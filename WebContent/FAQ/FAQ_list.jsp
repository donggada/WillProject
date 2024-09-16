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
  top: 500;
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
  <link href="style.css" rel="stylesheet">
  <link href="QnA/QnA11/bootstrap.css" rel="stylesheet">
 <link href="QnA/QnA11/bootstrap.min.css" rel="stylesheet">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
 

</head>
<body>

   <jsp:include page="/inc/Header.jsp"></jsp:include>


 <section id="page-title-area" class="section-padding overlay">
        <div class="container">
            <div class="row">
                <!-- Page Title Start -->
                <div class="col-lg-12">
                    <div class="section-title  text-center">
                        <h2>FAQ</h2>
                        <span class="title-line"><i class="fa fa-car"></i></span>
                        <p>Frequently Asked Questions</p>
                    </div>
                </div>
                <!-- Page Title End -->
            </div>
        </div>
    </section>
    <!--== Page Title Area End ==-->



   <!--== Car List Area Start ==-->
  
<br>    
            <div class="row">
             
                <!-- Single Articles Start -->
                <div class="col-lg-12">
                    <article class="single-article middle">
                        <div class="row">

                            <!-- Articles Thumbnail Start -->
                            <div class="col-lg-5 d-xl-none" style="padding-bottom: 30px;">
                                <div class="article-thumb">
                                    <img src="assets/img/article/arti-thumb-4.jpg" alt="JSOFT">
      
                               
                                </div>
                            </div>
                            <!-- Articles Thumbnail End -->

                     
                            <!-- Articles Content Start -->
                            <div class="col-lg-7" >
                                <div class="display-table">
                                    <div class="display-table-cell">
                                        <div class="article-body">
                                            
                                            <div class="article-meta">
                                                <a href="qnawrite.bo" class="author"><%=id %><span> 1:1 문의하기</span></a>
                                                    <a href="qnaBoardlist.bo" class="commnet">나의 문의내역 보기</a>
        
         <div style="float: right;">
       <form action="faqSearchPro.fbo" class="form-inline my-2 my-lg-0">
      <input name="search" id="search" class="form-control mr-sm-2" type="text" placeholder="Search" style="height: 25px; font-size: 9px;" >
      <button class="btn btn-secondary my-2 my-sm-0" type="submit" style="height: 25px; font-size: 9px;" >Search</button>
    </form>
    </div>
                                            </div>

                                            <div class="article-date">Will <span class="month">Rent</span></div>

                                           
<section id="listForm">
    <table class="table table-hover">
              <thead>
            <tr id="tr_top">
            <th scope="col" colspan="3"> 
            
          <button type="button" class="btn btn-outline-secondary" onclick="location.href='faqlist.fbo'" style="height: 28px; font-size: 12px;">전체</button>    
            <button type="button" class="btn btn-outline-secondary" onclick="location.href='faqtag1.fbo?tag=대여안내'" style="height: 28px; font-size: 12px;">대여안내</button>
      <button type="button" class="btn btn-outline-secondary" onclick="location.href='faqtag1.fbo?tag=보험 및 사고'" style="height: 28px; font-size: 12px;">보험/사고</button>
       <button type="button" class="btn btn-outline-secondary" onclick="location.href='faqtag1.fbo?tag=인수/반납'" style="height: 28px; font-size: 12px;">인수/반납</button>
        <button type="button" class="btn btn-outline-secondary" onclick="location.href='faqtag1.fbo?tag=사이트이용'" style="height: 28px; font-size: 12px;">사이트이용</button>
  
   
   
            

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

             <%}%>
                    </td>
                </tr>               
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
    
       
    


    
    
    <section id="pageList">
    <ul class="pagination pagination-sm">
    
    <%if(nowPage <= 1) { %>
             <li class="page-item disabled">
      <a class="page-link" href="#">&laquo;</a>
    </li>
    <%} else {%>
       <li class="page-item disabled">
            <a href="faqlist.fbo?page=<%=nowPage - 1%>" class="page-link">&laquo;</a>&nbsp;
            </li>
    <%} %>
    
    <%for(int i = startPage; i <= endPage; i++) {
            if(i == nowPage) {%>
                 <li class="page-item active">
      <a class="page-link" href="#"><%=i %></a>
        <%} else {%>
         <li>
                <a href="faqlist.fbo?page=<%=i %>" class="page-link"><%=i %></a>&nbsp;
        <%} %>
    <%} %>
    
    <%if(nowPage >= maxPage) {%>
              <li class="page-item">
      <a class="page-link" href="#">&raquo;</a>
    <%} else { %>
    <li class="page-item">
            <a href="faqlist.fbo?page=<%=nowPage + 1%>" class="page-link">&raquo;</a>
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
                            <!-- Articles Content End -->

                            <!-- Articles Thumbnail Start -->
                            <div class="col-lg-5 d-none d-xl-block">
                                <div class="article-thumb">
                                    <img src="assets/img/article/arti-thumb-4.jpg" alt="JSOFT">
                                </div>
                            </div>
                            <!-- Articles Thumbnail End -->
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

<br>




 
	
	


               <!-- Single Sidebar End -->
                    </div>
                </div>
                <!-- Sidebar Area End -->
            </div>
        </div>
    </section>






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

<script type="text/javascript">


function faqwrite() {

window.open("faqwriteform.fbo","faq등록","width=500,height=500,left=300,top=300,scrollbars=yes,resizable=yes");

}

</script>

  <jsp:include page="/inc/Footer.jsp"></jsp:include>


</body>
</html>






