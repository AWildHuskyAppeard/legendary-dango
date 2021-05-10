<%@page import="userInfo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",-1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢單筆會員資料</title>
</head>
<body>
	<center>
		<form action="/AwesomeProject/UserServlet" method="POST">
			<a href="/AwesomeProject/userInfo/test_GM_UserFunction.jsp">回到單筆查詢</a>
			<a href="/AwesomeProject/userInfo/test_GM_index.html">管理員首頁</a> <br>
			<br>
		<jsp:useBean id="findResult" class="userInfo.UserBean" scope="session" />

		<h2>查詢結果</h2>
		<table border="1">
			<th>User_ID</th>
			<th>Last Name</th>
			<th>First Name</th>
			<th>Birthday</th>
			<th>Telephone</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Address</th>
			<th style="color: red;">DELETE USER</th>
			<tr>
				<td><jsp:getProperty name="findResult" property="u_ID" /></td>
				<td><jsp:getProperty name="findResult" property="u_LastName" /></td>
				<td><jsp:getProperty name="findResult" property="u_FirstName" /></td>
				<td><jsp:getProperty name="findResult" property="u_BirthDay" /></td>
				<td><jsp:getProperty name="findResult" property="u_Tel" /></td>
				<td><jsp:getProperty name="findResult" property="u_Email" /></td>
				<td><jsp:getProperty name="findResult" property="u_Sex" /></td>
				<td><jsp:getProperty name="findResult" property="u_Address" /></td>
				<td style="text-align: center;"><input type="text" name="u_ID" size="3"
				 placeholder="user id.." style="margin: 4px 5px;"><button type="submit" 
				 name="deleteUser">確認刪除</button></td>
			</tr>
		</table>
		<h5 style="color: red; font-style: italic;">請在文字框輸入欲刪除的USER ID</h5>
		</form>
	</center>
</body>
</html>