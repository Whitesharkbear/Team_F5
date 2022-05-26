<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/f5/resources/css/board/board.css" rel="stylesheet" />
<link href="/f5/resources/css/head_nav.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<style type="text/css">
.comment_info label {
	display: block !important;
	font-size: 1.5em;
}

#comment_area {
	width: 80%;
	height: 80px;
	resize: none;
}

.comment_enter {
	float: right;
    height: 80px;
	width: 20%;
	border: none;
	border-radius: 5%;
	background-color: orange;
	color: #fff;
}
</style>
<!-- <script src="/f5/resources/js/board/board.js"></script> -->

<script>

	$(document).ready(function() {
		
		/* 
		showReplyList();
		
		function showReplyList(){
			// 댓글 리스트
			$.ajax({
				// 서버주소
				url:"reply_list.do",
				data: {"boardIdx":"${vo.boardIdx}"},
				dataType: 'json',
				type: 'POST',
				
				success: function(result) {
					alert(result);
					var htmls = "";
					if(result.length < 1) {
						htmls.push("등록된 댓글이 없습니다.");
					} else {
						alert(result);
						$(result).each(function(){
							htmls += '<div class="reply-member">';
							htmls += '<a></a>';
							htmls += '<button id="reply_update_btn">수정</button>';
							htmls += '<button id="reply_delete_btn">삭제</button>';
							htmls += '</div>';
							htmls += '<div class="reply-content-div">hong이 작성한 댓글내용입니다.</div>';
							htmls += '<div class="reply-etc">';
	
							htmls += '<dl>';
							htmls += 	'<dt>';
							htmls += '		<button id="reply_recommend_btn">추천</button>';
							htmls += '	</dt>';
							htmls += '	<dt id="reply_reco">0</dt>';
							htmls += '</dl>';
							htmls += '<dl>';
							htmls += '	<dt>';
							htmls += '		<button id="reply_derecommend_btn">비추천</button>';
							htmls += '	</dt>';
							htmls += '	<dt id="reply_deco">0</dt>';
							htmls += '</dl>';
							htmls += '<dl>';
							htmls += '	<dt>';
							htmls += '		<button id="reply-re-btn">답글쓰기</button>';
							htmls += '	</dt>';
	
							htmls += '</dl>';
	
							htmls += '<dl>';
							htmls += '	<dt>2022.04.23</dt>';
							htmls += '</dl>';
							htmls += '</div>';
						});
					}
					$("#reply-area").html(htmls);
				}
				
			});
		}
	
		 */
			
			
		// 게시판 삭제
		$("#content_delete").click(function(){
			var result = confirm("정말로 삭제하시겠습니까?");
			if(result) {
				delete_form.submit();
			} 
			
		});
		
		// 댓글입력
		$("#reply_insert_btn").click(function() {
			var reply = $(".reply-content").val();

			if(reply == "") {
				alert("댓글을 입력해주세요");
				$(".reply-content").focus();
			} else {
				var result = confirm("댓글을 입력하시겠습니까?");
				if(result) {
					reply_form.submit();
				}
			}
			
		});
		
		
		// 댓글 수정 삭제 버튼
		var reco = 0;
		var deco = 0;
		
		$(".reply_update_btn").click(function() {
			confirm("정말로 수정하시겠습니까?");
		});
		
		$(".reply_delete_btn").click(function() {
			var result = confirm("정말로 삭제하시겠습니까?");
			
		});
		
		
		// 댓글 추천 비추천 버튼
		$(".reply_recommend_btn").click(function() {
			reco += 1;
			$(".reply_reco").text(reco);
		});
		
		$(".reply_derecommend_btn").click(function() {
			deco += 1;
			$(".reply_deco").text(deco);
		});
		
		$(".reply-re-btn").click(function() {
			if($(".reply-re-write-area").css("display") == "none") {
				$(".reply-re-write-area").css("display","block");
			} else {
				$(".reply-re-write-area").css("display","none");
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

			<div class="board-container">
				<label class="board-caption">Foodly의 대나무 숲</label>
				<div class="board-content-container">

					<div class="board-info">
						<a href="board_delete.do?idx=${ vo.boardIdx }&rno=${ vo.rno }"><button id="content_delete" type="button" class="content-delete">삭제하기</button></a>
						<div class="content-title-div">
							<h2 class="content-title">${vo.boardTitle}</h2>
						</div>
						<dl>
							<dt>작성자:</dt>
							<dd>${vo.memberId}</dd>
						</dl>
						<dl>
							<dt>카테고리:</dt>
							<dd>${vo.boardCategory}</dd>
						</dl>
						<dl>
							<dt>작성날짜:</dt>
							<dd>${vo.boardDate}</dd>
						</dl>
						<dl>
							<dt>추천:</dt>
							<dd>123</dd>
						</dl>
						<dl>
							<dt>비추천:</dt>
							<dd>12</dd>
						</dl>
					</div>
					<div class="board-content-article">
						<div class="board-content">
							<p>${vo.boardContent}</p>
						</div>
						<div class="reply-write-area">
						
							<form name="reply_form" action="reply_write.do" method="post">
								<input type="hidden" name="boardIdx" value="${vo.boardIdx}">
								<div class="comment_info">
									<label>등록</label>
									<button type="button" class="comment_enter" id="reply_insert_btn">등록</button>
									<textarea rows="3" id="comment_area" class="reply-content" name="replyContent"></textarea>
								</div>
							</form>
						</div>
						<div class="board-reply-container">
							<div class="board-reply-head">

								<dl>
									<dt style="margin: 5px;">댓글</dt>
									<dt>
										<select>
											<option value="등록순">등록순
											<option value="추천순">추천순
										</select>
									</dt>
								</dl>
							</div>
							
							<c:forEach var="list" items="${rlist}">
							<div class="reply-area">
								<input type="hidden" name="boardIdx" value="${vo.boardIdx }">
									<div class="reply-member">
										<a>${list.replyIdx }</a>
										
										<form name="reply_update_form" action="reply_update.do" method="post">
											<button class="reply_update_btn">수정</button>
										</form>
										<form name="reply_delete_form" action="reply_delete.do" method="post">
											<input type="hidden" name="replyIdx" value="${list.replyIdx }">
											<input type="hidden" name="boardIdx" value="${vo.boardIdx }">
											<button class="reply_delete_btn">삭제</button>
										</form>
									</div>
									<div class="reply-content-div">${list.replyContent }</div>
									<div class="reply-etc">

										<dl>
											<dt>
												<button class="reply_recommend_btn" value="0">추천</button>
											</dt>
											<dt class="reply_reco">0</dt>
										</dl>
										<dl>
											<dt>
												<button class="reply_derecommend_btn">비추천</button>
											</dt>
											<dt class="reply_deco">0</dt>
										</dl>
										<dl>
											<dt>${list.replyDate }</dt>
										</dl>
									</div>
								
								
								<div class="reply-re-write-area">
									<form name="reply_re_write_form" action="reply_re_write.do"
										method="post">
										<div>
											<label class="reply-member">신순호</label>
										</div>
										<div class="reply-content-container">
											<input class="reply-content" type="text"
												placeholder="댓글을입력해주세요.">
										</div>
										<div class="reply-btn-container">
											<button type="button" class="reply-insert-btn">등록</button>
											<button type="reset">취소</button>
										</div>
									</form>
								</div>
							</div>
							</c:forEach>
							
						</div>


					</div>
					<div class="page-container">
						<button>이전글</button>
						<button>다음글</button>
						<a href="board_list.do">
							<button>목록</button>
						</a>
					</div>
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