<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String id = (String)session.getAttribute("member_id");
    %>
<!DOCTYPE html>

<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<h3>예약 페이지 1</h3>
</head>
<body> 

<%-- <%//system.out.println(id);%> --%>

<form action="BookForm2.bk" method="post">
<h2>기간선택</h2>
	
인수날짜 : <input type="date" id="pickup_date" name="pickup_date"><br>
도착날짜 : <input type="date" id="end_date" name="end_date"><br>



<h2>차량유형 선택</h2>	

<table id="Car_list" board="1">
<tr>
<td>경차<input type="radio" name="SelCar" value="경차"></td>
<td>소형<input type="radio" name="SelCar" value="소형" ></td>
<td>중형<input type="radio" name="SelCar"  value="중형" ></td>
</tr>
<tr>
<td>준대형<input type="radio" name="SelCar"  value="준대형" ></td>
<td>대형<input type="radio" name="SelCar"  value="대형" ></td>
<td>승합<input type="radio" name="SelCar"  value="승합" ></td>
</tr>
<tr>
<td>SUVㅣRV<input type="radio" name="SelCar"  value="SUVㅣRV" ></td>
<td>전기차<input type="radio" name="SelCar"  value="전기차" ></td>
<td>수입차<input type="radio" name="SelCar"  value="수입차"  ></td>
</tr>
</table>


<input type="submit" value="검색"><br>
</form>
</body>
</html>