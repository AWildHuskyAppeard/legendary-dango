<%@page import="cart.*"%>
<%@page import="javax.naming.*"%>
<%@page import="java.util.*"%>
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
	<body style="width: 100%;">
		<h1>管理者頁面</h1>
		<button id="newRow">添加空白訂單列</button>
		<form method="POST" action="/AwesomeProject/CartControllerServlet"> 
		<!-- 秀出所有Order_Info (希望之後能每20項分一頁) -->
			<table border="2px">
				<thead>
					<th style="background: aquamarine;" >Order ID<br>(READ-ONLY)</th>
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
							<td><input name="<%=i+"1"%>"  type="text" value="<%=dataArrays.get(i).get(1)%>" ></td>
							<td><input name="<%=i+"2"%>"  type="text" value="<%=dataArrays.get(i).get(2)%>" ></td>
							<td><input name="<%=i+"3"%>"  type="text" value="<%=dataArrays.get(i).get(3)%>" ></td>
							<td><input name="<%=i+"4"%>"  type="text" value="<%=dataArrays.get(i).get(4)%>" ></td>
							<td><input name="<%=i+"5"%>"  type="text" value="<%=dataArrays.get(i).get(5)%>" ></td>
							<td><input name="<%=i+"6"%>"  type="text" value="<%=dataArrays.get(i).get(6)%>" ></td>
							<td><input name="<%=i+"7"%>"  type="text" value="<%=dataArrays.get(i).get(7)%>" ></td>
							<td><input name="<%=i+"8"%>"  type="text" value="<%=dataArrays.get(i).get(8)%>" ></td>
							<td><input name="<%=i+"9"%>"  type="text" value="<%=dataArrays.get(i).get(9)%>" ></td>
							<td><input name="<%=i+"10"%>" type="text" value="<%=dataArrays.get(i).get(10)%>"></td>
							<td><input name="ckbox" type="checkbox" value="<%=dataArrays.get(i).get(0)/*該行O_ID值*/%>"></td>
					<%
						}
					%>
						</tr>

				</tbody>
			</table>
			<hr>
			<input id="counter" name="counter" value="" readonly>
			<hr>

			<button name="todo" value="insertAdmin">新增</button>
			<button name="todo" value="deleteAdmin">刪除</button>
			<button name="todo" value="updateAdmin">修改</button>
			
			<hr>
			
		</form>
		
		<a href="../index_test.html">回首頁</a>
		
		<script src="../assets/jquery-3.6.0.min.js"></script>
		<script>
			let counter = 0;
			$(function(){
				// 以下只是自訂日期(為了smalldatetime)
				let d = new Date();
				let year = d.getFullYear(); // 
				console.log("year = " + year);
				let date = d.getDate(); // 
				let monthIndex = d.getMonth();
				let months = {
						0: 　'01',
						1: 　'02',
						2: 　'03',
						3: 　'04',
						4: 　'05',
						5: 　'06',
						6: 　'07',
						7: 　'08',
						8: 　'09',
						9: 　'10',
						10:　'11',
						11:　'12'
				};
				let month = months[monthIndex];
				let hour = d.getHours();
				let minute = d.getMinutes();
				let second = d.getSeconds().toString();
				if(second < 10){
					second = '0' + second
				};
				if(minute < 10) {
					minute = '0' + minute
				};
				if(hour < 10) {
					hour = '0' + hour
				}
				
				let formatted = year + '-' + month + '-' + 
				date + '&nbsp;' + hour + ':' + 
				minute + ':' + second + '.0';
				let fs = formatted.toString();
				// -----------------------------------------------------------------
				$('#newRow').on('click', function(){
					counter++;
					$('#counter').attr('value', counter);
					let bla = counter - 1;
					let content = `
						<tr>
							<td><input type='text' name='new` + bla + `0'></td>
							<td><input type='text' name='new` + bla + `1'></td>
							<td><input type='text' name='new` + bla + `2'></td>
							<td><input type='text' name='new` + bla + `3'></td>
							<td><input type='text' name='new` + bla + `4'></td>
							<td><input type='text' name='new` + bla + `5'></td>
							<td><input type='text' name='new` + bla + `6'></td>
							<td><input type='text' name='new` + bla + `7'></td>
							<td><input type='text' name='new` + bla + `8'></td>
							<td><input type='text' name='new` + bla + `9' value=` /* + fs (有bug，無法正確新增)*/ + `></td>
							<td><input type='text' name='new` + bla + `10' value='1' readonly></td>
							<td></td>
						</tr>
						`;
					$('#newRowsBelow').append(content)
				})
			})
		</script>
</body>
</html>