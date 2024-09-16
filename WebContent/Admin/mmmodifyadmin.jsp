
<%@page import="qna.vo.pageinfo"%>
<%@page import="member.vo.MemberBean"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%
	ArrayList<MemberBean> articleList = (ArrayList<MemberBean>)request.getAttribute("articlelist");
	pageinfo pageiInfo = (pageinfo)request.getAttribute("pageInfo");
	

	int listCount = pageiInfo.getListcount();
	int nowPage = pageiInfo.getPage(); 
	int startPage = pageiInfo.getStartpage();
	int endPage = pageiInfo.getEndpage();
	int maxPage = pageiInfo.getMaxpage();
	
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
                        <h1 class="mt-4">Member Management</h1>
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
                                Member List
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                
                                
<form action="mmmodifypro.ad" method="post" name="boardform">
 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
      
     
      		 <tr>
             <th>IDX </th>
    	 		<th>ID</th>
     		<th>PASS</th>
     		<th style="white-space: nowrap;">NAME <img src="img/2.png" style="width: 12px;"></th>
     		<th style="white-space: nowrap;">AGE<img src="img/2.png" style="width: 12px;"></th>
     		<th>F/M</th>
     		<th>TEL</th>
     		<th>ADRESS</th>
     		<th>E-MAIL</th>		
     		<th>LICENSE</th>
     		<th>OPTION</th>
     		<th style="white-space: nowrap;">
     		
  

        <a data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="color: black;">GRADE <img src="img/3.png" style="width: 12px;"></a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">일반/NEW</a>
          <a class="dropdown-item" href="#">SILVER</a>
          <a class="dropdown-item" href="#">GOLD</a>
           <a class="dropdown-item" href="#">VIP</a>
        </div>
 
 
  
     		
     		</th>	
     		  <th>
 				관리
      		</th>
                                                
                                                
                                                
                                            </tr>
                                        </thead>
                                        <tfoot>
          <%if(articleList != null & listCount > 0) {%>
			<%for(int i = 0; i < articleList.size(); i++) {%>
			
				<tr>
					<th scope="row">
					<%=articleList.get(i).getMember_num()%>	
					</th>
					
				
			<td>
			<input type="text" name="id" id="inputDefault" value="<%=articleList.get(i).getMember_id()%>" readonly="readonly">
			</td>	
				<td>
				<input type="text" name="pass" id="inputDefault" value="<%=articleList.get(i).getMember_pass() %>">
			</td>
			<td>
			<input type="text" name="name" id="inputDefault" value="<%=articleList.get(i).getMember_name() %>">
			</td>
			<td>
			<input type="text" name="age" id="inputDefault" value="<%=articleList.get(i).getMember_age() %>">
			</td>
			<td>
			<input type="text" name="gender" id="inputDefault" value="<%=articleList.get(i).getMember_gender() %>">
			</td>
			<td>
			<input type="text" name="tel" id="inputDefault" value="<%=articleList.get(i).getMember_tel() %>">
			</td>
			<td>
			<input type="text" name="adress" id="inputDefault" value="<%=articleList.get(i).getMember_adress() %>">
			</td>
			<td>
			<input type="text" name="email" id="inputDefault" value="<%=articleList.get(i).getMember_email() %>">
			</td>
		<td>
		<input type="text" name="license" id="inputDefault" value="<%=articleList.get(i).getMember_license() %>">
			</td>
			
			<td>

			<%if(articleList.get(i).getMember_smoke()!=null){ %>
			S <input type="checkbox" name="smoke" checked="checked" value="smoke">
			<%}else if(articleList.get(i).getMember_smoke()==null){ %>
			S <input type="checkbox" name="smoke" value="smoke">
				<%} %>
			
			<%if(articleList.get(i).getMember_pet()!=null){ %>
			P <input type="checkbox" name="pet" checked="checked" value="pet">
			<%}else if(articleList.get(i).getMember_pet()==null){ %>
			P <input type="checkbox" name="pet" value="pet">
				<%} %>
	
				<%if(articleList.get(i).getMember_boby()!=null){ %>
			B <input type="checkbox" name="baby" checked="checked" value="baby">
			<%}else if(articleList.get(i).getMember_boby()==null){ %>
			B <input type="checkbox" name="baby" value="baby">
			<%} %>
		
			</td>
			
			

			
			<td>

			
	<select class="form-control" id="exampleSelect2" name="member_grade">
		
			<%if(articleList.get(i).getMember_grade().equals("Silver")){%>
        <option value="Silver" selected="selected">SILVER</option>
        <option value="GOLD">GOLD</option>
        <option value="VIP">VIP</option>
      
      <%}else if(articleList.get(i).getMember_grade().equals("GOLD")){%>
        <option value="Silver">SILVER</option>
        <option value="GOLD" selected="selected">GOLD</option>
        <option value="VIP">VIP</option>
      
      <%}else if(articleList.get(i).getMember_grade().equals("VIP")){%>
        <option value="Silver">SILVER</option>
        <option value="GOLD">GOLD</option>
        <option value="VIP" selected="selected">VIP</option>
			<%} %>
		</select>
			
			</td>
					
					
					
					
					
					<td style="white-space: nowrap;">
<!-- 					<button type="submit" value="수정">수정</button> -->
					<span class="badge badge-pill badge-warning" onclick="document.forms[1].submit()">수정</span>
					
					<a onclick="removeCheck(<%=articleList.get(i).getMember_num()%>)">
					<span class="badge badge-pill badge-danger">삭제</span></a>
					<input type="hidden" name="page" value="<%=nowPage%>">
			
					</td>
					
				</tr>				
<%}}%>

                                        </tbody>
                                    </table>
                                    
</form>
                         
 
                                    
                                    
                                        
                                </div>
                            </div>
                        </div>
                    </div>
                </main>



            </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="Admin/js/scripts.js"></script>
<!--         <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script> -->
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="Admin/assets/demo/datatables-demo.js"></script>
    </body>
    
    
   <script type="text/javascript">
<!--

//-->


function removeCheck(idx) {

	
 if (confirm("정말 삭제하시겠습니까??") == true){    //확인

	 location.href="/mmdelete.mm?idx="+idx ;


 }else{   //취소

     return false;

 }
 
 

}

</script>

</html>