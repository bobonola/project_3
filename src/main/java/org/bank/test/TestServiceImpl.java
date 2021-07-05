package org.bank.test;

import org.bank.banking.BankMapper;
import org.bank.data.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService
{
	@Autowired
	BankMapper bankMapper;
	
	public CardVO getCard( String card_number )
	{
		CardVO cvo=bankMapper.getCard( card_number );
		
		return cvo;
	}
}
