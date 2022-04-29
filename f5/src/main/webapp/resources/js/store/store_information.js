 $(document).ready(function() {
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
	    	$(".modal-select-number option:eq(0)").prop("selected",true);
	    	$(".modal-select-time option:eq(0)").prop("selected",true);
		}
		}
	});
   }


