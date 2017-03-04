$(document).ready(function() {
		$(".click").click(function() {
			window.location ="editCpMakefeeLink.do";
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
		
		var params = $("#searcherForm").serialize();
		$("form").append("<input name='pageId' type='hidden' value='" + nextPageId + "'/>").submit();
		
	}
	
	function deleteCpFeemeasure(ids){
		art.dialog.confirm("确认删除该措施？", 
			function() {
				if (!ids || ids == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				var url = "deleteCpMakefeeLink.do";
				var data = {"arrayIds" : ids};
				$.post(url, data, function(result) {
				//	alert("dsfdsfda");
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location ="listCpMakefeeLink.do";
						}
					}, false);
				}, "json");
			}, 
			function() {}
		);
	}
	