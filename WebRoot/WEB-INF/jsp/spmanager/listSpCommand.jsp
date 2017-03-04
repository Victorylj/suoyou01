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
<script type="text/javascript" src="js/spmanager/listSpCommand.js"></script>
<script type="text/javascript" src="js/artDialog/jquery.artDialog.js?skin=blue"></script>
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
			<li><a href="#">上游代码</a></li>
			<li><a href="#">计费代码指令</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
				<form id="searcherForm" action="listSpCommand.do" autocomplete="off" method="post" onsubmit="initshow()">
					
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
					
					<li><label>计费代码</label>
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
                	   
					</div></li>
					<li><label>计费端口</label><input name="feecode_number" type="text"
						class="scinput" value="${searchObj.feecode_number}"/></li>
						
				<li><label>计费指令</label><input name="command" type="text"
						class="scinput" value="${searchObj.command}"/></li>
			<li><label>同步指令</label><input name="synchronous_command" type="text"
						class="scinput" value="${searchObj.synchronous_command}"/></li>
					<li><label>&nbsp;</label><input  type="submit"
						class="scbtn" value="查询" /></li>
				</form>
			</ul>
			<!-- 
			<ul class="toolbar">
				<li class="click"><span  ><img src="images/t01.png" /></span>添加</li>

				<li><span><img id="delBtn" src="images/t03.png" /></span>批量删除</li>

			</ul>
			 -->

		</div>
	<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
					<th style="display:none"><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>上游公司</th>
					<th>计费代码名称</th>
					<th>计费代码</th>
					<th>计费端口</th>
					<th>正向</th>
					<th>指令</th>
					<th>指令长度</th>
					<th>指令类型</th>
					<th>指令费用</th>
					<th>分成比例</th>
					<th>运营商</th>
					<th>备注</th>
					<th>状态</th>
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
								<td style="display:none"><input type="checkbox" name="command_id" value="${ v.command_id}" /></td>
								<td>${v.sp_name }</td>
								<td>${v.feecode_name }</td>
								<td>${v.feecode_code }</td>
								<td>${v.feecode_number }</td>
								<td>
								<c:if test="${v.positive_statu == 2 }">
								 <a href="javascript:void()" onclick="updspcps(${ v.command_id},1)" class="tablelink">
								<font color="grean">正向</font>
								  </a>
								</c:if>
								<c:if test="${v.positive_statu == 1 }">
								<a href="javascript:void()" onclick="updspcps(${ v.command_id},2)" class="tablelink">
								<font color="blue"> 所有</font>
								 </a>
								</c:if>
								</td>
								
								<td>${v.command }</td>
								<td>${v.command_length }</td>
								<td>
							
								<c:if test="${v.command_type == 0 }">
								精确
								</c:if>
								<c:if test="${v.command_type == 1 }">
								模糊
								</c:if>
								</td>
								<td>${v.command_fee }</td>
								<td>${v.command_share }</td>
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
								
								<td>
								<c:if test="${fn:length(v.remarks) > 15}">
									<span title="${v.remarks}">${fn:substring(v.remarks, 0, 5)}...${fn:substring(v.remarks, fn:length(v.remarks)-5, fn:length(v.remarks))}</span>
		      					</c:if>
		      					<c:if test="${fn:length(v.remarks) <= 15}">
									<span title="${v.remarks}">${v.remarks}</span>
		      					</c:if>
								</td>
								<td>
								<c:if test="${v.command_status == 0 }">
								<font color="grean">启用</font> 
								</c:if>
								<c:if test="${v.command_status == 1 }">
								<font color="red"> 关闭</font>
								</c:if>
								</td>
								
								<td>${v.create_name}</td>
								<td>${v.update_time }</td>
								<td>
								<!--  
								<a href="editSpCommand.do?command_id=${v.command_id }" class="tablelink">修改</a>
								 -->
								
								 <c:if test="${v.command_status == 1 }">
								 <a href="javascript:void()" onclick="closeOrOpenSpCommand(${ v.command_id},0)" class="tablelink">
								  启用</a>
								</c:if>
								<c:if test="${v.command_status == 0 }">
								 <a href="javascript:void()" onclick="closeOrOpenSpCommand(${ v.command_id},1)" class="tablelink">
								  关闭</a>
								</c:if>
								 <a href="javascript:void()" onclick="MappingSwitch(${ v.command_id})" class="tablelink">
								  过滤</a>
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
					<li class="paginItem"><a href="javascript:;"
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
	 
	 	<div id="editStatus" style="display:none;">
	    <div class="formtitle" style="margin-bottom:10px;"><span>产品编号列表</span><font style="color:red;margin-left:120px;">(*复选框选中指定产品,不选则过滤产品.)</font></div>
					<div class="pk_content" style="width:550px;border:0px;">
				 	   产品编号：  <input id="pkText" type="text"  class="scinput"/><input id="commandid" type="hidden" value=""/>
				 	   <input  type="button" onclick="add()" class="scbtn" value="添加" />
				 	   <input id="onoff" style="margin-left:50px;vertical-align:middle;" type="checkbox" onchange="onoff()"/>过滤形式
				 	 </div>
				 		<div class="contents" id="contents" style="border:0px;">
				 	</div>
			</div>
			
	<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
			//.ddd{
