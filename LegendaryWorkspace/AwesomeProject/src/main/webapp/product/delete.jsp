<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/AwesomeProject/ControlServlet?method=delete" method="GET">
    
        <div>
            <label>想要刪除的課程編號:</label>
            <input type="text" name="P_ID" required>
        </div>
        <div>
            <input type="submit" value="確認送出">
            <input type="reset" value="重新輸入">
        </div>
    
    
    
    
    
    
    
    </form>

</body>
</html>