<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<meta charset="UTF-8">
  <TITLE>更新頁面</TITLE>
  <link rel="stylesheet" type="text/css" href="/AwesomeProject/event/Bootstrap/css/bootstrap.min.css">
</HEAD>
<BODY >
<H1 ALIGN="CENTER" >更新頁面</H1>
<CENTER>  
<FORM  class="form-control" ACTION="/AwesomeProject/EventServletDS">
   
   <div class="form-group">
   <label for="uid">活動 UID:</label>
   <INPUT  TYPE="TEXT" NAME="uid" id="uid"   >
   </div>
   <div class="form-group">
   <label for="aname">活動名稱 AName:</label>
   <INPUT TYPE="TEXT" NAME="aname" id="aname" >
   </div>
   <div class="form-group">
   <label for="aid"> 活動 AID:</label>
   <INPUT TYPE="TEXT" NAME="aid"   id="aid"      >
   </div>
   <div class="form-group">
   <label for="adate">活動時間 ADATE:</label>
   <INPUT TYPE="date" NAME="adate" id="adate" >
   </div>
   <div class="form-group">
   <label for="acoin">活動代幣 ACOIN:</label>
   <INPUT TYPE="TEXT" NAME="acoin" id="acoin" >
   </div>
   
   
            
  
   
    <INPUT NAME="updhomesubmit" TYPE="SUBMIT" VALUE="提交">
    <input type="submit" name="Home" value="首頁" >
    
  </CENTER>
</FORM>

</BODY>
</HTML>