<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<meta charset="UTF-8">
  <TITLE>專題2</TITLE>
</HEAD>
<BODY BGCOLOR="#FDF5E6">
<H1 ALIGN="CENTER">專題2</H1>
       
<FORM ACTION="/AwesomeProject/EventServletDS" autocomplete="off">
  <CENTER>
   活動 UID:<INPUT TYPE="TEXT" NAME="uid"  autocomplete=”off” ><BR>
   <!--
   活動名稱 AName:  <INPUT TYPE="TEXT" NAME="aname"><BR>
   活動 AID:  <INPUT TYPE="TEXT" NAME="aid"><BR>
   活動時間 ADATE:  <INPUT TYPE="TEXT" NAME="adate"><BR>
   活動代幣 ACOIN:  <INPUT TYPE="TEXT" NAME="acoin"><BR>-->
            
    <INPUT NAME="QUERY"  TYPE="SUBMIT" VALUE="查詢">
    <INPUT NAME="delete" TYPE="SUBMIT" VALUE="刪除">
    <INPUT NAME="UPDATE_home" TYPE="SUBMIT" VALUE="更新">
    
    <INPUT NAME="Add" TYPE="SUBMIT" VALUE="新增">
    <INPUT NAME="AllQUERY" TYPE="SUBMIT" VALUE="查詢全部">
   
  </CENTER>
</FORM>
<button><a href="/AwesomeProject/index_test.html">大家的首頁</a></button>
</BODY>
</HTML>