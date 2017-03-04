
function loading(){
		//var url=window.document.location.pathname;
		//url = url.substring(0,url.substr(1).indexOf('/')+1)+"/images/loading.gif";
		//var p = $('<div class="loading"><img src="'+url+'" style="padding-top:20%;"/><span>loading...</span></div>'); 
		//var first=document.body.firstChild;//得到页面的第一个元素 
		//document.body.insertBefore(p[0],first);
		$(".loading").show();
}
var status = "";
function gotourl(url){
	if(status!=url){
		status = url;
		loading();	
		//window.location.href=url;
		$("#myFrame")[0].src=url;
	}
}

function updpw(tit){
	art.dialog({
		 	content: document.getElementById('updpw'),
		title: tit,
		lock:true
	});
}
function hide(){
	$(".loading").hide();
	status = "";
	//$(".loading").slideUp(300);
	//$(".loading").remove();
}

function checkPw(){
	if ($("#password").val() == '') {
    	art.dialog({icon: 'warning',time: 1,lock:true,content: '请输入原密码!'});
        $("#password").focus();
        return false;
	}
	if ($("#pw").val() == '') {
    	art.dialog({icon: 'warning',time: 1,lock:true,content: '请输入新密码!'});
        $("#pw").focus();
        return false;
	}
	if ($("#qpw").val() == '') {
    	art.dialog({icon: 'warning',time: 1,lock:true,content: '请输入确认密码!'});
        $("#qpw").focus();
        return false;
	}
	if($("#pw").val()!=$("#qpw").val()){
		art.dialog({icon: 'warning',time: 1,lock:true,content: '新密码两次输入不一致!'});
        $("#pw").focus();
        return false;
	}
	return true;
}
