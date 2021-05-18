<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="cart.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Index Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/AwesomeProject/assets/css/main.css" />
<noscript><link rel="stylesheet" href="/AwesomeProject/assets/css/noscript.css" /></noscript>
</head>
<body class="is-preload">
<!-- *********************************************************** -->
<jsp:useBean id="addedProduct" scope="session" class="cart.ProductBean" type="cart.ProductBean" />
<%  
	request.getSession(true);
	List<ProductBean> cart = (ArrayList<ProductBean>)(session.getAttribute("cart"));
	// 測試用。cart如果是空的，會自動補3件下列商品作為測試
	if(cart == null || cart.size() == 0) 
	{
%>
		<h1 style='background-color: aquamarine; font-family: 
		Comic Sans MS ;font-size: 200%'>※購物車沒有任何東西，因此管理員塞了三個課程進來✌💀✌</h1>
<%
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
<!-- *********************************************************** -->
	<!-- Wrapper -->
	<div id="wrapper">
	
	<!-- include header進來 -->
	<jsp:include page="/test_header.jsp" />
	
		<!-- Main -->
		<div id="main" class="alt">

			<!-- One -->
			<section id="one">
				<div class="inner">
				<!-- <div class="form-check">-->
					<header class="major">
						<!-- <h1>功能(標題)</h1> -->
						<h1>您的購物車內有：</h1>
					</header>
					<!-- <span class="image main"><img src="images/pic11.jpg" alt="" /></span> -->
					<h3>HEADER 3,</h3>
					<p>PARAGRAPH.</p>
					<!-- ************************************************************************ -->
					
					<h1></h1>
					<!-- 1. 顯示當前購物車內容表格 -->
						<form method="POST" action="/AwesomeProject/CartControllerServlet"> 
							<table>
								<thead>
									<tr>
									    <th>移除</th>
									    <th>課程名稱(P_Name)</th>
									    <th>課程編號(P_ID)</th>
									    <th>課程價格(P_Price)</th>
									    <th>課程介紹(P_DESC))</th>
									    <th>課程老師(U_ID)</th>
									</tr>
								</thead>
								<tbody>
								<% for(int i = 0; i < cart.size(); i++) {
								%>
								<% if(cart != null){ %>
									<tr>
									<td>
									<div>
										<input class="form-check-input" type="checkbox" name="ckbox" value="<%=i%>" id="ckbox flexCheckDefault">
									    <label class="form-check-label" for="flexCheckDefault">
											取消
										</label>
									</div>
									</td>
									<td> <%= cart.get(i).getP_Name () %>   </td>
									<td> <%= cart.get(i).getP_ID   () %>   </td>
									<td> <%= cart.get(i).getP_Price() %>   </td>
									<td> <%= cart.get(i).getP_DESC () %>   </td>
									<td> <%= cart.get(i).getU_ID   () %>   </td>
								</tr>
								<% } %>
								<%} 
								%>
								</tbody>
							</table>
					
							<hr>
					
					<!-- 2. 按鈕導向各頁 -->
					<button name="todo" value="remove" id="delete" disabled>移除</button>
					<button name="todo" value="checkout" id="checkout">去結帳</button>
					<hr>
					</form>
					<form method="POST" action="/AwesomeProject/index_test.html">
						<button name="" value="">回首頁</button>
					</form>

					<!-- ************************************************************************ -->
					
				</div>
			</section>

		</div>

		<!-- Contact -->

		<!-- Footer -->
		<!-- include footer進來 -->
	<jsp:include page="/test_footer.jsp"/>

	</div>

	<!-- Scripts -->
	<script src="/AwesomeProject/assets/jquery-3.6.0.min.js"></script>
	<script src="/AwesomeProject/assets/js/jquery.scrolly.min.js"></script>
	<script src="/AwesomeProject/assets/js/jquery.scrollex.min.js"></script>
	<script src="/AwesomeProject/assets/js/browser.min.js"></script>
	<script src="/AwesomeProject/assets/js/breakpoints.min.js"></script>
	<script src="/AwesomeProject/assets/js/util.js"></script>
	<script src="/AwesomeProject/assets/js/main.js"></script>
	<!-- ************************************************************ -->

		<script>
			$(function() {
				$('input#ckbox').on('click', function() {
						let ckboxes = $('input#ckbox:checked');
						$('#delete').attr('disabled', true);
							if($(ckboxes).length == 0 || $(ckboxes).length == null) {
							} else {
								$('#delete').attr('disabled', false);			
							}
					})
			})
		</script>
	
	<!-- ************************************************************ -->
</body>
</html>