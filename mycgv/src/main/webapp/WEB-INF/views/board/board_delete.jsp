<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/mycgv/resources/css/mycgv.css">
</head>
<body>
	<!--  header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="board_delete">
			<h1 class="title">게시판</h1>
			<div class="content_layout">
				<h3>정말로 삭제하시겠습니까?</h3>
				<img src="http://localhost:9000/mycgv/resources/images/delete.jpg">
				<form name="delForm" action="board_delete.do" method="post">
					<div>
						<input type="hidden" name="bid" value="${bid}">
						<button type="submit" class="btn_style2">삭제완료</button>
						<a href="board_content.do?bid=${bid}&rno=${rno}"><button type="button" class="btn_style2">이전페이지</button></a>
						<a href="board_list.do"><button type="button" class="btn_style2">리스트</button></a>
					</div>
				</form>
			</div>
		</section>
		
	</div>
	
	<!--  footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>