<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 자유게시판 관리</title>
<link href="/f5/resources/css/admin/board/board_list.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container">
		<div class="row">
			<section>
				<div id="content">
					<h4>관리자 | 자유게시판 관리</h4>
					<div class="board_btn">
					</div>
					<table id="board_table">
					<colgroup>
							<!-- 번호 -->
							<col width="10%">
							<!-- 게시자 id -->
							<col width="15%">
							<!-- 게시글제목 -->
							<col width="25%">
							<!-- 게시 날짜 -->
							<col width="35%">
							<!-- 조회수 -->
							<col width="15%">
						</colgroup>
						<tr>
							<th>번호</th><th>게시자</th><th>제목</th><th>날짜</th><th>조회수</th>
						</tr>
						<% for ( int i = 10; i >= 0; i-- ) { %>
						<tr>
							<td><%= i %></td>
							<td><a href="member_content.do">user<%= i %></a></td>
							<td><a href="board_content.do">게시글제목<%= i %></a></td>
							<td>2022-04-29</td>
							<td><%= i %></td>
						</tr>
						<% } %>
					</table>
					<div class="search">
						<div class="search_text">
							<input type="text" id="searchbar" 
							placeholder="  검색어를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='  검색어를 입력해주세요.'">
							<button type="button" class="search_btn" onclick="search()">검색</button>
						</div>
					</div>
					<div class="paging">
						<div><< 1  2  3  4  5 >></div>
					</div>
				</div>
			</section>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>