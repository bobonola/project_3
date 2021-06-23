package com.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.mapper.UserMapper;
import com.site.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;

	@Override
	public UserVo login(UserVo userVo) {
		return userMapper.selectLogin(userVo);
	}

}
