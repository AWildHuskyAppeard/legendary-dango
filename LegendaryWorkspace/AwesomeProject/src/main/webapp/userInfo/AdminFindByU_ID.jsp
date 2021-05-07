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

            <a href="/AwesomeProject/userInfo/test_GM_UserFunction.jsp">回到單筆查詢</a>
            <a href="/AwesomeProject/userInfo/test_GM_index.html">管理員首頁</a>
            <br>
            <br>
        </form>

		<%
		UserBean ub = (UserBean)session.getAttribute("findResult");
		String U_ID = String.valueOf(ub.getU_ID());
		String U_LastName = String.valueOf(ub.getU_LastName());
		String U_FirstName = String.valueOf(ub.getU_FirstName());
		String U_Birthday = String.valueOf(ub.getU_BirthDay());
		String U_Email = String.valueOf(ub.getU_Email());
		String U_Tel = String.valueOf(ub.getU_Tel());
		String U_Sex = String.valueOf(ub.getU_Sex());
		String U_Address = String.valueOf(ub.getU_Address());
		%>
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
				<tr>
					<td><%= U_ID %></td>
					<td><%= U_LastName %></td>
					<td><%= U_FirstName %></td>
					<td><%= U_Birthday %></td>
					<td><%= U_Email %></td>
					<td><%= U_Tel %></td>
					<td><%= U_Sex %></td>
					<td><%= U_Address %></td>
				</tr>

		</table>

	</center>
</body>
</html>