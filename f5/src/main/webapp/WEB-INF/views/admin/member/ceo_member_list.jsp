<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | CEO회원관리</title>
<link href="/f5/resources/css/admin/member/member_list.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
		<div class="container">
			<div class="row">
				<div class="content1">
					<h1>CEO회원관리</h1>
					<table>
						<colgroup>
								<!-- 번호 -->
								<col width="10%">
								<!-- 이름 -->
								<col width="15%">
								<!-- 아이디 -->
								<col width="15%">
								<!-- 생년월일 -->
								<col width="15%">
								<!-- 회원권한 -->
								<col width="15%">
								<!-- 탈퇴 -->
								<col width="15%">
								<!-- 탈퇴 -->
								<col width="10%">
							</colgroup>
							<tr>
								<th>번호</th><th>이름</th><th>아이디</th><th>생년월일</th><th>회원권한</th><th>탈퇴</th><th>폐점신청</th>
							</tr>
							<% for ( int i = 1; i <= 10; i++ ) { %>
								<tr>
									<td><%= i %></td>
									<td>name<%= i %></td>
									<td>id<%= i %></td>
									<td>2022-01-01</td>
									<td>
									<!-- 
										<select class="auth">
											<option value="0" selected="selected">일반회원</option>
											<option value="1">CEO</option>
											<option value="2">관리자</option>
										</select>
									-->
									<label>CEO회원</label>
									</td>
									<td>
										<button value="0">승인</button>
									</td>
									<td>
										<button value="0">승인</button>
									</td>
								</tr>
							<% } %>
							<tr>
								<td colspan="7"><div class="paging"><< 1  2  3  4  5 >></div></td>
							</tr>
					</table>
				</div>
			</div>
		</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>