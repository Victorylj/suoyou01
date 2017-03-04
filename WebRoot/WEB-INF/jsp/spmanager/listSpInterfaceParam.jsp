<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/spmanager/listSpInterfaceParam.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript" src="js/pop.js"></script>
<script type="text/javascript" src="js/hideLoading.js"></script>
<script type="text/javascript" src="js/searchSelect.js"></script>
<script type="text/javascript">
$(function(){
	 $("#searchSp").searchInit({searchObj:"searchSp", searchText: "sp_name", searchId: "sp_id", result:"result", searchUrl: "/seachCpCompanyList.do"});
});
</script>


</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>
				<a href="#">首页</a>
			</li>
			<li>
				<a href="#">上游代码</a>
			</li>
			<li>
				<a href="#">上游接口配置</a>
			</li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
				<form id="searcherForm" action="listSpInterfaceParam.do" method="post" onsubmit="initshow()">

					<li>
						<label>上游公司</label>
						<div class="vocation" id="searchSp">

							<!-- 	 <select id="sp_id" name="sp_id" class="select3">
                		   <option value="">请选择</option>
                	      	<forEach items="{spList}" var="sp">
                			 <option value="{sp.sp_id}" <if test="{searchObj.sp_id eq sp.sp_id}">selected="selected"</if> >{sp.sp_name}</option>
                		    </forEach>
                	   </select> -->

							<div class="select3">
								<input id="sp_name" name="sp_name" class="scinput" value="${empty searchObj.sp_name?'--请选择--': searchObj.sp_name}" style="position: absolute; top: 2px; left: 2px; width: 73px; outline: none; border: 0px; z-index: 9;" />
								<div id="result" style="position: absolute; display: none; top: 33px; min-width: 98px; max-height: 200px; overflow: auto; z-index: 2;"></div>
								<input id="sp_id" name="sp_id" type="hidden" value="${searchObj.sp_id}" />
							</div>

						</div>
					</li>


					<li>
						<label>&nbsp;</label><input type="submit" class="scbtn" value="查询" />
					</li>
				</form>
			</ul>

		</div>
		<ul class="toolbar">
			<li class="click">
				<span><img src="images/t01.png" /></span>添加
			</li>

			<li style="display: none;">
				<span><img id="delBtn" src="images/t03.png" /></span>批量删除
			</li>

		</ul>
		<div class="divtable">
			<table class="tablelist">
				<thead>
					<tr>
						<th style="display: none;"><input name="" type="checkbox" value="" checked="checked" /></th>
						<th>上游公司ID</th>
						<th>上游公司名称</th>
						<th>接口地址</th>
						<th>linkid参数</th>
						<th>计费端口参数</th>
						<th>计费指令参数</th>
						<th>手机号码参数</th>
						<th>IP参数</th>
						<th>透传</th>
						<th>省份参数</th>
						<th>省份编码</th>
						<th>状态参数</th>
						<th>成功状态标示</th>
						<th>数据时间参数</th>
						<th>返回参数参数</th>
						<th>操作人</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty page.list}">
							<c:forEach items="${page.list}" var="v" varStatus="var">

								<tr>
									<td style="display: none;"><input type="checkbox" name="id" value="${ v.id}" /></td>
									<td>${v.sp_id }</td>
									<td>${v.sp_name }</td>
									<td>${v.url }</td>
									<td>${v.linkid }</td>
									<td>${v.spnumber }</td>
									<td>${v.command }</td>
									<td>${v.mobile }</td>
									<td>${v.ip_str }</td>
									<td>${v.cparams }</td>
									<td>${v.province }</td>
									<td>${v.pro_encoder }</td>
									<td>${v.status_str }</td>
									<td>${v.succ_status }</td>
									<td>${v.timestr }</td>
									<td>${v.ret_str }</td>
									<td>${v.create_name}</td>
									<td><a href="#" class="tablelink">查看</a> <a href="editSpInterfaceParam.do?id=${v.id }" class="tablelink">修改</a> <a href="javascript:void()" onclick="deleteSpInterfaceParam(${ v.id})" class="tablelink"> 删除</a></td>
								</tr>

							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="14">没有搜索到符合条件的数据！</td>
							</tr>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
		</div>

		<div class="pagin">
			<div class="message">
				共 <i class="blue">${page.total} </i>条记录，当前显示第&nbsp; <i class="blue">${page.pageNum}&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem">
					<a href="javascript:;" onclick="getPageId(${page.pages},${page.pageNum-1})"><span class="pagepre"></span> </a>
				</li>
				<li class="paginItem current">
					<a href="javascript:;">${page.pageNum}</a>
				</li>
				<li class="paginItem">
					<a href="javascript:;" onclick="getPageId(${page.pages},${page.pageNum+1})">${page.pageNum+1}</a>
				</li>
				<li class="paginItem">
					<a href="javascript:;" onclick="getPageId(${page.pages},${page.pageNum+2})">${page.pageNum+2}</a>
				</li>
				<li class="paginItem">
					<a href="javascript:;" onclick="getPageId(${page.pages},${page.pageNum+3})">${page.pageNum+3}</a>
				</li>
				<li class="paginItem">
					<a href="javascript:;" onclick="getPageId(${page.pages},${page.pageNum+4})">${page.pageNum+4}</a>
				</li>
				<li class="paginItem more">
					<a href="javascript:;">...</a>
				</li>
				<li class="paginItem">
					<a href="javascript:;" onclick="getPageId(${page.pages},${page.pageNum+6})">${page.pageNum+6}</a>
				</li>
				<li class="paginItem">
					<a href="javascript:;" onclick="getPageId(${page.pages},${page.pageNum+1})"><span class="pagenxt"></span> </a>
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
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input name="" type="button" class="cancel" value="取消" />
			</div>

		</div>
	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
