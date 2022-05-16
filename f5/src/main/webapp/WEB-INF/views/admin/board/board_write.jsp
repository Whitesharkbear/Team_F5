<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 게시글상세</title>
<link href="/f5/resources/css/admin/board/board_write.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function write() {
	
	var title = $("#board_title").val();
	var content = $("#board_content").val();
	
	if ( title == "" ) {
		
		alert("제목을 입력해주세요.");
		$("#board_title").focus();
	} else if ( content == "" ) {
		
		alert("내용을 입력해주세요.");
		$("#board_content").focus();
	} else {
		
		boardWrite.submit();
	}
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
				<h4>게시판관리 | 게시글 등록</h4>
				<form action="board_write.do" method="post" name="boardWrite">
				<table class="board_table">
					<tr>
						<td><label>제목</label></td>
					</tr>
					<tr>
						<td><input type="text" id="board_title" name="boardTitle"></td>
					</tr>
					<tr>
						<td><label>내용</label></td>
					</tr>
					<tr>
						<td><textarea rows="10" id="board_content" name="boardContent"></textarea></td>
					</tr>
					<tr>
						<td><label>파일첨부</label></td>
					</tr>
					<tr>
						<td><input type="file" id="file"></td>
					</tr>
				</table>
				<div class="board_btn">
					<button class="board_write" onclick="write()">수정</button>
					<button class="board_list" onclick="list()">목록</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>