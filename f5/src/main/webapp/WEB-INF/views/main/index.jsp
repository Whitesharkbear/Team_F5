<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
              
                    <div class="card mb-4">
                        <div class="card-body">
                        	<img class = "login_image" src = "/f5/resources/images/person.png"><input class = "input_id" type = "text" placeholder = "Username">
                        </div>
                        <div class="card-body">
							<img class = "login_image" src = "/f5/resources/images/password.png"><input class = "input_id" type = "password" placeholder = "****">
                        </div>
                        <div class= "card-body">
                        	<button class = "main_login_button">로그인</button>
                        	<button class = "main_join_button">회원가입</button>
                        </div>
                        <div class="card-body">
                        	<div class = "login-easily">
                        		<img class = "login-logo" src = "/f5/resources/images/kakao_logo.jpeg"><img class = "login-logo" src = "/f5/resources/images/naver_logo.jpeg">간편로그인
                        	</div>
                        </div>
                    </div>
                    
                 
                    <div class="card mb-4">
                        <div class="card-header">공지사항</div>
                        <div class="card-body">
							<table border="1">
								<tr>
									<th>목차</th>
									<th>제목</th>
									<th>작성일</th>
								</tr>
								<tr>
									<td>1</td>
									<td>강남Foodly 이용시 주의사항 안내</td>
									<td>오늘</td>
								</tr>
								<tr>
									<td>2</td>
									<td>3차 방문포장 이벤트 당첨자를 확인하세요</td>
									<td>어제</td>
								</tr>
								
							</table>
                        </div>
                    </div>
               
                    <div class="card mb-4">
                        <div class="card-header"><img></div>
                        <div class="card-body">HeadLine News!</div>
                        <div class = "main_news">
                        	코로나 19로 인해 절찬 할인 중!<br>
							닭, 돼지고기 반값 세일 중!<br>
							6월부터 재난지원금 추가 신청<br>
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
							<table border="1">
								<tr>
									<th>목차</th>
									<th>제목</th>
									<th>작성일</th>
								</tr>
								<tr>
									<td>1</td>
									<td>[리뷰글] 강남대박 맛집 다녀왔어요~</td>
									<td>오늘</td>
								</tr>
								<tr>
									<td>2</td>
									<td>매운카레 5단계도전파티 모집</td>
									<td>오늘</td>
								</tr>
								<tr>
									<td>3</td>
									<td>논현동 맛집 방문후기</td>
									<td>오늘</td>
								</tr>
								
							</table>
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
