package com.site.service;

import java.util.Map;

public interface QnaService {

	// qna 전체리스트 호출
	Map<String, Object> qnaList(int page);
	// qna 검색리스트 호출
	Map<String, Object> qnaListSearch(int page, String category, String search);

}
