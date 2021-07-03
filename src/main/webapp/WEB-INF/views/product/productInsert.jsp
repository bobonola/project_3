<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<c:if test="${session_flag == null || session_flag == 'fail' || session_admin_code == 1 }">
	   <script type="text/javascript">
	      alert("접근권한이 없습니다.");
	      window.location = "../index";
	   </script>
	   <%-- <c:redirect url="../index" /> --%>
	</c:if>
<title> 상품 등록하기 </title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="JARDIN" />
<meta name="keywords" content="JARDIN" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
<link rel="stylesheet" type="text/css" href="../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../css/content.css" />
<link rel="stylesheet" href="../css/style.css">
<link  rel="stylesheet" href="../css/write.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript">
</script>
<style>
#contain {
	margin : 0 250px
}

</style>
</head>
<body>
<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>

<div id="contain">
<div id="layerWrap">


<div class="inputWrap">
		
	<div class="inputBody">
		<div class="title">상품 등록하기</div>
		
			<form action="./productInsertDo" name="productInsert" method="post" enctype="multipart/form-data">
		      <table>
		        <colgroup>
		          <col width="55%">
		          <col width="25%">
		          <col width="50%">
		        </colgroup>
		        
		        <tr>
		          <th>스타일번호</th>
		          <td>
		            <input type="text" name="st_no" >
		          </td>
		        </tr>
		        
		        <tr>
		          <th>상품명</th>
		          <td>
		            <input type="text" name="product_name">
		          </td>
		        </tr>
		        
		        <tr>
		          <th>이미지</th>
		          <td>
		            <input multiple="multiple" type="file" name="files" class="file">
		          </td>
		        </tr>
		        
		        
		        
		        
		        
		        <tr>
		          <th>가격</th>
		          <td id="product_price">
		            <input type="text" name="product_price">
		          </td>
		        </tr>
		        
				<tr>
		          <th>재고</th>
		          	<td id="product_total_stock">
		          		<c:set var="sum" value="0" />
		          		<c:forEach var="i" begin="230" end="300" step="10">
		            		${i } : <input type="text" name="product_size_${i }"><br /><br />
		          		</c:forEach>
		            	<c:set var="sum" value="${sum + i}" />
		          
		          	</td>
		        </tr>
				
		        
		        <tr>
		          <th>설명</th>
		          <td>
		            <textarea name="product_description" cols="50" rows="10"></textarea>
		          </td>
		        </tr>
		        
		      </table>
		      <hr>
		      <div class="button-wrapper">
		        <button type="submit" class="write">등록하기</button>
		        <button type="button" class="cancel" onclick="javascript:location.href='../user/adminList'">취소</button>
		      </div>
		    </form>
		</div>

	</div>

</div>

</div>

</div>
<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>
</html>