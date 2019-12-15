<%@page contentType="text/html;charset=gb2312" import="java.sql.*,java.util.*"%>
<%
	if(session.getAttribute("user")==null)
	{ 
%>
		<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
%>
<html>
<head>
<title>мЬиорЬпп</title>
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
</head>
<FRAMESET border=0 frameSpacing=0 rows="60, *" frameBorder=0>
<FRAME name=header src="/netbank/header.jsp" frameBorder=0 noResize scrolling=no>
<FRAMESET cols="170, *">
<FRAME name=menu src="/netbank/left.jsp" frameBorder=0 noResize>
<FRAME name=main src="/netbank/main.jsp" frameBorder=0 noResize scrolling=yes>
</FRAMESET>
</FRAMESET>
<noframes>
</noframes>
</html>
