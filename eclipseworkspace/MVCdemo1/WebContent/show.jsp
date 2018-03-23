<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Integer d1=(Integer)request.getAttribute("out1");
		Integer d2=(Integer)request.getAttribute("out2");
		Integer sum=(Integer)request.getAttribute("out_sum");
	%>
	<p><%=d1 %>加到<%=d2 %>的和值是：<%=sum %></p>
</body>
</html>