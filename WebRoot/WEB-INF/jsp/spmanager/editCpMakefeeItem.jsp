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
<style>input[type=checkbox]{vertical-align:middle;}</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=blue"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript"  src="js/searchSelect.js"></script>
<script type="text/javascript">

$(document).ready(function() {
/*
	$("#selectP").change(function(){
		var Pid =$("#selectP").find("option:selected").val();
		var namestr=$("#selectP").find("option:selected").text();
		var arr=namestr.split("-");
		$("#feecode_number").val(arr[0]);
		
		$("#op").val(arr[1]);
		
		$("#selectS > option").hide();
		//alert(Pid);
		$(".SP"+Pid).show();
		//alert($(".SP"+Pid+":first").val());
		$("#selectS").val($(".SP"+Pid+":first").val());
		$("#Sname").val($(".SP"+Pid+":first").text());
	});

	$("#sp").change(function(){
		$("#selectP").empty();
			$("#selectP").append($("<option/>").text("请选择").attr("value",''));
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
                        $("#selectP").append($("<option/>").text(feecode_number+"-"+feecode_op+"-"+feecode_name).attr("value",feecode_id));
                	});
                	//$("#selectP").val('');
                	
                },
                error:function(){
                    alert("failed.");
                }
            });
	});*/
	
	$(".select4").uedSelect({
			width : 80
	});
	
	$(".select5").uedSelect({
			width : 150
	});
	
	$(".select3").uedSelect({
			width : 225
	});
	

	
	 var cascade = function(obj){
	 	$.ajax({
	         type:'post',
	         url: 'searchSpFeecodeTow.do',
	         data:'pid='+obj.id,
	         dataType:'text',
	         success:function(result){
		         $("#searchCode").initData(result,{result:"result1", searchText: "feecodes",defaultStr:true, searchId: "feecode_id"});
			 },
	         error:function(){
	             art.dialog({icon: 'warning',time: 1,lock:true,content: 'failed.'});
	         }
	     });
	 };
	 
	 var codecascade = function (obj){
	 	$("#feecode_number").val(obj.title);
		$("#op").val($(obj).attr("yys"));
		
	 };
	
	 $("#searchSp").searchInit({searchObj:"searchSp", searchText: "sp_name", searchId: "sp_id", result:"result", searchUrl: "/seachCpCompanyList.do",cascade:cascade});

	 $("#searchCode").searchInit({searchObj:"searchCode", pid:"sp_id", searchText: "feecodes", searchId: "feecode_id", result:"result1", searchUrl: "/seachSpFeecodeList.do",cascade:codecascade});
	
 
});

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

