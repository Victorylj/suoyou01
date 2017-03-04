<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

</script>

</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>优先级分配信息</span></div>
    <form action="addAutoLevelRatio.do" method="post">
      <input name="id" value="${paramObj.id }" type="hidden" ></input>
      <input name="create_name"  value="${sessionScope.curUser.userName }" readonly="readonly" type="hidden" class="dfinput" />
    <ul class="forminfo">
     
    <li>
    <label>优先等级</label><input name="level"  value="${paramObj.level }" type="text" class="dfinput" /><i>优先等级必须是在1~10之间</i>
    </li>
    <li>
    <label>比例</label><input name="ratio"  value="${paramObj.ratio }" type="text" class="dfinput" /><i>比例必须是在1~100之间</i>
    </li>
    <li>
    </li>  
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
