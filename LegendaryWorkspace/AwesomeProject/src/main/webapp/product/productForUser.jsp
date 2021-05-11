<%@page import="product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/AwesomeProject/userInfo/index_test.css">
<%
ArrayList<ProductBean> list = (ArrayList<ProductBean>) session.getAttribute("list");
ProductBean findByID = (ProductBean) session.getAttribute("find");
%>
<style>
div {
	display: inline-block;
	padding: 20px;
	margin: 50px;
	text-align: center;
}

img {
	width: 200px;
	height: 200px;
}

nav {
	margin: 30px;
}

form {
	text-align: center;
}
</style>
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
					<li><a href=""><b>活動</b></a></li>
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

			<form action="/AwesomeProject/ControlServlet" method="POST">
				<label>搜尋課程ID:</label> <input type="text" name="P_ID"><input
					type="submit" name="findForUser" value="搜尋">
			</form>

			<%
			if (findByID != null) {
				
				String imgName = findByID.getP_Img().split("\\\\")[10];
				String productName = findByID.getP_Name();
			%>

			<div>
				<figcaption>
					<img src="product/File/<%=imgName%>" width="200px" height="200px">
					<br>
				</figcaption>
				<a href=""><%=productName%></a>
			</div>

			<%
			} else {

			for (int i = 0; i < list.size(); i++) {

				ProductBean p = list.get(i);
				String imgName = p.getP_Img().split("\\\\")[10];
				String productName = p.getP_Name();
			%>
			<div>
				<figcaption>
					<img src="product/File/<%=imgName%>" width="200px" height="200px">
					<br>
				</figcaption>
				<a href=""><%=productName%></a>
			</div>

			<%
			}
			}
			session.invalidate();
			%>
		</div>
		<!--end content-->
	</div>
	<!--end allpage-->

</body>
</html>