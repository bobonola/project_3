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
<section>
    <h1>게시글수정</h1>
    <hr>

    <form action="./qnaReplyDo" name="qnaReply" method="post">
      <table>
      <input type="hidden" name="qna_no" value="${qnaVo.qna_no }">
      <input type="hidden" name="qna_group" value="${qnaVo.qna_group }">
      <input type="hidden" name="qna_step" value="${qnaVo.qna_step }">
      <input type="hidden" name="qna_indent" value="${qnaVo.qna_indent }">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="qna_name">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="qna_title" value="[답글] ${qnaVo.qna_title }">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
<textarea name="qna_content" cols="50" rows="10">


---------------------------
[답글]
${qnaVo.qna_content }
</textarea>
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
        <button type="submit" class="write">답변완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='qnaList'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>