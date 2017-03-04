<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="page" uri="http://www.bluesky.com/pagination" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>代码</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/styles.css" />
<link rel="stylesheet" type="text/css" href="css/pop.css" />
<!-- jQuery file -->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="panelwrap">

		<div class="header">
			<div class="title">
				<a href="#">管理后台</a>
			</div>

			<div class="header_right">
				欢迎
				<!--<a href="#" class="settings">Settings</a> <a href="#" class="logout">Logout</a> -->
			</div>

			<div class="menu">
				<ul>
					<li><a href="#" class="selected">主页</a></li>
					<li><a href="#">网关</a></li>
					<li><a href="#">计费代码</a></li>
					<li><a href="#">指令</a></li>
					<li><a href="#">cp渠道</a></li>
					<li><a href="#">产品</a></li>
					<li><a href="#">计费点</a></li>
					<li><a href="#">计费工具</a></li>
				</ul>
			</div>
		</div>
		<!--
    <div class="submenu">
		<ul>
		<li><a href="#" class="selected">settings</a></li>
		<li><a href="#">users</a></li>
		<li><a href="#">categories</a></li>
		<li><a href="#">edit section</a></li>
		<li><a href="#">templates</a></li>
		</ul>
    </div>     
	-->
		<div class="center_content">
			<div id="right_wrap">
				<div id="right_content">
					<h2>
						网关信息
					</h2>
					<form id="searcherForm" action="listGatewayInfo.do" method="post">
					<div id="search_form" class="search">
						<div class="search_form">
							<div class="search_form_row">
								<label>网关名称:</label> <input type="text" class="search_form_input"
									name="gateway_name" />
							</div>
							<div class="search_form_row">
								<label>网关代码:</label> <input type="text" class="search_form_input"
									name="gateway_code" />
							</div>
						</div>	
						<div class="search_form">
							<div class="search_form_row">
								<label>代码名称:</label> <input type="text" class="search_form_input"
									name="fee_name" />
							</div>
							<div class="search_form_row">
								<label>计费代码:</label> <input type="text" class="search_form_input"
									name="fee_code" />
							</div>
						</div>
						<div class="search_form">
							<div class="search_form_row">
								<label>端口:</label> <input type="text" class="search_form_input"
									name="port" />
							</div>
							<div class="search_form_row">
								<label>指令:</label> <input type="text" class="search_form_input"
									name="command" />
							</div>
						</div>
						<div class="search_form">
							<div class="search_form_row">
								<label>状态</label> <select class="search_form_select"
									name="gateway_status">
									<option value="0">启用</option>
									<option value="1">关闭</option>
								</select>
							</div>
							<div class="search_form_row">
		
								<input type="submit" class="button green" value="查询" />
								<input type="button" id=btnTest value='新增' onclick="popupDiv('pop-div');" />
							
							</div>
						</div>
					</div>
					</form>
					<table id="rounded-corner">
						<thead>
							<tr>
								<th></th>
								<th>网关名称</th>
								<th>网关编码</th>
								<th>计费代码名称</th>
								<th>计费代码</th>
								<th>端口</th>
								<th>指令</th>
								<th>运营商</th>
								<th>省份</th>
								<th>状态</th>
								<th>更新时间</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="13">
								<div class="form_sub_buttons">
						<a href="#" class="button red">删除</a>
					</div>
								<div class="pages">
								<span>共<font> ${page.total} </font>条</span>
								<a href="javascript:void(0);" onclick="getPageId(${page.pages},${page.pageNum-1})"><<上一页</a>
								<b>${page.pageNum}</b>
								<a  href="javascript:void(0);" onclick="getPageId(${page.pages},${page.pageNum+1})">下一页>></a>
								
								</div>
								 </td>
								
							</tr>
						</tfoot>
						<tbody>
							<c:choose>
								<c:when test="${not empty page.list}">
									<c:forEach items="${page.list}" var="v" varStatus="var">

										<tr class="odd">
											<td><input type="checkbox" name="id" value="${ v.id}" /></td>
											<td>${v.gateway_name }</td>
											<td>${v.gateway_code }</td>
											<td>${v.fee_name }</td>
											<td>${v.fee_code }</td>
											<td>${v.port }</td>
											<td>${v.command }</td>
											<td>${v.op }</td>
											<td>${v.open_province }</td>
											<td>${v.gateway_status }</td>
											<td>${v.update_time }</td>
											<td><a href="#"><img src="images/edit.png" alt=""
													title="" border="0" /></a></td>
											<td><a href="javascript:void(0);" onclick="deleteGatewayInfo(${ v.id})"><img src="images/trash.gif" alt=""
													title="" border="0" /></a></td>
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
			</div>
			<!-- end of right content-->
			<div id='pop-div' class="pop-box"
				style="position: absolute; top: 5px;">
				<div class="pop-box-body">

					<div id="tab1" class="tabcontent">
						<h3>
							<label>编辑</label><input id="btnClose" type="button"
								onclick="hideDiv('pop-div');" value="关闭" />
						</h3>
						<form action="addGateway.do" method="post">
							<div class="form">
								<div class="form_row">
									<label>网关名称:</label> <input type="text" class="form_input"
										name="gateway_name" />
								</div>
								<div class="form_row">
									<label>网关代码:</label> <input type="text" class="form_input"
										name="gateway_code" />
								</div>
								<div class="form_row">
									<label>计费代码名称:</label> <input type="text" class="form_input"
										name="fee_name" />
								</div>
								<div class="form_row">
									<label>计费代码:</label> <input type="text" class="form_input"
										name="fee_code" />
								</div>
								<div class="form_row">
									<label>端口:</label> <input type="text" class="form_input"
										name="port" />
								</div>
								<div class="form_row">
									<label>指令:</label> <input type="text" class="form_input"
										name="command" />
								</div>
								
								<div class="form_row">
									<label>联网类型:</label> <input type="text" class="form_input"
										name="network_role" />
								</div>
								<div class="form_row">
									<label>延迟发送时间:</label> <input type="text" class="form_input"
										name="sms_delay_time" />
								</div>
								<div class="form_row">
									<label>发送次数:</label> <input type="text" class="form_input"
										name="charge_count" />
								</div>
								<div class="form_row">
									<label>计费:</label> <input type="text" class="form_input"
										name="fee" />
								</div>
							
								<div class="form_row">
									<label>优先级:</label> <select class="form_select"
										name="gateway_level">
										<option value="1">1级</option>
										<option value="2">2级</option>
										<option value="3">3级</option>
										<option value="4">4级</option>
										<option value="5">5级</option>
									</select>
								</div>
								<div class="form_row">
									<label>客服号:</label> <input type="text" class="form_input"
										name="service_call" />
								</div>
								
								<div class="form_row">
									<label>状态</label> <select class="form_select"
										name="gateway_status">
										<option value="0">启用</option>
										<option value="1">关闭</option>
									</select>
								</div>


							</div>
							<div class="form">

								
								<div class="form_row">
									<label>是否二次确认:</label> 
									<select class="form_select"
										name="is_second">
										<option value="0">是</option>
										<option value="1">否</option>
									</select>
								</div>
								
								<div class="form_row">
									<label>二次确认端口:</label> <input type="text" class="form_input"
										name="second_port" />
								</div>
								<div class="form_row">
									<label>二次确认内容:</label> <input type="text" class="form_input"
										name="second_info" />
								</div>
								<div class="form_row">
									<label>二次确认类型:</label> <input type="text" class="form_input"
										name="second_type" />
								</div>
								<div class="form_row">
									<label>确认起始字符:</label> <input type="text" class="form_input"
										name="reply_start_str" />
								</div>
								<div class="form_row">
									<label>确认结束字符:</label> <input type="text" class="form_input"
										name="reply_end_str" />
								</div>
								<div class="form_row">
									<label>确认字符:</label> <input type="text" class="form_input"
										name="reply_str" />
								</div>
										
								<div class="form_row">
									<label>是否过滤:</label> 
									<select class="form_select"
										name="is_filter">
										<option value="0">是</option>
										<option value="1">否</option>
									</select>
								</div>
								<div class="form_row">
									<label>过滤端口:</label> <input type="text" class="form_input"
										name="filter_port" />
								</div>
								<div class="form_row">
									<label>过滤内容:</label> <input type="text" class="form_input"
										name="filter_info" />
								</div>						

								<div class="form_row">
									<label>备注:</label>
									<textarea class="form_textarea" name="remarks" ></textarea>
								</div>
								<div class="form_row">
									<input type="submit" class="form_submit" value="提交" />
								</div>
								<div class="clear"></div>
							</div>
						</form>
					</div>
				</div>

			</div>

			<div class="clear"></div>
		</div>
		<!--end of center_content-->

		<div class="footer">
			<a href="" title="网站" target="_blank">网站</a>
		</div>

	</div>

</body>


</html>
<script src="js/popdiv.js"></script>
<script src="js/pop.js"></script>
<script src="js/gateway/listGatewayInfo.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
