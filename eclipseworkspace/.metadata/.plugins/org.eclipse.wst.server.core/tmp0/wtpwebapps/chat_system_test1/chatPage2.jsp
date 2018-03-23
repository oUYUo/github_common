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
	
	//response.setHeader("refresh", "3");
	Jdcb jb = new Jdcb();
	String person1=(String) request.getParameter("person1");
	String person2=(String) request.getParameter("person2");
	String person1Word=jb.Search(person1);
	String person2Word=jb.Search(person2);
	out.println("I say:"+person1Word+"<br>");
	out.println("He say:"+person2Word+"<br>");

	
	
	
	

%>

<form action="update_DB.jsp" method="post">
<%--Name: <input type="text" name="name"/> --%>
Word：<input type="text" name="word"/>

<input type="submit" value="提交"/>
</form>
</body>
</html>