package com.site.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/pg/login")
	public String login1() {
		return "/pg/login";
	}
	
	@GetMapping("/pg/payment")
	public String payment() {
		return "/pg/payment";
	}
	
	@GetMapping("/pg/join")
	public String join() {
		return "/pg/join";
	}
	
	@GetMapping("/pg/join_email")
	public String join_email() {
		return "/pg/join_email";
	}
	
	@GetMapping("/pg/join_profile")
	public String join_profile() {
		return "/pg/join_profile";
	}
	
	@GetMapping("/pg/join_paymethod")
	public String join_paymethod() {
		return "/pg/join_paymethod";
	}
	
	@GetMapping("/pg/detail")
	public String detail() {
		return "/pg/detail";
	}
	
	@GetMapping("/pg/detailtest")
	public String detailtest() {
		return "/pg/detailtest";
	}
	
//	@RequestMapping(value="/login_ajax")
//	@ResponseBody
//	public Map<String,Object> login_ajax(testVo testVo,HttpServletRequest request,Model model) {
//		
//		Map<String,Object> map=new HashMap<String, Object>();
//		testVo mVo = memberService.login(testVo); //전체리스트 가져오기
//		map.put("mVo",mVo);
//		if(mVo==null) {
//			map.put("flag", "fail");
//			map.put("msg", "아이디와 패스워드가 일치하지 않습니다.");
//		}else {
//			map.put("flag", "success");
//			map.put("msg", "로그인 성공!");
//			HttpSession session = request.getSession();
//			session.setAttribute("session_flag","success");
//			session.setAttribute("session_id", mVo.getUser_id());
//			session.setAttribute("first_name", mVo.getFirst_name());
//		}
//		return map;
//	}
	
	
	
	

}
