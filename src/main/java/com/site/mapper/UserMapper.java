package com.site.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.site.vo.UserVo;


@Mapper
public interface UserMapper {

	// 로그인
	UserVo selectLogin(UserVo userVo);
	// 이메일 찾기
	UserVo selectSearchEmail(UserVo userVo);
	// 비밀번호 찾기
	UserVo selectSearchPassword(UserVo userVo);
	// 회원가입
	void insertUserDo(UserVo userVo);
	// 이메일 중복체크
	int emailCheck(String email);
	// 임시 비밀번호 저장
	void updatePassword(String email, String temp_password);


}
