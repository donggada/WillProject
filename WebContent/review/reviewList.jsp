<%@page import="review.vo.PageInfo"%>
<%@page import="review.vo.ReviewBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<ReviewBean> articleList = (ArrayList<ReviewBean>)request.getAttribute("articleList");
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
int listCount = pageInfo.getListCount();
int nowPage = pageInfo.getPage();
int maxPage = pageInfo.getMaxPage();
int startPage = pageInfo.getStartPage();
int endPage = pageInfo.getEndPage();
%>    
    
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<!--  -->	
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--=== Favicon ===-->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

    <title>WillRent - Review</title>

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
    
  <!--== Car List Area Start ==-->
							<%if(articleList != null && listCount>0){%>
    <div id="blog-page-content" class="section-padding">
        <div class="container">
            <div class="row">
                <!-- Single Articles Start -->
                <div class="col-lg-12">
                    <article class="single-article">
                        <div class="row">
<%							for(int i=0; i<articleList.size(); i++) {%>
                        <!-- Articles Thumbnail Start -->
                            <div class="col-lg-5">
                                <div class="article-thumb">
                                    <img src="reviewUpload/<%=articleList.get(i).getReview_file()%>" alt="JSOFT">
                                </div>
                            </div>
                            <!-- Articles Thumbnail End -->
							<!-- Articles Content Start -->
                            <div class="col-lg-7">
                                <div class="display-table">
                                    <div class="display-table-cell">
                                        <div class="article-body">
                                            <h3><a href="ReviewDetail.rw?review_num=<%=articleList.get(i).getReview_num() %>&page=<%=nowPage %>"><%=articleList.get(i).getReview_subject() %></a></h3>
                                            <div class="article-meta">
                                                <a class="author">작성자 <span><%=articleList.get(i).getMember_id() %></span></a>
                                                <a class="commnet">추천 <span><%=articleList.get(i).getReview_recocount() %></span></a>
                                                <a class="commnet">조회수 <span><%=articleList.get(i).getReview_readcount() %></span></a>                                            </div>
                                            <div class="article-date"><span class="month"><%=articleList.get(i).getReview_date() %></span></div>
										    <a href="ReviewDetail.rw?review_num=<%=articleList.get(i).getReview_num() %>&page=<%=nowPage %>" class="readmore-btn">보기<i class="fa fa-long-arrow-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Articles Content End -->
                        <%} %>
        				</div>
                    </article>
                </div>
                <!-- Single Articles End -->
            </div>
        </div>
    </div>
    <%} %>
    <!--== Car List Area End ==-->
    
	<!-- Page Pagination Start -->
      <div id="blog-page-content" class="section-padding">
        <div class="container">
            <div class="row">
                <!-- Page Pagination Start -->
                <div class="col-lg-12">
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
                	%>
                 <a href="ReviewWriteForm.rw" class="readmore-btn">글쓰기</a>
                 <%} %>
                    <div class="page-pagi">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <%if(nowPage<=1) {%>
                                <li class="page-item"><a class="page-link">Previous</a></li>
                                <%}else{ %>
                                <li class="page-item"><a class="page-link" href="ReviewList.rw?page=<%=nowPage-1 %>">Previous</a></li><%} %>
                                
                                <%for(int a=startPage; a<=endPage; a++){
                                	if(a==nowPage){%>
                                	<li class="page-item active"><a class="page-link"><%=a %></a><%}else{ %>
                                	
                                <li class="page-item"><a class="page-link" href="ReviewList.rw?page=<%=a %>"><%=a %></a>
                                <%} %>
                                <%} %>
                                
                               <%if(nowPage>=maxPage){ %>
                               <li class="page-item"><a class="page-link" href="#">Next</a>
                               <%}else{ %>
                                <li class="page-item"><a class="page-link" href="ReviewList.rw?page=<%=nowPage+1 %>">Next</a><%} %>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- Page Pagination End -->
            </div>
        </div>
    </div>
    <!--== Car List Area End ==-->

    <!--== Footer Area Start ==-->
   <jsp:include page="../inc/Footer.jsp" />
</body>
</html></html>