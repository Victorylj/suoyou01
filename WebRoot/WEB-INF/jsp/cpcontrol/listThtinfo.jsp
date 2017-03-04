<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="js/stat/listFeecodeStat.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=blue"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript"  src="js/pop.js"></script>
<script type="text/javascript"  src="js/laydate/laydate.js"></script>
<script type="text/javascript"  src="js/searchSelect.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript">
$(document).ready(function() {
		$(".click1").click(function() {
			var str = $(this).text();
			if(str.indexOf("开启")>=0){
				str = "开启";
			}else{
				str = "关闭";
			}
			var length = $("input[type=checkbox][name=sub_id]:checked").length;
			if(length<=0){
				art.dialog({
				    content: '未选择数据!',
				    time: 1,
				    lock:true
				    
				});
				return;
			}
			//var ccpid="";
			//$("input[type=checkbox][name=cp_id]:checked").each(function(){ 
			//	ccpid+=$(this).val();  
			//});
			art.dialog.confirm("确认"+str+"以下渠道？", 
				function() {
					  var path= 'conThtpl.do?tag=' + ${searchObj.tag};
					     $('#mvForm').attr("action", path).submit();
				}
			);
		});
		$(".click3").click(function() {
			var str = "开启";
			var length = $("input[type=checkbox][name=sub_id]:checked").length;
			if(length<=0){
				art.dialog({
				    content: '未选择数据!',
				    time: 1,
				    lock:true
				    
				});
				return;
			}
			art.dialog.confirm("确认"+str+"以下渠道？", 
				function() {
					  var path= 'conThtpl.do?tag=1&pageId='+${page.pageNum};
					     $('#mvForm').attr("action", path).submit();
				}
			);
		});
		$(".click4").click(function() {
			var str = "关闭";
			var length = $("input[type=checkbox][name=sub_id]:checked").length;
			if(length<=0){
				art.dialog({
				    content: '未选择数据!',
				    time: 1,
				    lock:true
				    
				});
				return;
			}
			art.dialog.confirm("确认"+str+"以下渠道？", 
				function() {
					  var path= 'conThtpl.do?tag=0&pageId='+${page.pageNum};
					     $('#mvForm').attr("action", path).submit();
				}
			);
		});
		
		
		$("#cpAll_id").click(function() {
             $('input[name=sub_id]').attr("checked",this.checked); 
        });
        $("input[type=checkbox][name=cp_id]").click(function(){
             $("#cpAll_id").attr("checked",$("input[type=checkbox][name=sub_id]").length == $("input[type=checkbox][name=sub_id]:checked").length ? true : false);
        });
		
		$(".click2").click(function() {
			//$(".editdiv").fadeIn(200);
			var str = $(this).text();
			if(str.indexOf("开启")>=0){
				str = "添加开启";
			}else{
				str = "添加关闭";
			}
			$(".formtitle").find("span").html(str);
			art.dialog({
   		 		content: document.getElementById('editStatus'),
    			title: "渠道状态修改",
    			lock:true
			});
	 
		});
	//	 $("#searchCode").searchInit({searchObj:"searchCode", searchText: "product_code", searchId: "product_code", result:"result2", searchUrl:"/seachCodeList.do"});
		 $("#searchSp").searchInit({searchObj:"searchSp", searchText: "cp_name", searchId: "cp_id", result:"result", searchUrl: "/seachCaipCompanyListfor.do"});
		 $("#searchName").searchInit({searchObj:"searchName", pid:"cp_id", searchText: "product_name", searchId: "product_id", result:"result1", searchUrl: "/seachProductList.do"});

	});
	function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
		/* var params = $("#searcherForm").serialize();
		param = decodeURIComponent(params,true);
		window.location = 'getThtlist.do?pageId='+nextPageId+'&'+param; */
	     var path= 'getThtlist.do?pageId=' + nextPageId;
	     $('#searcherForm').attr("action", path).submit();
		
	}
	
	var tag=${searchObj.tag};
	 function checkTag(){
		 if (tag!=0&&tag!=1){ 
				$("#thtopen").css("display","block");
				$("#thtclose").css("display","block");
		 }
		}
	 function closeIstht(obj,obj2){
			var str = obj==0?'开启':'关闭';
			art.dialog.confirm("确认"+str+"该渠道？", 
					function() {
						     window.location = 'changgeTht.do?tag='+obj+'&sub_id='+obj2+'&pageId='+${page.pageNum};
					});
		}
	 
	 
