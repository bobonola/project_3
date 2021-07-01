package org.pg.process;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.pg.data.BankVO;
import org.pg.data.PG_Code;
import org.pg.data.PaymentWayVO;
import org.pg.email.EmailComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProcessController
{
	@Autowired
	ProcessService service;

	@Autowired
	EmailComponent emailComponent;

	// 로그인 페이지 띄우기
	@RequestMapping( "/login" )
	public String login()
	{
		return "/pg/login.jsp";
	}

	// 로그인 체크 결과 돌려주기
	@RequestMapping( "/loginCheck" )
	@ResponseBody
	public Map<String, Object> loginCheck( @RequestBody Map<String, Object> map,
			HttpSession session )
	{
		String id = map.get( "id" ).toString();
		String password = map.get( "pw" ).toString();
		Map<String, Object> result = service.loginCheck( id, password, session );

		return result;
	}

	// 가입 페이지 띄우기
	@RequestMapping( "/join" )
	public String join()
	{
		return "/pg/join.jsp";
	}

	// 이메일 중복 여부 확인하기
	@RequestMapping( "/joinCheck" )
	@ResponseBody
	public Map<String, Object> joinCheck( @RequestBody Map<String, Object> map,
			HttpSession session )
	{
		String email = (String)map.get( "email" );
		Map<String, Object> result = service.joinCheck( email );
		session.setAttribute( "email", result.get( "email" ) );
		return result;
	}

	@RequestMapping( "/codeGenerate" )
	public String codeGenerate( HttpSession session )
	{
		String email = (String)session.getAttribute( "email" );

		String code = service.getCertifyingCode( email );
		emailComponent.sendMail( email, "Payment's 인증 메일입니다.", code );
		service.inputCodeToDB( email, code );

		return "forward:/emailConfirm";
	}

	// 인증용 이메일 전송 및 페이지 넘기기
	@RequestMapping( "/emailConfirm" )
	public String emailConfirm()
	{

		return "/pg/join_email.jsp";
	}

	@RequestMapping( "/emailCheck" )
	@ResponseBody
	public Map<String, Object> emailCheck( @RequestBody Map<String, Object> input,
			HttpSession session )
	{
		Map<String, Object> result = service.emailCheck( input );

		return result;
	}

	@RequestMapping( "/join_profile" )
	public String join_profile()
	{
		return "/pg/join_profile.jsp";
	}

	// 정보 확인 및 가입 처리.
	@RequestMapping( "/joinProcess" )
	@ResponseBody
	public Map<String, Object> joinProcess( @RequestBody Map<String, Object> map,
			HttpSession session )
	{
		Map<String, Object> result = service.joinProcess( map, session );

		return result;
	}

	@RequestMapping( "/joinSuccess" )
	public String joinSuccess( HttpSession session )
	{
		session.invalidate();

		return "redirect:/login";
	}

	// 새로운 거래 수단 입력 페이지 띄우기
	@RequestMapping( "/newPaymentWay" )
	public String newPaymentWays(Model m)
	{
		List<BankVO> list=service.getBanks();
		m.addAttribute( "banks", list );
		m.addAttribute( "pg_code",PG_Code.value );
		return "/pg/join_paymethod.jsp";
	}

	@RequestMapping( "/newPaymentWayAdd" )
	public String newPaymentWayAdd( PaymentWayVO paymentInfo, Model m,
			@RequestParam( "year" ) String year, @RequestParam( "month" ) String month )
	{
		Map<String, Object> result = service.newPaymentWay( paymentInfo, year, month );
		m.addAttribute( "map", result );
		return "";
	}

	@RequestMapping( "/payment" )
	public ModelAndView payment( HttpSession session )
	{
		ModelAndView mav = new ModelAndView( "/pg/payment.jsp" );

		String id = (String)session.getAttribute( "id" );
		Map<String, Object> map = service.getPaymentInfos( id );
		mav.addObject( "map", map );

		return mav;
	}
}
