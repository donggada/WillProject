<%@page import="book.vo.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <%
      String snsid = (String)session.getAttribute("snsid");
      String id = (String)session.getAttribute("id");

      String pickup = request.getParameter("pickup_date"); 
      String end = request.getParameter("end_date"); 
      String carid = request.getParameter("car_id"); 
      String rentprice = request.getParameter("rentprice");
      String SelCarType = request.getParameter("SelCar"); 

		BookBean bb = (BookBean)request.getAttribute("bookList");
    %>
    
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="style.css" rel="stylesheet">
  <link href="QnA/QnA11/bootstrap.css" rel="stylesheet">
 <link href="QnA/QnA11/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

 <jsp:include page="/inc/Header.jsp"></jsp:include>
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

    <jsp:include page="/inc/Header.jsp"></jsp:include>
    <!--== Header Area End ==-->

    <!--== Page Title Area Start ==-->
    <section id="page-title-area" class="section-padding overlay">
        <div class="container">
            <div class="row">
                <!-- Page Title Start -->
                <div class="col-lg-12">
                    <div class="section-title  text-center">
                        <h2>BOOK List</h2>
                        <span class="title-line"><i class="fa fa-car"></i></span>
                        <p>Rental list page</p>
                    </div>
                </div>
                <!-- Page Title End -->
            </div>
        </div>
    </section>
    <!--== Page Title Area End ==-->

    <!--== Car List Area Start ==-->
<body>
<br>
<br>

    <div class="container">
<!--             <div class="row"> -->
<form action="BookForm2.bk" method="post">
                        <div class="single-sidebar">
                            <h3>Rental Result</h3>
                            <div class="sidebar-body">
                                <ul class="recent-tips">
                                    <li class="single-recent-tips">
                                        <div class="recent-tip-thum">
                                            <a href="#"><img src="assets/img/we-do/service1-img.png" alt="JSOFT"></a>
                                        </div>
                                        <div class="recent-tip-body">
                                            <h4><a href="#">예약번호</a></h4>
                                            <span class="date">
<%=bb.getBook_num() %> </span>
                                        </div>
                                    </li>

                                    <li class="single-recent-tips">
                                        <div class="recent-tip-thum">
                                            <a href="#"><img src="assets/img/we-do/service3-img.png" alt="JSOFT"></a>
                                        </div>
                                        <div class="recent-tip-body">
                                            <h4><a href="#">예약일</a></h4>
                                            <span class="date">
                                           <%=bb.getBook_date() %>
                                           </span>
                                        </div>
                                    </li>

                                     <li class="single-recent-tips">
                                        <div class="recent-tip-thum">
                                            <a href="#"><img src="assets/img/we-do/service2-img.png" alt="JSOFT"></a>
                                        </div>
                                        <div class="recent-tip-body">
                                            <h4><a href="#">예약금액</a></h4>
                                            <span class="date"><%=rentprice %></span>
                                        </div>
                                    </li>
                                    
                                    <li class="single-recent-tips">
                                        <div class="recent-tip-thum">
                                            <a href="#"><img src="assets/img/we-do/service3-img.png" alt="JSOFT"></a>
                                        </div>
                                        <div class="recent-tip-body">
                                            <h4><a href="/WillProject/index.jsp">메인으로 돌아가기</a></h4>
                                            <h4><a href="#">마이페이지</a></h4>
                                            <span class="date"><input type="hidden" id="pickup_date" name="pickup_date" value="<%=pickup %>">
                                            
<input type="hidden" id="end_date" name="end_date" value="<%=end %>">
                                            </span>
                                        </div>
                                    </li>
                                    
                                    

                                </ul>
                            </div>
                        </div>
            </form>
            

<br>
<br>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Articles Content End -->
                        </div>
                    </article>
                </div>
                <!-- Single Articles End -->

                

            
            </div>

            <div class="row">

            </div>
        </div>
    </div>
  <jsp:include page="/inc/Footer.jsp"></jsp:include>

</body>
</html>