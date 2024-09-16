<%@page import="review.vo.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="review.vo.ReviewBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ArrayList<BookBean> bookList = (ArrayList<BookBean>)request.getAttribute("bookList");
ReviewBean article = (ReviewBean)request.getAttribute("article");
String id=(String)session.getAttribute("Member_id");
String snsid=(String)session.getAttribute("Member_snsid");
%>
<html>
<head>
<meta charset="UTF-8">
<title>예약검색</title>
<!--검색한 예약을 ReviewWriteForm.jsp에 입력하는 javascript입니다  -->
<script type="text/javascript">
	function sel2(a,b,c,d){
		window.opener.reviewForm.book_num.value=a;
		window.opener.reviewForm.car_id.value=b;
		window.opener.reviewForm.pickup_date.value=c;
		window.opener.reviewForm.end_date.value=d;
		window.close(); 

	}
</script>
</head>
<body>
<form action="bookSearch.jsp" method="post" name="bsh">
<table>
<%
	if(bookList != null){
%>
<tr>
<td>ID</td>
<td>예약번호</td>
<td>차량정보</td>
<td>이용일</td>
</tr>
<%for(int i=0; i<bookList.size(); i++){ 
	if(id.equals(bookList.get(i).getMember_id())){%>
<tr>
<td><%=bookList.get(i).getMember_id() %></td>
<td><%=bookList.get(i).getBook_num() %></td>
<td><%=bookList.get(i).getCar_id() %></td>
<td><%=bookList.get(i).getPickup_date() %>~<%=bookList.get(i).getEnd_date() %></td>
<td><input type="button" name="sel" value="예약선택" onclick="sel2('<%=bookList.get(i).getBook_num()%>','<%=bookList.get(i).getCar_id() %>','<%=bookList.get(i).getPickup_date() %>','<%=bookList.get(i).getEnd_date() %>')"></td>
</tr>
<%
		}
   }
}
%>
</table>
</form>
</body>
</html>