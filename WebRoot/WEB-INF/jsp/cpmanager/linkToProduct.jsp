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
    
    <div class="formtitle"><span>关联产品</span></div>
    <form action="addLinkToProduct.do" method="post">
    <ul class="forminfo">
    <li>
    <input name="ch_id" value="${paramObj.ch_id }" type="hidden" ></input>
    <label>渠道</label><input name="ch_name" value="${paramObj.ch_name }" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
	  <li><label>推广产品</label>
	    <c:forEach items="${prodList}" var="prod">
	       <input type="checkbox" name="product_id" value="${prod.product_id}" >${prod.product_name}</input>
	    </c:forEach>
	    <i></i></li>
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
