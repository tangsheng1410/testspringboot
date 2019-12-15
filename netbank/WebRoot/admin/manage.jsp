<%@page contentType="text/html;charset=utf-8" import="java.sql.*,java.util.*"%>
<%
	if(session.getAttribute("admin")==null)
	{ 
%>
		<jsp:forward page="/login.jsp"></jsp:forward>
<%
	}
%>
<html>
<head>
<title>管理员页面</title>
</head>
  <frameset framespacing="0" border="false" cols="230,*" frameborder="0">
  <frame name="left"  scrolling="no" marginwidth="0" marginheight="0" src="left.jsp">
  <frame name="right" scrolling="yes" src="main.jsp">
</frameset>

<noframes>
</noframes> 
</html>
