<%@ page contentType="text/html; charset=gb2312" import="java.sql.*, java.io.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="CSS/style.css">
<title>
Enterprise page
</title>
</head>

<%!
ResultSet rs=null;
String sql,nsql;
String username,login;
int n,count;
int pagesize=10;
int rowcount=0;
int pagecount=1;
%>
<body bgcolor="#ffffff">
<%
login=(String)session.getAttribute("login");
 username=(String)session.getAttribute("name");
if(login==null)
{
%>
<script language="javascript">
alert("您还未登录，不能浏览详细信息！！！");
<%
response.sendRedirect("login.jsp");
%>
</script>
<%}
%><jsp:include page="top.jsp"/>
<table width="786" height="137" border="1" align="center" cellpadding="0" cellspacing="0"bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#333333">
  <tr>
  <td width="786" colspan="9" height="60">
      <p align="center">车辆信息
  </td>
  </tr>
  <tr>
    <td width="786" height="30" colspan="9" align="right">

   <a href="car_add.jsp">发布信息...</a></td>
  </tr>
  <tr>
    <td width="11%" height="29" align="center">车牌号码</td>
   <td width="11%" height="29" align="center">车辆品名</td>
   <td width="11%" height="29" align="center">类型</td>
    <td width="11%" height="29" align="center">车辆限量</td>
    <td width="11%" height="29" align="center">已使用</td>
    <td width="11%" height="29" align="center">驾驶员驾龄</td>
    <td width="11%" height="29" align="center">运输类型</td>
    <td width="12%" height="29">
   <p align="center">操作</td>
</tr>
    <%
    sql="select * from tb_CarMessage order by IssueDate desc";
try
{
 rs=connection.executeQuery(sql);
if(!rs.next())
{
%>
<script language="javascript">
	alert("没有空车信息！！");
</script>
<%
}else
{
rs.last();
rowcount=rs.getRow();
int showpage=1;
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
n=rs.getInt("Code");
%>
<tr>
<td width="11%" height="29" align="center"><%=rs.getString("TradeMark")%></td>
<td width="11%" height="29" align="center"><%=rs.getString("Brand")%></td>
<td width="11%" height="29" align="center"><%=rs.getString("Style")%></td>
<td width="11%" height="29" align="center"><%=rs.getString("CarLoad")%>吨</td>
<td width="11%" height="29" align="center"><%=rs.getString("UsedTime")%>年</td>
<td width="15%" height="29" align="center"><%=rs.getString("DriverTime")%>年</td>
<td width="11%" height="29" align="center"><%=rs.getString("TranspotStyle")%></td>
<td width="12%" height="29" align="center"><a href="car_show.jsp?id=<%=n%>">详细</a></td>
</tr>
<%
if(!rs.next())
break;
}
%>
<tr>
    <td width="786" height="30" colspan="9" align="right">

<table width="786" align="center" cellpadding="0" cellspacing="0">
	<tr>
    <td width="786" height="30" colspan="9" align="right">
    共<%=pagecount%>页&nbsp;&nbsp;
        <a href="car_select.jsp?topage=<%=1%>">第一页</a>&nbsp;&nbsp;
        <a href="car_select.jsp?topage=<%=showpage-1%>">上一页</a>&nbsp;&nbsp;
        <a href="car_select.jsp?topage=<%=showpage+1%>">下一页</a>&nbsp;&nbsp;
        <a href="car_select.jsp?topage=<%=pagecount%>">最后一页</a>
  
</td>
</tr>
</table>
</td>
  </tr>
<%
}

}catch(Exception e)
{e.printStackTrace();System.out.println("carmessageage");}
%>
</table>
</body>
</html>
