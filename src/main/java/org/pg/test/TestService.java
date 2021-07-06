package org.pg.test;

import org.pg.data.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService
{
	@Autowired
	TestMapper mapper;

	public boolean nullCheck()
	{
		UserVO temp = mapper.nullCheck();
		boolean result = (temp == null);

		return result;
	}
}
