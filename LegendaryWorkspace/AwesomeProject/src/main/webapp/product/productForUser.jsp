<%@page import="product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="">
        <%
        ArrayList<ProductBean> list = (ArrayList<ProductBean>)session.getAttribute("list");
        ProductBean findByID = (ProductBean)session.getAttribute("find");
        %>
    </head>
    <body>
		<form action="/AwesomeProject/ControlServlet" method="POST">
            <label>搜尋課程ID:</label>
            <input type="text" name="P_ID"><input type="submit" name="findByID" value="搜尋">
        </form>
        
        <%
        for (int i=0;i<list.size();i++){
        	
        	ProductBean p = list.get(i);
        	String imgName = p.getP_Img().split("\\\\")[10];
        %>
    	<div>
    	<img src="product/File/<%=imgName%>" width="200px" height="200px" >
    	</div>
        
        <%} %>
        
        
    </body>
</html>