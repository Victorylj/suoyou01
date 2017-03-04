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
		window.location = 'listRecDataStat.do?pageId='+nextPageId+'&'+params;
	}
 function exportExcel(){
	 		var params = $("#searcherForm").serialize();
		window.location = 'exportRecDataDetail.do?'+params;
	 }
	 
</script>


</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据统计</a></li>
			<li><a href="#">收入统计</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
		<form id="searcherForm" action="listRecDataStat.do" autocomplete="off" method="post" onsubmit="initshow()">
			<ul class="seachform">
			
				<li><label>上游公司</label>
						<div class="vocation" id="sp_select" style="height:32px">
					
						<!--  <select id="sp_id" name="sp_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c1:forEach items="{companyList}" var="sp">
                			 <option value="{sp.sp_id}" <c1:if test="{searchObj.sp_id eq sp.sp_id}">selected="selected"</c1:if> >{sp.sp_name}</option>
                		    </c1:forEach>
                	   </select> -->
                	   
                	   <div class="select3">
                	    <input id="sp_name" name="sp_name" class="scinput" value="${searchObj.sp_name}" style="position:absolute;outline: none;top:2px;left:2px;width:73px;border:0px;z-index:9;"/> 
        				<div id="result" style="position:absolute; display:none; top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="sp_id" name="sp_id" type="hidden" value="${searchObj.sp_id}"/> 
                	   </div>
                	   
                	   
					</div></li>
					
					<li><label>计费端口</label><input name="spnumber" type="text" value="${ searchObj.spnumber}"
						class="scinput" /></li>
					<li><label>指令</label><input name="command" type="text"  value="${ searchObj.command}"
						class="scinput" /></li>
					
					<li><label>省份</label>
						<div class="vocation">
					
						 <select id="province_id" name="province_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c:forEach items="${proList}" var="pro">
                			 <option value="${pro.province_id}" <c:if test="${searchObj.province_id eq pro.province_id}">selected="selected"</c:if> >${pro.province_name}</option>
                		    </c:forEach>
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
					
					<li><label>分渠道</label>
						<input name="is_ch" type="checkbox" value="1" <c:if test="${searchObj.is_ch eq 1}">checked="checked" </c:if> /></li>		
					<li><label>分省</label>
						<input name="is_province" type="checkbox" value="1" <c:if test="${searchObj.is_province eq 1}">checked="checked" </c:if> /></li>	
					<li><label>明细</label>
						<input name="is_detail" type="checkbox" value="1" <c:if test="${searchObj.is_detail eq 1}">checked="checked" </c:if> /></li>					
			
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
					<th>上游公司名称</th>
					<th>计费代码名称</th>
					<th>对公对私</th>
					<th>计费端口</th>
					<th>指令</th>
					<th>省份</th>
					<th>计费次数</th>
					<th>报盘</th>
					<th>分成比例</th>
					<th>计费用户数</th> 
					<th style="display:none;">计费点</th>
					<th style="display:none;">渠道</th>
					<th>收入</th>
					<th>日期</th>
				</tr>
			</thead>
		</table>
	 </div>
	<div class="divtable">
		<table class="tablelist" style="margin-top:-36px;">
			<thead>
				<tr>
					<th>上游公司名称</th>
					<th>计费代码名称</th>
					<th>对公对私</th>
					<th>计费端口</th>
					<th>指令</th>
					<th>省份</th>
					<th>计费次数</th>
					<th>报盘</th>
					<th>分成比例</th>
					<th>计费用户数</th> 
					<th style="display:none;">计费点</th>
					<th style="display:none;">渠道</th>
					<th>收入</th>
					<th>日期</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">

							<tr>
								<td>${v.sp_name }</td>
								<td>${v.feecode_name }</td>
								<td>
								<c:if test="${v.sp_gsstatus eq '1'}">对公</c:if>
								<c:if test="${v.sp_gsstatus eq '2'}">对私</c:if>
								</td>
								<td>${v.spnumber }</td>
								<td>
								<c:if test="${fn:length(v.command) > 15}">
									<span title="${v.command}">${fn:substring(v.command, 0, 5)}...${fn:substring(v.command, fn:length(v.command)-5, fn:length(v.command))}</span>
		      					</c:if>
		      					<c:if test="${fn:length(v.command) <= 15}">
									<span title="${v.command}">${v.command}</span>
		      					</c:if>
								</td>
								<td>${v.province_name }</td>
								<td>${v.succ_calls}</td>
								<td>${v.fee }</td>
								<td>
									${v.share } 
								</td>
								<td>${v.succ_users}</td>	
								 					
								<td style="display:none;">
								${v.appfee_id}
								</td>
								<td style="display:none;">${v.cp_id }</td>
								
								<td><fmt:formatNumber type="number" value="${v.succ_calls*v.share}" maxFractionDigits="2"/></td>
							 
								<td>${v.dater }</td>
							</tr>

						</c:forEach>
						<tr><td colspan='6'>总计</td><td> ${allDatas} </td><td> ${allFee} </td><td></td>
						<td> ${allUsers} </td> <td>${allIncomeB}</td><td colspan='2'></td></tr>
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
