<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sky.blue.business.logon.entity.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
background-color: #3893C7;
}
</style>
<script language="javaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	$("#updpw").click(function(){
		parent.window.updPassward();
	});
})	
</script>


</head>

<body>
	<div class="topright">
		<% 
     	User user = (User)session.getAttribute("curUser");
     	%>
		<ul>
			<li><a href="javascript:void(0);">欢迎您，<%=user.getUserName() %></a></li>
			<li><a id="updpw" href="#">修改密码</a></li>
			<li><a href="doLogout.do" target="_parent">退出</a></li>
		</ul>
	</div>
</body>
</html>
