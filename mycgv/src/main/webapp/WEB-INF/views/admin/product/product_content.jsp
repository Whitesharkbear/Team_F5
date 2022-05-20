<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/mycgv/resources/css/mycgv.css">
</head>
<body>
	<!--  header -->
	<jsp:include page="../../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="board_content">
			<h1 class="title">관리자 - 상품상세정보</h1>
			<table class="content_layout">
				<tr>
					<th>번호</th>
					<td>${rno}</td>
					<th>날짜</th>
					<td>${vo.pdate }</td>
					<th>가격</th>
					<td>${vo.price }</td>
				</tr>
				<tr>
					<th>상품명</th>
					<td colspan="5">${vo.pname }</td>
				</tr>
				<tr>
					<th>상품정보</th>
					<td colspan="5">${vo.pinfo }<br><br><br>
					<img src="http://localhost:9000/mycgv/resources/upload/${vo.psfile1}" 
								width="100px"  height="50px">
					<img src="http://localhost:9000/mycgv/resources/upload/${vo.psfile2}" 
								width="100px"  height="50px">
					<img src="http://localhost:9000/mycgv/resources/upload/${vo.psfile3}" 
								width="100px"  height="50px">
					<img src="http://localhost:9000/mycgv/resources/upload/${vo.psfile4}" 
								width="100px"  height="50px">
					<img src="http://localhost:9000/mycgv/resources/upload/${vo.psfile5}" 
								width="100px"  height="50px">
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<%-- <a href="notice_update.do?nid=${vo.nid }&rno=${rno}"><button type="button" class="btn_style2">수정</button></a>
						<a href="notice_delete.do?nid=${vo.nid }&rno=${rno}"><button type="button" class="btn_style2">삭제</button></a>
						--%>
						<a href="product_list.do"><button type="button" class="btn_style2">리스트</button></a>
						<a href="http://localhost:9000/mycgv/index.do"><button type="button" class="btn_style2">홈으로</button></a> 
					</td>
				</tr>
			</table>
		</section>
		
	</div>
	
	<!--  footer -->
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>