<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>

<script type="text/javascript" src="js/logon/listRole.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">权限管理</a></li>
    <li><a href="#">角色管理</a></li>
    <li><a href="#">角色修改</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>用户组</span></div>
    <form action="addRole.do" method="post">
    <ul class="forminfo">
    <li>
    <input name="role_id" value="${paramObj.role_id }" type="hidden" ></input>
    <label>角色</label><input name="role_name" value="${paramObj.role_name }" type="text" class="dfinput" /><i></i></li>    
    <li><label>模块</label>
    <c:forEach items="${moduleList}" var="modu">
   		<c:set var="refstr" value=",${paramObj.ref_modules},"></c:set>  
   		<c:set var="idstr" value=",${ modu.module_id},"></c:set> 
   		
       <input id="module${ modu.module_id}" onclick="chooseModules(${ modu.module_id},${ modu.parent_id});" type="checkbox" style="vertical-align:middle;" name="modules" value="${modu.module_id}" <c:if test="${fn:contains(refstr,idstr)==true }">checked="checked"</c:if> >${modu.module_name}</input>
    </c:forEach>
    <i></i></li>
     
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
