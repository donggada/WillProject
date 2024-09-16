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
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>       
         <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script> 
     <link href="QnA/QnA11/bootstrap.css" rel="stylesheet">
 <link href="QnA/QnA11/bootstrap.min.css" rel="stylesheet">
    </head>
    <%
 Cookie[] cookies = request.getCookies() ;
 String cValue="off";
 if(cookies != null){   
     for(int i=0; i < cookies.length; i++){
         Cookie c = cookies[i] ;
       // 쿠키값을 가져온다
         cValue = c.getValue() ;
     }
 }
 %>  
   <!-- 좌측 메뉴 --> <jsp:include page="/inc/topleft.jsp"></jsp:include>
  
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">PoP-EVENT</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="adminpage.ad">ADMIN MAIN</a></li>
                            <li class="breadcrumb-item active">popm</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                            - 
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                        <i class="fas fa-table mr-1"></i>
                               pop-preview
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">


    <section id="listForm">
    <fieldset>
    
    
 <form action="PopupPageUpload.ad" method="post" enctype="multipart/form-data" name="reviewForm">
 <input type="file" id="image" accept="image/*" onchange="setThumbnail(event);" name="image"/> 
 <div id="image_container" width=300px height=200px></div>
 <script> 
 function setThumbnail(event) { var reader = new FileReader(); 
 reader.onload = function(event) { var img = document.createElement("img"); 
 img.setAttribute("src", event.target.result); 
 document.querySelector("div#image_container").appendChild(img); }; 
 reader.readAsDataURL(event.target.files[0]); }
 var cook="<%=cValue%>";
 </script>
 <input type="submit" value="등록하기">
 </form>
 
 
 
 <div id="layoutSidenav_content">
 <div class="row">
 <input type="button" value="이벤트올리기" onclick="location.href='PopupPageOn.ad'" id="btnon">
  <input type="button" value="이벤트삭제" onclick="location.href='PopupPageOff.ad'"id="btnoff">
  </div>
  </div>
    </div>
      
  </div>
  </div>
  </div>
  </main>
  </div>
          </fieldset>
  
    
    
    
   
      <script type="text/javascript">
 $(document).ready(function() {
	 $('#btnon').click(function(){
		 alert("이벤트창이 등록되었습니다!")
	 });
	 
	 $('#btnoff').click(function(){
		 alert("이벤트창이 삭제되었습니다!")
	 });

 });
 
 </script>
     
       
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="Admin/js/scripts.js"></script>
<!--         <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script> -->
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="Admin/assets/demo/datatables-demo.js"></script>
    </body>
   
</html>