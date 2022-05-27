<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gangnam Foodly</title>

<link href="/f5/resources/css/board/board_update.css" rel="stylesheet" />
<link href="/f5/resources/css/head_nav.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script src="/f5/resources/js/board/board.js"></script>

<script>
	
	$(document).ready(function() {
		$(".board_write").click(function() {
			var test = "${vo.boardTitle}";
			update_form.submit();
		});
		$(".board_list").click(function(){
			location.href=("board_content.do?boardIdx=${vo.boardIdx}");
		});
	});

</script>

</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="head-nav-container">
		<label class="head-nav-title">Free Board</label>
		<div class="head-nav-inner">
			<ul class="nav-col-ul">
				<li><a href="board_list.do">자유게시판</a></li>
				<li><a href="promote_list.do">홍보</a></li>
				<li><a href="#"></a></li>
				<li><a href="#"></a></li>
				<li><a href="#"></a></li>
			</ul>
		</div>

	</div>
	<!-- Page content-->
	<div class="container">
		<div class="row">
			<div class="content">
				<h4>게시글 수정</h4>
				<form name="update_form" action="board_update.do" method="post">
					<input type="hidden" name="boardIdx" value="${vo.boardIdx}">
					<table class="board_table">
						<tr>
							<td><label>제목</label></td>
						</tr>
						<tr>
							<td><input type="text" id="board_title" name="boardTitle"
								value="${vo.boardTitle }"></td>
						</tr>
						<tr>
							<td><label>내용</label></td>
						</tr>
						<tr>
							<td><textarea rows="10" id="board_content"
									name="boardContent">${vo.boardContent }</textarea></td>
						</tr>
						<tr>
							<td><label>파일첨부</label></td>
						</tr>
						<tr>
							<td><input type="file" id="file"></td>
						</tr>
					</table>
					<div class="board_btn">
						<button type="button" class="board_write">수정완료</button>
						<button type="button" class="board_list">목록</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- Footer-->
	<jsp:include page="../footer.jsp"></jsp:include>
	<!-- Bootstrap core JS-->
	<!--          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> -->
	<!-- Core theme JS-->

</body>
</html>