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

<script type="text/javascript"  src="js/hideLoading.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".editdiv").fadeIn(200);
		});

		$(".editdivtop a").click(function() {
			$(".editdiv").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});
	});

	function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
		window.location = 'listGatewayInfo.do?pageId='+nextPageId;
	}
	
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
				<form id="searcherForm" action="listGatewayInfo.do" method="post">
				<li><label>综合查询</label><input name="" type="text"
					class="scinput" /></li>
				<li><label>指派</label>
					<div class="vocation">
						<select class="select3">
							<option>全部</option>
							<option>其他</option>
						</select>
					</div></li>

				<li><label>重点客户</label>
					<div class="vocation">
						<select class="select3">
							<option>全部</option>
							<option>其他</option>
						</select>
					</div></li>

				<li><label>客户状态</label>
					<div class="vocation">
						<select class="select3">
							<option>全部</option>
							<option>其他</option>
						</select>
					</div></li>

				<li><label>&nbsp;</label><input name="" type="button"
					class="scbtn" value="查询" /></li>
			</form>
			</ul>


		</div>

		<ul class="toolbar">
			<li class="click"><span><img src="images/t01.png" /></span>添加</li>
			<li><span><img src="images/t03.png" /></span>批量删除</li>
		</ul>
		<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>编号<i class="sort"><img src="images/px.gif" /></i></th>
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
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">

							<tr>
								<td><input type="checkbox" name="id" value="${ v.id}" /></td>
								<td>20130906</td>
								<td>${v.gateway_name }</td>
								<td>${v.gateway_code }</td>
								<td>${v.fee_name }</td>
								<td>${v.fee_code }</td>
								<td>${v.port }</td>
								<td>${v.command }</td>
								<td>${v.op }</td>
								<td>${v.open_province }</td>
								<c:if test="${v.gateway_status==0}">
									<td>开启</td>
								</c:if>
								<c:if test="${v.gateway_status==1}">
									<td>关闭</td>
								</c:if>
								<td>${v.update_time }</td>
								<td><a href="#" class="tablelink">查看</a> <a href="#" class="tablelink">修改</a> <a href="#"
									class="tablelink"> 删除</a></td>
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

		<div class="pagin">
			<div class="message">
				共<i class="blue">${page.total} </i>条记录，当前显示第&nbsp;<i class="blue">${page.pageNum}&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem"><a href="javascript:;"
					onclick="getPageId(${page.pages},${page.pageNum-1})"><span
						class="pagepre"></span></a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum}</a></li>
				<li class="paginItem current"><a href="javascript:;">${page.pageNum+1}</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+2}</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+3}</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+4}</a></li>
				<li class="paginItem more"><a href="javascript:;">...</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+6}</a></li>
				<li class="paginItem"><a href="javascript:;"
					onclick="getPageId(${page.pages},${page.pageNum+1})"><span
						class="pagenxt"></span></a></li>
			</ul>
		</div>


		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipinfo">
				<form action="">
					<ul class="form_info">
						<li><label>文章标题</label><input name="" type="text"
							class="df_input" /><i>标题不能超过30个字符</i></li>
						<li><label>关键字</label><input name="" type="text"
							class="df_input" /><i>多个关键字用,隔开</i></li>
						<li><label>是否审核</label><cite><input name=""
								type="radio" value="" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input
								name="" type="radio" value="" />否</cite></li>
						<li><label>引用地址</label><input name="" type="text"
							class="df_input"
							value="http://www.uimaker.com/uimakerhtml/uidesign/" /></li>
						<li><label>文章内容</label>
						<textarea name="" cols="" rows="" class="text_input"></textarea></li>
						<li><label>&nbsp;</label><input name="" type="button"
							class="btn" value="确认保存" /></li>
					</ul>
				</form>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>

		</div>

		<div class="editdiv">
			<div class="editdivtop">
				<span>提示信息</span><a></a>
			</div>
			<div class="form_body">
				<form action="addGateway.do" method="post" >
					<ul class="form_info">
						<li><label>网关名称</label><input name="gateway_name" type="text"
							class="df_input" /><i>标题不能超过30个字符</i></li>
						<li><label>网关代码:</label><input name="gateway_code" type="text"
							class="df_input" /><i>多个关键字用,隔开</i></li>
						<li><label>是否审核</label><cite><input name=""
								type="radio" value="" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input
								name="" type="radio" value="" />否</cite></li>
						<li><label>计费代码名称:</label><input name="fee_name" type="text"
							class="df_input"
							 /></li>
						<li><label>计费代码:</label>
						<textarea name="fee_code" cols="" rows="" class="text_input"></textarea></li>
						
					</ul>
					<ul class="form_info">
						<li><label>文章标题</label><input name="" type="text"
							class="df_input" /><i>标题不能超过30个字符</i></li>
						<li><label>关键字</label><input name="" type="text"
							class="df_input" /><i>多个关键字用,隔开</i></li>
						<li><label>是否审核</label><cite><input name=""
								type="radio" value="" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input
								name="" type="radio" value="" />否</cite></li>
						<li><label>引用地址</label><input name="" type="text"
							class="df_input"
							value="http://www.uimaker.com/uimakerhtml/uidesign/" /></li>
						<li><label>文章内容</label>
						<textarea name="" cols="" rows="" class="text_input"></textarea></li>
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="确认保存" /></li>
					</ul>
				</form>
			</div>

		</div>

	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
