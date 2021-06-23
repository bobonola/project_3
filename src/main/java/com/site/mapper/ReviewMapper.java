package com.site.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.site.vo.ReviewVo;

@Mapper
public interface ReviewMapper {

	// 리뷰 쓰기 저장
	void insertReviewWrite(ReviewVo reviewVo);

}
