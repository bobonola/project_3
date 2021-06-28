package com.site.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.service.CartService;
import com.site.vo.CartVo;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@RequestMapping("/cart/cartList")		// 장바구니 리스트
	public String cartList(Model model) {
		Map<String, Object> map = null;
		
		map = cartService.cartList();
		model.addAttribute("map", map);
		
		return "/cart/cartList";
	}
	
	@RequestMapping("/cart/cartDelete")		// 장바구니 선택 삭제
	public String cartDelete(@RequestParam("cart_no")int cart_no) {
		cartService.cartDelete(cart_no);
		return "redirect:/cart/cartList";
	}
	
	@RequestMapping("/cart/cartAllDelete")	// 장바구니 전체 삭제
	public String cartAllDelete() {
		cartService.cartAllDelete();
		return "redirect:/cart/cartList";
	}
	
	@RequestMapping("/pay/payment")			// 결제창 리스트
	public String payment(Model model) {
		Map<String, Object> map = null;
		
		map = cartService.cartList();
		model.addAttribute("map", map);
		return "/pay/payment";
	}
	
	
}
