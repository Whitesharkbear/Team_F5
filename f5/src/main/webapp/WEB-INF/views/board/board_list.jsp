<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/f5/resources/css/board/board.css" rel="stylesheet" />
<link href="/f5/resources/css/head_nav.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="head-nav-container">
		<label class="head-nav-title">Free Board</label>
		<div class="head-nav-inner">
			<ul class="nav-col-ul">
				<li><a href="board_list.do">자유게시판</a></li>
				<li><a href="promote_list.do">홍보</a></li>
				<li><a href="#"></a></li>
				<li><a href="#"></a></li>
				<li><a href="#"></a></li>
			</ul>
		</div>
	</div>
	<!-- Page content-->
        <div class="container">
        
            <div class="row">
            	<div class="board_container">
            	<label class="board-caption">Fooldey의 대나무 숲</label>
            		<table class="table list-table">
	            	
            			<tr>
            				<th scope="col" colspan="4"></th>
            				<th width="10%" scope="col">
            				<a href="board_write.do">	
            					<button class="cusbtn btn-board_write" type="button" onclick="board_wirte()">글쓰기</button>
            				</a>	
            				</th>
            			</tr>
            			<tr class="tr-sec1">
            				<th class="board-table-col1">순번</th>
            				<th class="board-table-col2">제목</th>
            				<th class="board-table-col3">작성자</th>
            				<th class="board-table-col4">no</th>
            				<th class="board-table-col5">작성일</th>
            			</tr>
            			
            			<c:forEach var="vo" items="${list}">
            			<tr class="tr-sec">
            				<td class="board-table-col1"><span class="asd">${vo.rno}</span></td>
            				<td class="board-table-col2"><a href="board_content.do?boardIdx=${vo.boardIdx}">${vo.boardTitle}</a></td>
            				<td class="board-table-col3">${vo.memberId}</td>
            				<td class="board-table-col4">${vo.boardHits}</td>
            				<td class="board-table-col5">${vo.boardDate}</td>
            			</tr>
            			</c:forEach>
            			
            			<tr>
            				<td colspan=5>
            					<input type="search" class="search">
            					<button class="cusbtn">검색</button>
            				</td>
            			</tr>
            			<tr>
            				<td colspan=5><<1 2 3 4 5>></td>
            			<tr>
            		</table>
            	</div>
            </div>
        </div>
        <!-- Footer-->
	<jsp:include page="../footer.jsp"></jsp:include>
        <!-- Bootstrap core JS-->
<!--          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> -->
        <!-- Core theme JS-->

</body>
</html>