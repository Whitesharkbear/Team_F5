<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/f5/resources/css/board/promote.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="../../header.jsp"></jsp:include>
        <!-- Page content-->
        <div class="container">
            <div class="row">
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
            	<div class="board_container">
            	<label class="board-caption">Fooldey의 대나무 숲</label>
				<div style="text-align: right">
					<button class="cusbtn btn-promote_write" type="button"
						onclick="board_wirte()">글쓰기</button>
				</div>
				<div class="promote-list-container">
					<ul>
						<li>
							<div class="promote-list">
								<div class="promote-top">
									<img class="promte-img" src="/f5/resources/images/person.png">
									<p>1</p>
								</div>
								<div>
									<p>삼겹살 사장님이 쏜다쏜다쏜다!
									<a>
										놀러가기
									</a>
								</div>
							</div>
						</li>
						<li>
							<div class="promote-list">
								<div class="promote-top">
									<img class="promte-img" src="/f5/resources/images/naver_logo.jpeg">
									<p>2</p>
								</div>
								<div>
									<p>삼겹살 사장님이 쏜다쏜다쏜다!
									<a>
										놀러가기
									</a>
								</div>
							</div>
						</li>
						<li>
							<div class="promote-list">
								<div class="promote-top">
									<img class="promte-img" src="/f5/resources/images/naver_logo.jpeg">
									<p>2</p>
								</div>
								<div>
									<p>삼겹살 사장님이 쏜다쏜다쏜다!
									<a>
										놀러가기
									</a>
								</div>
							</div>
						</li>
						<li>
							<div class="promote-list">
								<div class="promote-top">
									<img class="promte-img" src="/f5/resources/images/naver_logo.jpeg">
									<p>2</p>
								</div>
								<div>
									<p>삼겹살 사장님이 쏜다쏜다쏜다!
									<a>
										놀러가기
									</a>
								</div>
							</div>
						</li>
					</ul>
				</div>
				
				<div style="text-align: center" colspan=5><<1 2 3 4 5>></div>
			</div>
            </div>
        </div>
        <!-- Footer-->
	<jsp:include page="../../footer.jsp"></jsp:include>
        <!-- Bootstrap core JS-->
<!--          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> -->
        <!-- Core theme JS-->

</body>
</html>