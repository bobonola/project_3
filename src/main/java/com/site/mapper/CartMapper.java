package com.site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.vo.CartVo;

@Mapper
public interface CartMapper {

	// 장바구니 리스트 호출
	List<CartVo> selectCartList();
	// 장바구니 삭제
	void deleteCartDelete(int product_no);
	// 장바구니 전체삭제
	void deleteCartAllDelete();

}
