<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">权限管理</a></li>
    <li><a href="#">用户组</a></li>
    <li><a href="#">用户组修改</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>用户组</span></div>
    <form action="addGroup.do" method="post">
    <ul class="forminfo">
    <li>
    <input name="group_id" value="${paramObj.group_id }" type="hidden" ></input>
    <label>用户组</label><input name="group_name" value="${paramObj.group_name }" type="text" class="dfinput" /><i></i></li>    
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
