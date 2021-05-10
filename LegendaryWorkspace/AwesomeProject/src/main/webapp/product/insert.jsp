<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增或更新課程</title>
</head>

<body>
	<form action="/AwesomeProject/ControlServlet" method="POST" enctype="multipart/form-data">
            <div>
                <label>課程編號:</label>
                <input type="text" name="P_ID" >
            </div>
            <div>
                <label>課程名稱:</label>
                <input required type="text" name="P_Name" >
            </div>
            <div>
                <label>老師帳號:</label>
                <input required type="text" name="U_ID" >
            </div>
            <div>
                <label>課程分類:</label>
                <select name="P_Class">
                <option value="english">英文</option>
                <option value="japanese">日文</option>

                </select>
            </div>
            <div>
                <label>課程價錢:</label>
                <input type="text" name="P_Price">
            </div>
            <div>
                <label>課程圖片:</label>
                <input type="file" name="P_Img">
            </div>
            <div>
                <label>課程影片:</label>
                <input type="file" name="P_Video">
            </div>
            <div>
                <label style="text-align: right; float: left;">課程介紹:</label>
                <textarea required cols="40" rows="8" name="P_DESC" style="resize: none;"></textarea>
            </div>
            <div>
                <input type="submit" value="新增課程" name="insertProduct">
                <input type="submit" value="更新課程" name="updateProduct">
                <input type="reset" value="重新輸入">
            </div>
           
        </form>
	
</body>
</html>