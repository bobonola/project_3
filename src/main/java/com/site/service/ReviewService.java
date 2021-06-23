package com.site.service;

import org.springframework.web.multipart.MultipartFile;

import com.site.vo.ReviewVo;

public interface ReviewService {
	// 리뷰 글쓰기 저장
	void reviewWirteDo(ReviewVo reviewVo, MultipartFile file);

}
