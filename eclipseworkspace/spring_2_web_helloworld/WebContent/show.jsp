<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.edu.HelloBean" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring应用示例</title>

</head>
<body>
<%
	ServletContext sc = request.getServletContext();
	WebApplicationContext wact;
	wact=WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
	HelloBean student;
	student=(HelloBean)wact.getBean("stu1");
%>
姓名：<%=student.getName() %><br>
课程名： <%=student.getCourse() %><br>
成绩：<%=student.getScore() %><br>
-----------------------<br>
<%	
	student=(HelloBean)wact.getBean("stu2");
%>
姓名：<%=student.getName() %><br>
课程名： <%=student.getCourse() %><br>
成绩：<%=student.getScore() %><br>
-----------------------<br>
<%	
	student=(HelloBean)wact.getBean("stu3");
%>
姓名：<%=student.getName() %><br>
课程名： <%=student.getCourse() %><br>
成绩：<%=student.getScore() %><br>
-----------------------<br>
</body>
</html>