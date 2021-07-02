<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
@import url('https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap');
</style>
<meta charset="UTF-8">
<title>Join2</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css?v=Y" />
<link rel="stylesheet" type="text/css" href="../css/layout.css?v=Y" />
<link rel="stylesheet" type="text/css" href="../css/content.css?v=Y" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="../js/idangerous.swiper-2.1.min.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	position: relative;
	height: 100%;
	text-align: center;
}

#wrap {
	position: relative;
	min-height: 100%;
	font-size: 12px;
}

#header {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 13px 0 30px 17px;
	width: 768px;
	margin: 0 auto;
}

#h_logo {
	display: block;
	overflow: hidden;
	width: auto;
	height: auto;
	margin: 0 auto;
	font-size: 40px;
	font-family: 'Fredoka One', cursive;
	line-height: 50px;
}

#container {
	min-height: 185px;
}

#content {
	width: 460px;
	margin: 0 auto;
	padding-bottom: 30px;
	
}

.id_area {
	position: relative;
}

.input_row {
	position: relative;
	height: 29px;
	margin: 5px 0 30px;
	padding: 10px 35px 10px 15px;
	border: solid 1px #dadada;
	background: #fff;
	border-radius: 15px;
}

.input_box {
	display: block;
	overflow: hidden;
}

.int {
	font-size: 15px;
	line-height: 18px;
	position: relative;
	z-index: 9;
	width: 100%;
	height: 16px;
	padding: 7px 0 6px;
	color: #000;
	border: none;
	background: #fff;
	appearance: none;
}

.content_notice {
	font-family: 'Noto Sans KR', sans-serif;
	padding-top: 2px;
}

#notice_main {
	font-size: 40px
}

#notice_sub {
	font-size: 25px
}
#card_images{
	width: 190px;
	height: 190px;
	padding-bottom: 10px;
}
#account_images{
	width: 140px;
	height: 140px;
	padding: 30px 0 30px 10px;
	
}
.btn_login {
	display: block;
	width: 100%;
	height: 61px;
	margin: 50px 0 14px;
	padding-top: 1px;
	border: none;
	background: linear-gradient( to left, #0CB680, #0555EB);
	text-align: center;
	color: #fff;
	font-size: 20px;
	font-weight: 700;
	line-height: 55px;
	cursor: pointer;
	border-radius: 15px;
	text-decoration: none
}
.btn_choose {
	display: block;
    width: 100%;
    height: 51px;
    margin: 13px 0 35px;
    padding-top: 1px;
    padding-left: 9px;
    border: solid 1px #e7e7e7;
    1px: white;
    text-align: center;
    color: #000;
    font-size: 17px;
    font-weight: 700;
    line-height: 55px;
    cursor: pointer;
    border-radius: 15px;
    text-decoration: none;
    font-family: 'Noto Sans KR', sans-serif;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    </script>

</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="h_logo">PayMent's</div>
		</div>
		<div id="container">
			<div id="content">
				<div style="margin-bottom: 7px"></div>
				<div class="content_notice" id="notice_main">계정이 생성되었습니다.</div>
				<div class="content_notice" id="notice_sub">카드나 계좌를 등록하여 쇼핑을 즐겨보세요.</div>
			<!-- tab -->
			<div class="detailTab">
				<ul>
					<li class="dep"><a href="javascript:;" onclick="return false;" id="detailInfo">카드</a></li>
					<li><a href="javascript:;" onclick="return false;" id="goodsRelation">계좌연결</a></li>
				</ul>
			</div><script type="text/javascript">$(function(){$(".detailTab ul li a:eq(0)").click();});</script>
		<!-- //tab -->


				<!-- detail info -->
				<div class="detailInfo disnone">
					<form action="" method="post">
						<img id="card_images" src="https://png.pngtree.com/png-vector/20190507/ourmid/pngtree-vector-credit-card-icon-png-image_1025464.jpg"  />
					<fieldset style="border: 0">
						<select class="btn_choose">
							<option>&nbsp;💰&nbsp;은행선택</option>
							<option>💰&nbsp;농협&nbsp;│&nbsp;352-1306-7622-33&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;자립예탁금</option>
							<option>💎&nbsp;신한&nbsp;│&nbsp;352-1306-7622-33&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;자립예탁금</option>
							<option>&nbsp;✈&nbsp;기업&nbsp;│&nbsp;352-1306-7622-33&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;자립예탁금</option>
						</select>
						<div class="id_area">
							<div class="input_row" id="id_area">
								<span class="input_box"> <input
									style="font-family: 'Noto Sans KR', sans-serif" type="text"
									name="user_id" id="user_id" class="int" placeholder=카드번호>
								</span>
							</div>
						</div>
						<div class="id_area">
							<div class="input_row" id="id_area">
								<span class="input_box"> <input
									style="font-family: 'Noto Sans KR', sans-serif" type="text"
									name="user_id" id="user_id" class="int" placeholder="만료일(MM/YY)">
								</span>
							</div>
						</div>
						<div class="id_area">
							<div class="input_row" id="id_area">
								<span class="input_box"> <input
									style="font-family: 'Noto Sans KR', sans-serif" type="password"
									name="user_id" id="user_id" class="int" placeholder="보안코드(CVC)">
								</span>
							</div>
						</div>
						<a href="http://localhost:8000/join/join_paymethod_card" class="btn_login"
							type="button">다음</a>
						<!-- <button class="btn_login" type="button" onclick="login_ajax()">결제하기</button> -->
					</fieldset>
				</form>
				</div>
				<!-- detail info -->

				<!-- goods relation -->
				<div class="goodsRelation disnone">
						<form action="" method="post">
						<img id="account_images" src="../images/pg/account.png"  />
					<fieldset style="border: 0">
							<select class="btn_choose">
								<option>&nbsp;💰&nbsp;은행선택</option>
								<option>💰&nbsp;농협</option>
								<option>💎&nbsp;신한</option>
								<option>&nbsp;✈&nbsp;기업</option>
							</select>
						
						<div class="id_area">
							<div class="input_row" id="id_area">
								<span class="input_box"> 
									<input style="font-family: 'Noto Sans KR', sans-serif" type="password" name="password" id="password" class="int" placeholder=계좌번호>
								</span>
							</div>
						</div>
						<div class="id_area">
							<div class="input_row" id="id_area">
								<span class="input_box"> 
									<input style="font-family: 'Noto Sans KR', sans-serif" type="password" name="password" id="password" class="int" placeholder=계좌비밀번호>
								</span>
							</div>
						</div>
						
						<a href="http://localhost:8000/join/join_paymethod_account" class="btn_login"
							type="button">다음</a>
					</fieldset>
				</form>
				</div>
				<!-- detail info -->
			
		</div>
	</div>
</body>
</html>