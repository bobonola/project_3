package org.bank.banking;

import java.util.Map;

public interface BankService
{

	Map<String, Object> getUsers();

	//입력받은 데이터를 처리하는 함수
	Map<String, Object> operating( Map<String, Object> input );

}
