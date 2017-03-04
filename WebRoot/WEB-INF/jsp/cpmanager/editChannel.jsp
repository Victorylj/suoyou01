<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".select3").uedSelect({
			width : 100
		});
	});
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
				<a href="#">表单</a>
			</li>
		</ul>
	</div>

	<div class="formbody">
		<div class="formtitle">
			<span>渠道信息</span>
		</div>
		<form action="addChannel.do" method="post">
			<ul class="forminfo">
				<li>
					<label>渠道负责人</label>
					<label>
						<select id="" name="m_id" class="select3">
							<option value="">请选择</option>
							<c:forEach items="${mList}" var="m">
								<option value="${m.m_id}" <c:if test="${paramObj.m_id==m.m_id }"> selected='selected'</c:if>>${m.m_name}</option>
							</c:forEach>
						</select>
					</label>
				</li>
				<li>
					<input name="ch_id" value="${paramObj.ch_id }" type="hidden"></input>
					<label>渠道</label>
					<input name="ch_name" value="${paramObj.ch_name }" type="text" class="dfinput" />
					<i>标题不能超过30个字符</i>
				</li>
				<li>
					<label>渠道地址</label>
					<input name="ch_address" value="${paramObj.ch_address }" type="text" class="dfinput" />
					<i></i>
				</li>
				<li>
					<label>渠道IP</label>
					<input name="ch_ip" value="${paramObj.ch_ip }" type="text" class="dfinput" />
					<i></i>
				</li>
				<li>
					<label>上行地址</label>
					<input name="mo_url" value="${paramObj.mo_url }" type="text" class="dfinput" />
					<i></i>
				</li>
				<li>
					<label>下行地址</label>
					<input name="mr_url" value="${paramObj.mr_url }" type="text" class="dfinput" />
					<i></i>
				</li>

				<li>
					<label>公钥</label>
					<input name="public_key" value="${paramObj.public_key }" type="text" class="dfinput" />
					<i></i>
				</li>
				<li>
					<label>私钥</label>
					<input name="private_key" value="${paramObj.private_key }" type="text" class="dfinput" />
					<i></i>
				</li>
				<li>
					<label>用户名</label>
					<input name="ch_account" value="${paramObj.ch_account }" type="text" class="dfinput" />
					<i></i>
				</li>
				<li>
					<label>密码</label>
					<input name="ch_passwd" value="${paramObj.ch_passwd }" type="text" class="dfinput" />
					<i></i>
				</li>
				<li>
					<label>支付账户</label>
					<input name="ch_pay_account" value="${paramObj.ch_pay_account }" type="text" class="dfinput" />
					<i></i>
				</li>
				<li>
					<label>扣水</label>
					<input name="ch_cut" value="${paramObj.ch_cut }" type="text" class="dfinput" />
					<i></i>
				</li>
				<li>
					<label>显示数据方式</label>
					<label>
						<select name="show_type" class="select3">
							<c:if test="${empty paramObj.show_type  }">
								<option value="1" selected="selected">cpa</option>
								<option value="2">cps</option>
								<option value="3">cpa+cps</option>
							</c:if>
							<c:if test="${paramObj.show_type == 1 }">
								<option value="1" selected="selected">cpa</option>
								<option value="2">cps</option>
								<option value="3">cpa+cps</option>
							</c:if>
							<c:if test="${paramObj.show_type == 2 }">
								<option value="1">cpa</option>
								<option value="2" selected="selected">cps</option>
								<option value="3">cpa+cps</option>
							</c:if>
							<c:if test="${paramObj.show_type == 3 }">
								<option value="1">cpa</option>
								<option value="2">cps</option>
								<option value="3" selected="selected">cpa+cps</option>
							</c:if>
						</select>
					</label>
					<i></i>
				</li>

				<li>
					<label>备注</label>
					<input name="remarks" value="${paramObj.remarks }" type="text" class="dfinput" />
					<i></i>
				</li>


				<li>
					<label>&nbsp;</label>
					<input type="submit" class="btn" value="确认保存" />
				</li>
			</ul>
		</form>
	</div>


</body>

</html>
