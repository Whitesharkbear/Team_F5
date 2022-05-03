<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 일반회원관리</title>
<link href="/f5/resources/css/admin/member/member_list.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
		<div class="container">
			<div class="row">
				<div id="content">
					<h4>일반회원관리</h4>
					<div class="register">
						<a href="member_insert.do"><button type="button" class="register_btn">일반회원 추가</button></a>
					</div>
					<table id="member_table">
						<colgroup>
								<!-- 번호 -->
								<col width="10%">
								<!-- 이름 -->
								<col width="15%">
								<!-- 아이디 -->
								<col width="15%">
								<!-- 생년월일 -->
								<col width="20%">
								<!-- 회원권한 -->
								<col width="20%">
								<!-- 탈퇴 -->
								<col width="15%">
							</colgroup>
							<tr>
								<th>번호</th><th>이름</th><th>아이디</th><th>생년월일</th><th>회원권한</th><th>블랙리스트</th>
							</tr>
							<% for ( int i = 1; i <= 10; i++ ) { %>
								<tr>
									<td><%= i %></td>
									<td>name<%= i %></td>
									<td><a href="member_content.do">id<%= i %></a></td>
									<td>2022-01-01</td>
									<td>
									<!-- 
										<select class="auth">
											<option value="0" selected="selected">일반회원</option>
											<option value="1">CEO</option>
											<option value="2">관리자</option>
										</select>
									-->
									<label>일반회원</label>
									</td>
									<td>
										<button value="0" class="black_list">추가</button>
									</td>
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
			</div>
		</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>