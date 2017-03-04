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
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>

<script type="text/javascript" src="js/spmanager/listCpMakefeeItem.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript">
	
</script>


</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据表</a></li>
			<li><a href="#">基本内容</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
			<form id="searcherForm" action="saveFeecodeProvinceLimit.do" method="post" onsubmit="initshow()">
				
			</ul>
			<ul class="toolbar">
				<li ><span>${ paramObj.remarks}</span>
			</ul>

		</div>


		<table class="tablelist">
			<thead>
				<tr>
					
					<th>省份</th>
					<th>省总月限(元)</th>
					<th>省总日限(元)</th>
					<th>省单用户月限(元)</th>
					<th>省单用户月限(元)</th>
					<th>省屏蔽日期</th>					
					<th>省屏蔽小时</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty proLimitList}">
						<c:forEach items="${proLimitList}" var="v" varStatus="var">

							<tr>
								
								<td><input type="hidden" name="proLimitArr[${var.index}].province" value="${ v.province}" />
								${ v.province_name}
								<input type="hidden" name="proLimitArr[${var.index}].province_name" value="${ v.province_name}" />
								<input type="hidden" name="proLimitArr[${var.index}].pro_limit_id" value="${ v.pro_limit_id}" />
								 <input type="hidden" name="proLimitArr[${var.index}].limit_id" value="${ v.limit_id}" />
								</td>
								
								<td>月限<input type="text" name="proLimitArr[${var.index}].pro_month_num" value="${ v.pro_month_num}" /></td>
								<td>日限<input type="text" name="proLimitArr[${var.index}].pro_day_num" value="${ v.pro_day_num}" /></td>
								<td>单月限<input type="text" name="proLimitArr[${var.index}].pro_single_month_num" value="${ v.pro_single_month_num}" /></td>
								<td>单日限<input type="text" name="proLimitArr[${var.index}].pro_single_day_num" value="${ v.pro_single_day_num}" /></td>
								<td>日期<input type="text" name="proLimitArr[${var.index}].pro_limit_time_str" value="${ v.pro_limit_time_str}" /></td>
								<td>小时<input type="text" name="proLimitArr[${var.index}].pro_limit_hour_str" value="${ v.pro_limit_hour_str}" /></td>
				
								</tr>

						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="25">没有搜索到符合条件的数据！</td>
						</tr>
					</c:otherwise>
				</c:choose>
						<tr>
						<td colspan="25">
						<ul class="seachform">
								<li><label>&nbsp;</label><input  type="submit"
									class="scbtn" value="提交" /></li>
								</form>
							</ul>
							</td>
						</tr>
			</tbody>
		</table>

	
	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
