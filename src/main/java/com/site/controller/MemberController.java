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
	
	@GetMapping("/join/join")
	public String join() {
		return "/join/join";
	}
	
	@GetMapping("/join/join_email")
	public String join_email() {
		return "/join/join_email";
	}
	
	
	@GetMapping("/join/join_profile")
	public String join_profile() {
		return "/join/join_profile";
	}
	
	@GetMapping("/join/join_paymethod")
	public String join_paymethod() {
		return "/join/join_paymethod";
	}
	
	@GetMapping("/join/join_paymethod_card")
	public String join_paymethod_card() {
		return "/join/join_paymethod_card";
	}
	
	@GetMapping("/join/join_paymethod_account")
	public String join_paymethod_account() {
		return "/join/join_paymethod_account";
	}
	
	@GetMapping("/join/join_success")
	public String join_success() {
		return "/join/join_success";
	}
	
	@GetMapping("/pg/detail")
	public String detail() {
		return "/pg/detail";
	}
	
	@GetMapping("/pg/detailtest")
	public String detailtest() {
		return "/pg/detailtest";
	}
	
	
	

}
