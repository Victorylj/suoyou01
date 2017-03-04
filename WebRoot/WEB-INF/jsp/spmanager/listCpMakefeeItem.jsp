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
<script type="text/javascript" src="js/spmanager/listCpMakefeeItem.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript"  src="js/tableTitle.js"></script>
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
			<li><a href="#">上游代码</a></li>
			<li><a href="#">计费项</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
				<form id="searcherForm" action="listCpMakefeeItem.do" autocomplete="off" method="post" onsubmit="initshow()">
					
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
        				<div id="result" style="position:absolute; display:none; top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="sp_id" name="sp_id" type="hidden" value="${searchObj.sp_id}"/> 
                	   </div>
                	   
					</div></li>
					<li><label>计费代码</label>
						<div class="vocation" id="searchCode">
                	   <div class="select3">
                	    <input id="feecodes" name="feecodes" class="scinput" value="${empty searchObj.feecodes?'--请选择--': searchObj.feecodes}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result1" style="position:absolute; display:none; top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="feecode_id" name="feecode_id" type="hidden" value="${searchObj.feecode_id}"/> 
                	   </div>
                	   
					</div></li>
					<li><label>计费端口</label><input name="feecode_number" type="text" value="${ searchObj.feecode_number}"
						class="scinput" /></li>
					<li><label>指令</label><input name="command" type="text"  value="${ searchObj.command}"
						class="scinput" /></li>
					<li><label>省份</label>
						<div class="vocation">
					
						 <select id="open_province_id" name="open_province_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c:forEach items="${proList}" var="pro">
                			 <option value="${pro.province_id}" <c:if test="${searchObj.open_province_id eq pro.province_id}">selected="selected"</c:if> >${pro.province_name}</option>
                		    </c:forEach>
                	   </select>
                	   
					</div></li>
					
					<li>
					    <label>状态</label>
					    <div class="vocation">
					      <select  name="item_status" class="select3">
					        		<option  value=""  <c:if test="${empty searchObj.item_status }"> selected="selected" </c:if>  >请选择</option>
					                <option  value="1" <c:if test="${searchObj.item_status eq 1 }"> selected="selected" </c:if> >关闭</option>
					                <option  value="0" <c:if test="${searchObj.item_status eq 0 }"> selected="selected" </c:if> >启用</option>
					               
					         </select>
					      </div>
					</li>
    
					<!-- <li><label>计费代码</label>
						<div class="vocation">
					
						 <select id="feecode_id" name="feecode_id" class="select3">
                		   <option value="">请选择</option>
                		    
                	      	<c:forEach items="${feecodeList}" var="feecode">
                			 <option value="${feecode.feecode_id}" <c:if test="${searchObj.feecode_id eq feecode.feecode_id}">selected="selected"</c:if> >${feecode.feecode_number}</option>
                		    </c:forEach>
                	   </select>
                	   
					</div></li>
					
						<li><label>指令</label>
						<div class="vocation">
					
						 <select id="command_id" name="command_id" class="select3">
                		   <option value="">请选择</option>
                		    
                	      	<c:forEach items="${feecodeList}" var="feecode">
                			 <option value="${feecode.feecode_id}" <c:if test="${searchObj.feecode_id eq feecode.feecode_id}">selected="selected"</c:if> >${feecode.feecode_number}</option>
                		    </c:forEach>
                	   </select>
                	   
					</div></li> -->
					
					<li><label>&nbsp;</label><input  type="submit"
						class="scbtn" value="查询" /></li>
				</form>
			</ul>
		</div>
