<%@ page language="java"  contentType="text/html; charset=UTF-8"
	import="java.util.*" session="true" isThreadSafe="true" errorPage="errorpage.jsp"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 注释，可以在浏览器源代码看见 -->
	<%--注释，在浏览器源代码看不见 --%>
	<%! int a = 5;%>
	<!-- 
		jsp声明变量作用域为整个页面 
		成为组件的全局变量，对变量的任何修改都会影响到所有访问此界面的客户端
	
	-->
	
	<p>您是第<%=a++ %>个访问本站的客户</p>
	
	<p>表达式的值</p>
	<%= a+10 %>
	<%=1/0 %>
</body>
</html>