<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�˻���Ϣ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/style.css">
	<link rel="stylesheet" type="text/css" href="style/default.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	<%@ include file='checklogin.jsp' %>
	-->
	
  </head>
  
  <body ><br>
  <div  align="center">
		<table width="450" border="1" class="table">
			<tbody>
				<tr><td>�˻���</td>
				<td>&nbsp;${user.accountid}</td></tr>
				<tr><td>������</td>
				<td>&nbsp;${personinfo.realname}</td></tr>
				<tr>
				<td>���䣺</td>
				<td>&nbsp;${personinfo.age}</td></tr>
				<tr>
				<td>�Ա�</td>
				<td>&nbsp;${personinfo.sex}</td></tr> 
				<tr><td>��ͥ��ַ��</td>
				<td>&nbsp;${personinfo.address}</td></tr>
				<tr>
				<td>��ϵ�绰��</td>
				<td>&nbsp;${personinfo.telephone}</td></tr>
				<tr>
				<td>֤�����룺</td>
				<td>&nbsp;${personinfo.cardid}</td></tr>
				<tr>
				<td>�˻���</td>
				<td>${user.balance}<br></td></tr>
			</tbody>
		</table> 		
		</div>
  </body>
</html>
