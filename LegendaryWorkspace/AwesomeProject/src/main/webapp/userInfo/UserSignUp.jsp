<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign up Page</title>
	<style>
        .UserSignUp_div_1{
            width: 400px;
            margin: auto;
            padding:20px 30px;
            box-shadow:3px 3px 12px lightgray;
            line-height:1.5;
        }
        .UserSignUp_div_1 td{
            line-height: 1.7;
        }
    </style>
</head>
<body>
	<div class="UserSignUp_div_1">
		<h2>註冊資料</h2>
		<form action="/AwesomeProject/UserServlet" method="POST">
			<table>
				<tr>
					<td>User ID:</td>
					<td><input type="text" name="u_ID" size="20" maxlength="20"
						autocomplete="off" required></td>
				</tr>
				<tr>
					<td>User Password:</td>
					<td><input type="password" name="u_Psw" size="20"
						maxlength="20" required></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><input type="date" name="u_BirthDay"></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="u_LastName" size="20"
						maxlength="20" required></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="u_FirstName" size="20"
						maxlength="20" required></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><input type="text" name="u_Email" size="20"
						maxlength="60" required></td>
				</tr>
				<tr>
					<td>Telephone:</td>
					<td><input type="text" name="u_Tel" size="20"
						maxlength="15"></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><label><input type="radio" name="u_Sex"
							value="male">man</label> <label><input type="radio"
							name="u_Sex" value="female">female</label></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" name="u_Address" size="20"
						maxlength="60"></td>
				</tr>
				<tr>
					<td><input type="reset"></td>
					<td><button type="submit" name="signUpButton" value="signUpButton">確認</td>
					<td><a href="/AwesomeProject/index_test.html" title="首頁">回首頁</a></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>