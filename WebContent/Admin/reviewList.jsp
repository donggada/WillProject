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
<html>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Admin</title>
        <link href="Admin/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
     <link href="QnA/QnA11/bootstrap.css" rel="stylesheet">
 <link href="QnA/QnA11/bootstrap.min.css" rel="stylesheet">
   
    </head>
    
    <jsp:include page="/inc/topleft.jsp"></jsp:include>
  <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Review List</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="main.ad">ADMIN MAIN</a></li>
                            <li class="breadcrumb-item active">Review List</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                            -
                                <a target="_blank" href="#">official DataTables documentation</a>
                                .
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1" style="float: left; margin-top: 10px;"></i>
         
							reviewlist admin
                             
                            </div>
                                <div class="card-body">
                                <div class="table-responsive">
                                
                                	<div style="float: right; padding-bottom: 10px;">
	       <form action="qnaSearchPro.fbo" class="form-inline my-2 my-lg-0">   
       <select class="custom-select" style="width: 100px; margin-right: 5px; float: left;">
      <option selected="">Search</option>
      <option value="1">제목</option>
      <option value="2">작성자</option>
    </select>
      <input name="search" id="search" class="form-control mr-sm-2" type="text" placeholder="Search" >
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
    </div>
                                
                                
<section id="listForm">  
<table class="table table-hover">
 <thead>

 <tr id="tr_top">
 <th scope="col">번호</td>
 <th scope="col">제목</td>
 <th scope="col" style="width: 250px;">작성자</td>
 <th scope="col" style="width: 200px;">날짜</td>
 <th scope="col" style="width: 200px;">조회수</td>
 <th scope="col" style="width: 200px;">추천수</td>
 <th scope="col" style="width: 100px;">
 
 
 <form action="reviewdelete.ad">
 <button type="submit" class="btn btn-primary" style="margin: -20px">삭제</button>
 </th>
 </tr>
 </thead>
 
<%
if(articleList != null && listCount>0){
%>
 <%for(int i=0; i<articleList.size(); i++) {%>
 <tr>
 <td><%=articleList.get(i).getReview_num() %></td>
 <td><a href="ReviewDetail.rw?review_num=<%=articleList.get(i).getReview_num() %>&page=<%=nowPage %>"><%=articleList.get(i).getReview_subject() %></a></td>
 <td><%=articleList.get(i).getMember_id() %></td>
 <td><%=articleList.get(i).getReview_date() %></td>
 <td><%=articleList.get(i).getReview_readcount() %></td>
 <td><%=articleList.get(i).getReview_recocount() %></td>
 	<td>
		<input type="hidden" name="num" value="<%=articleList.get(i).getReview_num()%>">

					
					<input type="checkbox" name="check" value="<%=articleList.get(i).getReview_num()%>">
					<input type="hidden" name="page" value="<%=nowPage%>">
					</td>
 </tr>
 <%
 }
 %>
 </form>
</table>    
</section>         
                            
                 
                        

     </div>


	
	
	<section id="pageList">
	<ul class="pagination pagination-sm">
	
	<%if(nowPage <= 1) { %>
			 <li class="page-item disabled">
      <a class="page-link" href="#">&laquo;</a>
    </li>
	<%} else {%>
	   <li class="page-item disabled">
			<a href="ReviewList.rw?page=<%=nowPage-1 %>">" class="page-link">&laquo;</a>&nbsp;
			</li>
	<%} %>
	
	<%for(int i = startPage; i <= endPage; i++) {
		    if(i == nowPage) {%>
				 <li class="page-item active">
     <a class="page-link" href="#"><%=i %></a>
		<%} else {%>
		 <li class="page-item">
				<a href="ReviewList.rw?page=<%=i %>"><%=i %></a>&nbsp;
		<%} %>
	<%} %>
	
	<%if(nowPage >= maxPage) {%>
			  <li class="page-item">
      <a class="page-link" href="#">&raquo;</a>
	<%} else { %>
	<li class="page-item">
			   <a href="ReviewList.rw?page=<%=nowPage+1 %>">" class="page-link">&raquo;</a>
	<%} %>
	
	  </li>
  </ul>
	</section>
<%} else {%>
	<section id="emptyArea">등록된 글이 없습니다.</section>
<%} %>

      </div>
                            </div>
                        </div>
	
    
	</div>

	
	
	
	
	
          <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="Admin/js/scripts.js"></script>
<!--         <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script> -->
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="Admin/assets/demo/datatables-demo.js"></script>
    </body>
</html>