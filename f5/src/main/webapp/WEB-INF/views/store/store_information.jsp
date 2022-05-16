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
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script src="/f5/resources/js/store/store_information.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#review_submit').on('click',function(){
			review_form.submit();
		});
		var pager = jQuery('#ampaginationsm').pagination({
			
		    maxSize: 7,	    		// max page size
		    totals: '${dbCount}',	// total pages	
		    page: '${reqPage}',		// initial page		
		    pageSize: '${pageSize}',			// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		

		});
		
		jQuery('#ampaginationsm').on('am.pagination.change',function(e){
			   jQuery('.showlabelsm').text('The selected page no: '+e.page);
	           $(location).attr('href', "http://localhost:9000/f5/store.do?rpage="+e.page);         
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
				<h2>댄싱 홍콩 강남1호점</h2>
				<div class="store-intro-img-box">
					<img class="button_before" src="/f5/resources/images/before_button.png">
					<div id="img-div-cover">
						<div id="img-div"></div>
					</div>
					<img class="button_next" src="/f5/resources/images/next_button.png">
				</div>
				<h2>평점 4.6</h2>
				<h2 id="intro">#핫플레이스 #중국 #친절</h2>
				<div class="store-intro-box">
					<div class="store-intro-maintext-box">
						<div class="store-intro-text-box">
							<ul>
								<li>${vo.store_name }</li>
								<li>${vo.store_place }</li>
								<li>${vo.store_tel }</li>
								<li>${vo.store_category }</li>
								<li>가격대 : 6천원 ~ 4만원</li>
								<li>주차 : 무</li>
								<li>웹사이트 : www.hongkong.co.kr</li>
							</ul>
						</div>
						<div class="store-intro-icon-box">
							<a><img class="store-intro-img-2" src="/f5/resources/images/store-img-review.jpeg"></a>
							<div>리뷰쓰기</div>
							<a><img class="store-intro-img-2" src="/f5/resources/images/store-img-thumbup.jpeg"></a>
							<div>추천하기</div>
						</div>
					</div>
					<div class="store-intro-map" id="location">
						<a><img class="store-intro-img" src="#"></a>
					</div>
				</div>
				<h2 id="review">리뷰</h2>
				<h4>나도한마디</h4>
				<div class="store-review">
					<div class="store-user">
						<div class="score-mobile">
							<div>
								<div>
									<img src="#">
								</div>
								<div>나는야단골</div>
							</div>
							<div class="review-score-2">4.5</div>
						</div>
						<div class="store-review-content">
							<div class="review-score">4.5</div>
							<div class="review-text">너무너무 맛있어서 기절할것같아요.</div>
						</div>
					</div>
					<div class="store-user">
						<div class="score-mobile">
							<div>
								<div>
									<img src="#">
								</div>
								<div>나는야안티</div>
							</div>
							<div class="review-score-2">1.0</div>
						</div>
						<div class="store-review-content">
							<div class="review-score">1.0</div>
							<div class="review-text">개노맛</div>
						</div>
					</div>
					<div class="store-user">
						<div class="score-mobile">
							<div>
								<div>
									<img src="#">
								</div>
								<div>나는야시인</div>
							</div>
							<div class="review-score-2">2.0</div>
						</div>
						<div class="store-review-content">
							<div class="review-score">2.0</div>
							<div class="review-text">양파의단맛과 알싸함의 조합이 첫사랑처럼 다가왔다.</div>
						</div>
					</div>
					<form name="review_form" action="store_information.do" method="POST">
					<div class="review-write-box">
						<input class="review-write" type="text" placeholder="리뷰를 작성해주세요" name = "review_content">
						<select name ="review_score">
								<option>별점주기</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
						</select>
						<input type="hidden" name = "store_idx" value="${vo.store_idx }">
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
									<div class="modal-input">
										<div>인원수 선택</div>
										<select class="modal-select-number" name="reservation_count">
											<option>--선택--</option>
											<option>1명</option>
											<option>2~3명</option>
											<option>4~5명</option>
											<option>6명 이상</option>
										</select>
										<div>시간대 선택</div>
										<select class="modal-select-time" name="reservation_date">
											<option>--선택--</option>
											<option>오전</option>
											<option>점심시간</option>
											<option>13:00~15:00</option>
											<option>15:00~17:00</option>
											<option>저녘시간</option>
											<option>20:00 이후</option>
										</select>
										<input type="hidden" name = "store_idx" value="${vo.store_idx }">
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