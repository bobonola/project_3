package org.pg.email;

import java.util.Date;
import java.util.Properties;

import javax.activation.*;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class EmailComponentImpl implements EmailComponent
{
	@Autowired
	private JavaMailSender mailSender;

	@Override
	@Async
	public void sendMail( String to, String subject, String code )
	{
		// String password = "msartefibppjqeww";
		// String from = "teamprojectpg@gmail.com";
		// String fromName = "Payment's Manager";
		// String host = "smtp.gmail.com";
		// String port = "465";
		//
		// Properties property = new Properties();
		//
		// property.put( "mail.transport.protocol", "smtp" );
		// property.put( "mail.smtp.host", host );
		// property.put( "mail.smtp.port", port );
		// property.put( "mail.smtp.auth", "true" );
		//
		// property.put( "mail.smtp.quitwait", "false" );
		// property.put( "mail.smtp.socketFatory.port", port );
		// property.put( "mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory" );
		// property.put( "mail.smtp.socketFatory.fallback", "false" );
		//
		// try
		// {
		//
		// Session mailSession = Session.getInstance( property, new Authenticator()
		// {
		// public PasswordAuthentication getPasswordAuthentication()
		// {
		// return new PasswordAuthentication( from, password );
		// }
		// } );
		// mailSession.setDebug( true );
		//
		// InternetAddress fromAddress = new InternetAddress( from, fromName );
		// InternetAddress toAddresses = new InternetAddress(to);
		// Date now = new Date();
		//
		// Message msg = new MimeMessage( mailSession );
		//
		// msg.setFrom( fromAddress );
		// msg.setRecipient( RecipientType.TO, toAddresses );
		// msg.setSubject( subject );
		// msg.setSentDate( now );
		//
		// Multipart multiparts = new MimeMultipart();
		// MimeBodyPart mTextPart = new MimeBodyPart();
		// // MimeBodyPart mFilePart = null;
		//
		// code = "<h3>" + code + "</h3>";
		//
		// mTextPart.setText( code, "UTF-8", "html" );
		// multiparts.addBodyPart( mTextPart );
		//
		// msg.setContent( multiparts, "text/html; charset=UTF-8" );
		//
		// MailcapCommandMap mailcapCmdMap = (MailcapCommandMap)CommandMap
		// .getDefaultCommandMap();
		// mailcapCmdMap.addMailcap(
		// "text/html;; x-java-content-handler=com.sun.mail.handlers.text_html" );
		// mailcapCmdMap.addMailcap(
		// "text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml" );
		// mailcapCmdMap.addMailcap(
		// "text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain" );
		// mailcapCmdMap.addMailcap(
		// "multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed" );
		// mailcapCmdMap.addMailcap(
		// "message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822" );
		//
		// Transport.send( msg, from, password );
		// // Transport.send( msg );
		//
		// }
		// catch( Exception e )
		// {
		// e.printStackTrace();
		// }

		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper( msg );
		
		try
		{
			helper.setTo( new InternetAddress( to ) );
			helper.setSubject( subject );
			helper.setText( code );

			mailSender.send( msg );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}

}
