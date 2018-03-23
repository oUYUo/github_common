<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@ page import="java.sql.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="CSS/style.css">
<title>
enterprise
</title>
</head>
<%!
ResultSet rs=null;
String sql,login;
int code;
int pagesize=10;
int rowcount=0;
int pagecount=1,n;
int showpage=1;
%>

<body bgcolor="#ffffff">
<%
login=(String)session.getAttribute("login");
if(login==null)
{
%>
<script language="javascript">
alert("您还未登录，不能浏览详细信息！！！");
</script>
<%
response.sendRedirect("login.jsp");
}
%><jsp:include page="top.jsp"/>
<table border="1" width="786" align="center"bordercolor="#FFFFFF" cellpadding="0" cellspacing="0"bordercolordark="#333333" bordercolorlight="#FFFFFF">
<tr>
    <td width="786" align="center" colspan="6" height="32">企业信息</td>
  </tr>
<tr>
    <td width="786" align="center" height="27" colspan="6">
      <p align="right"> <a href="enterprise_add.jsp">发布信息...</a></td>
  </tr>
  <tr>
    <td width="18%" align="center"height="27">企业类型</td>
    <td width="17%" align="center"height="27">企业名称</td>
    <td width="17%" align="center"height="27">经营范围</td>
    <td width="17%" align="center"height="27">所属区域</td>
    <td width="17%" align="center"height="27">地址</td>
    <td width="18%" align="center"height="27">操作</td>
  </tr>
<%
 sql="select * from tb_Enterprise order by IssueDate desc";
try
{
 rs=connection.executeQuery(sql);
if(!rs.next())
{
%>
<script language="javascript">
	alert("没有企业信息");
</script>
<%
}else
{
rs.last();
rowcount=rs.getRow();
pagecount=((rowcount%pagesize)==0?(rowcount/pagesize):(rowcount/pagesize)+1);
 String topage=request.getParameter("topage");
if(topage!=null)
{
showpage=Integer.parseInt(topage);
if(showpage>pagecount){
  showpage=pagecount;
  }else if(showpage<=0){
  showpage=1;
  }
}
rs.absolute((showpage-1)*pagesize+1);
for(int i=1;i<=pagesize;i++)
{
code=rs.getInt("ID");
%>
 <tr>
    <td width="17%" align="center" height="27"><%=rs.getString("EnterpriseSort")%></td>
    <td width="17%" align="center"height="27"><%=rs.getString("EnterpriseName")%></td>
    <td width="17%" align="center"height="27"><%=rs.getString("Operation")%></td>
    <td width="18%" align="center"height="27"><%=rs.getString("WorkArea")%></td>
    <td width="18%" align="center"height="27"><%=rs.getString("Address")%></td>
    <td width="17%" align="center"height="27"><a href="enterprise_show.jsp?id=<%=code%>">详细</a>　</td>
  </tr>
<%
if(!rs.next())
break;
}}
}catch(Exception e)
{out.println("查询异常!!!");}
%>
<tr>
    <td width="786" height="30" colspan="9" align="right">

<table width="786" align="center" cellpadding="0" cellspacing="0">
	<tr>
    <td width="786" height="30" colspan="6" align="right">
        共<%=pagecount%>页&nbsp;&nbsp;
        <a href="enterprise_select.jsp?topage=<%=1%>">第一页</a>&nbsp;&nbsp;
        <a href="enterprise_select.jsp?topage=<%=showpage-1%>">上一页</a>&nbsp;&nbsp;
        <a href="enterprise_select.jsp?topage=<%=showpage+1%>">下一页</a>&nbsp;&nbsp;
        <a href="enterprise_select.jsp?topage=<%=pagecount%>">最后一页</a>
 
</td>
</tr>
</table>
</td>
</tr>
</table>
</body>
</html>
