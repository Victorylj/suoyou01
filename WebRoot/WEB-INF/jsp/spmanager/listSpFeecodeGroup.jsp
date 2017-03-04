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
<script type="text/javascript" src="js/artDialog/jquery.artDialog.js?skin=blue"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>



<script type="text/javascript">

$(function(){

		delSpFeecodeGroup =function(gid){
			art.dialog.confirm("确认删除该分组？", function() {
				if (!gid || gid == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				$.post("delSpFeecodeGroup.do", {"g_id" : gid}, function(result) {
					// alert("dsfdsfda");
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location = "listSpFeecodeGroup.do";
						}
					}, false);
				}, "json");
			}, function() {
		});
		
		//art.dialog.confirm('你确定要删除这掉消息吗？', function () {
		//    art.dialog.tips('执行确定操作');
		//}, function () {
		//    art.dialog.tips('执行取消操作');
		//});
	
	};
	
	
	
	$(".click").click(function(){
		art.dialog.load('editSpFeecodeGroup.do', {title: '提示',lock:true}, false);
	});
	
	upd = function(obj){
		var tds = $(obj).closest("tr").find("td");
		art.dialog.load('editSpFeecodeGroup.do', {title: '提示',lock:true,init: function(){
			$("#g_id").val(tds.eq(0).html());
			$("#g_name").val(tds.eq(1).html());
			var yy = tds.eq(2).text().trim();
			if(yy=="移动"){
				yy="1";
			}else if(yy=="联通"){
				yy="2";
			}else if(yy=="电信"){
				yy="3";
			}
			$("[name='g_op']").each(function(){
				if(this.value==yy){
					this.checked = true;
				}else{
					this.checked = false;
				}
			});
				
			
			$("#g_interval").val(tds.eq(3).html());
			$("#remarks").val(tds.eq(4).html());
		
		}}, false);
	};
	
	check = function () {
	    if ($("#g_name").val() === '') {
	        $("#g_name").focus();
	        return false;
	    } else {
	        return true;
	    };
	};
	
	
	getPageId = function(pageNum, nextPageId) {
		if (nextPageId > pageNum) {
			nextPageId = 1;
		}
		if (nextPageId < 1) {
			nextPageId = pageNum;
		}
		$("#searcherForm").append(
				"<input name='pageId' type='hidden' value='" + nextPageId + "'/>")
				.submit();
		};
	});

</script>

</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">上游代码</a></li>
			<li><a href="#">计费代码类型</a></li>
		</ul>
	</div>
<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
				<form id="searcherForm" action="listSpFeecodeGroup.do" method="post" onsubmit="initshow()">
					<li><label>分组类型名称</label><input name="g_name" type="text"
						class="scinput" /></li>
				
					<li><label>&nbsp;</label><input  type="submit"
						class="scbtn" value="查询" /></li>
				</form>
			</ul>
			

		</div>
<ul class="toolbar">
				<li class="click"><span><img src="images/t01.png" /></span>添加</li>

				<li onclick="multiDel()" style="display:none;"><span><img id="delBtn" src="images/t03.png" /></span>批量删除</li>

			</ul>
	<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
					<th>编号</th>
					<th>分组名称</th>
					<th>运营商</th>
					<th>时间间隔</th>
					<th>备注</th>
					<th>操作人</th>
					<th>更新时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">

							<tr>
								<td>${v.g_id}</td>
								<td>${v.g_name }</td>
								<td><c:if test="${v.g_op eq 1}">移动</c:if><c:if test="${v.g_op eq 2}">联通</c:if><c:if test="${v.g_op eq 3}">电信</c:if></td>
								<td>${v.g_interval}</td>
								<td>${v.remarks }</td>
								<td>${v.update_name }</td>
								<td>${v.update_time }</td>
								<td> 
								<a href="javaScript:void(0)" onclick="upd(this)" class="tablelink">修改</a>
								 <a href="javascript:delSpFeecodeGroup(${ v.g_id})" class="tablelink"> 删除</a></td>
							</tr>

						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="8">没有搜索到符合条件的数据！</td>
						</tr>
					</c:otherwise>
				</c:choose>

			</tbody>
		</table>
	</div>

		<div class="pagin">
				<div class="message">
					共
					<i class="blue">${page.total} </i>条记录，当前显示第&nbsp;
					<i class="blue">${page.pageNum}&nbsp;</i>页
				</div>
				<ul class="paginList">
					<li class="paginItem">
						<a href="javascript:;"
							onclick="getPageId(${page.pages},${page.pageNum-1})"><span
							class="pagepre"></span> </a>
					</li>
					<li class="paginItem current">
						<a href="javascript:;">${page.pageNum}</a>
					</li>
					<li class="paginItem">
						<a href="javascript:;"
							onclick="getPageId(${page.pages},${page.pageNum+1})">${page.pageNum+1}</a>
					</li>
					<li class="paginItem">
						<a href="javascript:;"
							onclick="getPageId(${page.pages},${page.pageNum+2})">${page.pageNum+2}</a>
					</li>
					<li class="paginItem">
						<a href="javascript:;"
							onclick="getPageId(${page.pages},${page.pageNum+3})">${page.pageNum+3}</a>
					</li>
					<li class="paginItem">
						<a href="javascript:;"
							onclick="getPageId(${page.pages},${page.pageNum+4})">${page.pageNum+4}</a>
					</li>
					<li class="paginItem more">
						<a href="javascript:;">...</a>
					</li>
					<li class="paginItem">
						<a href="javascript:;"
							onclick="getPageId(${page.pages},${page.pageNum+6})">${page.pageNum+6}</a>
					</li>
					
				</ul>
			</div>
	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
