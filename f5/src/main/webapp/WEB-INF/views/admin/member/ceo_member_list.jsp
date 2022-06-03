<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | CEO회원관리</title>
<link href="/f5/resources/css/admin/member/member_list.css" rel="stylesheet" />
<link rel="stylesheet" href="http://localhost:9000/f5/resources/css/am-pagination.css">
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/f5/resources/js/am-pagination.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$(document).on('click', ".black_list", function(){
		var memberId = $(this).attr("id");
		if ( $(this).val() == "0" ) {
			$.ajax({
				url : "member_black_insert.do?id="+memberId,
				success : function(msg) {
					
					if ( msg == "success" ) {
						$("#"+memberId).css("background-color", "orange").text("석방");
						$("#"+memberId).val(1);
					} else {
						
						alert("fail");
					}
				}
			});
		} else {
			
			$.ajax({
				url : "member_black_out.do?id=" + memberId,
				success : function(msg) {
					
					if ( msg == "success" ) {
						
						$("#"+memberId).css("background-color", "brown").text("추가");
						$("#"+memberId).val(0);
					} else {
						
						alert("fail");
					}
				}
			});
		}
	});
	
	$(".closing").click(function(){
		var storeIdx = $(this).attr("id");
		$.ajax({
			url : "store_close.do?idx="+storeIdx,
			success : function(msg) {

				if ( msg == "succ" ) {
					$(this).remove();
				} else {
					
					console.log("Asdfdsdg");
				}
			}
		});
	});
});
</script>
</head>
<body>
	<jsp:include page="../header.jsp" />
		<div class="container">
			<div class="row">
				<div id="content">
					<h4>CEO회원관리</h4>
					<table id="member_table">
						<colgroup>
								<!-- 번호 -->
								<col width="10%">
								<!-- 이름 -->
								<col width="15%">
								<!-- 아이디 -->
								<col width="15%">
								<!-- 회원권한 -->
								<col width="15%">
								<!-- 블랙리스트 -->
								<col width="17%">
								<!-- 탈퇴 -->
								<col width="13%">
							</colgroup>
							<tr>
								<th>번호</th><th>이름</th><th>아이디</th><th>매장이름</th><th>블랙리스트</th><th>폐점신청</th>
							</tr>
							<c:forEach var="vo" items="${ list }">
								<tr>
									<td>${ vo.rno }</td>
									<td>${ vo.memberName }</td>
									<td><a href="ceo_member_content.do?id=${ vo.memberId }&rno=${ vo.rno }">${ vo.memberId }</a></td>
									<td>
									<label><a href="store_information.do?idx=${ vo.storeIdx }">${ vo.storeName }</a></label>
									</td>
									<td>
										<button value="0" class="black_list" id="${ vo.memberId }">승인</button>
									</td>
									<td>
										<button value="0" class="closing" id="${ vo.storeIdx }">승인</button>
									</td>
								</tr>
							</c:forEach>
					</table>
					<div class="search">
						<div class="search_text">
							<select class="search_type">
								<option value="n" <c:if test="${ search_type eq 'n' }">selected</c:if>>이름</option>
								<option value="i" <c:if test="${ search_type eq 'i' }">selected</c:if>>아이디</option>
								<option value="ni" <c:if test="${ search_type eq 'ni' }">selected</c:if>>이름/아이디</option>
								<option value="s" <c:if test="${ search_type eq 's' }">selected</c:if>>가게명</option>
							</select>
							<input type="text" id="searchbar" 
							placeholder="  검색어를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='  검색어를 입력해주세요.'">
							<button type="button" class="search_btn" onclick="search()">검색</button>
						</div>
					</div>
					<div class="paging">
						<div id="ampaginationsm"></div>
					</div>
				</div>
			</div>
		</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>