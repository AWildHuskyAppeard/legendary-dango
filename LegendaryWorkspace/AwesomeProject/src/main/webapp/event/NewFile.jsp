<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<meta charset="UTF-8">
  <TITLE>Department Form</TITLE>
</HEAD>
<BODY BGCOLOR="#FDF5E6">
<H1 ALIGN="CENTER">Department Form</H1>
       
<FORM ACTION="/MyTopic/EventServletDS">
   活動 UID  :     <INPUT TYPE="TEXT" NAME="deptno"><BR>
   活動名稱 AName:  <INPUT TYPE="TEXT" NAME="dname"><BR>
   活動 AID:  <INPUT TYPE="TEXT" NAME="aid"><BR>
   活動時間 ADATE:  <INPUT TYPE="TEXT" NAME="adate"><BR>
   活動代幣 ACOIN:  <INPUT TYPE="TEXT" NAME="acoin"><BR>
            
  <CENTER>
    <INPUT NAME="QUERY"  TYPE="SUBMIT" VALUE="查詢">
    <INPUT NAME="UPDATE" TYPE="SUBMIT" VALUE="更新">
    <INPUT NAME="delete" TYPE="SUBMIT" VALUE="刪除">
    <INPUT NAME="Add" TYPE="SUBMIT" VALUE="新增">
  </CENTER>
</FORM>

</BODY>
</HTML>