<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String ip = request.getRemoteAddr();
%>
<html class="no-js" lang="zxx">
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
<header id="header-area" class="fixed-top">
	<!--== Header Top Start ==-->
	<div id="header-top" class="d-none d-xl-block">
		<div class="container">
			<div class="row">
				<!--== Single HeaderTop Start ==-->
				<div class="col-lg-3 text-left">
					<i class="fa fa-map-marker"></i> S.Kor Jejudo
				</div>
				<!--== Single HeaderTop End ==-->

				<!--== Single HeaderTop Start ==-->
				<div class="col-lg-3 text-center">
					<i class="fa fa-mobile"></i> +82 051 264 2222
				</div>
				<!--== Single HeaderTop End ==-->

				<!--== Single HeaderTop Start ==-->
				<div class="col-lg-3 text-center">
					<i class="fa fa-clock-o"></i> Open Throughout The Year
				</div>
				<!--== Single HeaderTop End ==-->

				<!--== Social Icons Start ==-->
				<div class="col-lg-3 text-right">
					<div class="header-social-icons" style="font-size: 8px;">
						<%
						String id=(String)session.getAttribute("Member_id");
						String snsid=(String)session.getAttribute("Member_snsid");
						String totalId = null;
						if(id !=null){
							totalId=id;
						}else if(snsid!=null){
							totalId=snsid;
						}else{
							totalId=null;
						}

						
						if (totalId==null) {%>
						<a href="LoginForm.me">로그인</a> | <a href="JoinForm.me">회원가입</a>
					<a href="" onclick="window.open('chat/admin.jsp','admin','width=750, height=750, resizable=no')">|관리자채팅</a>
						<%}else if(totalId!=null&& totalId.equals("admin")){%>
						<%=totalId%>님 | <a href="MemberLogout.me">logout</a> | 
						<a href="MemberInfo.if">마이페이지</a>
                        <a href="" onclick="window.open('chat/admin.jsp','admin','width=750, height=750, resizable=no')">|관리자채팅</a>
						<a href="adminpage.ad">| admin page</a>
						<%}else if(totalId!=null){%> <%=totalId%>님 | <a href="MemberLogout.me">logout</a> | 
						<a href="MemberInfo.if">마이페이지</a>
						<a href="" onclick="window.open('chat/admin.jsp','admin','width=750, height=750, resizable=no')">|관리자채팅</a>
						<%} %>
					</div>
				</div>
				<!--== Social Icons End ==-->

			</div>
		</div>
	</div>
	<!--== Header Top End ==-->

	<!--== Header Bottom Start ==-->
	<div id="header-bottom">
		<div class="container">
			<div class="row">
				<!--== Logo Start ==-->
				<div class="col-lg-4">
					<a href="index.jsp" class="logo"> <img
						src="assets/img/logo.png" alt="JSOFT">
					</a>
				</div>
				<!--== Logo End ==-->

				<!--== Main Menu Start ==-->
				<div class="col-lg-8 d-none d-xl-block">
					<nav class="mainmenu alignright">
						<ul style="list-style: none;">
							<li class="active"><a href="index.jsp">Home</a> <!--                                     <ul> -->
								<!--                                         <li><a href="index.jsp">Home 1</a></li> -->
                <!--                                     </ul> --></li>

		
              				<li><a href="carIntro.bk">차량 소개</a></li>
		  					<li><a onclick="OpenMap()">코로나Map</a></li>

							<li><a href="ReviewList.rw">Review</a></li>
							<li><a href="#">고객센터</a>
								<ul>				
									<li><a href="faqlist.fbo">FAQ</a></li>
									<li><a href="qnawrite.bo">Q&A</a></li>
									<li><a onclick="chat_bot()">1:1 문의</a></li>
								</ul>
							</li>
							
						</ul>
					</nav>
				</div>
				<!--== Main Menu End ==-->
			</div>
		</div>
	</div>
	<!--== Header Bottom End ==-->
</header>
<script type="text/javascript">
function chat_bot() {
	window.open('chat/chat_bot.jsp','new','width=800, height=600, resizable=no');
}
var popupX = (window.screen.width/2)-(500/2);
//만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

var popupY= (window.screen.height/2)-(500/2);
//만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음

function OpenMap()
{
  // window.open("open할 window", "자식창 이름", "팝업창 옵션"); 
 window.open('map/maptest.jsp', '코로나 Map', 'status=no, height=600, width=600, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
}

 function logout() {
	 sessionStorage.clear();
	 alert("로그아웃");
	 location.href = "index.jsp";
}
</script>
<!--== Header Area End ==-->