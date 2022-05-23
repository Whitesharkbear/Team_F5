<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<html lang="en">
<link href="/f5/resources/css/member/mypage/mypage_com.css" rel="stylesheet" />
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
        
       <!-- comment -->
       <div>
	       	<div class="com_container">
	       		<H2>나의 예약현황</H2>
	       		<div class="com_btn">
	       		<button type="button">취소하기</button>
	       		</div>
	       		<table>
	       			<tr>
	       				<th><button id="com_button1" type="button">날짜변경</button></th>
	       				<th><button id="com_button1" type="button">시간변경</button></th>
	       				<th><button id="com_button1" type="button">상점변경</button></th>
	       			</tr>
	       			<tr>
	       				<td>Day</td>
	       				<td>Time</td>
	       				<td>Store</td>
	       				<td>Check</td>
	       			</tr>
	       			<tr>
	       				<td>Day_content</td>
	       				<td>Time_content</td>
	       				<td>Store_name</td>
	       				<td><input type="checkbox"></td>
	       			</tr>
	       			
	       		</table>
       	
       		</div>
       </div>
        
        <!-- Footer-->
	<jsp:include page="../../footer.jsp"></jsp:include>
    </body>
</html>
