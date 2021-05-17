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
<title>Login Check Page</title>
</head>
<body>
	<%
		if (session.getAttribute("userData") == null) {
	%>
		<script>
			alert("您還沒有登入, 請登入...");
			top.location.href = "/AwesomeProject/userInfo/UserLogin.jsp";
		</script>

	<%
		}
	%>
</body>
</html>