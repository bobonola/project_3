package org.pg.test;

import org.apache.ibatis.annotations.Mapper;
import org.pg.data.UserVO;

@Mapper
public interface TestMapper
{

	UserVO nullCheck();

}