<!-- 
		<div class="pagin">
			<ul class="paginList">
				<li class="paginItem"><a href="javascript:;"
					onclick="getPageId(${page.pages},${page.pageNum-1})"><span
						class="pagepre"></span></a></li>

				<li class="paginItem"><a href="javascript:;"
					onclick="getPageId(${page.pages},${page.pageNum+1})"><span
						class="pagenxt"></span></a></li>
			</ul>
		</div>
		 -->
		
		<ul class="toolbar">
				<li class="click"><span  ><img src="images/t01.png" /></span>添加</li>

				<li style="display:none;"><span><img id="delBtn" src="images/t03.png" /></span>批量删除</li>

			</ul>
			<div class="divtable" style="overflow-x:hidden;">
		<table class="tablelist" >
			<thead>
				<tr>
					<th style="display:none;"><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>上游名称</th>
					<th>运营商</th>
					<th>计费代码名称</th>
					<th>计费端口</th>					
					<th>指令</th>
					<th>指令长度</th>
					<th>指令费用</th>
					<th>省份</th>
					 <th>屏蔽地市</th> 
					<th>状态</th>
					<th>操作人</th>
					<th>更新时间</th>
					<th>操作</th>
				</tr>
			</thead>
		</table>
	 </div>
	<div class="divtable">	
		<table class="tablelist" style="margin-top:-36px;">
			<thead>
				<tr>
					<th style="display:none;"><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>上游名称</th>
					<!--  <th>计费项名称</th>-->
					<!--  <th>计费项编码</th>-->
					<th>运营商</th>
					<th>计费代码名称</th>
					<!--<th>计费代码</th>-->
					<th>计费端口</th>					
					<th>指令</th>
					<th>指令长度</th>
					<th>指令费用</th>
				<!-- 	<th>二次确认</th>
					<th>二次确认端口</th>
					<th>二次确认内容</th>
					<th>二次确认类型</th>
					<th>短信验证前段信息</th>
					<th>短信验证后端信息</th>
					<th>短信验证内容</th>
					<th>是否过滤短信</th>
					<th>过滤端口</th>
					<th>过滤内容</th>
					<th>互联网计费规则</th>
					<th>发送短信时间间隔</th>
					<th>计费优先级</th>
						<th>状态</th> -->
					<th>省份</th>
					 <th>屏蔽地市</th> 
					<th>状态</th>
					<!-- <th>备注</th>	 -->
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
								<td style="display:none;"><input type="checkbox" name="cp_item_id" value="${ v.cp_item_id}" /></td>
								<td>${v.sp_name }</td>
								<!--<td>${v.cp_item_name }</td>-->
								<!-- <td>${v.cp_item_code }</td>-->
								<td>
							
								<c:if test="${v.feecode_op == 1 }">
								移动
								</c:if>
								<c:if test="${v.feecode_op == 2 }">
								联通
								</c:if>
								<c:if test="${v.feecode_op == 3 }">
								电信
								</c:if>
								</td>
								<td>${v.feecode_name }</td>
								<!--<td>${v.feecode_code }</td>-->
								<td>${v.feecode_number }</td>
								<td>${v.command }</td>
								<td>${v.command_length }</td>
								<td>${v.command_fee }</td>
							<!--  	<td>${v.is_second }</td>
								<td>${v.second_port }</td>
								<td>${v.second_info }</td>
								<td>${v.second_type }</td>
								<td>${v.replay_start_str }</td>
								<td>${v.replay_end_str }</td>
								<td>${v.replay_str }</td>
								<td>${v.is_filter }</td>
								<td>${v.filter_port }</td>
								<td>${v.filter_info }</td>
								<td>${v.network_role }</td>
								<td>${v.sms_delay_time }</td>
								
								<td>${v.use_priority }</td> -->
								<td>${v.open_province_name }</td>
								
								<td >
								
								   <c:forEach items="${cityList}" var="city"><c:if test="${fn:contains(v.hide_city,city.city_id)==true}">${city.city_name},</c:if></c:forEach>
    							
    							</td>
								
								<td>
								 <c:if test="${v.item_status eq 1 }">
								 	<font color="red">关闭</font>
								 </c:if>
								<c:if test="${v.item_status eq 0 }">
								 	<font color="grean">启用</font>
								 </c:if>
								</td>
								<!-- <td>${v.remarks }</td> -->
								<td>${v.create_name }</td>
								<td>${v.update_time }</td>
								<td><a href="editCpMakefeeItem.do?cp_item_id=${v.cp_item_id }" class="tablelink" style="display:none;">查看</a> 
								<a href="editCpMakefeeItem.do?cp_item_id=${v.cp_item_id }&feecode_number=${v.feecode_number}&command_id=${v.command_id}" class="tablelink">修改</a>
								 
								 <c:if test="${v.item_status eq 0 }">
								 	 <a href="javascript:void()" onclick="closeOrOpenCpMakefeeItem(${v.open_province_id },${ v.cp_item_id},1)" class="tablelink">关闭</a>
								 </c:if>
								<c:if test="${v.item_status eq 1 }">
								 	 <a href="javascript:void()" onclick="closeOrOpenCpMakefeeItem(${v.open_province_id },${ v.cp_item_id},0)" class="tablelink">启用</a>
								 </c:if></td>
							</tr>

						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="25">没有搜索到符合条件的数据！</td>
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
