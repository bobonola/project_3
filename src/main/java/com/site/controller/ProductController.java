package com.site.controller;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.site.service.CartService;
import com.site.service.ProductService;
import com.site.service.ReviewService;
import com.site.vo.CartVo;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	ReviewService reviewService;
	
	@Autowired
	CartService cartService;
	
	// 메인페이지 호출
	@RequestMapping("/index")		
	public String index(@RequestParam(value="page", defaultValue="1")int page,
			@RequestParam @Nullable String sort,
			@RequestParam @Nullable String search,
			Model model) {
		Map<String, Object> map = null;
		System.out.println("sort ========= " +sort);
		
		if(search == null || search == "") {
			map = productService.productList(page, sort);		// 전체리스트 가져오기
		} else {
			map = productService.productListSearch(page, sort, search);		// 검색리스트 가져오기
		}
		
		model.addAttribute("map",map);
		
		return "/index";
	}
	
	// 상세뷰페이지 호출
	@RequestMapping("/view")		
	public String detail(@RequestParam("product_no")int product_no, 
			@RequestParam(value="page", defaultValue="1")int page,
			Model model) {
		Map<String, Object> map = productService.productView(product_no);	
		
		// 상품 정보 호출
		model.addAttribute("map", map);
		
		// 리뷰 정보 받아오기
		Map<String, Object> review_map = reviewService.reviewList(page, product_no);
		model.addAttribute("review_map", review_map);
		
		return "/view";
	}
	
	// 장바구니 저장
	@RequestMapping("/cart/cartInsert")
	public String cartInsert(CartVo cartVo) {
		System.out.println("cartVo : " + cartVo);
		
		cartService.cartInsert(cartVo);
		
		return "redirect:/cart/cartList";
	}
	
	
	
}
