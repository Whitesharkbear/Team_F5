<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/f5/resources/css/store/store.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="row store_content">
                        <div class="col-lg-6">
                            <!-- Blog post-->
                            <div class="store-card mb-4">
                                <a href="#!"><img class="card-img-top" src="/f5/resources/images/sample1.jpg" alt="..." /></a>
                                <div class="card-body">
                                    <h2 class="card-title h4">논현동 최고의 맛집! 4.5</h2>
                                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.</p>
                                    <a class="btn btn-primary" href="store_information.do">매장 보러가기 →</a>
                                </div>
                            </div>
                            <div class="store-card mb-4">
                                <a href="#!"><img class="card-img-top" src="/f5/resources/images/sample2.jpg" alt="..." /></a>
                                <div class="card-body">
                                    <h2 class="card-title h4">논현동 최고의 맛집! 4.3</h2>
                                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.</p>
                                    <a class="btn btn-primary" href="#!">매장 보러가기 →</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <!-- Blog post-->
                            <div class="store-card mb-4">
                                <a href="#!"><img class="card-img-top" src="/f5/resources/images/sample3.jpg" alt="..." /></a>
                                <div class="card-body">
                                    <h2 class="card-title h4">논현동 최고의 맛집 4.2</h2>
                                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.</p>
                                    <a class="btn btn-primary" href="#!">매장 보러가기 →</a>
                                </div>
                            </div>
                            <!-- Blog post-->
                            <div class="store-card mb-4">
                                <a href="#!"><img class="card-img-top" src="/f5/resources/images/sample4.jpg" alt="..." /></a>
                                <div class="card-body">
                                    <h2 class="card-title h4">논현동 최고의 맛집 4.2</h2>
                                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.</p>
                                    <a class="btn btn-primary" href="#!">매장 보러가기 →</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Pagination-->
                    <nav aria-label="Pagination">
                        <hr class="my-0" />
                        <ul class="pagination justify-content-center my-4">
                            <li class="page-item disabled"><a class="page-link" href="#" tabindex="-1" aria-disabled="true">Newer</a></li>
                            <li class="page-item active" aria-current="page"><a class="page-link" href="#!">1</a></li>
                            <li class="page-item"><a class="page-link" href="#!">2</a></li>
                            <li class="page-item"><a class="page-link" href="#!">3</a></li>
                            <li class="page-item disabled"><a class="page-link" href="#!">...</a></li>
                            <li class="page-item"><a class="page-link" href="#!">15</a></li>
                            <li class="page-item"><a class="page-link" href="#!">Older</a></li>
                        </ul>
                    </nav>
                </div>
                <!-- Side widgets-->
                <div class="col-lg-4">
                    <!-- Search widget-->
                    <div class="card mb-4">
                        <div class="card-header">Search</div>
                        <div class="card-body">
							<a><img class = "store-side-img" src = "/f5/resources/images/storesample1.jpeg"></a>
                        </div>
                    </div>
                    <!-- Categories widget-->
                    <div class="card mb-4">
                        <div class="card-header">Categories</div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-6">
                                    <ul class="list-unstyled mb-0">
                                        <li><a href="#!">#중국집</a></li>
                                        <li><a href="#!">#일식집</a></li>
                                        <li><a href="#!">#치킨집</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-6">
                                    <ul class="list-unstyled mb-0">
                                        <li><a href="#!">#분식집</a></li>
                                        <li><a href="#!">#돈까스집</a></li>
                                        <li><a href="#!">#한식집</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Side widget-->
                    <div class="card mb-4">
                        <div class="card-header">이런 검색어는 어떄요?</div>
                       <div class = "card-body"> 
                       <a><img class = "store-side-img" src = "/f5/resources/images/storesample2.jpeg"></a></div>
                        <div class="card-body">
                        	<div><a href = "#">짜장면 맛집 모아보기!</a></div>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>

