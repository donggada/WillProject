<%@page import="java.util.LinkedList"%>
<%@page import="book.vo.BookBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="book.vo.CarBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%
      String snsid = (String)session.getAttribute("Member_snsid");
      String id = (String)session.getAttribute("Member_id");

      String pickup = request.getParameter("pickup_date"); 
      String end = request.getParameter("end_date"); 
      String SelCarType = request.getParameter("SelCar"); 
      
      String pet = request.getParameter("option_pet");
      String baby = request.getParameter("option_baby");
      String smoke = request.getParameter("option_smoke");
      
      
      LinkedList<CarBean> carList = (LinkedList<CarBean>)request.getAttribute("carList");
//       ArrayList<BookBean> bookList =(ArrayList<BookBean>)request.getAttribute("bookList");

	 	int rentday = (int)request.getAttribute("rentday");
	 	System.out.println(rentday);
		System.out.println(snsid);
		System.out.println(id);
		
		System.out.println("북폼2"+baby);
		System.out.println(pet);
		System.out.println("Somke : " + smoke);
		
		if(baby == null){
			
			System.out.println("아기는  null");
		}else{
			
			System.out.println("아기는  null22");
		}
		
		
		

		
		
    %>
    
    
<!DOCTYPE html>
<html> 
<script src="js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				var today = new Date();
				var dd = today.getDate();
				var mm = today.getMonth() + 1;
				var yyyy = today.getFullYear();
				if (dd < 10) {
					dd = '0' + dd
				}
				if (mm < 10) {
					mm = '0' + mm
				}
				today = yyyy + '-' + mm + '-' + dd;
				document.getElementById("pickup_date").setAttribute("min",
						today);

				$('#pickup_date').change(
						function() {

							var pickup = new Date($('#pickup_date').val());
							document.getElementById('end_date').min = pickup
									.toISOString().substring(0, 10);
							document.getElementById('end_date').value = pickup
									.toISOString().substring(0, 10);
							pickup.setDate(pickup.getDate() + 7);
						});
			});

	
// 	function card(a,b,c,d,e,f){
// 		var car_id = a
// 		var pickup = b
// 		var end = c
// 		var price = d
// 		var member_id = e
// 		var SelCarType = f
// 		window.open("BookPro2.bk?car_id="+car_id+"&pickup="+pickup+"&end="+end+"&rentprice="+price+"&member_id="+member_id+"&SelCarType="+SelCarType"&payType="+card,"카드결제","width=900,height=600");
// 	}
		
	/*무통장입금 결제 팝업창  */	
	function vbank(a,b,c,d,e,f,g){
		var car_id = a
		var pickup = b
		var end = c
		var price = d
		var member_id = e
		var SelCarType = f
		var type = g
		alert(g);
		window.open("BookPro3.bk?car_id="+car_id+"&pickup="+pickup+"&end="+end+"&rentprice="+price+"&member_id="+member_id+"&SelCarType="+SelCarType+"&payType="+type,"카드결제","width=1100,height=850");
	}
	
	function noId(){
		
		
		alert("로그인을 해주세요.");
		location.href="LoginForm.me";
		
	}
		
		
	//     $('table tr td').click(function() {
	//         var txt = $(this).text();
	//         document.getElementById('car').value = txt;
	//         $('#Car_list tr td').css('border', '1px solid black');
	//         $(this).css('border', '2px solid blue');
	// 	});
</script>


<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="style.css" rel="stylesheet">
  <link href="QnA/QnA11/bootstrap.css" rel="stylesheet">
 <link href="QnA/QnA11/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

 <jsp:include page="/inc/Header.jsp"></jsp:include>
</head>

