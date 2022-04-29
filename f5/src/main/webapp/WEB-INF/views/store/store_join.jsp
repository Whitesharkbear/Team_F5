<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/f5/resources/css/store/store_join.css" rel="stylesheet" />
<link href="/f5/resources/css/head_nav.css" rel="stylesheet" />
<body>
<jsp:include page="../header.jsp"></jsp:include>
	<div class="head-nav-container">
		<label class="head-nav-title">Mypage</label>
		<div class="head-nav-inner">
			<ul class="nav-col-ul">
				<li><a href="#">매장관리</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">1:1문의</a></li>
				<li><a href="#">환경설정</a></li>
				<li><a href="#"></a></li>
			</ul>
		</div>

	</div>
	<div class="container">
	<div class="con">
        <!-- header -->
        <!-- wrapper -->
        
        
        <table class="store-info">
        <colgroup>
        	<col width="20%">
        	<col width="80%">
        </colgroup>
        	<tr>
        		<td><img src="resources/images/user.png"></td>
        		<td rowspan="2"><h1 style="text-align: center;">Username님, 환영합니다!</h1></td>
        	</tr>
        	<tr>
        		<td style="text-align: center">
        			<button class="profile-change-btn">프로필 사진변경</button>
        		</td>
        	</tr>
        </table>
        
        
        <div id="table-wrap">
            <!-- content-->
            <table class="store-table">
            <colgroup>
            	<col width="30%">
            	<col width="15%">
            	<col width="5%">            	
            	<col width="30%">
            	<col width="15%">
            	
            </colgroup>
            	<tr><td colspan="5">가게상호명</td></tr>
            	<tr>
            		<td colspan="5"><input type="text"></td>
            	</tr>
            	
            	<tr><td colspan="5">주소</td></tr>
            	<tr>
            		<td colspan="5"><input type="text"></td>
            	</tr>
            	
            	<tr><td colspan="5">전화번호</td></tr>
            	<tr>
            		<td colspan="5"><input type="text"></td>
            	</tr>
            	
            	<tr><td colspan="5">메뉴 유형</td></tr>
            	<tr>
            		<td>
            			<select>
            				<option>한식</option>
            				<option>양식</option>
            				<option>중식</option>
            				<option>일식</option>
            			</select>
					</td>
            	</tr>
            	
            	<tr><td colspan="5">가격대</td></tr>
            	<tr class="flex-rw">
            		<td><input class="min" type="text"></td>
					<td>
						<select>
							<option>천원</option>
							<option>만원</option>
						</select>
					</td>
					<td>
						~ 
					</td>
					
					<td><input class="max" type="text"></td>
					<td style="text-align: center">
						<select>
							<option>천원</option>
							<option>만원</option>
						</select>
					</td>	

            	</tr>
            	
            	<tr><td colspan="5">주차</td></tr>
            	<tr>
            		<td colspan="5">
            			<select>
            				<option>유</option>
            				<option>무</option>
            			</select>
            		</td>
            	</tr>
            	
            	<tr><td colspan="5">웹사이트</td></tr>
            	<tr>
            		<td colspan="5"><input type="text"></td>
            	</tr>
            	
            	<tr><td colspan="5">파일첨부</td></tr>
            	<tr>
            		<td colspan="5">
            			<div class="file-add">
            				<button>+</button>
            				<button>+</button>
            				<button>+</button>
            				<button>+</button>
            				<button>+</button>
            			</div>
            		</td>
            	</tr>
            	
            </table>


	       <!-- JOIN BTN-->
	       <div class="btn_area">
	           <button type="button" id="btnJoin">
	               <span>변경하기</span>
	           </button>
	       </div>

                

            

        </div> 
        <!-- wrapper -->
      </div>
 	</div>
   <jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>