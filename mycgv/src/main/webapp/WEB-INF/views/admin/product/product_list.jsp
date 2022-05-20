<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/mycgv/resources/css/mycgv.css">
<link rel="stylesheet" href="http://localhost:9000/mycgv/resources/css/am-pagination.css">
<script src="http://localhost:9000/mycgv/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/mycgv/resources/js/am-pagination.js"></script>
<script>
	$(document).ready(function(){
		
		var pager = jQuery('#ampaginationsm').pagination({
		
		    maxSize: 7,	    		// max page size
		    totals: '${dbCount}',	// total pages	
		    page: '${reqPage}',		// initial page		
		    pageSize: '${pageSize}',			// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		
		});
		
		jQuery('#ampaginationsm').on('am.pagination.change',function(e){
			   jQuery('.showlabelsm').text('The selected page no: '+e.page);
	           $(location).attr('href', "http://localhost:9000/mycgv/admin/notice_list.do?rpage="+e.page);         
	    });
		
 	});
</script> 
</head>
<body>
	<!--  header -->
	<jsp:include page="../../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="notice_list">
			<h1 class="title">관리자 - 상품관리</h1>
			<table class="content_layout">
				<tr>
					<td colspan="4">
						<a href="product_insert.do"><button type="button">상품등록</button></a>
					</td>
				</tr>
				<tr>
					<th>번호</th>
					<th>상품명</th>	
					<th>가격</th>
					<th>등록일</th>
				</tr>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.rno }</td>
						<td><a href="product_content.do?pid=${vo.pid}">${vo.pname }</a></td>
						<td>${vo.price }</td>
						<td>${vo.pdate }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4"><div id="ampaginationsm"></div></td>					
				</tr>
			</table>
		</section>
		
	</div>
	
	<!--  footer -->
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>