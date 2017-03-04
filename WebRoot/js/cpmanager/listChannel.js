$(document).ready(function() {
		$(".click").click(function() {
			window.location ="editChannel.do";
		});

		$(".editdivtop a").click(function() {
			$(".editdiv").fadeOut(200);
		});

		
		$("#delBtn").click(function() {
			$("#delDiv").fadeIn(200);
		}); 
		
		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});
	});

	function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
		$("form").append("<input name='pageId' type='hidden' value='" + nextPageId + "'/>").submit();
	}
	
	function deleteChannel(hpId){
		art.dialog.confirm("确认删除该黑名单？", 
			function() {
				if (!hpId || hpId == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				var url = "deleteChannel.do";
				var data = {"arrayIds" : spId};
				$.post(url, data, function(result) {
				//	alert("dsfdsfda");
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location ="listChannel.do";
						}
					}, false);
				}, "json");
			}, 
			function() {}
		);
	}
	