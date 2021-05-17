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
<title>功能(首頁名稱)</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/AwesomeProject/assets/css/main.css" />
<noscript><link rel="stylesheet" href="/AwesomeProject/assets/css/noscript.css" /></noscript>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">
	
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

		<!-- Main -->
		<div id="main" class="alt">

			<!-- One -->
			<section id="one">
				<div class="inner">
					<header class="major">
						<h1>功能(標題)</h1>
					</header>
					<!-- <span class="image main"><img src="images/pic11.jpg" alt="" /></span> -->
					<h3>HEADER 3,</h3>
					<p>PARAGRAPH.</p>
					<form action="/AwesomeProject/UserServlet" method="POST">
						<button type="submit" name="modifyUserInfo">BUTTON</button>
					</form>
				</div>
			</section>

		</div>

		<!-- Contact -->
		<!-- 這邊以下之後再修改 -->
		<section id="contact">
			<div class="inner">
				<section>
					<form method="post" action="#">
						<div class="fields">
							<div class="field half">
								<label for="name">Name</label> <input type="text" name="name"
									id="name" />
							</div>
							<div class="field half">
								<label for="email">Email</label> <input type="text" name="email"
									id="email" />
							</div>
							<div class="field">
								<label for="message">Message</label>
								<textarea name="message" id="message" rows="6"></textarea>
							</div>
						</div>
						<ul class="actions">
							<li><input type="submit" value="Send Message"
								class="primary" /></li>
							<li><input type="reset" value="Clear" /></li>
						</ul>
					</form>
				</section>
				<section class="split">
					<section>
						<div class="contact-method">
							<span class="icon solid alt fa-envelope"></span>
							<h3>Email</h3>
							<a href="#">information@untitled.tld</a>
						</div>
					</section>
					<section>
						<div class="contact-method">
							<span class="icon solid alt fa-phone"></span>
							<h3>Phone</h3>
							<span>(000) 000-0000 x12387</span>
						</div>
					</section>
					<section>
						<div class="contact-method">
							<span class="icon solid alt fa-home"></span>
							<h3>Address</h3>
							<span>1234 Somewhere Road #5432<br /> Nashville, TN 00000<br />
								United States of America
							</span>
						</div>
					</section>
				</section>
			</div>
		</section>

		<!-- Footer -->
		<footer id="footer">
			<div class="inner">
				<ul class="icons">
					<li><a href="#" class="icon brands alt fa-twitter"><span
							class="label">Twitter</span></a></li>
					<li><a href="#" class="icon brands alt fa-facebook-f"><span
							class="label">Facebook</span></a></li>
					<li><a href="#" class="icon brands alt fa-instagram"><span
							class="label">Instagram</span></a></li>
					<li><a href="#" class="icon brands alt fa-github"><span
							class="label">GitHub</span></a></li>
					<li><a href="#" class="icon brands alt fa-linkedin-in"><span
							class="label">LinkedIn</span></a></li>
				</ul>
				<ul class="copyright">
					<li>&copy; Untitled</li>
					<!-- <li>Design: <a href="https://html5up.net">HTML5 UP</a></li> -->
				</ul>
			</div>
		</footer>

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