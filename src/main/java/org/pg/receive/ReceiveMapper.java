package org.pg.receive;

import org.apache.ibatis.annotations.Mapper;
import org.pg.data.MallVO;

@Mapper
public interface ReceiveMapper
{

	MallVO getMall( String mall_code );

}
