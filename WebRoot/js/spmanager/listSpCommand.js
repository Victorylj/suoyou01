$(document).ready(function() {
		$(".click").click(function() {
			//$(".editdiv").fadeIn(200);
			window.location ="editSpCommand.do";
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
		
		

		$("#sp_id").change(function(){
			$("#feecode_id").empty();
				$("#feecode_id").append($("<option/>").text("请选择").attr("value",''));
				var sp_id = $(this).val();
				$.ajax({
	                type:'post',
	                url: 'getSpFeecodeList.do',
	                data:'sp_id='+sp_id,
	                dataType:'json',
	                success:function(result){
	                	$.each(result,function(n,val){
	                		var feecode_id= val.feecode_id;
	                    	var feecode_number=val.feecode_number;
	                    	var feecode_op=val.feecode_op;
	                    	var feecode_name=val.feecode_name;
	                        $("#feecode_id").append($("<option/>").text(feecode_number+"-"+feecode_op+"-"+feecode_name).attr("value",feecode_id));
	                	});
	                	//$("#selectP").val('');
	                	
	                },
	                error:function(){
	                    alert("failed.");
	                }
	            });
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
	
	function closeOrOpenSpCommand(ids,stat){
		art.dialog.confirm("是否注销该指令，注销后将关闭关联计费项，请更新计费措施组合？", 
			function() {
				if (!ids || ids == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				var url = "closeOrOpenSpCommand.do";
				var data = {"arrayIds" : ids,"command_status":stat};
				$.post(url, data, function(result) {
				//	alert("dsfdsfda");
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location ="listSpCommand.do";
						}
					}, false);
				}, "json");
			}, 
			function() {}
		);
	}
	
	
	function updspcps(ids,stat){
		var s = stat==1?"所有":"正向";
		art.dialog.confirm("是否更改"+s+"状态？", 
			function() {
				if (!ids || ids == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				var url = "updspcps.do";
				var data = {"arrayIds" : ids,"positive_statu":stat};
				$.post(url, data, function(result) {
				//	alert("dsfdsfda");
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location ="listSpCommand.do";
						}
					}, false);
				}, "json");
			}, 
			function() {}
		);
	}