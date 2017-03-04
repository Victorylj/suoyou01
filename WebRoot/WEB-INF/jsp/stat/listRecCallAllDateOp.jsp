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
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/laydate/laydate.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript"  src="js/tableTitle.js"></script>


</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">上游代码</a></li>
			<li><a href="#">计费代码指令</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
				<form id="searcherForm" action="listRecCallAllDates.do" method="post" onsubmit="initshow()">	
					<li><label>时间</label><input name="start_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput" value="${searchObj.start_time }"/></li>	
					<li>
					<label>
						<input name="status" type="radio" value="1" <c:if test="${searchObj.status eq 1}">checked="checked" </c:if> />
						类别1</label>
						<label>
						<input name="status" type="radio" value="2" <c:if test="${searchObj.status eq 2}">checked="checked" </c:if> />
						类别2</label>
					</li>	
					<li>
						<label>
						<input name="op" type="radio" value="1" <c:if test="${searchObj.op eq 1}">checked="checked" </c:if> />
						移动</label>
						<label>
						<input name="op" type="radio" value="2" <c:if test="${searchObj.op eq 2}">checked="checked" </c:if> />
						联通</label>
						
						<label>
						<input name="op" type="radio" value="3" <c:if test="${searchObj.op eq 3}">checked="checked" </c:if> />
						电信</label>
						<label>
						<input name="op" type="radio" value="0" <c:if test="${searchObj.op eq 0}">checked="checked" </c:if> />
						全部</label>
						
					</li>
					
						<li>
					<label>
						<input name="op" type="radio" value="4" <c:if test="${searchObj.op eq 4}">checked="checked" </c:if> />
						分运营商显示</label>
						
					</li>
					
					<li><label>&nbsp;</label><input  type="submit"
						class="scbtn" value="查询" /></li>
						
					<li><label>&nbsp;</label><input  type="button"
						class="scbtn" value="导出" onclick="exportExcel()" /></li>
				</form>
			</ul>
		</div>
	<div class="divtable" style="overflow-x:hidden;">
		<table class="tablelist" >
			<thead><tr><th>上游公司</th><th>产品</th><th>初始值</th><th>非13金额</th><th>计费代码</th><th>计费端口</th><th>上行条数</th><th>成功条数</th><th>上行转化率</th><th>同步转化率</th><th>报盘</th><th>收入</th><th>日期</th></tr></thead>
		</table>
	 </div>
		
	<div class="divtable">
		<table id="treetab" class="tablelist" style="margin-top:-36px;">
			<thead>
				<tr>
					<th>上游公司</th>
					<th>产品</th>
					<th>初始值</th>
					<th>计费代码</th>
					<th>计费端口</th>
					<th>上行条数</th>
					<th>成功条数</th>
					<th>上行转化率</th>
					<th>同步转化率</th>
					<th>报盘</th>
					<th>收入</th>
					<th>日期</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
					  <c:set var="succ_callsum" value="0"></c:set>
					  <c:set var="succ_numsum" value="0"></c:set>
					   <c:set var="feesum" value="0"></c:set>
					  <c:set var="ratessum" value="0"></c:set>
					  <c:set var="ptotal" value="0"></c:set>
						<c:forEach items="${page.list}" var="v" varStatus="var">
						<c:if test="${v.status==searchObj.status}">
							<tr id="${v.cp_id}">
								<td>${v.ch_name}</td>
								<td>${v.ccp_id}</td>
								<td>${v.initnum}</td>
								<td>
									<font color="red">${v.fee13}</font>
								</td>
								<td>${v.command}</td>
								<td>${v.feecode_number}</td>
								<td>${v.yd_succ_calls}|${v.lt_succ_calls}|${v.dx_succ_calls}|${v.succ_calls}</td>
								<td>${v.succ_num}</td>
								<td>${v.rateis}</td>
								<td>${v.ratesp}</td>
								<td>${v.yd_fee}|${v.lt_fee}|${v.dx_fee}|${v.fee}</td>
								<td>${v.yd_rates}|${v.lt_rates}|${v.dx_rates}|${v.rates}</td>
								<td>${v.dater}</td>
								<c:set var="succ_callsum" value="${succ_callsum+v.succ_calls}"></c:set>
								<c:set var="succ_numsum" value="${succ_numsum+v.succ_num}"></c:set>		
								<c:set var="ratessum" value="${ratessum+v.rates}"></c:set>	
								<c:set var="feesum" value="${feesum+v.fee}"></c:set>
								<c:set var="ptotal" value="${ptotal+1}"></c:set>			
							</tr>
						</c:if>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="8">没有搜索到符合条件的数据！</td>
						</tr>
					</c:otherwise>
				</c:choose>
			<tr><td colspan="6">总计</td><td>${succ_callsum}</td><td>${succ_numsum}</td><td></td><td></td><td></td><td id="sr_td">
			
			</td><td></td></tr>
			</tbody>
		</table>
	</div>
			<script type="text/javascript">
			    var a = "${ratessum}";
			    a = a.substr(0,a.indexOf(".")+2);
			    $("#sr_td").html(a);
			    a = "${feesum}";
			    a = a.substr(0,a.indexOf(".")+2);
			    $("#sr_td").prev().html(a);
			</script>
		<div class="pagin">
				<div class="message">
					共
					<i class="blue">${ptotal} </i>条记录，当前显示第&nbsp;
					<i class="blue">${page.pageNum}&nbsp;</i>页
				</div>
		</div>
	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		$(function(){
			//$(".select3").uedSelect({width : 100});		
			$("#treetab").find("tr").click(function(e){
				// alert(this.id)
				var cp_id = this.id;
				if($("tr[pid="+cp_id+"]").length>0){
					$("tr[pid="+cp_id+"]").remove();
					$(e.target).closest("tr").find("td").css({"font-weight":"","color":"","background-color":""});
					
					var toptitle = $(".divtable").eq(0);
					var content = $(".divtable").eq(1);
					var ths = toptitle.find("thead").find("th");
					var thead = content.find("tbody").find("tr").eq(0).find("td");
					content.find("table").css("margin-top","-36px");
					toptitle.find("table").width(content.find("table").width());
					for(var i=0;i<ths.length;i++){
						ths.eq(i).width(thead.eq(i).width()-7);
					}
					toptitle[0].scrollLeft=content[0].scrollLeft;
					content.scroll( function(){
						toptitle[0].scrollLeft=content[0].scrollLeft;
					});
				}else{
					var ccp_id = $(this).find("td").eq(1).html();
					$.post("getRecCallDates.do", {cp_id: cp_id,ccp_id:ccp_id}, function(data, status){
						var json = eval(data);
						for	(var i = 0; i<json.length; i++){
								var tr =$('<tr pid="'+cp_id+'"><td style="padding-left:50px">╀----</td><td>'+json[i].ccp_id+'</td><td>'+json[i].initnum+'</td><td>0</td><td>'+
								json[i].command+'</td><td>'+json[i].feecode_number+'</td><td>'+json[i].succ_calls+'</td><td>'+json[i].succ_num+'</td><td>'+
								json[i].rateis+'</td><td>'+json[i].ratesp+'</td><td>'+json[i].fee+'</td><td>'+json[i].rates+'</td><td>'+json[i].dater+'</td></tr>');
								tr.find("td").css({"color":"#222","background-color":"#E1EFF4"});
								$(e.target).closest("tr").after(tr);
						}
						$(e.target).closest("tr").find("td").css({"font-weight":"bold","color":"blue","background-color":"#D4E7F0"});
						
						var toptitle = $(".divtable").eq(0);
						var content = $(".divtable").eq(1);
						var ths = toptitle.find("thead").find("th");
						var thead = content.find("tbody").find("tr").eq(0).find("td");
						content.find("table").css("margin-top","-36px");
						toptitle.find("table").width(content.find("table").width());
						for(var i=0;i<ths.length;i++){
							ths.eq(i).width(thead.eq(i).width()-7);
						}
						toptitle[0].scrollLeft=content[0].scrollLeft;
						content.scroll( function(){
							toptitle[0].scrollLeft=content[0].scrollLeft;
						});
					});
				}		
			});
		});
		
		function exportExcel(){
	 		var params = $("#searcherForm").serialize();
			window.location = 'exportlrcAll.do?'+params;
	 	}
		
	</script>

</body>

</html>
