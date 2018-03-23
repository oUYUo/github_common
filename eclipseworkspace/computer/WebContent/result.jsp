<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
	String way =request.getParameter("way") ;
	String firstname =request.getParameter("firstname") ;
	String lastname =request.getParameter("lastname") ;
	if(way.equals("1"))
	{
		out.println("hello");
		out.println(way);
	}
	if(way.equals("3"))
	{
		int f =Integer.parseInt(firstname);
		int l =Integer.parseInt(lastname);
		int result=f+l;
		String Result = String.valueOf(result);
		out.println("result="+Result);
	}
	if(way.equals("4"))
	{
		int f =Integer.parseInt(firstname);
		int l =Integer.parseInt(lastname);
		int result=f-l;
		String Result = String.valueOf(result);
		out.println("result="+Result);
	}
	if(way.equals("1"))
	{
		int f =Integer.parseInt(firstname);
		int l =Integer.parseInt(lastname);
		int result=f*l;
		String Result = String.valueOf(result);
		out.println("result="+Result);
	}
	if(way.equals("2"))
	{
		int f =Integer.parseInt(firstname);
		int l =Integer.parseInt(lastname);
		int result=f/l;
		String Result = String.valueOf(result);
		out.println("result="+Result);
	}
	
%>
<br>
<a href="index.jsp">返回</a>
</body>
</html>