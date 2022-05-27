<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/f5/resources/css/board/promote.css" rel="stylesheet" />
<link href="/f5/resources/css/head_nav.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="../../header.jsp"></jsp:include>
	<div class="head-nav-container">
		<label class="head-nav-title">Promote</label>
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
            	<label class="board-caption">Foodly의 자랑거리</label>
				<div style="text-align: right; margin-bottom: 50px;">
					<a href="promote_write.do">
						<button class="cusbtn btn-promote-write" type="button">글쓰기</button>
					</a>
				</div>
				<div class="promote-list-container">
					<ul>
						<c:forEach var="vo" items="${list}">
							<li>
								<div class="promote-list">
									<div class="promote-top">
										<div class="centered">
											<img class="promote-img"
												src="/f5/resources/images/상점.jpeg">
										</div>
										<p>${vo.boardTitle }</p>
									</div>
									<div class="promote-bottom">
										<p>${vo.boardContent }</p>
									</div>
										<div class="promote-link">
											<a href="promote_update.do?boardIdx=${vo.boardIdx }">수정하기</a>
											<a style="text-decoration : line-through" href="store_information.do"> 놀러가기 </a>
										</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<br>
				<!-- Pagination-->
			<nav aria-label="Pagination">
				<hr class="my-0" />
				<ul class="pagination justify-content-center my-4">
					<li class="page-item disabled"><a class="page-link" href="#"
						tabindex="-1" aria-disabled="true">Newer</a></li>
					<li class="page-item active" aria-current="page"><a
						class="page-link" href="#!">1</a></li>
					<li class="page-item"><a class="page-link" href="#!">2</a></li>
					<li class="page-item"><a class="page-link" href="#!">3</a></li>
					<li class="page-item disabled"><a class="page-link" href="#!">...</a></li>
					<li class="page-item"><a class="page-link" href="#!">15</a></li>
					<li class="page-item"><a class="page-link" href="#!">Older</a></li>
				</ul>
			</nav>
				<br>
			</div>
            </div>
        </div>
        <!-- Footer-->
	<jsp:include page="../../footer.jsp"></jsp:include><br>
        <!-- Bootstrap core JS-->
<!--          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> -->
        <!-- Core theme JS-->

</body>
</html>