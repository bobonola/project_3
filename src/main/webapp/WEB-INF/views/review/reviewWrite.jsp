<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<c:if test="${session_flag == null || session_flag == 'fail'}">
	<script type="text/javascript">
		alert("로그인을 하셔야 글을 쓸 수 있습니다.");
		location.href = "./login";
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

<script type="text/javascript">



</script>


</head>

<body>
	<section>
		<h1>구매후기 작성</h1>
		<hr>
		<!-- enctype="multipart/form-data" : 이걸 써줘야 파일이 업로드된다. 꼭 필요함! -->	
		<form action="./reviewWriteDo" name="reviewWrite" method="post" enctype="multipart/form-data">
			<input type="hidden" name="product_no" value="${product_no}">
			<table>
				<colgroup>
					<col width="15%">
					<col width="85%">
				</colgroup>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="email" value="${session_email}" readonly="readonly"></td> <!-- 세션에 저장된 이메일을 value에 -->
				</tr>
				<tr>
					<th>제목</th>
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
										<img src="../images/view_img/ico_star.gif" alt="별점" />
									</c:forEach>
									
									<input type="radio" name="review_ratings" id="starFour" value="4"/>
									<c:forEach begin="1" end="4">
										<img src="../images/view_img/ico_star.gif" alt="별점" />
									</c:forEach>
									
									<input type="radio" name="review_ratings" id="starThree" value="3"/>
									<c:forEach begin="1" end="3">
										<img src="../images/view_img/ico_star.gif" alt="별점" />
									</c:forEach>
									
									<input type="radio" name="review_ratings" id="starTwo" value="2"/>
									<c:forEach begin="1" end="2">
										<img src="../images/view_img/ico_star.gif" alt="별점" />
									</c:forEach>

									<input type="radio" name="review_ratings" id="starOne" value="1"/>
										<img src="../images/view_img/ico_star.gif" alt="별점" />
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
				<button type="submit" class="write">작성완료</button>
				<button type="button" class="cancel"
					onclick="javascript:location.href='view'">취소</button>
			</div>
		</form>

	</section>

</body>
</html>