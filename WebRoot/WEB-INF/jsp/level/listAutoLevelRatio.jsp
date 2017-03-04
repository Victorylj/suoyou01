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

<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript">
	//跳转页面
	$(function(){
			$(".click").click(function() {
				//$(".editdiv").fadeIn(200);
				window.location ="editAutoLevelRatio.do";
			});
	});
	//分页
	function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
		
		var params = $("#searcherForm").serialize();
		window.location = 'listAutoLevelRatio.do?pageId='+nextPageId+'&'+params;
	
	}
	//删除
	function deleteAutoLevelRatio(ids){
		art.dialog.confirm("确认删除该选项？", 
			function() {
				if (!ids || ids == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				var url = "deleteAutoLevelRatio.do";
				var data = {"arrayIds" : ids};
				$.post(url, data, function(result) {
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location ="listAutoLevelRatio.do";
						}
					}, false);
				}, "json");
			}
		);
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
			<ul class="seachform">
			<form id="searcherForm" action="" method="post" onsubmit="initshow()">
					
					<%-- <li><label>上游公司</label>
						<div class="vocation">
					
						 <select id="sp_id" name="sp_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c:forEach items="${spList}" var="sp">
                			 <option value="${sp.sp_id}" <c:if test="${searchObj.sp_id eq sp.sp_id}">selected="selected"</c:if> >${sp.sp_name}</option>
                		    </c:forEach>
                	   </select>
                	   
					</div></li>
					<li><label>计费代码名称</label><input name="feecode_name" type="text"
						class="scinput" value="${searchObj.feecode_name}" /></li>
					<li><label>计费代码</label><input name="feecode_code" type="text"
						class="scinput" value="${searchObj.feecode_code}" /></li>
					<li><label>计费端口</label><input name="feecode_number" type="text"
						class="scinput" value="${searchObj.feecode_number}"/></li>
					<li><label>&nbsp;</label><input  type="submit"
						class="scbtn" value="查询" /></li> --%>
				</form>
			</ul>
		
		</div>
<ul class="toolbar">
				<li class="click"><span><img src="images/t01.png" /></span>添加</li>

				<!--<li><span><img id="delBtn" src="images/t03.png" /></span>批量删除</li>-->

			</ul>
	<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					
					<th>优先等级</th>
					<th>比例</th>
					<th>创建时间</th>
					<th>创建人</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">
							<tr>
								<td><input type="checkbox" name="id" value="${ v.id}" /></td>
								
								<td>${v.level }</td>
								<td>${v.ratio }</td>
								<td>${v.create_time }</td>
								<td>${v.create_name }</td>
								<td><!-- <a href="#" class="tablelink">查看</a>  -->
								<a href="editAutoLevelRatio.do?id=${v.id }" class="tablelink">修改</a>
								 <a href="javascript:void()" onclick="deleteAutoLevelRatio(${v.id })" class="tablelink"> 删除</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="7">没有搜索到符合条件的数据！</td>
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
				<li class="paginItem current"><a href="javascript:;">${page.pageNum+1}</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+2}</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+3}</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+4}</a></li>
				<li class="paginItem more"><a href="javascript:;">...</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+6}</a></li>
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
