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
    
    <div class="formtitle"><span>特殊计费点控制</span></div>
    <form action="addDataDictionary.do" method="post">
    <input name="id" value="${paramObj.id }" type="hidden" ></input>
    <ul class="forminfo">
     <c:if test="${empty paramObj.id }">
    <li>
    <label>接收状态</label>
    	<input type="radio" name="code"  value="1" />成功
    	<input type="radio" name="code"  value="0" />失败
    </li>
    <li>
    <label>开关</label>
   	 <input type="radio" name="swtichs" value="1" />打开
   	 <input type="radio" name="swtichs" value="0" />关闭
    </li>
    <li>
    <label>全部放开</label>
   	 <input type="radio" name="isall" value="1" />全部放开
   	 <input type="radio" name="isall" value="0" />部分放开
    </li>
    
    </c:if>
    <c:if test="${!empty paramObj.id  }">
    	<c:if test="${paramObj.code ==1 }">
    		<li>
    		<label>接收状态</label>
    		<input type="radio" name="code"  value="1" checked="checked"/>成功
    		<input type="radio" name="code"  value="0" />失败
    		</li>
    	</c:if>
    	<c:if test="${paramObj.code ==0 }">
    		<li>
    		<label>接收状态</label>
    		<input type="radio" name="code"  value="1" />成功
    		<input type="radio" name="code"  value="0" checked="checked"/>失败
    		</li>
    	</c:if>
    	<c:if test="${paramObj.swtichs ==1 }">
    		<li>
    		<label>总开关</label>
    		<input type="radio" name="swtichs" value="1" checked="checked"/>打开
    		<input type="radio" name="swtichs" value="0" />关闭
    		</li>
    	</c:if>
    	<c:if test="${paramObj.swtichs ==0 }">
    		<li>
    		<label>总开关</label>
    		<input type="radio" name="swtichs" value="1" />打开
    		<input type="radio" name="swtichs" value="0" checked="checked"/>关闭
    		</li>
    	</c:if>
    	<c:if test="${paramObj.isall ==1 }">
    		<li>
    		<label>开放控制</label>
    		<input type="radio" name="isall" value="1" checked="checked"/>全部放开
    		<input type="radio" name="isall" value="0" />部分放开
    		</li>
    	</c:if>
    	<c:if test="${paramObj.isall ==0 }">
    		<li>
    		<label>开放控制</label>
    		<input type="radio" name="isall" value="1" />全部放开
    		<input type="radio" name="isall" value="0" checked="checked"/>部分放开
    		</li>
    	</c:if>
    	
    </c:if>
    <li>
    <label>访问时间间隔</label><input name="time"  value="${paramObj.time }" type="text" class="dfinput" /><i></i>
    </li>
    <li>
    <label>每天访问最大次数</label><input name="daymaxdata"  value="${paramObj.daymaxdata }" type="text" class="dfinput" /><i></i>
    </li>
    <li>
    <label>每月访问最大次数</label><input name="monthmaxdata"  value="${paramObj.monthmaxdata }" type="text" class="dfinput" /><i></i>
    </li>
    <li>
    <label>每月最多扣费次数</label><input name="paydata"  value="${paramObj.paydata }" type="text" class="dfinput" /><i></i>
    </li>
    <li>
    <label>计费点</label><input name="appf_id"  value="${paramObj.appf_id}" type="text" class="dfinput" /><i></i>
    </li>

    <li>
    <label>渠道id</label><textarea name="cpids" class="textinput"  >${paramObj.cpids }</textarea><i></i>
    </li>
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
