package com.site.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.site.vo.UserVo;


@Mapper
public interface UserMapper {
	// 사용자 로그인
	UserVo selectLogin(UserVo userVo);
	
}
