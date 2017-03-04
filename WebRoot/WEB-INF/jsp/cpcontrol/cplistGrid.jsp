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
<style >
.tip {
    width: 80%;
    height: 80%;
    top: 10%;
    left: 10%;
}
.tipinfo {
    padding-top: 0px;
    margin-left: 0px;
    height: 450px;
    overflow:scroll;
}
.tipbtn {
    margin-top: 25px;
    margin-left: 70%;
}
input[type=checkbox].titcheck{height: 12px;}
.tbtd{text-align: center;}
</style>
<script type="text/javascript">

	
	function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
		var path= 'getTreeGridjson.do?pageId=' + nextPageId;
	     $('#searcherForm').attr("action", path).submit();
	}

	function getSublist(id){
		$('#subtn').removeAttr("disabled");
		$("#pageId").val(${pageId});
		getRow(id);
		$("#delDiv").css("display","block");
	}
	function getSubOne(){
		$('#subtn').removeAttr("disabled");
		$("#pageId").val(${pageId});
		var id=$("#sccpid").val();
		getRow(id);
		$("#delDiv").css("display","block");
	}
	
	function getRow(id){
		    $.post("getnTable.do",{id:id},function(data){
				 var htmltB="";
				 if(!data){
					 $('#subtn').attr('disabled',"true");
					 htmltB +="<tr>"
							+"<td colspan='6'>没有搜索到符合条件的数据</td>"
							+"</tr>"; 
		   		 }  else{
		   			
		   			$.each(data,function(index,obj){
		   				var pop,loading,isTht;
		   				if(obj.isPop==0){
		   					pop="<input type='checkbox' checked='checked' value='"+obj.id+"' onclick='nodeCheck(this);'  name='isPop' /><input  name='isPopinput' value='"+obj.isPop+"'  type='hidden' ></input>"
		   				}else{
		   					pop="<input type='checkbox' value='"+obj.id+"' onclick='nodeCheck(this);'  name='isPop' /><input  name='isPopinput' value='"+obj.isPop+"' type='hidden' ></input>"
		   				}
		   				if(obj.isLoading==0){
		   					loading="<input type='checkbox' checked='checked' value='"+obj.id+"' onclick='nodeCheck(this);' name='isLoading' /><input  name='isLoadinginput' value='"+obj.isLoading+"'  type='hidden' ></input>"
		   				}else{
		   					loading="<input type='checkbox' value='"+obj.id+"' onclick='nodeCheck(this);' name='isLoading' /><input  name='isLoadinginput' value='"+obj.isLoading+"'  type='hidden' ></input>"
		   				}
		   				/* if(obj.isTht==0){
		   					isTht="<input type='checkbox' checked='checked' onclick='nodeCheck(this);' value='"+obj.id+"' name='isTht' /><input  name='isThtinput' value='"+obj.isTht+"'  type='hidden' ></input>"
		   				}else{
		   					isTht="<input type='checkbox' value='"+obj.id+"' onclick='nodeCheck(this);' name='isTht' /><input  name='isThtinput' value='"+obj.isTht+"'  type='hidden' ></input>"
		   				} */
		   				
						  htmltB +="<tr>"
						  	+"<input  name='id' value='"+obj.id+"' type='hidden' ></input>"
							+"<td>"+obj.product_code+"</td>"
							+"<td>"+obj.product_name+"</td>"
							+"<td>"+obj.cp_name+"</td>"
							+"<td class='tbtd'>"+pop+"</td>"
							+"<td class='tbtd'>"+loading+"</td>"
							/* +"<td class='tbtd'>"+isTht+"</td>" */
							+"</tr>"; 
					
					});  
		   			
		   		 }
				  $("#tbody").html(htmltB); 
			 },"json");  
	}
		$(function() { 
			$("#cbAllpop").click(function() { 
				var flag = $(this).attr("checked"); 
				$("[name=isPop]:checkbox").each(function() { 
					$(this).attr("checked", flag); 
					if(flag){
						$(this).next().val(0);
					}else{
						$(this).next().val(1);
					}
				});
			});
			$("#cbAllload").click(function() { 
				var flag = $(this).attr("checked"); 
				$("[name=isLoading]:checkbox").each(function() { 
					$(this).attr("checked", flag); 
					if(flag){
						$(this).next().val(0);
					}else{
						$(this).next().val(1);
					}
				});
			});
			$("#cbAlltht").click(function() { 
				var flag = $(this).attr("checked"); 
				$("[name=isTht]:checkbox").each(function() { 
					$(this).attr("checked", flag); 
					if(flag){
						$(this).next().val(0);
					}else{
						$(this).next().val(1);
					}
				});
			});
			 $("#searchSp").searchInit({searchObj:"searchSp", searchText: "cp_name", searchId: "cp_id", result:"result", searchUrl: "/seachCaipCompanyListfor.do"});
			 $("#searchName").searchInit({searchObj:"searchName", pid:"cp_id", searchText: "product_name", searchId: "product_id", result:"result1", searchUrl: "/seachProductList.do"});
			 $("#searchCode").searchInit({searchObj:"searchCode", searchText: "product_code", searchId: "product_id1", result:"result2", searchUrl:"/seachCodeList.do"});
		}) 
		function nodeCheck(obj){
			var flag =obj.checked ; 
			if(flag){
				$(obj).next().val(0);
			}else{
				$(obj).next().val(1);
			}
		}
		
