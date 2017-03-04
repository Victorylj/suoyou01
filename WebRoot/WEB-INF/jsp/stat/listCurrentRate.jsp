<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

<script type="text/javascript" src="js/stat/listRecDataStat.js"></script>

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

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据统计</a></li>
			<li><a href="#">当前转化率</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
		<form id="searcherForm" action="listCurrentRate.do" autocomplete="off" method="post" onsubmit="initshow()">
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
					
						<li><label>计费端口</label><input name="feecode_number" type="text" value="${ searchObj.feecode_number}"
						class="scinput" /></li>
						
					<li><label>指令</label><input name="command" type="text"  value="${ searchObj.command}"
						class="scinput" /></li>

		<li>			
					<label>&nbsp;</label>
					<input  type="submit"
						class="scbtn" value="查询" /></li>
					
				
			</ul>
			</form>
		
		</div>
<div class="divtable" style="overflow-x:hidden;">
		<table class="tablelist" >
			<thead>
				<tr>
					<th>日期</th>
					<th>上游公司名称</th>
					<th>计费代码名称</th>
					<th>运营商</th>
					<th>计费端口</th>
					<th>指令</th>
					<th>计费次数</th>
					<th>成功条数</th>
					<th>单价</th>
					<th>报盘</th>
					<th>转化</th>
					<th>指令状态</th>
				</tr>
			</thead>
		</table>
	 </div>
	<div class="divtable">
		<table class="tablelist" style="margin-top:-36px;">
			<thead>
				<tr>
					<th>日期</th>
					<th>上游公司名称</th>
					<th>计费代码名称</th>
					<th>运营商</th>
					<th>计费端口</th>
					<th>指令</th>
					<th>计费次数</th>
					<th>成功条数</th>
					<th>单价</th>
					<th>报盘</th>
					<th>转化</th>
					<th>指令状态</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty ratelist}">
						<c:forEach items="${ratelist}" var="v" varStatus="var">

							<tr>
								<td>${v.start_time }</td>
								<td>${v.sp_name }</td>
								<td>${v.feecode_name }</td>
								<td>	
								<c:if test="${v.op eq '1'}">移动</c:if>
								<c:if test="${v.op eq '2'}">联通</c:if>
								<c:if test="${v.op eq '3'}">电信</c:if>
								</td>
								<td>${v.feecode_number }</td>
								<td>
								<c:if test="${fn:length(v.command) > 15}">
									<span title="${v.command}">${fn:substring(v.command, 0, 5)}...${fn:substring(v.command, fn:length(v.command)-5, fn:length(v.command))}</span>
		      					</c:if>
		      					<c:if test="${fn:length(v.command) <= 15}">
									<span title="${v.command}">${v.command}</span>
		      					</c:if>
								</td>
								<td>${v.mo_num}</td>
								<td>${v.mr_num }</td>
								<td>${v.feecode_fee }</td>
								<td>${v.feecode_fee * v.mr_num  }</td>
								<td>
								<c:choose>
									<c:when test="${v.rate gt 30}">
										<span style="color: green" ><fmt:formatNumber type="number" value="${v.rate /100}" maxFractionDigits="2"/></span>
									</c:when>
									<c:when test="${v.rate le 30 and v.rate gt 15}">
										<span style="color: blue"><fmt:formatNumber type="number" value="${v.rate /100}" maxFractionDigits="2"/></span>
									</c:when>
									<c:when test="${v.rate le 15}">
										<span style="color: red"><fmt:formatNumber type="number" value="${v.rate /100}" maxFractionDigits="2"/></span>
									</c:when>
								</c:choose>
								
								</td>
								
								<td>	
								<c:if test="${v.command_status eq '0'}"><span style="color: green">开启</span></c:if>
								<c:if test="${v.command_status eq '1'}"><span style="color: red">关闭</span></c:if>
							
								</td>
							</tr>

						</c:forEach>
						<tr><td colspan='6'>总计</td><td> ${allmo} </td><td> ${allmr} </td><td></td><td> ${allfee} </td><td></td><td></td></tr>
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
					<li class="paginItem">
						<a href="javascript:;"
							onclick="getPageId(${page.pages},${page.pageNum+1})"><span
							class="pagenxt"></span> </a>
					</li>
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
	</script>

</body>

</html>
