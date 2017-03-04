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
	$("#selectCPID").change(function(){
		//alert($("#selectCPID").find("option:selected").text());
		$("#selectCPNAME").val($("#selectCPID").find("option:selected").text());
	});
	$(".select3").uedSelect({
			width : 129
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
    
    <div class="formtitle"><span>扣费方案</span></div>
    <form action="addCpFeemeasure.do" method="post">
    <ul class="forminfo">
    <c:if test="${paramObj.feemeasure_id >0 }">
						<li><input name="feeplan_id" value="${paramObj.feeplan_id }"
							type="hidden"></input> <label>扣费方案</label><input
							name="feeplan_name" value="${paramObj.feeplan_name }" type="text"
							class="dfinput"></input></li>
					</c:if>
					<c:if test="${ empty paramObj.feemeasure_id}">
						<li><label>渠道名称</label><label> <input id="selectCPNAME"
							name="feeplan_name" value="" type="hidden"></input> 
							<select
							id="selectCPID" name="feeplan_id" class="select3">
								<option value="">请选择</option>
								<c:forEach items="${feeplanList}" var="feeplan">
									<option value="${feeplan.feeplan_id}">${feeplan.feeplan_name}</option>
								</c:forEach>
						</select></label></li>
					</c:if>
     
    <li>
    <input name="feemeasure_id" value="${paramObj.feemeasure_id }" type="hidden" ></input>
    <label>措施名称</label><input name="feemeasure_name"  value="${paramObj.feemeasure_name }" type="text" class="dfinput" />
    <i>名称举例：四元扣费方案一措施(移动) ，括号里的运营商一定要标，每个方案按运营商分有三种措施</i>
    </li>
    <li>
    <label>运营商</label><label>
      <select  name="feemeasure_op" class="select3">
        		<c:if test="${empty paramObj.feemeasure_op  }">
                <option  value="1" selected="selected" >移动</option>
                <option  value="2" >联通</option>
                <option  value="3" >电信</option>
                </c:if>
               <c:if test="${paramObj.feemeasure_op eq 1 }">
                <option  value="1" selected="selected" >移动</option>
                <option  value="2" >联通</option>
                <option  value="3" >电信</option>
                </c:if>
                  <c:if test="${paramObj.feemeasure_op eq 2 }">
                <option  value="1" >移动</option>
                <option  value="2" selected="selected" >联通</option>
                <option  value="3" >电信</option>
                </c:if>
                  <c:if test="${paramObj.feemeasure_op eq 3 }">
                <option  value="1" >移动</option>
                <option  value="2"  >联通</option>
                <option  value="3" selected="selected">电信</option>
                </c:if>
         </select></label>
         <i></i>
    </li>
     <li>
    <label>是否弹窗</label><label>
      <select  name="feemeasure_is_pop" class="select3">
        		<c:if test="${empty paramObj.feemeasure_is_pop  }">
                <option  value="1" selected="selected" >是</option>
                <option  value="0" >否</option>
                </c:if>
               <c:if test="${paramObj.feemeasure_is_pop eq 1 }">
                <option  value="1" selected="selected" >是</option>
                <option  value="0" >否</option>
                </c:if>
                  <c:if test="${paramObj.feemeasure_is_pop eq 0 }">
                <option  value="1" >是</option>
                <option  value="0" selected="selected"  >否</option>
                </c:if>
         </select></label>
         <i></i>
    </li>
     <li>
    <label>措施费用</label><input name="feemeasure_fee"  value="${paramObj.feemeasure_fee }" type="text" class="dfinput" />
    <i>单位：分</i>
    </li>
    <!-- 
      <li>
    <label>省</label><input name="feemeasure_province"  value="${paramObj.feemeasure_province }" type="text" class="dfinput" /><i></i>
    </li>
     <li>
    <label>市</label><input name="feemeasure_city"  value="${paramObj.feemeasure_city }" type="text" class="dfinput" /><i></i>
    </li>
     -->
    <li><label>备注</label><textarea name="remarks"  cols="" rows="" class="textinput">${paramObj.remarks }</textarea></li>
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
