<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.Jdbc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册返回结果</title>
</head>
<body>
<%
	Jdbc DB = new Jdbc();
	request.setCharacterEncoding("utf-8");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String password1=request.getParameter("password1");

	if((username!=null)&&(password!=null)&&(password1!=null)&&(password.equals(password1)))
	{
		if(DB.Login(username, password)==true)
		{
			out.println("信息填写正确");
			out.println("返回登录界面"+"<a href=\"login.jsp\">登录</a>");
		}
		else{
			out.println("用户已注册"+"<br>");
			out.println("返回注册界面"+"<a href=\"doLogin.jsp\">注册</a>"+"<br>");
			out.println("返回登录界面"+"<a href=\"login.jsp\">登录</a>");
		}
		
		
	}
	else{
		out.println("信息填写错误,重新注册"+"<br>");
		out.println("<a href=\"doLogin.jsp\">注册</a>"+"<br>");
		out.println("返回登录界面"+"<a href=\"login.jsp\">登录</a>");
	}
%>

</body>
</html>