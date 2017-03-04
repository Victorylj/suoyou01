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
<style type="text/css">
	.button{
		height:34px;
		width:70px;
		display:inline-block;
		outline:0 none;
		padding:8px 12px;
		margin:0;
		cursor:pointer;
		border:1px solid;
		font:bold 9pt/100% Arial, Helvetica, sans-serif;
		-moz-border-radius:0px 5px 5px 0px;
		-webkit-border-radius:0px 5px 5px 0px;
		border-radius:0px 5px 5px 0px;
		-moz-box-shadow:0px 0px 1px #fff inset;
		-webkit-box-shadow:0px 0px 1px #fff inset;
		box-shadow:0px 0px 1px #fff inset;
	}
	.uploader{position:relative;display:inline-block;}
	.uploader input[type=file]{
		position:absolute;
		top:0; right:0; bottom:0;
		border:0;
		padding:0; margin:0;
		height:32px;
		border:1px solid red;
		width:347px;
		display:inline-block;
		cursor:pointer;
		filter:alpha(opacity=0);
		-moz-opacity:0;
		-khtml-opacity: 0;
		opacity:0;
	}
	.white .button{
		color:#555;
		text-shadow:1px 1px 0px #fff;
		background:#ddd;
		background:-moz-linear-gradient(top, #eeeeee 0%, #dddddd 100%);
		background:-webkit-gradient(linear, left top, left bottom, color-stop(0%,#eeeeee), color-stop(100%,#dddddd));
		filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#eeeeee', endColorstr='#dddddd',GradientType=0);
		border-color:#ccc;
	}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=blue"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript">
	//跳转页面
	$(function(){
		$(".click").click(function() {
			art.dialog({
	   		 	content: document.getElementById('editStatus'),
	    		title: "编辑上传APK包文件",
	    		lock:true
			});
		});
		/*
		$("input[type=checkbox][name=mobiles]").click(function() {
             $('input[type=checkbox][name=mobile]').attr("checked",this.checked); 
        });
        $("input[type=checkbox][name=mobile]").click(function(){
             $("input[type=checkbox][name=mobiles]").attr("checked",$("input[type=checkbox][name=mobile]").length == $("input[type=checkbox][name=mobile]:checked").length ? true : false);
        });*/
        $("input[type=file]").change(function(){$(this).parents(".uploader").find(".filename").val($(this).val());});
		$("input[type=file]").each(function(){
		if($(this).val()==""){$(this).parents(".uploader").find(".filename").val("");}});
	
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
		window.location = 'listCpApkVersion.do?pageId='+nextPageId+'&'+params;
	
	}
	function updCpApk(obj){
		var tds = $(obj).closest("tr").find("td");
		var id = $(obj).closest("tr").attr("id");
		$("#editStatus").find("form").attr("action","updcpapk.do");
		art.dialog({
	   		 content: document.getElementById('editStatus'),
	    	 title: "编辑上传APK包文件",
	    	 lock:true,
	    	 init: function(){
	    	 		$("#id").val(id);
	    	 		$("#delname").val(tds.eq(4).html());
	    	 		$("#channel").val(tds.eq(1).html());
	    	 		$("#packages").val(tds.eq(2).html());
	    	 		$("#filename").val(tds.eq(4).html());
	    	 		$("#version").val(tds.eq(3).html());
	    	 }
		});
	}
	//删除
	function delCpApk(id,name){
		art.dialog.confirm("确认删除该选项？", 
			function() {
				if (!id || id == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				var url = "delcpapk.do";
				var data = {"id" : id, "filename" : name};
				$.post(url, data, function(result) {
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location ="listCpApkVersion.do";
						}
					}, false);
				}, "json");
			}
		);
	}
	
	function check(){
		if($("#id").val()==""){
			if($("#file").val()==""){
				art.dialog({icon: 'warning',time: 1,lock:true,content: '请选择APK文件!'});
				return false;
			}
			if($("#filename").val()==""){
				art.dialog({icon: 'warning',time: 1,lock:true,content: '请选择APK文件!'});
				return false;
			}
		}else{
			if($("#file").val()==""){
				$("#editStatus").find("form").attr("action","updCpApkBycp.do");
			}
		}
		return true;
	}
</script>


</head>


<body>

	<div class="place" style="l">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">文件管理</a></li>
			<li><a href="#">APK版本管理</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
			<form id="searcherForm" action="listCpApkVersion.do" method="post"  onsubmit="initshow()">
					<li><label>渠道</label><input name="channel" type="text"
						class="scinput" value="${searchObj.channel }" /></li>
					<li><label>包名</label><input name="packages" type="text"
						class="scinput" value="${searchObj.packages }" /></li>
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
					<th>文件名</th>
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
								<td>${v.filename}</td>
								<td>${v.updatetime}</td>
								<td><!-- <a href="#" class="tablelink">查看</a>  -->
								 <a href="${v.url}" class="tablelink"> 下载</a>
								 <a href="javascript:void(0)" onclick="updCpApk(this)" class="tablelink"> 修改</a>
								 <a href="javascript:delCpApk(${v.id},'${v.filename}')" class="tablelink"> 删除</a>
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
	
	<div id="editStatus" style="display:none;">
	    <div class="formtitle"><span>编辑APK版本文件</span><font style="color:red;margin-left:120px;"></font></div>
	<div class="form_body">
				<form action="addcpapk.do" method="post" enctype="multipart/form-data" target="" onsubmit="return check()">
					<input id="id" name="id" type="hidden"/>
					<input id="delname" name="delname" type="hidden"/>
					<input id="version" name="version" type="hidden"/>
					<ul class="form_info">
						<li><label>渠道</label><input id="channel" name="channel" type="text" class="dfinput"/><i></i></li>
						<li><label>包名</label><input id="packages" name="packages" type="text" class="dfinput"/><i></i></li>
						<li><label>APK</label><div class="uploader white">
								<input type="text" id="filename" name="filename" readonly="readonly" class="dfinput filename" style="width:277px; float:left;" />
								<input type="button" class="button" value="浏览" /><input id="file" type="file" name="file"/>
						</div><i></i></li>
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="提交" /></li>

					</ul>
				</form>
				<iframe name='hidden_frame' id="hidden_frame" style="display:none"></iframe> 
			</div></div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
