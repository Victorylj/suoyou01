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
					<li><a href="listGatewayInfo.do">网关指令</a></li>	
					<li><a href="listCpInfo.do">cp渠道</a></li>
					<li><a href="listCpProductInfo.do">产品计费点</a></li>
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
						渠道信息
					</h2>
					<form id="searcherForm" action="listCpProductInfo.do" method="post">
					<div id="search_form" class="search">
						<div class="search_form">
							<div class="search_form_row">
								<label>CP产品名称:</label> <input type="text" class="search_form_input"
									name="product_name" />
							</div>
							<div class="search_form_row">
								<label>CP产品编号:</label> <input type="text" class="search_form_input"
									name="product_code" />
							</div>
						</div>	
					
						
						<div class="search_form">
				
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
								<th>CP名称</th>
								<th>CP产品名称</th>
								<th>CP产品编号</th>
								<th>CP产品包</th>
								<th>产品计费</th>
								<th>是否溢价</th>
								<th>备注</th>
								<th>修改时间</th>
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
											<td>${v.cp_id }</td>
											<td>${v.product_name}</td>
											<td>${v.product_code }</td>
											<td>${v.product_package }</td>
											<td>${v.product_fee }</td>
											<td>${v.is_overfee }</td>
											<td>${v.remarks }</td>
											<td>${v.update_time }</td>
											<td><a href="#"><img src="images/edit.png" alt=""
													title="" border="0" /></a></td>
											<td><a href="javascript:void(0);" onclick="deleteCpProductInfo(${ v.id})"><img src="images/trash.gif" alt=""
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
						<form action="addCpProductInfo.do" method="post">
							<div class="form">
								<div class="form_row">
									<label>CP名称:</label> <input type="text" class="form_input"
										name="cp_id" />
								</div>

								<div class="form_row">
									<label>CP产品名称:</label> <input type="text" class="form_input"
										name="product_name" />
								</div>
								<div class="form_row">
									<label>CP产品编码:</label> <input type="text" class="form_input"
										name="product_code" />
								</div>
								<div class="form_row">
									<label>CP产品包:</label> <input type="text" class="form_input"
										name="product_package" />
								</div>
								<div class="form_row">
									<label>CP产品计费:</label> <input type="text" class="form_input"
										name="product_fee" />
								</div>
								<div class="form_row">
									<label>是否溢价:</label> <input type="text" class="form_input"
										name="is_overfee" />
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
<script src="js/cpservice/listCpInfo.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
