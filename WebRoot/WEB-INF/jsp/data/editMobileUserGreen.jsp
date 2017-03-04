<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>

<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=blue"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
</head>

<body>
    <div class="formbody">
    
    <div class="formtitle"><span>绿名单信息</span></div>
    <form action="updMobileUserGreen.do" method="post">
    <ul class="forminfo">
    <li>
       <input name="id" value="${paramObj.id }" type="hidden" ></input>
       <label>手机号码</label><input name="mobile" value="${paramObj.mobile }" type="text" class="dfinput" />
    </li>
    <li>
       <label>手机imsi</label><input name="imsi" value="${paramObj.imsi }" type="text" class="dfinput" />
    </li>
     <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
