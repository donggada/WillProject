<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!--=== Bootstrap CSS ===-->
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<!--=== Slicknav CSS ===-->
<link href="../assets/css/plugins/slicknav.min.css" rel="stylesheet">
<!--=== Magnific Popup CSS ===-->
<link href="../assets/css/plugins/magnific-popup.css" rel="stylesheet">
<!--=== Owl Carousel CSS ===-->
<link href="../assets/css/plugins/owl.carousel.min.css" rel="stylesheet">
<!--=== Gijgo CSS ===-->
<link href="../assets/css/plugins/gijgo.css" rel="stylesheet">
<!--=== FontAwesome CSS ===-->
<link href="../assets/css/font-awesome.css" rel="stylesheet">
<!--=== Theme Reset CSS ===-->
<link href="../assets/css/reset.css" rel="stylesheet">
<!--=== Main Style CSS ===-->
<link href="../style.css" rel="stylesheet">
<!--=== Responsive CSS ===-->
<link href="../assets/css/responsive.css" rel="stylesheet">
<style type="text/css">
*{background-color: black;}

#car_num{color: #ffc107;}
#car_maker{color: #ffc107;}
#car_type{color: #ffc107;}
#car_name{color: #ffc107;}
#btn{align-items: center;}
</style>


</head>
<body>
<!-- Single Pricing Table -->
<form action="insertCar.ad" method="post">
				<div class="col-lg-4 col-md-6 text-center">
					<div class="single-pricing-table1">
						
						<h2 id="car_num">차량번호 :<input type="text" name="car_num" required="required" id="car_name"></h2>

						<ul class="package-list">
						<li id="car_num">
						제조사:<input type="text" name="car_maker" required="required" id="car_name" >
						차이름:<input type="text" name="car_name" required="required" id="car_name">
						</li>
						
						<li id="car_num">
						차량종류:<select id="car_name" name="car_type">
						<option value="0">경차</option>
						<option value="1">소형</option>
						<option value="2">중형</option >
						<option value="3">준대형</option>
						<option value="4">대형</option >
						<option value="5">승합</option>
						<option value="6">SUV/RV</option >
						<option value="7">전기차</option>
						<option value="8">수입차</option>
						</select>
						색상:<input type="text" name="car_color" required="required" id="car_name">
						</li>
						
						<li id="car_num">
						연식:<input type="text" name="car_year" required="required" id="car_name">
						Oil(연료):<select id="car_name" name="car_oil">
						<option value="0">가솔린</option>
						<option value="1">경유</option>
						<option value="2">LPG</option >
						<option value="3">CNG</option>
						<option value="4">전기</option >
						<option value="5">하이브리드</option>
						</select>
						
						 </li>
						 
						<li id="car_num">
						가격:<input type="text" name="car_price_normal" required="required" id="car_name">
						세일:<input type="text" name="car_price_sale" required="required" id="car_name">
						 </li>
						 
						<li id="car_num">
						네비:<select id="car_name" name="car_is_navi"><option value="1">yes</option ><option value="0">no</option></select>
						오토여부<select id="car_name" name="car_is_auto"><option value="1">yes</option ><option value="0">no</option></select>
						<li>
						
						<li id="car_num">
						구륜방식:
						<select id="car_name" name="car_function">
						<option value="0">전륜</option >
						<option value="1">후륜</option>
						<option value="2">사륜구동</option>
						</select>
						배기량:<input type="text" name="car_cc" required="required" id="car_name">
						</li>
						
						<li id="car_num">	
						면허증기준:
						<select id="car_name" name="car_license_type">
						<option value="0">1종대형</option >
						<option value="1">1종보통 </option>
						<option value="2">1종소형</option>
						<option value="3">1종특수</option >
						<option value="4">2종보통</option>
						<option value="5">2종소형</option>
						<option value="6">2종원동기</option >
						</select>
						</li>
						<li id="car_num">
						
						수용인원:<input type="text" name="car_people_max" required="required" id="car_name">
						</li>
						<li id="car_num">
						흡연여부:<select id="car_name" name="car_is_smoke"><option value="1">yes</option ><option value="0">no</option></select>
						</li>
						
						<li id="car_num">
						애완동물여부:<select id="car_name" name="car_is_pet"><option value="1">yes</option ><option value="0">no</option></select>
						</li>	
							
						</ul>
					</div>
				</div>
&emsp&emsp&emsp<input type="submit" value="등록하기" width="100px" height="100px" style="background-color: gray;" >&emsp&emsp<input type="button" value="닫기" onclick="window.close()" style="background: gray;">	<!-- Single Pricing Table -->
</form>
</body>
</html>