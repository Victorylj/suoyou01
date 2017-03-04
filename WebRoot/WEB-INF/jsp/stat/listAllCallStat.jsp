<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="js/stat/listFeecodeStat.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=blue"></script>
<script type="text/javascript" src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript" src="js/pop.js"></script>
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/searchSelect.js"></script>
<script type="text/javascript" src="js/hideLoading.js"></script>
<script type="text/javascript" src="js/tableTitle.js"></script>
<script type="text/javascript">
$(document).ready(function() {
		$(".click1").click(function() {
			var str = $(this).text();
			if(str.indexOf("开启")>=0){
				str = "开启";
			}else{
				str = "关闭";
			}
			var length = $("input[type=checkbox][name=cp_id]:checked").length;
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
					$('#mvForm').submit();
				}
			);
		});
		
		$("#cpAll_id").click(function() {
             $('input[name=cp_id]').attr("checked",this.checked); 
        });
        $("input[type=checkbox][name=cp_id]").click(function(){
             $("#cpAll_id").attr("checked",$("input[type=checkbox][name=cp_id]").length == $("input[type=checkbox][name=cp_id]:checked").length ? true : false);
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
		$("#sp_select").searchInit({searchObj:"sp_select", searchText: "ch_name", searchId: "cp_id", searchUrl: "/seachChannelList.do"});
	});
	function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
		var params = $("#searcherForm").serialize();
		window.location = 'listAllCallStat.do?pageId='+nextPageId+'&'+params;
	}
	
	 function exportExcel(){
	 		var params = $("#searcherForm").serialize();
		window.location = 'exportCallStat.do?'+params;
	 }
	 
	 
	
	 
	 
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
				<a href="#">数据统计</a>
			</li>
			<li>
				<a href="#">访问量统计</a>
			</li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<form id="searcherForm" action="listAllCallStat.do" autocomplete="off" method="post" onsubmit="initshow()">
				<ul class="seachform">
					<li>
						<label>渠道</label>
						<div class="vocation" id="sp_select" style="height: 32px">

							<!-- 
						 <select id="cp_id" name="cp_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c1:forEach items="{chList}" var="ch">
                			 <option value="{ch.ch_id}" <c1:if test="{searchObj.cp_id eq ch.ch_id}">selected="selected"</c1:if> >{ch.ch_name}({ch.ch_id})</option>
                		    </c1:forEach>
                	   </select>
                	    -->
							<div class="select3">
								<input id="ch_name" name="ch_name" class="scinput" value="${searchObj.ch_name}" style="position: absolute; top: 2px; left: 2px; width: 73px; outline: none; border: 0px; z-index: 9;" />
								<div id="result" style="position: absolute; display: none; top: 33px; min-width: 98px; max-height: 200px; overflow: auto; z-index: 2;"></div>
								<input id="cp_id" name="cp_id" type="hidden" value="${searchObj.cp_id}" />
							</div>
						</div>
					</li>
					<!-- 
					<li><label>渠道名称</label><input name="cp_name1" type="text" value="{ searchObj.cp_name}"
						class="scinput" /></li>-->
					<li>
						<label>
							<input name="tag" type="radio" value="1" <c:if test="${searchObj.tag eq 1}">checked="checked" </c:if> />
							类别1
						</label>
						<label>
							<input name="tag" type="radio" value="2" <c:if test="${searchObj.tag eq 2}">checked="checked" </c:if> />
							类别2
						</label>
					</li>
					<li>
						<label>时间</label>
						<input name="start_time" type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" class="scinput" value="${searchObj.start_time }" />
						至
						<input name="end_time" type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" class="scinput" value="${searchObj.end_time }" />
					</li>
					<li>

						<label>
							<input name="protype" type="radio" value="1" <c:if test="${searchObj.protype eq 1}">checked="checked" </c:if> />
							全部
						</label>
						<label>
							<input name="protype" type="radio" value="2" <c:if test="${searchObj.protype eq 2}">checked="checked" </c:if> />
							SDK
						</label>
						<label>
							<input name="protype" type="radio" value="3" <c:if test="${searchObj.protype eq 3}">checked="checked" </c:if> />
							单机
						</label>

					</li>
					<li>
						<label>CCPID</label>
						<input name="ccp_id" type="text" value="${ searchObj.ccp_id}" class="scinput" />
					</li>
					<li>
						<label>&nbsp;</label>
						<input type="submit" class="scbtn" value="查询" />
					</li>
					<li>
						<label>&nbsp;</label>
						<input type="button" class="scbtn" value="导出" onclick="exportExcel()" />
					</li>

				</ul>
			</form>

		</div>
		<ul class="toolbar">
			<c:if test="${searchObj.tag==1}">
				<li class="click1">
					<span>
						<img src="images/t01.png" />
					</span>
					批量关闭
				</li>
				<!--<li class="click2"><span><img src="images/t01.png" /></span>添加关闭</li>-->
			</c:if>
			<c:if test="${searchObj.tag==2}">
				<li class="click1">
					<span>
						<img src="images/t01.png" />
					</span>
					批量开启
				</li>
				<!--<li class="click2"><span><img src="images/t01.png" /></span>添加开启</li>-->
			</c:if>
			<!--<li><span><img id="delBtn" src="images/t03.png" /></span>批量删除</li>-->
			<!-- input  type="submit" class="scbtn" 
						<c:if test="${searchObj.tag==1}">value="关闭"</c:if>
						<c:if test="${searchObj.tag==2}">value="启用"</c:if>/
						
						-->
		</ul>
		<div class="divtable" style="overflow-x: hidden;">
			<table class="tablelist">
				<thead>
					<tr>
						<th><input type="checkbox" id="cpAll_id" /></th>
						<th>日期</th>
						<th>产品</th>
						<th>渠道</th>
						<!--  <th>渠道编号</th>-->
						<th>推广产品id</th>
						<th>有效用户数</th>
						<th>下发协议次数</th>
						<th>下发协议用户数</th>
						<th>过滤用户数</th>
						<th>发送短信用户数</th>
						<th>总访问次数</th>
						<th>总访问用户数</th>
						<th>比值</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="divtable">
			<form id="mvForm" action="mvCallStat.do?tag=${searchObj.tag}" method="post" onsubmit="initshow()">
				<table class="tablelist" style="margin-top: -36px;">
					<thead>
						<tr>
							<th></th>
							<th>日期</th>
							<th>产品</th>
							<th>渠道</th>
							<!--  <th>渠道编号</th>-->
							<th>推广产品id</th>
							<th>有效用户数</th>
							<th>下发协议次数</th>
							<th>下发协议用户数</th>
							<th>过滤用户数</th>
							<th>发送短信用户数</th>
							<th>总访问次数</th>
							<th>总访问用户数</th>
							<th>比值</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty page}">
								<c:forEach items="${page.list}" var="v" varStatus="var">

									<tr>
										<td>
											<input type="checkbox" name="cp_id" value="${v.cp_id}&${v.ccp_id}" />
										</td>
										<td>${v.dater }</td>
										<td>${v.product_name }</td>
										<td>${v.cp_name }</td>
										<!--  <td>${v.cp_id }</td>-->
										<td>${v.ccp_id }</td>
										<td>${v.initnum }
											<c:if test="${v.nofeeinitnum>0}">
						(
						<font color="red">${v.nofeeinitnum }</font>
						)
						</c:if>
										</td>
										<td>${v.succ_calls }</td>
										<td>${v.succ_users }</td>
										<td>${v.smsNum }${v.remarks }</td>
										<td>${v.smsReportNum }</td>
										<td>${v.all_calls }</td>
										<td>${v.all_users }</td>
										<td>${v.rate }</td>
									</tr>

								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="9">没有搜索到符合条件的数据！</td>
								</tr>
							</c:otherwise>
						</c:choose>
						<tr>
							<td colspan="5">总计</td>
							<td>
								${allInitnum}
								<c:if test="${allNofeeInitnum>0}">
						(
						<font color="red">${allNofeeInitnum}</font>
						)
						</c:if>
							</td>
							<td>${allSuccCalls}</td>
							<td>${allSuccUsers}</td>
							<td>${allSmsNum}</td>
							<td>${allSmsReportNum}</td>
							<td>${allCalls}</td>
							<td>${allUsers}</td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>

		<div class="pagin">
			<div class="message">
				共<i class="blue">${page.total} </i>条记录，当前显示第&nbsp;<i class="blue">${page.pageNum}&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem">
					<a href="javascript:;" onclick="getPageId(${page.pages},${page.pageNum-1})">
						<span class="pagepre"></span>
					</a>
				</li>
				<li class="paginItem">
					<a href="javascript:;">${page.pageNum}</a>
				</li>
				<!--  	<li class="paginItem current"><a href="javascript:;">${page.pageNum+1}</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+2}</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+3}</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+4}</a></li>
				<li class="paginItem more"><a href="javascript:;">...</a></li>
				<li class="paginItem"><a href="javascript:;">${page.pageNum+6}</a></li>-->
				<li class="paginItem">
					<a href="javascript:;" onclick="getPageId(${page.pages},${page.pageNum+1})">
						<span class="pagenxt"></span>
					</a>
				</li>
			</ul>
		</div>
		<!--  
		<div class="editdiv">
			<div class="editdivtop">
				<span>提示信息</span><a></a>
			</div>
			<div class="form_body">
				<form action="mvCallStat.do?tag=${searchObj.tag}" method="post">
					<ul class="form_info">
						<li><label>渠道编号</label>
		
						<textarea name="cps"  cols="" rows="" class="textinput"></textarea>
							<i></i></li>
					
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="提交" /></li>

					</ul>
				</form>
			</div>
		</div> -->

		<div id="delDiv" class="tip">
			<div class="tiptop">
				<span>提示信息</span>
				<a></a>
			</div>

			<div class="tipinfo">
				<span>
					<img src="images/ticon.png" />
				</span>
				<div class="tipright">
					<p>是否确认删除信息 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />
				&nbsp;
				<input name="" type="button" class="cancel" value="取消" />
			</div>

		</div>
	</div>
	<div id="editStatus" style="display: none;">
		<div class="formtitle">
			<span>渠道状态修改</span>
		</div>
		<div class="form_body">
			<form action="mvCallStat.do?tag=${searchObj.tag}" method="post">
				<ul class="form_info">
					<li>
						<label>渠道编号</label>

						<textarea name="cps" cols="" rows="" class="textinput"></textarea>
						<i></i>
					</li>
					<li>
						<label>&nbsp;</label>
						<input name="" type="submit" class="btn" value="提交" />
					</li>

				</ul>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		$("#searchText").css("width","73px");
	</script>


</body>

</html>
