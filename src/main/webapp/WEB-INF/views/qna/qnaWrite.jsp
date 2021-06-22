<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<c:if test="${session_flag==null || session_flag=='fail' }">
   <script type="text/javascript">
      alert("로그인을 하셔야 글쓰기가 가능합니다.");
   </script>
   <c:redirect url="./login" />
</c:if>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글쓰기</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="../css/style.css">
  <link  rel="stylesheet" href="../css/write.css">
</head>
<body>
<section>
    <h1>QNA 글쓰기</h1>
    <hr>

    <form action="./qnaWriteDo" name="qnaWrite" method="post" enctype="multipart/form-data">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="email" value="${session_email }" readonly>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="qna_title">
          </td>
        </tr>
        
        <tr>
          <th>내용</th>
          <td>
            <textarea name="qna_content" cols="50" rows="10"></textarea>
          </td>
        </tr>
        <tr>
        	<th>비밀글 체크</th>
        	<td>
		        <div id="radiobox">
		        	오픈글<input type="radio" name="qna_secret_code" value="1" checked>
					비밀글<input type="radio" name="qna_secret_code" value="2">  
		        </div>
        	</td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">작성완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='list'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>