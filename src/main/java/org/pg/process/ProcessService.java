package org.pg.process;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.pg.data.BankVO;
import org.pg.data.PaymentWayVO;

public interface ProcessService
{

	//로그인 체크
	Map<String, Object> loginCheck( String id, String password,HttpSession session );

	//id 중복여부 체크
	Map<String,Object> joinCheck( String email );

	//정보 검증 및 가입 처리.
	Map<String, Object> joinProcess( Map<String,Object> map, HttpSession session );

	// 새로운 거래 수단 등록.
	Map<String, Object> newPaymentWay( PaymentWayVO paymentInfo, String year, String month );


	String getCertifyingCode( String email );
	
	void inputCodeToDB(String email, String code);

	Map<String, Object> emailCheck( Map<String, Object> input );

	Map<String, Object> getPaymentInfos( String id );

	List<BankVO> getBanks();


}
