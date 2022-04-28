<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.class{
		display: flex;
		flex-direction: column;
	}
	.goods-row{
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
	}
	.goods-img{
		width: 300px;
		max-height : 200px;
		background-size: cover;
	}
	
</style>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class = "container">
		<div class = "goods">
			<div class = "goods-row">
				<div>
					<a><img class = "goods-img" src = "/f5/resources/images/sample1.jpg"></a>
					<div>옛날짜장면</div>
					<div>5000원</div>
					<div>장바구니담기</div>
				</div>
				<div>
					<a><img class = "goods-img" src = "/f5/resources/images/sample1.jpg"></a>
					<div>옛날짜장면</div>
					<div>5000원</div>
					<div>장바구니담기</div>
				</div>
				<div>
					<a><img class = "goods-img" src = "/f5/resources/images/sample1.jpg"></a>
					<div>옛날짜장면</div>
					<div>5000원</div>
					<div>장바구니담기</div>
				</div>
				<div>
					<a><img class = "goods-img" src = "/f5/resources/images/sample1.jpg"></a>
					<div>옛날짜장면</div>
					<div>5000원</div>
					<div>장바구니담기</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>