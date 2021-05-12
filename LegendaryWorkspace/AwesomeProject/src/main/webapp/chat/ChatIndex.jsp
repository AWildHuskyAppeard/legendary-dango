<%@page import="chat.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat</title>
<style>
    body{
        text-align: center;
    }
    table{
        width: 60%;
        border: 2px solid black;
        margin: auto;
        background-color: white;
    }
    td{
    border-bottom: 1px solid blue;
    }
    td#class{
        width: 80px;
        text-align: center;
    }
    td#time{
        width: 100px;
        text-align: center;
    }
</style>
</head>
<body bgcolor="lightblue">
<%  

%>
    <header><h1>StudieHub 討論區</h1></header>
    <form action="../ChatServlet">
    <table>
    
	</table>    
    </form>
</body></html>