</script>

</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">渠道管控</a></li>
			<li><a href="#">产品管控</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
		<form id="searcherForm" action="getTreeGridjson.do" method="post" onsubmit="initshow()">
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
				<li><label>代码</label>
						<div class="vocation" id="searchCode">
                	   <div class="select3">
                	    <input id="product_code" name="product_code" AutoComplete="off" class="scinput" value="${empty searchObj.product_code?'--请选择--': searchObj.product_code}" style="position:absolute;top:2px;left:2px;width:73px;outline: none;border:0px;z-index:9;"/> 
        				<div id="result2" style="position:absolute;display:none;top:33px; min-width:98px; max-height:200px;overflow:auto;z-index:2;"></div>  
                	   	<input id="product_id1" name="product_code" type="hidden" value="${searchObj.product_code}"/> 
                	   </div>
					</div>
				</li>	
				
					<li> 
					<label>&nbsp;</label>
					<input  type="submit"
						class="scbtn" value="查询" /></li>
				
				
			</ul>
			</form>
		<ul class="seachform">
		<li><label>CCPID</label><input name="ccp_id" id="sccpid" type="text"  value="${ searchObj.ccp_id}"
						class="scinput" /></li>
				
			<li> 
					<label>&nbsp;</label>
					<input  type="button"
						class="scbtn" onclick="getSubOne()" value="设置" /></li>			
		</ul>
		</div>

	<div class="divtable">
		<table class="tablelist">
			<thead>
				<tr>
				<th>渠道</th>
				<th>产品</th>
				<th>代码</th>
				<th>是否弹框</th>
				<th>loading</th>	
				<!-- <th>13</th> -->
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">
							<tr onclick="getSublist(${v.id })">
								<td>${v.cp_name }</td>
								<td>${v.product_name }</td>
								<td>${v.product_code }</td>
								<td>
									<c:if test="${v.sumPop eq null}">
										<font color="#666">无下级</font>
									</c:if>
									<c:if test="${v.sumPop eq 0}">
										<font color="green">全部开</font>
									</c:if>
									<c:if test="${v.sumPop eq v.countPop}">
										<font color="red">全部关</font>
									</c:if>
									<c:if test="${v.sumPop gt 0 && v.sumPop lt  v.countPop}">
										<font color="#7233ee">部分开</font>
									</c:if>
								
								</td>
								<td>
									<c:if test="${v.sumLoading eq null}">
										<font color="#666">无下级</font>
									</c:if>
									<c:if test="${v.sumLoading eq 0}">
										<font color="green">全部开</font>
									</c:if>
									<c:if test="${v.sumLoading eq v.countLoading}">
										<font color="red">全部关</font>
									</c:if>
									<c:if test="${v.sumLoading gt 0 && v.sumLoading lt  v.countLoading}">
										<font color="#7233ee">部分开</font>
									</c:if>
								
								</td>
								<%-- <td>
									<c:if test="${v.sumTht eq null}">
										<font color="#666">无下级</font>
									</c:if>
									<c:if test="${v.sumTht eq 0}">
										<font color="green">全部开</font>
									</c:if>
									<c:if test="${v.sumTht eq v.countTht}">
										<font color="red">全部关</font>
									</c:if>
									<c:if test="${v.sumTht gt 0 && v.sumTht lt  v.countTht}">
										<font color="#7233ee">部分开</font>
									</c:if>
								
								</td> --%>
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
				<span>渠道管控</span><a class="cancel"></a>
			</div>

			<form action="saveInsubsat.do" method="post">
			 
				<div class="tipinfo">
				<input  id="pageId"  name="pageId" value="" type="hidden" ></input>
					<table class="tablelist">
						<thead>
							<tr>
							<th>代码</th>
							<th>渠道</th>
							<th>产品</th>
							<th>是否弹框 &nbsp; <input type="checkbox"  class="titcheck" id="cbAllpop" name="isPoptitle" /></th>
							<th>loading &nbsp; <input type="checkbox" class="titcheck" id="cbAllload" name="isLoadingtitle" /></th>	
							<!-- <th>13&nbsp; <input type="checkbox" class="titcheck" id="cbAlltht" name="isThttitle" /></th> -->
							</tr>
						</thead>
						<tbody id="tbody">
						
						</tbody>
					</table>	
					
				</div>
				<div class="tipbtn">
					<label>&nbsp;</label><input id="subtn"  type="submit" onclick="botnDis();" class="btn" value="确认保存"/>&nbsp; <input
						name="" type="button" class="cancel" value="取消" />
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
