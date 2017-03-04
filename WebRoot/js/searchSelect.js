
            $(function(){
            	
            	$.fn.searchInit = function(opts){
            		 opts = $.extend({
            			 searchText: 'name',
            			 searchId: "id",
            			 searchUrl: "http://",
            			 searchObj:"div",
            			 cascade: null,
            			 result: "result",
            			 isFirst:true,
            			 defaultValue:"",  
                      	 defaultId:"",
                      	 searchDefault:"",
                      	 timeoutObj:null,
                      	 pid:"",
                      	 defaultStr:true,
                      	 inittime:220
            	      }, opts);
            		 
            		  var $srarch = $("#" + opts.searchText);

            		  $srarch.keydown(function(event){ 
                      	  event=event||window.event;
                          if(event.keyCode==13){  
                            
                          }  
                          else if(event.keyCode==38){  
                              //按上键后改变上一行的背景颜色  
                              changeColor(true, opts);  
                          }  
                          else if(event.keyCode==40){  
                              //按下键后改变下一行的背景颜色  
                              changeColor(false, opts);  
                          }
                          opts.searchDefault = $srarch.val();
                      },opts);  
                      //文本框按键松开后触发的事件  
            		  $srarch.keyup(function(event){  
            			event=event||window.event;
                      	var textObj = $(this);
                      	if(textObj.val()==""){
                      		$("#"+opts.searchId).val("");
                      	}
                      	if(opts.searchDefault!=textObj.val()){
      	                    //如果timeoutObj已经存在，就清除，为了实现在文本框连续按键，在间隔时间较短只发一次请求，不用每输入一个文本就发一次清除  
                      		
                      		if(opts.timeoutObj){  
         	                    clearTimeout(opts.timeoutObj);  
         	                }
                      		 opts.timeoutObj = setTimeout(function(){
	      	                    var url=window.document.location.pathname;
	      	                    url = url.substring(0,url.substr(1).indexOf('/')+1)+opts.searchUrl;
	      	                    if(opts.pid==""){
	      	                    	$.post(url, {searchText: textObj.val()=="--请选择--"?"":textObj.val()}, function(data, status){  
	          	                      	showResult(data,opts,true);  
	          	                    });  
	      	                    }else{
	      	                    	$.post(url, {searchText: textObj.val()=="--请选择--"?"":textObj.val(), pid:$("#"+opts.pid).val()}, function(data, status){  
	          	                      	showResult(data,opts,true);  
	          	                    });  
	      	                    }
                      		}, opts.inittime);
                      	}
                      	
                      },opts);  
            		  $srarch.focus(function(){
            			  if(!opts.defaultStr){return;}
            			  var textObj = $(this);
            			  if(textObj.val()=="--请选择--"){
            				  textObj.val("");
            			  }
            		  },opts);
            		  $srarch.blur(function(){
            			  if(!opts.defaultStr){return;}
            			  var textObj = $(this);
                          if(textObj.val()==""){
                        	  textObj.val("--请选择--");
                          }
            		  },opts);
            		  
                      //textObj.click(0, getData);  
            		  //$srarch.bind("click",opts,getData);
                      $("#"+opts.searchObj).bind("click",opts,getData);
                      //textObj.change(500, getData);  
                      //文本框的值被改变后触发的事件,调用getData,传入参数500,不知道为什么上一行代码不能起到相同的作用  
                      //textObj.bind("input propertychange", 500, getData);  
                      //文档被点击后，隐藏提示框  
                      $(document).click(function(event){
                      	event=event||window.event;
                      	var obj = event.target;
                      	var str = opts.searchText;
                      	if(obj.id!=str&&obj.id!="divClick"){
                      		hideResult(opts); 
                      	}
                      },opts); 
            	}     
            	
            	$.fn.initData = function(obj, obj1){
            		clean(obj1);
            		showResult(obj, obj1, false);
            	};
            	
            	function clean(opts){
            		$("#" + opts.searchText).val("");
            		$("#" + opts.searchId).val("");
            		$("#"+opts.result).html("");
            	}
            
	            function changeColor(isUpKey,opts){  
	                if(opts.isFirst){ //第一次按上下键  
	                	opts.isFirst = false;  
	                    opts.defaultValue = $("#" + opts.searchText).val();
	                    opts.defaultId = $("#" + opts.searchId).val();
	                }  
	                //根据class获取提示框所有的行  
	                var rows = $("#"+opts.result).find("div");  
	                var len = rows.length;  
	                if(index>=0){  
	                    rows[index].style.backgroundColor="#fff";  
	                }  
	                if(isUpKey){  
	                    index = index==-1 ? len-1 : index-1;  
	                }else{  
	                    index = index==len-1 ? -1 : index+1;  
	                }  
	                if(index>=0){
	                    rows[index].style.backgroundColor="#b8ceda";  
	                    $("#" + opts.searchText).val(rows[index].innerHTML);
	                    $("#" + opts.searchId).val(rows[index].id);  
	                }else{  
	                    //移动后到文本框了，就将文本框的原来值恢复  
	                    //并将选中文本框标记设置为true  
	                	$("#" + opts.searchText).val(opts.defaultValue);  
	                	$("#" + opts.searchId).val(opts.defaultId);  
	                	opts.isFirst = true;  
	                }  
	            }  
	            function getData(event){
	            	event=event||window.event;  
	            	var opts = event.data;
	            	var resultObj = $("#" + opts.result);
            		if(resultObj.css("display")!="none"){
            			 resultObj.slideUp(300);
            			 return;
            		}
	            	var gorlobj = event.target;
	            	var text = "";
	            	if(gorlobj.id==opts.searchText){
	            		text = $("#" + opts.searchText).val();
	            		if(text=="--请选择--"){
	            			text = "";
	            		}
	            	}
	                //如果timeoutObj已经存在，就清除，为了实现在文本框连续按键，在间隔时间较短只发一次请求，不用每输入一个文本就发一次清除  
	                if(opts.timeoutObj)  
	                {  
	                    clearTimeout(opts.timeoutObj);  
	                }
	                if($("#"+opts.result).html()==""){
	                	opts.inittime = 220;
	                }
	                opts.timeoutObj = setTimeout(function(){
	                    //if(textObj.val().length>0)  
	                    //{  
	                        //获取数据，传入文本框的值作参数  
	                    	var url=window.document.location.pathname;
	                    	url = url.substring(0,url.substr(1).indexOf('/')+1)+opts.searchUrl;  
	                    	if(opts.pid==""){
		                        $.post(url, {searchText: text}, function(data, status){  
		                        		showResult(data, opts, true);  
		                        });  
	                    	}else{
	                    		$.post(url, {searchText: text, pid:$("#"+opts.pid).val()}, function(data, status){  
          	                      	showResult(data,opts, true);  
          	                    }); 
	                    	}
	                    //}  
	                }, opts.inittime);//在event.data时间后执行请求，就是事件绑定函数时传入的参数，点击文本框立即加载，输入文本则在500毫秒后加载  
	            }
	            
	            function showResult(jsonData,opts,showHide){  
	            	if(jsonData==null||jsonData==""){
	            		return;
	            	}
	                index = -1;//设置提示框选中值，即选中了文本框  
	                var resultObj = $("#" + opts.result);
	                if((typeof jsonData=='string')&&jsonData.constructor==String){
		                 if(opts.defaultStr){
		                	 jsonData = "<div class='span' style='padding:5px;'>--请选择--</div>"+jsonData;
		                 }
	                	 resultObj.html(jsonData);
	                }else{
	                	var str="";
	                	$.each(jsonData,function(n,val){
	                		//str += "<div id='"+val.feecode_id+"' class='span' style='padding:5px;'>"+val.feecode_number+"</div>";
	                	});
	                	resultObj.html(str);
	              	}
	                
	                resultObj.find("div").mousemove(function(){
	                	 this.style.backgroundColor="#b8ceda";
	                }).mouseout(function(){
	                	this.style.backgroundColor="#fff";
	                }).click(function(){
	                	 $("#"+opts.searchText).val(this.innerHTML);
		            	 $("#"+opts.searchId).val(this.id);
		            	 if(opts.cascade){
		            		 opts.cascade(this);
		            	 }
	                },opts);
	                
	                resultObj.css("border","1px solid #a7b5bc");
	                resultObj.css("background-color","#fff");
	                if(showHide){
	                	if(resultObj.css("display")=="none"){
		                	resultObj.slideDown(300);//将提示框div显示出来    
	                		//resultObj.show();
		                }
	                }else{
	                	$("#"+opts.searchText).val(resultObj.find("div").eq(0).html());
	                	$("#"+opts.searchId).val(resultObj.find("div").eq(0).attr("id"));
	                }
	            }
	            //隐藏提示框  
	            function hideResult(opts)  
	            {  
	                index=-1;  
	                var resultObj = $("#"+opts.result);  
	                resultObj.slideUp(300);
	                //resultObj.hide();
	            }  
            });