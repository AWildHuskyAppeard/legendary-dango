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
<title>GM Login Page</title>
	<style>
        #UserLogin_div_1{
            width: 300px;
            margin: auto;
            box-shadow:3px 3px 12px darkgray;
            padding:20px;
            text-align:center;
        }
        #Login_div_2{
            padding-top: 10px;
        }
        #Login_div_3{
            margin: 10px 0;
            width: 65px;
        }
        .Admin_body{
        	background-color: #FFFFB9;
        }
    </style>
</head>
<body class="Admin_body">
	<div id="UserLogin_div_1">
		<form action="/AwesomeProject/UserServlet" method="Get">
			
			
					Admin ID:<br>
					<input type="text" name="admin_ID" size="20" maxlength="20"
						autocomplete="off" required><br><br>
				
				
					Password:<br>
					<input type="password" name="admin_Psw" size="20"
						maxlength="20" required><br>
            <div id="Login_div_2">
                <input id="Login_div_3" type="submit" value="Login" name="adminLogin"><br/>
            </div>
		</form>
	</div>
</body>
</html>