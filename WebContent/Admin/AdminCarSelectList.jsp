
<%@page import="admin.vo.CarBean"%>
<%@page import="qna.vo.pageinfo"%>
<%@page import="member.vo.MemberBean"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
     <link href="QnA/QnA11/bootstrap.css" rel="stylesheet">
 <link href="QnA/QnA11/bootstrap.min.css" rel="stylesheet"> 
    </head>
<%
	ArrayList<CarBean> articleList = (ArrayList<CarBean>)request.getAttribute("articlelist");
	pageinfo pageiInfo = (pageinfo)request.getAttribute("pageInfo");
	String carsearch1 =(String)request.getAttribute("carsearch1");
	String carsearch2 =(String)request.getAttribute("carsearch2");
	

	int listCount = pageiInfo.getListcount();
	int nowPage = pageiInfo.getPage(); 
	int startPage = pageiInfo.getStartpage();
	int endPage = pageiInfo.getEndpage();
	int maxPage = pageiInfo.getMaxpage();
	
%>      
    
    
   <!-- 좌측 메뉴 --> <jsp:include page="/inc/topleft.jsp"></jsp:include>
  
        <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">CAR LIST Management</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">ADMIN CarList</a></li>
                            <li class="breadcrumb-item active">Car Data</li>
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
                                Car List
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                                                           
                                            <tr>
            <th style="white-space: nowrap;">차량번호<img src="img/2.png" style="width: 12px;"></th>       
     		<th style="white-space: nowrap;">제조사 <img src="img/2.png" style="width: 12px;"></th>
     		<th style="white-space: nowrap;">차량이름<img src="img/2.png" style="width: 12px;"></th>
     		<th style="white-space: nowrap;">차량종류<img src="img/2.png" style="width: 12px;"></th>	
     		<th style="white-space: nowrap;">비용<img src="img/2.png" style="width: 12px;"></th>    
     		<th style="white-space: nowrap;">수정 및 삭제<img src="img/2.png" style="width: 12px;"></th>                                  
                                            </tr>
                                            
                                        </thead>
                                     <tfoot>
                                        
          <%if(articleList != null & listCount > 0) {%>
			<%for(int i = 0; i < articleList.size(); i++) {%>
			
				<tr>
				<th scope="row" onclick="DetailCarInfo(<%=articleList.get(i).getCar_id()%>)" style="text-align: center;">
					<%=articleList.get(i).getCar_num()%>	
					</th>
					
					<th scope="row">
					<%=articleList.get(i).getCar_maker()%>	
					</th>
					
				
			<td>
			<%=articleList.get(i).getCar_name() %>
			</td>
					
				<td>
			<%=articleList.get(i).getCar_type() %>
			</td>
			<td>
			<%=articleList.get(i).getCar_price_normal() %>
			</td>
					
					
					
					
					
					<td style="white-space: nowrap;">
					<a href="mmmodify.ad?member_id=<%=articleList.get(i).getCar_id()%>&page?=<%=nowPage%>">
					<span class="badge badge-pill badge-warning">수정</span></a>
					
					<a onclick="removeCheck(<%=articleList.get(i).getCar_id()%>)">
					<span class="badge badge-pill badge-danger">삭제</span></a>
					<input type="hidden" name="page" value="<%=nowPage%>">
			
					</td>
					
				</tr>				
<%}%>

                                        </tbody>
                                    </table>
                                    
        <div style="float: right;">
	   <form action="CarSelectList.ad" class="form-inline my-2 my-lg-0">
       <select class="custom-select" style="width: 100px; margin-right: 5px;" name="carsearch1">
      <option selected="">Search</option>
      <option value="1">차량번호</option>
      <option value="2">제조사</option>
      <option value="3">종류</option>
    </select>
      <input name="carsearch2" id="search" class="form-control mr-sm-2" type="text" placeholder="Search" >
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
			<a href="CarSelectList.ad?page=<%=nowPage - 1%>&&carsearch1=<%=carsearch1%>&&carsearch2=<%=carsearch2%>" class="page-link">&laquo;</a>&nbsp;
			</li>
	<%} %>
	
	<%for(int i = startPage; i <= endPage; i++) {
		    if(i == nowPage) {%>
				 <li class="page-item active">
      <a class="page-link" href="#"><%=i %></a>
		<%} else {%>
		 <li class="page-item active">
				<a href="CarSelectList.ad?page=<%=i %>&&carsearch1=<%=carsearch1%>&&carsearch2=<%=carsearch2%>" class="page-link"><%=i %></a>&nbsp;
		<%} %>
	<%} %>
	
	<%if(nowPage >= maxPage) {%>
			  <li class="page-item">
      <a class="page-link" href="#">&raquo;</a>
	<%} else { %>
	<li class="page-item">
			<a href="CarSelectList.ad?page=<%=nowPage + 1%>&&carsearch1=<%=carsearch1%>&&carsearch2=<%=carsearch2%>" class="page-link">&raquo;</a>
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
      <script type="text/javascript">
<!--

//-->


function removeCheck(idx) {	
	
 if (confirm("정말 삭제하시겠습니까??") == true){    //확인
	 
	 location.href="mmdelete.ad?table=car&&idx="+idx ;
 
 }else{   //취소
	 
     return false;
 
 }
}

var popupX = (window.screen.width/2)-(500/2);
//만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

var popupY= (window.screen.height/2)-(500/2);
//만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음

function DetailCarInfo(car_id)
{
  // window.open("open할 window", "자식창 이름", "팝업창 옵션"); 
 window.open('Admin/DetailCarInfo.jsp?car_id='+car_id, 'DetailCarInfo', 'status=no, height=490, width=500, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
}
</script>
     
     
        
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="Admin/js/scripts.js"></script>
<!--         <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script> -->
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="Admin/assets/demo/datatables-demo.js"></script>
    </body>
   
</html>