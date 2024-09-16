<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<body>
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
                                수정할거 - 
                                <a target="_blank" href="#">official DataTables documentation</a>
                                .
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                               FAQ list
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">


	<section id="listForm">

<form action="faqwritepro.fbo" enctype="multipart/form-data" method="post" name="boardform">
 
 
 
                <fieldset>

                <div class="form-group">
                <label class="col-form-label" for="inputDefault">Subject</label>
                <input type="text" name="faqBoard_subject" class="form-control" placeholder="Default input">
              </div>


                  <div class="form-group">
                    <label for="exampleSelect1">Tag select</label>
                    <select class="form-control" name="tag">
                    <option value="인수/반납">인수/반납</option>
                    <option value="대여안내">대여안내</option>
                    <option value="보험 및 사고">보험 및 사고</option>
                    <option value="결제/취소">결제/취소</option>
                    <option value="사이트이용">사이트이용</option>
                    </select>
                  </div>
              
                  <div class="form-group">
                    <label for="exampleTextarea">Substance</label>
                    <textarea name="faqBoard_content" class="form-control" id="qnaBoard_content" rows="3"></textarea>
                  </div>
                  
                  <button type="submit" class="btn btn-primary">Submit</button>
                  <button type="reset" class="btn btn-primary">reset</button>
                </fieldset>
      
            </div>
          </div>
     </div>
     </div>
     </form>

           


</body>
</html>