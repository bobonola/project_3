package org.bank.test;

import java.sql.Timestamp;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.bank.banking.BankService;
import org.bank.data.CardVO;
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

	@Autowired
	TestService testService;

	@RequestMapping( "" )
	public String timestampTest( Model m )
	{
		Map<String, Object> map = new HashMap<>();

		CardVO cvo = testService.getCard( "1910-0903-1946-0314" );

		Timestamp t = cvo.getEnd_date();

		map.put( "time", t );
		map.put( "timelong", t.getTime() );

		m.addAttribute( "map", map );
		return "/test/userTest.jsp";
	}

	@RequestMapping( "/connect" )
	public String connect( Model m, HttpServletRequest request )
	{
		Map<String, Object> input = new HashMap<>();

		input.put( "messageType", CommunicationMessage.connect );
		input.put( "mall_ID", "Joongang" );
		input.put( "pg_code", "-1" );

		Map<String, Object> map = bankService.operating( input, request );

		m.addAttribute( "map", map );
		return "/test/buy.jsp";
	}

	@RequestMapping( "/accountCheck" )
	public String accountCheck( Model m, HttpServletRequest request )
	{
		Map<String, Object> input = new HashMap<>();

		input.put( "messageType", CommunicationMessage.paymentWayCheck );
		input.put( "means", "account" );
		input.put( "payment_number", "1910-0903-1946-0314" );
		Map<String, Object> map = bankService.operating( input, request );
		m.addAttribute( "map", map );
		return "/test/buy.jsp";
	}

	@RequestMapping( "/accountPasswordCheck" )
	public String accountPasswordCheck( Model m, HttpServletRequest request )
	{
		Map<String, Object> input = new HashMap<>();

		input.put( "messageType", CommunicationMessage.passwordCheck );
		input.put( "means", "account" );
		input.put( "payment_number", "1910-0903-1946-0314" );
		input.put( "payment_password", "1946" );
		Map<String, Object> map = bankService.operating( input, request );
		m.addAttribute( "map", map );
		return "/test/buy.jsp";
	}

	@RequestMapping( "/paymentByAccount" )
	public String paymentByAccount( Model m, HttpServletRequest request )
	{
		Map<String, Object> input = new HashMap<>();

		input.put( "messageType", CommunicationMessage.payment );
		input.put( "means", "account" );
		input.put( "payment_number", "1910-0903-1946-0314" );
		input.put( "price", "19720" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input, request );
		m.addAttribute( "map", map );
		return "/test/buy.jsp";
	}

	@RequestMapping( "/cardCheck" )
	public String cardCheck( Model m, HttpServletRequest request )
	{
		Map<String, Object> input = new HashMap<>();

		input.put( "messageType", CommunicationMessage.paymentWayCheck );
		input.put( "means", "card" );
		input.put( "payment_number", "1946-0314-1971-0724" );
		input.put( "CVC", "010" );
		input.put( "end_year", "2026" );
		input.put( "end_month", "06" );
		Map<String, Object> map = bankService.operating( input, request );
		m.addAttribute( "map", map );
		return "/test/buy.jsp";
	}

	@RequestMapping( "/cardPasswordCheck" )
	public String cardPasswordCheck( Model m, HttpServletRequest request )
	{
		Map<String, Object> input = new HashMap<>();

		input.put( "messageType", CommunicationMessage.passwordCheck );
		input.put( "means", "card" );
		input.put( "payment_number", "1946-0314-1971-0724" );
		input.put( "payment_password", "tkghlwndmlskrdnjs" );
		Map<String, Object> map = bankService.operating( input, request );
		m.addAttribute( "map", map );
		return "/test/buy.jsp";
	}

	@RequestMapping( "/paymentByCard" )
	public String paymentByCard( Model m, HttpServletRequest request )
	{
		Map<String, Object> input = new HashMap<>();

		input.put( "messageType", CommunicationMessage.payment );
		input.put( "means", "card" );
		input.put( "payment_number", "1946-0314-1971-0724" );
		input.put( "price", "19720" );
		input.put( "mall_account_number", "1922-1944-1946-2014" );

		Map<String, Object> map = bankService.operating( input, request );
		m.addAttribute( "map", map );
		return "/test/buy.jsp";
	}
}
