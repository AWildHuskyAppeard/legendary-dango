<%@page import="userInfo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
%>
<html>
<head>
<meta charset="UTF-8">
<title>會員資料</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/AwesomeProject/assets/css/main.css" />
<noscript><link rel="stylesheet" href="/AwesomeProject/assets/css/noscript.css" /></noscript>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">
	
	<!-- include header進來 -->
	<jsp:include page="/test_header.jsp" />

		<!-- Main -->
		<div id="main" class="alt">

			<!-- One -->
			<section id="one">
				<div class="inner">
					<header class="major">
						<h1>會員資料</h1>
					</header>
					<!-- <span class="image main"><img src="images/pic11.jpg" alt="" /></span> -->
					<%
						UserBean userBean = (UserBean)request.getSession().getAttribute("userData");
					%>
					<%
						if(userBean != null){
						String userID = userBean.getU_ID();
						String userPsw = userBean.getU_Psw();
						String userBday = userBean.getU_BirthDay();
						String userLastName = userBean.getU_LastName();
						String userFirstName = userBean.getU_FirstName();
						String userEmail = userBean.getU_Email();
						String userTel = userBean.getU_Tel();
						String userSex = userBean.getU_Sex();
						String userAddress = userBean.getU_Address();
					%>
					<form action="/AwesomeProject/UserServlet" method="POST">
					<h3>USER ID: <%=userID %></h3>
					<!-- <p>PARAGRAPH.</p> -->
					<p>修改密碼: <input type="Password" name="u_Psw"></p>
					<p>確認密碼: <input type="Password" name="cfm_Psw" placeholder="請再次輸入密碼"></p>
					<p>生日: <%=userBday %></p>
					<p><input type="date" name="u_BirthDay" style="color:darkgray;"></p>
					<p>姓: <input type="text" name="u_LastName" value="<%=userLastName %>"></p>
					<p>名: <input type="text" name="u_FirstName" value="<%=userFirstName %>"></p>
					<p>信箱: <input type="text" name="u_Email" value="<%=userEmail %>"></p>
					<p>電話: <input type="text" name="u_Tel" value="<%=userTel %>"></p>
					<p>性別: <%=userSex %>
					<p>地址: <input type="text" name="u_Address" value="<%=userAddress %>"></p>
					
						<button type="submit" name="modifyUserInfo">修改</button>
					</form>
					<%
						} else {
					%>
					<script>
						alert("您還沒有登入, 請登入...");
						top.location.href = "/AwesomeProject/userInfo/UserLogin.jsp";
					</script>
					<%
						}
					%>
				</div>
			</section>

		</div>

		<!-- Contact -->

		<!-- Footer -->
		<!-- include footer進來 -->
	<jsp:include page="/test_footer.jsp"/>

	</div>

	<!-- Scripts -->
	<script src="/AwesomeProject/assets/js/jquery.min.js"></script>
	<script src="/AwesomeProject/assets/js/jquery.scrolly.min.js"></script>
	<script src="/AwesomeProject/assets/js/jquery.scrollex.min.js"></script>
	<script src="/AwesomeProject/assets/js/browser.min.js"></script>
	<script src="/AwesomeProject/assets/js/breakpoints.min.js"></script>
	<script src="/AwesomeProject/assets/js/util.js"></script>
	<script src="/AwesomeProject/assets/js/main.js"></script>
</body>
</html>