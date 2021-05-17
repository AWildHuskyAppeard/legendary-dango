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
						<h1>功能(標題)</h1>
					</header>
					<!-- <span class="image main"><img src="images/pic11.jpg" alt="" /></span> -->
					<h3>抓帳號 (id),</h3>
					<p>PARAGRAPH.</p>
					<form action="/AwesomeProject/UserServlet" method="POST">
						<button type="submit" name="modifyUserInfo">修改</button>
					</form>
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