<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jdbc.Jdcb" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chatPage</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String word=request.getParameter("word");
	Jdcb jb = new Jdcb();
	
	
	out.println("user:"+jb.getUser()+"<br>"	);
	jb.setWord1(word);
	String word1=jb.getWord1();
	String word2=jb.getWord2();
	if(word1!=null){
		out.println("I:"+word1+"<br>");
	}
	if(word2!=null){
		out.println("I:"+word2+"<br>");
	}
	

%>

<jsp:include page="input4.jsp"></jsp:include>
</body>
</html>