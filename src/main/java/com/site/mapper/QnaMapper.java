package com.site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.vo.QnaVo;

@Mapper
public interface QnaMapper {

	// qna 전체리스트 호출
	List<QnaVo> selectQnaList(int startRow, int endRow);
	// qna 전체글 수
	int selectQnaCount();
	// qna all로 검색한 리스트 호출
	List<QnaVo> selectQnaListSearchAll(int startRow, int endRow, String search);
	// qna all로 검색한 수
	int selectQnaSearchAllCount(String search);
	// qna category별 검색한 리스트 호출
	List<QnaVo> selectQnaListSearch(int startRow, int endRow, String category, String search);
	// qna category별 검색한 수
	int selectQnaSearchCount(String category, String search);

}
