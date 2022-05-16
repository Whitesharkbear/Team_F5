<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 공지사항 상세페이지</title>
<link href="/f5/resources/css/admin/notice/notice_content.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function del() {
	
	if ( confirm("공시글을 삭제하시겠습니까?") ) {
		
		alert("삭제되었습니다.");
		location.href="notice_list.do";
	} else {
		
		return;
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
				<h4>공지사항 관리 | 공지사항 상세페이지</h4>
				<table class="notice_table">
					<tr>
						<td><label>제목</label></td>
					</tr>
					<tr>
						<td><input type="text" id="notice_title" value="${ vo.boardTitle }" readonly="readonly"></td>
					</tr>
					<tr>
						<td><label>게시자</label></td>
					</tr>
					<tr>
						<td><input type="text" id="writer" value="${ vo.memberId }" readonly="readonly"></td>
					</tr>
					<tr>
						<td><label>내용</label></td>
					</tr>
					<tr>
						<td><textarea rows="10" id="notice_content" readonly="readonly">${ vo.boardContent }</textarea></td>
					</tr>
					<tr>
						<td><label>파일첨부</label></td>
					</tr>
					<tr>
						<td><input type="file" id="file" readonly="readonly"></td>
					</tr>
				</table>
				<div class="notice_btn">
					<a href="notice_update.do?idx=${ vo.boardIdx }&rno=${ rno }"><button class="notice_update">수정하기</button></a>
					<a href="notice_delete.do?idx=${ vo.boardIdx }"><button class="notice_delete">삭제하기</button></a>
					<button class="notice_list" onclick="list()">목록</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>