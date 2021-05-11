<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>目前題庫資料</title>
</head>
<body BGCOLOR="#FDF5E6">

	<%
	request.getAttribute("all");
	%>
	<form action="/AwesomeProject/QuesServletDS">
		<table>
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

		</table>		
		<hr>
		<a href="/AwesomeProject/question/QuesFormDS.jsp">題庫首頁</a>
	</FORM>

</body>
</html>