<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/AwesomeProject/ControlServlet" method="POST">
    <label>搜尋課程ID:</label>
    <input type="text" name="P_ID"><input type="submit" name="findByID" value="搜尋">
</form>
</body>
</html>