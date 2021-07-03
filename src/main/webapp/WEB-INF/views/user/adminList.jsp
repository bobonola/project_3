<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<c:if test="${session_flag == null || session_flag == 'fail' || session_admin_code == 1 }">
	   <script type="text/javascript">
	      alert("접근권한이 없습니다.");
	      window.location = "../index";
	   </script>
	   <%-- <c:redirect url="../index" /> --%>
	</c:if>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="../css/admin_account.css">
</head>

<body>
  <header>
    <div id="header-left">
      LMS <span>ENTERPRISE</span> Type
    </div>
    <div id="header-right">
      <span>관리자 (GMT+9:00) Seoul</span>
      <img src="http://lmsenterprise2019.itmap.co.kr/_admin/image/logout.png" alt="">

      <table>
        <tr>
          <td class="select">
            <img src="http://lmsenterprise2019.itmap.co.kr/_admin/image/KOR.png" alt="">
            <span>한국어</span>
          </td>
          <td class="arrow">
            <div class="separator"></div>
            <span>▼</span>
          </td>
        </tr>
      </table>

      <table>
        <tr>
          <td class="select">
            <span>LMS 매뉴얼</span>
          </td>
          <td class="arrow">
            <div class="separator"></div>
            <span>▼</span>
          </td>
        </tr>
      </table>
    </div>
  </header>

  <nav>
    <ul>
      <li><span class="nav1">&emsp;<a href="./userList"></span> 회원관리</a></li>
      <li><span class="nav2">&emsp;<a href="../product/productInsert"></span> 상품등록</a></li>
      <li><span class="nav3">&emsp;<a href="../notice/noticeList"></span> 공지사항</a></li>
      <li><span class="nav4">&emsp;<a href="../qna/qnaList"></span> QNA</a></li>
    </ul>
  </nav>

</body>
</html>