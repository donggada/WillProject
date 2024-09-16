
<%@page import="qna.vo.qnaBoardbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	qnaBoardbean article = (qnaBoardbean)request.getAttribute("article");
    String nowPage = (String)request.getAttribute("page");
	String id = (String)session.getAttribute("Member_id");

%>

<!DOCTYPE html>
<html>
<head>
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
                        <h2>1:1 Inquiry List</h2>
                        <span class="title-line"><i class="fa fa-car"></i></span>
                        <p>Don't hesitate to ask me any questions!</p>
                    </div>
                </div>
                <!-- Page Title End -->
            </div>
        </div>
    </section>
    <!--== Page Title Area End ==-->

    <!--== Car List Area Start ==-->
    <div id="blog-page-content" class="section-padding">
        <div class="container">
            <div class="row">
                <!-- Single Articles Start -->
                <div class="col-lg-12">
                    <article class="single-article">
                        <div class="row">
                            <!-- Articles Thumbnail Start -->
                            <div class="col-lg-5">
                                <div class="article-thumb">
                                    <img src="assets/img/article/arti-thumb-1.jpg" alt="JSOFT">
                                       <img src="assets/img/article/arti-thumb-2.jpg" alt="JSOFT">
                                        <img src="assets/img/article/arti-thumb-3.jpg" alt="JSOFT">
                                </div>
                            </div>
                            <!-- Articles Thumbnail End -->

                            <!-- Articles Content Start -->
                            <div class="col-lg-7">
                                <div class="display-table">
                                    <div class="display-table-cell">
                                        <div class="article-body">
                                            <h3><a href="#">1:1 Inquiry</a></h3>
                                            <div class="article-meta">
                                                <a href="#" class="author">By :: <span><%=id%></span></a>
                                                <a href="qnawrite.bo" class="commnet">추가문의하기</a>
                                                <a href="qnaBoardlist.bo?page=<%=nowPage%>" class="commnet">목록</a>
                    
                                            </div>

                                            <div class="article-date">will <span class="month">Rent</span></div>
 <p>

 

              <div class="card mb-3">
                <h5 class="card-header"><%=article.getQnaBoard_id()%>님의 문의내용보기</h5>
                <div class="card-body">
                  <h5 class="card-title"><%=article.getQnaBoard_subject() %></h5>

                </div>
                
                <%if(article.getQnaBoard_file()!=null){ %>
                <img style="height: 200px; width: 100%; display: block;" src="upload/<%=article.getQnaBoard_file() %>" alt="image">
                <%}{} %>
                <div class="card-body">
                
                  <p class="card-text"><%=article.getQnaBoard_content() %></p>
                </div>
                
                
                <ul class="list-group list-group-flush">
           
                  <li class="list-group-item">
                  첨부파일 : 
                  <%if(article.getQnaBoard_file()!=null) {%>
                  <a href="qnaboardfiledowun.bo?file_name=<%=article.getQnaBoard_file()%>"> <%=article.getQnaBoard_file() %>
                  </li></a>
                  <%}else{ %>
                  	첨부파일 없음
                  <%} %>
                </ul>
                <div class="card-footer text-muted">
                 작성일 : <%=article.getQnaBoard_date() %>  
                 <br>
                 <div style="float: right;">
                   <a href="qnawritemodifyform.bo?qnaboard_num=<%=article.getQnaBoard_num() %>&page=<%=nowPage %>" class="card-link">수정</a>
                   <a href="qnaBoardDeleteform.bo?qnaBoard_num=<%=article.getQnaBoard_num() %>&page=<%=nowPage %>" class="card-link">삭제</a>
                </div>
                </div>
              </div>
          
              
   
              
            
              <div class="card mb-3">
              
              
              <%if(id.equals("admin")){%>
                <form action="qnaBoardReplyPro.bo" method="get" name="boardform">
                <h5 class="card-header">관리자 답변</h5>
                <input type="hidden" value="<%=article.getQnaBoard_num()%>" name="qnaBoard_num">
                  <input type="hidden" value="<%=nowPage%>" id="page">
                <div class="card-body">
                    <textarea name="qnaBoard_reply" class="form-control" name="qnaBoard_reply" rows="4"><%if(article.getQnaboard_reply()!=null){ %>
                    <%=article.getQnaboard_reply() %>
                    <%}{} %>
                    </textarea>
                </div>
        		  <ul class="list-group list-group-flush">
                  <li class="list-group-item">
                <div class="card-body" style="text-align: center;">
                 <input type="submit" class="btn btn-secondary disabled" value="답변등록">
                </div>
                  </li>
                </ul>
                </form>
           
           
                <%}else{ %>
                <h3 class="card-header">관리자 답변</h3>
                <input type="hidden" value="<%=article.getQnaBoard_num()%>" name="qnaBoard_num">
                  <input type="hidden" value="<%=nowPage%>" id="page">
                <div class="card-body">
                    <textarea name="qnaBoard_reply" class="form-control" name="qnaBoard_reply" rows="4" readonly="readonly"><%if(article.getQnaboard_reply()!=null){ %>
                    <%=article.getQnaboard_reply()%>
                    <%}{%>
                    	미답변
                   <% } %>
                    </textarea>
                </div>
        		  <ul class="list-group list-group-flush">
              
                </ul>
                <%}%>
                
                
                
                <div class="card-footer text-muted">
                <%if(article.getQnaBoard_reply_date()!=null){ %>
               작성일 : <%=article.getQnaBoard_reply_date()%>
               <%}{ %>
               미답변
               <%} %>
                </div>
              </div>
              </div>
              </div>
      

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
    <!--== Car List Area End ==-->



        <jsp:include page="/inc/Footer.jsp"></jsp:include>

</body>

</html>

