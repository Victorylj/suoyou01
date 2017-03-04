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
		$("input[type=checkbox][name=mobiles]").click(function() {
             $('input[type=checkbox][name=mobile]').attr("checked",this.checked); 
        });
        $("input[type=checkbox][name=mobile]").click(function(){
             $("input[type=checkbox][name=mobiles]").attr("checked",$("input[type=checkbox][name=mobile]").length == $("input[type=checkbox][name=mobile]:checked").length ? true : false);
        });
	
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
			<li><a href="#">测试查询</a></li>
			<li><a href="#">测试查询</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
			<form id="searcherForm" action="getRequstInfoList.do" method="post"  onsubmit="initshow()">
					
				
					<li><label>用户IMSI</label><input name="mobile_imsi" type="text"
						class="scinput" value="${searchObj.mobile_imsi}" /></li>
					<li><label>产品编号</label><input name="ccp_id" type="text"
						class="scinput" value="${searchObj.ccp_id}" /></li>
					<li><label>&nbsp;</label><input  type="submit"
						class="scbtn" value="查询" /></li>
				</form>
			</ul>
		</div>
	<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
					<th>IMSI</th>
					<th>计费点</th>
					<th>产品编号</th>
					<th>省份</th>
					<th>包名</th>
					<th>结果</th>
					<th>结果说明</th>
					<th>时间</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty reqList}">
						<c:forEach items="${reqList}" var="v" varStatus="var">
							<tr>
						
								<td>${v.mobile_imsi}</td>
								<td>${v.appfee_id}</td>
								<td>${v.ccp_id}</td>
								<td>${v.province_name}</td>
								<td>${v.packagestr}</td>
								<td>${v.error_name}</td>
								<td>${v.error_info}</td>
								<td>${v.create_time}</td>
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

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
