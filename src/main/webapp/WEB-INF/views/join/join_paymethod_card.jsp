<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" type="text/css" href="../css/content.css?v=Y" />
<style>
@import url('https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap');
</style>
    <meta charset="UTF-8">
    <title>join_email</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            position: relative;
            height: 100%;
            text-align: center;
        }
        #wrap{
            position: relative;
            min-height: 100%;
            font-size: 12px;
        }
        #header{
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 14px 0 30px;
            width: 768px;
            margin: 0 auto;
        }

        #h_logo{
            display: block;
            overflow: hidden;
            width: auto;
            height: auto;
            margin: 0 auto;
            font-size: 40px;
            font-family: 'Fredoka One', cursive;
        }
        #container{
            padding-bottom: 50px;
            min-height: 185px;
			padding-top: 0px;
        }
        #content{
            width: 460px;
            margin: 0 auto;
            padding-bottom: 30px;
        }
        .id_area{
            position: relative;
        }
        .input_row{
            position: relative;
            height: 29px;
            margin: 30px 0 30px;
            padding: 10px 35px 10px 15px;
            border: solid 1px #dadada;
            background: #fff;
            border-radius: 15px;
            
        }
        .input_box{
            display: block;
            overflow: hidden;
        }

        .int{
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
        .content_notice{
       		font-family: 'Noto Sans KR', sans-serif;
       		padding-top:2px;
        }
        #notice_main{
        	font-size:40px
        }
        #notice_sub{
        	font-size:20px
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
    </style>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
    </script>

</head>
<body>
<div id="wrap">
    <div id="header">
        <div id="h_logo">
        	PayMent's
        </div>
    </div>
    <div id="container">
        <div id="content">
            <div style="margin-bottom: 7px"></div>
            <div class ="content_notice" id="notice_main">카드 인증하기</div>
            <div class ="content_notice" id="notice_sub">인증을 위하여 카드 비밀번호를 <br> 입력해주세요.</div>
            <form action="" method="get">
                <fieldset style="border: 0">
                    <div class="id_area">
                        <div class="input_row" id="id_area">
                            <span class="input_box">
                                <input style = "font-family: 'Noto Sans KR', sans-serif" type="text" name="user_id" id="user_id" class="int" placeholder="인증코드 4자리">
                            </span>
                        </div>
                    </div>
                    <a href="http://localhost:8000/join/join_success" class="btn_login" type="button">다음</a>
                    <!-- <button class="btn_login" type="button" onclick="login_ajax()">결제하기</button> -->
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>