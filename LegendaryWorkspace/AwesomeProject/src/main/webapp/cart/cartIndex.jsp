<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Index Page</title>
<link rel="stylesheet" href="/AwesomeProject/assets/cartIndex.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</head>
<body>
<!-- 1. 顯示當前購物車內容表格 -->
	<form method="POST" action="/AwesomeProject/CartControllerServlet"> 
		<table>
			<tr>
			    <th>C1</th>
			    <th>C2</th>
			    <th>C3</th>
			    <th>C4</th>
			    <th>C5</th>
			    <th>C6 Delete checkboxes</th>
			</tr>
			
			<tr>
			    <td>11</td>
			    <td>22</td>
			    <td>33</td>
			    <td>44</td>
			    <td>55</td>
			    <td>66<input type="checkbox" name="checkRemove"></td>
			    <td>66<input type="checkbox" name="checkRemove"></td>
			    <td>66<input type="checkbox" name="checkRemove"></td>
			</tr>
		
		
		</table>

		<hr>
<!-- 2. 按鈕導向各頁 -->
		<button name="todo" value="remove">移除</button>
		<button name="todo" value="checkout">結帳</button>
		<button name="" value="">回首頁</button>
	</form>
</body>
</html>