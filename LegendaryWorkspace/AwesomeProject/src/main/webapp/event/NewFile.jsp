<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<meta charset="UTF-8">
  <TITLE>專題2</TITLE>
  <link rel="stylesheet" type="text/css" href="/AwesomeProject/event/Bootstrap/css/bootstrap.min.css">
</HEAD>
<BODY >
<H1 ALIGN="CENTER">專題2</H1>
       
<FORM ACTION="/AwesomeProject/EventServletDS"  class="form-control" >
<CENTER>
  <div class="form-group">
   搜尋活動ID:<INPUT TYPE="TEXT" NAME="uid"  ><BR>
   </div>
   <!--
   活動名稱 AName:  <INPUT TYPE="TEXT" NAME="aname"><BR>
   活動 AID:  <INPUT TYPE="TEXT" NAME="aid"><BR>
   活動時間 ADATE:  <INPUT TYPE="TEXT" NAME="adate"><BR>
   活動代幣 ACOIN:  <INPUT TYPE="TEXT" NAME="acoin"><BR>
    <INPUT class="btn btn-danger"  NAME="delete" TYPE="SUBMIT" VALUE="刪除">
    <INPUT class="btn btn-primary"  NAME="UPDATE_home" TYPE="SUBMIT" VALUE="更新">   
    <INPUT class="btn btn-primary"  NAME="Add" TYPE="SUBMIT" VALUE="新增">-->
            
    <INPUT class="btn btn-primary"  NAME="QUERY"  TYPE="SUBMIT" VALUE="查詢">
    <INPUT class="btn btn-primary"  NAME="AllQUERY" TYPE="SUBMIT" VALUE="後臺">
   
</CENTER>
</FORM>
<button><a class="btn btn-primary"  href="/AwesomeProject/index_test.html"><b>大家的首頁</b></a></li></button>

</BODY>
</HTML>