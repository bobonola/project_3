package com.site.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.site.vo.ReviewVo;

public interface ReviewService {
	
	// 리뷰 글쓰기 저장
	void rewriteInsert(ReviewVo reviewVo, MultipartFile file);
	
	//리뷰 리스트 불러오기
	Map<String, Object> reviewList(int page, int product_no);

	//리뷰 수정페이지 호출
	ReviewVo reviewModify(int review_no);

	//리뷰 수정 저장
	void reviewModifyDo(ReviewVo reviewVo);

	//리뷰삭제
	void reviewDelete(int review_no);

		

}
