<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/searchSelect.js"></script>
<script type="text/javascript">
$(function(){
	$("input[name=feecode_number]").blur(function(){
		if($("input[name=feecode_id]").val()==""){
			$.ajax({
				type:"post",
				url:"getFeecodeNumberBySpId.do",
				data:{"feecode_number":$(this).val(),"sp_id":$("#sp_id").val()},
				dataType:"json",
				success:function(result){
					$("#msg").text(result.msg);
				}
				
			});
		}
	});
	
	$("input[name=feecode_number]").focus(function(){
		if($("#sp_id").val()!=""){
			$("input[name=feecode_number]").removeAttr("readonly");
			$("#msg").html("");
		}else{
			$("input[name=feecode_number]").val("");
			$("input[name=feecode_number]").attr("readonly","readonly");
			$("#msg").html("请先选择上游公司!");
		}
	});
	
	if($("input[name=feecode_id]").val()!=""){
		$("input[name=feecode_number]").removeAttr("readonly");
	}
	
	/*
	$("#selectSPID").change(function(){
		
		if($("#selectSPID option:selected").html()!="请选择"){
			$("input[name=feecode_number]").removeAttr("readonly");
			$("#selectSPNAME").val($("#selectSPID option:selected").html());
		}else{
			$("input[name=feecode_number]").attr("readonly","readonly");
			
		}
		
	});*/
	
	$("#searchSp").searchInit({
	 	searchObj:"searchSp", 
	 	searchText: "sp_name", 
	 	searchId: "sp_id", 
	 	result:"result", 
	 	searchUrl: "/seachCpCompanyList.do"
	});
	
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
			<li>
				<a href="#">首页</a>
			</li>
			<li>
				<a href="#">表单</a>
			</li>
		</ul>
	</div>

	<div class="formbody">

		<div class="formtitle">
			<span>计费代码信息</span>
		</div>
		<form action="addSpFeecode.do" method="post">
			<input id="feecodNumber" value="${paramObj.sp_id }" type="hidden"></input>
			<ul class="forminfo">
				<c:if test="${paramObj.feecode_id >0 }">
					<li>
						<input name="sp_id" value="${paramObj.sp_id }" type="hidden"></input>
						<label>上游公司名称</label>
						<input name="sp_name" readonly="readonly" value="${paramObj.sp_name }" type="text" class="dfinput"></input>
					</li>

				</c:if>
				<c:if test="${ empty paramObj.feecode_id}">
					<li>
						<label>上游公司</label>

						<div class="vocation" id="searchSp">
							<!--<input id="selectSPNAME" name="sp_name" value="" type="hidden" ></input>  
    	<select id="selectSPID" name="sp_id" class="select3">
                <option value="">请选择</option>
                <forEach items="{spList}" var="sp">
                <option  value="{sp.sp_id}" >{sp.sp_name}</option>
                </forEach>
         </select> -->
							<div class="select3">
								<input id="sp_name" name="sp_name" class="scinput" value="${empty searchObj.sp_name?'--请选择--': searchObj.sp_name}" style="position: absolute; top: 2px; left: 2px; width: 73px; outline: none; border: 0px; z-index: 9;" />
								<div id="result" style="position: absolute; display: none; top: 33px; min-width: 98px; max-height: 200px; overflow: auto; z-index: 2;"></div>
								<input id="sp_id" name="sp_id" type="hidden" value="${searchObj.sp_id}" />
							</div>
						</div>
					</li>

				</c:if>

				<%-- <li><label>代码分组</label>
     	<label>
    	 <select id="group_id" name="group_id" class="select3" style="z-index:1">
                <option value="">请选择</option>
                <c:forEach items="${spfcgroup}" var="sfg">
                	<option  value="${sfg.g_id}" <c:if test="${paramObj.group_id eq sfg.g_id}">selected="selected"</c:if>>${sfg.g_name}</option>
                </c:forEach>
         </select>
         </label>
    </li> --%>


				<li>
					<input name="feecode_id" value="${paramObj.feecode_id }" type="hidden"></input>
					<label>计费代码名称</label>
					<input name="feecode_name" value="${paramObj.feecode_name }" type="text" class="dfinput" /><i>业务名称，如：星球保卫战</i>
				</li>
				<li>
					<label>计费代码</label>
					<input name="feecode_code" value="${paramObj.feecode_code }" type="text" class="dfinput" /><i>计费代码，保证唯一，一般业务名称拼音首字母大写，如：XQBWZ</i>
				</li>
				<li>
					<label>计费端口</label>
					<input name="feecode_number" value="${paramObj.feecode_number }" type="text" class="dfinput" readonly="readonly" /><i>端口，长号码</i><i id="msg" style="color: red"></i>
				</li>
				<li>
					<label>运营商</label>
					<label>
						<select name="feecode_op" class="select3">
							<c:if test="${empty paramObj.feecode_op  }">
								<option value="1" selected="selected">移动</option>
								<option value="2">联通</option>
								<option value="3">电信</option>
							</c:if>
							<c:if test="${paramObj.feecode_op eq 1 }">
								<option value="1" selected="selected">移动</option>
								<option value="2">联通</option>
								<option value="3">电信</option>
							</c:if>
							<c:if test="${paramObj.feecode_op eq 2 }">
								<option value="1">移动</option>
								<option value="2" selected="selected">联通</option>
								<option value="3">电信</option>
							</c:if>
							<c:if test="${paramObj.feecode_op eq 3 }">
								<option value="1">移动</option>
								<option value="2">联通</option>
								<option value="3" selected="selected">电信</option>
							</c:if>
						</select>
					</label>
					<i>运营商，必选</i>
				</li>
				<li>
					<label>计费类型</label>
					<label>
						<select name="feecode_type" class="select3">
							<c:if test="${empty paramObj.feecode_type  }">
								<option value="0" selected="selected">短信</option>
								<option value="2">wap网游</option>
								<option value="4">视频</option>
								<option value="11">强指令</option>
								<option value="12">视频包月</option>
								<option value="1">IVR</option>
							</c:if>
							<c:if test="${paramObj.feecode_type eq 0 }">
								<option value="0" selected="selected">短信</option>
								<option value="2">wap网游</option>
								<option value="4">视频</option>
								<option value="11">强指令</option>
								<option value="12">视频包月</option>
								<option value="1">IVR</option>
							</c:if>
							<c:if test="${paramObj.feecode_type eq 2 }">
								<option value="0">短信</option>
								<option value="2" selected="selected">wap网游</option>
								<option value="4">视频</option>
								<option value="11">强指令</option>
								<option value="12">视频包月</option>
								<option value="1">IVR</option>
							</c:if>
							<c:if test="${paramObj.feecode_type eq 4 }">
								<option value="0">短信</option>
								<option value="2">wap网游</option>
								<option value="4" selected="selected">视频</option>
								<option value="11">强指令</option>
								<option value="12">视频包月</option>
								<option value="1">IVR</option>
							</c:if>

							<c:if test="${paramObj.feecode_type eq 11 }">
								<option value="0">短信</option>
								<option value="2">wap网游</option>
								<option value="4">视频</option>
								<option value="11" selected="selected">强指令</option>
								<option value="12">视频包月</option>
								<option value="1">IVR</option>
							</c:if>
							<c:if test="${paramObj.feecode_type eq 12 }">
								<option value="0">短信</option>
								<option value="2">wap网游</option>
								<option value="4">视频</option>
								<option value="11">强指令</option>
								<option value="12" selected="selected">视频包月</option>
								<option value="1">IVR</option>
							</c:if>
							<c:if test="${paramObj.feecode_type eq 14 }">
								<option value="0">短信</option>
								<option value="2">wap网游</option>
								<option value="4">视频</option>
								<option value="11">强指令</option>
								<option value="12">视频包月</option>
								<option value="1" selected="selected">IVR</option>
							</c:if>
						</select>
					</label>
					<i> 计费类型，必选</i>
				</li>

				<li>
					<label>互斥控制</label>
					<label style="width: 400px;">

						<c:if test="${paramObj.feecode_mutex eq 1}">
							<input name="feecode_mutex" type="radio" checked="checked" value="1" /> 是
		&nbsp;&nbsp;<input name="feecode_mutex" type="radio" value="2" /> 否
   	</c:if>
						<c:if test="${empty paramObj.feecode_mutex or paramObj.feecode_mutex eq 2}">
							<input name="feecode_mutex" type="radio" value="1" /> 是
		&nbsp;&nbsp;<input name="feecode_mutex" type="radio" checked="checked" value="2" /> 否
    </c:if>
						<i>（是否互斥）</i>
					</label>
				</li>

				<!--  
    <li>
    <label>计费费用</label><input name="feecode_fee"  value="${paramObj.feecode_fee }" type="text" class="dfinput" /><i></i>
    </li>
    -->
				<%-- <li>
					<label>计费频率</label>
					<input name="hz" value="${paramObj.hz }" type="text" class="dfinput" /><i>代码使用频率</i> </i>
				</li> --%>
				<li>
					<label>备注</label>
					<textarea name="remarks" cols="" rows="" class="textinput">${paramObj.remarks }</textarea>
				</li>
				<li>
					<label>&nbsp;</label>
					<input type="submit" class="btn" value="确认保存" />
				</li>
			</ul>
		</form>
	</div>


</body>

</html>
