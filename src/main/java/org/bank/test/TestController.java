package org.bank.test;

import java.util.*;

import org.bank.banking.BankService;
import org.bank.data.CommunicationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/test" )
public class TestController
{


	@Autowired
	BankService bankService;



	@RequestMapping( "/getuser" )
	public String userTest( Model m )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "message", CommunicationMessage.dataSend );
		input.put( "paymentMeans", "account" );
		input.put( "userid", "simyoung" );
		input.put( "account_number", "1910-0903-1946-0314" );

		Map<String, Object> map = bankService.operating( input );

		m.addAttribute( "map", map );
		return "/test/userTest.jsp";
	}

	@RequestMapping( "/accountbuy" )
	public String account( Model m )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "message", CommunicationMessage.dataSend );
		input.put( "paymentMeans", "account_check" );

		input.put( "userid", "simyoung" );
		input.put( "account_number", "1910-0903-1946-0314" );
		input.put( "password", "1946" );

		input.put( "price", "19720" );
		input.put( "mall_ID", "Joongang" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input );

		m.addAttribute( "map", map );

		return "/test/buy.jsp";
	}

	@RequestMapping( "/accountbuy/execute" )
	public String account_execute( Model m )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "message", CommunicationMessage.dataSend );
		input.put( "paymentMeans", "account" );

		input.put( "userid", "simyoung" );
		input.put( "account_number", "1910-0903-1946-0314" );
		input.put( "password", "1946" );

		input.put( "price", "19720" );
		input.put( "mall_ID", "Joongang" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input );

		m.addAttribute( "map", map );

		return "/test/buy.jsp";
	}

	@RequestMapping( "/accountbuy/wrong/account_number" )
	public String account_wrong_account_number( Model m )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "message", CommunicationMessage.dataSend );
		input.put( "paymentMeans", "account_check" );

		input.put( "userid", "simyoung" );
		input.put( "account_number", "1910-0903-1946-0315" );
		input.put( "password", "1946" );

		input.put( "price", "19720" );
		input.put( "mall_ID", "Joongang" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input );

		m.addAttribute( "map", map );

		return "/test/buy.jsp";
	}

	@RequestMapping( "/accountbuy/wrong/userid" )
	public String account_wrong_userid( Model m )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "message", CommunicationMessage.dataSend );
		input.put( "paymentMeans", "account_check" );

		input.put( "userid", "simyong" );
		input.put( "account_number", "1910-0903-1946-0314" );
		input.put( "password", "1946" );

		input.put( "price", "19720" );
		input.put( "mall_ID", "Joongang" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input );

		m.addAttribute( "map", map );

		return "/test/buy.jsp";
	}

	@RequestMapping( "/accountbuy/wrong/password" )
	public String account_wrong_password( Model m )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "message", CommunicationMessage.dataSend );
		input.put( "paymentMeans", "account_check" );

		input.put( "userid", "simyoung" );
		input.put( "account_number", "1910-0903-1946-0314" );
		input.put( "password", "1972" );

		input.put( "price", "19720" );
		input.put( "mall_ID", "Joongang" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input );

		m.addAttribute( "map", map );

		return "/test/buy.jsp";
	}

	@RequestMapping( "/accountbuy/wrong/mall" )
	public String account_wrong_mall( Model m )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "message", CommunicationMessage.dataSend );
		input.put( "paymentMeans", "account_check" );

		input.put( "userid", "simyoung" );
		input.put( "account_number", "1910-0903-1946-0314" );
		input.put( "password", "1946" );

		input.put( "price", "19720" );
		input.put( "mall_ID", "Joongan" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input );

		m.addAttribute( "map", map );

		return "/test/buy.jsp";
	}

	@RequestMapping( "/cardbuy" )
	public String card( Model m )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "message", CommunicationMessage.dataSend );
		input.put( "paymentMeans", "card_check" );

		input.put( "userid", "simyoung" );
		input.put( "card_number", "1910-0903-1946-0314" );
		input.put( "transaction_password", "tkghlwndmlskrdnjs" );
		input.put( "CVS", "010" );
		input.put( "price", "19720" );
		input.put( "mall_ID", "Joongang" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input );
		m.addAttribute( "map", map );
		return "/test/buy.jsp";
	}
	
	@RequestMapping( "/cardbuy/execute" )
	public String card_execute( Model m )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "message", CommunicationMessage.dataSend );
		input.put( "paymentMeans", "card" );

		input.put( "userid", "simyoung" );
		input.put( "card_number", "1910-0903-1946-0314" );
		input.put( "transaction_password", "tkghlwndmlskrdnjs" );
		input.put( "CVS", "010" );
		input.put( "price", "19720" );
		input.put( "mall_ID", "Joongang" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input );
		m.addAttribute( "map", map );
		return "/test/buy.jsp";
	}
	
	@RequestMapping( "/cardbuy/wrong/cardnumber" )
	public String card_wrong_cardnumber( Model m )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "message", CommunicationMessage.dataSend );
		input.put( "paymentMeans", "card_check" );

		input.put( "userid", "simyoung" );
		input.put( "card_number", "1910-0903-1946-0315" );
		input.put( "transaction_password", "tkghlwndmlskrdnjs" );
		input.put( "CVS", "010" );
		input.put( "price", "19720" );
		input.put( "mall_ID", "Joongang" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input );
		m.addAttribute( "map", map );
		return "/test/buy.jsp";
	}
	
	@RequestMapping( "/cardbuy/wrong/password" )
	public String card_wrong_password( Model m )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "message", CommunicationMessage.dataSend );
		input.put( "paymentMeans", "card_check" );

		input.put( "userid", "simyoung" );
		input.put( "card_number", "1910-0903-1946-0314" );
		input.put( "transaction_password", "tkdwq" );
		input.put( "CVS", "010" );
		input.put( "price", "19720" );
		input.put( "mall_ID", "Joongang" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input );
		m.addAttribute( "map", map );
		return "/test/buy.jsp";
	}
	
	@RequestMapping( "/cardbuy/wrong/cvs" )
	public String card_wrong_cvs( Model m )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "message", CommunicationMessage.dataSend );
		input.put( "paymentMeans", "card_check" );

		input.put( "userid", "simyoung" );
		input.put( "card_number", "1910-0903-1946-0314" );
		input.put( "transaction_password", "tkghlwndmlskrdnjs" );
		input.put( "CVS", "070" );
		input.put( "price", "19720" );
		input.put( "mall_ID", "Joongang" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input );
		m.addAttribute( "map", map );
		return "/test/buy.jsp";
	}
}
