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

<script type="text/javascript" src="js/cpfeeplan/listCpMakefeeLink.js"></script>
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
			<li><a href="#">扣费方案管理</a></li>
			<li><a href="#">扣费组合</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
				<form id="searcherForm" action="listCpMakefeeLink.do" method="post" onsubmit="initshow()">
					<li><label>扣费措施</label>
						<div class="vocation">
					
						 <select id="feemeasure_id" name="feemeasure_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c:forEach items="${feemeasureList}" var="measure">
                			 <option value="${measure.feemeasure_id}" <c:if test="${searchObj.feemeasure_id eq measure.feemeasure_id}">selected="selected"</c:if> >${measure.feemeasure_name}</option>
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
			
					<th>扣费措施名称</th>
					<th>计费项名称</th>
					<th>计费条数</th>
					<th>省份</th>
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
								<td><input type="checkbox" name="link_id" value="${ v.link_id}" /></td>
		
								<td>${v.feemeasure_name }</td>
								<td>${v.cp_item_name }</td>
								<td>${v.cp_item_count }</td>
								<td>${v.province_name }</td>
								<td>${v.remarks }</td>
								<td>${v.update_time }</td>
								<td><a href="linkMakefeeItem.do?feemeasure_name=${v.feemeasure_name }&feemeasure_item_id=${v.feemeasure_item_id }&feemeasure_province=${v.province }" class="tablelink">分省修改计费项</a> 
								<!--  <a href="linkMakefeeItem.do?feemeasure_name=${v.feemeasure_name }&feemeasure_item_id=${v.feemeasure_item_id }" class="tablelink">修改计费项</a> -->
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
