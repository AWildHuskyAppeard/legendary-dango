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
<title>Login Page</title>
	<style>
        #UserLogin_div_1{
            width: 300px;
            margin: auto;
            box-shadow:3px 3px 12px lightgray;
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
    </style>
</head>
<body>
	<div id="UserLogin_div_1">
		<form action="/AwesomeProject/UserServlet" method="Get">
			
			
					User ID:<br>
					<input type="text" name="u_ID" size="20" maxlength="20"
						autocomplete="off"><br><br>
				
				
					User Password:<br>
					<input type="password" name="u_Psw" size="20"
						maxlength="20"><br>
            <div id="Login_div_2">
                <input id="Login_div_3" type="submit" value="Login" name="login"><br>
                <!--<button id="Login_div_3" type="submit" value="signUp" name="signUp">Sign Up</button>-->
                <a id="Login_div_3" href="/AwesomeProject/userInfo/UserSignUp.jsp" title="註冊">註冊</a>
                <a href="/AwesomeProject/userInfo/index_test.html" title="首頁">首頁</a>
            </div>
		</form>
	</div>
</body>
</html>