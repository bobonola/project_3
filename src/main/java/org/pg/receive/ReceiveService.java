package org.pg.receive;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface ReceiveService
{

	Map<String, Object> connectionCheck( Map<String, Object> input );

}
