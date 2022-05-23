<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<html lang="en">
<link href="/f5/resources/css/member/mypage/mypage.css" rel="stylesheet" />
<link href="/f5/resources/css/member/common.css" rel="stylesheet" />
<link href="/f5/resources/css/main/index.css" rel="stylesheet" />
</head>
    <body>
    	<jsp:include page="../../header.jsp"></jsp:include>
    	<!-- UnderBar -->
    	<div class="container">
	    	<div class="row">
	               <div class="head-nav-container">
	                  <label class="head-nav-title">My Page</label>
	                  <div class="head-nav-inner">
	                     <ul class="nav-col-ul">
	                        <li><a href="#">나의 한마디</a></li>
	                        <li><a href="#">공지사항</a></li>
	                        <li><a href="#">1:1 문의</a></li>
	                        <li><a href="#">환경설정</a></li>
	                     </ul>
	                  </div>
	               </div>
	         </div>
        </div> <!-- UnderBar -->
        <!-- User Information -->
        <div>
        	<div>
        		<div class="profile">
					<img class="user-img" src="/f5/resources/images/user.png"><br>
					<a href="mypage_info.do"><button class="user-fix" type="button">회원정보변경</button></a>
				</div>
				<span class="profile-h"><h2>Username 님, 환영합니다!</h2></span>
				<hr>
				<div class = "mypage-info">
					
				<table class = "mypage-li">
					<tr>
						<th>
						<img class = "mypage-icon"src="/f5/resources/images/sample1.jpg">
						<br>쿠폰함
						</th>
						<th>
						<img class = "mypage-icon"src="/f5/resources/images/sample1.jpg">
						<br>예약현황
						</th>
						<th>
						<img class = "mypage-icon"src="/f5/resources/images/sample1.jpg">
						<br>주문현황
						</th>
						<th>
						<img class = "mypage-icon"src="/f5/resources/images/sample1.jpg">
						<br>문의현황
						</th>
					</tr>

				</table>
				</div>
				
        	</div>
        </div>
        
        <!-- Footer-->
	<jsp:include page="../../footer.jsp"></jsp:include>
    </body>
</html>
