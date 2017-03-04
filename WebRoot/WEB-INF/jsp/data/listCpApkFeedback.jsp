<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=blue"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/laydate/laydate.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript">
	//跳转页面
	$(function(){
		
		/*
		$("input[type=checkbox][name=mobiles]").click(function() {
             $('input[type=checkbox][name=mobile]').attr("checked",this.checked); 
        });
        $("input[type=checkbox][name=mobile]").click(function(){
             $("input[type=checkbox][name=mobiles]").attr("checked",$("input[type=checkbox][name=mobile]").length == $("input[type=checkbox][name=mobile]:checked").length ? true : false);
        });*/

	
	});
	//分页
	function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
		
		var params = $("#searcherForm").serialize();
		window.location = 'listCpApkFeedback.do?pageId='+nextPageId+'&'+params;
	
	}
	//删除
	function delCpApk(id,name){
		art.dialog.confirm("确认删除该选项？", 
			function() {
				if (!id || id == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				var url = "delCpApkFeedback.do";
				var data = {"id" : id};
				$.post(url, data, function(result) {
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location ="listCpApkFeedback.do";
						}
					}, false);
				}, "json");
			}
		);
	}
</script>


</head>


<body>

	<div class="place" style="l">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">文件管理</a></li>
			<li><a href="#">APK版本反馈</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
			<form id="searcherForm" action="listCpApkFeedback.do" method="post"  onsubmit="initshow()">
					
				
					<li><label>时间</label><input name="start_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput" value="${searchObj.start_time }"/>--
					<input name="end_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput"  value="${searchObj.end_time }" /></li>	
					
					<li><label>&nbsp;</label><input  type="submit"
						class="scbtn" value="查询" /></li>
				</form>
			</ul>
		</div>
<ul class="toolbar">
				<li class="click"><span><img src="images/t01.png" /></span>添加</li>

				<!--<li><span><img id="delBtn" src="images/t03.png" /></span>批量删除</li>-->

			</ul>
	<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
					<!--<th><input name="mobiles" type="checkbox" value="" /></th>-->
					<th>序号</th>
					<th>渠道</th>
					<th>包名</th>
					<th>版本</th>
					<th>反馈见意</th>
					<th>更新时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">
							<tr id="${v.id}">
								<!--<td><input type="checkbox" name="mobile" value="" /></td>-->
								<td>${v.id}</td>
								<td>${v.channel}</td>
								<td>${v.packages}</td>
								<td>${v.version}</td>
								<td>${v.text}</td>
								<td>${v.savetime}</td>
								<td>
								 <a href="javascript:delCpApk(${v.id})" class="tablelink"> 删除</a>
								 </td> 
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="11">没有搜索到符合条件的数据！</td>
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
					
				</ul><br />
		</div>

		
	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
