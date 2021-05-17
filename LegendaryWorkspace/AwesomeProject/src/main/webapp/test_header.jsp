<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

		<!-- Header -->
		<header id="header">
			<a href="/AwesomeProject/index_test.html" class="logo"><strong>首頁</strong></a>
			<nav>
				<a href="#menu">Menu</a>
			</nav>
		</header>

		<!-- Menu -->
		<nav id="menu">
			<ul class="links">
			<li><a href="/AwesomeProject/userInfo/test_UserUpdate.jsp">會員資料</a></li>
				<li><a href="/AwesomeProject/ControlServlet?findAllToUser">課程</a></li>
				<li><a href="/AwesomeProject/cart/cartIndex.jsp">購物車</a></li>
				<li><a href="/AwesomeProject/event/NewFile.jsp">活動</a></li>
				<li><a href="/AwesomeProject/question/QuesFormDS.jsp">測驗區</a></li>
				<li><a href="/AwesomeProject/chat/Chat.html">討論區</a></li>
				<!-- <li><a href="/AwesomeProject/userInfo/AdminLogin.jsp">GM Page</a></li> -->
			</ul>
			<ul class="actions stacked">
				<li><a href="/AwesomeProject/userInfo/AdminLogin.jsp"
					class="button primary fit">管理員頁面</a></li>
			</ul>
			<form action="logout servlet(還沒用)" method="POST">
				<!-- <li><a href="#" class="button fit">登出</a></li> -->
				<button class="button fit" type="submit" name="logout">登出</button>
			</form>
		</nav>