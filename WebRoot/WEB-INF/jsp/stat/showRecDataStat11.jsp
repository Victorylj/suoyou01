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
<script type="text/javascript">
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
			<li><a href="#">数据表</a></li>
			<li><a href="#">基本内容</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
		<form id="searcherForm" action="getRecDataStat.do" method="post" onsubmit="initshow()">
			<ul class="seachform">
					<li><label>计费端口</label><input name="feecode_number" type="text" value="${ searchObj.feecode_number}"
						class="scinput" /></li>
					<li><label>指令</label><input name="command" type="text"  value="${ searchObj.command}"
						class="scinput" /></li>
						
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

	<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
					<th>上游公司名称</th>
					<th>计费代码名称</th>
					<th>计费端口</th>
					<th>指令</th>
					
					<th>返回协议指令条数</th>
					<th>返回协议用户数</th>
					<th>单价</th>
					<th>收入</th>
					<th>收入用户</th>
					<th>收入数</th>
					<th>转化率</th>
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
						
								<td>${v.succ_calls}</td>
								<td>${v.succ_users}</td>	
								<td>${v.feecode_fee }</td>							
								<td>${v.fee}</td>
								<td>${v.income_user }</td>
								<td>1</td>
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
								<td>${v.dater }</td>
							</tr>

						</c:forEach>
						<tr><td colspan='4'>总计</td><td> ${allDatas} </td>
						<td> ${allUsers} </td> <td>  </td> <td> ${allFee} </td>  <td> ${allIncomeUser} </td>  <td ></td></tr>
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
	</script>

</body>

</html>
