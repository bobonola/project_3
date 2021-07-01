package org.pg.receive;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReceiveController
{

	@Autowired
	private ReceiveService service;

	@RequestMapping( "/connect" )
	@ResponseBody
	public Map<String, Object> connect( Map<String, Object> input, HttpSession session )
	{
		Map<String, Object> result = service.connectionCheck( input, session );


		return result;

	}
}