function changstat(v)
{
	if(v == 1){
		var li = document.getElementsByClassName("changli");
		for(var i=0; i < li.length; i++)
		{
			li[i].style.display="block";
		}	
	}else{
		var li = document.getElementsByClassName("changli");
		for(var i=0; i < li.length; i++)
		{
			li[i].style.display="none";
		}
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
    
    <div class="formtitle"><span>计费项信息</span></div>
    <form id="myForm" action="addCpMakefeeItem.do" method="post">
    <ul class="forminfo">
    <c:if test="${paramObj.cp_item_id >0 }">
    	<li>
    		<input name="feecode_id" value="${paramObj.feecode_id }" type="hidden" ></input>
    		<label>计费端口</label><input disabled="true" name="feecode_number" value="${paramObj.feecode_number }" type="text" class="dfinput"></input>
    		</li>
    		
    		<li>
    		<input name="command_id" value="${paramObj.command_id }" type="hidden" ></input>
    		    <input name="command_length"  value="${paramObj.command_length }" type="hidden" class="dfinput" />
    		<label>计费指令</label><input name="command" value="${paramObj.command }" type="text" readonly="true" class="dfinput"></input>
    		</li>
    		
    </c:if>
     <c:if test="${ empty paramObj.cp_item_id}">
      <li><label>上游公司</label>
     	 <div id="searchSp" class="vocation">
    	<!--  <select id="sp"  class="select3">
                <option value="">请选择</option>
                <c:forEach items="${companyList}" var="spc">
                <option  value="${spc.sp_id}" >${spc.sp_name}</option>
                </c:forEach>
         </select> -->
          <div class="select3">
                	 <input id="sp_name" name="sp_name" class="scinput" value="--请选择--" style="position:absolute;top:2px;left:2px;width:196px;outline: none;border:0px;z-index:19;"/> 
        				<div id="result" style="position:absolute;display:none;top:33px; min-width:223px; max-height:223px;overflow:auto;z-index:12;"></div>  
                	   	<input id="sp_id" name="sp_id" type="hidden" value=""/> 
                </div>
         </div>
    </li>
    
     <li><label>计费端口</label>
     <div id="searchCode" class="vocation">
     	<input id="feecode_number" name="feecode_number" value="" type="hidden" ></input>
    	<!-- <select id="selectP" name="feecode_id" class="select3" >
                <option value="">请选择</option>
                <c:forEach items="${feecodeList}" var="feecode">
                <option  value="${feecode.feecode_id}" >${feecode.feecode_number}-${feecode.feecode_op}</option>
                </c:forEach>
         </select>-->
         <div class="select3">
                	    <input id="feecodes" name="feecodes" class="scinput" value="--请选择--" style="position:absolute;top:2px;left:2px;width:196px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result1" style="position:absolute;display:none;top:33px; min-width:223px; max-height:223px;overflow:auto;z-index:2;"></div>  
                	   	<input id="feecode_id" name="feecode_id" type="hidden" value=""/> 
                	   </div>
         </div>
    </li>
     
    <li>
    <input name="command_id" value="${paramObj.command_id }" type="hidden" ></input>

    <label>指令</label><input id="command" name="command"  value="${paramObj.command }" type="text" class="dfinput" /><i>指令</i>
    </li>  
     </c:if>
     <!--   
    <li>
    <label>指令长度</label><input name="command_length"  value="${paramObj.command_length }" type="text" class="dfinput" /><i>指令长度</i>
    </li>
     -->
     <li>
    <label>指令费用</label><input id="command_fee" name="command_fee"  value="${paramObj.command_fee }" type="text" class="dfinput" /><i>指令费用，单位（分）</i>
    </li>
     <li>
    <label>分成比例</label><input name="command_share"  value="${paramObj.command_share }" type="text" class="dfinput" /><i>分成比例,填写小数</i>
    </li>
    <c:if test="${not empty sp}">
     <li>
    <label>同步指令</label><input name="synchronous_command"  value="${paramObj.synchronous_command }" type="text" class="dfinput" /><i></i>
    </li>
     <li>
    <label>同步端口</label><input name="synchronous_port"  value="${paramObj.synchronous_port }" type="text" class="dfinput" /><i></i>
    </li>
    <li>
    <label>同步条数</label><input name="synchro_num"  value="${paramObj.synchro_num }" type="text" class="dfinput" /><i></i>
    </li>
    </c:if>
   
    <c:if test="${empty sp}">
      <li>
    <label>同步指令</label><input name="synchronous_command" disabled="disabled" value="${paramObj.synchronous_command }" type="text" class="dfinput" /><i></i>
    </li>
     <li>
    <label>同步端口</label><input name="synchronous_port" disabled="disabled" value="${paramObj.synchronous_port }" type="text" class="dfinput" /><i></i>
    </li>
    <li>
    <label>同步条数</label><input name="synchro_num" disabled="disabled"  value="${paramObj.synchro_num }" type="text" class="dfinput" /><i></i>
    </li>
    </c:if>
     <li>
    <label>指令类型</label>
    <label>
         <select  name="command_type" class="select4 select3">
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
         </label>
    </li>
     
     
     
     
         <c:if test="${not empty paramObj.open_province_name  }">
    <li>
     <label>状态</label>
     <label>
      <select  name="item_status" class="select4 select3" >
        		<c:if test="${empty paramObj.item_status  }">
                <option  value="1" selected="selected" >关闭</option>
                <option  value="0" >启用</option>
                </c:if>
               <c:if test="${paramObj.item_status eq 1 }">
                <option  value="1" selected="selected" >关闭</option>
                <option  value="0" >启用</option>
                </c:if>
                  <c:if test="${paramObj.item_status eq 0 }">
                <option  value="1" >关闭</option>
                <option  value="0" selected="selected"  >启用</option>
                </c:if>
         </select>
         </label>
         <i> 计费项开通或者关闭</i>
    </li>
    </c:if>
    
      <li>
    <label>运营商</label>
         <label>
          <select id="op"  name="feecode_op" class="select4 select3">
        		<c:if test="${empty paramObj.feecode_op  }">
                <option  value="1" selected="selected" >移动</option>
                <option  value="2" >联通</option>
                <option  value="3" >电信</option>
                </c:if>
               <c:if test="${paramObj.feecode_op eq 1 }">
                <option  value="1" selected="selected" >移动</option>
                <option  value="2" >联通</option>
                <option  value="3" >电信</option>
                </c:if>
                  <c:if test="${paramObj.feecode_op eq 2 }">
                <option  value="1" >移动</option>
                <option  value="2" selected="selected" >联通</option>
                <option  value="3" >电信</option>
                </c:if>
                  <c:if test="${paramObj.feecode_op eq 3 }">
                <option  value="1" >移动</option>
                <option  value="2"  >联通</option>
                <option  value="3" selected="selected">电信</option>
                </c:if>
         </select>
         </label>
    <i>必选</i>
    </li>
    <!--  
     <li>
    <label>计费项名称</label><input name="cp_item_name"  value="${paramObj.cp_item_name }" type="text" class="dfinput" /><i>一般写计费代码名称+指令+计费项，如：星球保卫战1478计费项</i>
    </li>
    <li>
    <label>计费项编码</label><input name="cp_item_code"  value="${paramObj.cp_item_code }" type="text" class="dfinput" /><i>保证唯一即可，长度限制在20字符</i>
    </li>
    -->
    <li>
    <input id="cp_item_id" name="cp_item_id" value="${paramObj.cp_item_id }" type="hidden" ></input>
    <label>二次确认</label>
    <label>
     <select  name="is_second" class="select4 select3" id="select3" onchange=changstat(this.value)>
        		<c:if test="${empty paramObj.is_second  }">
                <option  value="1" >是</option>
                <option  value="0" selected="selected" >否</option>
                </c:if>
               <c:if test="${paramObj.is_second eq 1 }">
                <option  value="1" selected="selected" >是</option>
                <option  value="0" >否</option>
                </c:if>
                  <c:if test="${paramObj.is_second eq 0 }">
                <option  value="1" >是</option>
                <option  value="0" selected="selected"  >否</option>
                </c:if>
         </select>
    </label>
    <i>是否二次确认</i>
    </li>
    <li id="changli" class="changli" style="display:none;">
    <label >二次确认端口</label><input name="second_port"  value="${paramObj.second_port }" type="text" class="dfinput" /><i></i>
    </li>
     <li class="changli" style="display:none;">
    <label>二次确认关键字</label><input name="second_info"  value="${paramObj.second_info }" type="text" class="dfinput" /><i>二次确认信息里包含的关键字，用作屏蔽该条短信</i>
    </li>
     <li class="changli" style="display:none;">
    <label>二次确认类型</label>
    <label>
    <select  name="second_type" class="select5 select3">
        		<c:if test="${empty paramObj.second_type  }">
                <option  value="1" selected="selected" >回复设置好的内容</option>
                <option  value="2" >随即动态码</option>
                </c:if>
               <c:if test="${paramObj.second_type eq 1 }">
                <option  value="1" selected="selected" >回复设置好的内容</option>
                <option  value="2" >随即动态码</option>
                </c:if>
                  <c:if test="${paramObj.second_type eq 2 }">
                <option  value="1" >回复设置好的内容</option>
                <option  value="2" selected="selected"  >随即动态码</option>
                </c:if>
         </select>
         </label>
    <i></i>
    </li>
    <li class="changli" style="display:none;">
    <label>短信验证前段字符</label><input name="replay_start_str"  value="${paramObj.replay_start_str }" type="text" class="dfinput" />
    <i>动态二次确认中紧接动态内容前的字符</i>
    </li>
      <li class="changli" style="display:none;">
    <label>短信验证后端字符</label><input name="replay_end_str"  value="${paramObj.replay_end_str }" type="text" class="dfinput" />
     <i>动态二次确认中紧接动态内容之后的字符</i>
    </li>
      <li class="changli" style="display:none;">
    <label>短信验证字符</label><input name="replay_str"  value="${paramObj.replay_str }" type="text" class="dfinput" />
    <i>确定回复的内容，比如回复是确认的：是，当回复任意时，填任意内容</i>
    </li> 
     <li>
    <label>是否过滤短信</label>
    <label>
     <select  name="is_filter" class="select4 select3">
        		<c:if test="${empty paramObj.is_filter  }">
                <option  value="1" selected="selected" >是</option>
                <option  value="0" >否</option>
                </c:if>
               <c:if test="${paramObj.is_filter eq 1 }">
                <option  value="1" selected="selected" >是</option>
                <option  value="0" >否</option>
                </c:if>
                  <c:if test="${paramObj.is_filter eq 0 }">
                <option  value="1" >是</option>
                <option  value="0" selected="selected"  >否</option>
                </c:if>
         </select>
    </label>
    <i></i>
    </li>
      <li>
    <label>过滤端口</label><input name="filter_port"  value="${paramObj.filter_port }" type="text" class="dfinput" />
    <i>过滤端口，多个以 # 隔开 </i>
    </li>
      <li>
    <label>过滤内容</label><input name="filter_info"  value="${paramObj.filter_info }" type="text" class="dfinput" />
    <i>过滤的关键字，多个以 # 隔开</i>
    </li>
    <!-- 
      <li>
    <label>计费规则</label><input name="network_role"  value="${paramObj.network_role }" type="text" class="dfinput" />
    <i></i>
    </li>
    
  
    </li>-->
      <li>
      
   
    <label>优先级</label>
    <input name="use_priority"  value="${paramObj.use_priority }" type="text" class="dfinput" /> 
    <i></i>
    </li>
     
         <li>
    <label>发送短信时间间隔</label><input name="sms_delay_time"  value="${paramObj.sms_delay_time }" type="text" class="dfinput" />
    <i></i>
      <li>
    <label>开通省份</label>
    	<input name="open_province_id"  value="${paramObj.open_province_id }" type="hidden"  />
    	<input name="open_province_name"  value="${paramObj.open_province_name }" type="hidden"  />
    	<c:if test="${paramObj.open_province_id != 99 }">
    	${paramObj.open_province_name }
    	</c:if>
      
      <c:if test="${empty paramObj.open_province_name or paramObj.open_province_id== 99  }">
          <c:forEach items="${proList}" var="pro">
       <input type="checkbox" name="province" value="${pro.province_id}" 
       <c:if test="${fn:contains(paramObj.openProvinceStr,pro.province_id)==true}">checked="checked"</c:if>  
   		 />${pro.province_name}
   		 
    </c:forEach>
    ---<input type="checkbox" onclick="doChecked();" id="pro99"/>全选
    </c:if>
    <i> 
    
    
   		勾选为开通
     </i>
    </li>
     <c:if test="${not empty cityList  }">
    <li><label>屏蔽地市</label>
           <c:forEach items="${cityList}" var="city">
               <input type="checkbox" name="citys" value="${city.city_id}" <c:if test="${fn:contains(paramObj.hide_city,city.city_id)==true}">checked="checked"</c:if> >${city.city_name}</input>
       </c:forEach>
   
    <i>勾选为屏蔽</i></li>
    </c:if>

    
    <li><label>备注</label><textarea name="remarks"  cols="" rows="" class="textinput">${paramObj.remarks }</textarea></li>
    
    <c:if test="${not empty sp}">
    <li><label>总小时限</label><input name="hour_num"  value="${sp.hour_num}" type="text" class="dfinput" /><i>单位：元</i></li>
    <li><input id="limit_id" name="limit_id" value="${sp.limit_id}" type="hidden" ></input>
    <label>总日限</label><input name="day_num"  value="${sp.day_num}" type="text" class="dfinput" /><i>单位：元</i></li>
    <li><label>总月限</label><input name="month_num"  value="${sp.month_num}" type="text" class="dfinput" /><i>单位：元</i></li>
    <li><label>同步总日限</label><input name="rec_day_num"  value="${sp.rec_day_num}" type="text" class="dfinput" /><i>单位：元</i></li>
    <li><label>同步总月限</label><input name="rec_month_num"  value="${sp.rec_month_num}" type="text" class="dfinput" /><i>单位：元</i></li>
    <li><label>单用户日限</label><input id="single_day_num" name="single_day_num"  value="${sp.single_day_num}" type="text" class="dfinput" /><i>单位：元</i></li>
    <li><label>单用户月限</label><input id="single_month_num" name="single_month_num"  value="${sp.single_month_num}" type="text" class="dfinput" /><i>单位：元</i></li>
  
     <li><label>屏蔽日期段</label><input name="limit_time_str"  value="${sp.limit_time_str}" type="text" class="dfinput" /><i>例如，7号到15号不放量，格式为：7-15</i></li>
    <li><label>屏蔽小时段</label><input name="limit_hour_str"  value="${sp.limit_hour_str}" type="text" class="dfinput" /><i>例如，0点到7点不放量，格式：0-7,23点到第二天7点不放量，格式：23-7</i></li>
    <li><label>限制备注</label><input name="limit_remarks"  value="${sp.remarks}" type="text" class="dfinput" /><i></i></li>
    </c:if>
    
    <li><label>&nbsp;</label><input  type="button"  class="btn" onclick="onSubmit()" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>
<script type="text/javascript">
	function onSubmit(){
		var obj = $("#sp_id");
		if(obj.val()==""){
			art.dialog({icon: 'warning',time: 1,lock:true,content: '请选择上游公司!'});
			return false;
		}
		
		obj = $("#feecode_id");
		if(obj.val()==""){
			art.dialog({icon: 'warning',time: 1,lock:true,content: '请选择计费代码!'});
			return false;
		}

		obj = $("#command");
		if(obj.val()==""){
			art.dialog({icon: 'warning',time: 1,lock:true,content: '请输入计费指令!',close:function(){obj.select();}});
			return false;
		}
		
		obj = $("#command_fee");
		if(obj.val()==""){
			art.dialog({icon: 'warning',time: 1,lock:true,content: '请输入指令费用!',close:function(){obj.select();}});
			return false;
		}

		obj = $("#single_day_num");
		if(obj != null){
			if(obj.val()==""){
				art.dialog({icon: 'warning',time: 1,lock:true,content: '请输入单用户日限!'});
				obj.select();
				return false;
			}
			
			var num = Number($("#command_fee").val())/100;
			if(num>Number(obj.val())){
				art.dialog({icon: 'warning',time: 1,lock:true,content: '单用户日限需大于或等于指令费用!'});
				obj.select();
				return false;
			}
			
			obj = $("#single_month_num");
			if(obj.val()==""){
				art.dialog({icon: 'warning',time: 1,lock:true,content: '请输入单用户月限!'});
				obj.select();
				return false;
			}
			
			if(num>Number(obj.val())){
				art.dialog({icon: 'warning',time: 1,lock:true,content: '单用户月限需大于或等于指令费用!'});
				obj.select();
				return false;
			}
			
		}
		obj = $("#cp_item_id");
		if(obj.val()==""){
			$.post("checkData.do", {command: $("#command").val(), feecode_number:$("#feecode_number").val(), sp_id:$("#sp_id").val()}, function(data){ 
				 if(data.errorCode==0){
				  	 art.dialog({icon: 'warning',time: 1,lock:true,content: data.msg});
				 }else{
					 initshow();
				 	 $("#myForm").submit();
				 }
	        }); 
        }else{
        	 initshow();
			 $("#myForm").submit();
        }
		return false;
	}
</script>
</html>
