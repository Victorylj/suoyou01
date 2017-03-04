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
		var cascade = function(obj){
	 	$.ajax({
	         type:'post',
	         url: 'getAllfeecode.do',
	         data:'pid='+obj.id,
	         dataType:'text',
	         success:function(result){
		         $("#searchCode").initData(result,{result:"result1", searchText: "feecodes",defaultStr:true,searchId: "feecode_id"});
			 },
	         error:function(){
	             alert("failed.");
	         }
	     });
	 }
		$("#my_select").searchInit({searchObj:"my_select", searchText: "company", searchId: "com_id",result:"result", searchUrl: "/getAllcompany.do",cascade:cascade});
		
		$("#searchCode").searchInit({searchObj:"searchCode", pid:"com_id", searchText: "feecode_name", searchId: "feecode_id", result:"result1", searchUrl: "/getAllfeecode.do"});
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
			<li><a href="#">合作方</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
		<form id="searcherForm" action="listAllCompanyStat.do" autocomplete="off" method="post" onsubmit="initshow()">
			<ul class="seachform">
				<li><label>合作方</label>
						<div class="vocation" id="my_select" style="height:32px">
                	   <div class="select3">
                	    <input id="company" name="company" class="scinput" value="${searchObj.company}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result" style="position:absolute; display:none; top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="com_id" name="com_id" type="hidden" value="${searchObj.com_id}"/> 
                	   </div>
                	   
					</div></li>
					<li><label>业务名称</label>
						<div class="vocation" id="searchCode">
					
						 <div class="select3">
                	    <input id="feecode_name" name="feecode_name" class="scinput" value="${searchObj.feecode_name}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result1" style="position:absolute; display:none; top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="feecode_id" name="feecode_id" type="hidden" value="${searchObj.feecode_id}"/> 
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
					<th>合作方</th>
					<th>业务名称</th>
					<th>用户数</th>
					<th>计费条数</th>
					<th>单价(分)</th>
					<th>成功条数</th>
					<th>信息费</th>
					<th>结算比例</th>
					<th>结算金额(元)</th>
				</tr>
			</thead>
		</table>
	 </div>
	<div class="divtable">
		<table class="tablelist" style="margin-top:-36px;">
			<thead>
				<tr>
					<th>日期</th>
					<th>合作方</th>
					<th>业务名称</th>
					<th>用户数</th>
					<th>计费条数</th>
					<th>单价(分)</th>
					<th>成功条数</th>
					<th>信息费</th>
					<th>结算比例</th>
					<th>结算金额(元)</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
					 <c:set var="succ_callsum" value="0"></c:set>
					  <c:set var="succ_numsum" value="0"></c:set>
					   <c:set var="feesum" value="0"></c:set>
					   <c:set var="xifsum" value="0"></c:set>
					  <c:set var="income_callssum" value="0"></c:set>
						<c:forEach items="${page.list}" var="v" varStatus="var">

							<tr id="${v.dater }">
								<td>${v.dater }</td>
								<td id="${v.com_id}">${v.company }</td>
								<td id="${v.feecode_id}">${v.feecode_name }</td>			
								<td>${v.succ_users }</td>
								<td>${v.succ_calls }</td>
								<td>${v.feecode_fee }</td>
								<td>${v.income_calls }</td>
								<td>${v.fee }</td>
								<td>${v.shares }</td>
								<td onclick="edits(this)">${v.infee }</td>
							</tr>
							<c:set var="succ_callsum" value="${succ_callsum+v.succ_users}"></c:set>
							<c:set var="succ_numsum" value="${succ_numsum+v.succ_calls}"></c:set>		
							<c:set var="income_callssum" value="${income_callssum+v.income_calls}"></c:set>	
							<c:set var="feesum" value="${feesum+v.infee}"></c:set>	
							<c:set var="xifsum" value="${xifsum+v.fee}"></c:set>	
						</c:forEach>
						<tr><td colspan='3'>总计</td><td>${succ_callsum}</td><td>${succ_numsum}</td><td></td><td>${income_callssum}</td><td>${xifsum}</td><td></td><td id="sumfee">${feesum}</td></tr>
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
	function edits(obj){
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
	            	$.post("updCompanyStatFee.do", {dater:tds.eq(0).html(),com_id:tds.eq(1).attr("id"),feecode_id:tds.eq(2).attr("id"),fee:parseFloat($(this).val())}, function(data, status){
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
				$.post("updCompanyStatFee.do", {dater:tds.eq(0).html(),com_id:tds.eq(1).attr("id"),feecode_id:tds.eq(2).attr("id"),infee:parseFloat($(this).val())}, function(data, status){
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
