<%@page import="review.vo.ReviewBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
ReviewBean article = (ReviewBean)request.getAttribute("article");
String nowPage = (String)request.getAttribute("page");
%>    
    
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--=== Favicon ===-->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
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
    
    <title>WillRent - ReviewDetail</title>
<script src="js/jquery-3.5.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#recobtn').click(function(){
		$.ajax({
			url:"ReviewRecoCheck.rw",
			dataType: "json",
			data:{
				review_num:$('#review_num').val(),
				page:$('#page').val()
			},
			success: function(returndata){
				$('#recobtn').html("&#xf087; "+returndata.recoCount);
				
			}
		});
	});
});
</script>
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
        <!--== Header Top End ==-->
<!--== Page Title Area Start ==-->
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
    <!--== Page Title Area End ==-->        
 <section id="car-list-area" class="section-padding">
        <div class="container">
            <div class="row">
                <!-- Car List Content Start -->
                <div class="col-lg-8">
                    <div class="car-details-content">
                        <h2><%=article.getReview_subject() %><span class="price">작성자: <b><%=article.getMember_id() %></b></span></h2>
                        <%if(article.getReview_file()!=null){ %>
                        <div>
                           <img src="reviewUpload/<%=article.getReview_file()%>"><br>
                        </div><%} %>
                        <div class="car-details-info">
                            <p><%=article.getReview_content() %></p>
                            <div class="technical-info">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="tech-info-table">
                                            <table class="table table-bordered">
                                                <tr>
                                                    <th>차량정보</th>
                                                    <td><%=article.getCar_id() %></td>
                                                </tr>
                                                <tr>
                                                    <th>인수일</th>
                                                    <td><%=article.getPickup_date() %></td>
                                                </tr>
                                                <tr>
                                                    <th>반납일</th>
                                                    <td><%=article.getEnd_date() %></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </div>
                         </div>
                        </div>         
<div id="recodiv" class="input-submit">
<input type="hidden" name="review_num" id="review_num" value="<%=article.getReview_num() %>">
<input type="hidden" name="page" id="page" value="<%=nowPage %>">
<Button type="submit" value="추천하기" id="recobtn" class="fa">&#xf087; <%=article.getReview_recocount() %></Button>
</div>
</div>
<%String id=(String)session.getAttribute("Member_id");
  String snsid=(String)session.getAttribute("Member_snsid");
  String totalId = null;
  if(id != null){
      totalId=id;
  }else if(snsid!=null){
      totalId=snsid;
  }%>
  <%
   if(totalId != null){
	   if(totalId.equals(article.getMember_id())){
   %>
<a href="ReviewModifyForm.rw?review_num=<%=article.getReview_num() %>&page=<%=nowPage %>" class="readmore-btn">수정</a>
<a href="ReviewDeleteForm.rw?review_num=<%=article.getReview_num() %>&page=<%=nowPage %>" class="readmore-btn">삭제</a>
<%} }%>
<a href="ReviewList.rw?page=<%=nowPage %>" class="readmore-btn">목록</a>
        </div>
    </section>
    <!--== Car List Area End ==-->        
    <!--== Footer Area Start ==-->
    <jsp:include page="../inc/Footer.jsp" />
</body>
</html>