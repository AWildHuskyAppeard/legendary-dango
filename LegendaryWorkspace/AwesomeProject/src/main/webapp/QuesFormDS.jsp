<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
%>
<HTML>
<HEAD>
<BODY BGCOLOR="#FDF5E6">
<meta charset="UTF-8">
<TITLE>題庫</TITLE>
</HEAD>
<BODY>
<FORM ACTION="./QuesServletDS">
<H1 ALIGN="CENTER">題庫</H1>
  題目編號  :  <INPUT TYPE="TEXT" NAME="Q_ID"><BR>
  題目種類  :  <INPUT TYPE="TEXT" NAME="Q_Type"><BR>
  題　目　  :  <INPUT TYPE="TEXT" NAME="Q_Ques"><BR>
  選　項　  :  <INPUT TYPE="TEXT" NAME="Q_Selection"><BR>
  正　解　  :  <INPUT TYPE="TEXT" NAME="Q_Ans"><BR>
  題目類別  :  <INPUT TYPE="TEXT" NAME="P_Class"><BR><BR>
  
  <DIV>
    <INPUT NAME="QUERY"  TYPE="SUBMIT" VALUE="QUERY">
    <INPUT NAME="UPDATE" TYPE="SUBMIT" VALUE="UPDATE">
    <INPUT NAME="DELETE" TYPE="SUBMIT" VALUE="DELETE">
    <INPUT NAME="CREATE" TYPE="SUBMIT" VALUE="CREATE">
    
  </DIV>
</FORM>


</BODY>
</HTML>