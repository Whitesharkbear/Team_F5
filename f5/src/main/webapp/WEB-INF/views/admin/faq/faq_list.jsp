<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 자주찾는질문</title>
<link href="/f5/resources/css/admin/faq/faq_list.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
		<div class="container">
			<div class="row">
				<div id="content">
				<h4>관리자 | FAQ관리</h4>
					<div class="faq_write">
						<a href="faq_write.do">
							<button type="button" class="faq_write_btn">등록</button>
						</a>
					</div>
					<div id="faqList">
						<% for ( int i = 10; i > 0; i-- ) { %>
						<details>
							<summary>질문 <%= i %></summary>
							<p><span>답변 <%= i %></span></p>
							<div class="faq_btn">
								<a href="faq_update.do">
									<button type="button" class="update">수정</button>
								</a>
								<a href="faq_delete.do">
									<button type="button" class="delete">삭제</button>
								</a>
							</div>
						</details>
						<% } %>
					</div>
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