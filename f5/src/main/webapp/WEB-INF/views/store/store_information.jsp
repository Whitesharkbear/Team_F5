<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gangnam Foodly</title>
<link href="/f5/resources/css/store/store_information.css"
	rel="stylesheet" />
<script type = "text/javascript" src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> --%>
<script type = "text/javascript" src="/f5/resources/js/store/store_information.js"></script>


<script type="text/javascript">
	var sessionmemberId = '${sessionScope.memberId}'
	var storeIdx = '${vo.storeIdx}'
	var store_intro_img_list = ['${vo.suFile1}','${vo.suFile2}','${vo.suFile3}','${vo.suFile4}','${vo.suFile5}'];
   	var k=0;
	var start_x;
	var end_x;
	var move_x;
   	var move_width = -(k*310);
	$(document).ready(function(){
		
/* 		img_bar(); */
   		
   		/* function img_bar(){ */
	/*	for(var i=1; i<6; i++){
			store_intro_img_list.push({"img":"/f5/resources/images/sample"+i+".jpg"});
		}*/
		var img_slider = "";
		img_slider +="<ul class ='store-intro-img-ul'>";
		for(var i=0; i<Object.keys(store_intro_img_list).length; i++){
			img_slider+="<li><a class = 'img-cover'><img class = 'store-intro-img' src='http://localhost:9000/f5/resources/upload/"+store_intro_img_list[i]+"'></a></li>";
		}
		img_slider += "</ul>";
 		$('#img-div').empty(); 
		$('#img-div').append(img_slider);
		
/* } */
  if(matchMedia("screen and (max-width: 768px)").matches){
		var imgdiv = document.getElementById('img-div');
		imgdiv.addEventListener('touchstart',touch_start);
		imgdiv.addEventListener('touchend',touch_end);
		imgdiv.addEventListener('touchmove',touch_move);
		function touch_start(event){
			start_x = (event.touches[0].pageX)+move_width;
		};
 	 }	
	});//documnet ready
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
		<label class="head-nav-title">Store Inroduce</label>
		<div class="head-nav-inner">
			<ul class="nav-col-ul">
				<li><a href="">??????</a></li>
				<li><a href="#location">??????</a></li>
				<li><a href="#review">??????</a></li>
				<li><a href="#reservation">??????</a></li>
				<li><a href="#delivery">??????</a></li>
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
						<div id="img-div">
						</div>
					</div>
					<img class="button_next" src="/f5/resources/images/next_button.png">
				</div>
				<h2 id = "average-score"></h2>
				<h2 id="intro">#?????? #????????? #Instagram</h2>
				<div class="store-intro-box">
					<div class="store-intro-maintext-box">
						<div class="store-intro-text-box">
							<ul>
								<li>${vo.storeName }</li>
								<li>${vo.storePlace }</li>
								<li>${vo.storeTel }</li>
								<li>${vo.storeCategory }</li>
							<li>????????? : ${vo.storePrice }</li>
								<li>?????? : ${vo.storeParking }</li>
								<li>???????????? : ${vo.storeWebSite }</li>
							</ul>
						</div>
<!-- 						<div class="store-intro-icon-box">
							<a><img class="store-intro-img-2" src="/f5/resources/images/store-img-review.jpeg"></a>
							<div>????????????</div>
							<a><img class="store-intro-img-2" src="/f5/resources/images/store-img-thumbup.jpeg"></a>
							<div>????????????</div>
						</div> -->
					</div>
					<div class="store-intro-map" id="location">
						<a><img class="store-intro-img" src="#"></a>
					</div>
				</div>
				<h2 class ="font-com" id="review">??????</h2>
				<h4>Comment</h4>
				<div class="store-review">
				<input type="hidden" id = "review-page" value = "1">
				<input type="hidden" id = "myreview-page" value = "1">
				
					<div>
						<button type="button" class = "more-review" id="my-review-list">????????????</button>
						<button type="button" class = "more-review" id="all-review-list">???????????????</button>
						<button type="button" class = "more-review" id="more-review-button">?????????</button>
						<button type="button" class = "more-review" id="close-review-button">??????</button>
					</div>
					<form name="review_form" action="store_information.do" method="POST">
					<div class="review-write-box">
						<input class="review-write" type="text" placeholder="????????? ??????????????????" name = "reviewContent" >
						<select name ="reviewScore" id ="review-score-select">
								<option>????????????</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
						</select>
						<input type="hidden" name = "storeIdx" value="${vo.storeIdx }">
						<button id = "review_submit" class="review-button" type="button">????????????</button>
					</div>
					</form> 
				</div><hr><br>
				<div class="reservation" id="reservation">
					<h2 class ="font-com">??????</h2>
					<h5>Store Schedule</h5>
					<div class="sec_cal">
						<div class="cal_nav">
							<a href="javascript:;" class="nav-btn go-prev"><<</a>
							<div class="year-month"></div>
							<a href="javascript:;" class="nav-btn go-next">>></a>
						</div>
						<div class="dates"></div>
					</div>
					<!-- ?????????-->
					<form name="store_information_reservation_form"
						action="store_information.do" method="post">
						<div class="reservation-modal">
							<div class="modal-window">
								<div class="modal-title">????????????</div>
								<div class="modal-contents">
									<div class="selected-date"></div>
									<input type="hidden" name = "reservationTimeDate" class="selected-date-hidden">
									<div class="modal-input">
										<div>????????? ??????</div>
										<select class="modal-select-number" name="reservationCount">
											<option>--??????--</option>
											<option value=1>1???</option>
											<option value=3>2~3???</option>
											<option value=5>4~5???</option>
											<option value=10>6??? ??????</option>
										</select>
										<div>????????? ??????</div>
										<select class="modal-select-time" name="reservationTime">
										</select>
										<input type="hidden" name = "storeIdx" value="${vo.storeIdx }">
									</div>
									<div class="button-location">
										<button type="button" class="reservation-button" id="reservation-submit-button">????????????</button>
										<button type="button" class="reservation-button" id="reservation-close-button">??????</button>
									</div>
								</div>
							</div>
						</div>
						<br><hr>
					</form>
					<!-- ?????????  -->
				</div>
				<br><hr><br>
				<h2 class ="font-com" id="delivery">??????</h2>
				<h4>Order Product</h4>
				<div class="delivery">
					<div class="goods">
						<a><img class="store-intro-img"
							src="/f5/resources/images/?????????3.jpeg"></a>
						<div>??????</div>
						<div>100???</div>
					</div>
					<div class="goods">
						<a><img class="store-intro-img"
							src="/f5/resources/images/?????????1.jpeg"></a>
						<div>????????????</div>
						<div>10???</div>
					</div>
					<div class="goods">
						<a><img class="store-intro-img"
							src="/f5/resources/images/?????????4.jpeg"></a>
						<div>?????????</div>
						<div>10???</div>
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