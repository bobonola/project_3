package com.site.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.mapper.CartMapper;
import com.site.mapper.ProductMapper;
import com.site.vo.CartVo;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartMapper cartMapper;
	
	@Autowired
	ProductMapper productMapper;
	
	@Override		// 장바구니 리스트
	public Map<String, Object> cartList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVo> list = cartMapper.selectCartList();
		
		for(CartVo cvo:list) {
			System.out.println("=========================="+cvo);
		}
		
		map.put("list", list);
		
		return map;
	}

	@Override		// 장바구니 선택 삭제
	public void cartDelete(int product_no) {
		cartMapper.deleteCartDelete(product_no);
	}

	@Override		// 장바구니 전체 삭제
	public void cartAllDelete() {
		cartMapper.deleteCartAllDelete();
	}
	
	//장바구니 물건 추가
	@Override
	public void cartInsert(CartVo cartVo) {
		cartMapper.cartInsertDo(cartVo);
			
	}


}
