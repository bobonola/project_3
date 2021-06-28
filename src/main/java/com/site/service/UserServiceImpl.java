package com.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.mapper.UserMapper;
import com.site.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;

	@Override		// 로그인
	public UserVo login(UserVo userVo) {
		return userMapper.selectLogin(userVo);
	}

	@Override		// 이메일 찾기
	public UserVo searchEmail(UserVo userVo) {
		return userMapper.selectSearchEmail(userVo);
	}

	@Override		// 비밀번호 찾기
	public UserVo searchPassword(UserVo userVo) {
		return userMapper.selectSearchPassword(userVo);
	}

	@Override		// 회원가입
	public void insertUser(UserVo userVo) {
		userMapper.insertUserDo(userVo);
	}

	@Override		// 이메일 중복체크
	public int emailCheck(String email) throws Exception {
		return userMapper.emailCheck(email);
	}

	@Override		// 임시 비밀번호 변경
	public void changePassword(String email, String temp_password) {
		userMapper.updatePassword(email, temp_password);
	}




}
