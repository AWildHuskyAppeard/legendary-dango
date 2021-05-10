<%@page import="product.ProductBean"%>
<%@page import="product.ProductDAOImpl"%>
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
    </head>
    <body>
        <%
        
        ProductDAOImpl pDao = new ProductDAOImpl();
        ArrayList<ProductBean> list = pDao.findAll();
		//把arraylist放進session裡面
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
        
        %>
        <img src="/AwesomeProject/src/main/webapp/images/logo.jpg"

    </body>
</html>