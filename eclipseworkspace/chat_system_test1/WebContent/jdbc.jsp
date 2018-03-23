<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jdbc.Jdcb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String user=request.getParameter("person1");
	Jdcb jb = new Jdcb();

		jb.setUser(user);
		System.out.println(user+"正在使用对话");

%>
<jsp:forward page="chatPage4.jsp"></jsp:forward>
</body>
</html>