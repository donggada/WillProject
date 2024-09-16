<%@page import="info.vo.pageinfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="info.vo.ListBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="myPage/css/bootstrap.css">
	<link rel="stylesheet" href="myPage/css/infoStyle.css"> 

    <%
    	ListBean lb = (ListBean)request.getAttribute("bean");
    	ArrayList<ListBean> list = (ArrayList<ListBean>)request.getAttribute("list");
    	pageinfo pagecheck = (pageinfo)request.getAttribute("pageinfo");
    	int checkNum = 0;
    	int listCount = pagecheck.getListcount();
    	int nowPage = pagecheck.getPage(); 
    	int startPage = pagecheck.getStartpage();
    	int endPage = pagecheck.getEndpage();
    	int maxPage = pagecheck.getMaxpage();
    	if((request.getParameter("page") != null))
    	{
    			checkNum = Integer.parseInt(request.getParameter("page"));
    			
        	if(checkNum != 1)
        	{
        		checkNum = startPage * 10;
        	}
        	else if(checkNum == 1)
        	{
        		checkNum = 0;
        	}
    	}

    %>
<!DOCTYPE html>
<html>
<script src="js/jquery-3.5.1.js"></script>
<script type="text/javascript">

 function updatepage() {
	 document.getElementById('info_form').submit();
}

 function onClickUpdate() {
	 var button_name = document.getElementById('info_name'); 
	 var button_age = document.getElementById('info_age'); 
	 var button_tel = document.getElementById('info_tel'); 
	 var button_pass = document.getElementById('info_pass');
	 var button_license = document.getElementById('info_license');
	 var button_smoke = document.getElementById('info_smoke');
	 var button_pet = document.getElementById('info_pet');
	 var button_baby = document.getElementById('info_baby');
	 var btn = document.createElement("BUTTON");
	 
	 	button_name.disabled = false; 
	 	button_age.disabled = false; 
	 	button_tel.disabled = false;
	 	button_pass.disabled = false;
	 	button_license.disabled = false;
	 	button_smoke.disabled = false;
	 	button_pet.disabled = false;
	 	button_baby.disabled = false;
	 
	 document.getElementById('update').value = "취소";
	 document.getElementById('update').onclick = cancel;
	 btn.innerHTML = "수정완료";
	 btn.id = 'updatebtn';
	 document.getElementById('button').appendChild(btn);
	 btn.onclick = updatepage;
}
 function cancel() {
	 var button_name = document.getElementById('info_name'); 
	 var button_age = document.getElementById('info_age'); 
	 var button_tel = document.getElementById('info_tel'); 
	 var button_pass = document.getElementById('info_pass');
	 var button_license = document.getElementById('info_license');
	 var button_smoke = document.getElementById('info_smoke');
	 var button_pet = document.getElementById('info_pet');
	 var button_baby = document.getElementById('info_baby');
	 var checkupdate = document.getElementById('updatebtn'); 
	 
	 	button_name.disabled = true; 
	 	button_age.disabled = true; 
	 	button_tel.disabled = true;
	 	button_pass.disabled = true;
	 	button_license.disabled = true;
	 	button_smoke.disabled = true;
	 	button_pet.disabled = true;
	 	button_baby.disabled = true;
	 	
		 document.getElementById('update').value = "수정하기";
		 checkupdate.remove();
		 document.getElementById('update').onclick = onClickUpdate; 
}
</script>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<script src="myPage/js/bootstrap.js"></script>
<body>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

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
            <!-- NAV TABS -->
