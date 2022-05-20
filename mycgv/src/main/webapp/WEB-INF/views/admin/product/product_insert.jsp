<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/mycgv/resources/css/mycgv.css">
<script src="http://localhost:9000/mycgv/resources/js/mycgv_javascript.js"></script>
</head>
<body>
	<!--  header -->
	<jsp:include page="../../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="board_write">
			<h1 class="title">관리자 - 상품등록</h1>
			<form name="notice_write" action="product_insert.do" method="post" enctype="multipart/form-data">
				<table class="content_layout">
					<tr>
						<th>카테고리</th>
						<td>
							<select name="pcategory">
								<option value="스킨">스킨</option>
								<option value="로션">로션</option>
								<option value="올인원">올인원</option>
								<option value="에센스">에센스</option>
								<option value="크림">크림</option>								
							</select>
						</td>
					</tr>
					<tr>
						<th>상품명</th>
						<td><input type="text" name="pname"></td>
					</tr>
					<tr>
						<th>상품가격</th>
						<td><input type="text" name="price"></td>
					</tr>
					<tr>
						<th>상품정보</th>
						<td><textarea name="pinfo"></textarea></td>
					</tr>
					<tr>
						<th>상품이미지</th>
						<td>
							<input type="file" name="files">
							<input type="file" name="files">
							<input type="file" name="files">
							<input type="file" name="files">
							<input type="file" name="files">							
						</td>
					</tr>
					<tr>					
						<td colspan="2">
							<button type="submit" class="btn_style2" >저장</button>
							<button type="reset" class="btn_style2">취소</button>
							<a href="notice_list.do"><button type="button" class="btn_style2">리스트</button></a>
							<a href="http://localhost:9000/mycgv/index.do"><button type="button" class="btn_style2">홈으로</button></a>
						</td>
					</tr>
				</table>
			</form>
		</section>
		
	</div>
	
	<!--  footer -->
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>