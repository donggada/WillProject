<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--=== Favicon ===-->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

    <title>Cardoor - Car Rental HTML Template</title>

    <!--=== Bootstrap CSS ===-->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!--=== Slicknav CSS ===-->
    <link href="assets/css/plugins/slicknav.min.css" rel="stylesheet">
    <!--=== Magnific Popup CSS ===-->
    <link href="assets/css/plugins/magnific-popup.css" rel="stylesheet">
    <!--=== Owl Carousel CSS ===-->
    <link href="assets/css/plugins/owl.carousel.min.css" rel="stylesheet">
    <!--=== Gijgo CSS ===-->
    <link href="assets/css/plugins/gijgo.css" rel="stylesheet">
    <!--=== FontAwesome CSS ===-->
    <link href="assets/css/font-awesome.css" rel="stylesheet">
    <!--=== Theme Reset CSS ===-->
    <link href="assets/css/reset.css" rel="stylesheet">
    <!--=== Main Style CSS ===-->
    <link href="style.css" rel="stylesheet">
    <!--=== Responsive CSS ===-->
    <link href="assets/css/responsive.css" rel="stylesheet">


    <!--[if lt IE 9]>
        <script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
      <link href="style.css" rel="stylesheet">
  <link href="QnA/QnA11/bootstrap.css" rel="stylesheet">
 <link href="QnA/QnA11/bootstrap.min.css" rel="stylesheet">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
 
    
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

    <!--== Header Area Start ==-->
  <jsp:include page="../inc/Header.jsp" />
  
    <!--== Header Area End ==-->

    <!--== Slider Area Start ==-->
    <section id="slider-area">
        <!--== slide Item One ==-->
        <div class="single-slide-item overlay">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5">
                        <div class="book-a-car">
                            <form action="MemberJoinPro.me" method="post" name="loginform">
                                <!--== Pick Up Location ==-->
                                <div>
                                <h2>회원가입</h2>
                                </div><br>
                                <div class="pickup-location book-item">
                            
                                    <h5>아이디</h5>
                                    <input type="text" name="id" id="id" required="required" 
											placeholder="4~12자리 영문,숫자 조합">
                                    <input type="button" value="중복체크" id="btn">	
                                    <span id="checkIdResult"><!-- 자바스크립스에 의해 메세지 출력할 공간 --></span>
                                    
                                </div>
                                 <div class="pickup-location book-item">
                                    <h5>비밀번호</h5>
                                    <input type="password" name="pass" required="required" 
											placeholder="8~16자리 영문,숫자,특수문자 조합" onkeyup="checkPasswd(this)">
									<span id="checkPasswdResult"><!-- 자바스크립스에 의해 메세지 출력할 공간 --></span>
                                    
                                </div>
                                 <div class="pickup-location book-item">
                                    <h5>이름</h5>
                                    <input type="text" name="name" required="required" />
                                    
                                </div>
                                 <div class="pickup-location book-item">
                                    <h5>나이</h5>
                                    <input type="text" name="age" required="required" />
                                    
                                </div>
                                 <div class="pickup-location book-item">
                                    <h5>성별</h5>
                                   <select name="gender" required="required"><option>남</option><option>여</option></select>
                                    
                                </div>
                                 <div class="pickup-location book-item">
                                    <h5>전화번호</h5>
                                    <input type="text" name="tel" required="required" />
                                    
                                </div>
                                 <div class="pickup-location book-item">
                                    <h5>주소</h5>
                                    <input type="text" name="adress" required="required">
						   		    <input type="button" value="주소검색" onclick="juso()">
                                    
                                </div>
                                <div class="pickup-location book-item">
                                    <h5>이메일</h5>
									<input type="text" name="email" id="email" required="required" style="width: 100px;">
										@<select name="email1" id="email1" required="required" style="width: 100px;">
										<option>naver.com</option><option>google.com</option><option>hanmail.net</option></select>
                                    <input type="button" value="이메일 인증하기" id="emalicheck" style="width: 122px; font-size: 12px;">
                                    <span id="checkemailResult"><!-- 자바스크립스에 의해 메세지 출력할 공간 --></span>
                                    <input type="text"  id="tchecknum">
                                    <input type="button" value="확인" id="bchecknum">
                                    <span id="checkResult1"><!-- 자바스크립스에 의해 메세지 출력할 공간 --></span>
                                </div>
                                 <div class="pickup-location book-item">
                                    <h5>면허증</h5>
                                    <input type="text" name="license"  required="required" />
                                    
                                </div>
