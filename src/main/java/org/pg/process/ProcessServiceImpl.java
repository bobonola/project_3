package org.pg.process;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.pg.data.BankVO;
import org.pg.data.CertifyVO;
import org.pg.data.CommunicationMessage;
import org.pg.data.PGException;
import org.pg.data.PG_Code;
import org.pg.data.PaymentWayVO;
import org.pg.data.URLs;
import org.pg.data.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class ProcessServiceImpl implements ProcessService
{
	@Autowired
	ProcessMapper mapper;

	// 트랜잭션 매니저
	@Autowired
	DataSourceTransactionManager transactionManager;



	@Override
	public Map<String, Object> loginCheck( String id, String password, HttpSession session )
	{
		Map<String, Object> result = new HashMap<>();
		boolean login = false;
		UserVO userInfo = null;

		try
		{
			if ( id.equals( "" ) || password.equals( "" ) )
			{
				throw new PGException( "id와 비밀번호가 입력되지 않았습니다." );
			}

			userInfo = mapper.getUser( id );
			if ( userInfo == null )
			{
				throw new PGException( "존재하지 않는 회원입니다." );
			}

			String userID = userInfo.getUserID();
			String userPassword = userInfo.getPassword();

			boolean idEqual = id.equals( userID );
			boolean pwEqual = password.equals( userPassword );

			if ( idEqual && pwEqual )
			{
				login = true;
				session.setAttribute( "id", id );
			}
			else
			{
				throw new PGException( "아이디와 비밀번호가 일치하지 않습니다." );
			}

		}
		catch( PGException e )
		{
			result.put( "message", e.getMessage() );
		}
		catch( Exception e )
		{
			result.put( "message", "예상치 못한 에러가 발생했습니다: " + e.getMessage() );
			e.printStackTrace();
		}

		result.put( "check", login );
		return result;
	}

	// 이메일 중복 여부 점검
	@Override
	public Map<String, Object> joinCheck( String email )
	{
		Map<String, Object> result = new HashMap<>();

		if ( email.equals( "" ) )
		{
			result.put( "check", false );
			result.put( "message", "아이디를 입력하세요" );
			return result;
		}

		UserVO userInfo = mapper.getUserByEmail( email );

		if ( userInfo != null )
		{
			result.put( "check", false );
			result.put( "message", "이미 존재하는 이메일입니다." );
		}
		else
		{
			result.put( "email", email );
			result.put( "check", true );

		}

		return result;
	}

	// 인증 코드 생성
	@Override
	public String getCertifyingCode( String email )
	{

		SecureRandom random = new SecureRandom();
		int length = 8;
		StringBuffer tempCode = new StringBuffer( "" );

		for( int i = 0 ; i < length ; i++ )
		{
			char c = (char)(random.nextInt( 58 ) + 65);
			tempCode.append( c );
		}
		String code = tempCode.toString();
		return code;
	}

	// 인증 코드를 DB에 등록.
	@Override
	@Transactional
	public void inputCodeToDB( String email, String code )
	{
		// 트랜잭션 관리를 위한 객체들
		DefaultTransactionDefinition transactionDef = new DefaultTransactionDefinition();
		transactionDef.setPropagationBehavior( TransactionDefinition.PROPAGATION_REQUIRED );
		TransactionStatus transactionStat = transactionManager
				.getTransaction( transactionDef );

		try
		{
			mapper.deleteCertifyingCode( email );
			mapper.joinCodeGeneration( email, code );

			transactionManager.commit( transactionStat );
		}
		catch( Exception e )
		{
			e.printStackTrace();
			transactionManager.rollback( transactionStat );
		}
	}

	// 입력받은 코드를 대조
	@Override
	public Map<String, Object> emailCheck( Map<String, Object> input )
	{
		Map<String, Object> result = new HashMap<>();

		String email = (String)input.get( "email" );
		String code = (String)input.get( "code" );

		CertifyVO codeInfo = mapper.getCertify( email );
		String existedCode = codeInfo.getCode();

		boolean equal = code.equals( existedCode );
		if ( equal == false )
		{
			result.put( "check", false );
			result.put( "message", "코드가 일치하지 않습니다. 다시 확인하세요." );
		}
		else
		{
			result.put( "check", true );
			mapper.deleteCertifyingCode( email );
		}

		return result;
	}

	// 가입을 위해 입력한 정보들을 검증
	@Override
	public Map<String, Object> joinProcess( Map<String,Object> map,
			HttpSession session )
	{
		Map<String, Object> result = new HashMap<>();

		try
		{
			String id = (String)map.get( "userID" );

			// 아이디 입력 체크
			if ( id == null || id.equals( "" ) )
			{
				throw new PGException( "아이디가 입력되지 않았습니다." );
			}

			// id 중복 확인
			UserVO existedID = mapper.getUser( id );
			if ( existedID != null )
			{
				throw new PGException( "이미 사용중인 아이디입니다." );
			}

			// 비밀번호 체크
			String password = (String)map.get( "password" );
			String password_confirm = (String)map.get( "password_confirm" );
			if ( password == null || password.equals( "" ) )
			{
				throw new PGException( "비밀번호가 입력되지 않았습니다." );
			}
			if ( password.equals( password_confirm ) == false )
			{
				System.out.println( "password: " + password );
				System.out.println( "passwordConfirm: " + password_confirm );
				throw new PGException( "비밀번호가 일치하지 않습니다." );
			}

			// 이름 체크
			String name =(String)map.get( "name" );
			if ( name == null || name.equals( "" ) )
			{
				throw new PGException( "이름이 입력되지 않았습니다." );
			}

			// 전화번호 체크
			String phone_number = (String)map.get( "phone_number" );
			if ( phone_number == null || phone_number.equals( "" ) )
			{
				throw new PGException( "전화번호가 입력되지 않았습니다." );
			}

			result.put( "check", true );
			session.setAttribute( "id", id );
			
			String email=(String)map.get( "email" );
			mapper.insertNewUser(id,password,email,name,phone_number);
		}
		catch( PGException e )
		{
			result.put( "check", false );
			result.put( "message", e.getMessage() );
		}

		return result;
	}
	

	@Override
	public List<BankVO> getBanks()
	{
		List<BankVO> result=mapper.getBanks();
		return result;
	}


	@Override
	public Map<String, Object> newPaymentWay( PaymentWayVO paymentInfo, String year,
			String month )
	{
		Map<String, Object> result = new HashMap<>();

		String bank_code = paymentInfo.getBank_code();
		String means = paymentInfo.getMeans();
		String payment_number = paymentInfo.getPayment_number();

		result.put( "means", means );
		result.put( "payment_number", payment_number );
		result.put( "PG_code", PG_Code.value );

		// String payment_password = paymentInfo.getPayment_password();
		// result.put( "payment_password", payment_password );

		if ( means.equals( "card" ) )
		{
			String cvc = paymentInfo.getCvc();

			result.put( "CVC", cvc );
			result.put( "end_year", year );
			result.put( "end_month", month );
		}

		switch ( bank_code )
		{
			case "":
				result.put( "url", URLs.bankA );
				break;
		}

		result.put( "messageType", CommunicationMessage.paymentWayCheck );

		return result;
	}

	@Override
	public Map<String, Object> getPaymentInfos( String id )
	{
		Map<String, Object> result=new HashMap<>();
		
		List<PaymentWayVO> paymentways=mapper.getPaymentWays(id);
		
		result.put( "paymentways", paymentways );
		
		return result;
	}

}
