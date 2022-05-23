<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 일반회원 상세페이지</title>
<link href="/f5/resources/css/admin/member/member_content.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
		<div class="container">
			<div class="row">
				<div id="content">
					<h4>관리자 | CEO회원 상세페이지</h4>
					<table id="content_table">
						<tr>
							<td>아이디</td>
						</tr>
						<tr>
							<td>
								<input type="text" id="id"
								placeholder="  아이디를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='  아이디를 입력해주세요.'">
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
						</tr>
						<tr>
							<td>
								<input type="text" id="pw"
								placeholder="  비밀번호를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='  비밀번호를 입력해주세요.'">
							</td>
						</tr>
						<tr>
							<td>비밀번호 재확인</td>
						</tr>
						<tr>
							<td>
								<input type="text" id="pwChk"
								placeholder="  제목을 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='  제목을 입력해주세요.'">
							</td>
						</tr>
						<tr>
							<td>이름</td>
						</tr>
						<tr>
							<td>
								<input type="text" id="name">
							</td>
						</tr>
						<tr>
							<td>생년월일</td>
						</tr>
						<tr>
							<td>
								<input type="text" id="year">
								<select id="month">
									<option value="0">월</option>
								<% for ( int i = 1; i <= 12; i++ ) { %>
									<option value="<%= i %>"><%= i %></option>
								<% } %>
								</select>
								<select id="day">
									<option value="0">일</option>
								<% for ( int i = 1; i <= 31; i++ ) { %>
									<option value="<%= i %>"><%= i %></option>
								<% } %>
								</select>
							</td>
						</tr>
						<tr>
							<td>성별</td>
						</tr>
						<tr>
							<td>
								<select id="gender">
									<option value="0" selected="selected">성별을 선택하세요</option>
									<option value="1">남자</option>
									<option value="2">여자</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>본인확인 이메일(선택)</td>
						</tr>
						<tr>
							<td><input type="text" id="email"></td>
						</tr>
						<tr>
							<td>휴대전화</td>
						</tr>
						<tr>
							<td><input type="text" id="tel"></td>
						</tr>
						<tr>
							<td>주소</td>
						</tr>
						<tr>
							<td><input type="text" id="address"></td>
						</tr>
					</table>
					<div class="table_btn">
						<button type="button" class="update">수정</button>
						<a href="ceo_member_list.do"><button type="button" class="list">목록</button></a>
					</div>
				</div>
			</div>
		</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>