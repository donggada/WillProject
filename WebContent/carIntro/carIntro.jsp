<%@page import="book.vo.PageInfo"%>
<%@page import="book.vo.CarBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	ArrayList<CarBean> articleList = (ArrayList<CarBean>)request.getAttribute("articleList");
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
    int listCount = pageInfo.getListCount();
    int nowPage = pageInfo.getPage();
    int maxPage = pageInfo.getMaxPage();
    int startPage = pageInfo.getStartPage();
    int endPage = pageInfo.getEndPage();
    %>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--=== Favicon ===-->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

    <title>Cardoor - Car Rental HTML Template</title>

    <!--=== Bootstrap CSS ===-->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!--=== Slicknav CSS ===-->
    <link href="assets/css/plugins/slicknav.min.css" rel="stylesheet">
    <!--=== Magnific Popup CSS ===-->
    <link href="assets/css/plugins/magnific-popup.css" rel="stylesheet">
    <!--=== Owl Carousel CSS ===-->
    <link href="assets/css/plugins/owl.carousel.min.css" rel="stylesheet">
    <!--=== Gijgo CSS ===-->
    <link href="assets/css/plugins/gijgo.css" rel="stylesheet">
    <!--=== FontAwesome CSS ===-->
    <link href="assets/css/font-awesome.css" rel="stylesheet">
    <!--=== Theme Reset CSS ===-->
    <link href="assets/css/reset.css" rel="stylesheet">
    <!--=== Main Style CSS ===-->
    <link href="style.css" rel="stylesheet">
    <!--=== Responsive CSS ===-->
    <link href="assets/css/responsive.css" rel="stylesheet">


    <!--[if lt IE 9]>
        <script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="loader-active">

    <!--== Preloader Area Start ==-->
    <div class="preloader">
        <div class="preloader-spinner">
            <div class="loader-content">
                <img src="assets/img/preloader.gif" alt="JSOFT">
            </div>
        </div>
    </div>
    <!--== Preloader Area End ==-->
    <jsp:include page="../inc/Header.jsp" />
    
    <!--== Page Title Area Start ==-->
    <section id="page-title-area" class="section-padding overlay">
        <div class="container">
            <div class="row">
                <!-- Page Title Start -->
                <div class="col-lg-12">
                    <div class="section-title  text-center">
                        <h2>차량소개</h2>
                        <span class="title-line"><i class="fa fa-car"></i></span>
                        <p></p>
                    </div>
                </div>
                <!-- Page Title End -->
            </div>
        </div>
    </section>
    <!--== Page Title Area End ==-->
    <!--== Gallery Page Content Start ==-->
    <section id="gallery-page-content" class="section-padding">
     <%
							if(articleList != null && listCount>0){%>
        <div class="container">
        	<div class="row">
        		<div class="col-lg-12">
					<div class="popular-cars-wrap">
        	
						<!-- Filtering Menu -->
						<div class="popucar-menu text-center">
							<a href="#" data-filter="*" class="active">ALL</a>
							<a href="#" data-filter=".현대">Hyundai</a>
							<a href="#" data-filter=".기아">kia</a>
							<a href="#" data-filter=".쌍용">SsangYong</a>
							<a href="#" data-filter=".삼성">Samsung</a>
							<a href="#" data-filter=".BMW">Bmw</a>
							<a href="#" data-filter=".볼보">volvo</a>
						</div>
						<!-- Filtering Menu -->
       			<%
								for(int i=0; i<articleList.size(); i++) {
										%>
						<div class="row popular-car-gird">
							<!-- Single Popular Car Start -->
							<div class="col-lg-4 col-md-6 <%=articleList.get(i).getCar_maker() %>">
								<div class="single-popular-car">
									<div class="p-car-thumbnails" style="float: left;">
										<a class="car-hover" href="assets/img/car/<%=articleList.get(i).getCar_name() %>.JPG">
										  <img src="assets/img/car/<%=articleList.get(i).getCar_name() %>.JPG" alt="JSOFT">
									   </a>
									</div>

									<div class="p-car-content">
										<h3>
											<a href="#"><%=articleList.get(i).getCar_name() %></a>
											<span class="price"><i class="fa fa-tag"></i> </span>
										</h3>
										
										<h5><%=articleList.get(i).getCar_maker() %></h5>

										<div class="p-car-feature">
											<a href="#">연식 : <%=articleList.get(i).getCar_year() %></a>
											<a href="#">타입 : <%=articleList.get(i).getCar_type() %></a>
											<a href="#">연료 : <%=articleList.get(i).getCar_oil() %></a>
										</div>

										<div class="p-car-feature">
											<a href="#">승차 가능 인원 : <%=articleList.get(i).getCar_people_possible() %></a>
											<a href="#">연비 : <%=articleList.get(i).getCar_cc() %></a>
										</div>
										<div class="p-car-feature">
											<a href="index.jsp" class="rent-btn" style="">Book It</a>
										</div>
									</div>
								</div>
							</div>
							<!-- Single Popular Car End -->
						</div>
						
							<%}%>
        			</div>
        		</div>
        	</div>
        </div>
        	<%}%>
    </section>
    <!--== Gallery Page Content End ==-->
        <!--== Footer Area Start ==-->
    <jsp:include page="../inc/Footer.jsp" />
</body>
</html>