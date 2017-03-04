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


<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/laydate/laydate.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript"  src="js/tableTitle.js"></script>
<script type="text/javascript">
		function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
		var params = $("#searcherForm").serialize();
		window.location = 'listFeecodeStat.do?pageId='+nextPageId+'&'+params;
	}
	$(".select3").uedSelect({
			width : 100
		});
</script>


</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据统计</a></li>
			<li><a href="#">数据统计</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
		<form id="searcherForm" action="listFeecodeStat.do" method="post" onsubmit="initshow()">
			<ul class="seachform">
					<li><label>计费代码</label>
						<div class="vocation">
					
						 <select id="feecode_id" name="feecode_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c:forEach items="${feecodeList}" var="feecode">
                			 <option value="${feecode.feecode_id}" <c:if test="${searchObj.feecode_id eq feecode.feecode_id}">selected="selected"</c:if> >${feecode.feecode_name}</option>
                		    </c:forEach>
                	   </select>
                	   
					</div></li>
					<li><label>省份</label>
						<div class="vocation">
					
						 <select id="province_id" name="province_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c:forEach items="${proList}" var="pro">
                			 <option value="${pro.province_id}" <c:if test="${searchObj.province_id eq pro.province_id}">selected="selected"</c:if> >${pro.province_name}</option>
                		    </c:forEach>
                	   </select>
                	   
					</div></li>
					<li><label>运营商</label>
						<div class="vocation">
					
						 <select id="op" name="op" class="select3">
                		   <option value="">请选择</option>
                	      	<option value="1" <c:if test="${searchObj.op ==1}">selected="selected"</c:if> >移动</option>
                	      	<option value="2" <c:if test="${searchObj.op ==2}">selected="selected"</c:if> >联通</option>
                	      	<option value="3" <c:if test="${searchObj.op ==3}">selected="selected"</c:if> >电信</option>
                	   </select>
                	   
					</div></li>
					
					<li><label>时间</label><input name="start_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput" value="${searchObj.start_time }"/>--
					<input name="end_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput"  value="${searchObj.end_time }" /></li>	
					<li>
					
					<label>&nbsp;</label>
					<input  type="submit"
						class="scbtn" value="查询" /></li>
				
			</ul>
			</form>
		
		</div>
	<div class="divtable" style="overflow-x:hidden;">
		<table class="tablelist" >
			<thead><tr>
					<th>上游公司名称</th>
					<th>计费代码名称</th>
					<th>计费端口</th>
					<th>指令</th>
					<th>计费费用</th>
					<th>计费次数</th>
					<th>计费用户数</th>
					<th>运营商</th>
					<th>省份</th>
					<th>日期</th>	
				</tr></thead>
		</table>
	 </div>
	<div class="divtable">
		<table class="tablelist" style="margin-top:-36px;">
			<thead>
				<tr>
					<th>上游公司名称</th>
					<th>计费代码名称</th>
					<th>计费端口</th>
					<th>指令</th>
					<th>计费费用</th>
					<th>计费次数</th>
					<th>计费用户数</th>
					<th>运营商</th>
					<th>省份</th>
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
								<td>${v.feecode_number }</td>
								<td>
								<c:if test="${fn:length(v.command) > 15}">
									<span title="${v.command}">${fn:substring(v.command, 0, 5)}...${fn:substring(v.command, fn:length(v.command)-5, fn:length(v.command))}</span>
		      					</c:if>
		      					<c:if test="${fn:length(v.command) <= 15}">
									<span title="${v.command}">${v.command}</span>
		      					</c:if>
								</td>
								<td>${v.feecode_fee }</td>
								<td>${v.succ_calls}</td>
								<td>${v.succ_users}</td>								
								<td>
								 <c:if test="${v.op ==1}">
								 	移动
								 </c:if>
								<c:if test="${v.op ==2 }">
								 	联通
								 </c:if>
								 <c:if test="${v.op ==3 }">
								 	电信
								 </c:if>
								</td>
							
								
								<td>${v.province_name }</td>
								<td>${v.dater }</td>
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
