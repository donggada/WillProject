<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String id=(String)session.getAttribute("Member_id");
String snsid=(String)session.getAttribute("Member_snsid");
String totalId = null;
if(id !=null){
	totalId=id;
}else if(snsid!=null){
	totalId=snsid;
}else{
	totalId="";
}
out.println(totalId);
%>   
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>WillRent - ReviewWrite</title>


<!--예약검색하는 javascript입니다  -->
<script type="text/javascript">
function bookSearch(){
	var totalId=document.reviewForm.member_id.value
    window.open("BookCheck.rw?id="+totalId,"예약검색","width=500,height=300");
}
</script>

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
                        <form action="ReviewWritePro.rw" method="post" enctype="multipart/form-data" name="reviewForm">
                            <div class="input-submit">
								<input type="button" value="예약검색" onclick="bookSearch()">
                            </div>
                            <div class="row">
                                <div class="col-lg-6 col-md-6">
                                    <div class="website-input">
                                        <input type="text" placeholder="ID" name="member_id" id="member_id" value="<%=totalId%>">
                                    </div>
                                </div>

                                <div class="col-lg-6 col-md-6">
                                    <div class="website-input">
                                        <input type="text" placeholder="예약번호" name="book_num" id="book_num">
                                    </div>
                                </div>

                                <div class="col-lg-6 col-md-6">
                                    <div class="website-input">
                                        <input type="text" placeholder="차량정보" name="car_id" id="car_id">
                                    </div>
                                </div>
                                 <div class="col-lg-6 col-md-6">
                                    <div class="website-input">
                                        <input type="text" placeholder="인수일" name="pickup_date" id="pickup_date">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-6 col-md-6">
                                    <div class="subject-input">
                                        <input type="text" placeholder="제목" name="review_subject">
                                    </div>
                                </div>

                                <div class="col-lg-6 col-md-6">
                                    <div class="subject-input">
                                        <input type="text" placeholder="반납일" name="end_date" id="end_date">
                                    </div>
                                </div>
                            </div>

                            <div class="message-input">
                                <textarea cols="30" rows="10" placeholder="내용" name="review_content"></textarea>
                            </div>

                            <div class="row">
                                <div class="col-lg-6 col-md-6">
                                    <div class="subject-input">
                                        <input type="file" placeholder="파일" name="review_file" required="required">
                                    </div>
                                </div>

                                <div class="col-lg-6 col-md-6">
                                    <div class="subject-input">
                                        <input type="password" placeholder="비밀번호" name="review_pass" required="required">
                                    </div>
                                </div>
                            </div>

                            <div class="input-submit">
                                <button type="submit" class="btn" >등록</button>
                                <button type="reset" class="btn" onclick="history.back()">취소</button>
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