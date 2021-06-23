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
import com.site.vo.ReviewVo;

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

	//리뷰 글쓰기 저장
	@Override
	public void rewriteInsert(ReviewVo reviewVo, MultipartFile file) {
		
		//파일저장위치
		String fileUrl = "C:/Users/user/eclipse-workspace/shop1/src/main/resources/static/upload/";
		
		// 파일이름 중복방지를 위한 파일명 변경
		long time = System.currentTimeMillis(); // 숫자형태로 시간을 표현해줘요. return타입이 long임
		String uploadFileName = time + "_" + file.getOriginalFilename(); // 파일이름 -> 시간_파일이름으로 나옴
		
		// 파일저장 - io를 import해서 자동으로 디렉토리 없으면 만들어서 저장시킴
		File f = new File(fileUrl + uploadFileName);
		System.out.println("DB저장 전 uploadFileName : " + uploadFileName);

		//파일전송 - 예외처리 필요, 에러나서 다운될까봐, 예외처리는 마음대로 불가능, 피치못할 사정으로 생긴 에러만 예외처리할것.
		 
		try {
			file.transferTo(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 파일이름을 VO에 저장
		reviewVo.setReview_image(uploadFileName);

		// DB저장
		productMapper.insertProductRewrite(reviewVo);

		System.out.println("DB저장 후 uploadFileName : " + reviewVo.getEmail());
		
	}

	
}
