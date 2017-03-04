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
    <li><a href="#">模块</a></li>
    <li><a href="#">模块修改</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>模块</span></div>
    <form action="addModule.do" method="post">
    <ul class="forminfo">
    <li>
    <input name="module_id" value="${paramObj.module_id }" type="hidden" ></input>
    <label>模块名称</label><input name="Module_name" value="${paramObj.module_name }" type="text" class="dfinput" /><i></i></li>
    <li><label>访问路径</label><input name="module_path" value="${paramObj.module_path }" type="text" class="dfinput" /><i></i></li>
    <li><label>访问url</label><input name="module_url" value="${paramObj.module_url }" type="text" class="dfinput" /><i></i></li>
    
    	<c:if test="${ empty paramObj.parent_id }">
    	<li><label>父模块</label>
    		<input name="parent_id" value="${paramObj.parent_id }" type="text" class="dfinput" /><i></i>
    		   </li>
    		   	<li> <label>是否叶节点</label><input name="is_leaf" value="${paramObj.is_leaf }" type="text" class="dfinput" /><i></i></li>
   			<li> <label>显示顺序</label><input name="display_order" value="${paramObj.display_order }" type="text" class="dfinput" /><i></i></li>
 <li> <label>显示顺序</label><input name="p_id" value="${paramObj.p_id }" type="text" class="dfinput" /><i></i></li>
 
    	</c:if>
    	<c:if test="${ !empty paramObj.parent_id }">
    	<li><label>父模块</label>
    		<input name="parent_id" value="${paramObj.parent_id }" type="hidden" class="dfinput" /><i></i>
    		<label>${ paramObj.parent_name }</label>
    		   </li>
    		<li> <label>是否叶节点</label><input name="is_leaf" value="${paramObj.is_leaf }" type="hidden" class="dfinput" /><label>${ paramObj.is_leaf }</label></li>
   			<li> <label>显示顺序</label><input name="display_order" value="${paramObj.display_order }" type="hidden" class="dfinput" /><label>${ paramObj.display_order }</label></li>
     		<li> <label>分组</label><input name="p_id" value="${paramObj.p_id }" type="hidden" class="dfinput" /><label>${ paramObj.p_id }</label></li>
     
    	</c:if>
 
    
       
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