<!--                                  <div class="pickup-location book-item"> -->
                                    <h5>선택사항</h5>

                                    
                                        <div class="form-group">
    <div class="custom-control custom-checkbox">
      <input type="checkbox" class="custom-control-input" id="customCheck1" name="smoke" value="흡연">
      <label class="custom-control-label" for="customCheck1">흡연여부</label>
    </div>
      <div class="custom-control custom-checkbox">
      <input type="checkbox" class="custom-control-input" id="customCheck2" name="pet" value="동물">
      <label class="custom-control-label" for="customCheck2">애완동물</label>
    </div>
      <div class="custom-control custom-checkbox">
      <input type="checkbox" class="custom-control-input" id="customCheck3" name="baby" value="아기">
      <label class="custom-control-label" for="customCheck3">카시트</label>
    </div>
    
                                </div>
                              
						                 <div class="book-button text-center">
						                <input type="submit" value="회원가입" id="insertbtn" class="book-now-btn">					                               
               
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="col-lg-7 text-right">
                        <div class="display-table">
                            <div class="display-table-cell">
                                <div class="slider-right-text">
                                    <h1>행복한 휴가를 더욱 빛나게</h1>
                                    <p>최고의 서비스와 더불어 최고의 차량으로<br>휴가를 빛나게 만들겠습니다.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--== slide Item One ==-->
    </section>
   

    <!--== Footer Area Start ==-->
    <section id="footer-area">
        <!-- Footer Widget Start -->
        <div class="footer-widget-area">
            <div class="container">
                <div class="row">
                    <!-- Single Footer Widget Start -->
                    <div class="col-lg-4 col-md-6">
                        <div class="single-footer-widget">
                            <h2>About Us</h2>
                            <div class="widget-body">
                                <img src="assets/img/logo.png" alt="JSOFT">
                                <p>Lorem ipsum dolored is a sit ameted consectetur adipisicing elit. Nobis magni assumenda distinctio debitis, eum fuga fugiat error reiciendis.</p>

                                <div class="newsletter-area">
                                    <form action="index.jsp">
                                        <input type="email" placeholder="Subscribe Our Newsletter">
                                        <button type="submit" class="newsletter-btn"><i class="fa fa-send"></i></button>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                    <!-- Single Footer Widget End -->

                    <!-- Single Footer Widget Start -->
                    <div class="col-lg-4 col-md-6">
                        <div class="single-footer-widget">
                            <h2>Recent Posts</h2>
                            <div class="widget-body">
                                <ul class="recent-post">
                                    <li>
                                        <a href="#">
                                           Hello Bangladesh! 
                                           <i class="fa fa-long-arrow-right"></i>
                                       </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                          Lorem ipsum dolor sit amet
                                           <i class="fa fa-long-arrow-right"></i>
                                       </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                           Hello Bangladesh! 
                                           <i class="fa fa-long-arrow-right"></i>
                                       </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            consectetur adipisicing elit?
                                           <i class="fa fa-long-arrow-right"></i>
                                       </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- Single Footer Widget End -->

                    <!-- Single Footer Widget Start -->
                    <div class="col-lg-4 col-md-6">
                        <div class="single-footer-widget">
                            <h2>get touch</h2>
                            <div class="widget-body">
                                <p>Lorem ipsum doloer sited amet, consectetur adipisicing elit. nibh auguea, scelerisque sed</p>

                                <ul class="get-touch">
                                    <li><i class="fa fa-map-marker"></i> 800/8, Kazipara, Dhaka</li>
                                    <li><i class="fa fa-mobile"></i> +880 01 86 25 72 43</li>
                                    <li><i class="fa fa-envelope"></i> kazukamdu83@gmail.com</li>
                                </ul>
                                <a href="https://goo.gl/maps/b5mt45MCaPB2" class="map-show" target="_blank">Show Location</a>
                            </div>
                        </div>
                    </div>
                    <!-- Single Footer Widget End -->
                </div>
            </div>
        </div>
        <!-- Footer Widget End -->

        <!-- Footer Bottom Start -->
        <div class="footer-bottom-area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer Bottom End -->
    </section>
    <!--== Footer Area End ==-->

    <!--== Scroll Top Area Start ==-->
    <div class="scroll-top">
        <img src="assets/img/scroll-top.png" alt="JSOFT">
    </div>
    <!--== Scroll Top Area End ==-->

    <!--=======================Javascript============================-->
    <!--=== Jquery Min Js ===-->
    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <!--=== Jquery Migrate Min Js ===-->
    <script src="assets/js/jquery-migrate.min.js"></script>
    <!--=== Popper Min Js ===-->
    <script src="assets/js/popper.min.js"></script>
    <!--=== Bootstrap Min Js ===-->
    <script src="assets/js/bootstrap.min.js"></script>
    <!--=== Gijgo Min Js ===-->
    <script src="assets/js/plugins/gijgo.js"></script>
    <!--=== Vegas Min Js ===-->
    <script src="assets/js/plugins/vegas.min.js"></script>
    <!--=== Isotope Min Js ===-->
    <script src="assets/js/plugins/isotope.min.js"></script>
    <!--=== Owl Caousel Min Js ===-->
    <script src="assets/js/plugins/owl.carousel.min.js"></script>
    <!--=== Waypoint Min Js ===-->
    <script src="assets/js/plugins/waypoints.min.js"></script>
    <!--=== CounTotop Min Js ===-->
    <script src="assets/js/plugins/counterup.min.js"></script>
    <!--=== YtPlayer Min Js ===-->
    <script src="assets/js/plugins/mb.YTPlayer.js"></script>
    <!--=== Magnific Popup Min Js ===-->
    <script src="assets/js/plugins/magnific-popup.min.js"></script>
    <!--=== Slicknav Min Js ===-->
    <script src="assets/js/plugins/slicknav.min.js"></script>

    <!--=== Mian Js ===-->
    <script src="assets/js/main.js"></script>
    
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<script type="text/javascript">
jQuery(document).ready(function () {
	$('#btn').click(function() {
		var regex = /^[A-Za-z][A-Za-z0-9]{3,11}$/;
		var id=$('#id').val();
		if(regex.exec(id)) { 
			//중복 체크 실행
			$.ajax('Member/DupCheck.jsp',{data:{id:id},
							success:function(rdata){
								$('#checkIdResult').html(rdata);
							}});
			
		}else{
			alert('아이디 형식이적합하지 않음');
			
		}
			
	})
	
	$('#emalicheck').click(function() {    //이메일 인증 
		var email=$('#email').val()+"@"+$('#email1').val();
	
		
		if(email !=null){
			$.ajax('Member/EmailCheck.jsp',{data:{email:email},
				success:function(rdata){
					//timer
					$('#bchecknum').click(function() {
						var checkNum=$('#tchecknum').val();
						if(rdata.trim() == checkNum){
							$('#checkResult1').html('인증되었습니다.');
						}else{
							$('#checkResult1').html('인증번호가 다릅니다');
						}
					});
				}});
		}else {
			alert('Email 형식이적합하지 않음');
		}
		
	});
	

	
	$('#insertbtn').click(function(){
		if($('#checkIdResult').html().trim()=="아이디 사용가능"){
				if($('#checkPasswdResult').html().trim()=="적합한 패스워드"){
					if($('#checkResult1').html().trim()=="인증되었습니다."){
		
						}else{
							alert("이메일인증을해주세요");
							}
				}else{
					alert('비밀번호가 적합하지 않습니다');
				}
		}else {
			alert("아이디 인증해주세요");
		}
		
		
	});
	
	
	
	
});
	
	function checkPasswd(passwd) {
		// 8 ~ 16자리 패스워드 영문,숫자,특수문자 조합
		// 1. 정규표현식 지정
		// 1) 길이 체크 : 8 ~ 16자리. 영문 대문자&소문자&숫자&특수문자(!@#$%^_)
		var lengthRegex = /^[A-Za-z0-9!@#$%^_]{8,16}$/;
		// 2) 소문자 체크
		var lowerCaseRegex = /[a-z]/;
		// 3) 숫자 체크
		var digitRegex = /[0-9]/;
		// 4) 특수문자 체크
		var specCharRegex = /[!@#$%^_]/;
		
// 		// 2. 체크 후 메세지 표시할 공간의 태그 id 값 가져오기
		var element = document.getElementById('checkPasswdResult'); // checkPasswdResult 값을 ID 로 갖는 태그 찾기
		
// 		// 3. 정규표현식을 통한 유효성 검사 수행(정규표현식 저장 변수명.exec() 를 사용)
// 		// 함수 호출 시 전달받은 파라미터(id) 의 값을 정규표현식으로 검사
		// 길이, 대문자, 소문자, 숫자, 특수문자 체크를 모두 통과했을 경우
		if(passwd.value!=""){
			if(lengthRegex.exec(passwd.value) && lowerCaseRegex.exec(passwd.value) && digitRegex.exec(passwd.value) &&
					specCharRegex.exec(passwd.value)) {
// 			alert('유효성 검사 통과');	
			// 지정된 태그 내에 메세지 표시
				element.innerHTML = "적합한 패스워드";
			} else { // 유효성 검사를 통과하지 못했을 경우
// 			alert('유효성 검사 탈락');
				element.innerHTML = "적합하지 않은 패스워드";
			}
		}else{
				element.innerHTML = "";
		}		
	}
	
	
	function juso() {//주소 api
		
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	loginform.adress.value=data.jibunAddress	            
	        }
	    }).open();
	
	
	
	}
</script>
	
</body>

</html>
