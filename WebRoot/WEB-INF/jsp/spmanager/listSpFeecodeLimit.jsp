<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<script type="text/javascript" src="js/spmanager/listSpFeecodeLimit.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript"  src="js/searchSelect.js"></script>
<script type="text/javascript">
$(function(){
	 var cascade = function(obj){
	 	$.ajax({
	         type:'post',
	         url: 'seachSpFeecodeList.do',
	         data:'pid='+obj.id,
	         dataType:'text',
	         success:function(result){
		         $("#searchCode").initData(result,{result:"result1", searchText: "feecodes",defaultStr:true,searchId: "feecode_id"});
			 },
	         error:function(){
	             alert("failed.");
	         }
	     });
	 }
	
	 $("#searchSp").searchInit({searchObj:"searchSp", searchText: "sp_name", searchId: "sp_id", result:"result", searchUrl: "/seachCpCompanyList.do",cascade:cascade});
	 
	 $("#searchCode").searchInit({searchObj:"searchCode", pid:"sp_id", searchText: "feecodes", searchId: "feecode_id", result:"result1", searchUrl: "/seachSpFeecodeList.do"});
	
});
</script>


</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">计费代码限制</a></li>
			<li><a href="#">计费代码限制</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
				<form id="searcherForm" action="listSpFeecodeLimit.do" method="post" onsubmit="initshow()">
					
					<li><label>上游公司</label>
						<div class="vocation" id="searchSp">
					
						<!-- <select id="sp_id" name="sp_id" class="select3">
                		   <option value="">请选择</option>
                	      	<forEach items="{companyList}" var="sp">
                			 <option value="{sp.sp_id}" <if test="{searchObj.sp_id eq sp.sp_id}">selected="selected"</if> >{sp.sp_name}</option>
                		    </forEach>
                	   </select> -->
                	   
                	   <div class="select3">
                	    <input id="sp_name" name="sp_name" class="scinput" value="${empty searchObj.sp_name?'--请选择--': searchObj.sp_name}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result" style="position:absolute;display:none;top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="sp_id" name="sp_id" type="hidden" value="${searchObj.sp_id}"/> 
                	   </div>
                	   
					</div></li>
					
					<li><label>计费代码</label>
						<div class="vocation" id="searchCode">
					
						<!-- <select id="feecode_id" name="feecode_id" class="select3">
                		   <option value="">请选择</option>
                	      	<forEach items="{feecodeList}" var="feecode">
                			 <option value="{feecode.feecode_id}" <if test="{searchObj.feecode_id eq feecode.feecode_id}">selected="selected"</if> >{feecode.feecode_number}</option>
                		    </forEach>
                	   </select> -->
                	    <div class="select3">
                	    <input id="feecodes" name="feecodes" class="scinput" value="${empty searchObj.feecodes?'--请选择--': searchObj.feecodes}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result1" style="position:absolute;display:none;top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="feecode_id" name="feecode_id" type="hidden" value="${searchObj.feecode_id}"/> 
                	   </div>
                	   
					</div></li>
					<li><label>计费端口</label><input name="feecode_number" type="text"
						class="scinput" value="${searchObj.feecode_number}"/></li>
					<li><label>&nbsp;</label><input  type="submit"
						class="scbtn" value="查询" /></li>
				</form>
			</ul>

		</div>
<ul class="toolbar">
				<li class="click"><span  ><img src="images/t01.png" /></span>添加</li>

				<li><span><img id="delBtn" src="images/t03.png" /></span>批量删除</li>

			</ul>
	<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>上游公司</th>
					<th>计费代码名称</th>
					<th>计费端口</th>
					<th>日限</th>
					<th>月限</th>
					<th>单用户日限</th>
					<th>单用户月限</th>
					<th>屏蔽省份</th>
					<th>屏蔽地市</th>
					<th>屏蔽日期段</th>
					<th>屏蔽小时段</th>
					<th>备注</th>
					<th>操作人</th>
					<th>更新时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">

							<tr>
								<td><input type="checkbox" name="limit_id" value="${ v.limit_id}" /></td>
								<td>${v.sp_name }</td>
								<td>${v.feecode_name }</td>
								<td>${v.feecode_number }</td>
								<td>${v.day_num }</td>
								<td>${v.month_num }</td>
								<td>${v.single_day_num }</td>
								<td>${v.single_month_num }</td>
								<td>
								   <c:forEach items="${proList}" var="pro">
       									 <c:if test="${fn:contains(v.limit_province,pro.province_id)==true}">${pro.province_name},</c:if> 
    								</c:forEach>
    								</td>
								<td>${v.limit_city }</td>
								<td>${v.limit_time_str}</td>
								<td>${v.limit_hour_str}</td>
								<td>
								<c:if test="${fn:length(v.remarks) > 15}">
									<span title="${v.remarks}">${fn:substring(v.remarks, 0, 5)}...${fn:substring(v.remarks, fn:length(v.remarks)-5, fn:length(v.remarks))}</span>
		      					</c:if>
		      					<c:if test="${fn:length(v.remarks) <= 15}">
									<span title="${v.remarks}">${v.remarks}</span>
		      					</c:if>
								</td>
								<td>${v.create_name }</td>
								<td>${v.update_time }</td>
								<td><a href="#" class="tablelink">查看</a> 
								<a href="editSpFeecodeLimit.do?limit_id=${v.limit_id }" class="tablelink">修改</a>
								<a href="editSpFeecodeProvinceLimit.do?limit_id=${v.limit_id }&remarks=${v.feecode_name }(${v.feecode_number })" class="tablelink">添加省份限制</a>
								
								 <a href="javascript:void()" onclick="deleteSpFeecodeLimit(${ v.limit_id})" class="tablelink"> 删除</a></td>
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
