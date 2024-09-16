<%@page import="faq.vo.pageinfo"%>
<%@page import="faq.vo.faqBoardbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	// Action 클래스에서 request 객체의 setAttibute() 메서드로 저장되어 전달된 객체 가져오기(Object 타입이므로 형변환 필요)
	String id = (String)session.getAttribute("Member_id");
	ArrayList<faqBoardbean> articleList = (ArrayList<faqBoardbean>)request.getAttribute("articlelist");
	pageinfo pageInfo = (pageinfo)request.getAttribute("pageinfo");
	
	// PageInfo 객체로부터 페이징 정보 가져오기
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
  width: 800px;
  height: 300px;
  background-color: white;
  overflow: auto;
}

</style>
  <link href="QnA/QnA11/bootstrap.css" rel="stylesheet">
 <link href="QnA/QnA11/bootstrap.min.css" rel="stylesheet">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
 

</head>
<body>


		<h2>FAQ</h2>
<div style="position: relative; margin: 0 auto;">

<%if(id.equals("admin")){%>
<div style="float: right; padding-bottom: 3px;">
<a href="qnaBoardlist.bo?id=<%=id %>" style="" >
<button type="button" class="btn btn-outline-primary">1:1문의내역관리</button>
</a>

<button type="button" class="btn btn-outline-primary">
<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="margin: -8px; float: right;">FAQ관리</a>
    <div class="dropdown-menu">
   <a class="dropdown-item" onclick="faqwrite()" name="faqwrite">등록</a>
	<a class="dropdown-item" href="faqadminlist.fbo">수정/삭제</a>
	<a class="dropdown-item" href="faqlist.fbo">해제</a>
    </div>
</button>
</div>
<%}else{ %>
<a href="qnawrite.bo" style="float: right;">
<button type="button" class="btn btn-outline-primary">1:1문의하기</button>
</a>
<a href="qnaBoardlist.bo?id=<%=id %>" style="float: right;">
<button type="button" class="btn btn-outline-primary">나의 문의 내역</button>
</a>
<%} %>
</div>
	<section id="listForm">
	<table class="table table-hover">
			  <thead>
			<tr id="tr_top">
			<th scope="col"> </th>
     		<th scope="col">
     		
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="margin: -10px;">구분</a>
    <div class="dropdown-menu">
   <a class="dropdown-item" href="faqlist.fbo">전체</a>
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
					<img src="img/faq.PNG">
					<input type="hidden" id="num" value="<%=articleList.get(i).getFaqboard_num()%>">
					<input type="hidden" name="id" id="id" value=<%=id%>>
					</th>
				
			<td style="text-align: center;">
	<b><%=articleList.get(i).getFaqBoard_tag() %></b>
			</td>
					<td>
	
	<%=articleList.get(i).getFaqboard_subject() %>
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
		 <li class="page-item active">
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



<script type="text/javascript">
 function show(num){
// 	alert(num);
	temp = num;
}

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






