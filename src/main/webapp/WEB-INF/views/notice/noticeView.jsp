<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>공 지 사 항</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/read.css">
    <script type="text/javascript">
    function noticeDelete_check(){
    	if(confirm("삭제하시겠습니까?")){
    		location.href="./noticeDelete?notice_no=${map.noticeVo.notice_no}";
    	}else{
    		return false;
    	}
    }
  </script>  
</head>

<body>
  <c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>

  <section>
    <h1>NOTICE</h1>

    <table>
      <tr>
        <th>${map.noticeVo.notice_title}</th>
      </tr>
      <tr>
        <td>${map.noticeVo.notice_date }</td>
      </tr>
       <tr>
        <td>${map.noticeVo.notice_content }</td>
      </tr>     
      <tr>
        <td class="article">
          <img src="http://localhost:8000/noticeUpload/${map.noticeVo.notice_image }" alt="" width="80%"></td>
      </tr>


    </table>
    <a href="./noticeList"><div class="list">목록</div></a>
	    <c:if test="${session_admin_code == 2 }">
	    	<a href="#" onclick="noticeDelete_check()"><div class="list">삭제</div></a>
	    	<a href="./noticeModify?notice_no=${map.noticeVo.notice_no }"><div class="list">수정</div>   
	    </c:if>
    
</section>

 	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>
</html>