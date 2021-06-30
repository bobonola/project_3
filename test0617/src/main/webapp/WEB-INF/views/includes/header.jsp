<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:300,400,500,700,900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/header.css">
</head>
<body>
	<div id="nav_up">
		<ul>
			<c:choose>
			<c:when test="${session_flag==null || session_flag=='fail' }">
				<li><a href="/join">회원가입&nbsp;</a>|</li>
				<li><a href="/login">로그인&nbsp;</a>|</li> 
			</c:when>
			<c:otherwise>
				<li><a href="./userModify?email=${session_email }">회원정보수정</a></li>
				<li><a href="/logout">로그아웃</a></li>
			</c:otherwise>	
		</c:choose>
	   </ul>
	</div>
</body>
</html>