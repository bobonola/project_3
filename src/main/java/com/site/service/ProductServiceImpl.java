package com.site.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.site.mapper.ProductMapper;
import com.site.vo.ProductVo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;
	
	@Override		// 전체리스트 호출
	public Map<String, Object> productList(int page, String sort) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int limit = 10;
		
		int startRow = (page - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		System.out.println("sort: "+sort);
		List<ProductVo> list = productMapper.selectProductList(startRow, endRow, sort);

		int listCount = 0;	// 총 상품 수
		listCount = productMapper.selectProductCount();
		
		for (ProductVo productVo : list) {
//			System.out.println("productVo.getProduct_no() : " + productVo.getProductNo());
			System.out.println(productVo);
		}
		
		//하단 최대 넘버링페이지 
		int maxPage = (int)((double)listCount / limit + 0.99); 
		//하단 시작 넘버링페이지
		int startPage = (((int) ((double)page / 10 + 0.99)) - 1) * 10 + 1;
		//하단 끝 넘버링페이지
		int endPage = maxPage;
		// 1,2,3,4,5,6,7,8,9,10 -> 10개가 모두 있을 경우는 10을 endPage에 넣어줌.
		if (endPage>startPage + 10 - 1) {
			endPage=startPage + 10 - 1;
		}

		// page는 현재페이지를 의미
		map.put("list", list);
		map.put("page", page);
		map.put("listCount", listCount);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("maxPage", maxPage);
		map.put("sort", sort);
		
		return map;
	}

	@Override		// 검색리스트 호출
	public Map<String, Object> productListSearch(int page, String sort, String search) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<ProductVo> list = null;
		int limit = 10;
		
		int startRow = (page - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println("impl search : " + search);
		
		int listCount = 0;
		list = productMapper.selectProductListSearch(startRow, endRow, sort, search);
		listCount = productMapper.selectProductSearchCount(search);
		
		System.out.println("listCount : " + listCount);
		
		int maxPage = (int)((double) listCount / limit + 0.99);
		int startPage = (((int) ((double) page / 10 + 0.99)) - 1) * 10 + 1;
		int endPage = maxPage;
		if(endPage > startPage + 10 - 1) {
			endPage = startPage + 10 - 1;
		}
		
		map.put("list", list);
		map.put("page", page);
		map.put("listCount", listCount);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("maxPage", maxPage);
		map.put("sort", sort);
		map.put("search", search);
		
		return map;
	}

	@Override		// 상세뷰페이지 호출
	public Map<String, Object> productView(int product_no) {
		Map<String, Object> map = new HashMap<String, Object>();
		ProductVo productVo = productMapper.selectProductView(product_no);
		map.put("productVo", productVo);
		
		return map;
	}

	
	
}
