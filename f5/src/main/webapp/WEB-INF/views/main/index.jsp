<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<!DOCTYPE html>

<html lang="en">
<link href="/f5/resources/css/main/index.css" rel="stylesheet" />

    <body>
    	<jsp:include page="../header.jsp"></jsp:include>
        <!-- Page content-->
        <div class="container">
            <div class="row">
                <!-- Blog entries-->
           
                <div class="col-lg-8">
                
                    <div class="card mb-4">
                        <a href="#!"><img class="card-img-top" src="/f5/resources/images/sample1.jpg" alt="..." /></a>
                    </div>
                    <div class="card mb-4">
                        <a href="#!"><img class="card-img-top" src="/f5/resources/images/sample2.jpg" alt="..." /></a>
                    </div>
                    <div class="card mb-4">
                        <a href="#!"><img class="card-img-top" src="/f5/resources/images/sample3.jpg" alt="..." /></a>
                    </div>
                    <div class="card mb-4">
                        <a href="#!"><img class="card-img-top" src="/f5/resources/images/sample4.jpg" alt="..." /></a>
                    </div>
                    <div class="card mb-4">
                        <a href="#!"><img class="card-img-top" src="/f5/resources/images/sample5.jpg" alt="..." /></a>
                    </div>

                     <!-- Pagination-->
                   
                    <nav aria-label="Pagination">
                        <hr class="my-0" />
                        <ul class="pagination justify-content-center my-4">
                            <li class="page-item disabled"><a class="page-link" href="#" tabindex="-1" aria-disabled="true">Newer</a></li>
                            <li class="page-item active" aria-current="page"><a class="page-link" href="#!">1</a></li>
                            <li class="page-item"><a class="page-link" href="#!">2</a></li>
                            <li class="page-item"><a class="page-link" href="#!">3</a></li>
                            <li class="page-item disabled"><a class="page-link" href="#!">...</a></li>
                            <li class="page-item"><a class="page-link" href="#!">15</a></li>
                            <li class="page-item"><a class="page-link" href="#!">Older</a></li>
                        </ul>
                    </nav>
                </div>
             
                <!-- Side widgets-->
            
                <div class="col-lg-4">
              
              		<c:choose>
              		<c:when test="${sessionScope.memberId == null}">
                    <div class="card mb-4 login_sec">
                        <div class="card-body">
                        	<button class = "main_login_button">로그인</button>
                        	<input class = "input_id" type = "text" placeholder = "Username">
							<input class = "input_id" type = "password" placeholder = "****">
                        </div>
                        <div class= "card-body">
                        	<a class = "main_join_button">아이디/비밀번호 찾기</a>
                        	<a class = "main_join_button">회원가입</a>
                        </div>
                        <div class="card-body">
                        	<div class = "login-easily">
                        		<img class = "login-logo" src = "/f5/resources/images/kakao_logo.jpeg">
                        		<img class = "login-logo" src = "/f5/resources/images/naver_logo.jpeg">
                        		<button type="button" class="easy_login">간편로그인</button>
                        	</div>
                        </div>
                    </div>
                    </c:when>
                    <c:otherwise>
                    	<div class = "card mb-4">
                    		<div class = "card-header">${sessionScope.memberName }님 환영합니다~</div>
                    		<div class = "card-body">
                    			<button type="button" class="mypage-button">마이페이지</button>
                    			<button type="button" class="reservation-button">예약확인</button>
                    			<button type="button" class="reservation-button">장바구니</button>
                    			<button type="button" class="logout-button">로그아웃</button>
                    		</div>
                    	</div>
                    </c:otherwise>
                    </c:choose>
                 
                    <div class="card mb-4">
                        <div class="card-header">공지사항</div>
                        <div class="card-body">
                        	<div class="main_notice">
								<ul class="new_notice">
									<li><a>공지1</a></li>
									<li><a>공지2</a></li>
									<li><a>공지3</a></li>
								</ul>
                        	</div>
                        </div>
                    </div>
               
                    <div class="card mb-4">
                        <div class="card-header">최신 뉴스</div>
                        <div class="card-body">
	                        <div class = "main_news">
	                        	<ul class="new_news">
	                        		<li><a>뉴스1</a></li>
	                        		<li><a>뉴스2</a></li>
	                        		<li><a>뉴스3</a></li>
	                        	</ul>
	                        </div>
                        </div>
                    </div>
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
                	 <div class="card mb-4 ">
                        <div class="card-header">자유게시판</div>
                        <div class="card-body">
                        	<div class="main_board">
								<ul class="new_board">
									<li><a>게시글1</a></li>
									<li><a>게시글2</a></li>
									<li><a>게시글3</a></li>
								</ul>
                        	</div>
                        </div>
                    </div>
                    
                </div>
            </div>
            <!-- row -->
        </div>
        <!-- container -->
        
        <!-- Footer-->
	<jsp:include page="../footer.jsp"></jsp:include>
    </body>
</html>
