<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Page</title>
<style>
/*
body{
width:500px;
margin:auto;
}*/
	.UserConfirm_div_1{
		width: 350px;
        margin: auto;
        box-shadow:3px 3px 12px lightgray;
        line-height:1.5;
        padding:10px;
	}
</style>
</head>
<body>
	<div class="UserConfirm_div_1">
		<h2>確認註冊資料</h2>
		<form action="./UserServlet" method="Get">
			<tr>
			<td><b>User ID: </b></td>
			<td>${param.u_ID }</td>
			</tr><br>
			
			<tr>
			<td><b>Birthday: </b></td>
			<td>${param.u_BirthDay }</td>
			</tr><br>
			
			<tr>
			<td><b>Last Name: </b></td>
			<td>${param.u_LastName }</td>
			</tr><br>
			
			<tr>
			<td><b>First Name: </b></td>
			<td>${param.u_FirstName }</td>
			</tr><br>
			
			<tr>
			<td><b>E-mail: </b></td>
			<td>${param.u_Email }</td>
			</tr><br>
			
			<tr>
			<td><b>Telephone: </b></td>
			<td>${param.u_Tel }</td>
			</tr><br>
			
			<tr>
			<td><b>Gender: </b></td>
			<td>${param.u_Sex }</td>
			</tr><br>
			
			<tr>
			<td><b>Address: </b></td>
			<td>${param.u_Address }</td>
			</tr><br>
				<!-- <li><b>User ID: </b>${param.id }</li>
				<li><b>Birthday: </b>${param.birthDay }</li>
				<li><b>Last Name: </b>${param.lastName }</li>
				<li><b>First Name: </b>${param.firstName }</li>
				<li><b>E-mail: </b>${param.email }</li>
				<li><b>Telephone: </b>${param.telephone }</li>
				<li><b>Gender: </b>${param.gender }</li>
				<li><b>Address: </b>${param.address }</li> -->
			
			<button type="submit" name="confirmButton" value="confirm">確認</button>
		</form>
	</div>
</body>
</html>