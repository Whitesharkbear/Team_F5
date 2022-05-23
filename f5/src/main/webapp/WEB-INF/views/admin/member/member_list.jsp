<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 일반회원관리</title>
<link href="/f5/resources/css/admin/member/member_list.css" rel="stylesheet" />
<link rel="stylesheet" href="http://localhost:9000/f5/resources/css/am-pagination.css">
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/f5/resources/js/am-pagination.js"></script>
<script type="text/javascript">

function search() {
	
	var search = $("#searchbar").val();
	
	if ( search == "" ) {
		
		alert("검색할 사용자를 입력해주세요.");
		$("#searchbar").focus();
	} else {
		
		location.href="http://localhost:9000/f5/admin/member_search_list.do?search="+search;
	}
}

$(document).ready(function(){
	
// 	$(".black_list").click(function(){
		
// 		if ( $(this).val() == "0" ) {
			
// 			$(this).css('background-color', 'orange').text("석방");
// 			$(this).val(1);
// 		} else {
			
// 			$(this).css('background-color', 'brown').text("추가");
// 			$(this).val(0);
// 		}
// 	});
	
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
           $(location).attr('href', "http://localhost:9000/f5/admin/member_list.do?rpage="+e.page);         
    });
});
</script>
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
								<c:forEach var="vo" items="${ list }">
								<tr>
									<td>${ vo.rno }</td>
									<td>${ vo.memberName }</td>
									<td><a href="member_content.do?id=${ vo.memberId }&rno=${ vo.rno}">${ vo.memberId }</a></td>
									<td>${ vo.memberBirth }</td>
									<td>
									<label>일반회원</label>
									</td>
									<td>
										<button value="0" class="black_list">추가</button>
									</td>
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
			</div>
		</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>