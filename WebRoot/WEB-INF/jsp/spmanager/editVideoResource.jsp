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
$(document).ready(function() {
	$("#selectFEECODEID").change(function(){
		//alert($("#selectFEECODEID").find("option:selected").text());
		$("#selectFEECODENAME").val($("#selectFEECODEID").find("option:selected").text());
	});
	$(".select3").uedSelect({
			width : 187
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
    
    <div class="formtitle"><span>上游公司信息</span></div>
    <form action="addVideoResource.do" method="post">
    <ul class="forminfo">
    <c:if test="${paramObj.id >0 }">
    	<li>
    		<input name="feecode_id" value="${paramObj.feecode_id }" type="hidden" ></input>
    		<label>计费代码</label><input name="feecode_name" value="${paramObj.feecode_name }" type="text" class="dfinput"></input>
    		</li>
    </c:if>
     <c:if test="${ empty paramObj.id}">
     <li><label>计费代码</label>
     <label>
     	<input id="selectFEECODENAME" name="feecode_name" value="" type="hidden" ></input>
    	 <select id="selectFEECODEID" name="feecode_id" class="select3">
                <option value="">请选择</option>
                <c:forEach items="${feecodeList}" var="feecode">
                <option value="${feecode.feecode_id}" >${feecode.feecode_name}</option>
                </c:forEach>
         </select>
         </label>
    </li>
     </c:if>
     
    <li>
    <input name="id" value="${paramObj.id }" type="hidden" ></input>
    <label>视频名称</label><input name="video_name"  value="${paramObj.video_name }" type="text" class="dfinput" /><i></i>
    </li>
        <li>
    <label>视频编码</label><input name="video_code"  value="${paramObj.video_code }" type="text" class="dfinput" /><i></i>
    </li>
     <li>
    <label>渠道ID</label><input name="channelid"  value="${paramObj.channelid }" type="text" class="dfinput" /><i></i>
    </li>
    
     <li>
    <label>访问URL</label>
        <textarea name="access_url"  cols="" rows="" class="textinput">${paramObj.access_url }</textarea>
    </li>

    <li><label>备注</label><textarea name="remarks"  cols="" rows="" class="textinput">${paramObj.remarks }</textarea></li>
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
