<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gangnam Foodly | 자주찾는질문</title>
<link href="/f5/resources/css/admin/faq/faq_list.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function search() {
	
	var search = $("#searchbar").val();
	
	if ( search == "" ) {
		
		alert("검색어를 입력해주세요");
	} else {
		
		alert("검색하신 " + search + " 결과입니다.");
	}
}

function update() {
	
	location.href="faq_update.do";
}

function del() {
	
	if ( confirm("삭제하시겠습니까?") ) {
		
		alert("삭제되었습니다.");
		location.href="faq_list.do";
	} else {
		
		return;
	}
}
</script>
</head>
<body>
	<jsp:include page="../header.jsp" />
		<div class="container">
			<div class="row">
				<div id="content">
				<h4>foodly | FAQ관리</h4>
					<div id="faqList">
					<c:forEach var="vo" items="${ list }">
						<details>
							<summary>${ vo.faqTitle }</summary>
							<p><span>${ vo.faqContent }</span></p>
						</details>
					</c:forEach>
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