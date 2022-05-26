<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/f5/resources/css/head_nav.css" rel="stylesheet" />
<link href="/f5/resources/css/board/board.css" rel="stylesheet" />
<script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/f5/resources/js/am-pagination.js"></script>
<script>
	
	$(document).ready(function() {
		
		
		$("select[name=selectBox]").change(function() {
			var selectValue = $(this).val();
			
			$.ajax({
				url: "board_change.do",
				type: "POST",
				data: {
					"boardCategory" : selectValue
				},
				success: function(result){
					var jdata = JSON.parse(result);
					var table = "";
					$(".tr-sec").remove();
					
					for(var i in jdata.jlist) {
						table += "<tr class='tr-sec'>";
						table += "<td class='board-table-col1'>"+jdata.jlist[i].rno+"</td>";
						table += "<td class='board-table-col2'><a href='board_content.do?boardIdx="+jdata.jlist[i].boardIdx+"'>"+jdata.jlist[i].boardTitle+"</a></td>";
						table += "<td class='board-table-col3'>"+jdata.jlist[i].memberId+"</td>";
						table += "<td class='board-table-col4'>"+jdata.jlist[i].boardHits+"</td>";
						table += "<td class='board-table-col5'>"+jdata.jlist[i].boardDate+"</td>";
						table += "</tr>";
					}
					
					$(".tr-sec1").after(table);
				},
				error: function(result) {
					alert("실패"+result);
				}
			});
			
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
				<li><a href="board_list.do">자유게시판</a></li>
				<li><a href="promote_list.do">홍보</a></li>
				<li><a href="#"></a></li>
				<li><a href="#"></a></li>
				<li><a href="#"></a></li>
			</ul>
		</div>
	</div>
	<!-- Page content-->
        <div class="container">
        
            <div class="row">
            	<div class="board_container">
            	<label class="board-caption">Foodly의 대나무 숲</label>
            	<div class="table-top-container">
	            	<select name="selectBox">
						<option value="0">일반</option>
						<option value="1">홍보</option>
						<option value="2">공지</option>
						<option value="3">전체</option>
					</select> <a href="board_write.do">
						<button class="cusbtn btn-board-write" type="button">글쓰기</button>
					</a>
				</div>
				<table class="table list-table">
            			<tr class="tr-sec1">
            				<th class="board-table-col1">순번</th>
            				<th class="board-table-col2">제목</th>
            				<th class="board-table-col3">작성자</th>
            				<th class="board-table-col4">조회수</th>
            				<th class="board-table-col5">작성일</th>
            			</tr>
            			
            			<c:forEach var="vo" items="${list}">
            			<tr class="tr-sec">
            				<td class="board-table-col1">${vo.rno}</td>
            				<td class="board-table-col2"><a href="board_content.do?boardIdx=${vo.boardIdx}">${vo.boardTitle}</a></td>
            				<td class="board-table-col3">${vo.memberId}</td>
            				<td class="board-table-col4">${vo.boardHits}</td>
            				<td class="board-table-col5">${vo.boardDate}</td>
            			</tr>
            			</c:forEach>
            			
            			<tr>
            				<td colspan=5>
            					<select>
            						<option>작성자</option>
            						<option>제목</option>
            						<option>내용</option>
            						<option>제목+내용</option>
            					</select>
            					<input type="search" class="search">
            					<button class="cusbtn">검색</button>
            				</td>
            			</tr>
            			<tr>
            				<td colspan=5><div id="ampaginationsm"></div></td>
            			<tr>
            		</table>
            	</div>
            </div>
        </div>
        <!-- Footer-->
	<jsp:include page="../footer.jsp"></jsp:include>
        <!-- Bootstrap core JS-->
<!--          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> -->
        <!-- Core theme JS-->

</body>
</html>