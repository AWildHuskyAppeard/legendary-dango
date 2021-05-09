<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanks Page</title>
</head>
	<body>
		<h1>Thank you for registration!</h1>
		<form action="/AwesomeProject/UserServlet" method="POST">
			<!--<button type="submit" name="thankPageButton" value="thankPageButton">回登入頁面</button>-->
			<!-- 打完整路徑 -->
			<a href="/AwesomeProject/userInfo/UserLogin.jsp" title="返回登入">返回登入頁面</a>
		</form>
	</body>
</html>