<%@page import="faq.vo.pageinfo"%>
<%@page import="faq.vo.faqBoardbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	// Action 클래스에서 request 객체의 setAttibute() 메서드로 저장되어 전달된 객체 가져오기(Object 타입이므로 형변환 필요)
	String id = (String)session.getAttribute("id");
	ArrayList<faqBoardbean> articleList = (ArrayList<faqBoardbean>)request.getAttribute("articlelist");
	pageinfo pageInfo = (pageinfo)request.getAttribute("pageinfo");
	
	int listCount = pageInfo.getListcount();
	int nowPage = pageInfo.getPage(); // page 디렉티브의 이름과 중복되므로 nowPage 라는 변수명으로 사용
	int startPage = pageInfo.getStartpage();
	int endPage = pageInfo.getEndpage();
	int maxPage = pageInfo.getMaxpage();
	
%>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.modal {
  display: none;
  position: fixed;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  background: rgba(0, 0, 0, 0.8);
  z-index: 2;
}

.modal_content {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  width: 300px;
  height: 300px;
  background-color: white;
  overflow: auto;
}

</style>
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
                        <h1 class="mt-4">FAQ</h1>
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
                                FAQ list
                                <div style="float: right; padding-right: 10px;">
                                <a href="faqwriteform.fbo">
			 <button type="submit" class="btn btn-outline-secondary" style="margin: -20px;">새글등록</button></a>
			 </div>
                                
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">


	<section id="listForm">
	<table class="table table-hover">
			  <thead>
			<tr id="tr_top">
			<th scope="col">
			
			 </th>
     		<th scope="col">
     		
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="margin: -10px;">구분</a>
    <div class="dropdown-menu">
   <a class="dropdown-item" href="faqadminlist.fbo">전체</a>
	<a class="dropdown-item" href="faqtag.fbo?tag=대여안내">대여안내</a>
      <a class="dropdown-item" href="faqtag.fbo?tag=보험 및 사고">보험/사고</a>
      <a class="dropdown-item" href="faqtag.fbo?tag=인수/반납">인수/반납</a>
      <a class="dropdown-item" href="faqtag.fbo?tag=사이트이용">사이트이용</a>
    </div>
     

     		</th>
      		<th scope="col">
      		제목</th>
      		  		<th scope="col">
      		  		<form action="faqdelete.fbo">
      		 <button type="submit" class="btn btn-primary" style="margin: -20px">삭제</button>
      		</th>
			</tr>
			</thead>
	 <tbody>
			
		<%if(articleList != null & listCount > 0) {%>
			<%for(int i = 0; i < articleList.size(); i++) {%>
			
				<tr>
					<th scope="row">
					<img src="img/faq.PNG" style="width: 30px;">
					<input type="hidden" id="num" value="<%=articleList.get(i).getFaqboard_num()%>">
					<input type="hidden" name="id" id="id" value=<%=id%>>
					</th>
				
			<td style="text-align: center;">
	<b><%=articleList.get(i).getFaqBoard_tag() %></b>
			</td>
					<td>
	
	<a href="javascript:void(0)" id="num" class="numbtn" onclick="show('<%=articleList.get(i).getFaqboard_num()%>')">
	<%=articleList.get(i).getFaqboard_subject() %>  </a>
	 <a href="faqmodifyform.fbo?faqBoard_num=<%=articleList.get(i).getFaqboard_num()%>&page=<%=nowPage%>">
	 <span class="badge badge-pill badge-primary">수정</span>

					</td>
					<td>
					<input type="checkbox" name="check" value="<%=articleList.get(i).getFaqboard_num()%>">
					<input type="hidden" name="page" value="<%=nowPage%>">
					</td>
					
				</tr>				
<%} %>	
				 </form>
			</tbody>
		</table>		
	</section>
	
	<div class="modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">FAQ</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      </div>
    <div class="modal-footer">
        <a href="qnawrite.bo?id=<%=id %>"><button type="button" class="btn btn-primary" onclick="">1:1문의</button></a>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
	
		<div style="float: right;">
	   <form action="qnaSearchPro.fbo" class="form-inline my-2 my-lg-0">
      <input name="search" id="search" class="form-control mr-sm-2" type="text" placeholder="Search" >
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
    </div>
	
	
	
	

	
		<div style="float: right;">
	   <form action="qnaSearchPro.fbo" class="form-inline my-2 my-lg-0">
      <input name="search" id="search" class="form-control mr-sm-2" type="text" placeholder="Search" >
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
    </div>
	


	
	
	<section id="pageList">
	<ul class="pagination pagination-sm">
	
	<%if(nowPage <= 1) { %>
			 <li class="page-item disabled">
      <a class="page-link" href="#">&laquo;</a>
    </li>
	<%} else {%>
	   <li class="page-item disabled">
			<a href="faqadminlist.fbo?page=<%=nowPage - 1%>" class="page-link">&laquo;</a>&nbsp;
			</li>
	<%} %>
	
	<%for(int i = startPage; i <= endPage; i++) {
		    if(i == nowPage) {%>
				 <li class="page-item active">
      <a class="page-link" href="#"><%=i %></a>
		<%} else {%>
		 <li class="page-item">
				<a href="faqadminlist.fbo?page=<%=i %>" class="page-link"><%=i %></a>&nbsp;
		<%} %>
	<%} %>
	
	<%if(nowPage >= maxPage) {%>
			  <li class="page-item">
      <a class="page-link" href="#">&raquo;</a>
	<%} else { %>
	<li class="page-item">
			<a href="faqadminlist.fbo?page=<%=nowPage + 1%>" class="page-link">&raquo;</a>
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
    


<script type="text/javascript">
 function show(num){
// 	alert(num);
	temp = num;
}

</script>


<script src="js/jquery-3.5.1.js">
</script>
<script type="text/javascript">

$(document).ready(function() {
	
	$('.numbtn').click(function() {
		var num=temp;
// 		alert(num);

		 $(".modal").fadeIn();
		$.ajax('FAQ/dup2.jsp',{
				data:{
					num:num,
				},
				
				success:function(returndata){
					$('.modal-body').html(returndata);
				},
				
				error:function(xhr,status,error){
					alert(erroer);
				}
			});
			
		});
	
	
	  $(".modal").click(function() {
		    $(".modal").fadeOut();
		  });
	
	  
	  
	  
});

</script>

<script src="js/jquery-3.5.1.js">
</script>
<script type="text/javascript">


function faqwrite() {

window.open("faqwriteform.fbo","faq등록","width=500,height=500,left=300,top=300,scrollbars=yes,resizable=yes");

}

function faqmodify() {

	window.open("faqmodifyform.fbo","faq등록","width=500,height=500,left=300,top=300,scrollbars=yes,resizable=yes");

	}

</script>

</body>
</html>






