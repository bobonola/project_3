<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<c:if test="${session_flag == null || session_flag == 'fail'}">
	<script type="text/javascript">
		alert("로그인을 하셔야 글을 쓸 수 있습니다.");
		location.href = "../user/login";
	</script>
</c:if>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>구매후기 작성</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean"
	rel="stylesheet">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/write.css">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
	<section>
		<h1>구매후기 작성</h1>
		<hr>
		<!-- enctype="multipart/form-data" : 이걸 써줘야 파일이 업로드된다. 꼭 필요함! -->	
		<form action="./reviewWriteDo" name="reviewWrite" method="post" enctype="multipart/form-data">
		<table>
				<colgroup>
					<col width="15%">
					<col width="85%">
				</colgroup>
				<tr>
					<th>작 성 자</th>
					<td><input type="text" name="email" value="${session_email}" readonly="readonly"></td> <!-- 세션에 저장된 이메일을 value에 -->
						<!-- 번호를 뿌릴곳이 없기 때문에 숨김으로 product_no를 view에서 받아옴 -->
						<input type="hidden" name="product_no" value="${product_no}"></td>
								
				</tr>
				
				<tr>
					<th>제   목</th>
					<td><input type="text" name="review_title"></td>
				</tr>
				<tr>
						<th scope="row"><span>평가</span></th>
						<td>
							<ul class="pta">
							<div id="star2">
								<li>
									<label for="starFive" class="star">
									<input type="radio" name="review_ratings" id="starFive" value="5" checked="checked"/>
									<c:forEach begin="1" end="5">
										<img src="../images/product_images/ico_star.gif" alt="별점" />
									</c:forEach>
									
									<input type="radio" name="review_ratings" id="starFour" value="4"/>
									<c:forEach begin="1" end="4">
										<img src="../images/product_images/ico_star.gif" alt="별점" />
									</c:forEach>
									
									<input type="radio" name="review_ratings" id="starThree" value="3"/>
									<c:forEach begin="1" end="3">
										<img src="../images/product_images/ico_star.gif" alt="별점" />
									</c:forEach>
									
									<input type="radio" name="review_ratings" id="starTwo" value="2"/>
									<c:forEach begin="1" end="2">
										<img src="../images/product_images/ico_star.gif" alt="별점" />
									</c:forEach>

									<input type="radio" name="review_ratings" id="starOne" value="1"/>
										<img src="../images/product_images/ico_star.gif" alt="별점" />
									</label>
								</li>

								
								</div>
							</ul>
						</td>
					</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="review_content" cols="50" rows="10"></textarea>
					</td>
				</tr>
				<tr>
					<th>이미지 표시</th>
					<td><input type="file" name="file" id="file"></td>
				</tr>
			</table>
			<hr>
			<div class="button-wrapper">
				<input type="button" class="write" value="작성완료" onclick="checkfield()">
				<input type="button" class="cancel" onclick="history.back(-1);" value="취소" >
			</div>
		</form>

	</section>

</body>
<script>
/* 유효성검사 */
function checkfield(){
 
	 if(document.reviewWrite.review_title.value==""){ 	//review_title값이 없을 경우
	 	alert("제목을 입력하세요");        	 			//메세지 경고창을 띄운 후
	 	document.reviewWrite.review_title.focus();     	// id 텍스트박스에 커서를 위치
	 	exit;
	 }else if(document.reviewWrite.review_content.value==""){
	 	alert("내용을 입력하세요");
	 	document.reviewWrite.review_content.focus();
	 	exit;
	 }
	 
 document.reviewWrite.submit();
}
</script>
</html>