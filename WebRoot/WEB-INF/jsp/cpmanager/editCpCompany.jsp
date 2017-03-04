<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>产品公司</span></div>
    <form action="addCpCompany.do" method="post">
    <ul class="forminfo">
    <li>
    <input name="cp_id" value="${paramObj.cp_id }" type="hidden" ></input>
    <label>产品公司</label><input name="cp_name" value="${paramObj.cp_name }" type="text" class="dfinput" />
    <i>产品公司或者负责人</i>
    </li>
    <li><label>同步地址</label><input name="mr_url"  value="${paramObj.mr_url }" type="text" class="dfinput" /><i></i></li>
     
    <!--  
    <li><label>渠道地址</label><input name="cp_address"  value="${paramObj.cp_address }" type="text" class="dfinput" /><i></i></li>
    <li><label>渠道IP</label><input name="cp_ip"  value="${paramObj.cp_ip }" type="text" class="dfinput" /><i></i></li>
    
    <li><label>上行地址</label><input name="mo_url"  value="${paramObj.mo_url }" type="text" class="dfinput" /><i></i></li>
     <li><label>下行地址</label><input name="mr_url"  value="${paramObj.mr_url }" type="text" class="dfinput" /><i></i></li>
     
        <li><label>公钥</label><input name="public_key"  value="${paramObj.public_key }" type="text" class="dfinput" /><i></i></li>
     <li><label>私钥</label><input name="private_key"  value="${paramObj.private_key }" type="text" class="dfinput" /><i></i></li>
        <li><label>用户名</label><input name="cp_account"  value="${paramObj.cp_account }" type="text" class="dfinput" /><i></i></li>
     <li><label>密码</label><input name="cp_passwd"  value="${paramObj.cp_passwd }" type="text" class="dfinput" /><i></i></li>
        <li><label>支付账户</label><input name="cp_pay_account"  value="${paramObj.cp_pay_account }" type="text" class="dfinput" /><i></i></li>
     <li><label>扣水</label><input name="cp_cut"  value="${paramObj.cp_cut }" type="text" class="dfinput" /><i></i></li>
     -->
     
    <li><label>备注</label><input name="remarks"  value="${paramObj.remarks }" type="text" class="dfinput" /><i></i></li>
    
    
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
