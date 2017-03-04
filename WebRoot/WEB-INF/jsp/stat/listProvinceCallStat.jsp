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
		window.location = 'listAllCallStat.do?pageId='+nextPageId+'&'+params;
	}
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
		<form id="searcherForm" action="listProvinceCallStat.do" method="post" onsubmit="initshow()">
			<ul class="seachform">
									
					<li><label>时间</label><input name="start_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput" value="${searchObj.start_time }"/>--
					<input name="end_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput"  value="${searchObj.end_time }" /></li>	
					<li>
					
					<li><label>运营商</label>
						<div class="vocation">
					
						 <select id="op" name="op" class="select3">
                		      <option value="">请选择</option>          	  
                			 <option value="1" <c:if test="${searchObj.op eq 1}">selected="selected"</c:if> >移动</option>
							 <option value="2" <c:if test="${searchObj.op eq 2}">selected="selected"</c:if> >联通</option>
  							<option value="3" <c:if test="${searchObj.op eq 3}">selected="selected"</c:if> >电信</option>
                	   </select>
                	   
					</div></li>
					
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
				<th>运营商</th>
				<th>省份</th>	
				<th>有效用户数</th>	
				<th>下发协议次数</th>		
				<th>下发协议用户数</th>
				<th>总访问次数</th>		
				<th>总访问用户数</th>
				<th>指令总费用</th>
				<th>指令数</th>
				</tr>
			</thead>
		</table>
	 </div>
	<div class="divtable">
		<table class="tablelist" style="margin-top:-36px;">
			<thead>
				<tr>
				<th>日期</th>
				<th>运营商</th>
				<th>省份</th>	
				<th>有效用户数</th>	
				<th>下发协议次数</th>		
				<th>下发协议用户数</th>
				<th>总访问次数</th>		
				<th>总访问用户数</th>
				<th>指令总费用</th>
				<th>指令数</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">

							<tr>
								<td>${v.dater }</td>
								<td>
								<c:if test="${v.op eq '1'}">移动</c:if>
								<c:if test="${v.op eq '2'}">联通</c:if>
								<c:if test="${v.op eq '3'}">电信</c:if>
								</td>
								<td>${v.province_name }</td>
								<td>${v.initnum }</td>
								<td>${v.succ_calls }</td>
								<td>${v.succ_users }</td>
								<td>${v.all_calls }</td>
								<td>${v.all_users }</td>
								<td>
								<c:if test="${v.fees lt 30}"><span style="color:red;">${v.fees }</span></c:if>
								<c:if test="${v.fees gt 50}"><span style="color:green;">${v.fees }</span></c:if>
								<c:if test="${v.fees ge 30 and v.fees le 50}"><span style="color:blue;">${v.fees }</span></c:if>
								
								</td>
								<td><a href="listCpMakefeeItem.do?open_province_id=${v.province_id }&feecode_op=${v.op }&command_status=0&item_status=0" target="_blank" class="tablelink">${v.cmds }</a> 
								</td>
							</tr>

						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="9">没有搜索到符合条件的数据！</td>
						</tr>
					</c:otherwise>
				</c:choose>
			<tr><td colspan="3">总计</td><td> ${allInitnum} </td><td> ${allSuccCalls} </td><td> ${allSuccUsers} </td><td> ${allCalls} </td><td> ${allUsers} </td><td></td><td></td></tr>
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
