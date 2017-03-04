<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>sdk计费平台</title>
<script type="text/javascript">
	function updPassward() {
		window.frames["rightFrame"].updpw("修改密码");

	}
</script>
</head>
<frameset rows="33,*" cols="*" frameborder="no" border="0" framespacing="0">
	<frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
	<frameset cols="187,*" frameborder="no" border="0" framespacing="0">
		<frame src="left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="default.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
	</frameset>
</frameset>
<!-- <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
	<frame src="left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
	<frame src="default.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
</frameset> -->
<noframes>
	<body>
	</body>
</noframes>
</html>
