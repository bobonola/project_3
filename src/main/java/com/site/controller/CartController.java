package com.site.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@RequestMapping("/cartList")
	public String cartList(Model model) {
		Map<String, Object> map = null;
		
		map = cartService.cartList();
		model.addAttribute("map", map);
		
		return "/cart/cartList";
	}
	
	@RequestMapping("/cartDelete")
	public String cartDelete(@RequestParam("product_no")int product_no) {
		cartService.cartDelete(product_no);
		return "redirect:/cart/cartList";
	}
	
	@RequestMapping("/cartAllDelete")
	public String cartAllDelete() {
		cartService.cartAllDelete();
		return "redirect:/cart/cartList";
	}
	
	
}
