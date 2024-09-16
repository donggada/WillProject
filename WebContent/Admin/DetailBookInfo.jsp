<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link href="Admin/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
     <link href="../QnA/QnA11/bootstrap.css" rel="stylesheet">
 <link href="../QnA/QnA11/bootstrap.min.css" rel="stylesheet"> 
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<%String book_num=request.getParameter("book_num"); %>

<script type="text/javascript">
var book_num=<%=book_num%>
jQuery(document).ready(function () {
	
	  $.getJSON('DetailBooktInfo.ad?book_num='+book_num,function(rdata){
		 $.each(rdata,function(index,item){
			 $('#car_id').append(item.book_state);
		     $('#car_type').append(item.book_num);
			 $('#car_type2').append(item.book_id);
			 $('#car_type3').append(item.car_id);
			 $('#car_type4').append("<h7>"+item.book_date+"</h7><br>"+" / "+item.pickup_date+" ~ "+item.end_date);

		 });
	 });	
	 
	
	
	
	
});
</script>
</head>
<body>

<div class="card mb-3">
  <h4 class="card-header" id="car_id">결제일 : </h4>

  <div class="card-body">
    <h6 class="card-title" id="car_type">[예약번호] : </h6>
    <h6 class="card-title" id="car_type2">[예약아이디] : </h6>
    <h6 class="card-title" id="car_type3">[예약차량번호] : </h6>
    <h6 class="card-title" id="car_type4">[예약일/이용일] : </h6>

 </div>

  <div class="card-footer text-muted" style="text-align: right;">
      <a onclick="window.close();" class="card-link" >닫기</a>
  </div>
</div>






</body>
</html>