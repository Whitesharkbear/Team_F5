<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/f5/resources/css/store/store.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/f5/resources/js/am-pagination.js"></script>
<link rel="stylesheet" href="http://localhost:9000/f5/resources/css/am-pagination.css">
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
	           $(location).attr('href', "http://localhost:9000/f5/store.do?rpage="+e.page);         
	    });
		
 	});
</script> 
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="row store_content">
                        <div class="col-lg-6">
                            <!-- Blog post-->
                            <c:forEach var="vo"  items="${list}">
                            <c:choose>
                            <c:when test="${vo.rno % 4 == 1 || vo.rno % 4 == 3}">
	                            <div class="store-card mb-4">
	                                <a href="#!"><img class="card-img-top" src="/f5/resources/images/sample1.jpg" alt="..." /></a>
	                                <div class="card-body">
	                                    <h2 class="card-title h4">${vo.storeName }</h2>
	                                    <p class="card-text">${vo.storePlace }</p>
	                                    <a class="btn btn-primary" href="store_information.do?storeIdx=${vo.storeIdx }">매장 보러가기 →</a>
	                                </div>
	                            </div>
	                        </c:when>
                            </c:choose>
                            </c:forEach>
                        </div>
                        <div class="col-lg-6">
                            <!-- Blog post-->
                            <c:forEach var="vo"  items="${list}">
                            <c:choose>
                            <c:when test="${vo.rno % 4 == 2 || vo.rno % 4 == 0}">
                            <div class="store-card mb-4">
                                <a href="#!"><img class="card-img-top" src="/f5/resources/images/sample3.jpg" alt="..." /></a>
                                <div class="card-body">
                                    <h2 class="card-title h4">${vo.storeName }</h2>
                                    <p class="card-text">${vo.storePlace }</p>
                                    <a class="btn btn-primary" href="store_information.do?storeIdx=${vo.storeIdx }">매장 보러가기 →</a>
                                </div>
                            </div>
	                        </c:when>
                            </c:choose>                           
                            </c:forEach>
                        </div>
                    </div>
                    <!-- Pagination-->
	               <table>
	                <tr>
						<td colspan="4"><div id="ampaginationsm"></div></td>					
					</tr>
					</table>
                </div>
                <!-- Side widgets-->
                <div class="col-lg-4">
                    <!-- Search widget-->
                    <div class="card mb-4">
                        <div class="card-header">Search</div>
                        <div class="card-body">
							
                    <!-- Categories widget-->
                    <div class="card mb-4">
                        <div class="card-header">Categories</div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-6">
                                    <ul class="list-unstyled mb-0">
                                        <li><a href="#!">#중국집</a></li>
                                        <li><a href="#!">#일식집</a></li>
                                        <li><a href="#!">#치킨집</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-6">
                                    <ul class="list-unstyled mb-0">
                                        <li><a href="#!">#분식집</a></li>
                                        <li><a href="#!">#돈까스집</a></li>
                                        <li><a href="#!">#한식집</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Side widget-->
                    <div class="card mb-4">
                        <div class="card-header">이런 검색어는 어떄요?</div>
                       <div class = "card-body"> 
                       <a><img class = "store-side-img" src = "/f5/resources/images/storesample2.jpeg"></a></div>
                        <div class="card-body">
                        	<div><a href = "#">짜장면 맛집 모아보기!</a></div>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>

