<%@page import="java.util.ArrayList"%>
<%@page import="cart.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Index Page</title>
<link rel="stylesheet" href="/AwesomeProject/assets/cartIndex.css">
</head>
<body>
<jsp:useBean id="addedProduct" scope="session" class="cart.ProductBean" />
<% List<ProductBean> cart = (ArrayList<ProductBean>)(session.getAttribute("cart")); 
	int itemQty = cart.size();
%>
<!-- 1. 顯示當前購物車內容表格 -->
	<form method="POST" action="/AwesomeProject/CartControllerServlet"> 
		<table>
			<thead>
				<tr>
				    <th>課程名稱(P_Name)</th>
				    <th>課程編號(P_ID)</th>
				    <th>課程價格(P_Price)</th>
				    <th>課程介紹(P_DESC))</th>
				    <th>課程老師(U_ID)</th>
				    <th>Delete checkboxes</th>
				</tr>
			</thead>
			<tbody>
			<% for(int i = 0; i < itemQty; i++) {
			%>
			<tr>
				<td> <%= cart.get(i).getP_Name() %> </td>
				<td> <%= cart.get(i).getP_ID() %>   </td>
				<td> <%= cart.get(i).getP_Price() %></td>
				<td> <%= cart.get(i).getP_DESC() %> </td>
				<td> <%= cart.get(i).getU_ID() %>   </td>
				<td><input type="checkbox" name="checkRemove"></td>
			</tr>
			<%} 
			%>
			</tbody>	
		
		
		</table>

		<hr>
<!-- 2. 按鈕導向各頁 -->
		<button name="todo" value="remove">移除</button>
		<button name="todo" value="checkout">結帳</button>
		<button name="" value="">回首頁</button>
		<input type="checkbox" name="checkRemove">
		<input type="checkbox" name="checkRemove">
		<input type="checkbox" name="checkRemove">
	</form>
</body>
</html>