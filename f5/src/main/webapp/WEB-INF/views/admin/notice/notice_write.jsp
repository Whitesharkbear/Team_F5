<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 공지등록</title>
<link href="/f5/resources/css/admin/notice/notice_write.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function update() {
	
	var title = $("#notice_title").val();
	var content = $("#notice_content").val();
	
	if ( title == "" ) {
		
		alert("제목을 입력해주세요.");
		$("#notice_title").focus();
	} else if ( content == "" ) {
		
		alert("내용을 입력해주세요.");
		$("#notice_content").focus();
	} else {
		
		submit();
	}
}

function list() {
	location.href="notice_list.do";
}
</script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container">
		<div class="row">
			<div id="content">
				<h4>공지사항 관리 | 공지사항 등록</h4>
<!-- 				<form action="#" method="get" enctype="multipart/form-data"> -->
				<table class="notice_table">
					<tr>
						<td><label>제목</label></td>
					</tr>
					<tr>
						<td><input type="text" id="notice_title"></td>
					</tr>
					<tr>
						<td><label>내용</label></td>
					</tr>
					<tr>
						<td><textarea rows="10" id="notice_content"></textarea></td>
					</tr>
					<tr>
						<td><label>파일첨부</label></td>
					</tr>
					<tr>
						<td><input type="file" id="file"></td>
					</tr>
				</table>
				<div class="notice_btn">
					<button class="notice_register" onclick="register()">등록</button>
					<button class="notice_list" onclick="list()">목록</button>
				</div>
<!-- 				</form> -->
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>