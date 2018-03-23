<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.Jdbc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选项</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String friend=request.getParameter("friend");
	Jdbc DB = new Jdbc();
	if((password.equals(DB.SearchPassword(username)))&&(DB.SearchPassword(friend)!="null")){
		session.setAttribute("username",username);
		session.setAttribute("password", password);
		session.setAttribute("friend",friend);
		out.println("<a href=\"mainPage.jsp\">进入我的主页</a>");
	}
	else{
		//out.println(password+DB.SearchPassword(username));
		out.println(DB.SearchPassword(friend));
		out.println("账户不存在，或密码错误,或好友不存在"+"<br>");
		out.println("<a href=\"login.jsp\">登录页面</a>");
	}
	
%>


</body>
</html>