package org.pg.sample;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailTest
{

	public static void main( String[] args )
	{
		final String user = "teamprojectpg@gmail.com"; // 발신자의 지메일 아이디를 입력
		final String password = "msartefibppjqeww"; // 발신자 계정의 앱패스워드를 입력(이메일계정 비밀번호가 아님)

		Properties props = new Properties();
		props.put( "mail.transport.protocol", "smtp" );
		props.put( "mail.smtp.host", "smtp.gmail.com" );
		props.put( "mail.smtp.port", "465" );
		props.put( "mail.smtp.auth", "true" );

		props.put( "mail.smtp.quitwait", "false" );
		props.put( "mail.smtp.socketFactory.port", "465" );
		props.put( "mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory" );
		props.put( "mail.smtp.socketFactory.fallback", "false" );

		Session session = Session.getInstance( props, new Authenticator()
		{
			public PasswordAuthentication getPasswordAuthentication()
			{
				// 인증 아이디/비밀번호를 저장한다.
				return new PasswordAuthentication( user, password );
			}
		} );

		try
		{
			Message msg = new MimeMessage( session );

			// 발신자 이메일 주소를 설정한다.
			msg.setFrom( new InternetAddress( "from@test.com" ) );

			// 수신자 이메일 주소를 설정한다.
			msg.addRecipient( Message.RecipientType.TO,
					new InternetAddress( "sws199001@gmail.com" ) );

			// 제목을 저장한다.
			msg.setSubject( "제목" );

			// 메일 내용을 저장한다.
			msg.setContent( "본문", "text/plain;charset=utf-8" );

			// 메일 전송
			Transport.send( msg );
			System.out.println( "message sent successfully..." );

		}
		catch( AddressException e )
		{
			e.printStackTrace();
		}
		catch( MessagingException e )
		{
			e.printStackTrace();
		}
	}
}