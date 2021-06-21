package com.site.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.service.QnaService;

@Controller
public class QnaController {

	@Autowired
	QnaService qnaService;
	
	@RequestMapping("/qnaList")
	public String qnaList(@RequestParam(value="page", defaultValue = "1")int page,
			@RequestParam @Nullable String category,
			@RequestParam @Nullable String search,
			Model model) {
		
		Map<String, Object> map = null;
		
		if(category == null || category == "" || search == null || search == "") {
			map = qnaService.qnaList(page);
		} else {
			map = qnaService.qnaListSearch(page, category, search);
		}
		
		model.addAttribute("map", map);
		
		return "/qnaList";
	}
	
}
