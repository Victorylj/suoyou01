<%@page import="com.sky.blue.business.logon.entity.User"%>
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

$(function(){
	$(".select3").uedSelect({
		width : 345
	});
	
	 var cascade = function(obj){
	 	$.ajax({
	         type:'post',
	         url: 'searchSpFeecodeTow.do',
	         data:'pid='+obj.id,
	         dataType:'text',
	         success:function(result){
		         $("#searchCode").initData(result,{result:"result1", searchText: "feecode_number", searchId: "feecode_id"});
		       	 $("#command").val($("#result1").find("#"+$("#feecode_id").val()).attr("title"));
		       	 var yys = $("#result1").find("#"+$("#feecode_id").val()).attr("yys");
		       	 $("#opid").val(yys);
			 	 if(yys==1){
			 		$("#opname").html("移动");
			 	 }else if(yys==2){
			 		$("#opname").html("联通");
			 	 }else if(yys==3){
			 		$("#opname").html("电信");
			 	 }
			 },
	         error:function(){
	             alert("failed.");
	         }
	     });
	 }
	 
	 var codecascade = function (obj){
	 	$("#command").val(obj.title);
	 	$("#opid").val($(obj).attr("yys"));
	 	if($(obj).attr("yys")==1){
	 		$("#opname").html("移动");
	 	}else if($(obj).attr("yys")==2){
	 		$("#opname").html("联通");
	 	}else if($(obj).attr("yys")==3){
	 		$("#opname").html("电信");
	 	}
	 }
	
	 $("#searchSp").searchInit({searchObj:"searchSp", searchText: "sp_name", searchId: "sp_id", result:"result", searchUrl: "/seachCpCompanyList.do",defaultStr:false,cascade:cascade});
	 
	 $("#searchCode").searchInit({searchObj:"searchCode", pid:"sp_id", searchText: "feecode_number", searchId: "feecode_id", result:"result1", searchUrl: "/searchSpFeecodeTow.do",defaultStr:false,cascade:codecascade});
	
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
    
    <div class="formtitle"><span>新代码优先级分配信息</span></div>
    <form action="addAutoCmdLevel.do" method="post">
     <input name="id" value="${paramObj.id }" type="hidden" ></input>
     <input name="status" value="${paramObj.status }" type="hidden" ></input>
     <input name="create_name"  value="${sessionScope.curUser.userName }" readonly="readonly" type="hidden" class="dfinput" />
    <ul class="forminfo">
    <c:if test="${paramObj.id >0 }">
   	<li>
    <label>计费端口</label><input id="feecode_number" name="feecode_number" readonly="readonly"  value="${paramObj.feecode_number }" type="text" class="dfinput" /><i></i>
    </li>
    <li>
    <label>计费指令</label><input id="command" name="command" readonly="readonly"  value="${paramObj.command }" type="text" class="dfinput" /><i></i>
    </li>
    </c:if>
    <c:if test="${ empty paramObj.id}">
    	<li>
    	<label>上游公司</label>
 
 	  <div class="vocation" id="searchSp">
    		<div class="select3">
               <input id="sp_name" autocomplete="off" name="sp_name" class="scinput" value="" style="position:absolute;top:2px;left:2px;width:316px;outline: none;border:0px;z-index:9;"/> 
        		<div id="result" style="position:absolute; display:none; top:33px; min-width:343px; max-height:343px;overflow:auto;z-index:10;"></div>  
               <input id="sp_id" name="sp_id" type="hidden" value=""/> 
             </div>
             </div>
   
   	</li>
   	
   	<li>
    <label>计费端口</label>
    	<div class="vocation" id="searchCode">
    		<div class="select3">
               <input id="feecode_number" autocomplete="off"  name="feecode_id" class="scinput" value="${paramObj.feecode_number}" style="position:absolute;top:2px;left:2px;width:316px;outline: none;border:0px;z-index:9;"/> 
        		<div id="result1" style="position:absolute; display:none; top:33px; min-width:343px; max-height:343px;overflow:auto;z-index:10;"></div>  
               <input id="feecode_id" name="feecode_number" type="hidden" value=""/> 
             </div>
         </div>
    </li>
   
    <!--  
    <li>
    <label>计费端口</label><input name="feecode_number"  value="${paramObj.feecode_number }" type="text" class="dfinput" /><i></i>
    </li>
     -->
    <li>
    <label>计费指令</label><input id="command" name="command" readonly="readonly"  value="${paramObj.command }" type="text" class="dfinput" /><i></i>
    </li>
    </c:if>
    <li> 
     <label>运营商</label>
     <label id="opname">
     <!--  
      <select  name="op" class="select3">
        		<c:if test="${empty paramObj.op  }">
                <option  value="1" selected="selected" >移动</option>
                <option  value="2" >联通</option>
                <option  value="3" >电信</option>
                </c:if>
               <c:if test="${paramObj.op eq 1 }">
                <option  value="1" selected="selected" >移动</option>
                <option  value="2" >联通</option>
                <option  value="3" >电信</option>
                </c:if>
                  <c:if test="${paramObj.op eq 2 }">
                <option  value="1" >移动</option>
                <option  value="2" selected="selected" >联通</option>
                <option  value="3" >电信</option>
                </c:if>
                  <c:if test="${paramObj.op eq 3 }">
                <option  value="1" >移动</option>
                <option  value="2"  >联通</option>
                <option  value="3" selected="selected">电信</option>
                </c:if>
         </select>
          -->
          
            <c:if test="${empty paramObj.op  }">移动</c:if>
            <c:if test="${paramObj.op eq 1 }">移动</c:if>
            <c:if test="${paramObj.op eq 2 }">联通</c:if>
            <c:if test="${paramObj.op eq 3 }">电信</c:if>
         </label>
         <input type="hidden" id="opid" name="op" value="${paramObj.op}"/>
         <i></i>
    </li>
    <li>
    <label>优先等级</label><input name="level"  value="${paramObj.level }" type="text" class="dfinput" /><i></i>
    </li>
    <li>
    <label>限制量${paramObj.deal_type}</label><input name="limit_num"  value="${paramObj.limit_num }" type="text" class="dfinput" /><i></i>
    </li>
   
    <c:if test="${ !empty paramObj.id  }">
    	<c:if test="${paramObj.deal_type == 0}">
	    	<li>
	    	<label>到量处理</label><label style="width:345px">
	    		<input type="radio" name="deal_type" value="0" checked="checked"/>&nbsp;停止放量&nbsp;&nbsp;
	    		<input type="radio" name="deal_type" value="1"/>&nbsp;继续放量</label>
	    	</li>
    	</c:if>
    	<c:if test="${paramObj.deal_type == 1}">
	    	<li>
	    	<label>到量处理</label>
	    		<label style="width:345px"><input type="radio" name="deal_type" value="0" />&nbsp;停止放量&nbsp;&nbsp;
	    		<input type="radio" name="deal_type" value="1" checked="checked"/>&nbsp;继续放量</label>
	    	</li>
    	</c:if>
    </c:if>
    
    <c:if test="${ empty paramObj.id  }">
    	<li>
    	<label>到量处理</label>
    		<label style="width:345px"><input type="radio" checked="checked" name="deal_type" value="0" />&nbsp;停止放量&nbsp;&nbsp;
    		<input type="radio" name="deal_type" value="1"/>&nbsp;继续放量</label>
    	</li>
    </c:if>
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