<body class="loader-active">

    <!--== Preloader Area Start ==-->
    <div class="preloader">
        <div class="preloader-spinner">
            <div class="loader-content">
                <img src="assets/img/preloader.gif" alt="JSOFT">
            </div>
        </div>
    </div>
    <!--== Preloader Area End ==-->

    <jsp:include page="/inc/Header.jsp"></jsp:include>
    <!--== Header Area End ==-->

    <!--== Page Title Area Start ==-->
    <section id="page-title-area" class="section-padding overlay">
        <div class="container">
            <div class="row">
                <!-- Page Title Start -->
                <div class="col-lg-12">
                    <div class="section-title  text-center">
                        <h2>BOOK List</h2>
                        <span class="title-line"><i class="fa fa-car"></i></span>
                        <p>Rental list page</p>
                    </div>
                </div>
                <!-- Page Title End -->
            </div>
        </div>
    </section>
    <!--== Page Title Area End ==-->

    <!--== Car List Area Start ==-->
<%
System.out.println(pickup);
System.out.println(end);
System.out.println(SelCarType);

%>
</head>

<script type="text/javascript">
		
function search(id){
	alert(id);
}		
		
		
</script>

<body>
<br>


        <div class="container">
<!--             <div class="row"> -->
<form action="BookForm2.bk" method="post">
                        <div class="single-sidebar">
                            <h3>Rental List</h3>
                            <div class="sidebar-body">
                                <ul class="recent-tips">
                                    <li class="single-recent-tips">
                                        <div class="recent-tip-thum">
                                            <a href="#"><img src="assets/img/we-do/service1-img.png" alt="JSOFT"></a>
                                        </div>
                                        <div class="recent-tip-body">
                                            <h4><a href="#">기간선택</a></h4>
                                            <span class="date">
          인수날짜 : <input type="date" id="pickup_date" name="pickup_date" value="<%=pickup %>"> 
도착날짜 : <input type="date" id="end_date" name="end_date" value="<%=end %>"> </span>
                                        </div>
                                    </li>

                                    <li class="single-recent-tips">
                                        <div class="recent-tip-thum">
                                            <a href="#"><img src="assets/img/we-do/service3-img.png" alt="JSOFT"></a>
                                        </div>
                                        <div class="recent-tip-body">
                                            <h4><a href="#">차량유형 선택</a></h4>
                                            <span class="date">
                                            <table id="Car_list" style="float: left;">
<tr>
<td>경차<input type="radio" name="SelCar" value="경차" <%if(SelCarType.equals("경차")){ %>checked<%} %>></td>
<td>소형<input type="radio" name="SelCar" value="소형" <%if(SelCarType.equals("소형")){ %>checked<%} %>></td>
<td>중형<input type="radio" name="SelCar"  value="중형" <%if(SelCarType.equals("중형")){ %>checked<%} %>></td>
</tr>
<tr>
<td>준대형<input type="radio" name="SelCar"  value="준대형" <%if(SelCarType.equals("준대형")){ %>checked<%} %>></td>
<td>대형<input type="radio" name="SelCar"  value="대형" <%if(SelCarType.equals("대형")){ %>checked<%} %>></td>
<td>승합<input type="radio" name="SelCar"  value="승합" <%if(SelCarType.equals("승합")){ %>checked<%} %>></td>
</tr>
<tr>
<td>SUV/RV<input type="radio" name="SelCar"  value="SUVㅣRV" <%if(SelCarType.equals("SUVㅣRV")){ %>checked<%} %>></td>
<td>전기차<input type="radio" name="SelCar"  value="전기차" <%if(SelCarType.equals("전기차")){ %>checked<%} %>></td>
<td>수입차<input type="radio" name="SelCar"  value="수입차"  <%if(SelCarType.equals("수입차")){ %>checked<%} %>></td>
</tr>
</table><br>


<br>
<br>
 <h4><a href="#">추가 선택 사항</a></h4><br>
 (미선택시 회원가입시 입력 사항으로 초기 검색 됩니다.)<br>
 
 

<!-- <input type="checkbox" name="option_baby" value="아기" />아기 카시트 -->
<!-- <input type="checkbox" name="option_smoke" value="흡연" />흡연여부 -->
<!-- <input type="checkbox" name="option_pet" value="동물" />애완동물 -->


