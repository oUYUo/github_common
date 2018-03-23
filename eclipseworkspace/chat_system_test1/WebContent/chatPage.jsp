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
<%! String All="";
	String person2="";
	String person2Before="";
%>

<%
	session.setAttribute("person1", request.getParameter("person1"));
	session.setAttribute("person2", request.getParameter("person2"));
	Jdcb jb = new Jdcb();
	String person2Word=jb.Search(request.getParameter("person2"));
	person2Before=person2;
	person2=person2Word;
	
	if(person2!=person2Before)
	{
		out.println("person2:"+person2+"<hr>");
	}
	
	if(request.getParameter("word")!=null)
	{
		All=All+request.getParameter("word")+"<hr>";
		out.println(All);
	}

%>

<form action="update_DB.jsp" method="post">
<%--Name: <input type="text" name="name"/> --%>
Word：<input type="text" name="word"/>

<input type="submit" value="提交"/>
</form>
</body>
</html>