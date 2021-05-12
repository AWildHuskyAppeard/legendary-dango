<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>目前題庫資料</title>
<style type="text/css">
 tr:nth-child(odd){
	background-color: white;
	color: black;
}

 tr:nth-child(even){
	background-color: aliceblue;
	color: black;
}


</style>
</head>
<body BGCOLOR="#FDF5E6">
<H1 ALIGN="CENTER">後台管理系統</H1>
	<%
	request.getAttribute("all");
	%>
	<form action="/AwesomeProject/QuesServletDS">
		<table ALIGN="CENTER">
			<tr>
				<td>Q_ID</td>
				<td>Q_Type</td>
				<td>Q_Ques</td>
				<td>Q_Selection</td>
				<td>Q_Ans</td>
				<td>P_Class</td>
			</tr>
			
			<c:forEach items="${all}" var="allQuesBean">
				<tr>
					<td>${allQuesBean.q_ID}</td>
					<td>${allQuesBean.q_Type}</td>
					<td>${allQuesBean.q_Ques}</td>
					<td>${allQuesBean.q_Selection}</td>
					<td>${allQuesBean.q_Ans}</td>
					<td>${allQuesBean.p_Class}</td>	
					             
				</tr>

			</c:forEach>

		</table><br><br>
		<a href="/AwesomeProject/question/QuesFormDS2.jsp">進入數據管理</a>
	
		<hr><br>
		<a href="/AwesomeProject/question/QuesFormDS.jsp">題庫首頁</a>
	</FORM>

</body>
</html>