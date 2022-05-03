<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 자유게시글 상세</title>
<link href="/f5/resources/css/admin/board/board_content.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function write() {
	location.href="board_write.do";
}

function list() {
	location.href="board_list.do";
}
</script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container">
		<div class="row">
			<div id="content">
				<h4>자유게시판 관리 | 상세페이지</h4>
<!-- 				<form action="board_write.do" method="get" enctype="multipart/form-data"> -->
				<table class="board_table">
					<tr>
						<td><label>제목</label></td>
					</tr>
					<tr>
						<td><input type="text" id="board_title"></td>
					</tr>
					<tr>
						<td><label>보낸사람</label></td>
					</tr>
					<tr>
						<td><input type="text" id="sender"></td>
					</tr>
					<tr>
						<td><label>내용</label></td>
					</tr>
					<tr>
						<td><textarea rows="10" id="board_content"></textarea></td>
					</tr>
					<tr>
						<td><label>파일첨부</label></td>
					</tr>
					<tr>
						<td><input type="file" id="file"></td>
					</tr>
				</table>
				<div class="board_btn">
					<button class="board_delete" onclick="del()">삭제하기</button>
					<button class="board_list" onclick="list()">목록</button>
				</div>
<!-- 				</form> -->
				<div class="comment">
					<div class="comment_info">
						<label>등록</label>
						<button type="button" class="comment_enter">등록</button>
						<textarea rows="3" id="comment_area"></textarea>
					</div>
					<ul>
					<% for ( int i = 1; i <= 10; i++ ) { %>
						<li>
							<div class="comment_btn">
								<button class="comment_update">수정</button>
								<button class="comment_delete">삭제</button>
							</div>
							<label>user<%= i %></label>
							<textarea rows="3" cols="">댓글<%= i %></textarea>
						</li>
					<% } %>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>