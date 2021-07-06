<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
@import url('https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap');
</style>
<title> JARDIN SHOP </title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="JARDIN SHOP" />
<meta name="keywords" content="JARDIN SHOP" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
<link rel="stylesheet" type="text/css" href="../css/reset.css?v=Y" />
<link rel="stylesheet" type="text/css" href="../css/layout.css?v=Y" />
<link rel="stylesheet" type="text/css" href="../css/content.css?v=Y" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/top_navi.js"></script>
<script type="text/javascript" src="../js/left_navi.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="../js/idangerous.swiper-2.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.anchor.js"></script>
<style>
div.text_style {
	text-align:center;
}
#main_title {
	font-size:30px;
}
#sub_title {
	font-size:20px;
	padding:10px 0px
}
#shopping_more{
	padding:0 15px;
}
.loading{
	width:100%;
	height:100%;
	position:fixed;
	left:0px;
	top:0px;
	background:#fff;
	z-index:1000; /* 이 값으로 레이어의 위치를 조정합니다. */
}
#loader {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 12.5%;
  pointer-events: none;
}
#loader > div {
  width: 100%;
  height: 100%;
  background: linear-gradient( to left, #FF4790, #E841D7 , #DA55FF ,#9641E8 ,#7347FF);
  transition: transform 2100ms;
  opacity: 0.8;
}
 #loader > div:nth-child(1) {
  transition-delay: 0ms;
}
 #loader > div:nth-child(2) {
  transition-delay: 100ms;
}
#loader > div:nth-child(3) {
  transition-delay: 150ms;
}
#loader > div:nth-child(4) {
  transition-delay: 200ms;
}
#loader > div:nth-child(5) {
  transition-delay: 250ms;
}
#loader > div:nth-child(6) {
  transition-delay: 300ms;
}
#loader > div:nth-child(7) {
  transition-delay: 350ms;
}
#loader > div:nth-child(8) {
  transition-delay: 400ms;
} 
 
 
body:not(.hidden).reveal #loader > div {
  transform: translateX(-100%);
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
  	setTimeout(() => {
  	    document.body.classList.add("reveal")
  	}, 500),
  	/* document.addEventListener("click", () => { */
  	    document.body.classList.toggle("reveal")
  	/* });  */ 	
 	 
</script>
</head>
<body>
<div id="loader">
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
</div>

	<!-- container -->
	<div id="container">
		<div id="location">
		</div>
		<div id="outbox">		
		</div>
	</div>
	<!-- //container -->
	<div class="text_style" id="main_title">쇼핑몰 결제완료 페이지입니다.
		<div id="sub_title">
			<a href="../index" id="shopping_more">쇼핑 더하기</a>
			<a href="../index" id="shopping_more">상품 페이지</a>
		</div>
	</div>
</body>
</html>