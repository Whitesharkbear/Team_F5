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
				<div id="content">
					<h4>관리자 | 문의내역</h4>
					<div class="question_btn">
						<button>수정하기</button>
					</div>
					<table id="question_table">
					<colgroup>
							<!-- 선택 -->
							<col width="10%">
							<!-- 번호 -->
							<col width="10%">
							<!-- 문의자 id -->
							<col width="15%">
							<!-- 문의제목 -->
							<col width="20%">
							<!-- 문의내용 -->
							<col width="35%">
							<!-- 답변여부 -->
							<col width="10%">
						</colgroup>
						<tr>
							<th>선택</th><th>번호</th><th>문의자</th><th>문의제목</th><th>문의내용</th><th>답변여부</th>
						</tr>
						<% for ( int i = 10; i >= 0; i-- ) { %>
						<tr>
							<td><input type="checkbox"></td>
							<td><%= i %></td>
							<td><a href="member_content.do">user<%= i %></a></td>
							<td>문의<%= i %></td>
							<td><a href="question_content.do">문의내용<%= i %></a></td>
							<td>
								<select>
									<option value="0" selected="selected">대기중
									<option value="1">답변중
									<option value="2">답변완료
								</select>
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
			</section>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>