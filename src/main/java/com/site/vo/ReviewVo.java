package com.site.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVo {

	private int review_no;				// 리뷰 번호
	private String email;				// 사용자 이메일
	private String review_title;		// 리뷰 제목
	private String review_content;		// 리뷰 내용
	private String review_image;		// 리뷰 이미지
	private Timestamp review_date;		// 리뷰 작성일
	private int review_ratings;			// 리뷰 평점
}
