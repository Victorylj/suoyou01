$(document).ready(function() {
		$(".click").click(function() {
			//$(".editdiv").fadeIn(200);
			window.location ="editCpMakefeeItem.do";
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
		
		/*$("#sp_id").change(function(){
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
                    	var feecode_name=val.feecode_name;
                    	
                        $("#feecode_id").append($("<option/>").text(feecode_name).attr("value",feecode_id));
                	});
                	$("#feecode_id").val('');
                	
                },
                error:function(){
                    alert("failed.");
                }
            });
		});
		
		
		
		$("#feecode_id").change(function(){
			$("#command_id").empty();
			$("#command_id").append($("<option/>").text("请选择").attr("value",''));
			var feecode_id = $(this).val();
			$.ajax({
                type:'post',
                url: 'getSpCommandList.do',
                data:'feecode_id='+feecode_id,
                dataType:'json',
                success:function(result){
                	$.each(result,function(n,val){
                		var command_id= val.command_id;
                    	var command=val.command;
                    	
                        $("#command_id").append($("<option/>").text(command).attr("value",command_id));
                	});
                	$("#command_id").val('');
                	
                },
                error:function(){
                    alert("failed.");
                }
            });
		});*/
		
	});

	function getPageId(pageNum,nextPageId){
		if(nextPageId>pageNum){
			nextPageId=1;
		}
		if(nextPageId<1){
			nextPageId=pageNum;
		}
		var params = $("#searcherForm").serialize();
		//alert(params);
		$("form").append("<input name='pageId' type='hidden' value='" + nextPageId + "'/>").submit();
	}
	
	function closeOrOpenCpMakefeeItem(proid,ids,state){
		art.dialog.confirm("确认关闭改选项？", 
			function() {
				if (!ids || ids == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				var url = "closeOrOpenCpMakefeeItem.do";
				var data = {"open_province_id":proid,"arrayIds" : ids,"item_status":state};
				$.post(url, data, function(result) {
				//	alert("dsfdsfda");
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location ="listCpMakefeeItem.do";
						}
					}, false);
				}, "json");
			}, 
			function() {}
		);
	}
	