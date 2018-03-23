<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用表单提交信息</title>
</head>
<body>

<form action="getParam.jsp" method="post">
	姓名<input type="text" name="Username"/>
	<br>
	选出你喜欢的水果
	<input type="checkbox" name="checkbox1" value="苹果"/>苹果
	<input type="checkbox" name="checkbox1" value="香蕉"/>香蕉
	<input type="checkbox" name="checkbox1" value="西瓜"/>西瓜
	<input type="submit" value="提交">
</form>

</body>
</html>