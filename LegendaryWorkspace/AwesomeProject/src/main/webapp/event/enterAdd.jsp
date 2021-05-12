<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<meta charset="UTF-8">
  <TITLE>新增頁面</TITLE>
  <link rel="stylesheet" type="text/css" href="/AwesomeProject/event/Bootstrap/css/bootstrap.min.css">
</HEAD>
<BODY >
<H1 ALIGN="CENTER">新增頁面</H1>
        <CENTER>
<FORM ACTION="/AwesomeProject/EventServletDS">
   活動 UID  :     <INPUT TYPE="TEXT" NAME="uid"><BR>
   活動名稱 AName:  <INPUT TYPE="TEXT" NAME="aname"><BR>
   活動 AID:  <INPUT TYPE="TEXT" NAME="aid"><BR>
   活動時間 ADATE:  <INPUT TYPE="date" NAME="adate"><BR>
   活動代幣 ACOIN:  <INPUT TYPE="TEXT" NAME="acoin"><BR>
            
 
   
    <INPUT class="btn btn-primary"  NAME="addsubmit" TYPE="SUBMIT" VALUE="提交">
    <input class="btn btn-primary"  type="submit" name="Home" value="首頁" >
    
  </CENTER>
</FORM>

</BODY>
</HTML>