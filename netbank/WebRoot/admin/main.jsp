<%@page contentType="text/html;charset=gb2312" import="java.sql.*,java.util.*"%>
<%@page import="com.netbank.entity.Admin"%>

<%
	if(session.getAttribute("admin")==null){
%>
		<jsp:forward page="/login.jsp"></jsp:forward>
<%
	}
%>

<style type=text/css>
body  { background:#799AE1; margin:0px; font:9pt ����; }
table  { border:0px; }
td  { font:normal 12px ����; }
img  { vertical-align:bottom; border:0px; }
a  { font:normal 12px ����; color:#000000; text-decoration:none; }
a:hover  { color:#428EFF;text-decoration:underline; }
.sec_menu  { border-left:1px solid white; border-right:1px solid white; border-bottom:1px solid white; overflow:hidden; background:#D6DFF7; }
.menu_title  { }
.menu_title span  { position:relative; top:2px; left:8px; color:#215DC6; font-weight:bold; }
.menu_title2  { }
.menu_title2 span  { position:relative; top:2px; left:8px; color:#428EFF; font-weight:bold; }
</style>
<html>
<head>

<meta http-equiv="Content-Language" content="zh-cn">

<title>�ޱ����ĵ�</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<base target="_blank">

</head>
<body bgcolor="#FFFFFF" text="#000000" style="background-color: #DBC2B0">
<br>
<div align="center">
  <center>
  <table style="WORD-BREAK: break-all; BORDER-COLLAPSE: collapse" cellSpacing="0" cellPadding="0" width="645" bgColor="#ffffff" border="0">
    <tr>
      <td colSpan="3" width="645">
      <div align="center">
        <table cellSpacing="0" cellPadding="0" width="96%" border="0">
          <tr>
            <td>
            <p style="MARGIN-TOP: 20px; MARGIN-BOTTOM: 5px; MARGIN-LEFT: 50px; LINE-HEIGHT: 150%">
            <b><font color="#ed5f19">����ӭʹ�ù���ϵͳ��</font></b></p>
                  <p style="MARGIN-TOP: 20px; MARGIN-BOTTOM: 5px; MARGIN-LEFT: 50px; LINE-HEIGHT: 150%"> 
                   
                  <p style="MARGIN-TOP: 20px; MARGIN-BOTTOM: 5px; MARGIN-LEFT: 50px; LINE-HEIGHT: 150%"><br>
                    -------------------------------------------------------- </p>
                  <p style="MARGIN-TOP: 5px; MARGIN-BOTTOM: 5px; MARGIN-LEFT: 50px; LINE-HEIGHT: 150%"> 
                  <p>&nbsp;</p>
                  <p style="MARGIN-TOP: 5px; MARGIN-BOTTOM: 5px; MARGIN-LEFT: 50px; LINE-HEIGHT: 150%"><br>
                ��</td>
          </tr>
        </table>
      </div>
      </td>
    </tr>
  </table>
  </center>
</div>
<br>
</body>
</html>