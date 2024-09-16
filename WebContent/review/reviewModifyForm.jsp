<%@page import="review.vo.ReviewBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ReviewBean article = (ReviewBean)request.getAttribute("article");
String nowPage = request.getParameter("page");
%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>WillRent - ReviewModify</title>
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

    <!--== Header Area Start ==-->
   <jsp:include page="../inc/Header.jsp" />

 <section id="page-title-area" class="section-padding overlay">
        <div class="container">
            <div class="row">
                <!-- Page Title Start -->
                <div class="col-lg-12">
                    <div class="section-title  text-center">
                        <h2>Review</h2>
                        <span class="title-line"><i class="fa fa-car"></i></span>
                        <p></p>
                    </div>
                </div>
                <!-- Page Title End -->
            </div>
        </div>
    </section>  


<div class="contact-page-wrao section-padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 m-auto">
                    <div class="contact-form">
                        <form action="ReviewModifyPro.rw?review_num=<%=article.getReview_num()%>&page=<%=nowPage %>" method="post" enctype="multipart/form-data" name="reviewForm">  
                            <div class="row">
                                <div class="col-lg-6 col-md-6">
                                    <div class="website-input">
                                        <input type="text" placeholder="ID" name="member_id" id="member_id" value="<%=article.getMember_id() %>">
                                    </div>
                                </div>

                                <div class="col-lg-6 col-md-6">
                                    <div class="website-input">
                                        <input type="text" value="<%=article.getBook_num() %>" name="book_num" id="book_num">
                                    </div>
                                </div>

                                <div class="col-lg-6 col-md-6">
                                    <div class="website-input">
                                        <input type="text" value="<%=article.getCar_id() %>" name="car_id" id="car_id">
                                    </div>
                                </div>
                                 <div class="col-lg-6 col-md-6">
                                    <div class="website-input">
                                        <input type="text" value="<%=article.getPickup_date() %>" name="pickup_date" id="pickup_date">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-6 col-md-6">
                                    <div class="subject-input">
                                        <input type="text" name="review_subject" value="<%=article.getReview_subject()%>">
                                    </div>
                                </div>

                                <div class="col-lg-6 col-md-6">
                                    <div class="subject-input">
                                        <input type="text" value="<%=article.getEnd_date() %>" name="end_date" id="end_date">
                                    </div>
                                </div>
                            </div>

                            <div class="message-input">
                                <textarea cols="30" rows="10" name="review_content"><%=article.getReview_content() %></textarea>
                            </div>

                            <div class="row">
                                <div class="col-lg-6 col-md-6">
                                    <div class="subject-input">
                                        <input type="file" name="review_file" value="<%=article.getReview_file()%>" required="required">
                                    </div>
                                </div>

                                <div class="col-lg-6 col-md-6">
                                    <div class="subject-input">
                                        <input type="password" placeholder="비밀번호" name="review_pass" required="required">
                                    </div>
                                </div>
                            </div>

                            <div class="input-submit">
                                <button type="submit" value="등록" class="btn" >등록</button>
                                <button type="reset" value="취소" class="btn" onclick="history.back()">취소</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<!--  -->
    <!--== Footer Area Start ==-->
 <jsp:include page="../inc/Footer.jsp" />
</body>
</html>