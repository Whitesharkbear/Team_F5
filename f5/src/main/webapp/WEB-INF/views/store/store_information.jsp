<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/f5/resources/css/store/store_information.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script src="/f5/resources/js/store/store_information.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="row">
               <div class="head-nav-container">
                  <label class="head-nav-title">Free Board</label>
                  <div class="head-nav-inner">
                     <ul class="nav-col-ul">
                        <li><a href="#intro">소개</a></li>
                        <li><a href="#location">위치</a></li>
                        <li><a href="#review">리뷰</a></li>
                        <li><a href="#reservation">예약</a></li>
                        <li><a href="#delivery">주문</a></li>
                     </ul>
                  </div>
               </div>
               
            </div>
	<div class = "container">
		<div class = "store-intro">
			<h2>댄싱 홍콩 강남1호점</h2>
			<div class= "store-intro-img-box">
				<a><img class= "store-intro-img" src = "/f5/resources/images/sample5.jpg"></a>
				<a><img class= "store-intro-img" src = "/f5/resources/images/sample5.jpg"></a>
				<a><img class= "store-intro-img" src = "/f5/resources/images/sample5.jpg"></a>
				<button type="button" class = "button_next">다음사진</button>
			</div>
			<h2>평점 4.6</h2>
			<h2 id="intro">#핫플레이스 #중국 #친절</h2>
			<div class = "store-intro-box" >
				<div class = "store-intro-maintext-box">
					<div class = "store-intro-text-box">
						<ul>
							<li>댄싱홍콩 강남 1호점 4.6</li>
							<li>주소 : 서울시 강남구 강남거리 231길 25</li>
							<li>전화 : 050-9241-2432</li>
							<li>종류 : 중국요리</li>
							<li>가격대 : 6천원 ~ 4만원</li>
							<li>주차 : 무</li>
							<li>웹사이트 : www.hongkong.co.kr</li>
						</ul>
					</div>
					<div class = "store-intro-icon-box">
						<a><img class= "store-intro-img-2" src = "/f5/resources/images/store-img-review.jpeg"></a>
						<div>리뷰쓰기</div>
						<a><img class= "store-intro-img-2" src = "/f5/resources/images/store-img-thumbup.jpeg"></a>
						<div>추천하기</div>
					</div>
				</div>
				<div class = "store-intro-map" id="location">
					<a><img class= "store-intro-img" src = "/f5/resources/images/storesample1.jpeg">></a>
				</div>
			</div>
			<h2 id="review">리뷰</h2>
			<h4>나도한마디</h4>
			<div class = "store-review">
				<div class= "store-user">
					<div class = "score-mobile"><div><div><img src = "#"></div><div>나는야단골</div></div>
					<div class = "review-score-2">4.5</div></div>
					<div class = "store-review-content">
						<div class = "review-score">4.5</div>
						<div class = "review-text">너무너무 맛있어서 기절할것같아요.</div>
					</div>
				</div>
				<div class= "store-user">
					<div class = "score-mobile"><div><div><img src = "#"></div><div>나는야안티</div></div>
					<div class = "review-score-2">1.0</div></div>
					<div class = "store-review-content">
						<div class = "review-score">1.0</div>
						<div class = "review-text">개노맛</div>
					</div>
				</div>	
				<div class= "store-user">
					<div class = "score-mobile"><div><div><img src = "#"></div><div>나는야시인</div></div>
					<div class = "review-score-2">2.0</div></div>
					<div class = "store-review-content">
						<div class = "review-score">2.0</div>
						<div class = "review-text">양파의단맛과 알싸함의 조합이 첫사랑처럼 다가왔다.</div>
					</div>
				</div>			
				<div class="review-write-box"><input class = "review-write" type="text" placeholder="리뷰를 작성해주세요"><button class = "review-button">완료</button></div>	
			</div>
			<div class="reservation" id="reservation">
				<h2>예약</h2>
				<h4>나는 편하게!</h4>
				<h3>가게 스케줄링~</h3>
				 <div class="sec_cal">
				  <div class="cal_nav">
				    <a href="javascript:;" class="nav-btn go-prev"><<</a>
				    <div class="year-month"></div>
				    <a href="javascript:;" class="nav-btn go-next">>></a>
				  </div>
				  <div class = "dates"></div>
				</div>
				<!-- 모달창-->
				<div class = "reservation-modal">
					<div class = "modal-window">
						<div class = "modal-title">예약설정</div>
						<div class = "modal-contents">
							<div class = "selected-date"></div>
							<div class = "modal-input">
								<div>인원수 선택</div>
								<select class = "modal-select-number">
									<option>--선택--</option>
									<option>1명</option>
									<option>2~3명</option>
									<option>4~5명</option>
									<option>6명 이상</option>
								</select>
								<div>시간대 선택</div>
								<select class = "modal-select-time">
									<option>--선택--</option>
									<option>오전</option>
									<option>점심시간</option>
									<option>13:00~15:00</option>
									<option>15:00~17:00</option>
									<option>저녘시간</option>
									<option>20:00 이후</option>
								</select>
							</div>
							<div class="button-location">
								<button type="button" class="reservation-button" id="reservation-submit-button">예약접수</button>
								<button type="button" class="reservation-button" id="reservation-close-button">닫기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<h2 id="delivery">주문</h2>
			<h4>집에서 즐기세요</h4>
			<div class="delivery">
				<div class = "goods">
					<a><img class= "store-intro-img" src = "/f5/resources/images/sample5.jpg"></a>
					<div>볶음밥</div><div>10원</div>
				</div>
				<div class="goods">
					<a><img class= "store-intro-img" src = "/f5/resources/images/sample5.jpg"></a>
					<div>볶음밥</div><div>10원</div>
				</div>
				<div class="goods">
					<a><img class= "store-intro-img" src = "/f5/resources/images/sample5.jpg"></a>
					<div>볶음밥</div><div>10원</div>
				</div>
			</div>
			<nav aria-label="Pagination">
                        <hr class="my-0" />
                        <ul class="pagination justify-content-center my-4">
                            <li class="page-item disabled"><a class="page-link" href="#" tabindex="-1" aria-disabled="true">Newer</a></li>
                            <li class="page-item active" aria-current="page"><a class="page-link" href="#!">1</a></li>
                            <li class="page-item"><a class="page-link" href="#!">2</a></li>
                            <li class="page-item"><a class="page-link" href="#!">3</a></li>
                            <li class="page-item disabled"><a class="page-link" href="#!">...</a></li>
                            <li class="page-item"><a class="page-link" href="#!">15</a></li>
                            <li class="page-item"><a class="page-link" href="#!">Older</a></li>
                        </ul>
            </nav>
		</div>
	</div>
	

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>