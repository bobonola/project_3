package com.site.service;

import org.springframework.stereotype.Service;

import com.site.vo.UserVo;

@Service
public interface UserService {

	UserVo login(UserVo userVo);

	void insertUser(UserVo userVo);

	int emailCheck(String email) throws Exception;
		
	
	

}
