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
<script type="text/javascript"  src="js/searchSelect.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#selectSPID").change(function(){
		//alert($("#selectSPID").find("option:selected").text());
		$("#selectSPNAME").val($("#selectSPID").find("option:selected").text());
	});
	
	$(".select3").uedSelect({
			width : 100
	});
	
	
	$("#searchSp").searchInit({
	 	searchObj:"searchSp", 
	 	searchText: "sp_name", 
	 	searchId: "sp_id", 
	 	result:"result", 
	 	searchUrl: "/seachCpCompanyList.do"
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
    <form action="addSpChannel.do" method="post">
    <ul class="forminfo">
    <c:if test="${paramObj.sp_channel_id >0 }">
    	<li>
    		<input name="sp_id" value="${paramObj.sp_id }" type="hidden" ></input>
    		<label>上游公司名称</label><input name="sp_name" value="${paramObj.sp_name }" type="text" class="dfinput"></input>
    		</li>
    </c:if>
     <c:if test="${ empty paramObj.sp_channel_id}">
     <li><label>上游公司</label><div class="vocation" id="searchSp">
    	<!--<input id="selectSPNAME" name="sp_name" value="" type="hidden" ></input> 
    	<select id="selectSPID" name="sp_id" class="select3">
                <option value="">请选择</option>
                <forEach items="{spList}" var="sp">
                <option value="{sp.sp_id}" >{sp.sp_name}</option>
                </forEach>
         </select> --> 
         
         <div class="select3">
               <input id="sp_name" name="sp_name" class="scinput" value="${empty searchObj.sp_name?'--请选择--': searchObj.sp_name}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        		<div id="result" style="position:absolute;display:none;top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
               <input id="sp_id" name="sp_id" type="hidden" value="${searchObj.sp_id}"/> 
        </div>
         </div>
    </li>
     </c:if>
     
    <li>
    <input name="sp_channel_id" value="${paramObj.sp_channel_id }" type="hidden" ></input>
    <label>频道名称</label><input name="sp_channel_name"  value="${paramObj.sp_channel_name }" type="text" class="dfinput" /><i></i>
    </li>
        <li>
    <label>频道IP</label><input name="sp_channel_ip"  value="${paramObj.sp_channel_ip }" type="text" class="dfinput" /><i></i>
    </li>
     <li>
    <label>上行地址</label><input name="sp_channel_mo_url"  value="${paramObj.sp_channel_mo_url }" type="text" class="dfinput" /><i></i>
    </li>
     <li>
    <label>下行地址</label><input name="sp_channel_mr_url"  value="${paramObj.sp_channel_mr_url }" type="text" class="dfinput" /><i></i>
    </li>
    <li><label>备注</label><textarea name="remarks"  cols="" rows="" class="textinput">${paramObj.remarks }</textarea></li>
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
