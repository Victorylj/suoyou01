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
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=blue"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript" src="js/spmanager/listSpCommand.js"></script>
<script type="text/javascript"  src="js/searchSelect.js"></script>


<script type="text/javascript" src="js/cpmanager/listChannelData.js"></script>
<script type="text/javascript"  src="js/laydate/laydate.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>

<script type="text/javascript">
$(function(){
	 var cascade = function(obj){
	 	$.ajax({
	         type:'post',
	         url: 'seachProductList.do',
	         data:'pid='+obj.id,
	         dataType:'text',
	         success:function(result){
		         $("#searchCode").initData(result,{result:"result1", searchText: "product_name",defaultStr:true,searchId: "product_id"});
			 },
	         error:function(){
	             alert("failed.");
	         }
	     });
	 }
	
	 $("#searchSp").searchInit({searchObj:"searchSp", searchText: "cp_name", searchId: "cp_id", result:"result", searchUrl: "/seachCaipCompanyList.do",cascade:cascade});
	 $("#searchCode").searchInit({searchObj:"searchCode", pid:"cp_id", searchText: "product_name", searchId: "product_id", result:"result1", searchUrl: "/seachProductList.do"});
	 
});
	
	function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
		var params = $("#searcherForm").serialize();
		window.location = 'listCaitsat.do?pageId='+nextPageId+'&'+params;
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
			<li><a href="#">投拆统计</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
		<form id="searcherForm" action="listCaitsat.do" method="post" onsubmit="initshow()">
			<ul class="seachform">
											
				<li><label>时间</label><input name="start_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput" value="${searchObj.start_time }"/>--
					<input name="end_time" type="text"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"	class="scinput"  value="${searchObj.end_time }" /></li>	
					<li> 
					<li><label>渠道</label>
					<div class="vocation" id="searchSp">
                	    <div class="select3">
                	    <input id="cp_name" name="cp_name" class="scinput" value="${empty searchObj.cp_name?'--请选择--': searchObj.cp_name}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result" style="position:absolute;display:none;top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="cp_id" name="cp_id" type="hidden" value="${searchObj.cp_id}"/> 
                	   </div>
					</div>
				</li>	
				<li><label>产品</label>
						<div class="vocation" id="searchCode">
					
                	   
                	   <div class="select3">
                	    <input id="product_name" name="product_name" class="scinput" value="${empty searchObj.product_name?'--请选择--': searchObj.product_name}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result1" style="position:absolute;display:none;top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="product_id" name="product_id" type="hidden" value="${searchObj.product_id}"/> 
                	   </div>
                	   
					</div></li>	
				
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
				<th>日期</th>
				<th>渠道</th>
				<th>产品名称</th>
				<th>渠道</th>
				<th>N</th>	
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">
							<tr>
								<td>${v.dater }</td>
								<td>${v.cp_name }</td>
								<td>${v.product_name }</td>
								<td>${v.ccp_id }</td>
								<td>${v.n }</td>
							</tr>
						</c:forEach>
						<%-- <tr>
						<td colspan='2'>总计</td>
						<c:if test="${curCH.show_type==1}">
						<td> ${allDataRet} </td>
						</c:if>
						<c:if test="${curCH.show_type==2}">
						<td> ${allDataFee} </td>
						</c:if>
						
						<c:if test="${curCH.show_type==3}">
						<td> ${allDataInit} </td>
						<td> ${allDataRet} </td>
						<td> ${allDataFee} </td>
						</c:if>
						</tr> --%>
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
