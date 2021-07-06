package com.site.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.site.vo.CartVo;

@Mapper
public interface PayMapper {

	void insertPayment( CartVo cartVo );

}
