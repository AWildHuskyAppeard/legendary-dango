<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:setDataSource var="ds" dataSource="jdbc/DBDB" />
<sql:query sql="select [U_ID] ,[U_Psw] ,[U_Birthday] ,[U_LastName] ,[U_FirstName] ,[U_Email] ,[U_Tel] ,[U_Sex] ,[U_Address] FROM User_Info" var="rs" dataSource="${ds}" />
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
<title>查詢會員</title>
</head>
<body>
    <center>

            <a href="/AwesomeProject/userInfo/test_GM_UserFunction.jsp">回到單筆查詢</a>
            <a href="/AwesomeProject/userInfo/test_GM_index.html">管理員首頁</a>
            <br>
            <br>
        </form>


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
			<c:forEach var="row" items="${rs.rows}">
				<tr>
					<td>${row.U_ID}</td>
					<td>${row.U_LastName}</td>
					<td>${row.U_FirstName}</td>
					<td>${row.U_Birthday}</td>
					<td>${row.U_Email}</td>
					<td>${row.U_Tel}</td>
					<td>${row.U_Sex}</td>
					<td>${row.U_Address}</td>
				</tr>
			</c:forEach>

		</table>

	</center>
</body>
</html>