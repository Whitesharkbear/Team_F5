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
	       		<H2>나의 한마디</H2>
	       		<div class="com_btn">
	       		<button type="button">변경하기</button>
	       		<button type="button">삭제하기</button>
	       		</div>
	       		<table>
	       			<tr>
	       				<th>목차</th>
	       				<th>내용</th>
	       				<th>경로</th>
	       				<th>Check</th>
	       			</tr>
	       			<tr>
	       				<td>num</td>
	       				<td>com</td>
	       				<td>loc</td>
	       				<td><input type="checkbox"></td>
	       			</tr>
	       			
	       		</table>
       	
       		</div>
       </div>
        
        <!-- Footer-->
	<jsp:include page="../../footer.jsp"></jsp:include>
    </body>
</html>
