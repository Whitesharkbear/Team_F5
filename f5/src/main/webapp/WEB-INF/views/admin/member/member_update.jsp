<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 일반회원 수정</title>
<link href="/f5/resources/css/admin/member/member_update.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
		<div class="container">
			<div class="row">
				<div id="content">
					<h4>관리자 | 일반회원 수정</h4>
					<table id="member_update_table">
						<tr>
							<td><label>아이디</label></td>
						</tr>
						<tr>
							<td>
								<input type="text" id="id"
								placeholder="  아이디를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='  아이디를 입력해주세요.'">
							</td>
						</tr>
						<tr>
							<td><label>비밀번호</label></td>
						</tr>
						<tr>
							<td>
								<input type="text" id="pw"
								placeholder="  비밀번호를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='  비밀번호를 입력해주세요.'">
							</td>
						</tr>
						<tr>
							<td><label>비밀번호 재확인</label></td>
						</tr>
						<tr>
							<td>
								<input type="text" id="pwChk">
							</td>
						</tr>
						<tr>
							<td><label>이름</label></td>
						</tr>
						<tr>
							<td>
								<input type="text" id="name">
							</td>
						</tr>
						<tr>
							<td><label>생년월일</label></td>
						</tr>
						<tr>
							<td>
								<input type="text" id="year">
								<select id="month">
									<option value="0">월</option>
								<% for ( int i = 1; i < 13; i++ ) { %>
									<option value="<%= i %>"><%= i %>월</option>
								<% } %>
								</select>
								<select id="day">
									<option value="0">일</option>
								<% for ( int i = 1; i <= 31; i++ ) { %>
									<option value="<%= i %>"><%= i %>일</option>
								<% } %>
								</select>
							</td>
						</tr>
						<tr>
							<td><label>성별</label></td>
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
							<td><label>본인확인 이메일(선택)</label></td>
						</tr>
						<tr>
							<td><input type="text" id="email"></td>
						</tr>
						<tr>
							<td><label>휴대전화</label></td>
						</tr>
						<tr>
							<td><input type="text" id="tel"></td>
						</tr>
						<tr>
							<td><label>주소</label></td>
						</tr>
						<tr>
							<td><input type="text" id="address"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>