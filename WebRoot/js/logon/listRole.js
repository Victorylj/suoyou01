$(document).ready(function() {
		$(".click").click(function() {
			window.location ="editRole.do";
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
	
	function deleteRole(roleId){
		art.dialog.confirm("确认删除该角色？", 
			function() {
				if (!roleId || roleId == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				var url = "deleteRole.do";
				var data = {"arrayIds" : roleId};
				$.post(url, data, function(result) {
				//	alert("dsfdsfda");
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location ="listRole.do";
						}
					}, false);
				}, "json");
			}, 
			function() {}
		);
	}
	
	function chooseModules(moduleId,parentId){
		var obj = $("#module"+moduleId);
		if(obj.attr("checked")==true){
			$.ajax({
	            type:'post',
	            url: 'getChoosedModuleList.do',
	            data:{'module_id':moduleId,'parent_id':parentId},
	            dataType:'json',
	            success:function(result){
	            	$.each(result,function(n,val){
	            		var module_id= val.module_id;
	            		var checkObj = $("#module"+module_id);
	            		checkObj.attr("checked",true);
	            	
	                       	});
	            	
	            	
	            },
	            error:function(){
	                alert("failed.");
	            }
	        });
		}else{
			
		}
	}