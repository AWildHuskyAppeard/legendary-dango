<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/AwesomeProject/event/Bootstrap/css/bootstrap.min.css">
</head>
<body >

	<%
	request.getAttribute("all");
	%>
	<form action="/AwesomeProject/EventServletDS">
		<table>
			<tr>
				<td>UID</td>
				<td>AID</td>
				<td>ANAME</td>
				<td>ADEAT</td>
				<td>ACOIN</td>
			</tr>
			
			<c:forEach items="${all}" var="allEventBean">
				<tr>
					<td>${allEventBean.uid}</td>
					<td>${allEventBean.aid}</td>
					<td>${allEventBean.aname}</td>
					<td>${allEventBean.adate}</td>
					<td>${allEventBean.acoin}</td>
					<td><a href="/AwesomeProject/EventServletDS?uid=${allEventBean.uid}&aid=${allEventBean.aid}&aname=${allEventBean.aname}&adate=${allEventBean.adate}&acoin=${allEventBean.acoin}&UPDATE=修改">修改</a></td>
				<!--	<td><a href="/MyTopic/enterUPDATE.jsp">修改</a></td>   就更改-->
				 <!--   <td><a href="/MyTopic/enterUPDATE.jsp">修改</a></td> 就更改-->
                    <td><a href="/AwesomeProject/EventServletDS?uid=${allEventBean.uid}&delete=%E5%88%AA%E9%99%A4" onclick="if(confirm('是否確定刪除?')==false){return false}">刪除</a></td>
                   
				</tr>

			</c:forEach>

		</table>
		<hr>
		<input type="submit" name="Home" value="首頁">
	</FORM>

</body>
</html>