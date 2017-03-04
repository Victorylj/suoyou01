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
	$("#selectCPID").change(function(){
		//alert($("#selectCPID").find("option:selected").text());
		$("#selectCPNAME").val($("#selectCPID").find("option:selected").text());
	});
	$(".select3").uedSelect({
			width : 176
	});
});

function checkForm(){

	var product_id =$("#product_id").val(); 
	var product_name = $("#product_name").val();
	alert("进入检测函数"+ product_name);
	if(product_id == null || product_id ==''){
		$.post("checkproductname.do",{"product_name":product_name},function(result){
				if(result =="ok"){
					$("form").submit();
				}else if(result == "product_name"){
					alert("产品名称已经存在");
					return false;
				}
		});
	}else{
		$("form").submit();
	}
	

	return false;
}

function doChecked(){
	if($("#pro99").attr("checked")==true){
		$("input[name='province']").each(function(){
	  		 $(this).attr("checked",true);
	  	});  
	}else{
		$("input[name='province']").each(function(){
	  		 $(this).attr("checked",false);
	  	}); 
	}
}

function choose(x){
	if(x=='0'){
		$("input[name='province']").each(function(){
	  		 $(this).attr("checked",false);
	  	}); 
	}
}

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
    
    <div class="formtitle"><span>产品</span></div>
    <form action="addCpProduct.do" method="post">
    <ul class="forminfo">
    <c:if test="${paramObj.product_id >0 }">
						<li><input name="cp_id" value="${paramObj.cp_id }"
							type="hidden"></input> <label>产品公司</label><input
							name="cp_name" value="${paramObj.cp_name }" type="text"
							class="dfinput"></input></li>
					</c:if>
					<c:if test="${ empty paramObj.product_id}">
						<li><label>产品公司</label><label> <input id="selectCPNAME"
							name="cp_name" value="" type="hidden"></input> <select
							id="selectCPID" name="cp_id" class="select3">
								<option value="">请选择</option>
								<c:forEach items="${cpList}" var="cp">
									<option value="${cp.cp_id}">${cp.cp_name}</option>
								</c:forEach>
						</select></label></li>
					</c:if>
     
    <li>
    <input id="product_id" name="product_id" value="${paramObj.product_id }" type="hidden" ></input>
    <label>产品名称</label><input id="product_name" name="product_name"  value="${paramObj.product_name }" type="text" class="dfinput" />
    <i></i>
    </li>
    <li>
    <label>产品编码</label><input name="product_code"  value="${paramObj.product_code }" type="text" class="dfinput" />
    <i>一般大写字母组合，唯一即可，长度不超过20</i>
    </li>
     <li>
    <label>产品程序包</label><input name="product_package"  value="${paramObj.product_package }" type="text" class="dfinput" />
    <i>包名，由技术提供</i>
    </li>
     <li>
    <label>产品费用</label><input name="product_fee"  value="${paramObj.product_fee }" type="text" class="dfinput" /><i></i>
    </li>
      <li>
    <label>是否外放sdk</label><label>
      <select  name="is_overfee" class="select3">
        		<c:if test="${empty paramObj.is_overfee  }">
                <option  value="0" >是</option>
                <option  value="1"  selected="selected">否</option>
                </c:if>
               <c:if test="${paramObj.is_overfee eq 0 }">
                <option  value="0" selected="selected" >是</option>
                <option  value="1" >否</option>
                </c:if>
                  <c:if test="${paramObj.is_overfee eq 1 }">
                <option  value="0" >是</option>
                <option  value="1" selected="selected"  >否</option>
                </c:if>
         </select></label>
    <i></i>
    </li>
         <li>
    <label>是否弹框</label><label>
      <select  name="is_pop" class="select3" onchange="choose(this.options[this.options.selectedIndex].value)" >
        		<c:if test="${empty paramObj.is_pop  }">
                <option  value="1" >是</option>
                <option  value="0"  selected="selected">否</option>
                </c:if>
               <c:if test="${paramObj.is_pop eq 1 }">
                <option  value="1" selected="selected" >是</option>
                <option  value="0" >否</option>
                </c:if>
                  <c:if test="${paramObj.is_pop eq 0 }">
                <option  value="1" >是</option>
                <option  value="0" selected="selected"  >否</option>
                </c:if>
         </select></label>
    <i></i>
    </li>
    
          <li>
    <label>指定弹框省份</label>
    

          <c:forEach items="${proList}" var="pro">
       <input type="checkbox" name="province" value="${pro.province_id}" 
       <c:if test="${fn:contains(paramObj.provincestr,pro.province_id)==true}">checked="checked"</c:if>  
   		 />${pro.province_name}
   		 
    </c:forEach>
    ---<input type="checkbox" onclick="doChecked();" id="pro99"/>全选

    <i> 
		如需分省份弹框，请勾选相应省份。
     </i>
    </li>
    
    
    <li><label>备注</label><textarea name="remarks"  cols="" rows="" class="textinput">${paramObj.remarks }</textarea></li>
      <li><label>&nbsp;</label><input  type="button" class="btn" value="确认保存" onclick="checkForm()"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
