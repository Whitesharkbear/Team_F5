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
	$(document).ready(function(){
		/* review_table(); */
		show_review_page(1);
/* 		$('#review_submit').on('click',function(){
			review_form.submit();
		}); */
		$("#more-review-button").on("click",function(){
			var rpage = $("#review-page").val();
			show_review_page(rpage);
		});
		$("#close-review-button").on("click",function(){
			show_review_page(1);
			});
		});
		
	function show_review_page(rpage){
		/* var rpage = $("#review-page").val(); */
		if(rpage == 1){
			$("#close-review-button").css("display","none");
		}else{
			$("#close-review-button").css("display","block");
		}
		
		$.ajax(
				{
					url :"store_information_review.do?rpage="+rpage,
				/* 	data:{"rpage" : rpage,"storeIdx" : storeIdx},
					datatype : "json", */
					success : function(content){
						/*  alert("ajax 성공"+content);  */
						const reviewObject=JSON.parse(content);
						//for(var k=0; k=reviewObject.jlist.length; k++){
							var str='<div id="review_table">';
							for(var k in reviewObject.jlist){
								str +='<div class="store-user">';
								str +='<div class="score-mobile">';
								str +='<div><div><img src="#"></div>';
								str +='<div>'+reviewObject.jlist[k].memberId+'</div></div>';
								str +='<div class="review-score-2">'+reviewObject.jlist[k].reviewScore+'</div></div>';
								str +='<div class="store-review-content">';
								str +='<div class="review-score">'+reviewObject.jlist[k].reviewScore+'</div>';
								str +='<div class="review-text" id="div'+reviewObject.jlist[k].reviewIdx+'">'+reviewObject.jlist[k].reviewContent+'</div>';
								str +='<input type = "hidden" class="review-text-update" placeholder ="'+reviewObject.jlist[k].reviewContent+'" id="input'+reviewObject.jlist[k].reviewIdx+'">';
								str +='<div class="review-update-div" id="update'+reviewObject.jlist[k].reviewIdx+'">';
								str +='<button class = "review-update-cancle" id="'+reviewObject.jlist[k].reviewIdx+'">취소</button>';
								str +='<button class = "review-update-submit" id="'+reviewObject.jlist[k].reviewIdx+'">수정완료</button></div>';
								str +='<div class="div'+reviewObject.jlist[k].memberId+'" id="review_control'+reviewObject.jlist[k].reviewIdx+'">';
								str +='<button class = "review-delete-button" id="'+reviewObject.jlist[k].reviewIdx+'">삭제</button>';
								str +='<button class = "review-update-button" id="'+reviewObject.jlist[k].reviewIdx+'">수정</button></div></div></div>';

						}
							str +='</div>';
								$("#review_table").remove();
								$("#review-page").after(str);
								$("#review-page").val(parseInt(rpage)+1);
								$(".review-update-div").css("display","none");
								for(var k in reviewObject.jlist){
									var sessionMemberId = '${sessionScope.memberId}'
									var memberId = reviewObject.jlist[k].memberId;
									if(sessionMemberId != reviewObject.jlist[k].memberId ){
										$('.div'+memberId).css("display","none");
									}else{
										$('.div'+memberId).css("display","block");
									}
									sessionMemberId="";
								}
								
							},
					error : function(){
						alert("ajax 실패");
					}
				}
			);
				}
			$(document).on('click','.review-delete-button',function(){
				var delete_check = confirm("삭제하시겠습니까? 삭제된 정보는 저장되지 않습니다.");
				if(delete_check){
					$.ajax(
						{
							url : "store_review_delete.do?reviewIdx="+$(this).attr('id'),
							success : function(content){
							if(content=='1'){
								alert("삭제에 성공하였습니다.");
								show_review_page(rpage);
						}
								}
							}
						);
						
					}
				});
			$(document).on('click','.review-update-button',function(){
				var sessionMemberId = '${sessionScope.memberId}'
				var review_idx=$(this).attr('id');
				$('.div'+sessionMemberId).css("display","block");
				$('.review-text').css('display','block');
				$('.review-text-update').attr('type','hidden');
				$('.review-update-div').css("display","none");
				$('#update'+review_idx).css("display","block");
				$('#div'+review_idx).css('display','none');
				$('#input'+review_idx).attr('type','text');
				$('#review_control'+review_idx).css('display','none');
			});
		
		$(document).on('click','.review-update-submit',function(){
			var review_idx=$(this).attr('id');
			var update_check = confirm("수정 하시겠습니까?");
			var text = $('#input'+review_idx).val();
			if(update_check){
				$.ajax(
					{
						url : "store_review_update.do?reviewIdx="+review_idx+"&reviewContent="+text,
						success : function(content){
							if(content=='1'){
								alert("수정되었습니다.");
								$('#update'+review_idx).css("display","none");
								$('#review_control'+review_idx).css('display','block');
								$('#input'+review_idx).attr('type','hidden');
								$('#div'+review_idx).css('display','block');
								show_review_page(rpage);
							}
						}
					}
				);
			}
		});
		$(document).on('click','.review-update-cancle',function(){
			var review_idx=$(this).attr('id');
			$('#update'+review_idx).css("display","none");
			$('#review_control'+review_idx).css('display','block');
			$('#input'+review_idx).attr('type','hidden');
			$('#div'+review_idx).css('display','block');
		});
				
</script>
<style type="text/css">
	.more-review{
		width : 100%;
		border-style: none;
		background-color: white;
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
								<li>${vo.storeName }</li>
								<li>${vo.storePlace }</li>
								<li>${vo.storeTel }</li>
								<li>${vo.storeCategory }</li>
							<li>가격대 : ${vo.storePrice }</li>
								<li>주차 : ${vo.storeParking }</li>
								<li>웹사이트 : ${vo.storeWebSite }</li>
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
				<input type="hidden" id = "review-page" value = "1">
				
					<div>
						<button type="button" class = "more-review" id="more-review-button">더보기</button>
						<button type="button" class = "more-review" id="close-review-button">접기</button>
					</div>
					<form name="review_form" action="store_information.do" method="POST">
					<div class="review-write-box">
						<input class="review-write" type="text" placeholder="리뷰를 작성해주세요" name = "reviewContent">
						<select name ="reviewScore">
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
											<option>--선택--</option>
											<option value=1>오전</option>
											<option value=2>점심시간</option>
											<option value=3>13:00~15:00</option>
											<option value=4>15:00~17:00</option>
											<option value=5>저녘시간</option>
											<option value=6>20:00 이후</option>
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