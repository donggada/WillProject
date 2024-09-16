<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.5.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
 $.getJSON('PopupPagePro.ad',function(rdata){
	 $.each(rdata,function(index,item){
		 if(item.idx=='1'){window.close();}
		 else{
		 $('body').append('<img alt="300" src="../EventUploadfile/'+item.image+'" width="400" height="400"><br>');
		 }
	 });
 });
	
});

</script>

</head>
<body>
팝업창 입니다<br>
</body>
</html>