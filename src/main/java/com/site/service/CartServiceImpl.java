package com.site.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.mapper.CartMapper;
import com.site.vo.CartVo;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartMapper cartMapper;
	
	@Override
	public Map<String, Object> cartList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVo> list = cartMapper.selectCartList();
		
		for(CartVo cvo:list) {
			System.out.println("=========================="+cvo);
		}
		
		map.put("list", list);
		
		return map;
	}

	@Override
	public void cartDelete(int product_no) {
		cartMapper.deleteCartDelete(product_no);
	}

	@Override
	public void cartAllDelete() {
		cartMapper.deleteCartAllDelete();
	}

}
