<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢資料</title>
</head>
<body>
<jsp:useBean id="reg_EventBean" class="event.EventBeanpag.EventBean" scope="session" />
<h2>
查詢資料
</h2>
<form action="/AwesomeProject/EventServletDS">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<tr bgcolor="#FFFFE1">
    <td>會員ID:</td>
    <td><jsp:getProperty name="reg_EventBean" property="uid" /></td>
</tr>
<tr bgcolor="#F2F4FB">
    <td>活動ID:</td>
    <td>
    <jsp:getProperty name="reg_EventBean" property="aid" />     
    </td>
</tr>
<tr bgcolor="#FFFFE1">
    <td>活動名稱:</td>
    <td><jsp:getProperty name="reg_EventBean" property="aname" /></td>
</tr>
<tr bgcolor="#F2F4FB">
    <td width="150">活動日期:</td>
    <td><jsp:getProperty name="reg_EventBean" property="adate" /> 
</tr>
<tr bgcolor="#FFFFE1">
    <td>活動代幣</td>
    <td><jsp:getProperty name="reg_EventBean" property="acoin" /></td>
</tr>

</table>
<center>

<input type="submit" name="Home" value="首頁" >

</center>
</form>
</body>
</html>