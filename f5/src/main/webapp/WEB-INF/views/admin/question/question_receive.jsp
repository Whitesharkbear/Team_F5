<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 문의상세</title>
<link href="/f5/resources/css/admin/question/question_receive.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function send() {
	
	var title = $("#question_title").val();
	var receiver = $("#receiver").val();
	var content = $("#question_content").val();
	
	if ( title == "" ) {
		
		alert("제목을 입력해주세요.");
		$("#question_title").focus();
	} else if ( receiver == "" ) {
		
		alert("받는사람 정보를 입력해주세요.");
		$("#receiver").focus();
	} else if ( content == "" ) {
		
		alert("답변 내용을 입력해주세요.");
		$("#question_content").focus();
	} else {
		
		submit();
	}
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
				<h4>문의관리 | 문의답변</h4>
<!-- 				<form action="#" method="get" enctype="multipart/form-data"> -->
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
						<td>받는사람</td>
						<td><input type="text" id="receiver"></td>
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
					<button class="question_update" onclick="send()">보내기</button>
					<button class="question_list" onclick="list()">목록</button>
				</div>
<!-- 				</form> -->
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>