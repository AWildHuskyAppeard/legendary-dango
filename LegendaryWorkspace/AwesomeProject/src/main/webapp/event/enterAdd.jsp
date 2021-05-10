<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<meta charset="UTF-8">
  <TITLE>更新頁面</TITLE>
</HEAD>
<BODY BGCOLOR="#FDF5E6">
<H1 ALIGN="CENTER">更新頁面</H1>
       
<FORM ACTION="/MyTopic/EventServletDS">
   活動 UID  :     <INPUT TYPE="TEXT" NAME="uid"><BR>
   活動名稱 AName:  <INPUT TYPE="TEXT" NAME="aname"><BR>
   活動 AID:  <INPUT TYPE="TEXT" NAME="aid"><BR>
   活動時間 ADATE:  <INPUT TYPE="TEXT" NAME="adate"><BR>
   活動代幣 ACOIN:  <INPUT TYPE="TEXT" NAME="acoin"><BR>
            
  <CENTER>
   
    <INPUT NAME="addsubmit" TYPE="SUBMIT" VALUE="提交">
    <input type="submit" name="Home" value="首頁" >
    
  </CENTER>
</FORM>

</BODY>
</HTML>