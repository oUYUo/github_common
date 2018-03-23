<%@ page language="java" contentType="text/html; charset=UTF-8"
	import = "java.io.PrintWriter"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
	错误原因为：<% exception.printStackTrace(new PrintWriter(out));%>
	<%--当页面有错误时，就会跳转至此页面 --%>
</p>
</body>
</html>