 $(document).ready(function() {
	img_slide()
    calendarInit();
    
});

function calendarInit() {

    var date = new Date(); 
    var utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); 
    var kstGap = 9 * 60 * 60 * 1000; 
    var today = new Date(utc + kstGap); 
  
    var thisMonth = new Date(today.getFullYear(), today.getMonth(), today.getDate());
  
  
    
    var currentYear = thisMonth.getFullYear();
    var currentMonth = thisMonth.getMonth(); 
    var currentDate = thisMonth.getDate();

	renderCalender(thisMonth);

	
    function renderCalender(thisMonth) {

     
        currentYear = thisMonth.getFullYear();
        currentMonth = thisMonth.getMonth();
        currentDate = thisMonth.getDate();

 
        var startDay = new Date(currentYear, currentMonth, 0);
        var prevDate = startDay.getDate();
        var prevDay = startDay.getDay();


        var endDay = new Date(currentYear, currentMonth + 1, 0);
        var nextDate = endDay.getDate();
        var nextDay = endDay.getDay();
		
        var currentMonth_2 =currentMonth + 1;

        $('.year-month').text(currentYear + '.' + (currentMonth + 1));
		var calendar="";
        calendar=calendar +"<table class='days'><tr><th class='day'>MON</th><th class='day'>TUE</th><th class='day'>WED</th><th class='day'>THU</th>"
        +"<th class='day'>FRI</th><th class='day'>SAT</th><th class='day'>SUN</th></tr><tr>"
       
        // 지난달
        for (var i = prevDate - prevDay + 1; i <= prevDate; i++) {
            calendar=calendar+'<td class="day_prev_disable">' + i + '</td>';
            if(prevDate==0){
            	calendar=calendar+'</tr><tr>'
            }
        }
        
        // 이번달
        for (var i = 1; i <= nextDate; i++) {
            calendar=calendar+"<td><span>" + i + "</span><a class ='calendar_reservation' id='"+currentYear+"-"+currentMonth_2+"-"+i+"'>예약하기</a></td>";
            if((i+prevDay)%7 == 0){
            	calendar=calendar+'</tr><tr>'
            }
        }
        calendar.innerHTML = calendar.innerHTML +'</tr><tr>'
        // 다음달
        for (var i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
            calendar=calendar+'<td class="day_next_disable">' + i + '</td>'
        }
       		 calendar=calendar+'</tr></table>'
       	
       /* document.write(calendar); */
       		$('.dates').empty();
       		$('.dates').append(calendar);
    
    }
    $('.go-prev').on('click', function() {
        thisMonth = new Date(currentYear, currentMonth - 1, 1);
        renderCalender(thisMonth);
    });

    $('.go-next').on('click', function() {
        thisMonth = new Date(currentYear, currentMonth + 1, 1);
        renderCalender(thisMonth); 
    });
    $(document).on('click','.calendar_reservation',function(){
    	$('.selected-date').text($(this).attr('id'));
    	$('.selected-date-hidden').val($(this).attr('id'));
    	$('.modal-window').css("display","block");
    	$('.reservation-modal').css("display","block");
    	$('body').css("overflow","hidden");
    });
    $('#reservation-close-button').on('click', function () {
    	$('.modal-window').css("display","none");
    	$('.reservation-modal').css("display","none");
    	$('body').css("overflow","auto");
    	$(".modal-select-number option:eq(0)").prop("selected",true);
    	$(".modal-select-time option:eq(0)").prop("selected",true);
	});
	$('#reservation-submit-button').on('click',function(){
		if($('.modal-select-number option:selected').val() == $(".modal-select-time option:eq(0)").val()){
			alert("인원수를 입력해주세요");
		}else if($('.modal-select-time option:selected').val()==$(".modal-select-time option:eq(0)").val()){
			alert("시간대를 입력해주세요");
		}else{
		var confirm_result=confirm($('.selected-date').text()+" 일 "+ $('.modal-select-number option:selected').val() + " "+$('.modal-select-time option:selected').val()+"(으)로 예약신청하시겠습니까?")
		if(confirm_result){
			alert("예약이 완료되었습니다.");
			$('.modal-window').css("display","none");
	    	$('.reservation-modal').css("display","none");
	    	$('body').css("overflow","auto");
	    	store_information_reservation_form.submit();
	    	$(".modal-select-number option:eq(0)").prop("selected",true);
	    	$(".modal-select-time option:eq(0)").prop("selected",true);
	    	
		}

		}
	});
   }
function img_slide(){
   		var k=0;
		var start_x;
		var end_x;
		var move_x;
   		var store_intro_img_list =[];
   		var move_width = -(k*310);
		img_bar();
   		
   		
   		function img_bar(){
		for(var i=1; i<6; i++){
			store_intro_img_list.push({"img":"/f5/resources/images/sample"+i+".jpg"});
		}
		var img_slider = "";
		img_slider +="<ul class ='store-intro-img-ul'>";

		for(var i=1; i<Object.keys(store_intro_img_list).length+1; i++){
			img_slider+="<li><a class = 'img-cover'><img class = 'store-intro-img' src = '/f5/resources/images/sample"+i+".jpg'></a></li>";
		}
		
		img_slider += "</ul>";
		$('#img-div').empty();
		$('#img-div').append(img_slider);

	}

	$(document).on('click','.button_next',function(){
		if(k!=Object.keys(store_intro_img_list).length-3){
			k++;
			$('#img-div').css({'transform':'translate('+(k)*(-310)+'px,0px)','transition':'all 0.7s'});
		}
		
	});
	$(document).on('click','.button_before',function(){
		if(k!=0){
			k--;
			$('#img-div').css({'transform':'translate('+(k)*(-310)+'px,0px)','transition':'all 0.7s'});
		}
	});
	
	if(matchMedia("screen and (max-width: 768px)").matches){
	var imgdiv = document.getElementById('img-div');
	imgdiv.addEventListener('touchstart',touch_start);
	imgdiv.addEventListener('touchend',touch_end);
	imgdiv.addEventListener('touchmove',touch_move);
	function touch_start(event){
		start_x = (event.touches[0].pageX)+move_width;
	};

	function touch_end(event) {
	  end_x = event.changedTouches[0].pageX;
	  
	  if(start_x > end_x+100){
	  if(k!=Object.keys(store_intro_img_list).length-1){
	  	k++;
		$('#img-div').css({'transform':'translate('+(k)*(-310)+'px,0px)','transition':'all 0.7s'});
		}
	  }else if(end_x>start_x+100){
	  	if(k!=0){
		k--;
		$('#img-div').css({'transform':'translate('+(k)*(-310)+'px,0px)','transition':'all 0.7s'});
		}
	  }
	  else{
			$('#img-div').css({'transform':'translate('+(k)*(-310)+'px,0px)','transition':'all 0.7s'});
		}
	};
	function touch_move(event){
		move_x = event.changedTouches[0].pageX;
		if(start_x>move_x){
			if(k!=Object.keys(store_intro_img_list).length-1){
				$('#img-div').css({'transform':'translate('+(-(start_x-move_x)-(k*310))+'px,0px)','transition':'none'});
			}
		}else{
			if(k!=0){
				$('#img-div').css({'transform':'translate('+((move_x-start_x)-(k*310))+'px,0px)','transition':'none'});
			}
		}
	};
	}
	window.onresize = function(event){
		k=0;
		$('#img-div').css({'transform':'translate(0px,0px)'});
	};
	
};

