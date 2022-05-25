<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/f5/resources/css/head_nav.css" rel="stylesheet" />
<link href="/f5/resources/css/board/board.css" rel="stylesheet" />
<link href="/f5/resources/css/board/promote.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>

<script>
	
	$(document).ready(function(){
		
		$("#promote_insert_btn").click(function(){
			if( $("#promote_title").val() == "" ) {
				alert("홍보 제목을 입력해주세요.");
				$("#promote_title").focus();
				return;
			} else if( $("#promote_content").val() == "" ) {
				alert("홍보 상세내용을 입력해주세요.");
				$("#promote_content").focus();
				return;
			}
			promote_write_form.submit();
			
		});
		
		$(".pre-show").click(function(){
			var title = $("#promote_title").val();
			var content = $("#promote_content").val();
			
			if( $(".promote-show").css("display") == "none" ) {				
				$(".pre-reshow").css("display","block");
				$(".promote-show").css("display","inline-block");
				$(".pre-title").text(title);
				$(".pre-content").text(content);
			} else if( $(".promote-show").css("display") == "inline-block" ) {
				$(".promote-show").css("display","none");
				$(".pre-reshow").css("display","none");
			} 
		});
		
		$(".pre-reshow").click(function() {
			var title = $("#promote_title").val();
			var content = $("#promote_content").val();
			$(".pre-title").text(title);
			$(".pre-content").text(content);
		});
		
	});

</script>


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
				<form name="promote_write_form" action="promote_write.do" method="post">
					<div class="board-write-container">
						<div class="board-write-container-wrap">
							<table class="write-table">
								<colgroup>
									<col width="20%"/>
									<col width="20%"/>
									<col width="20%"/>
									<col width="20%"/>
									<col width="20%"/>									
								</colgroup>
								<tr>
									<th colspan="5" class="write-title"><label class="label">홍보제목</label>
									</th>
								</tr>
								<tr>
									<td colspan="5">
										<input name="boardTitle" id="promote_title" type="text" placeholder="제목을 입력해주세요" class="title">
									</td>
								</tr>
								<tr>
									<th colspan="5"><label class="label">홍보상세내용</label></th>
								</tr>
								<tr>
									<td colspan="5">
										<textarea name="boardContent" id="promote_content" class="content" placeholder="추가하실 내용을 입력해주세요.&#13;&#10;예)&#13;&#10; 타임세일: 13시에만 열리는 타임세일!"></textarea>
									</td>
								</tr>
								<tr>
									<th colspan="5"><label class="label">파일첨부</label></th>
								</tr>
								<tr>
									<td colspan="5">
										<input type="file">
									</td>
								</tr>
								<tr>
									<td>img</td>
									<td>img</td>
									<td>img</td>
									<td>img</td>
									<td>img</td>
								</tr>
								<tr>
									<th colspan="5"><label class="label">미리보기</label></th>
								</tr>
								<tr>
									<td><button class="pre-show" type="button">Click</button></td>
									<td colspan="2"><button class="pre-reshow" type="button">새로고침</button></td>
								</tr>
								<tr>
									<td colspan="5" style="text-align: center">
										<div class="promote-list promote-show">
											<div class="promote-top">
												<div class="centered">
													<img class="promote-img"
														src="/f5/resources/images/person.png">
												</div>
												<p class="pre-title"></p>
											</div>
											<div class="promote-bottom">
												<p class="pre-content"></p>
											</div>
										</div>
									</td>
								</tr>
							</table>
							
						</div>
					</div>
				</form>					
				<div class="board-write-btn-container">
					<div class="board-write-btn-container-wrap">
						<button type="button" id="promote_insert_btn" class="cusbtn">등록</button>
						<button class="cusbtn" type="reset">취소</button>
						<a href="promote_list.do">
							<button class="cusbtn" type="button">돌아가기</button>
						</a>
					</div>
				</div>
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