<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>sdk计费平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<script src="js/login/cufon-yui.js" type="text/javascript"></script>
<script src="js/login/ChunkFive_400.font.js" type="text/javascript"></script>
<script language="JavaScript" src="js/jquery.js"></script>
</head>
<body>
	<div class="wrapper">
		<div class="content">
			<div id="form_wrapper" class="form_wrapper">
				<form class="login active" action="doLogin.do" method="post">
					<h3>用户登录</h3>
					<div>
						<label>用户名:</label> <input type="text" name="account"/>
					</div>
					<div>
						<label>密码: </label> <input type="password" name="password"/>
					</div>
					<div class="bottom">
						<!-- <div class="remember">
							<input type="checkbox" /><span>Keep me logged in</span>
						</div> -->
						<input type="submit" value="登录"></input>
						<div class="clear"></div>
					</div>
				</form>
			</div>
			<div class="clear"></div>
		</div>
	</div>
<script type="text/javascript">
$(function() {
	
});
</script>
</body>
</html>