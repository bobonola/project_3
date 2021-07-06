package org.pg.test;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.pg.data.CommunicationMessage;
import org.pg.data.UserVO;
import org.pg.process.ProcessService;
import org.pg.receive.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/test" )
public class TestController
{
	@Autowired
	TestService service;
	
	@Autowired
	ReceiveService receiveService;

	@Autowired
	ProcessService processService;

	@RequestMapping( "/nullCheck" )
	public String testPage( Model m )
	{
		boolean bool=service.nullCheck();
		m.addAttribute( "map", bool );
		return "/test/test.jsp";
	}

	@RequestMapping( "/connect" )
	public ModelAndView connect( HttpSession session )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "mall_code", "19721121" );
		Map<String, Object> result = receiveService.connectionCheck( input );

		String message = (String)result.get( "messageType" );

		if ( message.equals( CommunicationMessage.connect ) )
		{
			session.setAttribute( "mall_code", input.get( "mall_code" ) );
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject( "map", result );
		mav.setViewName( "/test/test.jsp" );
		return mav;
	}

	@RequestMapping( "/connect/wrong/mall_code" )
	public ModelAndView connect_wrong_mall_code( HttpSession session )
	{
		Map<String, Object> input = new HashMap<>();
		input.put( "mall_code", "19460314" );
		Map<String, Object> result = receiveService.connectionCheck( input );

		ModelAndView mav = new ModelAndView();
		mav.addObject( "map", result );
		mav.setViewName( "/test/test.jsp" );
		return mav;
	}

	@RequestMapping( "/disconnect" )
	public ModelAndView disconnect( HttpSession session )
	{
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName( "/test/test.jsp" );

		return mav;
	}

	@RequestMapping( "/login" )
	public ModelAndView login( HttpSession session )
	{
		ModelAndView mav = new ModelAndView();

		Map<String, Object> map = processService.loginCheck( "kimdoohan", "rothflwlqdjcu",
				session );

		mav.addObject( "map", map );
		mav.setViewName( "/test/test.jsp" );

		return mav;
	}

	@RequestMapping( "/login/wrong/id" )
	public ModelAndView login_wrong_id( HttpSession session )
	{
		ModelAndView mav = new ModelAndView();

		Map<String, Object> map = processService.loginCheck( "kimdohan", "rothflwlqdjcu", session );

		mav.addObject( "map", map );
		mav.setViewName( "/test/test.jsp" );

		return mav;
	}

	@RequestMapping( "/login/wrong/pw" )
	public ModelAndView login_wrong_password( HttpSession session )
	{
		ModelAndView mav = new ModelAndView();

		Map<String, Object> map = processService.loginCheck( "kimdoohan", "rofhflwlqdjcu",
				session );

		mav.addObject( "map", map );
		mav.setViewName( "/test/test.jsp" );

		return mav;
	}

	@RequestMapping( "/join" )
	public ModelAndView join(HttpSession session)
	{
		ModelAndView mav=new ModelAndView();

		Map<String,Object> input=new HashMap<>();
//		input.put( "id", "simyoung" );
//		input.put( "password", "wjsdnleo" );
//		input.put( "email", "eunuch@communism.com" );
//		input.put( "password_confirm", "wjsdnleo" );
//		input.put( "phone_number", "010-1946-0314" );
//		input.put( "name", "심영"  );
		
		
		Map<String,Object> map=processService.joinProcess( input, session );
		
		mav.addObject( "map", map );
		mav.setViewName( "/test/test.jsp" );
		
		return mav;
	}
}
