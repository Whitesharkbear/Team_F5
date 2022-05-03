<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="/f5/resources/css/admin/dashboard.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
    	<jsp:include page="header.jsp" />
        <!-- Page content-->
        <div class="container">
            <div class="row">
				<section>
					<div id="content1">
						<h3>통계</h3>
						<ul>
							<li class="statistics_list">
								<div class="statistics">
									<h5>PageView</h5>
									<div id="pageviews">
										<ul>
											<li>
												<label>today : 0</label>
											</li>
											<li>
												<label>total : 0</label>
											</li>
										</ul>
									</div>
								</div>
							</li>
							<li class="statistics_list">
								<div class="statistics">
									<h5>사용자 통계</h5>
									<div id="users">
										<ul>
											<li>
												<label>today : 0</label>
											</li>
											<li>
												<label>total : 0</label>
											</li>
										</ul>
									</div>
								</div>
							</li>
							<li class="statistics_list">
								<div class="statistics">
									<h5>asdf</h5>
									<div id="users">
										<ul>
											<li>
												<label>today : 0</label>
											</li>
											<li>
												<label>total : 0</label>
											</li>
										</ul>
									</div>
								</div>
							</li>
							<li class="statistics_list">
								<div class="statistics">
									<h5>asdf</h5>
									<div id="users">
										<ul>
											<li>
												<label>today : 0</label>
											</li>
											<li>
												<label>total : 0</label>
											</li>
										</ul>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</section>
				<section>
					<div id="content2">
						<h3>회원관리</h3>
						<div class="member_btn">
							<a href="#">더 보기</a>
						</div>
						<div>
							<table id="member_table">
							<colgroup>
								<!-- 번호 -->
								<col width="10%">
								<!-- 이름 -->
								<col width="15%">
								<!-- 아이디 -->
								<col width="15%">
								<!-- 생년월일 -->
								<col width="20%">
								<!-- 회원권한 -->
								<col width="20%">
								<!-- 탈퇴 -->
								<col width="15%">
							</colgroup>
								<tr>
									<th>번호</th><th>이름</th><th>아이디</th><th>생년월일</th><th>회원권한</th><th>탈퇴</th>
								</tr>
								<tr>
									<td>1</td>
									<td>name</td>
									<td><a href="member_content.do">id</a></td>
									<td>2022-01-01</td>
									<td>
									<!-- 
										<select class="auth">
											<option value="0" selected="selected">일반회원</option>
											<option value="1">CEO</option>
											<option value="2">관리자</option>
										</select>
									-->
									<label>일반회원</label>
									</td>
									<td>
										<button value="0">승인</button>
									</td>
								</tr>
								<tr>
									<td>2</td>
									<td>CEO</td>
									<td><a href="ceo_member_content.do">CEO_ID</a></td>
									<td>2022-01-01</td>
									<td>
									<!-- 
										<select class="auth">
											<option value="0" selected="selected">일반회원</option>
											<option value="1">CEO</option>
											<option value="2">관리자</option>
										</select>
									-->
									<label>CEO</label>
									</td>
									<td>
										<button value="0">승인</button>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</section>
				<section>
					<div id="content3">
						<h3>문의내역</h3>
						<div class="question_btn">
							<a href="question_list.do">더 보기</a>
						</div>
						<table id="question_table">
						<colgroup>
								<!-- 번호 -->
								<col width="10%">
								<!-- 문의자 id -->
								<col width="15%">
								<!-- 문의제목 -->
								<col width="25%">
								<!-- 문의내용 -->
								<col width="35%">
								<!-- 답변여부 -->
								<col width="15%">
							</colgroup>
							<tr>
								<th>번호</th><th>문의자 id</th><th>문의제목</th><th>문의내용</th><th>답변여부</th>
							</tr>
							<% for ( int i = 1; i <= 10; i++) { %>
							<tr>
								<td>1</td>
								<td>user1</td>
								<td>문의1</td>
								<td><a href="question_content.do">문의내용</a></td>
								<td>접수중</td>
							</tr>
							<% } %>
						</table>
					</div>
				</section>
            </div>
            <!-- row -->
        </div>
        <!-- container -->
        
        <!-- Footer-->
	<jsp:include page="footer.jsp" />
    </body>
</html>
