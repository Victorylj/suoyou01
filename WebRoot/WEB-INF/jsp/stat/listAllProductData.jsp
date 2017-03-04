<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/laydate/laydate.js"></script>
<script type="text/javascript"  src="js/searchSelect.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript"  src="js/tableTitle.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".select3").uedSelect({
			width : 100
		});
		$("#my_select").searchInit({searchObj:"my_select", searchText: "cpname", searchId: "cpid",result:"result", searchUrl: "/getAllcp.do"});
		$("#searchCode").searchInit({searchObj:"searchCode", searchText: "proname", searchId: "proid",result:"result1", searchUrl: "/getAllproduct.do"});

		$('.tablelist tbody tr:odd').addClass('odd');
	});
	
	
		
		function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
				var params = $("#searcherForm").serialize();
		window.location = 'listAllCompanyStat.do?pageId='+nextPageId+'&'+params;
	}
	 function exportExcel(){
	 		var params = $("#searcherForm").serialize();
		//window.location = 'exportRateDetail.do?'+params;
	 }
	 

</script>

</head>


<body>

	<div class="place" on>
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据统计</a></li>
			<li><a href="#">产品</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
		<form id="searcherForm" action="listALLProductStat.do" autocomplete="off" method="post" onsubmit="initshow()">
			<ul class="seachform">
				<li><label>渠道</label>
						<div class="vocation" id="my_select" style="height:32px">
                	   <div class="select3">
                	    <input id="cpname" name="cpname" class="scinput" value="${searchObj.cpname}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result" style="position:absolute; display:none; top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="cpid" name="cpid" type="hidden" value="${searchObj.cpid}"/> 
                	   </div>
                	   
					</div></li>
					<li><label>产品</label>
						<div class="vocation" id="searchCode">
					
						 <div class="select3">
                	    <input id="proname" name="proname" class="scinput" value="${searchObj.proname}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result1" style="position:absolute; display:none; top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="proid" name="proid" type="hidden" value="${searchObj.proid}"/> 
                	   </div>
					</div></li>
					<li><label>时间</label><input name="start_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput" value="${searchObj.start_time }"/>--
					<input name="end_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput"  value="${searchObj.end_time }" /></li>	
					<li>
					
					<label>&nbsp;</label>
					<input  type="submit"
						class="scbtn" value="查询" /></li>
					<li>	
						<label>&nbsp;</label>
					<input  type="button"
						class="scbtn" value="导出" onclick="exportExcel()" /></li>		

		</ul>
		
			</form>
		
		</div>
<div class="divtable" style="overflow-x:hidden;">
		<table class="tablelist" >
			<thead>
				<tr>
					<th>日期</th>
					<!-- <th>渠道</th> -->
					<th>产品编号</th>
					<th>产品</th>
					<th>安装数</th>
					<th>计费条数</th>
					<th>收入(元)</th>
				</tr>
			</thead>
		</table>
	 </div>
	<div class="divtable">
		<table class="tablelist" style="margin-top:-36px;">
			<thead>
				<tr>
					<th>日期</th>
					<!-- <th>渠道</th> -->
					<th>产品编号</th>
					<th>产品</th>
					<th>安装数</th>
					<th>计费条数</th>
					<th>收入(元)</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
					 <c:set var="initnumsum" value="0"></c:set>
					  <c:set var="succ_userssum" value="0"></c:set>
					   <c:set var="feesum" value="0"></c:set>
						<c:forEach items="${page.list}" var="v" varStatus="var">

							<tr id="${v.dater }">
								<td>${v.dater }</td>
								<td id="${v.cpid}">${v.proid }</td>
								<td id="${v.proid}">${v.proname }</td>				
								<td>${v.initnum }</td>
								<td>${v.succ_users }</td>
								<td onclick="edits(this,'fee')">${v.fee }</td>
							</tr>
							<c:set var="initnumsum" value="${initnumsum+v.initnum}"></c:set>
							<c:set var="succ_userssum" value="${succ_userssum+v.succ_users}"></c:set>		
							<c:set var="feesum" value="${feesum+v.fee}"></c:set>	

						</c:forEach>
						<tr><td colspan='3'>总计</td><td>${initnumsum}</td><td>${succ_userssum}</td><td id="sumfee">${feesum}</td></tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="10">没有搜索到符合条件的数据！</td>
						</tr>
					</c:otherwise>
				</c:choose>
				<script type="text/javascript">
			    a = "${feesum}";
			    a = a.substr(0,a.indexOf(".")+3);
			    $("#sumfee").html(a);
				</script>
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
		</div>

		
	</div>
<script type="text/javascript">
	var gorlInput;
	var gorlNumber;
	var bo = false;
	function edits(obj,name){
		var number = $(obj).html();
		if($(obj).find("input").length==0){
			if(bo){return;}
			if(gorlInput!=null){gorlInput.closest("td").html(gorlNumber);}
			gorlNumber = number;
			gorlInput = $('<input class="scinput" style="width:50px" type="text" value="'+number+'">');
			gorlInput.unbind();
			gorlInput.keydown(function(e){
				e=e||window.event;  
	            if(e.keyCode==13){
	            	if(isNaN(parseFloat(gorlInput.val()))){gorlInput.closest("td").html(gorlNumber);return;}
	            	if(gorlNumber==gorlInput.val()){ gorlInput.closest("td").html(gorlInput.val());return;}
	            	var tds = $(this).closest("tr").find("td");
	            	$.post("updCalldetailFee.do", {dater:tds.eq(0).html(),cpid:tds.eq(1).attr("id"),proid:tds.eq(2).attr("id"),fee:parseFloat($(this).val()),uname:name}, function(data, status){
						if(data=="0"){
							art.dialog({icon: 'warning',time: 1,lock:true,content: '修改失败!'});
						}else{
							gorlInput.closest("td").html(parseFloat(gorlInput.val()));
							var sum = $("#sumfee").html();
							sum = todoublt(sum)-todoublt(gorlNumber)+todoublt(gorlInput.val());
							$("#sumfee").html(sum);
						}
	            	});
	            }  
			});
			gorlInput.blur(function(){
				if(isNaN(parseFloat(gorlInput.val()))){gorlInput.closest("td").html(gorlNumber);return;}
				if(gorlNumber==gorlInput.val()){gorlInput.closest("td").html(gorlInput.val());return;}
				bo = true;
				var tds = $(this).closest("tr").find("td");
				$.post("updCalldetailFee.do", {dater:tds.eq(0).html(),cpid:tds.eq(1).attr("id"),proid:tds.eq(2).attr("id"),fee:parseFloat($(this).val()),uname:name}, function(data, status){
					if(data=="0"){
						art.dialog({icon: 'warning',time: 1,lock:true,content: '修改失败!'});
					}else{
						gorlInput.closest("td").html(parseFloat(gorlInput.val()));
						var sum = $("#sumfee").html();
						sum = todoublt(sum)-todoublt(gorlNumber)+todoublt(gorlInput.val());
						$("#sumfee").html(sum);
					}
					bo = false;
	            });

			});
			gorlInput.keyup(function(){
				//alert(/^[0-9]+(.[0-9])?$/.test(this.value))
			
				//this.value=this.value.replace(/\D/g,'');
			});
			$(obj).html(gorlInput);
			gorlInput.select();
		}
	};
	function todoublt(str){
		if(str==""||str==null){
			return 0;
		}
		if(isNaN(str)){
			return 0;
		}
		return  parseFloat(str);
	}
</script>

</body>

</html>
