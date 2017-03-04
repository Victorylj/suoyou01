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

<script type="text/javascript" src="js/cpfeeplan/listCpFeemeasureItem.js"></script>
<script type="text/javascript"
	src="js/artDialog/artDialog.source.js?skin=glsx"></script>
<script type="text/javascript"
	src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript" src="js/pop.js"></script>
<script type="text/javascript"  src="js/hideLoading.js"></script>
<script type="text/javascript"  src="js/tableTitle.js"></script>
</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">扣费方案管理</a></li>
			<li><a href="#">扣费措施项</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="seachform">
				<form id="searcherForm" action="listCpFeemeasureItem.do" method="post" onsubmit="initshow()">
					<li><label>扣费方案</label>
						<div class="vocation">
					
						 <select id="feeplan_id" name="feeplan_id" class="select3">
                		   <option value="">请选择</option>
                	      	<c:forEach items="${feeplanList}" var="feeplan">
                			 <option value="${feeplan.feeplan_id}" <c:if test="${searchObj.feeplan_id eq feeplan.feeplan_id}">selected="selected"</c:if> >${feeplan.feeplan_name}</option>
                		    </c:forEach>
                	   </select>
                	   
					</div></li>

					<li><label>扣费措施</label><input name="feemeasure_item_name" type="text"
						class="scinput" /></li>
				<li><label>省份</label>
						<div class="vocation">
					
						 <select id="feemeasure_province" name="feemeasure_province" class="select3">
                		   <option value="">请选择</option>
                	      	<c:forEach items="${proList}" var="pro">
                			 <option value="${pro.province_id}" <c:if test="${searchObj.feemeasure_province eq pro.province_id}">selected="selected"</c:if> >${pro.province_name}</option>
                		    </c:forEach>
                	   </select>
                	   
					</div></li>
					<li><label>运营商</label>
						<div class="vocation">
					
						 <select id="feemeasure_op" name="feemeasure_op" class="select3">
                		   <option value="">请选择</option>
                	      	<option value="1" <c:if test="${searchObj.feemeasure_op ==1}">selected="selected"</c:if> >移动</option>
                	      	<option value="2" <c:if test="${searchObj.feemeasure_op ==2}">selected="selected"</c:if> >联通</option>
                	      	<option value="3" <c:if test="${searchObj.feemeasure_op ==3}">selected="selected"</c:if> >电信</option>
                	   </select>
                	   
					</div></li>
					<li><label>&nbsp;</label><input type="submit" class="scbtn"
						value="查询" /></li>
				</form>
			</ul>

		</div>
<ul class="toolbar">
				<li class="click"><span><img src="images/t01.png" /></span>添加</li>

				<li><span><img id="delBtn" src="images/t03.png" /></span>批量删除</li>

			</ul>
			
			<div class="divtable" style="overflow-x:hidden;">
		<table class="tablelist" >
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>扣费方案名称</th>
					<th>扣费措施名称</th>
					<th>运营商</th>
					<th>是否弹窗</th>
					<th>措施费用</th>
					<th>省分</th>
					<th>地市</th>
					<th>是否绑定计费项</th>
					<!--  <th>备注</th>-->
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
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>扣费方案名称</th>
					<th>扣费措施名称</th>
					<th>运营商</th>
					<th>是否弹窗</th>
					<th>措施费用</th>
					<th>省分</th>
					<th>地市</th>
					<th>是否绑定计费项</th>
					<!--  <th>备注</th>-->
					<th>更新时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty page.list}">
						<c:forEach items="${page.list}" var="v" varStatus="var">
							<c:if test="${not empty v.remarks }">
							<tr>
								<td><input type="checkbox" name="feemeasure_item_id" value="${ v.feemeasure_item_id}" /></td>
							
								<td>${v.feeplan_name }</td>
								<td>${v.feemeasure_name }</td>
								<td>
								 <c:if test="${v.feemeasure_op ==1 }">
								 	移动
								 </c:if>
								<c:if test="${v.feemeasure_op ==2 }">
								 	联通
								 </c:if>
								 <c:if test="${v.feemeasure_op ==3 }">
								 	电信
								 </c:if>
								</td>
								<td>
								 <c:if test="${v.feemeasure_is_pop ==1 }">
								 	是
								 </c:if>
								<c:if test="${v.feemeasure_is_pop ==0 }">
								 	否
								 </c:if>
								
								</td>
								<td>${v.feemeasure_fee }</td>
								<td>${v.feemeasure_province_name }</td>
								<td>${v.feemeasure_city_name }</td>
								<!-- 
								<td>
									绑定id-${v.cp_item_id }-
									 <c:if test="${v.item_status eq 1 }">
								 	<font color="red">关闭</font>
								 </c:if>
								<c:if test="${v.item_status eq 0 }">
								 	<font color="grean">启用</font>
								 </c:if>
								</td> -->
								<td>${v.remarks }</td>
								<td>${v.update_time }</td>
								<td><a href="linkMakefeeItem.do?feemeasure_name=${v.feemeasure_name }&feemeasure_id=${v.feemeasure_id }&feemeasure_item_id=${v.feemeasure_item_id }&feemeasure_province=${v.feemeasure_province }&feemeasure_op=${v.feemeasure_op }&ref_items=${v.ref_items}" class="tablelink">分省绑定计费项</a> 
							<!--  	<a href="linkMakefeeItem.do?feemeasure_name=${v.feemeasure_name }&feemeasure_id=${v.feemeasure_id }&feemeasure_op=${v.feemeasure_op }" class="tablelink">绑定计费项</a> -->
								<!--  
								<a href="editCpFeemeasureItem.do?feemeasure_item_id=${v.feemeasure_item_id }" class="tablelink">修改</a>
									<a href="javascript:void()"
									onclick="deleteCpFeemeasureItem(${ v.feemeasure_id})" class="tablelink">
										删除</a> --> </td>
							</tr>
						</c:if>
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
