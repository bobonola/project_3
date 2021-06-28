package com.site.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.site.vo.UserVo;


@Mapper
public interface UserMapper {

	UserVo selectLogin(UserVo userVo);

	void insertUserDo(UserVo userVo);
	
	public int emailCheck(String email);

}
