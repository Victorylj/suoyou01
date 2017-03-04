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
$(document).ready(function() {
	$("#selectFEECODEID").change(function(){
		//alert($("#selectFEECODEID").find("option:selected").text());
		$("#selectFEECODENAME").val($("#selectFEECODEID").find("option:selected").text());
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
    <form action="addSpCommand.do" method="post">
    <ul class="forminfo">
    <c:if test="${paramObj.command_id >0 }">
    	<li>
    		<input name="feecode_id" value="${paramObj.feecode_id }" type="hidden" ></input>
    		<label>计费代码</label><input name="feecode_name" value="${paramObj.feecode_name }" type="text" class="dfinput"></input>
    		</li>
    </c:if>
     <c:if test="${ empty paramObj.command_id}">
     <li><label>计费代码</label>
     	<input id="selectFEECODENAME" name="feecode_name" value="" type="hidden" ></input>
    	 <select id="selectFEECODEID" name="feecode_id" class="select3">
                <option value="">请选择</option>
                <c:forEach items="${feecodeList}" var="feecode">
                <option value="${feecode.feecode_id}" >${feecode.feecode_name}</option>
                </c:forEach>
         </select>
    </li>
     </c:if>
     
    <li>
    <input name="command_id" value="${paramObj.command_id }" type="hidden" ></input>
    <label>指令</label><input name="command"  value="${paramObj.command }" type="text" class="dfinput" /><i>指令</i>
    </li>
        <li>
    <label>指令长度</label><input name="command_length"  value="${paramObj.command_length }" type="text" class="dfinput" /><i>指令长度</i>
    </li>
     <li>
    <label>指令费用</label><input name="command_fee"  value="${paramObj.command_fee }" type="text" class="dfinput" /><i>指令费用，单位（分）</i>
    </li>
    
     <li>
    <label>指令类型</label>
         <select  name="command_type" class="select3">
        		<c:if test="${empty paramObj.command_type  }">
                <option  value="0" selected="selected" >精确</option>
                <option  value="1" >模糊</option>
                </c:if>
               <c:if test="${paramObj.command_type eq 0 }">
                <option  value="0" selected="selected" >精确</option>
                <option  value="1" >模糊</option>
                </c:if>
                  <c:if test="${paramObj.command_type eq 0 }">
                <option  value="0" >精确</option>
                <option  value="1" selected="selected"  >模糊</option>
                </c:if>
         </select>
    </li>

    <li><label>备注</label><textarea name="remarks"  cols="" rows="" class="textinput">${paramObj.remarks }</textarea></li>
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
