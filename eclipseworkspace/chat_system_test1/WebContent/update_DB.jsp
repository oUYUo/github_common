<%@page import="jdbc.Jdcb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");
	String name;
	String word;
	String person1;
	String person2;
	word=request.getParameter("word");
	person1=(String) session.getAttribute("person1");
	person2=(String) session.getAttribute("person2");
	System.out.println("用户为："+person1);
	System.out.println("对象为："+person2);
	//name=request.getParameter("name");
	name=person1;
	out.println(word);
	Jdcb jb = new Jdcb();
	jb.Update(name, word);
%>
<jsp:forward page="chatPage2.jsp"></jsp:forward>
</body>
</html>