<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="myPage/css/bootstrap.css">
<link rel="stylesheet" href="myPage/css/infoStyle.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<script src="myPage/js/bootstrap.js"></script>
<body>
	<link
		href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
		rel="stylesheet">

	<!--== Header Area Start ==-->
	<jsp:include page="../inc/Header.jsp" />
	<section id="page-title-area" class="section-padding overlay">
		<div class="container">
			<div class="row">
				<!-- Page Title Start -->
				<div class="col-lg-12">
					<div class="section-title  text-center">
						<h2>MyPage</h2>
						<span class="title-line"><i class="fa fa-car"></i></span>
						<p>Check your profile, Change your infomation</p>
					</div>
				</div>
				<!-- Page Title End -->
			</div>
		</div>
	</section>
	<!--== Page Title Area End ==-->
	<!--== Header Area End ==-->

	<div class="container bootstrap snippets bootdey">
		<div class="row">
			<div class="main-content">
				<div class="tab-content profile-page">
					<!-- PROFILE TAB CONTENT -->
					<div class="tab-pane profile active" id="profile-tab">
						<div class="row">
							<form action="deleteInfoPro.if" id="info_form" method="post">
								<h3>
									<i class="fa fa-square"></i> 회원탈퇴
								</h3>
								<p class="data-row">
								<span>주의! 회원탈퇴 이후에는 복구가 불가능합니다</span><br>
								<br>
									<span class="data-name">UserPass</span><span class="data-value"><input type="password" name="pass" value=""></span>
								</p>
								<input type="submit" class="usebutton" value="확인"><input type="button" class="usebutton" value="취소" onclick="javascript:history.back()">
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!--== Footer Area Start ==-->
	<jsp:include page="../inc/Footer.jsp" />
	<!--== Footer Area End ==-->


	<form action="deleteInfoPro.if" method="post">
		<table border="1">
			<tr>
				<th colspan="2">회원탈퇴</th>
			</tr>
			<tr>
				<th>비밀번호 입력</th>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="확인"><input
					type="button" value="취소" onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>