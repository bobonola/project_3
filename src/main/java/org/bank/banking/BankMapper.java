package org.bank.banking;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.bank.data.AccountVO;
import org.bank.data.CardVO;
import org.bank.data.LogVO;
import org.bank.data.UserVO;

@Mapper
public interface BankMapper
{


	UserVO getUser( String userID );

	BigDecimal getBalance( String account_number );

	void payment( BigDecimal price, String account_number );

	void receive( BigDecimal price, String mall_account_number );

	void logging( LogVO lvo );

	AccountVO getAccount( String card_number );

	CardVO getCard( String card_number );

}
