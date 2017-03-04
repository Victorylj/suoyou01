<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title></title>
<style type="text/css">
body {
overflow: hidden;
}
</style>
</head>

<body>
    <div class="formbody">
    
    <div class="formtitle"><span>上游公司信息</span></div>
    <form action="addSpCompany.do" method="post">
    <ul class="forminfo">
    <li>
    <input name="sp_id" value="${paramObj.sp_id }" type="hidden" ></input>
    <label>上游公司名称</label><input name="sp_name" value="${paramObj.sp_name }" type="text" class="dfinput" />
    <i>标题不能超过30个字符</i></li>
    <li><label>上游公司地址</label><input name="sp_address"  value="${paramObj.sp_address }" type="text" class="dfinput" /><i></i></li>
    <li><label>对公对私</label><label style="width:400px;">
    
    <c:if test="${empty paramObj.sp_gsstatus or paramObj.sp_gsstatus eq 1}">
    	 <input name="sp_gsstatus" type="radio" checked="checked" value="1"/> 对公
		&nbsp;&nbsp;<input name="sp_gsstatus" type="radio" value="2"/> 对私
   	</c:if>
     <c:if test="${paramObj.sp_gsstatus eq 2}">
    <input name="sp_gsstatus" type="radio" value="1"/> 对公
		&nbsp;&nbsp;<input name="sp_gsstatus" type="radio" checked="checked" value="2"/> 对私
    </c:if>
    <i>（对公对私选择以后作用于转化率、SP收入统计）</i></label></li>
    <li><label>联系人</label><input name="sp_thecontact"  value="${paramObj.sp_thecontact }" type="text" class="dfinput" /><i></i></li>
    <li><label>联系电话</label><input name="sp_contactmobile"  value="${paramObj.sp_contactmobile }" type="text" class="dfinput" /><i></i></li>
    <li><label>联系QQ</label><input name="sp_contactqq"  value="${paramObj.sp_contactqq }" type="text" class="dfinput" /><i></i></li>
    <li><label>后台查询网址</label><input name="sp_selectaddress"  value="${paramObj.sp_selectaddress }" type="text" class="dfinput" /><i></i></li>
   
    
      <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>


</body>

</html>
