package com.site.service;

import java.util.Map;

import com.site.vo.CartVo;

public interface CartService {

	// 장바구니 리스트 호출
	Map<String, Object> cartList();
	// 장바구니 삭제
	void cartDelete(int product_no);
	// 장바구니 전체삭제
	void cartAllDelete();

	//장바구니 물건 추가
	void cartInsert(CartVo cartVo);


}
