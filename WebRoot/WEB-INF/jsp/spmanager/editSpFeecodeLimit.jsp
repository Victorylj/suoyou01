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
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#sp").change(function(){
		$("#feecode_id").empty();
			$("#feecode_id").append($("<option/>").text("请选择").attr("value",''));
			var sp_id = $(this).val();
			$.ajax({
                type:'post',
                url: 'getSpFeecodeList.do',
                data:'sp_id='+sp_id,
                dataType:'json',
                success:function(result){
                	$.each(result,function(n,val){
                		var feecode_id= val.feecode_id;
                    	var feecode_number=val.feecode_number;
                    	var feecode_op=val.feecode_op;
                    	var feecode_name=val.feecode_name;
                        $("#feecode_id").append($("<option/>").text(feecode_number+"-"+feecode_op+"-"+feecode_name).attr("value",feecode_id));
                	});
                	//$("#selectP").val('');
                	
                },
                error:function(){
                    alert("failed.");
                }
            });
	});
	$(".select3").uedSelect({
			width : 290
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
    <form action="addSpFeecodeLimit.do" method="post">
    <ul class="forminfo">
    <c:if test="${paramObj.limit_id >0 }">
    <li>
    		<input name="feecode_id" value="${paramObj.feecode_id }" type="hidden" ></input>
    		<label>计费代码名称</label><input name="feecode_name" value="${paramObj.feecode_name }" type="text" class="dfinput"></input>
    		</li>
    </c:if>
        <c:if test="${ empty paramObj.limit_id}">
        
         <li><label>上游公司</label>
     	 <label>
    	 <select id="sp"  class="select3">
                <option value="">请选择</option>
                <c:forEach items="${companyList}" var="spc">
                <option  value="${spc.sp_id}" >${spc.sp_name}</option>
                </c:forEach>
         </select></label>
    </li>
    <li><label>计费代码</label>
 <label>
    	 <select id="feecode_id" name="feecode_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c:forEach items="${feecodeList}" var="feecode">
                			 <option value="${feecode.feecode_id}" <c:if test="${searchObj.feecode_id eq feecode.feecode_id}">selected="selected"</c:if> >${feecode.feecode_name}(${feecode.feecode_number})</option>
                		    </c:forEach>
          </select></label>
    </li>
    </c:if>

    

    <li><input name="limit_id" value="${paramObj.limit_id }" type="hidden" ></input>
    <label>总日限</label><input name="day_num"  value="${paramObj.day_num }" type="text" class="dfinput" /><i>单位:元</i></li>
    <li><label>总月限</label><input name="month_num"  value="${paramObj.month_num }" type="text" class="dfinput" /><i>单位：元</i></li>
    
    <li><label>单用户日限</label><input name="single_day_num"  value="${paramObj.single_day_num }" type="text" class="dfinput" /><i>单位：元</i></li>
    <li><label>单用户月限</label><input name="single_month_num"  value="${paramObj.single_month_num }" type="text" class="dfinput" /><i>单位：元</i></li>
    <!-- 
    <li><label>屏蔽省份</label>
    <c:forEach items="${proList}" var="pro">
       <input type="checkbox" name="province" value="${pro.province_id}" <c:if test="${fn:contains(paramObj.limit_province,pro.province_id)==true}">checked="checked"</c:if> >${pro.province_name}</input>
    </c:forEach>
    <i></i></li>
    <li><label>屏蔽地市</label><input name="limit_city"  value="${paramObj.limit_city }" type="text" class="dfinput" /><i></i></li>
     -->
     <li><label>屏蔽日期段</label><input name="limit_time_str"  value="${paramObj.limit_time_str }" type="text" class="dfinput" /><i>例如，7号到15号不放量，格式为：7-15</i></li>
    <li><label>屏蔽小时段</label><input name="limit_hour_str"  value="${paramObj.limit_hour_str }" type="text" class="dfinput" /><i>例如，0点到7点不放量，格式：0-7,23点到第二天7点不放量，格式：23-7</i></li>
   
    <li><label>备注</label><input name="remarks"  value="${paramObj.remarks }" type="text" class="dfinput" /><i></i></li>
    
    
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
