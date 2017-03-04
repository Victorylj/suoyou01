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
		$("#sp_select").searchInit({searchObj:"sp_select", searchText: "sp_name", searchId: "sp_id", searchUrl: "/seachCpCompanyList.do"});
		});
		
		function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
				var params = $("#searcherForm").serialize();
		window.location = 'getRecDataStat.do?pageId='+nextPageId+'&'+params;
	}
	 function exportExcel(){
	 		var params = $("#searcherForm").serialize();
		window.location = 'exportRateDetail.do?'+params;
	 }
	 

</script>

</head>


<body>

	<div class="place" on>
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据统计</a></li>
			<li><a href="#">转化率统计</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
		<form id="searcherForm" action="getRecDataStat.do" autocomplete="off" method="post" onsubmit="initshow()">
			<ul class="seachform">
				<li><label>上游公司</label>
						<div class="vocation" id="sp_select" style="height:32px">
					
						 <!-- <select id="sp_id" name="sp_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c1:forEach items="{companyList}" var="sp">
                			 <option value="{sp.sp_id}" <c1:if test="{searchObj.sp_id eq sp.sp_id}">selected="selected"</c1:if> >{sp.sp_name}</option>
                		    </c1:forEach>
                	   </select> -->
                	   
                	   <div class="select3">
                	    <input id="sp_name" name="sp_name" class="scinput" value="${searchObj.sp_name}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result" style="position:absolute; display:none; top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="sp_id" name="sp_id" type="hidden" value="${searchObj.sp_id}"/> 
                	   </div>
                	   
					</div></li>
					<li><label>运营商</label>
						<div class="vocation">
					
						 <select id="op" name="op" class="select3">
                		   <option value="">请选择</option>
                	  
                			 <option value="1" <c:if test="${searchObj.op eq 1}">selected="selected"</c:if> >移动</option>
							 <option value="2" <c:if test="${searchObj.op eq 2}">selected="selected"</c:if> >联通</option>
  							<option value="3" <c:if test="${searchObj.op eq 3}">selected="selected"</c:if> >电信</option>
                	   </select>
                	   
					</div></li>
					
					<li><label>对公对私</label>
						<div class="vocation">
					
						 <select id="sp_gsstatus" name="sp_gsstatus" class="select3">
                		   <option value="">请选择</option>
                			 <option value="1" <c:if test="${searchObj.sp_gsstatus eq 1}">selected="selected"</c:if> >对公</option>
							 <option value="2" <c:if test="${searchObj.sp_gsstatus eq 2}">selected="selected"</c:if> >对私</option>
                	   </select>
                	   
					</div></li>
					
					<li><label>计费端口</label><input name="feecode_number" type="text" value="${ searchObj.feecode_number}"
						class="scinput" /></li>
					<li><label>指令</label><input name="command" type="text"  value="${ searchObj.command}"
						class="scinput" /></li>
					<li><label>分省</label>
						<input name="is_province" type="checkbox" value="1" <c:if test="${searchObj.is_province eq 1}">checked="checked" </c:if> /></li>	
		</ul>
		<ul class="seachform">
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
					<th>SP公司</th>
					<th>运营商</th>
					<th>对公对私</th>
					<th>代码名称</th>
					<th>端口</th>
					<th>指令</th>
					<th>省份</th>
					<th>计费用户数</th>
					<th>收入用户</th>
					<th>计费条数</th>
					<th>成功条数</th>
					<th>单价(分)</th>
					<th>报盘(元)</th>
					<th>转化率</th>
					<th>收入(元)</th>
					<th>效果</th>	
					<th>状态</th>
					<th>日期</th>
				</tr>
			</thead>
		</table>
	 </div>
	<div class="divtable">
		<table class="tablelist" style="margin-top:-36px;">
			<thead>
				<tr>
					<th>SP公司</th>
					<th>运营商</th>
					<th>对公对私</th>
					<th>代码名称</th>
					<th>端口</th>
					<th>指令</th>
					<th>省份</th>
					<th>计费用户数</th>
					<th>收入用户</th>
					<th>计费条数</th>
					<th>成功条数</th>
					<th>单价(分)</th>
					<th>报盘(元)</th>
					<th>转化率</th>
					<th>收入(元)</th>
					<th>效果</th>
					<th>状态</th>
					<th>日期</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">

							<tr id="${v.sp_id }">
								<td>${v.sp_name }</td>
								<td>
								<c:if test="${v.op eq '1'}">移动</c:if>
								<c:if test="${v.op eq '2'}">联通</c:if>
								<c:if test="${v.op eq '3'}">电信</c:if>
								</td>
								<td>
								<c:if test="${v.sp_gsstatus eq '1'}">对公</c:if>
								<c:if test="${v.sp_gsstatus eq '2'}">对私</c:if>
								</td>
								<td>${v.feecode_name }</td>
								<td>${v.feecode_number }</td>
								<td>
								<c:if test="${fn:length(v.command) > 15}">
					<span title="${v.command}">${fn:substring(v.command, 0, 5)}...${fn:substring(v.command, fn:length(v.command)-5, fn:length(v.command))}</span>
		      	</c:if>
		      	<c:if test="${fn:length(v.command) <= 15}">
					<span title="${v.command}">${v.command}</span>
		      	</c:if>
								</td>
								<td>${v.province_name}</td>
								<td>${v.succ_users}</td>	
								<td>${v.income_user }</td>
								<td>${v.succ_calls}</td>
								<td onclick="edits(this)">${v.income_calls}</td>
								<td>${v.feecode_fee }</td>							
								<td>${v.fee}</td>
								<td>
								<c:choose>
									<c:when test="${v.rate*100 gt 30}">
										<span style="color: green" >${v.rate}</span>
									</c:when>
									<c:when test="${v.rate*100 le 30 and v.rate*100 gt 15}">
										<span style="color: blue">${v.rate}</span>
									</c:when>
									<c:when test="${v.rate*100 le 15}">
										<span style="color: red">${v.rate}</span>
									</c:when>
								</c:choose>
								 </td>
								 
								  <td><fmt:formatNumber type="number" value="${v.income_calls*v.share}" maxFractionDigits="3"/></td>
								
								 <td>
								<c:choose>
									<c:when test="${(v.income_calls*v.share)/(v.succ_calls*v.feecode_fee)*100 gt 30}">
										<span style="color: green" ><fmt:formatNumber type="number" value="${(v.income_calls*v.share)/(v.succ_calls*v.feecode_fee)}" maxFractionDigits="2"/></span>
									</c:when>
									<c:when test="${(v.income_calls*v.share)/(v.succ_calls*v.feecode_fee)*100 le 30 and (v.income_calls*v.share)/(v.succ_calls*v.feecode_fee)*100 gt 15}">
										<span style="color: blue"><fmt:formatNumber type="number" value="${(v.income_calls*v.share)/(v.succ_calls*v.feecode_fee)}" maxFractionDigits="2"/></span>
									</c:when>
									<c:when test="${(v.income_calls*v.share)/(v.succ_calls*v.feecode_fee)*100 le 15}">
										<span style="color: red"><fmt:formatNumber type="number" value="${(v.income_calls*v.share)/(v.succ_calls*v.feecode_fee)}" maxFractionDigits="2"/></span>
									</c:when>
								</c:choose>
								 </td>
								 <td>${v.remarks }</td>
								<td>${v.dater }</td>
							</tr>

						</c:forEach>
						<tr><td colspan='7'>总计</td>
						<td> ${allUsers} </td> <td> ${allIncomeUser} </td><td> ${allDatas} </td> <td>${allSuccs}  </td><td> </td> <td> ${allFee} </td> <td>&nbsp;</td><td>${allIncomeB}</td><td>&nbsp;</td>  <td>&nbsp;</td><td>&nbsp;</td></tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="10">没有搜索到符合条件的数据！</td>
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
		var gorlInput;
		var gorlNumber;
		var bo = false;
		function edits(obj){
			var sp_id = $(obj).closest("tr").attr("id");
			var tds = $(obj).closest("tr").find("td");
			var date = new Date();
			date.setHours(0);	
			date.setMinutes(0);	
			date.setSeconds(0);	
			date.setMilliseconds(0);
			var sdate=new Date(tds.eq(17).html()); 
			sdate.setHours(0);	
			sdate.setMinutes(0);	
			sdate.setSeconds(0);	
			sdate.setMilliseconds(0);
			var number = $(obj).html();
			var unumber = tds.eq(8).html();
			if(unumber!=""&&unumber!="0"){return;}
			if(sdate<date && $(obj).find("input").length==0){
				if(bo){return;}
				if(gorlInput!=null){gorlInput.closest("td").html(gorlNumber);}
				gorlNumber = number;
				gorlInput = $('<input class="scinput" style="width:50px" type="text" value="'+number+'">');
				gorlInput.unbind();
				gorlInput.keydown(function(e){
					e=e||window.event;  
                    if(e.keyCode==13){
                    	if(gorlNumber==gorlInput.val()){ gorlInput.closest("td").html(gorlInput.val());return;}
                    	var sp_id = $(this).closest("tr").attr("id");
                    	var tds = $(this).closest("tr").find("td");
                      	$.post("updSussNumber.do", {sp_id:sp_id,sp_name:tds.eq(0).html(),feecode_name:tds.eq(3).html(),feecode_number:tds.eq(4).html(),command:tds.eq(5).find("span").attr("title"),
                      		 succ_users:tds.eq(7).html(),income_user:tds.eq(8).html(),succ_calls:tds.eq(9).html(),feecode_fee:tds.eq(11).html(),dater:tds.eq(17).html(),income_calls:$(this).val()}, function(data, status){
                      		 var tds =  gorlInput.closest("tr").find("td");
                      		 gorlInput.closest("td").html(gorlInput.val());
                      		 
                      		 var json = eval(data);
                      		 tds.eq(12).html(json[0].fee);
                      		 if(json[0].rate*100>30){
                      		 	tds.eq(13).html('<span style="color: green" >'+json[0].rate+'</span>');
                      		 }else if(json[0].rate*100<=30 && json[0].rate*100>=15){
                      		 	tds.eq(13).html('<span style="color: blue" >'+json[0].rate+'</span>');
                      		 }else if(json[0].rate*100<15){
                      		 	tds.eq(13).html('<span style="color: red" >'+json[0].rate+'</span>');
                      		 }
                      		 
                      		 tds.eq(14).html(Math.round(json[0].income_calls*json[0].share*100)/100);
                      		 
                      		 var xg = (json[0].income_calls*json[0].share)/(json[0].succ_calls*json[0].feecode_fee);
                      		  xg = Math.round(xg*100)/100;
                      		 if(xg*100>30){
                      		 	tds.eq(15).html('<span style="color: green" >'+xg+'</span>');
                      		 }else if(xg*100<=30 && xg*100>=15){
                      		 	tds.eq(15).html('<span style="color: blue" >'+xg+'</span>');
                      		 }else if(xg*100<15){
                      		 	tds.eq(15).html('<span style="color: red" >'+xg+'</span>');
                      		 }
                      		 //tds.eq(11).html();
                      	});
                      	
                    }  
				});
				gorlInput.blur(function(){
						if(gorlNumber==gorlInput.val()){gorlInput.closest("td").html(gorlInput.val());return;}
						var sp_id = $(this).closest("tr").attr("id");
                    	var tds = $(this).closest("tr").find("td");
                    	bo = true;
                      	$.post("updSussNumber.do", {sp_id:sp_id,sp_name:tds.eq(0).html(),feecode_name:tds.eq(3).html(),feecode_number:tds.eq(4).html(),command:tds.eq(5).find("span").attr("title"),
                      		 succ_users:tds.eq(7).html(),income_user:tds.eq(8).html(),succ_calls:tds.eq(9).html(),feecode_fee:tds.eq(11).html(),dater:tds.eq(17).html(),income_calls:$(this).val()}, function(data, status){
                      		 var tds =  gorlInput.closest("tr").find("td");
                      		 gorlInput.closest("td").html(gorlInput.val());
                      		 bo = false;
                      		 var json = eval(data);
                      		 tds.eq(12).html(json[0].fee);
                      		 if(json[0].rate*100>30){
                      		 	tds.eq(13).html('<span style="color: green" >'+json[0].rate+'</span>');
                      		 }else if(json[0].rate*100<=30 && json[0].rate*100>=15){
                      		 	tds.eq(13).html('<span style="color: blue" >'+json[0].rate+'</span>');
                      		 }else if(json[0].rate*100<15){
                      		 	tds.eq(13).html('<span style="color: red" >'+json[0].rate+'</span>');
                      		 }
                      		 tds.eq(14).html(Math.round(json[0].income_calls*json[0].share*100)/100);
                      		 var xg = (json[0].income_calls*json[0].share)/(json[0].succ_calls*json[0].feecode_fee);
                      		 xg = Math.round(xg*100)/100;
                      		 if(xg*100>30){
                      		 	tds.eq(15).html('<span style="color: green" >'+xg+'</span>');
                      		 }else if(xg*100<=30 && xg*100>=15){
                      		 	tds.eq(15).html('<span style="color: blue" >'+xg+'</span>');
                      		 }else if(xg*100<15){
                      		 	tds.eq(15).html('<span style="color: red" >'+xg+'</span>');
                      		 }
                      		 //tds.eq(11).html();
                      	});
				});
				gorlInput.keyup(function(){
					this.value=this.value.replace(/\D/g,'');
				});
				$(obj).html(gorlInput);
				gorlInput.select();
			}else{
				//gorlInput.remove();
				
				// gorlInput.unbind("blur");
				 //alert(gorlInput);
				// gorlInput.closest("td").html(gorlNumber);
			}
		}
	</script>

</body>

</html>
