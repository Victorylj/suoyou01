$(document).ready(function() {
	$(".click").click(function() {
		art.dialog.load('editSpCompany.do', {title: '上游信息',lock:true}, false);
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

function getPageId(pageNum, nextPageId) {
	if (nextPageId > pageNum) {
		nextPageId = 1;
	}
	if (nextPageId < 1) {
		nextPageId = pageNum;
	}
	$("#searcherForm").append(
			"<input name='pageId' type='hidden' value='" + nextPageId + "'/>")
			.submit();

}

function selectAll() {
	var checkall = document.getElementById("chkall").checked;
	var allChecks = document.getElementsByName("chkbox");
	for (var i = 0; i < allChecks.length; i = i + 1) {
		// chkvalues[i].checked = icheck.checked;
		allChecks[i].checked = checkall;
	}
}

function multiDel() {
	var str = "";
	
	var url = "deleteSpCompany.do";
	
	var sel = document.getElementsByName("chkbox");// 获取checkbox的值
	for (var i = 0; i < sel.length; i++)
		if (sel[i].checked == true)
			str += sel[i].value + ",";
	if (str == "") {
		alert("请至少选择一条记录");
		return false;
	}
	if (window.confirm("确定删除"+sel.length+"条记录吗？")) {
		alert("批量删除"+sel.length+"项");
		//window.location = "multiDel?ids=str";// 后台删除处理
	
	}
}

function deleteSpCompany(spId) {
	art.dialog.confirm("确认删除该用户？", function() {
		if (!spId || spId == 0) {
			pop_warning("温馨提示", "请求参数有误", false);
			return;
		}
		var url = "deleteSpCompany.do";
		var data = {
			"arrayIds" : spId
		};
		$.post(url, data, function(result) {
			// alert("dsfdsfda");
			pop_succeed("温馨提示", result.msg, function() {
				if (result.errorCode == 0) {
					window.location = "listSpCompany.do";
				}
			}, false);
		}, "json");
	}, function() {
	});
}
