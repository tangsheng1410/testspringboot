<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function disptime(){
	var now=new Date();
	
	var year=now.getFullYear();
	var month=now.getMonth()+1;
	var date=now.getDate();
	var hour=now.getHours();
	var minute=now.getMinutes();
	var second =now.getSeconds();
		document.myform.date.value=year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
		//year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
		setTimeout("disptime()", 1000);
	}
</script>
  </head>
  
  <body onload="disptime()">
  	<%=basePath %>
   <form name="myform" action="file/file_addImages" enctype="multipart/form-data" method="post">
   	<input type="file" name="image">
   	<input type="submit" value="upload"><br>
   	<input type="text" name="date" >
   </form> 
</html>
