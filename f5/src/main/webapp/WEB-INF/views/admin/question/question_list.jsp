<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 문의관리</title>
<link href="/f5/resources/css/admin/question/question_list.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container">
		<div class="row">
			<section>
				<div id="content1">
					<h4>관리자 | 문의내역</h4>
					<div class="question_btn">
					</div>
					<table id="question_table" border="1">
					<colgroup>
							<!-- 번호 -->
							<col width="10%">
							<!-- 문의자 id -->
							<col width="15%">
							<!-- 문의제목 -->
							<col width="25%">
							<!-- 문의내용 -->
							<col width="35%">
							<!-- 답변여부 -->
							<col width="15%">
						</colgroup>
						<tr>
							<th>번호</th><th>문의자 id</th><th>문의제목</th><th>문의내용</th><th>답변여부</th>
						</tr>
						<% for ( int i = 10; i >= 0; i-- ) { %>
						<tr>
							<td><%= i %></td>
							<td>user<%= i %></td>
							<td>문의<%= i %></td>
							<td><a href="question_content.do">문의내용<%= i %></a></td>
							<td>접수중</td>
						</tr>
						<% } %>
					</table>
				</div>
			</section>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>