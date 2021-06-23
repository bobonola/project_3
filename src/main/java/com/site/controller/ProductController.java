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

import com.site.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
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
	public String detail(@RequestParam("product_no")int product_no, Model model) {
		Map<String, Object> map = productService.productView(product_no);	
		model.addAttribute("map", map);
		return "/view";
	}
	
	
	
	
}
