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
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".select3").uedSelect({
			width : 100
	});
});
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">权限管理</a></li>
    <li><a href="#">用户管理</a></li>
    <li><a href="#">修改</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>上游公司信息</span></div>
    <form action="addUser.do" method="post">
    <ul class="forminfo">
    <li>
    <input name="userId" value="${paramObj.userId }" type="hidden" ></input>
    <label>用户名</label><input name="userName" value="${paramObj.userName }" type="text" class="dfinput" /><i></i></li>
    <li><label>账号</label><input name="account" value="${paramObj.account }" type="text" class="dfinput" /><i></i></li>
 
    <li><label>密码</label><input name="password"  value="${paramObj.password }" type="text" class="dfinput" /><i></i></li>
    <li><label>用户组</label><label>
    	 <select name="group_id" class="select3">
                <option value="">请选择</option>
                <c:forEach items="${groupList}" var="g">
                <option  value="${g.group_id}"  <c:if test="${paramObj.group_id == g.group_id}">selected="selected"</c:if> > ${g.group_name } </option>
                </c:forEach>
         </select></label>
         
    </li>
    
     <li><label>角色</label>
    <c:forEach items="${roleList}" var="role">
    <c:set var="refstr" value=",${paramObj.ref_roles},"></c:set>  
   		<c:set var="idstr" value=",${ role.role_id},"></c:set> 
       <input id="module${ role.role_id}"  type="checkbox" style="vertical-align:middle;" name="roles" value="${role.role_id}" 
       <c:if test="${fn:contains(refstr,idstr)==true}">
       	checked="checked"
       </c:if> >
       ${role.role_name}
       </input>
    </c:forEach>
    <i></i></li>
    
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
