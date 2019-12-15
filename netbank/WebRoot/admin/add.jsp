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
    
    <title>My JSP 'modify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/netbank/style/style.css">
	<link rel="stylesheet" type="text/css" href="/netbank/style/default.css">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function check()
	{
	
      	var isMobile=/^(?:13\d|15\d)\d{5}(\d{3}|\*{3})$/;   
       	var isPhone=/^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/; 
       	var isCardid=/^\d{17}(\d|x)$/;
		var username=document.getElementById("username").value;
		var pwd=document.getElementById("pwd").value;
		var confirmpwd=document.getElementById("confirmpwd").value;
		var balance=document.getElementById("balance").value;
		var realname=document.getElementById("realname").value;
		var age=document.getElementById("age").value;
		var address=document.getElementById("address").value;
		var telephone=document.getElementById("telephone").value;
		var cardid=document.getElementById("cardid").value;
		
		
		document.getElementById("errorusername").innerHTML="";
		document.getElementById("errorpwd").innerHTML="";
		document.getElementById("errorconfirmpwd").innerHTML="";
		document.getElementById("errorbalance").innerHTML="";
		document.getElementById("errorrealname").innerHTML="";
		document.getElementById("errorage").innerHTML="";
		document.getElementById("erroraddress").innerHTML="";
		document.getElementById("errortelephone").innerHTML="";
		document.getElementById("errorcardid").innerHTML="";
		if(username=="")
		{
				document.getElementById("errorusername").innerHTML="请输入用户名";
				return false;
		}else if(pwd=="")
		{
				document.getElementById("errorpwd").innerHTML="请输入密码";
				return false;
		}else if(confirmpwd=="")
		{
				document.getElementById("errorconfirmpwd").innerHTML="请确认密码";
				return false;
		}else if(balance=="")
		{
				document.getElementById("errorbalance").innerHTML="请输入金额";
				return false;
		}else if(realname=="")
		{
				document.getElementById("errorrealname").innerHTML="请输入姓名";
				return false;
		}else if(address=="")
		{
				document.getElementById("erroraddress").innerHTML="请输入地址";
				return false;
		}else if(telephone=="")
		{
				document.getElementById("errortelephone").innerHTML="请输入电话";
				return false;
		}else if(cardid=="")
		{
				document.getElementById("errorcardid").innerHTML="请输入身份证号";
				return false;
		}else if(age=="")
		{
				document.getElementById("errorage").innerHTML="请输入年龄";
				return false;
		}else
		{
			if(pwd!=confirmpwd)
				{
					document.getElementById("errorconfirmpwd").innerHTML="两次密码不一致";
					return false;
				}
			if(!(balance.search(/^[\+\-]?\d+\.?\d*$/)==0))
			{
				
				document.getElementById("errorbalance").innerHTML="含有非法字符";
				return false;
			}else{
				if(parseFloat(balance)<10)
				{
						document.getElementById("errorbalance").innerHTML="开户金额不能少于10元";
						return false;
				}
			}
			if(!(age.search(/^[\+\-]?\d+\.?\d*$/)==0))
			{
				
				document.getElementById("errorage").innerHTML="含有非法字符";
				return false;
			}else{
				if(parseFloat(age)<18)
				{
						document.getElementById("errorage").innerHTML="未成年人不能开户";
						return false;
				}else if(parseFloat(age)>99)
				{
					document.getElementById("errorage").innerHTML="年龄输入有误,100岁以下";
						return false;
				}
			}
			if(!isPhone.test(telephone)&&!isMobile.test(telephone))
			{
				document.getElementById("errortelephone").innerHTML="电话格式不正确";
				return false;
			}
			if(!isCardid.test(cardid))
			{
				document.getElementById("errorcardid").innerHTML="身份证格式不正确";
				return false;
			}
			return true;
		}
		
		
		
	}
</script>
  </head>
  
  <body>
  <form method="post" name="myform" action="/netbank/admin/kaihu" onsubmit="return check()">
  <div align="center">
  	<table width="450" class="table">
			<tbody>
				<tr>
					<td width="100">用户名：</td>
					<td>
						<input id="username" type="text" name="account.username"/>
						<span id="errorusername" style="color:red;">${message}</span>						
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td>
						<input id="pwd" type="password" name="account.password"/>
						<span id="errorpwd" style="color:red;"></span>
					</td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td>
						<input id="confirmpwd" type="password"/>
						<span id="errorconfirmpwd" style="color:red;"></span>
					</td>
				</tr>
				<tr>
					<td>开户金额：</td>
					<td>
						<input id="balance" type="text" name="account.balance" />
						<span id="errorbalance" style="color:red;"></span>
					</td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td>
						<input type="text" id="realname" name="personinfo.realname"/>
						<span id="errorrealname" style="color:red;"></span>
					</td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td>
						<input id="age" type="text" name="personinfo.age""/>
						<span id="errorage" style="color:red;"></span>
					</td>
				</tr>
				<tr>
				<td>性别：</td>
				<td>
						<select name="personinfo.sex" >
							<option value="男" >男</option>
							<option value="女" >女</option>
						</select></td></tr> 
				<tr><td>家庭地址：</td>
				<td>
					<input id="address" type="text" name="personinfo.address""/>
					<span id="erroraddress" style="color:red;"></span>
				</td></tr>
				<tr>
					<td>联系电话：</td>
					<td>
						<input id="telephone" name="personinfo.telephone" value="${personinfo.telephone}" type="text"/>
						
						<font size="1">区号(3或4位)-电话(8或9位)</font>
						<span id="errortelephone" style="color:red;"></span>
					</td>
				</tr>
				<tr>
					<td>证件号码：</td>
					<td>
					<input id="cardid" type="text" name="personinfo.cardid" value="${personinfo.cardid}"/>
					<font size="1" >15位或18位</font>
					<span id="errorcardid" style="color:red;"></span>
					</td>
				</tr>
				<tr>
				<td></td>
				<td><input type="submit" value="提交" /> <br></td></tr>
			</tbody>
		</table>
		<div style="color:red;">
        <s:fielderror /> 
    	</div> 
		</div>
		<br>
  </form>  	
   </body>
</html>
