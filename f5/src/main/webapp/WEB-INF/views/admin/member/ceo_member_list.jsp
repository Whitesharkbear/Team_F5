<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | CEO회원관리</title>
<link href="/f5/resources/css/admin/member/member_list.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$(".black_list").click(function(){
		
		if ( $(this).val() == "0" ) {
			
			$(this).css('background-color', 'orange').text("석방");
			$(this).val(1);
		} else {
			
			$(this).css('background-color', 'brown').text("추가");
			$(this).val(0);
		}
	});
	
	$(".closing").click(function(){
		
		if ( $(this).val() == "0" ) {
			
			$(this).css('background-color', 'brown').text("취소");
			$(this).val(1);
		} else {
			
			$(this).css('background-color', 'orange').text("승인");
			$(this).val(0);
		}
	});
});
</script>
</head>
<body>
	<jsp:include page="../header.jsp" />
		<div class="container">
			<div class="row">
				<div id="content">
					<h4>CEO회원관리</h4>
					<div class="register">
						<a href="ceo_member_insert.do"><button type="button" class="register_btn">CEO회원 추가</button></a>
					</div>
					<table id="member_table">
						<colgroup>
								<!-- 번호 -->
								<col width="10%">
								<!-- 이름 -->
								<col width="15%">
								<!-- 아이디 -->
								<col width="15%">
								<!-- 회원권한 -->
								<col width="15%">
								<!-- 블랙리스트 -->
								<col width="17%">
								<!-- 탈퇴 -->
								<col width="13%">
							</colgroup>
							<tr>
								<th>번호</th><th>이름</th><th>아이디</th><th>매장이름</th><th>블랙리스트</th><th>폐점신청</th>
							</tr>
							<% for ( int i = 1; i <= 10; i++ ) { %>
								<tr>
									<td><%= i %></td>
									<td>name<%= i %></td>
									<td><a href="ceo_member_content.do">id<%= i %></a></td>
									<td>
									<label>음식점<%= i %></label>
									</td>
									<td>
										<button value="0" class="black_list" id="black<%= i %>">승인</button>
									</td>
									<td>
										<button value="0" class="closing" id="store<%= i %>">승인</button>
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