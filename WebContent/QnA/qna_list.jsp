<%@page import="org.apache.el.lang.ELSupport"%>
<%@page import="qna.vo.pageinfo"%>
<%@page import="qna.vo.qnaBoardbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%String id = (String)session.getAttribute("Member_id"); 
     	if(id==null){
		%>
	<script type="text/javascript">
	  alert("회원만 작성가능합니다.")
	window.history.back();
	</script>
		
	<% }%>
    
	
    <% 
	ArrayList<qnaBoardbean> articleList = (ArrayList<qnaBoardbean>)request.getAttribute("articlelist");
	pageinfo pageInfo = (pageinfo)request.getAttribute("pageinfo");

	int listCount = pageInfo.getListcount();
	int nowPage = pageInfo.getPage(); 
	int startPage = pageInfo.getStartpage();
	int endPage = pageInfo.getEndpage();
	int maxPage = pageInfo.getMaxpage();
	
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
                                </div>
                            </div>
                            <!-- Articles Thumbnail End -->

                            <!-- Articles Content Start -->
                            <div class="col-lg-7">
                                <div class="display-table">
                                    <div class="display-table-cell">
                                        <div class="article-body">
                                            <h3><a href="#">1:1 Inquiry List</a></h3>
                                            <div class="article-meta">
                                                <a href="#" class="author">By :: <span><%=id%></span></a>
                                                <a href="qnawrite.bo" class="commnet">문의하기</a>
                                            </div>

                                            <div class="article-date">will <span class="month">Rent</span></div>
 <p>
   <section id="listForm">
<a href="faqlist.fbo">
</a>
        
        
    <table class="table table-hover">
              <thead>
            <tr id="tr_top">
            <th scope="col">번호</th>
            <th scope="col">구분</th>
            <th scope="col">제목</th>
            <th scope="col" style="height: 5px;">
            <%if(id.equals("admin")){%>

    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="margin: -10px;">답변상태</a>
    <div class="dropdown-menu" style="">
      <a class="dropdown-item" href="qnaBoardlist.bo">전체</a>
      <a class="dropdown-item" href="qnaadminlist2.bo">답변완료</a>
      <a class="dropdown-item" href="qnaadminlist.bo">미답변</a>
    </div>          
    
    
            <%}else{%>답변유무<%}%>
            </th>
            <th scope="col">작성일</th>
            <th scope="col">조회수</th>
            </tr>
            </thead>
     <tbody>
            
                <tr>
        <%if(articleList != null & listCount > 0) {%>
            <%for(int i = 0; i < articleList.size(); i++) {%>
            
                    <%if(articleList.get(i).getQnaBoard_re_lev()==0){ %>
                    <th scope="row"><%=articleList.get(i).getQnaBoard_num() %></td>
                    <%} else if(articleList.get(i).getQnaBoard_re_lev()>0){%>
                    <td scope="row"></td>
                    <% } %>
            <td style="text-align: center;">
            <%if(articleList.get(i).getQnaBaord_tag() !=null){ 
            %><b><%=articleList.get(i).getQnaBaord_tag() %></b><%}{}%>
            </td>
                    <td>
                     <%if(id.equals("admin")){%>
                    <a href="qnaBoardDetail.bo?qnaBoard_num=<%=articleList.get(i).getQnaBoard_num()%>&page=<%=nowPage%>">
                            <%=articleList.get(i).getQnaBoard_subject() %>
                     <%}else{%>
                       <a href="qnaboardcheck.bo?qnaBoard_num=<%=articleList.get(i).getQnaBoard_num()%>&page=<%=nowPage%>">
                            <%=articleList.get(i).getQnaBoard_subject() %>
                
                     <% }%>
                     
                        </a>
                    </td>
                            
                            <td>
                            <%if(articleList.get(i).getQnaboard_reply()!=null){ %>
                            <span class="badge badge-pill badge-primary">답변 완료</span>
                            <%}else if(articleList.get(i).getQnaboard_reply()==null){%>
                                <span class="badge badge-pill badge-secondary">답변대기중</span>
                                
                            <%} %>
                            </td>
                    

                    
                    <%if(articleList.get(i).getQnaBoard_re_lev()==0){ %>
                    <td align="center"><%=articleList.get(i).getQnaBoard_date()%></td>
                    <td align="center"><%=articleList.get(i).getQnaBoard_readcount() %></td>
                    <%} else if(articleList.get(i).getQnaBoard_re_lev()>0){%>
                    <td align="center"></td>
                    <td align="center"></td>
                    <% } %>
                </tr>
            <%}} %>
            </tbody>
        </table>        
        
    <section id="pageList">
    <ul class="pagination pagination-sm">
    
    <%if(nowPage <= 1) { %>
             <li class="page-item disabled">
      <a class="page-link" href="#">&laquo;</a>
    </li>
    <%} else {%>
       <li class="page-item disabled">
            <a href="qnaBoardlist.bo?page=<%=nowPage - 1%>" class="page-link">&laquo;</a>&nbsp;
            </li>
    <%} %>
    
    <%for(int i = startPage; i <= endPage; i++) {
            if(i == nowPage) {%>
                 <li class="page-item active">
      <a class="page-link" href="#"><%=i %></a>
        <%} else {%>
         <li>
                <a href="qnaBoardlist.bo?page=<%=i %>" class="page-link"><%=i %></a>&nbsp;
        <%} %>
    <%} %>
    
    <%if(nowPage >= maxPage) {%>
              <li class="page-item">
      <a class="page-link" href="#">&raquo;</a>
    <%} else { %>
    <li class="page-item">
            <a href="qnaBoardlist.bo?page=<%=nowPage + 1%>" class="page-link">&raquo;</a>
    <%} %>
    
      </li>
  </ul>
    </section>
    
    
      </p>
<br>


    <div class="single-sidebar">
                            <h3>For More Informations</h3>

                            <div class="sidebar-body">
                           <a href="" onclick="window.open('chat/admin.jsp','admin','width=750, height=750, resizable=no')" style="float: right;">
                          <span class="badge badge-pill badge-secondary"> 
                           실시간 채팅문의</span></a>
                                <p><i class="fa fa-mobile"></i> T : 051-1599-8888 </p>
                                <p><i class="fa fa-clock-o"></i> Mon - Sat 8.00 - 18.00</p>
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














