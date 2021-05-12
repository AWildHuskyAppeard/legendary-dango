<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/AwesomeProject/event/Bootstrap/css/bootstrap.min.css">
</head>
<body>
	<CENTER>

		<%
		request.getAttribute("all");
		%>
		<form action="/AwesomeProject/EventServletDS">






			<table class="table table-bordered">
				<tr>
					<td>會員ID</td>
					<td>活動ID</td>
					<td>活動名稱</td>
					<td>活動時間</td>
					<td>代幣</td>
				</tr>

				<c:forEach items="${all}" var="allEventBean">
		
					<tr>
						<td>${allEventBean.uid}</td>
						<td>${allEventBean.aid}</td>
						<td>${allEventBean.aname}</td>
						<td>${allEventBean.adate}</td>
						<td>${allEventBean.acoin}</td>

						<td><button class="btn btn-primary btn-xs">
								<a class="btn btn-primary"
									href="/AwesomeProject/EventServletDS?uid=${allEventBean.uid}&aid=${allEventBean.aid}&aname=${allEventBean.aname}&adate=${allEventBean.adate}&acoin=${allEventBean.acoin}&UPDATE=修改">修改</a>
							</button></td>
						<!--	<td><a href="/MyTopic/enterUPDATE.jsp">修改</a></td>   就更改-->
						<!--    <td><a href="/MyTopic/enterUPDATE.jsp">修改</a></td> 就更改-->
						<td><button class="btn btn-danger btn-xs">
								<a class="btn btn-danger"
									href="/AwesomeProject/EventServletDS?uid=${allEventBean.uid}&delete=刪除!"
									onclick="if(confirm('是否確定刪除?')==false){return false}">刪除</a>
							</button></td>

					</tr>

				</c:forEach>

			</table>
			<hr>

			<INPUT class="btn btn-primary" NAME="Add" TYPE="SUBMIT" VALUE="新增">
			<input class="btn btn-primary" type="submit" name="Home" value="首頁">
		</FORM>
	</CENTER>

</body>
</html>