</script>

</head>


<body>

	<div class="rightinfo">
		<div class="tools">
		<form id="searcherForm" id="searcherForm" action="getThtlist.do" method="post" onsubmit="initshow()">
			<ul class="seachform">
											
					<li><label>渠道</label>
					<div class="vocation" id="searchSp">
                	    <div class="select3">
                	    <input id="cp_name" name="cp_name" class="scinput" AutoComplete="off" value="${empty searchObj.cp_name?'--请选择--': searchObj.cp_name}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result" style="position:absolute;display:none;top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="cp_id" name="cp_id" type="hidden" value="${searchObj.cp_id}"/> 
                	   </div>
					</div>
				</li>	
				<li><label>产品</label>
						<div class="vocation" id="searchName">
                	   <div class="select3">
                	    <input id="product_name" name="product_name" AutoComplete="off" class="scinput" value="${empty searchObj.product_name?'--请选择--': searchObj.product_name}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result1" style="position:absolute;display:none;top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="product_id" name="product_id" type="hidden" value="${searchObj.product_id}"/> 
                	   </div>
                	   
					</div>
				</li>	
				<%-- <li><label>代码</label>
						<div class="vocation" id="searchCode">
                	   <div class="select3">
                	    <input id="product_code" name="product_code" AutoComplete="off" class="scinput" value="${empty searchObj.product_code?'--请选择--': searchObj.product_code}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result2" style="position:absolute;display:none;top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="product_codev" name="product_codev" type="hidden" value="${searchObj.product_code}"/> 
                	   </div>
                	   
					</div>
				</li>	 --%>
				<li>
					<label>
						<input name="tag" type="radio" value="0" <c:if test="${searchObj.tag eq 0}">checked="checked" </c:if> />
						开</label>
						<label>
						<input name="tag" type="radio" value="1" <c:if test="${searchObj.tag eq 1}">checked="checked" </c:if> />
						关</label>
						<label>
						<input name="tag" type="radio" value="2" <c:if test="${searchObj.tag eq 2}">checked="checked" </c:if> />
						全部</label>
					</li>	
					
					
					<li><label>CCPID</label><input name="ccp_id" type="text"  value="${ searchObj.ccp_id}"
						class="scinput" /></li>
				
					<li> 
					<label>&nbsp;</label>
					<input id="scbtn"  type="submit"
						class="scbtn" value="查询" /></li>
				
				
			</ul>
			</form>
		
		</div>
	<ul class="toolbar">
     		<c:if test="${searchObj.tag==0}">
				<li class="click1"><span><img src="images/t01.png" /></span>批量关闭</li>
			</c:if>
			<c:if test="${searchObj.tag==1}">
				<li class="click1"><span><img src="images/t01.png" /></span>批量开启</li>
			</c:if>
		<li class="click3" id="thtopen" style="display: none"><span><img src="images/t01.png" /></span>批量开启</li>
		<li class="click4" id="thtclose" style="display: none"><span><img src="images/t01.png" /></span>批量关闭</li>
	</ul>

	<div class="divtable">
	<form id="mvForm" action="" method="post" onsubmit="initshow()">
		<table class="tablelist">
			<thead>
				<tr>
				<th><input onclick="checkTag()" type="checkbox" id="cpAll_id" /></th>
				<th>日期</th>
				<th>产品</th>
				<th>渠道</th>
				<th>推广产品ID</th>
				<th>有效用户</th>
				<th>13</th>
				</tr>
			</thead>

			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">
							<tr>
							<td><input type="checkbox" onclick="checkTag()" name="sub_id" value="${v.sub_id}" />
								</td>
								<td>${v.dater }</td>
								<td>${v.product_name }</td>
								<td>${v.cp_name }</td>
								<td>${v.subchannel_id }</td>
								<td>${v.initnum }</td>

								<td>
								    
									<c:if test="${v.is_tht eq 0}">
										<font color="green" onclick="closeIstht(1,${v.sub_id});">开</font>
									</c:if>
									<c:if test="${v.is_tht eq 1}">
										<font color="red" onclick="closeIstht(0,${v.sub_id});">关</font>
									</c:if>
									
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
			</form>
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
