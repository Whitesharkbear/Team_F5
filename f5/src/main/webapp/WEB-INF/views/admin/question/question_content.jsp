<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 문의상세</title>
<link href="/f5/resources/css/admin/question/question_content.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function receive() {
	location.href="question_receive.do";
}

function list() {
	location.href="question_list.do";
}
</script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container">
		<div class="row">
			<div id="content">
				<h4>문의관리 | 상세페이지</h4>
<!-- 				<form action="question_receive.do" method="get" enctype="multipart/form-data"> -->
				<table class="question_table">
				<colgroup>
					<col width="20%">
					<col width="80%">
				</colgroup>
					<tr>
						<td>제목</td>
						<td><input type="text" id="question_title"></td>
					</tr>
					<tr>
						<td>보낸사람</td>
						<td><input type="text" id="sender"></td>
					</tr>
					<tr>
						<td colspan="2">내용</td>
					</tr>
					<tr>
						<td colspan="2"><textarea rows="10" id="question_content"></textarea></td>
					</tr>
					<tr>
						<td>파일첨부</td>
						<td><input type="file" id="file"></td>
					</tr>
				</table>
				<div class="question_btn">
					<button class="question_update" onclick="receive()">답장하기</button>
					<button class="question_list" onclick="list()">목록</button>
				</div>
<!-- 				</form> -->
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>