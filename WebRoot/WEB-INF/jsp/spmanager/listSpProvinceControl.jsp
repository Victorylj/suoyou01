<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>

<script type="text/javascript" src="js/spmanager/listSmsResource.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript">
	function closeOrOpenSpProvince(ids,stat,tag){
		art.dialog.confirm("确定？", 
			function() {
				if (!ids || ids == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				var url = "updateSpProvinceControl.do";
				var data = {"province_id" : ids,"stat":stat,"tag":tag};
				$.post(url, data, function(result) {
				//	alert("dsfdsfda");
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location ="listSpProvinceControl.do";
						}
					}, false);
				}, "json");
			}, 
			function() {}
		);
	}
</script>


</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">上游代码</a></li>
			<li><a href="#">省份放量控制</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		

	<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
				
					<th>省份</th>
					<th>计费控制</th>
					<th>弹窗控制</th>
					<th>13控制</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">

							<tr>
								
								<td>${v.province_name }</td>
							<%-- 	<td>
								<c:if test="${v.stat == 1 }">
								<font color="grean">放开</font> 
								</c:if>
								<c:if test="${v.stat == 2 }">
								<font color="red"> 关闭</font>
								</c:if>
								</td> --%>
								
								<td>
								<c:if test="${v.stat == 1 }">
								 <a href="javascript:void()" onclick="closeOrOpenSpProvince(${ v.province_id},2,1)" class="tablelink">
								 <font color="grean">放开</font> </a>
								</c:if>
								<c:if test="${v.stat == 2 }">
								 <a href="javascript:void()" onclick="closeOrOpenSpProvince(${ v.province_id},1,1)" class="tablelink">
									<font color="red"> 关闭</font></a>
								</c:if>
								</td>
								<td>
								<c:if test="${v.stat_out == 1 }">
								 <a href="javascript:void()" onclick="closeOrOpenSpProvince(${ v.province_id},2,2)" class="tablelink">
								 <font color="grean">弹窗</font> </a>
								</c:if>
								<c:if test="${v.stat_out == 2 }">
								 <a href="javascript:void()" onclick="closeOrOpenSpProvince(${ v.province_id},1,2)" class="tablelink">
									<font color="red">不弹窗</font></a>
								</c:if>
								</td>
								<td>
								<c:if test="${v.stat_spe == 1 }">
								 <a href="javascript:void()" onclick="closeOrOpenSpProvince(${ v.province_id},2,3)" class="tablelink">
								 <font color="grean">放开13</font> </a>
								</c:if>
								<c:if test="${v.stat_spe == 2 }">
								 <a href="javascript:void()" onclick="closeOrOpenSpProvince(${ v.province_id},1,3)" class="tablelink">
									<font color="red"> 关闭13</font></a>
								</c:if>
								</td>
							</tr>

						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="9">没有搜索到符合条件的数据！</td>
						</tr>
					</c:otherwise>
				</c:choose>

			</tbody>
		</table>
	</div>

		
		<div id="delDiv" class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认删除信息 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>

		</div>
	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
