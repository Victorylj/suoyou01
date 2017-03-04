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
			<form id="searcherForm" action="saveFeepointPlan.do" method="post" onsubmit="initshow()">
				
			</ul>
			<ul class="toolbar">
				<li ><span>${ paramObj.product_name}-->${ paramObj.appfee_name}</span>
				<input type="hidden" name="appfee_id" value="${ paramObj.appfee_id}" /></li>
			</ul>

		</div>

<div class="divtable">	
		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>扣费方案名称</th>
					<th>扣费措施名称</th>
					<th>运营商</th>
					<th>是否弹窗</th>
					<th>措施费用</th>
					<th>省分</th>
					<th>地市</th>
					<th>备注</th>
					<th>更新时间</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty cpFeemeasureList}">
						<c:forEach items="${cpFeemeasureList}" var="v" varStatus="var">

							<tr>
								<td><input type="checkbox" name="feemeasure_id" value="${ v.feemeasure_id}" /></td>
							
								<td>${v.feeplan_name }</td>
								<td>${v.feemeasure_name }</td>
								<td>
								 <c:if test="${v.feemeasure_op ==1 }">
								 	移动
								 </c:if>
								<c:if test="${v.feemeasure_op ==2 }">
								 	联通
								 </c:if>
								 <c:if test="${v.feemeasure_op ==3 }">
								 	电信
								 </c:if>
								</td>
								<td>
								 <c:if test="${v.feemeasure_is_pop ==0 }">
								 	是
								 </c:if>
								<c:if test="${v.feemeasure_is_pop ==1 }">
								 	否
								 </c:if>
								
								</td>
								<td>${v.feemeasure_fee }</td>
								<td>${v.feemeasure_province_name }</td>
								<td>${v.feemeasure_city_name }</td>
								<td>${v.remarks }</td>
								<td>${v.update_time }</td>
						
							</tr>

						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="10">没有搜索到符合条件的数据！</td>
						</tr>
					</c:otherwise>
				</c:choose>
						<tr>
						<td colspan="10">
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
	
	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
