package com.site.service;

import org.springframework.stereotype.Service;

import com.site.vo.UserVo;

@Service
public interface UserService {

	// 로그인
	UserVo login(UserVo userVo);
	// 이메일 찾기
	UserVo searchEmail(UserVo userVo);
	// 비밀번호 찾기
	UserVo searchPassword(UserVo userVo);
	// 회원가입
	void insertUser(UserVo userVo);
	// 이메일 중복체크
	int emailCheck(String email) throws Exception;
	// 임시 비밀번호 저장
	void changePassword(String email, String temp_password);

		
	
	

}
