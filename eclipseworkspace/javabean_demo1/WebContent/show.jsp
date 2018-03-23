<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="c" class="com.bean_demo.Add" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="c"/>
	<p>调用jsp:getProperty标签显示结果:<br>
		<jsp:getProperty property="shuju1" name="c"/>
		<jsp:getProperty property="shuju2" name="c"/>
		<jsp:getProperty property="sum" name="c"/>
</body>
</html>