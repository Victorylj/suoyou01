<%@ page language="java" import="java.sql.*, com.sky.blue.comm.page.*" %>
<%@ page contentType="text/html; charset=gb2312" %>
<jsp:useBean id="pq" scope="page" class="com.sky.blue.comm.page.PageQuery" />
<html>

<body bgcolor="#8BA9C9">
<table bgcolor="#fecda9" cellspacing=0>
<% 

String query = "SELECT * FROM user";   // 注意这个" FROM "一定要大写，程序中需要靠这个FROM后的query语句判断总行数。        
ResultSet rs = pq.myQuery(query, request);
String bar = pq.PageLegend();  //读取分页提示栏

out.println("<tr><td colspan=2>"+bar+"</td></tr>");
out.println("<tr><td colspan=2><hr size=1 color=blue></td></tr>");
while (rs.next())  { 
//说明：rs.getString(2)等是列名相对应的位置，不要用rs.getString("colmn_name")这种形式
%> 
<tr><td><%=rs.getString(1)%></td><td><%=rs.getString(2)%></td></tr>
<% } 
rs.close();
pq.close();
%>
</table>
</body>
</html>
