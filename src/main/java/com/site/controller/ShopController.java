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
public class ShopController {
	
	@GetMapping("/shop/payment_shop")
	public String payment_shop() {
		return "/shop/payment_shop";
	}
	
	@GetMapping("/shop/shopping_success")
	public String shopping_success() {
		return "/shop/shopping_success";
	}
	
	@GetMapping("/email_form")
	public String email_form() {
		return "/email_form";
	}
	
	
	
	
	

}
