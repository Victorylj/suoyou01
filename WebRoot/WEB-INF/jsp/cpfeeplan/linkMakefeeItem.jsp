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
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>

<script type="text/javascript" src="js/spmanager/listCpMakefeeItem.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
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
			<form id="searcherForm" action="saveMakefeeLink.do" method="post" onsubmit="initshow()">
				
			</ul>

		</div>
			<ul class="toolbar">
				<li ><span>${ paramObj.feemeasure_name}(itemid:${ paramObj.feemeasure_item_id})-->${ paramObj.feemeasure_province_name}</span>
				<input type="hidden" name="feemeasure_item_id" value="${ paramObj.feemeasure_item_id}" />
				<input type="hidden" name="feemeasure_id" value="${ paramObj.feemeasure_id}" />
				<input type="hidden" name="link_id" value="${ makefeeLink.link_id}" /></li>
				<input type="hidden" name="province" value="${ paramObj.feemeasure_province}" /></li>
			</ul>
	<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					
					<th>计费项名称</th>
					<!-- <th>计费项编码</th> -->
					<th>上游公司</th>
					<th>计费代码名称</th>
					<!--  <th>计费代码</th>-->
					<th>计费端口</th>					
					<th>指令</th>
					<th>费用</th>
				<!-- 	<th>二次确认</th>
					<th>二次确认端口</th>
					<th>二次确认内容</th>
					<th>二次确认类型</th>
					<th>短信验证前段信息</th>
					<th>短信验证后端信息</th>
					<th>短信验证内容</th>
					<th>是否过滤短信</th>
					<th>过滤端口</th>
					<th>过滤内容</th>
					<th>互联网计费规则</th>
					<th>发送短信时间间隔</th>
					<th>计费优先级</th>
						<th>状态</th> -->
					<th>省份</th>
					<th>状态</th>
					<!-- <th>备注</th>	 -->
					<th>更新时间</th>
					<th>条数</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty feeItemList}">
						<c:forEach items="${feeItemList}" var="v" varStatus="var">
							<c:if test="${fn:contains(paramObj.ref_items,v.cp_item_id)==true || v.item_status eq '0'   }">
							<tr>
							
								<td><input type="checkbox" name="makeFeeItem[${var.index}].cp_item_id" value="${ v.cp_item_id}"
								<c:if test="${fn:contains(paramObj.ref_items,v.cp_item_id)==true}">checked="checked"</c:if>  />
								    <input type="hidden" name="makeFeeItem[${var.index}].feecode_id" value="${ v.feecode_id}" />
								    <input type="hidden" name="makeFeeItem[${var.index}].command_id" value="${ v.command_id}" />
									</td>
								<td>${v.cp_item_name }</td>
								<!-- <td>${v.cp_item_code }</td>-->
								<td>${v.sp_name }</td>
								<td>${v.feecode_name }</td>
								<!--  <td>${v.feecode_code }</td>-->
								<td>${v.feecode_number }</td>
								<td>${v.command }</td>
								<td>${v.command_fee }</td>
							<!--  	<td>${v.is_second }</td>
								<td>${v.second_port }</td>
								<td>${v.second_info }</td>
								<td>${v.second_type }</td>
								<td>${v.replay_start_str }</td>
								<td>${v.replay_end_str }</td>
								<td>${v.replay_str }</td>
								<td>${v.is_filter }</td>
								<td>${v.filter_port }</td>
								<td>${v.filter_info }</td>
								<td>${v.network_role }</td>
								<td>${v.sms_delay_time }</td>
								
								<td>${v.use_priority }</td> -->
								<td>${v.open_province_name }</td>
								<td> <c:if test="${v.item_status eq 1 }">
								 	<font color="red">关闭</font>
								 </c:if>
								<c:if test="${v.item_status eq 0 }">
								 	<font color="grean">启用</font>
								 </c:if></td>
								<!--  <td>${v.remarks }</td>-->
								<td>${v.update_time }</td>
								<td><input name="makeFeeItem[${var.index}].item_count" type="text" value="1" checked="checked" /></td>
								</tr>
							</c:if>
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
	
	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
