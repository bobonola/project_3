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
  <link rel="stylesheet" href="../css/notice_list.css">
</head>
<body>
<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>

  <section>
    <h1 id="notice_h1">NOTICE</h1>

   <table>
      <colgroup>
        <col width="18%">
        <col width="40%">
        <col width="28%">
        <col width="10%">
      </colgroup>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
     <c:forEach var="noticeVo" items="${map.list }">
	      <tr>
	        <td><span class="table-notice">${noticeVo.notice_no }</span></td>
	        <td class="table-title">
	        <!-- content_view?번호를 전달 -->
		    <a href="./noticeView?notice_no=${noticeVo.notice_no }">${noticeVo.notice_content }</a>
	        </td>
	        <td>${noticeVo.notice_date}</td>
	        <td>${noticeVo.notice_hit}</td>
	      </tr>
   
    </c:forEach>
   </table>

    <!-- 하단 넘버링 -->
    <ul class="page-num">
      <a href="./noticeList?page=1"><li class="first"></li></a>
      <!-- 이전페이지는 1이상일때 -1을 해줌, 1일때는 링크 삭제시킴 -->
      <c:if test="${map.page <= 1 }">
        <li class="prev"></li>
      </c:if>
      <c:if test="${map.page > 1}">
        <a href="./noticeList?page=${map.page - 1 }"><li class="prev"></li></a>
      </c:if>
      
      <!-- 번호넣기 -->
      <c:forEach var="nowPage" begin="${map.startPage }" end="${map.endPage }">
        <c:if test="${map.page == nowPage }">
          <li class="num"><div>${nowPage}</div></li>
        </c:if>
        <c:if test="${map.page != nowPage }">
          <li class="num">
            <a href="./noticeList?page=${nowPage}"><div>${nowPage}</div></a>
          </li>
        </c:if>
      </c:forEach>
      <!-- 다음페이지는 max보다 작을때 +1 증가, max보다 크거나 같을때 링크 삭제시킴 -->
      <c:if test="${map.page >= map.maxPage }">
        <li class="next"></li>
      </c:if>
      <c:if test="${map.page < map.maxPage }">
        <a href="./noticeList?page=${map.page + 1 }"><li class="next"></li></a>
      </c:if>
      <!-- 마지막페이지 이동 -->
      <a href="./noticeList?page=${map.maxPage }"><li class="last"></li></a>
    </ul>
    <!-- 하단 넘버링 끝 -->

    <c:if test="${session_admin_code==2 }">
    	<a href="./noticeWrite"><div class="write">쓰기</div>
    </c:if> 
    
    
  </section>

  <c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>	
</body>
</html>