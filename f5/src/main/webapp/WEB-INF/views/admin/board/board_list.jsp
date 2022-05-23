<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 자유게시판 관리</title>
<link href="/f5/resources/css/admin/board/board_list.css" rel="stylesheet" />
<link rel="stylesheet" href="http://localhost:9000/f5/resources/css/am-pagination.css">
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/f5/resources/js/am-pagination.js"></script>

<script type="text/javascript">
function search() {
	
	var search = $("#searchbar").val();
	
	if ( search == "" ) {
		
		alert("검색어를 입력해주세요.");
		$("#searchbar").focus();
	} else {
		
		alert("검색하신 "+ search +" 결과입니다.");
	}
}
$(document).ready(function(){
	
	var pager = jQuery('#ampaginationsm').pagination({
		
	    maxSize: 7,	    		// max page size
	    totals: '${ dbCount }',	// total pages	
	    page: '${ reqPage }',		// initial page		
	    pageSize: '${ pageSize }',	// max number items per page
	
	    // custom labels		
	    lastText: '&raquo;&raquo;', 		
	    firstText: '&laquo;&laquo;',		
	    prevText: '&laquo;',		
	    nextText: '&raquo;',
			     
	    btnSize:'sm'	// 'sm'  or 'lg'		
	});
	
	jQuery('#ampaginationsm').on('am.pagination.change',function(e){
		   jQuery('.showlabelsm').text('The selected page no: '+e.page);
           $(location).attr('href', "http://localhost:9000/f5/admin/board_list.do?rpage="+e.page);         
    });
});
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
						<c:forEach var="vo" items="${ list }">
							<tr>
								<td>${ vo.rno }</td>
								<td>${ vo.memberId }</td>
								<td><a href="board_content.do?idx=${ vo.boardIdx }&rno=${ vo.rno }">${ vo.boardTitle }</a></td>
								<td>${ vo.boardDate }</td>
								<td>${ vo.boardHits }</td>
							</tr>
						</c:forEach>
					</table>
					<div class="search">
						<div class="search_text">
							<input type="text" id="searchbar" 
							placeholder="  검색어를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='  검색어를 입력해주세요.'">
							<button type="button" class="search_btn" onclick="search()">검색</button>
						</div>
					</div>
					<div class="paging">
						<div id="ampaginationsm"></div>
					</div>
				</div>
			</section>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>