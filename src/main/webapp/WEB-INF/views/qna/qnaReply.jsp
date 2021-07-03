<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>QNA 답변</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/write.css">
  <script type="text/javascript">
	  document.addEventListener("DOMContentLoaded", function(){
		  
		  document.getElementById("qna_secret_code${qnaVo.qna_secret_code }").checked = true;
		  
		  
	  });
	  
	</script>
	  
</head>
<body>
<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
<section>
    <h1>QNA 답글</h1>
    <hr>

    <form action="./qnaReplyDo" name="qnaReply" method="post">
      <table>
      <input type="hidden" name="qna_no" value="${qnaVo.qna_no }">
      <input type="hidden" name="qna_group" value="${qnaVo.qna_group }">
      <input type="hidden" name="qna_step" value="${qnaVo.qna_step }">
      <input type="hidden" name="qna_indent" value="${qnaVo.qna_indent }">
      <input type="hidden" name="qna_original_name" value="${qnaVo.qna_original_name }">
      
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="qna_name" value="${name }">
            <input type="hidden" name="email" value="${session_email }">
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
		        	오픈글<input type="radio" name="qna_secret_code" id="qna_secret_code1" value="1">
					비밀글<input type="radio" name="qna_secret_code" id="qna_secret_code2" value="2">  
		        </div>
        	</td>
        </tr>
        
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">답변완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='./qnaList'">취소</button>
      </div>
    </form>

  </section>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>
</html>