package org.bank.banking;

import java.math.BigDecimal;
import java.util.*;


import org.bank.data.AccountVO;
import org.bank.data.CardVO;
import org.bank.data.CommunicationMessage;
import org.bank.data.LogVO;
import org.bank.data.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class BankServiceImpl implements BankService
{
	@Autowired
	private BankMapper mapper;

	// 트랜잭션 매니저
	@Autowired
	DataSourceTransactionManager transactionManager;

	

	@Override
	public Map<String, Object> operating( Map<String, Object> input )
	{
		Map<String, Object> result = null;
		String messageType = (String)input.get( "messageType" );

		// 메세지 유형 별 분기
		switch ( messageType )
		{
			case CommunicationMessage.connect:
				// 연결 처리
				result = this.connection( input );
				break;
			case CommunicationMessage.keySend:
				// 암호화를 위한 public 키 보내기
				result = this.keySend( input );
				break;
			case CommunicationMessage.dataSend:
				// 결제 요청 처리하기
				result = this.dataSend( input );
				break;
		}

		return result;
	}

	// ================================== private functions ====================================

	private Map<String, Object> connection( Map<String, Object> input )
	{
		Map<String, Object> result = new HashMap<>();
		Exception exception = null;
		String mall_ID = (String)input.get( "mall_ID" );

		UserVO mallInfo = mapper.getUser( mall_ID );

		try
		{
			if ( mallInfo == null )
			{
				exception = new Exception( "등록되지 않은 상점입니다." );
				throw exception;
			}
			result.put( "messageType", CommunicationMessage.connect );
		}
		catch( Exception e )
		{
			result.put( "messageType", CommunicationMessage.fail );
			result.put( CommunicationMessage.fail, e.getMessage() );
		}

		return result;
	}

	private Map<String, Object> keySend( Map<String, Object> input )
	{
		// String receivedKey = (String)input.get( "key" );
		// Decoder decoder = Base64.getDecoder();
		//
		// byte[] tempPubKey = decoder.decode( receivedKey );
		//
		// X509EncodedKeySpec keySpec = new X509EncodedKeySpec( tempPubKey );
		// KeyFactory kf = null;
		//
		// try
		// {
		// kf = KeyFactory.getInstance( "RSA" );
		// SecureKeys.pubKey = kf.generatePublic( keySpec );
		// }
		// catch( Exception e )
		// {
		// e.printStackTrace();
		// }
		//
		// KeyPair kp = null;
		//
		//
		// KeyPairGenerator kpg;
		// try
		// {
		// kpg = KeyPairGenerator.getInstance( "RSA" );
		// kpg.initialize( 512 );
		// kp = kpg.generateKeyPair();
		// }
		// catch( NoSuchAlgorithmException e )
		// {
		// // TODO 자동 생성된 catch 블록
		// e.printStackTrace();
		// }
		//
		// SecureKeys.privKey = kp.getPrivate();
		// PublicKey tempKey = kp.getPublic();
		//
		// Encoder encoder = Base64.getEncoder();
		// String key = encoder.encodeToString( tempKey.getEncoded() );

		Map<String, Object> result = new HashMap<>();
		result.put( "messageType", CommunicationMessage.keySend );
		result.put( "key", "Public Key" );

		return result;
	}

	@Transactional( rollbackFor = { Throwable.class, Error.class } )
	private Map<String, Object> dataSend( Map<String, Object> input )
	{

		Map<String, Object> result = null;
		String means = (String)input.get( "paymentMeans" ); // 결제수단
		String userID = (String)input.get( "userid" );
		UserVO userInfo = mapper.getUser( userID );
		if ( userInfo == null )
		{
			result = new HashMap<>();
			result.put( "messageType", CommunicationMessage.fail );
			result.put( CommunicationMessage.fail, "존재하지 않는 사람입니다." );
		}
		else
		{
			switch ( means ) // 결제 수단에 따른 분기
			{
				case "card":
					result = this.paymentByCard( input, userInfo );
					break;
				case "account":
					result = this.paymentByAccount( input, userInfo );
					break;
				case "card_check":
					// 카드 결제시
					result = this.paymentByCard_check( input, userInfo );
					break;
				case "account_check":
					// 계좌 결제시
					result = this.paymentByAccount_check( input, userInfo );
					break;
			}
		}
		return result;
	}

	// 계좌 결제 확인
	@Transactional( rollbackFor = { Throwable.class, Error.class } )
	private Map<String, Object> paymentByAccount_check( Map<String, Object> input, UserVO userInfo )
	{
		Map<String, Object> result = new HashMap<>();

		// 결제자의 계좌 정보 긁어오기
		String account_number = (String)input.get( "account_number" );
		AccountVO accountInfo = mapper.getAccount( account_number );

		if ( accountInfo == null ) // 계좌가 존재하지 않는다면?
		{
			result.put( "messageType", CommunicationMessage.fail );
			result.put( CommunicationMessage.fail, "계좌가 존재하지 않습니다." );

			return result;
		}

		String userPassword = userInfo.getPassword(); // 사용자 비밀번호
		String password = (String)input.get( "password" ); // 입력받은 비밀번호
		if ( password.equals( userPassword ) == false ) // 비밀번호 불일치
		{
			result.put( "messageType", CommunicationMessage.fail );
			result.put( CommunicationMessage.fail, "비밀번호가 일치하지 않습니다." );

			return result;
		}

		String mall_ID = (String)input.get( "mall_ID" ); // 업체 아이디
		UserVO mallInfo = mapper.getUser( mall_ID );
		if ( mallInfo == null )
		{
			result.put( "messageType", CommunicationMessage.fail );
			result.put( CommunicationMessage.fail, "등록되지 않은 업체입니다." );

			return result;
		}

		String mall_account_number = (String)input.get( "mall_account_number" ); // 업체 계좌

		BigDecimal balance = accountInfo.getBalance(); // 잔고
		Exception exception = null;
		String means = (String)input.get( "paymentMeans" ); // 결제수단

		// 트랜잭션 관리를 위한 객체들
		DefaultTransactionDefinition transactionDef = new DefaultTransactionDefinition();
		transactionDef.setPropagationBehavior( TransactionDefinition.PROPAGATION_REQUIRED );
		TransactionStatus transactionStat = transactionManager.getTransaction( transactionDef );

		// 작업 영역
		try
		{

			String tempPrice = input.get( "price" ).toString();
			BigDecimal price = new BigDecimal( tempPrice ); // 결제할 가격.

			if ( balance.compareTo( price ) < 0 ) // 잔액 부족
			{
				exception = new Exception( "잔액이 부족합니다." );
				throw exception;
			}

			result.put( "messageType", CommunicationMessage.success );

		}
		catch( Exception e ) // 오류 발생시 롤백
		{
			transactionManager.rollback( transactionStat );
			String ErrorMsg = e.getMessage();

			balance = mapper.getBalance( account_number );

			LogVO log = new LogVO( null, new BigDecimal( 0 ), balance, userPassword, means,
					account_number, mall_ID,  mall_account_number, ErrorMsg, null );

			mapper.logging( log );

			result.put( "messageType", CommunicationMessage.error );
			result.put( CommunicationMessage.error, ErrorMsg );
		}

		return result;
	}

	// 계좌 결제 실행
	@Transactional( rollbackFor = { Throwable.class, Error.class } )
	private synchronized Map<String, Object> paymentByAccount( Map<String, Object> input,
			UserVO userInfo )
	{
		Map<String, Object> result = new HashMap<>();
		BigDecimal balance = null;

		String account_number = (String)input.get( "account_number" ); // 계좌번호

		String mall_ID = (String)input.get( "mall_ID" ); // 업체 아이디
		String mall_account_number = (String)input.get( "mall_account_number" ); // 업체 계좌

		String tempPrice = (String)input.get( "price" );
		BigDecimal price = new BigDecimal( tempPrice ); // 가격
		String means = (String)input.get( "paymentMeans" ); // 결제수단

		// 트랜잭션 관리를 위한 객체들
		DefaultTransactionDefinition transactionDef = new DefaultTransactionDefinition();
		transactionDef.setPropagationBehavior( TransactionDefinition.PROPAGATION_REQUIRED );
		TransactionStatus transactionStat = transactionManager.getTransaction( transactionDef );

		mapper.payment( price, account_number );// 결제
		mapper.receive( price, mall_account_number ); // 금액 이전

		balance = mapper.getBalance( account_number );
		BigDecimal deposit = price.negate();

		LogVO log = new LogVO( null, deposit, balance, userInfo.getUserID(), means, account_number,
				mall_ID,  mall_account_number, "거래 성공", null );

		mapper.logging( log ); // 로그 기록

		transactionManager.commit( transactionStat );

		result.put( "messageType", CommunicationMessage.success );
		result.put( "balance", balance );

		return result;
	}

	// 카드 결제 확인
	@Transactional( rollbackFor = { Throwable.class, Error.class } )
	private Map<String, Object> paymentByCard_check( Map<String, Object> input, UserVO userInfo )
	{
		Map<String, Object> result = new HashMap<>();

		// 카드 정보 긁어오기
		String card_number = (String)input.get( "card_number" );
		CardVO cardInfo = mapper.getCard( card_number );

		// 카드번호가 없을 경우.
		if ( cardInfo == null )
		{
			result.put( "messageType", CommunicationMessage.fail );
			result.put( CommunicationMessage.fail, "카드가 존재하지 않습니다." );
			return result;
		}

		// 입력받은 비밀번호
		String transaction_password = (String)input.get( "transaction_password" );
		String userPassword = userInfo.getTransaction_password(); // 카드 비밀번호

		if ( transaction_password.equals( userPassword ) == false ) // 비밀번호 불일치
		{
			result.put( "messageType", CommunicationMessage.fail );
			result.put( CommunicationMessage.fail, "비밀번호가 일치하지 않습니다." );
			return result;
		}

		String cvs = (String)input.get( "CVS" ); // CVS 코드
		if ( cvs.equals( cardInfo.getCvs() ) == false ) // CVS 불일치
		{
			result.put( "messageType", CommunicationMessage.fail );
			result.put( CommunicationMessage.fail, "CVS가 일치하지 않습니다." );
			return result;
		}

		String mall_ID = (String)input.get( "mall_ID" ); // 업체 아이디
		UserVO mallInfo = mapper.getUser( mall_ID ); // 업체 정보
		if ( mallInfo == null )
		{
			result.put( "messageType", CommunicationMessage.fail );
			result.put( CommunicationMessage.fail, "비밀번호가 일치하지 않습니다." );

			return result;
		}

		String mall_account_number = (String)input.get( "mall_account_number" ); // 업체 계좌
		String means = (String)input.get( "paymentMeans" ); // 결제수단

		String account_number = cardInfo.getAccount_number();// 카드와 연결된 계좌번호
		BigDecimal balance = mapper.getBalance( account_number ); // 잔고
		Exception exception = null;
		String tempPrice = input.get( "price" ).toString();
		BigDecimal price = new BigDecimal( tempPrice ); // 가격

		// 트랜잭션 관리를 위한 객체들
		DefaultTransactionDefinition transactionDef = new DefaultTransactionDefinition();
		transactionDef.setPropagationBehavior( TransactionDefinition.PROPAGATION_REQUIRED );
		TransactionStatus transactionStat = transactionManager.getTransaction( transactionDef );

		try
		{

			if ( balance.compareTo( price ) < 0 )// 잔액이 부족할 때
			{
				exception = new Exception( "잔액이 부족합니다." );
				throw exception;
			}

			result.put( "messageType", CommunicationMessage.success );
			result.put( "balance", balance );

		}
		catch( Exception e ) // 오류 발생시 롤백
		{
			transactionManager.rollback( transactionStat );
			String errorMsg = e.getMessage();

			balance = mapper.getBalance( account_number );

			LogVO log = new LogVO( null, price, balance, userInfo.getUserID(), means, card_number,
					mall_ID, mall_account_number, errorMsg, null );
			mapper.logging( log );

			result.put( "messageType", CommunicationMessage.error );
			result.put( CommunicationMessage.error, errorMsg );
		}

		return result;
	}

	// 카드 결제 실행
	@Transactional( rollbackFor = { Throwable.class, Error.class } )
	private synchronized Map<String, Object> paymentByCard( Map<String, Object> input,
			UserVO userInfo )
	{
		Map<String, Object> result = new HashMap<>();

		// 가격 정보 조회
		String tempPrice = input.get( "price" ).toString();
		BigDecimal price = new BigDecimal( tempPrice );
		BigDecimal deposit=price.negate();

		// 사용자 정보 조회
		String card_number = (String)input.get( "card_number" );
		CardVO cardInfo = mapper.getCard( card_number );
		String account_number = cardInfo.getAccount_number();

		// 업체 계좌 정보 조회
		String mall_account_number = (String)input.get( "mall_account_number" );
		AccountVO mall_accountInfo = mapper.getAccount( mall_account_number );
		String mall_ID = mall_accountInfo.getUserID();

		// 결제 수단 조회
		String means = (String)input.get( "paymentMeans" );

		// 트랜잭션 관리를 위한 객체들
		DefaultTransactionDefinition transactionDef = new DefaultTransactionDefinition();
		transactionDef.setPropagationBehavior( TransactionDefinition.PROPAGATION_REQUIRED );
		TransactionStatus transactionStat = transactionManager.getTransaction( transactionDef );

		mapper.payment( price, account_number ); // 결제
		mapper.receive( price, mall_account_number ); // 이체

		BigDecimal balance = mapper.getBalance( account_number ); // 결제 후 잔액

		LogVO log = new LogVO( null, deposit, balance, userInfo.getUserID(), means, card_number,
				mall_ID,  mall_account_number, "거래 성공", null );

		mapper.logging( log ); // 로그 기록

		transactionManager.commit( transactionStat );
		

		result.put( "messageType", CommunicationMessage.success );
		result.put( "balance", balance );

		return result;
	}
}
