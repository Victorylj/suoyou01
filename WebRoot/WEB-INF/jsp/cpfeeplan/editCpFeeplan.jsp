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
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>扣费方案，用作绑定到计费点</span></div>
    <form action="addCpFeeplan.do" method="post">
    <ul class="forminfo">
    <li>
    <input name="feeplan_id" value="${paramObj.feeplan_id }" type="hidden" ></input>
    <label>扣费方案名称</label><input name="feeplan_name" value="${paramObj.feeplan_name }" type="text" class="dfinput" />
    <i>名称举例：四元计费方案一，二元计费方案二 等。（一个计费点绑定一个方案，一个方案下的措施绑定一组计费项）</i>
    </li>
    <li><label>扣费方案编码</label><input name="feeplan_code"  value="${paramObj.feeplan_code }" type="text" class="dfinput" />
    <i>一般为大写字符组合，唯一即可，长度不超过20</i></li>
    <li><label>联网类型</label><label>
        <select  name="net_type" class="select3">
        		<c:if test="${empty paramObj.net_type  }">
                <option  value="1"  >NET</option>
                <option  value="2" selected="selected">wap</option>
                </c:if>
               <c:if test="${paramObj.net_type eq 1 }">
                <option  value="1" selected="selected" >NET</option>
                <option  value="2" >wap</option>
                </c:if>
                  <c:if test="${paramObj.net_type eq 2 }">
                <option  value="1" >NET</option>
                <option  value="2" selected="selected"  >wap</option>
                </c:if>
         </select></label>
    <li><label>方案费用</label><input name="feeplan_fee"  value="${paramObj.feeplan_fee }" type="text" class="dfinput" />
    <i>单位：分</i></li>
       <li><label>备注</label><input name="remarks"  value="${paramObj.remarks }" type="text" class="dfinput" /><i></i></li>
    
    
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
