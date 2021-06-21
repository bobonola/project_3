package com.site.service;

import java.util.Map;

public interface ProductService {

	// 전체리스트 호출
	Map<String, Object> productList(int page, String sort);
	// 검색리스트 호출
	Map<String, Object> productListSearch(int page, String sort, String search);
	// 상세뷰페이지 호출
	Map<String, Object> productView(int product_no);

}
