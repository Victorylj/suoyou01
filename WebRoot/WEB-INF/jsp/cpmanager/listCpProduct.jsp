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

<script type="text/javascript" src="js/cpmanager/listCpProduct.js"></script>
<script type="text/javascript"
	src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript"
	src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript" src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>

</head>


<body>
	 <div class="bg_div"></div>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">计费点管理</a></li>
			<li><a href="#">产品信息</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
				<form id="searcherForm" action="listCpProduct.do" method="post" onsubmit="initshow()">
					<li><label>渠道</label>
						<div class="vocation">
					
						 <select id="cp_id" name="cp_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c:forEach items="${cpList}" var="cps">
                			 <option value="${cps.cp_id}" <c:if test="${searchObj.cp_id eq cps.cp_id}">selected="selected"</c:if> >${cps.cp_name}</option>
                		    </c:forEach>
                	   </select>
                	   
					</div></li>

					<li><label>产品名称</label><input name="product_name" type="text"
						class="scinput" /></li>
					<li><label>产品编号</label><input name="product_code" type="text"
						class="scinput" /></li>
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
					<th style="width:5%"><input name="" type="checkbox" value="" checked="checked" /></th>
					<th style="width:15%">渠道名称</th>
					<th style="width:5%">渠道编号</th>
					<th style="width:10%">产品名称</th>
					<th style="width:5%">产品编号</th>
					<th style="width:25%">产品应用包</th>
					<th style="width:5%">产品费用</th>
					<th style="width:5%" >是否SDK</th>
					<th style="width:5%" >是否弹框</th>
					<th style="width:5%">备注</th>
					<th style="width:5%">操作人</th>
					<th style="width:5%" >更新时间</th>
					<th style="width:15%" >操作</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">

							<tr>
								<td><input type="checkbox" name="product_id" value="${ v.product_id}" /></td>
								<td>${v.cp_name }</td>
								<td>${v.cp_id }</td>
								<td>${v.product_name }</td>
								<td>${v.product_code }</td>
								<td>
								<textarea>${v.product_package }</textarea>
								</td>
								<td>${v.product_fee }</td>
								<td>
								<c:if test="${v.is_overfee eq 0 }">
								是
								</c:if>
								<c:if test="${v.is_overfee eq 1 }">
								否
								</c:if>
								</td>
								<td>
								<c:if test="${v.is_pop eq 1 }">
								是
								</c:if>
								<c:if test="${v.is_pop eq 0 }">
								否
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
								<td>${v.create_name}</td>
								<td>${v.update_time }</td>
								<td><a href="#" class="tablelink">查看</a> <a
									href="editCpProduct.do?product_id=${v.product_id }" class="tablelink">修改</a>
									<a href="javascript:void()"
									onclick="deleteCpProduct(${ v.product_id})" class="tablelink">
										删除</a>
									<a href="javascript:show(${ v.product_id})"  class="tablelink">映射包</a>
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
	<div id="pkdiv" class="pkdiv" >
	 	<div class="pk_tiele">
	 		映射包列表
	 		<a href="javaScript:close()" style="float:right;padding-top:9px;"><img src="images/icon_close.gif">&nbsp;</a>
	 		</div>
	 		<div class="pk_content">
	 	   映射包：  <input id="pkText" type="text"  class="scinput"/><input id="product_id" type="hidden" value=""/>
	 	   <input  type="button" onclick="add()" class="scbtn" value="添加" />
	 	 </div>
	 		<div class="contents" id="contents">
	 	</div>
	 </div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	
	<script type="text/javascript">
			
      function createHtmlObj(id, str){
      		var a = $('<a class="btnyew" id="'+id+'"><span>'+str+'</span></a>'); 
			a.hover(function(){
					$("#clo_"+this.id).css("display","inline")              
    		}, function(){
	      		$("#clo_"+this.id).css("display","none");
     		});
     		var b = $('<a class="cloce" id="clo_'+id+'"><img src="images/error_.png" style="width:15px;"/></a>'); 
     		b.click(function(){
     			var id = $(this).prev().attr("id");
     			var obj = $(this);
     			var url=window.document.location.pathname;
	       	 	url = url.substring(0,url.substr(1).indexOf('/')+1)+"/delPackage.do"; 
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
    	function show(product_id){
    		//$("#pkdiv").show(300);
    		$(".bg_div").show()
    		$("#product_id").val(product_id);
    		init(product_id);
    		$("#pkdiv").slideDown(300);
    	}
    	
    	function close(){
    		//$("#pkdiv").hide(300);
    		$("#product_id").val("");
    		$("#pkdiv").slideUp(300);
    		$(".bg_div").hide();
    		$("#contents").html("");
    	}
    	
        function init(product_id){
        	$("#contents").html("");
      		var url=window.document.location.pathname;
	        url = url.substring(0,url.substr(1).indexOf('/')+1)+"/getPackage.do";  
	        $.post(url, {product_id: product_id}, function(data, status){ 
	        	var objstr = eval(data);      
		      	for(var i=0; i<objstr.length; i++){
		      		createHtmlObj(objstr[i].id,objstr[i].product_package);
		      	}      	 
	    	});  
      	
      	}
			
		function add(){
			var str = $("#pkText").val().trim();
			var product_id = $("#product_id").val().trim();
			if(str==""){
				$("#pkText").select();
				return;
			}
			var url=window.document.location.pathname;
	        url = url.substring(0,url.substr(1).indexOf('/')+1)+"/addPackage.do"; 
			$.post(url, {product_id: product_id,product_package:str}, function(data, status){ 
				createHtmlObj(data,str);
				$("#pkText").val("");
			}); 
			//	$("#contents").append('<a class="btngr" id="1"><span>'+str+'</span></a><a class="cloce" id="clo_1"><img src="css/img/error_.png" style="width:15px;"/></a>');		
		}
	
	</script>

</body>

</html>
