package com.site.service;

import java.util.Map;

public interface CartService {

	// 장바구니 리스트 호출
	Map<String, Object> cartList();
	// 장바구니 삭제
	void cartDelete(int product_no);
	// 장바구니 전체삭제
	void cartAllDelete();

}
