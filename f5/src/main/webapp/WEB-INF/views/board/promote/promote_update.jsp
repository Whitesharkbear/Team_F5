<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gangnam Foodly</title>

<link href="/f5/resources/css/board/board.css" rel="stylesheet" />
<link href="/f5/resources/css/head_nav.css" rel="stylesheet" />
<link href="/f5/resources/css/board/promote.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script>
	
	$(document).ready(function(){
		$("#promote_update_btn").click(function(){
			if( $("#promoteTitle").val() == "" ) {
				alert("홍보 제목을 입력해주세요.");
				$("#promoteTitle").focus();
				return;
			} else if( $("#promoteContent").val() == "" ) {
				alert("홍보 상세내용을 입력해주세요.");
				$("#promoteContent").focus();
				return;
			}
			promote_update_form.submit();
			
		});
		
		$("#promote_delete_btn").click(function(){
			var delete_result = confirm("정말로 삭제하시겠습니까?");
			if(delete_result) {
				location.href = "promote_delete.do?boardIdx=${vo.boardIdx}";
			}
		});
		

		$(".pre-show").click(function(){
			var title = $("#promoteTitle").val();
			var content = $("#promoteContent").val();
			
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
			var title = $("#promoteTitle").val();
			var content = $("#promoteContent").val();
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
				<form name="promote_update_form" action="promote_update.do" method="post">
				<input type="hidden" name="boardIdx" value="${vo.boardIdx }">
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
										<input name="boardTitle" id="promoteTitle" type="text" placeholder="제목을 입력해주세요" class="title" value="${vo.boardTitle }">
									</td>
								</tr>
								<tr>
									<th colspan="5"><label class="label">홍보상세내용</label></th>
								</tr>
								<tr>
									<td colspan="5">
										<textarea name="boardContent" id="promoteContent" class="content" placeholder="추가하실 내용을 입력해주세요.&#13;&#10;예)&#13;&#10; 타임세일: 13시에만 열리는 타임세일!">${vo.boardContent }</textarea>
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
														src="/f5/resources/images/상점.jpeg">
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
						<button type="button" id="promote_update_btn" class="cusbtn">수정완료</button>
						<button type="button" id="promote_delete_btn" class="cusbtn2">삭제하기</button>
						<a href="promote_list.do">
							<button class="cusbtn3" type="button">돌아가기</button>
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