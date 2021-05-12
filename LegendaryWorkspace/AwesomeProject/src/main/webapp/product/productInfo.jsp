<%@page import="product.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/AwesomeProject/userInfo/index_test.css">
<%
ProductBean findByID = (ProductBean) session.getAttribute("find");
%>
</head>
<body>
	<div class="allpage">
		<header>
			<img class="logo-img" src="/AwesomeProject/images/logo.jpg"
				title="logo" alt="logo">
			<nav>
				<ul class="menu">
					<li><a href="/AwesomeProject/index_test.html"><b>首頁</b></a></li>
					<li><a href="/AwesomeProject/ControlServlet?findAllToUser"><b>課程</b></a></li>
					<li><a href="/AwesomeProject/chat/Chat.html"><b>討論區</b></a></li>
					<li><a href="/AwesomeProject/question/QuesFormDS.jsp"><b>測驗區</b></a></li>
					<li><a href="/AwesomeProject/event/NewFile.jsp"><b>活動</b></a></li>
					<li><a href="/AwesomeProject/cart/cartIndex.jsp"><b>購物車</b></a></li>
					<li><a href=""><b>關於</b></a></li>
					<li style="float: right;"><a
						href="/AwesomeProject/userInfo/AdminLogin.jsp"><b>GM系統</b></a></li>
					<li style="float: right;"><a
						href="/AwesomeProject/userInfo/test_UserUpdate.jsp"><b>修改會員資料</b></a></li>
					<li style="float: right;"><a
						href="/AwesomeProject/userInfo/UserLogin.jsp"><b>登入</b></a></li>
					<li style="float: right;"><a
						href="/AwesomeProject/userInfo/UserSignUp.jsp"><b>註冊</b></a></li>
				</ul>
			</nav>
		</header>
		<div class="content">
			<%
			String imgName = findByID.getP_Img().split("\\\\")[10];
			String videoName = findByID.getP_Video().split("\\\\")[10];
			String productName = findByID.getP_Name();
			%>
			
			<h1>hello <%=findByID.getP_Name()%></h1>
			<hr>
			<div><img src="File/en001Pic.png" width="300px" height="200px"></div>
			<hr>
			<h3>簡介:</h3>
			<div>
				Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quibusdam facilis minus eveniet nulla repudiandae maxime odit cupiditate minima tempore, nihil id nisi quod dolores quidem sapiente assumenda debitis in accusamus?
			</div>
			<hr>
			<div>
				<iframe width="900" height="506" src="File/en001.mp4" frameborder="0" allow="accelerometer;clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
			</div>
			
			
			
			
			
			
			
			
			
		</div>
		<!--end content-->
	</div>
	<!--end allpage-->



</body>
</html>