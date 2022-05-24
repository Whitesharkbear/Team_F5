<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/f5/resources/css/store/store_information.css"
	rel="stylesheet" />
<script type = "text/javascript" src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
<script type = "text/javascript" src="/f5/resources/js/store/store_information.js"></script>


<script type="text/javascript">
	var sessionmemberId = '${sessionScope.memberId}'
	var storeIdx = '${vo.storeIdx}'
</script>
<style type="text/css">
	.more-review{
		width : 100%;
		border-style: none;
		background-color: white;
	}
	#all-review-list{
		display: none;
	}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="head-nav-container">
		<label class="head-nav-title">Free Board</label>
		<div class="head-nav-inner">
			<ul class="nav-col-ul">
				<li><a href="#">소개</a></li>
				<li><a href="#location">위치</a></li>
				<li><a href="#review">리뷰</a></li>
				<li><a href="#reservation">예약</a></li>
				<li><a href="#delivery">주문</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="store-intro">
				<h2>${vo.storeName }</h2>
				<div class="store-intro-img-box">
					<img class="button_before" src="/f5/resources/images/before_button.png">
					<div id="img-div-cover">
						<div id="img-div"></div>
					</div>
					<img class="button_next" src="/f5/resources/images/next_button.png">
				</div>
				<h2 id = "average-score"></h2>
				<h2 id="intro">#핫플레이스 #중국 #친절</h2>
				<div class="store-intro-box">
					<div class="store-intro-maintext-box">
						<div class="store-intro-text-box">
							<ul>
								<li>${vo.storeName }</li>
								<li>${vo.storePlace }</li>
								<li>${vo.storeTel }</li>
								<li>${vo.storeCategory }</li>
							<li>가격대 : ${vo.storePrice }</li>
								<li>주차 : ${vo.storeParking }</li>
								<li>웹사이트 : ${vo.storeWebSite }</li>
							</ul>
						</div>
<!-- 						<div class="store-intro-icon-box">
							<a><img class="store-intro-img-2" src="/f5/resources/images/store-img-review.jpeg"></a>
							<div>리뷰쓰기</div>
							<a><img class="store-intro-img-2" src="/f5/resources/images/store-img-thumbup.jpeg"></a>
							<div>추천하기</div>
						</div> -->
					</div>
					<div class="store-intro-map" id="location">
						<a><img class="store-intro-img" src="#"></a>
					</div>
				</div>
				<h2 id="review">리뷰</h2>
				<h4>나도한마디</h4>
				<div class="store-review">
				<input type="hidden" id = "review-page" value = "1">
				<input type="hidden" id = "myreview-page" value = "1">
				
					<div>
						<button type="button" class = "more-review" id="my-review-list">내글보기</button>
						<button type="button" class = "more-review" id="all-review-list">전체글보기</button>
						<button type="button" class = "more-review" id="more-review-button">더보기</button>
						<button type="button" class = "more-review" id="close-review-button">접기</button>
					</div>
					<form name="review_form" action="store_information.do" method="POST">
					<div class="review-write-box">
						<input class="review-write" type="text" placeholder="리뷰를 작성해주세요" name = "reviewContent" >
						<select name ="reviewScore" id ="review-score-select">
								<option>별점주기</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
						</select>
						<input type="hidden" name = "storeIdx" value="${vo.storeIdx }">
						<button id = "review_submit" class="review-button" type="button">리뷰작성</button>
					</div>
					</form> 
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
						<div class="dates"></div>
					</div>
					<!-- 모달창-->
					<form name="store_information_reservation_form"
						action="store_information.do" method="post">
						<div class="reservation-modal">
							<div class="modal-window">
								<div class="modal-title">예약설정</div>
								<div class="modal-contents">
									<div class="selected-date"></div>
									<input type="hidden" name = "reservationTimeDate" class="selected-date-hidden">
									<div class="modal-input">
										<div>인원수 선택</div>
										<select class="modal-select-number" name="reservationCount">
											<option>--선택--</option>
											<option value=1>1명</option>
											<option value=3>2~3명</option>
											<option value=5>4~5명</option>
											<option value=10>6명 이상</option>
										</select>
										<div>시간대 선택</div>
										<select class="modal-select-time" name="reservationTime">
										</select>
										<input type="hidden" name = "storeIdx" value="${vo.storeIdx }">
									</div>
									<div class="button-location">
										<button type="button" class="reservation-button" id="reservation-submit-button">예약접수</button>
										<button type="button" class="reservation-button" id="reservation-close-button">닫기</button>
									</div>
								</div>
							</div>
						</div>
					</form>
					<!-- 모달끝  -->
				</div>
				<h2 id="delivery">주문</h2>
				<h4>집에서 즐기세요</h4>
				<div class="delivery">
					<div class="goods">
						<a><img class="store-intro-img"
							src="/f5/resources/images/sample5.jpg"></a>
						<div>볶음밥</div>
						<div>10원</div>
					</div>
					<div class="goods">
						<a><img class="store-intro-img"
							src="/f5/resources/images/sample5.jpg"></a>
						<div>볶음밥</div>
						<div>10원</div>
					</div>
					<div class="goods">
						<a><img class="store-intro-img"
							src="/f5/resources/images/sample5.jpg"></a>
						<div>볶음밥</div>
						<div>10원</div>
					</div>
				</div>
			</div>
				<nav aria-label="Pagination">
					<hr class="my-0" />
					<ul class="pagination justify-content-center my-4">
						<li class="page-item disabled"><a class="page-link" href="#"
							tabindex="-1" aria-disabled="true">Newer</a></li>
						<li class="page-item active" aria-current="page"><a
							class="page-link" href="#!">1</a></li>
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