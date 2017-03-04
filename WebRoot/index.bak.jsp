<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
	<script type="text/javascript"  src="js/loading.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/artDialog/artDialog.source.js?skin=blue"></script>
<script type="text/javascript"
	src="js/artDialog/plugins/iframeTools.source.js"></script>
<script type="text/javascript" src="js/pop.js"></script>
	<script type="text/javascript">
		function updatePwd(){
			if(checkPw()){
			$(".loading").show();
			var d = $("#changePwdForm").serialize();
			$.post("updateUsePwd.do",d,function(result){
				
				var parsedJson = jQuery.parseJSON(result);
				pop_succeed("温馨提示", result.msg, function() {
					$(".loading").hide();
					if (result.errorCode == 0) {
						window.location ="doLogout.do";
					}
				}, false);
			});
			}
			return false;
		}
	</script>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.loading{display:none; width:100%; height:100%;z-index:100;filter:alpha(opacity=50);opacity:0.5; background:#bbb;position:absolute;text-align: center;}
	.updpw{display:none;}
	</style>
  </head>
  <body style="margin:0px;overflow:hidden;">
  	<div class="loading"><img src="images/loading.gif" style="padding-top:20%;"/><span>loading...</span></div>
   
   <div id="updpw" class="updpw">
  		<div class="formtitle"><span>修改密码</span><font style="color:red;margin-left:70px;">(*必填)</font></div>
	<form id="changePwdForm" action="updateUsePwd.do" class="form_body">
				
				<ul class="form_info">
						<li><label>原密码</label><input type="text" id="password" name="oldPwd" class="dfinput" style="width:260px"/> <i style="color:red;">*</i></li>
						<li><label>新密码</label><input type="text" id="pw" name="newPwd" class="dfinput" style="width:260px"/> <i style="color:red;">*</i></li>
						<li><label>确认密码</label><input type="text" id="qpw" name="qpw" class="dfinput" style="width:260px"/> <i style="color:red;">*</i></li>
						<li><label>&nbsp;</label><input name="" type="button"
							class="btn" onclick="updatePwd()" value="提交" /></li>

					</ul>
		
			</form>
  	</div>
  	
    <iframe id="myFrame" name="myFrame" src="welcome.html" frameborder="0" style="width:100%;height:100%;"></iframe>
  </body>
</html>
