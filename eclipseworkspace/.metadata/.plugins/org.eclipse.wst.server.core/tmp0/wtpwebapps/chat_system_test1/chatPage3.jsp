<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jdbc.Jdcb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ChatPage</title>
</head>
<body>


<form action="jdbc.jsp" method="post">
	输入：<input type="text" name="word">
	<input type="submit" value="发送">
</form>

</body>
</html>