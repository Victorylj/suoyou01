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
$(function() {
	$("#selectSPID").change(
			function() {
				$("#selectSPNAME").val($("#selectSPID").find("option:selected").text());
			});
	$(".select3").uedSelect({
		width : 160
	});
	$("#searchSp").searchInit({
		searchObj : "searchSp",
		searchText : "sp_name",
		searchId : "sp_id",
		result : "result",
		searchUrl : "/seachCpCompanyList.do"
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
			<span>上游公司信息</span>
		</div>
		<form action="addSpInterfaceParam.do" method="post">
			<input type="hidden" name="ip_port" value="120.55.161.54:6029"/>
			<ul class="forminfo">
				<c:if test="${paramObj.id >0 }">
					<li>
						<input name="sp_id" value="${paramObj.sp_id }" type="hidden"></input>
						<label>上游公司名称</label>
						<input name="sp_name" value="${paramObj.sp_name }" type="text" class="dfinput"></input>
					</li>
				</c:if>
				<c:if test="${ empty paramObj.id}">
					<li>
						<label>上游公司</label>
						<div class="vocation" id="searchSp">
							<!--  <select id="selectSPID" name="sp_id" class="select3" style="whdth:100px">
                <option value="">请选择</option>
                <forEach items="{spList}" var="sp">
                <option value="{sp.sp_id}" >{sp.sp_name}</option>
                </forEach>
         </select>-->
							<div class="select3">
								<input id="sp_name" name="sp_name" class="scinput" value="${empty searchObj.sp_name?'--请选择--': searchObj.sp_name}" style="position: absolute; top: 2px; left: 2px; width: 133px; outline: none; border: 0px; z-index: 9;" />
								<div id="result" style="position: absolute; display: none; top: 33px; min-width: 158px; max-height: 200px; overflow: auto; z-index: 2;"></div>
								<input id="sp_id" name="sp_id" type="hidden" value="${searchObj.sp_id}" />
							</div>
						</div>
					</li>
				</c:if>

				<li>
					<input name="id" value="${paramObj.id }" type="hidden"></input>
					<label>linkId</label>
					<input name="linkid" value="${paramObj.linkid }" type="text" class="dfinput" /><i>linkid,一般为唯一标示</i>
				</li>
				<li>
					<label>端口</label>
					<input name="spnumber" value="${paramObj.spnumber }" type="text" class="dfinput" /><i>计费端口参数字符</i>
				</li>
				<li>
					<label>指令</label>
					<input name="command" value="${paramObj.command }" type="text" class="dfinput" /><i>指令对应参数字符</i>
				</li>
				<li>
					<label>手机号码</label>
					<input name="mobile" value="${paramObj.mobile }" type="text" class="dfinput" /><i>手机号码对应字符</i>
				</li>
				<li>
					<label>省份</label>
					<input name="province" value="${paramObj.province }" type="text" class="dfinput" /><i>省份参数字符</i>
				</li>
				<li>
					<label>省份编码方式</label>
					<input name="pro_encoder" value="${paramObj.pro_encoder }" type="text" class="dfinput" /><i>省份字符编码方式</i>
				</li>
				<li>
					<label>上游请求IP</label>
					<input name="ip_str" value="${paramObj.ip_str }" type="text" class="dfinput" /><i>上游请求IP，用于鉴权</i>
				</li>
				<li>
					<label>透传</label>
					<input name="cparams" value="${paramObj.cparams }" type="text" class="dfinput" /><i>透传参数</i>
				</li>
				<li>
					<label>成功状态参数</label>
					<input name="status_str" value="${paramObj.status_str }" type="text" class="dfinput" /><i>成功状态参数字符</i>
				</li>

				<li>
					<label>成功状态标示</label>
					<input name="succ_status" value="${paramObj.succ_status }" type="text" class="dfinput" /><i>成功状态参数字符</i>
				</li>
				<li>
					<label>数据时间字符</label>
					<input name="timestr" value="${paramObj.timestr }" type="text" class="dfinput" /><i>状态报告时间字符</i>
				</li>
				<li>
					<label>接口返回字符</label>
					<input name="ret_str" value="${paramObj.ret_str }" type="text" class="dfinput" /> <i>接口返回字符</i>
				</li>
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
