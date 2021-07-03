<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글수정</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/write.css">
</head>
<body>
<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
<section>
    <h1>게시글수정</h1>
    <hr>

    <form action="./noticeModifyDo" name="noticeModify" method="post" enctype="multipart/form-data">
     
      <input type="hidden" name="notice_no" value="${noticeVo.notice_no }">
      <input type="hidden" name="notice_image" value="${ noticeVo.notice_image}">  
       <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="email" value="${noticeVo.email }" readonly>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="notice_title" value="${noticeVo.notice_title }">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="notice_content" cols="50" rows="10">${noticeVo.notice_content}</textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="file" id="file" >
            <a href="./noticeUpload/${noticeVo.notice_image }">${noticeVo.notice_image }</a>
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">수정완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='./noticeList'">취소</button>
      </div>
    </form>

  </section>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>
</html>