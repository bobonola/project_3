package org.pg.receive;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.pg.data.CommunicationMessage;
import org.pg.data.MallVO;
import org.pg.data.PGException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiveServiceImpl implements ReceiveService
{

	@Autowired
	private ReceiveMapper mapper;

	@Override
	public Map<String, Object> connectionCheck( Map<String, Object> input,
			HttpSession session )
	{
		Map<String, Object> result = new HashMap<>();
		PGException exception = null;
		String mall_code = null;

		try
		{
			String message = (String)result.get( "messageType" );

			if ( message.equals( CommunicationMessage.connect ) == false )
			{
				exception = new PGException( "잘못된 접근입니다." );
				throw exception;
			}

			if ( input == null )
			{
				exception = new PGException( "입력된 데이터가 없습니다." );
				throw exception;
			}
			mall_code = (String)input.get( "mall_code" );

			if ( mall_code == null )
			{
				exception = new PGException( "업체 코드가 없습니다." );
				throw exception;
			}
			MallVO mallInfo = mapper.getMall( mall_code );

			if ( mallInfo == null )
			{
				exception = new PGException( "등록되지 않은 업체입니다." );
				throw exception;
			}

			result.put( "messageType", CommunicationMessage.success );
			session.setAttribute( "mall_name", input.get( "mall_name" ) );
		}
		catch( PGException e )
		{
			result.put( "messageType", CommunicationMessage.fail );
			result.put( "message", e.getMessage() );
			return result;
		}
		catch( Exception e )
		{
			result.put( "messageType", CommunicationMessage.error );
			result.put( "message", "예상치 못한 오류가 발생했습니다.: " + e.getMessage() );
			e.printStackTrace();
			return result;
		}

		return result;
	}

}
