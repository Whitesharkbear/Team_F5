<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/f5/resources/css/board/board.css" rel="stylesheet" />
<link href="/f5/resources/css/head_nav.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script src="/f5/resources/js/board/board.js"></script>
<script>
	
$(document).ready(function() {
	$("#write_btn").click(function() {
		var title = $(".title").val();
		var content = $(".content").val();
		
		if(title == "") {
			alert("제목을 입력해주세요");
			$(".title").focus();
			return;
		} else if(content == "") {
			alert("내용을 입력해주세요");
			$(".content").focus();
			return;
		} else {
			board_form.submit();
		}
	});
});

</script>
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
            		<label class="board-caption">Foodly의 대나무 숲</label>
	            	<div class="board-write-container">
	            		<div class="board-write-container-wrap">
	            		<form name="board_form" action="board_write.do" method="post">
		            		<table class="write-table">
		            			<tr>
		            				<th class="write-title" colspan="2">
		            					<label class="label">제목</label>
		            				</th>
		            			</tr>
		            			<tr>
		            				<td colspan="2"><input type="text" name="boardTitle" placeholder="제목을 입력해주세요" class="title"></td>
		            			</tr>
		            			<tr><th colspan="2"><label class="label">내용</label></th></tr>
		            			<tr>
		            				<td colspan="2"><textarea name="boardContent" class="content" placeholder="내용을 입력해주세요"></textarea></td>
		            			</tr>
		            			<tr><th colspan="2"><label class="label">파일첨부</label></th></tr>
		            			<tr>
		            				<td>
		            					<table class="file-table">
		            						<tr>
		            							<td><button>+</button></td>
		            							
		            						</tr>
		            					</table>
		            				</td>
		            				<td>
		            					<table class="file-table">
		            						<tr>
		            							<td>img</td>
		            							<td>img</td>
		            							<td>img</td>
		            							<td>img</td>
		            							<td>img</td>
		            						</tr>
		            					</table>
		            				<td>
		            			</tr>
		            		</table>
	            		</form>
	            		</div>
	            	</div>
            	</div>
            	<div class="board-write-btn-container">
            		<div class="board-write-btn-container-wrap">
						<button id="write_btn" class="cusbtn" type="button">등록</button>        		
	   					<button class="cusbtn" type="reset">취소</button>
	   					<a href="board_list.do">
	   						<button class="cusbtn" type="button">돌아가기</button>
	   					</a>
           			</div>
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