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

<script type="text/javascript" src="js/cpmanager/listFeepointPlan.js"></script>
<script type="text/javascript"
	src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript"
	src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript" src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>

</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">计费点管理</a></li>
			<li><a href="#">计费实现</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
				<form id="searcherForm" action="listFeepointPlan.do" method="post" onsubmit="initshow()">
					<li><label>渠道</label>
						<div class="vocation">
					
						 <select id="appfee_id" name="appfee_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c:forEach items="${appfeeList}" var="appfee">
                			 <option value="${appfee.appfee_id}" <c:if test="${searchObj.appfee_id eq appfee.appfee_id}">selected="selected"</c:if> >${appfee.appfee_name}</option>
                		    </c:forEach>
                	   </select>
                	   
					</div></li>

					<li><label>&nbsp;</label><input type="submit" class="scbtn"
						value="查询" /></li>
				</form>
			</ul>

		</div>
<ul class="toolbar">
				<li class="click"><span><img src="images/t01.png" /></span>添加</li>

				<li><span><img id="delBtn" src="images/t03.png" /></span>批量删除</li>

			</ul>
	<div class="divtable">	
		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>产品名称</th>
					<th>计费点名称</th>
					<th>计费点费用</th>
					<th>计费方案名称</th>
					<th>备注</th>
					<th>更新时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">

							<tr>
								<td><input type="checkbox" name="appfee_id" value="${ v.appfee_id}" /></td>
								<td>${v.product_name }</td>
								<td>${v.appfee_name }</td>
								<td>${v.appfee_fee }</td>
								<td>
								${v.feeplan_name }
								
								</td>
								
								<td>
								<c:if test="${fn:length(v.remarks) > 15}">
									<span title="${v.remarks}">${fn:substring(v.remarks, 0, 5)}...${fn:substring(v.remarks, fn:length(v.remarks)-5, fn:length(v.remarks))}</span>
		      					</c:if>
		      					<c:if test="${fn:length(v.remarks) <= 15}">
									<span title="${v.remarks}">${v.remarks}</span>
		      					</c:if>
								</td>
								<td>${v.update_time }</td>
								<td>
								<a href="feepointLinkToFeemeasure.do?appfee_id=${v.appfee_id }&appfee_fee=${v.appfee_fee }&appfee_name=${v.appfee_name }&product_name=${v.product_name }" class="tablelink">绑定计费措施</a> 
								<a href="editCpAppfee.do?appfee_id=${v.appfee_id }" class="tablelink">修改</a>
									<a href="javascript:void()"
									onclick="deleteCpAppfee(${ v.appfee_id})" class="tablelink">
										删除</a></td>
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
