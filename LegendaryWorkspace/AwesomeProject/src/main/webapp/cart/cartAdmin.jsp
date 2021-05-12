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
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	</head>
	<body style="width: 100%;">
		<h1>管理者頁面</h1>
		<button id="newRow">添加空白訂單列</button>
		<form method="POST" action="/AwesomeProject/CartControllerServlet"> 
		<!-- 秀出所有Order_Info (希望之後能每20項分一頁) -->
			<table border="2px">
				<thead>
					<th>DELETE BUTTON</th>
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
				</thead>
				<tbody id="newRowsBelow">
					<% 
						ArrayList<OrderBean> adminBeans = new ArrayList();
						for(int i = 0; i < dataArrays.size(); i++) {
					%>
						<tr>
							<td><input name="ckbox" id="ckbox" type="checkbox" value="<%=dataArrays.get(i).get(0)/*有勾選的行數(0起算)*/%>"></td>
							<td style="background: aquamarine;"><input name="<%=i+"0"%>" type="text" value="<%=dataArrays.get(i).get(0)%>" readonly></td>
							<td><input required name="<%=i+"1"%>"  type="text" value="<%=dataArrays.get(i).get(1)%>" ></td>
							<td><input required name="<%=i+"2"%>"  type="text" value="<%=dataArrays.get(i).get(2)%>" ></td>
							<td><input required name="<%=i+"3"%>"  type="text" value="<%=dataArrays.get(i).get(3)%>" ></td>
							<td><input required name="<%=i+"4"%>"  type="text" value="<%=dataArrays.get(i).get(4)%>" ></td>
							<td><input required name="<%=i+"5"%>"  type="text" value="<%=dataArrays.get(i).get(5)%>" ></td>
							<td><input required name="<%=i+"6"%>"  type="text" value="<%=dataArrays.get(i).get(6)%>" ></td>
							<td><input required name="<%=i+"7"%>"  type="text" value="<%=dataArrays.get(i).get(7)%>" ></td>
							<td><input required name="<%=i+"8"%>"  type="text" value="<%=dataArrays.get(i).get(8)%>" ></td>
							<td><input required name="<%=i+"9"%>"  type="text" value="<%=dataArrays.get(i).get(9)%>" ></td>
							<td><input required name="<%=i+"10"%>" type="text" value="<%=dataArrays.get(i).get(10)%>"></td>
					<%
						}
					%>
						</tr>

				</tbody>
			</table>
			<hr>

			<button name="todo" id="insert" value="insertAdmin">新增</button>
			<button name="todo" id="delete" value="deleteAdmin" disabled>刪除</button>
			<button name="todo" id="update" value="updateAdmin">修改</button>
			<hr>
			
		</form>
		<form>
			<button formmethod="POST" formaction="../index_test.html">回首頁</button>
			<button formmethod="POST" formaction="../userInfo/test_GM_index.html">回GM首頁</button>
		</form>


		
		<script src="../assets/jquery-3.6.0.min.js"></script>
		<script>
			let counter = -1;
			$(function(){
				$('#newRow').on('click', function(){
					counter++;
					let content = `
					<tr style="background-color: yellow;">
						<td><button type='' id=''><i class="fas fa-trash-alt"></i></td>
							<td><input required type='text' name='new` + counter + `0'    ></td>
							<td><input required type='text' name='new` + counter + `1'    ></td>
							<td><input required type='text' name='new` + counter + `2'    ></td>
							<td><input required type='text' name='new` + counter + `3'    ></td>
							<td><input required type='text' name='new` + counter + `4'    ></td>
							<td><input required type='text' name='new` + counter + `5'    ></td>
							<td><input required type='text' name='new` + counter + `6'    ></td>
							<td><input required type='text' name='new` + counter + `7'    ></td>
							<td><input required type='text' name='new` + counter + `8'    ></td>
							<td><input required type='text' name='new` + counter + `9'     value=` /* + fs (有bug，無法正確新增)*/ + `></td>
							<td><input required type='text' name='new` + counter + `10'    value='1' readonly></td>
							</tr>
							`;
					$('#newRowsBelow').append(content);
				})
				$('input#ckbox').on('click', function(){
					let ckboxes = $('input#ckbox:checked');
					$('#delete').attr('disabled', true);
						if($(ckboxes).length == 0 || $(ckboxes).length == null) {
							console.log('(if)' + $(ckboxes).length);
						} else {
							$('#delete').attr('disabled', false);
							console.log('(else)' + $(ckboxes).length);							
						}
					
				})

			})
			// 以下只是自訂日期(為了smalldatetime)
			/*let d = new Date();
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
			let fs = formatted.toString(); */
			// -----------------------------------------------------------------
			</script>
</body>
</html>