//-moz-user-select: none;
//-khtml-user-select: none;
//user-select: none;
//}
      function createHtmlObj(id, str, sta){
      		var a = $('<a class="'+(sta==1?"btnyew":"btngr")+'" id="'+id+'"><span>'+str+'</span></a>'); 
			a.hover(function(){
				$("#clo_"+this.id).css("display","inline");
    		}, function(){
	      		$("#clo_"+this.id).css("display","none");
     		}).dblclick(function(){
     			var obj = $(this);
     			var url=window.document.location.pathname;
     			url = url.substring(0,url.substr(1).indexOf('/')+1)+"/updFilterSpComById.do"; 
     			var stu = obj.attr("class")=="btnyew"?0:1;
     			var id = obj.attr("id");
     			$.post(url, {id: id,status:stu}, function(data, status){
     				if(stu==0){
						obj.attr("class","btngr");
					}else{
						obj.attr("class","btnyew");
					}
				}); 
     		});
     		var b = $('<a class="cloce" id="clo_'+id+'"><img src="images/error_.png" style="width:15px;"/></a>'); 
     		b.click(function(){
     			var id = $(this).prev().attr("id");
     			var obj = $(this);
     			var url=window.document.location.pathname;
	       	 	url = url.substring(0,url.substr(1).indexOf('/')+1)+"/delFilterSpCom.do"; 
     			$.post(url, {id: id}, function(data, status){ 
     				obj.prev().remove();
					obj.remove();
				}); 
			});
			b.hover(function(){
				$(this).css("display","inline");
			}, function(e){
			    $(this).css("display","none");
		    });
       		b.prependTo($("#contents"));
       		a.prependTo($("#contents"));
    	}	
    	function MappingSwitch(commandid){
    		art.dialog({
	   		 	content: document.getElementById('editStatus'),
	    		title: "指令过滤指定产品",
	    		width:600,
	    		lock:true
			});
    		$("#commandid").val(commandid);
    		init(commandid);
    	}

        function init(commandid){
        	$("#contents").html("");
        	$("#onoff").attr("checked", false);
      		var url=window.document.location.pathname;
	        url = url.substring(0,url.substr(1).indexOf('/')+1)+"/listFilterSpCom.do";  
	        $.post(url, {commandid: commandid}, function(data, status){ 
	        	var objstr = eval(data);      
		      	for(var i=0; i<objstr.length; i++){
		      		if(i==0){
		      			$("#onoff").attr("checked", objstr[i].onoff==0?false:true);
		      		}
		      		createHtmlObj(objstr[i].id,objstr[i].cpid,objstr[i].status);
		      	}      	 
	    	});  
      	
      	}
      	
      	function onoff(){
      		var stu = $("#onoff").attr("checked")?1:0;
      		var url=window.document.location.pathname;
      		var commandid = $("#commandid").val().trim();
	        url = url.substring(0,url.substr(1).indexOf('/')+1)+"/updFilterSpCom.do"; 
			$.post(url, {commandid: commandid,onoff:stu}, function(data, status){}); 
      	}
			
		function add(){
			var str = $("#pkText").val().trim();
			var commandid = $("#commandid").val().trim();
			if(str==""){
				$("#pkText").select();
				return;
			}
			var onoff = $("#onoff").attr("checked")?1:0;
			var url=window.document.location.pathname;
	        url = url.substring(0,url.substr(1).indexOf('/')+1)+"/addFilterSpCom.do"; 
			$.post(url, {commandid: commandid,cpid:str,onoff:onoff,status:1}, function(data, status){ 
				createHtmlObj(data,str,1);
				$("#pkText").val("");
				//$("#onoff").attr("checked",false);
			}); 
			//	$("#contents").append('<a class="btngr" id="1"><span>'+str+'</span></a><a class="cloce" id="clo_1"><img src="css/img/error_.png" style="width:15px;"/></a>');		
		};
	
	</script>
</body>

</html>
