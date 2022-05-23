<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 자주찾는질문</title>
<link href="/f5/resources/css/admin/faq/faq_list.css" rel="stylesheet" />
<link rel="stylesheet" href="http://localhost:9000/f5/resources/css/am-pagination.css">
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/f5/resources/js/am-pagination.js"></script>
<script type="text/javascript">
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
           $(location).attr('href', "http://localhost:9000/f5/admin/faq_list.do?rpage="+e.page);         
    });
	
	var search = $("#searchbar").val();
	var rpage = jQuery('#ampaginationsm').on('am.pagination.change',function(e){
		   jQuery('.showlabelsm').text('The selected page no: '+e.page);
           $(location).attr('href', "http://localhost:9000/f5/admin/faq_list.do?search="+search+"&rpage="+e.page);         
    });
	$("#searchbar").keydown(function(key) {
		
		if( key.keyCode == 13 ){
			
				location.href="faq_list.do?search=" + search + "&rpage=" + rpage;
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
				<h4>관리자 | FAQ관리</h4>
					<div class="faq_write">
						<a href="faq_write.do">
							<button type="button" class="faq_write_btn">등록</button>
						</a>
					</div>
					<div id="faqList">
						<c:forEach var="vo" items="${ list }">
							<details>
							<summary>${ vo.faqTitle }</summary>
							<p><span>${ vo.faqContent }</span></p>
							<div class="faq_btn">
								<a href="faq_update.do?idx=${ vo.faqIdx }&rno=${ vo.rno }"><button type="button" class="update">수정</button></a>
								<a href="faq_delete.do?idx=${ vo.faqIdx }&rno=${ vo.rno }"><button type="button" class="delete">삭제</button></a>
							</div>
						</details>
						</c:forEach>
					</div>
					<div class="search">
						<div class="search_text">
							<input type="text" id="searchbar" name="search"
							placeholder="  검색어를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='  검색어를 입력해주세요.'">
							<button type="button" class="search_btn">검색</button>
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