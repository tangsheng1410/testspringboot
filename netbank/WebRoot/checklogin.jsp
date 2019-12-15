
<%@page import="com.netbank.entity.Account"%>
<%
	Account account=(Account)session.getAttribute("user");
	if(account==null){
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}

%>
