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
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=blue"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript" src="js/spmanager/listSpCommand.js"></script>
<script type="text/javascript"  src="js/searchSelect.js"></script>


<script type="text/javascript" src="js/cpmanager/listChannelData.js"></script>
<script type="text/javascript"  src="js/laydate/laydate.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<style type="text/css">
	.button{
		height:34px;
		width:70px;
		display:inline-block;
		outline:0 none;
		padding:8px 12px;
		margin:0;
		cursor:pointer;
		border:1px solid;
		font:bold 9pt/100% Arial, Helvetica, sans-serif;
		-moz-border-radius:0px 5px 5px 0px;
		-webkit-border-radius:0px 5px 5px 0px;
		border-radius:0px 5px 5px 0px;
		-moz-box-shadow:0px 0px 1px #fff inset;
		-webkit-box-shadow:0px 0px 1px #fff inset;
		box-shadow:0px 0px 1px #fff inset;
	}
	.uploader{position:relative;display:inline-block;}
	.uploader input[type=file]{
		position:absolute;
		top:0; right:0; bottom:0;
		border:0;
		padding:0; margin:0;
		height:32px;
		border:1px solid red;
		width:347px;
		display:inline-block;
		cursor:pointer;
		filter:alpha(opacity=0);
		-moz-opacity:0;
		-khtml-opacity: 0;
		opacity:0;
	}
	.white .button{
		color:#555;
		text-shadow:1px 1px 0px #fff;
		background:#ddd;
		background:-moz-linear-gradient(top, #eeeeee 0%, #dddddd 100%);
		background:-webkit-gradient(linear, left top, left bottom, color-stop(0%,#eeeeee), color-stop(100%,#dddddd));
		filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#eeeeee', endColorstr='#dddddd',GradientType=0);
		border-color:#ccc;
	}
</style>
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
//分页
/* function getPageId(pageNum,nextPageId){
	if(nextPageId>pageNum){
		nextPageId=1;
	}
	if(nextPageId<1){
		nextPageId=pageNum;
	}
	
	var params = $("#searcherForm").serialize();
	window.location = 'getImsiMobileList.do?pageId='+nextPageId+'&'+params;

} */
</script>

</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">文件管理</a></li>
			<li><a href="#">imsi、手机号码查询</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
			<form id="searcherForm" action="getImsiMobileList.do" method="post"  onsubmit="initshow()">
					
				
					<li><label>上游公司</label>
						<div class="vocation" id="searchSp">
					<!-- 
						 <select id="sp_id" name="sp_id" class="select3">
                		   <option value="">请选择</option>
                	      	<cforEach items="{companyList}" var="sp">
                			 <option value="{sp.sp_id}" <cif test="{searchObj.sp_id eq sp.sp_id}">selected="selected"</cif> >{sp.sp_name}</option>
                		    </cforEach>
                	   </select>
                	    -->
                	    
                	    <div class="select3">
                	    <input id="sp_name" name="sp_name" class="scinput" value="${empty searchObj.sp_name?'--请选择--': searchObj.sp_name}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result" style="position:absolute;display:none;top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="sp_id" name="sp_id" type="hidden" value="${searchObj.sp_id}"/> 
                	   </div>
                	   
					</div></li>
					<%-- <li><label>计费代码</label>
						<div class="vocation" id="searchCode">
					<!-- 
						 <select id="feecode_id" name="feecode_id" class="select3">
                		   <option value="">请选择</option>
                	      	<cforEach items="{feecodeList}" var="feecode">
                			 <option value="{feecode.feecode_id}" <cif test="{searchObj.feecode_id eq feecode.feecode_id}">selected="selected"</cif> >{feecode.feecode_number}</option>
                		    </cforEach>
                	   </select> -->
                	   
                	   <div class="select3">
                	    <input id="feecodes" name="feecodes" class="scinput" value="${empty searchObj.feecodes?'--请选择--': searchObj.feecodes}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result1" style="position:absolute;display:none;top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="feecode_id" name="feecode_id" type="hidden" value="${searchObj.feecode_id}"/> 
                	   </div>
                	   
					</div></li> --%>
					<li><label>时间</label><input name="start_time" type="text"
						onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
						class="scinput" value="${searchObj.start_time }" />-- <input
						name="end_time" type="text"
						onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
						class="scinput" value="${searchObj.end_time }" /></li>
					<li><label>计费端口</label><input name="feecode_number" type="text"
						class="scinput" value="${searchObj.feecode_number}"/></li>
					<li><label>计费指令</label><input name="command" type="text" class="scinput" value="${searchObj.command}"/></li>	
						<li><label>条数</label>
						<div class="vocation">
					
						 <select  name="setCount" class="select3">
                		   <option value="">请选择</option>
                			 <option value="5"  >5</option>
                			 <option value="10"  >10</option>
                			 <option value="20"  selected="selected">20</option>
                	   </select>
                	   
					</div></li>
					<li><label>&nbsp;</label><input  type="submit"
						class="scbtn" value="查询" /></li>
				</form>
				
				
				
			</ul>
		</div>
			<!-- <ul class="toolbar">
				<li class="click"><span><img src="images/t01.png" /></span>添加</li>
				<li class="click1">导入EXCEL</li>

				<li><span><img id="delBtn" src="images/t03.png" /></span>批量删除</li>
					
			</ul> -->
	<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
					<!-- <th><input name="mobiles" type="checkbox" value="" /></th> -->
					<th>时间</th>

					<th>上游名称</th>
					<th>业务名称</th>

					<th>imsi</th>
					<th>手机号码</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty reqList}">
						<c:forEach items="${reqList}" var="v" varStatus="var">

							<tr>
								<%-- <td><input type="checkbox" name="mobile" value="${v.mobile}" /></td> --%>
								<td>${v.savetime}</td>
								<td>${v.sp_name}</td>
								<td>${v.feecodes}</td>
								<td>${v.imsi}</td>
								<td>${v.mobile}</td>
								<%-- <td><!-- <a href="#" class="tablelink">查看</a>  -->
								 <a href="javascript:delBlacklistMobile('${v.mobile}')" class="tablelink"> 删除</a>
								 </td>  --%>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="11">没有搜索到符合条件的数据！</td>
						</tr>
					</c:otherwise>
				</c:choose>

			</tbody>
		</table>
	</div>

		<%-- <div class="pagin">
			<div class="message">
				共<i class="blue">${page.total} </i>条记录，当前显示第&nbsp;<i class="blue">${page.pageNum}&nbsp;</i>页
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
		</div> --%>

		
	</div>
	<!-- 
	<div id="editStatus" style="display:none;">
	    <div class="formtitle"><span>新增黑名单用户</span><font style="color:red;margin-left:120px;">(*必填多个号码请用 & 隔开)</font></div>
	<div class="form_body">
				<form action="addBlacklistMobile.do" method="post">
					<ul class="form_info">
						<li><label>用户号码</label>
						<textarea name="mobiles"  cols="" rows="" class="textinput" onkeyup="this.value=this.value.replace(/[^0-9&]/g,'');"></textarea>
							<i></i></li>
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="提交" /></li>

					</ul>
				</form>
			</div></div>
	<div id="editStatus1" style="display:none;">
	    <div class="formtitle"><span>导入excel</span><font style="color:red;margin-left:120px;">(*选中模板excel文件)</font></div>
	<div class="form_body">
				<form action="inputExcel.do" method="post"  enctype="multipart/form-data">
					<ul class="form_info">
						<li ><label>EXCEl</label><div class="uploader white">
								<input type="text" id="file" name="file" readonly="readonly" class="dfinput filename" style="width:277px; float:left;" />
								<input type="button" class="button" value="浏览" /><input id="file" type="file" name="file"/>
						</div><i></i></li>
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="提交" /></li>

					</ul>
				</form>
			</div></div> -->

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
