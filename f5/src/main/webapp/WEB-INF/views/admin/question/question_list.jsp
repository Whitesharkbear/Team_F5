<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 문의관리</title>
<link href="/f5/resources/css/admin/question/question_list.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function search() {
	
	var search = $("#searchbar").val(); 
	
	if ( search == "" ) {
		
		alert("검색어를 입력해주세요.");
	} else {
		
		alert("검색하신 " + search + " 결과입니다.");
	}
}

/* checkbox 전체 선택/취소 */
$(document).ready(function() {
	$("#cbx_chkAll").click(function() {
		
		if($("#cbx_chkAll").is(":checked")) $("input[name=chk]").prop("checked", true);
		else $("input[name=chk]").prop("checked", false);
	});
	
	$("input[name=chk]").click(function() {
		
		var total = $("input[name=chk]").length;
		var checked = $("input[name=chk]:checked").length;
		
		if(total != checked) $("#cbx_chkAll").prop("checked", false);
		else $("#cbx_chkAll").prop("checked", true); 
	});
});

function modify() {
	
	if ( confirm("선택하신 문의 답변여부를 수정하시겠습니까?") ) {
		
		alert("수정되었습니다.");
	} else {
		
		return;
	}
}

</script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container">
		<div class="row">
			<section>
				<div id="content">
					<h4>관리자 | 문의내역</h4>
					<div class="question_btn">
						<button type="button" onclick="modify()">수정하기</button>
					</div>
					<table id="question_table">
					<colgroup>
							<!-- 선택 -->
							<col width="10%">
							<!-- 번호 -->
							<col width="10%">
							<!-- 문의자 -->
							<col width="15%">
							<!-- 문의제목 -->
							<col width="35%">
							<!-- 문의내용 -->
							<col width="20%">
							<!-- 답변여부 -->
							<col width="10%">
						</colgroup>
						<tr>
							<th><input type="checkbox" id="cbx_chkAll"></th>
							<th>번호</th><th>문의자</th><th>문의제목</th><th>문의날짜</th><th>답변여부</th>
						</tr>
						<% for ( int i = 10; i >= 0; i-- ) { %>
						<tr>
							<td><input type="checkbox" name="chk" value="check<%= i %>"></td>
							<td><%= i %></td>
							<td><a href="member_content.do">user<%= i %></a></td>
							<td><a href="question_content.do">문의<%= i %></a></td>
							<td>2022-05-03</td>
							<td>
								<select>
									<option value="0" selected="selected">대기중
									<option value="1">답변중
									<option value="2">답변완료
								</select>
							</td>
						</tr>
						<% } %>
					</table>
					<div class="search">
						<div class="search_text">
							<input type="text" id="searchbar" 
							placeholder="  검색어를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='  검색어를 입력해주세요.'">
							<button type="button" class="search_btn" onclick="search()">검색</button>
						</div>
					</div>
					<div class="paging">
						<div><< 1  2  3  4  5 >></div>
					</div>
				</div>
			</section>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>