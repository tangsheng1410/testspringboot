<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>changepwd</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="style/style.css" >
	<link rel="stylesheet" type="text/css" href="style/default.css" >
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript">
	
	function check(){
	var oldpwd=document.getElementById("oldpwd").value;
	var newpwd=document.getElementById("newpwd").value;
	var confirmpwd=document.getElementById("confirmpwd").value;
		if(oldpwd!=""&&newpwd!=""&&confirmpwd!="")
		{
			if(newpwd!=confirmpwd)
			{
				document.getElementById("secondpwd").style.display="inline";
				return false;
				
			}
			return true;
		}
		else{
			alert("密码不能为空！");
			return false;
		}
	}
	
	
	
	
</script>
  </head>
  	
  <body>
		<form  method="post" name="myform" action="admin/changepwd" onsubmit="return check()">
				<div align="center">
				<table width="400" border="0" class="table">
					<tbody>
						<tr>
						<td>&nbsp;当前密码：</td>
						<td>
							<input type="password" name="pwd.oldpwd" id="oldpwd">
							<span style="color:red;">* <s:fielderror/></span>
						</td>
						</tr>
						<tr>
						<td width="100">&nbsp;新密码：</td>
						<td>
							<input type="password" name="pwd.newpwd" id="newpwd" >
							<span style="color:red;">*</span>
						</td></tr>
						<tr>
						<td>&nbsp;确认密码：</td>
						<td>
							<input type="password" name="pwd.confirmpwd" id="confirmpwd" >
							<span style="color:red;">*</span>
							<span style="color:red;display:none;" id="secondpwd">两次密码不一致</span>
						</td>
						</tr>
						<tr>
						<td>&nbsp;</td>
						<td>&nbsp;<input type="Submit" value="修改" /> </td>
						</tr>
					</tbody>
				</table>
					 
				</div> 
				
		</form>
  </body>
</html>