<!--         	<ul class="nav nav-tabs nav-tabs-custom-colored tabs-iconized"> -->
<!--         		<li class="active"><a href="#profile-tab" data-toggle="tab" aria-expanded="true"><i class="fa fa-user"></i> 회원정보</a></li> -->
<!--         		<li class=""><a href="#activity-tab" data-toggle="tab" aria-expanded="false"><i class="fa fa-rss"></i> 예약현황</a></li> -->
<!--         	</ul> -->
        	<!-- END NAV TABS -->
        	<div class="tab-content profile-page">
        		<!-- PROFILE TAB CONTENT -->
        		<div class="tab-pane profile active" id="profile-tab">
        			<div class="row">
        			    <form action="UpdateInfo.if" id="info_form" method="post">
        				  <div class="col-md-9">
        					<div class="user-info-right">
        						<div class="basic-info">
        							<h3><i class="fa fa-square"></i> 기본사항</h3>
        							<p class="data-row">
        								<span class="data-name">UserID</span>
        								<span class="data-value"><%=lb.getId() %></span>
        							</p>
        							<p class="data-row">
        								<span class="data-name">Password</span>
        								<span class="data-value"><input type="password" name="pass" id="info_pass" value="<%=lb.getPass() %>" disabled></span>
        							</p>
        							<p class="data-row">
        								<span class="data-name">UserName</span>
        								<span class="data-value"><input type="text" name="name" id="info_name" value="<%=lb.getName() %>" disabled></span>
        							</p>
        							<p class="data-row">
        								<span class="data-name">Age</span>
        								<span class="data-value"><input type="text" name="age" id="info_age" value="<%=lb.getAge() %>" disabled></span>
        							</p>
        							<p class="data-row">
        								<span class="data-name">Gender</span>
        								<span class="data-value"><%=lb.getGender() %></span>
        							</p>
        							<p class="data-row">
        								<span class="data-name">Tel</span>
        								<span class="data-value"><input type="text" name="tel" id="info_tel" value="<%=lb.getTel() %>" disabled></span>
        							</p>
        							<p class="data-row">
        								<span class="data-name">Address</span>
        								<span class="data-value"><%=lb.getAddress() %></span>
        							</p>
        							<p class="data-row">
        								<span class="data-name">Email</span>
        								<span class="data-value"><%=lb.getEmail() %></span>
        							</p>
        						</div>
        						<div class="contact_info">
        							<h3><i class="fa fa-square"></i> 선택사항</h3>
        							<p class="data-row">
        								<span class="data-name">Grade</span>
        								<span class="data-value"><%=lb.getGrade() %></span>
        							</p>
        							<p class="data-row">
        								<span class="data-name">license</span>
        								<span class="data-value"><input type="text" name="license" id="info_license" value="<%=lb.getLicense() %>" disabled></span>
        							</p>
        							<p class="data-row">
        								<span class="data-name">Smoking</span>
        								<span class="data-value"><input type="text" name="smoke" id="info_smoke" value="<%=lb.getSmoke() %>" disabled></span>
        							</p>
        							<p class="data-row">
        								<span class="data-name">Pet</span>
        								<span class="data-value"><input type="text" name="pet" id="info_pet" value="<%=lb.getPet() %>" disabled></span>
        							</p>
        							<p class="data-row">
        								<span class="data-name">Baby</span>
        								<span class="data-value"><input type="text" name="baby" id="info_baby" value="<%=lb.getBaby() %>" disabled></span>
        							</p>
										<div id='button'>
										<input type="button" class="usebutton" id="update" value="수정하기" onclick="onClickUpdate()">
										</div>
										<input type="button" class="usebutton" value="회원탈퇴" onclick="location.href='deleteInfo.if'">
									</div>
									<p style="visibility: hidden;">Dramatically facilitate proactive solutions whereas professional intellectual capital. Holisticly utilize competitive e-markets through intermandated meta-services. Objectively.</p>
									<div>
									</div>
								<h3><i class="fa fa-square"></i> 예약현황</h3>
									<%
							if(list != null & pagecheck.getListcount() > 0)
							{
							%>
							<table class="contentTable">
							<tr>
							<th>순번</th><th>예약일시</th><th>대여일</th><th>반납일</th><th>차량 아이디</th><th>가격</th>
							</tr>
							<%
							for(int i =0; i < list.size(); i++)
							{
							%>
							<tr>
							<td><%=checkNum + (i+1) %></td>
							<td><%=list.get(i).getBook_date() %></td>
							<td><%=list.get(i).getPickup_date() %></td>
							<td><%=list.get(i).getEnd_date() %></td>
							<td><%=list.get(i).getCar_id() %></td>
							<td><%=list.get(i).getPrice() %>원</td>
							</tr>
							<%
							}
							%>
							</table>

        			    <%if(nowPage<=1){ %>
						    [이전]
						    <%}else{ %>
						        <a href="MemberInfo.if?page=<%=nowPage-1 %>">[이전]</a>
						    <%} %>
						    <%for(int a=startPage; a<=endPage; a++){ 
						        if(a==nowPage){%>
						            [<%=a %>]
						    <%} else { %>
						        <a href="MemberInfo.if?page=<%=a %>">[<%=a %>]</a>
						        <%} %>    
						    <%} %>
						    <%if(nowPage>=maxPage){ %>
						        [다음]
						    <%}else{ %>    
						        <a href="MemberInfo.if?page=<%=nowPage+1 %>">[다음]</a>
						    <%} %>
							<%}else{
							%>등록된 글이 없습니다.
							<%} %>
        					</div>
        				</div>
        			  </form>
        			</div>
        		</div>
        		<!-- END PROFILE TAB CONTENT -->
        
        		<!-- ACTIVITY TAB CONTENT -->
        		<div class="tab-pane activity" id="activity-tab">
        			<ul class="list-unstyled activity-list">
        				<li>
						</li>
					</ul>
        		</div>
        		<!-- END ACTIVITY TAB CONTENT -->
        	</div>
        </div>    
	</div>
</div>

	<!--== Footer Area Start ==-->
		<jsp:include page="../inc/Footer.jsp" />
	<!--== Footer Area End ==-->
</body>
</html>











