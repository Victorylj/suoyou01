<%@ page language="java" import="java.sql.*, com.sky.blue.comm.page.*" %>
<%@ page contentType="text/html; charset=gb2312" %>
<jsp:useBean id="pq" scope="page" class="com.sky.blue.comm.page.PageQuery" />
<html>

<body bgcolor="#8BA9C9">
<table bgcolor="#fecda9" cellspacing=0>
<% 

String query = "SELECT * FROM user";   // ע�����" FROM "һ��Ҫ��д����������Ҫ�����FROM���query����ж���������        
ResultSet rs = pq.myQuery(query, request);
String bar = pq.PageLegend();  //��ȡ��ҳ��ʾ��

out.println("<tr><td colspan=2>"+bar+"</td></tr>");
out.println("<tr><td colspan=2><hr size=1 color=blue></td></tr>");
while (rs.next())  { 
//˵����rs.getString(2)�����������Ӧ��λ�ã���Ҫ��rs.getString("colmn_name")������ʽ
%> 
<tr><td><%=rs.getString(1)%></td><td><%=rs.getString(2)%></td></tr>
<% } 
rs.close();
pq.close();
%>
</table>
</body>
</html>
