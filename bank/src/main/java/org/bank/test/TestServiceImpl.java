package org.bank.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService
{
	@Autowired
	private TestMapper mapper;

	@Override
	public boolean sizeTest( int size )
	{
		int executed = mapper.updateSize( size );
		boolean isUpdated = (executed != 0);
		
		return isUpdated;
	}

}
