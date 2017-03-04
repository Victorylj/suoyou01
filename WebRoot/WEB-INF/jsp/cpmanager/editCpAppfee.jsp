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
	$("#selectPRPDUCTID").change(function(){
		//alert($("#selectPRPDUCTID").find("option:selected").text());
		$("#selectPRPDUCTNAME").val($("#selectPRPDUCTID").find("option:selected").text());
	});
	$(".select3").uedSelect({
			width : 140
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
    
    <div class="formtitle"><span>添加计费点</span></div>
    <form action="addCpAppfee.do" method="post">
    <ul class="forminfo">
    <c:if test="${paramObj.appfee_id >0 }">
						<li><input name="product_id" value="${paramObj.product_id }"
							type="hidden"></input> <label>产品名称</label><input
							name="product_name" value="${paramObj.product_name }" type="text"
							class="dfinput"></input></li>
					</c:if>
					<c:if test="${ empty paramObj.appfee_id}">
						<li><label>产品名称</label> <label><input id="selectPRPDUCTNAME"
							name="product_name" value="" type="hidden"></input> <select
							id="selectPRPDUCTID" name="product_id" class="select3">
								<option value="">请选择</option>
								<c:forEach items="${productList}" var="product">
									<option value="${product.product_id}">${product.product_name}</option>
								</c:forEach>
						</select></label></li>
					</c:if>
     
   
    <li>
     <input name="appfee_id" value="${paramObj.appfee_id }" type="hidden" ></input>
    <label>计费点名称</label><input name="appfee_name"  value="${paramObj.appfee_name }" type="text" class="dfinput" />
    <i></i>
    </li>
     <li>
    <label>计费点费用</label><input name="appfee_fee"  value="${paramObj.appfee_fee }" type="text" class="dfinput" /><i></i>
    </li>
     <li>
    <label>是否溢价</label><label>
      <select  name="appfee_isoverfee" class="select3">
        		<c:if test="${empty paramObj.appfee_isoverfee  }">
                <option  value="0" >是</option>
                <option  value="1" selected="selected"  >否</option>
                </c:if>
               <c:if test="${paramObj.appfee_isoverfee eq 0 }">
                <option  value="0" selected="selected" >是</option>
                <option  value="1" >否</option>
                </c:if>
                  <c:if test="${paramObj.appfee_isoverfee eq 1 }">
                <option  value="0" >是</option>
                <option  value="1" selected="selected"  >否</option>
                </c:if>
         </select></label>
    <i></i>
    </li>

    <li><label>备注</label><textarea name="remarks"  cols="" rows="" class="textinput">${paramObj.remarks }</textarea></li>
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
