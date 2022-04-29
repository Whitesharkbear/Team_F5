<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/f5/resources/css/board/board.css" rel="stylesheet" />
<link href="/f5/resources/css/head_nav.css" rel="stylesheet" />
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
				<label class="board-caption">Fooldey의 대나무 숲</label>
				<div class="board-content-container">
					<div class="board-info">
						<a href="board_update.do" class="board_update_link">수정하기</a>
						<button>삭제하기</button>
						<div class="content-title-div">
							<h2 class="content-title">제목</h2>
						</div>
						<dl>
							<dt>작성자:</dt>
							<dd>작성자1</dd>
						</dl>
						<dl>
							<dt>카테고리:</dt>
							<dd>자유글</dd>
						</dl>
						<dl>
							<dt>작성날짜:</dt>
							<dd>2022-04-23</dd>
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
							<p>
							동해물과 백두산이 마르고 닳도록<br>
							하느님이 보우하사 우리나라 만세<br>
							무궁화 삼천리 화려 강산<br>
							대한사람 대한으로 길이 보전하세<br>
							남산 위에 저 소나무 철갑을 두른듯<br>
							바람서리 불변함은 우리 기상일세<br>
							무궁화 삼천리 화려 강산<br>
							대한사람 대한으로 길이 보전하세<br>
							가을 하늘 공활한데 높고 구름 없이<br>
							밝은 달은 우리 가슴 일편단심일세<br>
							무궁화 삼천리 화려 강산<br>
							대한사람 대한으로 길이 보전하세<br>
							이 기상과 이 마음으로 충성을 다하여<br>
							괴로우나 즐거우나 나라사랑하세<br>
							무궁화 삼천리 화려 강산<br>
							대한사람 대한으로 길이 보전하세<br>
							
							</p>
						</div>
						<div class="reply-write-area">
							<div>
								<label class="reply-member">신순호</label>
							</div>
							<div class="reply-content-container">
								<input class="reply-content" type="text"
									placeholder="댓글을입력해주세요.">
							</div>
							<div class="reply-btn-container">
								<button type="button">등록</button>
								<button type="reset">취소</button>
							</div>
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
							<div class="reply-area">
								<div class="reply-member">
									<a>hong</a>
									<button>수정</button>
									<button>삭제</button>
								</div>
								<div class="reply-content-div">hong이 작성한 댓글내용입니다.</div>
								<div class="reply-etc">
									
									<dl>
										<dt><button>추천</button></dt>
										<dt>123</dt>
									</dl>
									<dl>
										<dt><button>비추천</button></dt>
										<dt>22</dt>
									</dl>
									<dl>
										<dt><button>답글쓰기</button></dt>
									</dl>
								
									<dl>
										<dt>2022.04.23</dt>
									</dl>
									
								</div>
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
	</div>

	<!-- Footer-->
	<jsp:include page="../footer.jsp"></jsp:include>
	<!-- Bootstrap core JS-->
	<!--          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> -->
	<!-- Core theme JS-->


</body>
</html>