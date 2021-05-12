<%@page import="product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>課程管理</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/AwesomeProject/userInfo/test_GM_index.css">
<%
ArrayList<ProductBean> list = (ArrayList<ProductBean>) session.getAttribute("list");
ProductBean findByID = (ProductBean) session.getAttribute("find");
%>
</head>
<style>
th {
	border: 1px solid black;
	width: 70px;
}

tr {
	width: 100px;
}

form {
	display: inline-block;
}
</style>
<body>


	<div class="allpage">
		<header>
			<center>
				<h1 class="header_h1">管理系統</h1>
			</center>
			<!-- <img class="logo-img" src="../images/logo.jpg" title="logo" alt="logo"> -->
			<nav>
				<ul class="menu">
					<li><a href="/AwesomeProject/index_test.html"><b>使用者首頁</b></a></li>
					<li><a href="/AwesomeProject/ControlServlet?findAll"><b>課程</b></a></li>
					<li><a href=""><b>討論區</b></a></li>
					<li><a href=""><b>測驗區</b></a></li>
					<li><a href=""><b>活動</b></a></li>
					<li style="float: right;"><a
						href="/AwesomeProject/userInfo/AdminLogin.jsp"><b>GM系統</b></a></li>
					<li style="float: right;"><a
						href="/AwesomeProject/userInfo/test_GM_index.html"><b>管理者首頁</b></a></li>
				</ul>
			</nav>
		</header>
		<div class="content">
			
			<form action="/AwesomeProject/ControlServlet" method="POST">
				<label>搜尋全部課程:</label> <input type="submit" name="findAll"
					value="搜尋全部"> <label>搜尋課程ID:</label> <input type="text"
					name="P_ID"><input type="submit" name="findByID" value="搜尋">
			</form>
			<form action="/AwesomeProject/ControlServlet" method="POST">
				<label>刪除課程ID:</label> <input type="text" name="P_ID"><input
					type="submit" name="deleteProduct" value="刪除">
			</form>

			<a href="/AwesomeProject/product/insert.jsp">新增課程/更新課程</a>


			<h2>課程列表</h2>
			<table align="center" border="1">
				<tr>
					<th>課程ID</th>
					<th>課程名稱</th>
					<th>課程分類</th>
					<th>課程敘述</th>
					<th>課程價錢</th>
					<th>課程圖片</th>
					<th>課程影片</th>
					<th>授課者ID</th>
				</tr>
				<%
				if (findByID != null) {
				%>
				<tr>
					<th><%=findByID.getP_ID()%></th>
					<th><%=findByID.getP_Name()%></th>
					<th><%=findByID.getP_Class()%></th>
					<th><%=findByID.getP_DESC()%></th>
					<th><%=findByID.getP_Price()%></th>
					<th><%=findByID.getP_Img()%></th>
					<th><%=findByID.getP_Video()%></th>
					<th><%=findByID.getU_ID()%></th>
				</tr>
				<%
				} else {
				for (int i = 0; i < list.size(); i++) {

					ProductBean p = list.get(i);
				%>
				<tr>
					<th><%=p.getP_ID()%></th>
					<th><%=p.getP_Name()%></th>
					<th><%=p.getP_Class()%></th>
					<th><%=p.getP_DESC()%></th>
					<th><%=p.getP_Price()%></th>
					<th><%=p.getP_Img()%></th>
					<th><%=p.getP_Video()%></th>
					<th><%=p.getU_ID()%></th>
				</tr>
				<%
				}
				}
				session.invalidate();
				%>
			</table>
	
		</div>
		<!--end content-->
	</div>
	<!--end allpage-->


</body>
</html>