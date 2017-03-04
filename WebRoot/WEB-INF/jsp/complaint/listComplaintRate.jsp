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
<script type="text/javascript" src="js/stat/listFeecodeStat.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=blue"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/laydate/laydate.js"></script>
<script type="text/javascript"  src="js/searchSelect.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript">
$(document).ready(function() {
		$(".click1").click(function() {
			var str = $(this).text();
			if(str.indexOf("开启")>=0){
				str = "开启";
			}else{
				str = "关闭";
			}
			var length = $("input[type=checkbox][name=cp_id]:checked").length;
			if(length<=0){
				art.dialog({
				    content: '未选择数据!',
				    time: 1,
				    lock:true
				    
				});
				return;
			}
			//var ccpid="";
			//$("input[type=checkbox][name=cp_id]:checked").each(function(){ 
			//	ccpid+=$(this).val();  
			//});
			art.dialog.confirm("确认"+str+"以下渠道？", 
				function() {
					$('#mvForm').submit();
				}
			);
		});
		
		$("#cpAll_id").click(function() {
             $('input[name=cp_id]').attr("checked",this.checked); 
        });
        $("input[type=checkbox][name=cp_id]").click(function(){
             $("#cpAll_id").attr("checked",$("input[type=checkbox][name=cp_id]").length == $("input[type=checkbox][name=cp_id]:checked").length ? true : false);
        });
		
		$(".click2").click(function() {
			//$(".editdiv").fadeIn(200);
			var str = $(this).text();
			if(str.indexOf("开启")>=0){
				str = "添加开启";
			}else{
				str = "添加关闭";
			}
			$(".formtitle").find("span").html(str);
			art.dialog({
   		 		content: document.getElementById('editStatus'),
    			title: "渠道状态修改",
    			lock:true
			});
	 
		});
		$("#sp_select").searchInit({searchObj:"sp_select", searchText: "ch_name", searchId: "cp_id", searchUrl: "/seachChannelList.do"});
	});
	function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
		var params = $("#searcherForm").serialize();
		window.location = 'listAllCallStat.do?pageId='+nextPageId+'&'+params;
	}
	
	 function exportExcel(){
	 		var params = $("#searcherForm").serialize();
		window.location = 'exportCallStat.do?'+params;
	 }
	 
	 
	
	 
	 
</script>

</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据统计</a></li>
			<li><a href="#">投拆统计</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
		<form id="searcherForm" action="listComplaintRate.do" method="post" onsubmit="initshow()">
			<ul class="seachform">
											
				<li><label>时间</label><input name="start_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput" value="${searchObj.start_time }"/>--
					<input name="end_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput"  value="${searchObj.end_time }" /></li>	
					<li> 

					<label>
						<input name="tag" type="radio" value="1" <c:if test="${searchObj.tag eq 1}">checked="checked" </c:if> />
						类别1</label>
						<label>
						<input name="tag" type="radio" value="2" <c:if test="${searchObj.tag eq 2}">checked="checked" </c:if> />
						类别2</label>
					</li>	
					<li> 
					<label>&nbsp;</label>
					<input  type="submit"
						class="scbtn" value="查询" /></li>
				
				
			</ul>
			</form>
		
		</div>
		  <ul class="toolbar">
     		<c:if test="${searchObj.tag==1}">
				<li class="click1"><span><img src="images/t01.png" /></span>批量关闭</li>
			</c:if>
			<c:if test="${searchObj.tag==2}">
				<li class="click1"><span><img src="images/t01.png" /></span>批量开启</li>
			</c:if>
		
	</ul>

	<div class="divtable">
	<form id="mvForm" action="mvComplaintStat.do?tag=${searchObj.tag}" method="post" onsubmit="initshow()">
		<table class="tablelist">
			<thead>
				<tr>
				<th><input type="checkbox" id="cpAll_id" /></th>
				<th>日期</th>
				<th>渠道</th>
				<th>投诉个数</th>
				<th>初始化用户数</th>
				<th>万投</th>
				</tr>
			</thead>

			<tbody>
				<c:choose>
					<c:when test="${not empty retlist}">
						<c:forEach items="${retlist}" var="v" varStatus="var">
							<tr>
							<td><input type="checkbox" name="cp_id" value="${v.cp_id}" />
								</td>
								<td>${searchObj.start_time }-${searchObj.end_time }</td>
								<td>${v.ch_name }</td>
								<td>${v.cusers }</td>
								<td>${v.allinit }</td>

								<td>${v.rate}</td>
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
			</form>
	</div>

		<%-- <div class="pagin">
			<div class="message">
				共<i class="blue">${page.total} </i>条记录，当前显示第&nbsp;<i class="blue">${page.pageNum}&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem"><a href="javascript:;"
					onclick="getPageId(${page.pages},${page.pageNum-1})"><span
						class="pagepre"></span></a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum}</a></li>
			<!--  	<li class="paginItem current"><a href="javascript:;">${page.pageNum+1}</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+2}</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+3}</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+4}</a></li>
				<li class="paginItem more"><a href="javascript:;">...</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+6}</a></li>-->
				<li class="paginItem"><a href="javascript:;"
					onclick="getPageId(${page.pages},${page.pageNum+1})"><span
						class="pagenxt"></span></a></li>
			</ul>
		</div> --%>

		<div id="delDiv" class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认删除信息 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>

		</div>
	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
