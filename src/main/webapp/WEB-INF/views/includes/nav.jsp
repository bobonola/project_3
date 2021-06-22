<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:300,400,500,700,900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/nav.css">
</head>
<body>

	<nav>
		<h1></h1>
		<ul>
			<li><a href="./notice"><span>공지사항</span></a></li>
			<li>2</li>
			<li>3</li>
			<li>4</li>
			<li>5</li>
		</ul>
		<ul>
		<c:choose>
		<c:when test="${session_admin_code==2 }">
			<li><a href="#"><span>관리자페이지</span></a></li>
		</c:when>
		<c:otherwise>
			<li><a href="#"><span>장바구니</span></a></li>
		</c:otherwise>
		</c:choose>
		</ul>

	</nav>

</body>
</html>