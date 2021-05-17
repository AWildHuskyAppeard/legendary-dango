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
<title>User Login</title>
</head>
<body>
<%
	UserBean userBean = (UserBean)request.getSession().getAttribute("userData");
	String userID = userBean.getU_ID();
	String userPsw = userBean.getU_Psw();
%>
	<script>
		alert("歡迎回來!");
		top.location.href = "/AwesomeProject/index_test.html";
	</script>

</body>
</html>