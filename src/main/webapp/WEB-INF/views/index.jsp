<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>신발</title>
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:300,400,500,700,900&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/style_main.css">
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  		<link rel="stylesheet" href="css/page.css">
  		<link rel="stylesheet" type="text/css" href="/css/reset.css?v=Y" />
		<link rel="stylesheet" type="text/css" href="/css/layout.css?v=Y" />
		<link rel="stylesheet" type="text/css" href="/css/content.css?v=Y" />
	</head>
	<style>
img#sold_out {
    position: relative;
    opacity: 0.5;
    padding: 27px 0;
    padding-bottom: 91px;
}
img#main_img {
    position: absolute;
}
	
	</style>
	<body>
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	 	<section>
	 		<div id="top_img"></div>
			<br>
			<div id="best">
			
		 		<div class="wrapper">
		 		<h2>NEW ARRIVALS</h2> <br>
		 		
			      <form action="./index" name="search" method="post" align="center">
			
			        <div class="main_search">
			          <input type="text" size="16" name="search" id="search" value="${map.search }">
			        </div>
			      </form>
			      <br>
			      <br>
			      
			      <form action="./index" method="post">
			        <select name="sort" id="category">
			          <option value="productDateDesc" ${(map.sort eq 'productDateDesc')? 'selected':'' }>신상품순</option>
			          <option value="productPriceAsc" ${(map.sort eq 'productPriceAsc')? 'selected':'' }>낮은가격순</option>
			          <option value="productPriceDesc" ${(map.sort eq 'productPriceDesc')? 'selected':'' }>높은가격순</option>
			          <option value="productSales" ${(map.sort eq 'productSales')? 'selected':'' }>판매량순</option>
			          <option value="productRatings" ${(map.sort eq 'productRatings')? 'selected':'' }>평점순</option>
			        </select>		  
			        <button type="submit">
			        	<i class="fas fa-search">선택하기</i>
			        </button>
				  </form>
			      
			      
			    </div>
			    
			    <ul class="main_show">
	 				<c:forEach var="productVo" items="${map.list }">
	 				
		 				<li>
			 					<c:if test="${productVo.product_total_stock == 0}">
			 						<img id="main_img" alt="" src="${productVo.product_main_image }">
			 						<img id="sold_out" alt="" src="../images/ico/sold_out2.PNG">
			 					</c:if>
			 					<c:if test="${productVo.product_total_stock != 0}">
			 						<a href="./product/productView?product_no=${productVo.product_no }">
			 							<img alt="" src="${productVo.product_main_image }">
			 							<span id="best_top">BEST<br>${productVo.product_no }</span>
			 							<span>${productVo.product_name }</span> <br><br>
					 					<span>
					 						<fmt:formatNumber value="${productVo.product_price}" pattern="#,###"/> 원
					 					</span>
			 						</a>
			 					</c:if>

			 					
			 					<br />
	 						</a>	
		 				</li>
	 				</c:forEach>
	 			</ul><br><br>
	 			
	 			<!-- 하단 넘버링 -->
		    <ul class="page-num">
		      <a href="./index?page=1&&search=${map.search}&sort=${map.sort}"><li class="first"></li></a>
		      <!-- 이전페이지는 1이상일때 -1을 해줌, 1일때는 링크 삭제시킴 -->
		      <c:if test="${map.page <= 1 }">
		        <li class="prev"></li>
		      </c:if>
		      <c:if test="${map.page>1}">
		        <a href="./index?page=${map.page - 1 }&search=${map.search}&sort=${map.sort}"><li class="prev"></li></a>
		      </c:if>
		      
		      <!-- 번호넣기 -->
		      <c:forEach var="nowPage" begin="${map.startPage}" end="${map.endPage }">
		        <c:if test="${map.page == nowPage }">
		          <li class="num"><div>${nowPage}</div></li>
		        </c:if>
		        <c:if test="${map.page != nowPage }">
		          <li class="num">
		            <a href="./index?page=${nowPage}&search=${map.search}&sort=${map.sort}"><div>${nowPage}</div></a>
		          </li>
		        </c:if>
		      </c:forEach>
		      <!-- 다음페이지는 max보다 작을때 +1 증가, max보다 크거나 같을때 링크 삭제시킴 -->
		      <c:if test="${map.page >= map.maxPage }">
		        <li class="next"></li>
		      </c:if>
		      <c:if test="${map.page < map.maxPage }">
		        <a href="./index?page=${map.page + 1 }&search=${map.search}&sort=${map.sort}"><li class="next"></li></a>
		      </c:if>
		      <!-- 마지막페이지 이동 -->
		      <a href="./index?page=${map.maxPage }&search=${map.search}&sort=${map.sort}"><li class="last"></li></a>
		    </ul>
		    <!-- 하단 넘버링 끝 -->	
	 			
		</div>
	 		
	 	</section>
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</body>
</html>