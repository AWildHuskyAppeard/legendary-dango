<%@page import="cart.CartControllerServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cart.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout Page</title>
</head>
<body>
<%  
	request.getSession(true);
	List<ProductBean> cart = (ArrayList<ProductBean>)(session.getAttribute("cart"));
	// 測試用
	if(cart == null || cart.size() == 0) 
	{
		cart = new ArrayList<ProductBean>();
		cart.add(CartControllerServlet.testBean1);
		cart.add(CartControllerServlet.testBean2);
		cart.add(CartControllerServlet.testBean3);
	}
%>

<%	
	session.setAttribute("cart", cart);
	if(cart == null) cart = new ArrayList<ProductBean>();
%>

	<h1>您欲購買的項目如下：</h1>
<!-- 1. 顯示當前購物車內容表格........................................ -->
	<form method="POST" action="/AwesomeProject/CartControllerServlet"> 
		<table>
			<thead>
				<tr>
				    <th>課程名稱(P_Name)</th>
				    <th>課程編號(P_ID)</th>
				    <th>課程價格(P_Price)</th>
				    <th>課程介紹(P_DESC))</th>
				    <th>課程老師(U_ID)</th>
				</tr>
			</thead>
			<tbody>
			<%! int totalPrice = 0; %>
			<% for(int i = 0; i < cart.size(); i++) {
			%>
			<% if(cart != null){ %>
			<tr>
				<td> <%= cart.get(i).getP_Name () %>   </td>
				<td> <%= cart.get(i).getP_ID   () %>   </td>
				<td> <%= cart.get(i).getP_Price() %>   </td>
				<td> <%= cart.get(i).getP_DESC () %>   </td>
				<td> <%= cart.get(i).getU_ID   () %>   </td>
				<% totalPrice += cart.get(i).getP_Price(); %>
			</tr>
			<% } %>
			<%} 
			%>
			</tbody>
		</table>
		<h1>總計：<%= totalPrice %></h1>
		<hr>
<!-- 2. 補充Order_Info所需要的所有資訊................................. -->
<!-- 缺O_ID，O_Amt，U_ID，U_FirstName，U_LastName，U_mail，O_Status，O_Date -->
		<input type="text">
		<h1>LULLL</h1>
		
		<hr>
<!-- 3. 按鈕導向各頁................................................... -->
		<button name="todo" value="back">回上一頁</button>
		<button name="todo" value="pay">確定結帳</button>
		<hr>
	</form>
	<script src="../assets/jquery-3.6.0.min.js"></script>
	<script>
		$(function(){





		})
	</script>
</body>
</html>