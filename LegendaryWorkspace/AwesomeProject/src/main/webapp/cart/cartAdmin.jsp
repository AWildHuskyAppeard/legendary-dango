<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<sql:setDataSource var="ds" dataSource="jdbc/DBDB" />
<sql:query sql="select * FROM [Order_Info]" var="rs" dataSource="${ds}" />    
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
<meta charset="UTF-8">
<title>Cart Administrator Page</title>
</head>
<body>
	<!-- 秀出所有Order_Info + 每20項分一頁 -->
		<table border="1">
			<thead>
				<th>Order ID</th>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>User ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>E-mail</th>
				<th>Order Status</th>
				<th>Order Date</th>
				<th>Order Amount</th>
				<th>DELETE BUTTON</th>
			</thead>
			<tbody>
				<c:forEach var="row" items="${rs.rows}">
					<tr>
						<td><input type="text" name="" id="">${row.O_ID}</td>
						<td><input type="text" name="" id="">${row.P_ID}</td>
						<td><input type="text" name="" id="">${row.P_Name}</td>
						<td><input type="text" name="" id="">${row.P_Price}</td>
						<td><input type="text" name="" id="">${row.U_ID}</td>
						<td><input type="text" name="" id="">${row.U_FirstName}</td>
						<td><input type="text" name="" id="">${row.U_LastName}</td>
						<td><input type="text" name="" id="">${row.U_Email}</td>
						<td><input type="text" name="" id="">${row.O_Status}</td>
						<td><input type="text" name="" id="">${row.O_Date}</td>
						<td><input type="text" name="" id="">${row.O_Amt}</td>
						<td><input type="radio"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
        <hr>

        <button name="" value="">修改</button>
        <button name="" value="">刪除</button>
        <button name="" value="">新增</button>

        <hr>
        
	<form>
        
	
	<hr>
	
	
	</form>
	
	

</body>
</html>