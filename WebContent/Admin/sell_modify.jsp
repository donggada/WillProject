
<%@page import="book.vo.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%BookBean article = (BookBean)request.getAttribute("article"); 
  String nowPage = (String)request.getAttribute("page");%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
                        <h1 class="mt-4">Sell state</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="adminpage.ad">ADMIN MAIN</a></li>
                            <li class="breadcrumb-item active">Selling</li>
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
                               BOOKDETAIL
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">


	<section id="listForm">
 
 
 
 
<form action="sellmodifypro.ad" method="post" name="boardform">
 
         
   <div class="form-group">
  <fieldset>
    <label class="control-label" for="readOnlyInput">book_num</label>
    <input class="form-control" id="readOnlyInput" name="num" type="text" value="<%=article.getBook_num()%>" readonly="readonly">
   
  </fieldset>
</div>
                
                

               <div class="form-group">
  <fieldset>
    <label class="control-label" for="readOnlyInput">Member_id</label>
    <input class="form-control" id="readOnlyInput" type="text" value="<%=article.getMember_id()%>" readonly="readonly">
   
  </fieldset>
</div>


               <div class="form-group">
  <fieldset>
    <label class="control-label" for="readOnlyInput">Book_date</label>
    <input class="form-control" id="readOnlyInput" type="text" value="예약일 : <%=article.getBook_date()%> 이용기간 <%=article.getPickup_date()%> - <%=article.getEnd_date()%>" readonly="readonly">

  </fieldset>
</div>

         


                  <div class="form-group">
                    <label for="exampleSelect1">Book_state</label>
                    <select class="form-control" name="book_state">
                    <option value=0>미결제</option>
                     <option value="1">카드</option>
                    <option value="2">무통장</option>
                    </select>
                  </div>
              
           
                  
                  <button type="submit" class="btn btn-primary">수정</button>
                  <button type="button" class="btn btn-primary" onClick ="javascript:history.go(-1)" >취소</button>
     </form>
                </fieldset>
      
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
</html>