<input type="checkbox" name="option_baby" value="아기" <%if(baby != null){%>checked <%}%>/>아기 카시트
<input type="checkbox" name="option_smoke" value="흡연" <%if(smoke != null){%>checked <%}%>/>흡연여부
<input type="checkbox" name="option_pet" value="동물" <%if(pet != null){%> checked <%}%>/>애완동물

	<br>						 `
<input type="submit" value="재검색" ><br></span>
                                        </div>
                                    </li>

                                    <li class="single-recent-tips">
                                        <div class="recent-tip-thum">
                                            <a href="#"><img src="assets/img/we-do/service2-img.png" alt="JSOFT"></a>
                                        </div>
                                        <div class="recent-tip-body">
                                            <h4><a href="#">How to Enjoy Losses Angeles Car Rentals</a></h4>
                                            <span class="date"><input type="hidden" id="pickup_date" name="pickup_date" value="<%=pickup %>">
                                            
<input type="hidden" id="end_date" name="end_date" value="<%=end %>">
                                            </span>
                                        </div>
                                    </li>

                                </ul>
                            </div>
                        </div>
            </form>
            
        






 
 




 
 



 
 
 <form action="BookPro.bk" method="post">
 
  <section id="car-list-area" class="section-padding">
        <div class="container">
            <div class="row">
                <!-- Car List Content Start -->
                <div class="col-lg-12">
                    <div class="car-list-content">
                        <div class="row">
                            <!-- Single Car Start -->
           
           
           
           
           
            <table id="carselect">
	
				
				
			
			
			<%
			
			
			
			String ct = null;
			
			for(int i = 0; i<carList.size(); i++){
			
				ct = carList.get(i).getCar_type().toString();
				
				if(carList.get(i).isCar_is_rent()==true && ct.equals(SelCarType)) {
			 
				%>
                    <tr >
                              <div class="col-lg-6 col-md-6">
                                <div class="single-car-wrap">
<!--                                     <div class="car-list-thumb car-thumb-1"> -->
                                    <div>
                                    <img src="ChartCarimg/<%=carList.get(i).getCar_name()%>.png">
                                    </div>
<!--                                     </div> -->
                                    <div class="car-list-info without-bar">
                                        <h2><a href="#"><%=carList.get(i).getCar_id() %></a></h2>
                                        <h5><%=carList.get(i).getCar_maker() %>/<%=carList.get(i).getCar_type() %></h5>
                                        <p>연식 : <%=carList.get(i).getCar_year() %>/ cc: <%=carList.get(i).getCar_cc() %>/ 트렁크 : <%=carList.get(i).getCar_trunk() %>
                                       /차량 색상 <%=carList.get(i).getCar_color() %></p>
                                        <ul class="car-info-list">
                                            <li><%=carList.get(i).getCar_price_normal()*rentday %></li>
                                            <li><%=carList.get(i).getCar_oil()%></li>
                                            <li>Auto</li>
                                        </ul>
                                        <p class="rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star unmark"></i>
                                        </p>
<!--                                         <a href="#" class="rent-btn">카드</a> -->
<!--                                          <a href="#" class="rent-btn">무통장</a> -->
				<%if(id == null){%>
             	 <input type="button" class="rent-btn" id="selbtn" value="카드결제" onclick="noId()">
					<input type="button" class="rent-btn" id="selbtn" value="무통장입금" onclick="noId()">
						<%
						}else{
						%>
						<input type="button" class="rent-btn" id="selbtn" value="카드결제" onclick="vbank('<%=carList.get(i).getCar_id()%>','<%=pickup%>','<%=end%>','<%=carList.get(i).getCar_price_normal()*rentday%>','<%if(id == null){%><%=snsid%><%}else{%><%=id%><%};%>','<%=SelCarType%>','card')">
						<input type="button" class="rent-btn" id="selbtn" value="무통장입금" onclick="vbank('<%=carList.get(i).getCar_id()%>','<%=pickup%>','<%=end%>','<%=carList.get(i).getCar_price_normal()*rentday%>','<%if(id == null){%><%=snsid%><%}else{%><%=id%><%};%>','<%=SelCarType%>','cash')">
						
					<%
					}
					%>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Car End -->
 


					

					

				
			<%
			}
			}
			%>
			</table>

</form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Articles Content End -->
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


        <jsp:include page="/inc/Footer.jsp"></jsp:include>


</body>


</html>