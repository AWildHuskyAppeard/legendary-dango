<%@page import="product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>課程管理</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="">
        <%
        ArrayList<ProductBean> list = (ArrayList<ProductBean>)session.getAttribute("list");
        //System.out.println(list);
        %>
    </head>
    <style>
        th{
            border: 1px solid black;
        }
    </style>
    <body>
		<h2>課程列表</h2>
		<table align="center" border="1">
			<tr>
                <th>課程ID</th>
                <th>課程名稱</th>
                <th>課程分類</th>
                <th>課程敘述</th>
                <th>課程價錢</th>
                <th>課程圖片</th>
                <th>課程影片</th>
                <th>授課者ID</th>
            </tr>
            <%
            for (int i=0;i<list.size();i++){
            	
            	ProductBean p = list.get(i);
            %>
            <tr>
            	<th><%=p.getP_ID() %></th>
            	<th><%=p.getP_Name() %></th>
            	<th><%=p.getP_Class() %></th>
            	<th><%=p.getP_DESC() %></th>
            	<th><%=p.getP_Price() %></th>
            	<th><%=p.getP_Img() %></th>
            	<th><%=p.getP_Video() %></th>
            	<th><%=p.getU_ID() %></th>
            </tr>
            <% 
            }
            %>
            
       
           
            
		</table>

    </body>
</html>