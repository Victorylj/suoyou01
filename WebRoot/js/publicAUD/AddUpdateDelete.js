/**
 * @author fangyuansheng
 * @
 */
var str="";//全局变量，作用1：在添加中起着清除value值，也就是在点击修改之后，未进行修改，存储在的object
//修改(url:根据id进行查询的路劲；id:id,idname:需要弹框的id标签；title:弹框的名字)
function update(url,id,idname,title){
	 $.ajax({  
        type : "POST",  //提交方式  
        url : url,//路径  
        data : {  
            id:id
        },//数据，这里使用的是Json格式进行传输  
        success : function(data) {//返回数据根据结果进行相应的处理  
        	var u = JSON.parse(data);//json转string
            str=u;//赋值给全局变量
	        $.each(u, function(i) {
	        	var obj=u[i];//遍历出来的value值，i为key值
	        	if(document.getElementById( i )!=undefined){
	        		document.getElementById( i ).value=obj;
	        	}else{
	        		 
	        	}
	        });
            art.dialog({
	   		 	content: document.getElementById(idname),
	    		title: title,
	    		lock:true
			});  
        },
        error:function(data) {//返回数据根据结果进行相应的处理  
        	art.dialog({
	   		 	content: document.getElementById(idname),
	    		title: "返回数据失败，编辑失败",
	    		lock:true
			});
        } 
    }); 
};
//添加(idname:需要弹框的id标签；title:弹框的名字)在添加按钮哪里最好用onclick事件
function insert(idname,title) {
			 if(str!=""){
				 $.each(str, function(i) {
			        	if(document.getElementById( i )!=undefined){
			        		document.getElementById( i ).value="";
			        	}else{
			        		
			        	}
			        });
			 }
			 art.dialog({
				content: document.getElementById(idname),
	   		 	title: title,
	    		lock:true
			}); 
};
//删除(urll:根据id进行删除的路劲；id:id,locafind:删除后跳回的页面)
function deletee(urll,id,locafind){
		art.dialog.confirm("确认删除该选项？", 
			function() {
				if (!id || id == 0) {
					pop_warning("温馨提示", "请求参数有误", false);
					return;
				}
				var url = urll;
				var data = {"id" : id};
				$.post(url, data, function(result) {
					pop_succeed("温馨提示", result.msg, function() {
						if (result.errorCode == 0) {
							window.location =locafind;
						}
					}, false);
				}, "json");
			}
		);
	}