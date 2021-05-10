<%@page import="cart.OrderBean"%>
<%@page import="javax.naming.*"%>
<%@page import="java.util.*"%>
<%@page import="cart.CartDAOImpl"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%!	private DataSource ds;
		private HttpSession session;
		private InitialContext ctx;
		private Connection conn = null;
		private ArrayList<ArrayList<String>> dataArrays = null;%>    
<%
try 
{
	if (this.ds == null) 
	{	
		ctx = new InitialContext();
		// 改資料庫名稱
		this.ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/DBDB");
	}
	this.conn = this.ds.getConnection();
} catch (NamingException e) 
{
	e.printStackTrace();
} catch (SQLException e) 
{
	e.printStackTrace();
} 
CartDAOImpl dao = new CartDAOImpl(conn);
dao.selectAllOrder();
dataArrays = CartDAOImpl.dataArrays;
%>
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
		<button id="newRow">添加空白訂單列</button>
		<form method="POST" action="/AwesomeProject/CartControllerServlet"> 
		<!-- 秀出所有Order_Info + 每20項分一頁 -->
			<table border="1">
				<thead>
					<th style="background: aquamarine;">Order ID<br>(READ-ONLY)</th>
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
				<tbody id="newRowsBelow">
					<% 
						ArrayList<OrderBean> adminBeans = new ArrayList();
						for(int i = 0; i < dataArrays.size(); i++) {
					%>
						<tr>
							<td style="background: aquamarine;"><input name="<%=i+"0"%>" type="text" value="<%=dataArrays.get(i).get(0)%>" readonly></td>
							<td><input name="<%=i+"1"%>" type="text" value="<%=dataArrays.get(i).get(1)%>"></td>
							<td><input name="<%=i+"2"%>" type="text" value="<%=dataArrays.get(i).get(2)%>"></td>
							<td><input name="<%=i+"3"%>" type="text" value="<%=dataArrays.get(i).get(3)%>"></td>
							<td><input name="<%=i+"4"%>" type="text" value="<%=dataArrays.get(i).get(4)%>"></td>
							<td><input name="<%=i+"5"%>" type="text" value="<%=dataArrays.get(i).get(5)%>"></td>
							<td><input name="<%=i+"6"%>" type="text" value="<%=dataArrays.get(i).get(6)%>"></td>
							<td><input name="<%=i+"7"%>" type="text" value="<%=dataArrays.get(i).get(7)%>"></td>
							<td><input name="<%=i+"8"%>" type="text" value="<%=dataArrays.get(i).get(8)%>"></td>
							<td><input name="<%=i+"9"%>" type="text" value="<%=dataArrays.get(i).get(9)%>"></td>
							<td><input name="<%=i+"10"%>" type="text" value="<%=dataArrays.get(i).get(10)%>"></td>
							<td><input name="" type="radio"></td>
					<%
						}
					%>
						</tr>
						<hr>

				</tbody>
			</table>
			<input id="counter" name="counter" value="" readonly>
			<hr>

			<button name="todo" value="insertAdmin">新增</button>
			<button name="todo" value="deleteAdmin">刪除</button>
			<button name="todo" value="updateAdmin">修改</button>
			
			<hr>
			<hr>
		</form>
		
		<script src="../assets/jquery-3.6.0.min.js"></script>
		<script>
			$(function(){
				let counter = -1;
				$('#newRow').on('click', function(){
					counter++;
					$('#counter').text(counter);
					$('#newRowsBelow').append(
						`
						<tr>
							<td><input type="text" name="n${counter}0"></td>
							<td><input type="text" name="n${counter}1"></td>
							<td><input type="text" name="n${counter}2"></td>
							<td><input type="text" name="n${counter}3"></td>
							<td><input type="text" name="n${counter}4"></td>
							<td><input type="text" name="n${counter}5"></td>
							<td><input type="text" name="n${counter}6"></td>
							<td><input type="text" name="n${counter}7"></td>
							<td><input type="text" name="n${counter}8"></td>
							<td><input type="text" name="n${counter}9"></td>
							<td><input type="text" name="n${counter}10"></td>
							<td><input name="" type="radio"></td>
						</tr>
						`
					)

				})


			})
		</script>
</body>
</html>