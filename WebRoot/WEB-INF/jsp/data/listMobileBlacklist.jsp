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
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
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
<script type="text/javascript">


	//跳转页面
	$(function(){
		$(".click").click(function() {
			art.dialog({
	   		 	content: document.getElementById('editStatus'),
	    		title: "编辑黑名单",
	    		lock:true
			});
		});
		$(".click1").click(function() {
			art.dialog({
	   		 	content: document.getElementById('editStatus1'),
	    		title: "导入EXCEL",
	    		lock:true
			});
		});
		$("input[type=checkbox][name=mobiles]").click(function() {
             $('input[type=checkbox][name=mobile]').attr("checked",this.checked); 
        });
        $("input[type=checkbox][name=mobile]").click(function(){
             $("input[type=checkbox][name=mobiles]").attr("checked",$("input[type=checkbox][name=mobile]").length == $("input[type=checkbox][name=mobile]:checked").length ? true : false);
        });
        
        $("input[type=file]").change(function(){$(this).parents(".uploader").find("#file").val($(this).val());});
		$("input[type=file]").each(function(){
		if($(this).val()==""){$(this).parents(".uploader").find("#file").val("");}});
	
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
		window.location = 'getBlacklistMobile.do?pageId='+nextPageId+'&'+params;
	
	}
	function inputExcel(){
 		var params = $("#searcherForm").serialize();
		window.location = 'inputCallStat.do?';
 	}
	//删除
	function delBlacklistMobile(mobile){
		art.dialog.confirm("确认删除该选项？", 
			function() {
				if (!mobile || mobile == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				var url = "delBlacklistMobile.do";
				var data = {"mobile" : mobile};
				$.post(url, data, function(result) {
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location ="getBlacklistMobile.do";
						}
					}, false);
				}, "json");
			}
		);
	}
</script>


</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">计费代码限制</a></li>
			<li><a href="#">黑名单用户号码</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
			<form id="searcherForm" action="getBlacklistMobile.do" method="post"  onsubmit="initshow()">
					
				
					<li><label>用户号码</label><input name="mobile" type="text"
						class="scinput" value="${searchObj.mobile}" /></li>
					
					<li><label>&nbsp;</label><input  type="submit"
						class="scbtn" value="查询" /></li>
				</form>
				
				
				
			</ul>
		</div>
<ul class="toolbar">
				<li class="click"><span><img src="images/t01.png" /></span>添加</li>
				<li class="click1">导入EXCEL</li>

				<!--<li><span><img id="delBtn" src="images/t03.png" /></span>批量删除</li>-->
					
			</ul>
	<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="mobiles" type="checkbox" value="" /></th>
					<th>黑名单</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">
							<tr>
								<td><input type="checkbox" name="mobile" value="${v.mobile}" /></td>
								<td>${v.mobile}</td>
								<td><!-- <a href="#" class="tablelink">查看</a>  -->
								 <a href="javascript:delBlacklistMobile('${v.mobile}')" class="tablelink"> 删除</a>
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
					<li class="paginItem">
						<a href="javascript:;"
							onclick="getPageId(${page.pages},${page.pageNum+1})"><span
							class="pagenxt"></span> </a>
					</li>
				</ul>
		</div>

		
	</div>
	
	<div id="editStatus" style="display:none;">
	    <div class="formtitle"><span>新增黑名单用户</span><font style="color:red;margin-left:120px;">(*必填多个号码请用 & 隔开)</font></div>
	<div class="form_body">
				<form action="addBlacklistMobile.do" method="post">
					<ul class="form_info">
						<li><label>用户号码</label>
						<textarea name="mobiles"  cols="" rows="" class="textinput" onkeyup="this.value=this.value.replace(/[^0-9&]/g,'');"></textarea>
							<i></i></li>
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="提交" /></li>

					</ul>
				</form>
			</div></div>
	<div id="editStatus1" style="display:none;">
	    <div class="formtitle"><span>导入excel</span><font style="color:red;margin-left:120px;">(*选中模板excel文件)</font></div>
	<div class="form_body">
				<form action="inputExcel.do" method="post"  enctype="multipart/form-data">
					<ul class="form_info">
						<li ><label>EXCEl</label><div class="uploader white">
								<input type="text" id="file" name="file" readonly="readonly" class="dfinput filename" style="width:277px; float:left;" />
								<input type="button" class="button" value="浏览" /><input id="file" type="file" name="file"/>
						</div><i></i></li>
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="提交" /></li>

					</ul>
				</form>
			</div></div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
