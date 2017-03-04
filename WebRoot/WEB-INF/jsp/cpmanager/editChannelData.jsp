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
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".select3").uedSelect({
			width : 253
	});
});
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
    
    <div class="formtitle"><span>添加渠道查询数据</span></div>
    <form action="addChannelData.do" method="post">
    <ul class="forminfo">
  
	 <c:if test="${paramObj.ch_data_id  >0 }">
						<li><input name="ch_data_id" value="${paramObj.ch_data_id }"
							type="text"></input> <label>渠道名称</label>
							<label><select id="ch_id" name="ch_id" class="select3">
								<option value="">请选择</option>
								<c:forEach items="${chList}" var="ch">
									<option value="${ch.ch_id}" <c:if test="${paramObj.ch_id == ch.ch_id}">selected='selected'</c:if>>${ch.ch_name}(${ch.ch_id})</option>
								</c:forEach>
						</select></label></li>
					</c:if>
					<c:if test="${ empty paramObj.ch_data_id}">
						<li><label>渠道名称</label><label><select
							id="ch_id" name="ch_id" class="select3">
								<option value="">请选择</option>
								<c:forEach items="${chList}" var="ch">
									<option value="${ch.ch_id}" >${ch.ch_name}(${ch.ch_id})</option>
								</c:forEach>
						</select></label></li>
					</c:if>
									
    <li><label>安装数</label><input name="data_init"  value="${paramObj.data_init }" type="text" class="dfinput" /><i></i></li>
    <li><label>激活数（返回协议）</label><input name="data_ret"  value="${paramObj.data_ret }" type="text" class="dfinput" /><i></i></li>
   <li><label>充值金额</label><input name="data_fee"  value="${paramObj.data_fee }" type="text" class="dfinput" /><i></i></li>
    <li><label>分成金额</label><input name="data_div"  value="${paramObj.data_div }" type="text" class="dfinput" /><i></i></li>
     <li><label>时间</label><input name="dater" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput" value="${paramObj.dater }"/></li>	

    
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
