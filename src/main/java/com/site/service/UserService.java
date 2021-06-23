package com.site.service;

import org.springframework.stereotype.Service;

import com.site.vo.UserVo;

public interface UserService {
	// 사용자 로그인
	UserVo login(UserVo userVo);
		
}
