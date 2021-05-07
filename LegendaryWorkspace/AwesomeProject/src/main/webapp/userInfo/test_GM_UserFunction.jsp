<%@page import="userInfo.UserBean"%>
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
<title>查詢會員</title>
</head>
<body>
    <center>
        <div style="width: 500px;  margin-top: 30px; box-shadow:3px 3px 12px whitesmoke ;">
        <h1>查詢會員資料</h1>
        <form action="/AwesomeProject/UserServlet" method="Get">
            <span>請輸入User ID:</span>
            <input type="text" name="u_ID">
            <button type="submit" name="findByU_ID" style="margin: 0 10px;">查詢單筆</button>
            <br>
            <br>
            <button type="reset" style="margin: 0 10px;">清除</button>
            <a href="/AwesomeProject/userInfo/AdminFindAllUserInfo.jsp">顯示全部會員</a>
            <a href="/AwesomeProject/userInfo/test_GM_index.html">管理員首頁</a>
            <br>
            <br>
        </form>
  		</div>
 
	</center>
</body>
</html>