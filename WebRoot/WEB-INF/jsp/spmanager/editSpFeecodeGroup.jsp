<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
</head>

<body >
    <div class="formbody" style="width:600px;">
    <div class="formtitle"><span>分组信息</span></div>
    <form action="addSpFeecodeGroup.do" method="post" onsubmit="return check()">
    		<input id="g_id" name="g_id" type="hidden" value=""/>
			<ul class="forminfo">
				<li><label>分组名称</label><input id="g_name" name="g_name" type="text" maxlength="50" class="dfinput"
							class="df_input" /><i style="color:red;">*</i></li>
				<li><label>运营商</label><div style="padding-top:10px;" ><input name="g_op" type="radio" checked="checked" value="1"/>移动
										&nbsp;&nbsp;<input name="g_op" type="radio" value="2"/>联通
										&nbsp;&nbsp;<input name="g_op" type="radio" value="3"/>电信</div></li>
				<li><label>时间间隔</label><input id="g_interval" name="g_interval" type="text" maxlength="6" onkeyup="this.value=this.value.replace(/\D/g,'');" class="dfinput"
							class="df_input" /><i>(秒)</i></li>
				<li><label>备注</label><input id="remarks" name="remarks" type="text" maxlength="100" class="dfinput"
							class="df_input" /><i></i></li>
				<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="确认保存" /></li>
			</ul>
	</form>
    </div> 
</body>
</html>
