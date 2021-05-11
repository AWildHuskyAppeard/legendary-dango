<%@page import="cart.*"%>
<%@page import="java.util.*"%>
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
<jsp:useBean id="addedProduct" scope="session" class="cart.ProductBean" type="cart.ProductBean" />
<%  
	request.getSession(true);
	List<ProductBean> cart = (ArrayList<ProductBean>)(session.getAttribute("cart"));
	// 測試用。cart如果是空的，會自動補3件下列商品作為測試
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

<h1>您的購物車內有：</h1>
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
				    <th>Delete buttons</th>
				</tr>
			</thead>
			<tbody>
			<% for(int i = 0; i < cart.size(); i++) {
			%>
			<% if(cart != null){ %>
			<tr>
				<td> <%= cart.get(i).getP_Name () %>   </td>
				<td> <%= cart.get(i).getP_ID   () %>   </td>
				<td> <%= cart.get(i).getP_Price() %>   </td>
				<td> <%= cart.get(i).getP_DESC () %>   </td>
				<td> <%= cart.get(i).getU_ID   () %>   </td>
				<!--  <td><input type="checkbox" name="checkRemove"></td>-->
				<td><input type="checkbox" name="ckbox" value="<%=i%>">取消</td>
			</tr>
			<% } %>
			<%} 
			%>
			</tbody>	
		
		
		</table>

		<hr>
<!-- 2. 按鈕導向各頁 -->
		<button name="todo" value="remove">移除</button>
		<button name="todo" value="checkout">去結帳</button>
		<hr>
	</form>
	<form method="POST" action="/AwesomeProject/index_test.html">
		<button name="" value="">回首頁</button>
	</form>
</body>
</html>