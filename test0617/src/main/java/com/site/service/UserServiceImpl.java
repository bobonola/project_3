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

	@Override
	public void insertUser(UserVo userVo) {
		userMapper.insertUserDo(userVo);
	
	}

	@Override //이메일 중복체크
	public int emailCheck(String email) throws Exception {
		
		return userMapper.emailCheck(email);
	}

	@Override //회원정보수정 호출
	public UserVo userModify(String email) {
		UserVo userVo = userMapper.selectUserModify(email);
		return userVo;
	}

	@Override //회원정보수정 저장
	public void modifyUser(UserVo userVo) {
		userMapper.updateUserModifyDo(userVo);
	}





}
