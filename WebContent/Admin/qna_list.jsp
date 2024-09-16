<%@page import="org.apache.el.lang.ELSupport"%>
<%@page import="qna.vo.pageinfo"%>
<%@page import="qna.vo.qnaBoardbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
	
    <%
	ArrayList<qnaBoardbean> articleList = (ArrayList<qnaBoardbean>)request.getAttribute("articlelist");
	pageinfo pageInfo = (pageinfo)request.getAttribute("pageInfo");
	int listCount = pageInfo.getListcount();
	int nowPage = pageInfo.getPage(); 
	int startPage = pageInfo.getStartpage();
	int endPage = pageInfo.getEndpage();
	int maxPage = pageInfo.getMaxpage();
	
%>  

 
    
    
<!DOCTYPE html>
<html>
<head>
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
                        <h1 class="mt-4">QnA List</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">ADMIN MAIN</a></li>
                            <li class="breadcrumb-item active">Member</li>
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
                                <i class="fas fa-table mr-1"></i>
                                QnA list
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
		
		
		
			<section id="listForm">
		
	 <table class="table table-hover">
                                       
			  <thead>
			<tr id="tr_top">
			<th scope="col">번호</th>
     		<th scope="col">구분</th>
      		<th scope="col">제목</th>
      		<th scope="col" style="height: 5px;">
      	

    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="margin: -10px;">구분</a>
    <div class="dropdown-menu" style="">
      <a class="dropdown-item" href="QnABoard.ad">전체</a>
      <a class="dropdown-item" href="qnaadminlist2.bo">답변완료</a>
      <a class="dropdown-item" href="qnaadminlist.bo">미답변</a>
    </div>      	
    
    	<th scope="col">작성일</th>
    <th scope="col">조회수</th>
			</thead>
	 <tbody>
			
		<%if(articleList != null & listCount > 0) {%>
			<%for(int i = 0; i < articleList.size(); i++) {%>
			
				<tr>
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
					<a href="qnaBoardDetail.bo?qnaBoard_num=<%=articleList.get(i).getQnaBoard_num()%>&page=<%=nowPage%>">
							<%=articleList.get(i).getQnaBoard_subject() %>
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
			<%} %>
			</tbody>
		</table>		
	</section>
	
	
	

	
	
	<section id="pageList" style="text-align: center; margin-left: auto; margin-right: auto;">
	<div style="text-align: center; margin-left: auto; margin-right: auto;">
	<ul class="pagination pagination-sm">
	<%if(nowPage <= 1) { %>
			 <li class="page-item disabled">
     	 <a class="page-link" href="#">&laquo;</a>
   		 </li>
	<%} else {%>
			    <li class="page-item disabled">
      <a class="page-link" href="qnaBoardlist.bo?page=<%=nowPage - 1%>#">&laquo;</a>&nbsp;
  		  </li>
	<%} %>
	
	<%for(int i = startPage; i <= endPage; i++) {
		    if(i == nowPage) {%>
		     <li class="page-item active">
		  <a class="page-link" href="#">
				<%=i %>
				</a>&nbsp;
				
		<%} else {%>
		 <li class="page-item active">
		  <a class="page-link" href="qnaBoardlist.bo?page=<%=i %>">
				<%=i %>
				</a>&nbsp;
		<%} %>
	<%} %>
	
	<%if(nowPage >= maxPage) {%>
			<li class="page-item">
      <a class="page-link" href="#">&raquo;</a>
          </li>
	<%} else { %>
			   <li class="page-item">
      <a class="page-link" href="qnaBoardlist.bo?page=<%=nowPage + 1%>">&raquo;</a>
    </li>
	<%} %>
	</ul>
</div>
	</section>
<%} else {%>


	<section id="emptyArea">등록된 글이 없습니다.</section>
	<section id="writeButton" style="float: right;">
	</section>
	
<%} %>

 </div>
                            </div>
                        </div>
                    </div>
                </main>



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


















