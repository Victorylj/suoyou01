 			var timeoutObj;  
            var index = -1; //记录按上下键后得到的行数  
            var searchDefault;
            var searchText;
            var searchId;
            var searchUrl;
            var cascade;
            var result = "result";
            function searchInit(text,id,url,cascade,result){
            	searchText = "#"+text;
            	searchId = "#"+id;
            	searchUrl = url;
            	if(cascade){cascade = cascade;}
            	if(result){result = result;}
            }
            
            $(function()  
            {  
                var textObj = $(searchText);  
                //文本框按键后触发的事件  
                textObj.keydown(function(event){ 
                		event=event||window.event;  
                    if(event.keyCode==13) //enter  
                    {  
                      
                    }  
                    else if(event.keyCode==38)//up  
                    {  
                        //按上键后改变上一行的背景颜色  
                        changeColor(true);  
                    }  
                    else if(event.keyCode==40)//down  
                    {  
                        //按下键后改变下一行的背景颜色  
                        changeColor(false);  
                    }
                    searchDefault = textObj.val();
                    
                    
                });  
                //文本框按键松开后触发的事件  
                textObj.keyup(function(){  
                    //如果文本框被清空，隐藏显示的提示框  
                   // if(textObj.val().length==0)  
                   // {  
                    //    hideResult();  
                   // }
                	var textObj = $(searchText);
                	if(searchDefault!=textObj.val()){
	                    //如果timeoutObj已经存在，就清除，为了实现在文本框连续按键，在间隔时间较短只发一次请求，不用每输入一个文本就发一次清除  
	                    var url=window.document.location.pathname;
	                    url = url.substring(0,url.substr(1).indexOf('/')+1)+searchUrl;  
	                    $.post(url, {searchText: textObj.val()}, function(data, status){  
	                      	showResult(data);  
	                    });  
                	}
                });  
                //文本框被点击后触发的事件,调用getData, 传入参数0  
                //textObj.click(0, getData);  
                textObj.bind("click",0,getData);
                $("#sp_select").bind("click",0,getData);
                //textObj.change(500, getData);  
                //文本框的值被改变后触发的事件,调用getData,传入参数500,不知道为什么上一行代码不能起到相同的作用  
                //textObj.bind("input propertychange", 500, getData);  
                //文档被点击后，隐藏提示框  
                $(document).click(function(event){
                	event=event||window.event;
                	var obj = event.target;
                	var str = searchText.substr(1);
                	if(obj.id!=str&&obj.id!="divClick"){
                		hideResult(); 
                	}
                });  
            });  
            
           
            var isFirst = true; //标记是否选中的是文本框  
            var defaultValue; //文本框的输入值  
            var defaultId;
            function changeColor(isUpKey)  
            {  
                if(isFirst){ //第一次按上下键  
                    isFirst = false;  
                    defaultValue = $(searchText).val();
                    defaultId = $(searchId).val();
                }  
                //根据class获取提示框所有的行  
                var rows = $(".span");  
                var len = rows.length;  
                if(index>=0)  
                {  
                    //如果当前行大于等于0，就把当前行的背景颜色恢复  
                    rows[index].style.backgroundColor="#fff";  
                }  
                if(isUpKey)  
                {  
                    //按了上键后，如果当前选中的是文本框，移动后应该是最后一行  
                    //否则选择行往上移动一格，如果当前是第一行，移动后选中的是文本框  
                    index = index==-1 ? len-1 : index-1;  
                }  
                else  
                {  
                    //按了下键后，如果当前是最后一行，移动后应该到文本框，即index=-1，  
                    //否则选择行往下移动一格  
                    index = index==len-1 ? -1 : index+1;  
                }  
                if(index>=0)  
                {  
                    //移动后的选中行不是文本框，就将选中行背景颜色改变  
                    //并将文本框的值设置为当前行的值  
                    rows[index].style.backgroundColor="#b8ceda";  
                    $(searchText).val(rows[index].innerHTML);
                    $(searchId).val(rows[index].id);  
                }  
                else  
                {  
                    //移动后到文本框了，就将文本框的原来值恢复  
                    //并将选中文本框标记设置为true  
                    $(searchText).val(defaultValue);  
                    $(searchId).val(defaultId);  
                    isFirst = true;  
                }  
            }  
            function getData(event)  
            {
            	var textObj = $(searchText);  
                //如果timeoutObj已经存在，就清除，为了实现在文本框连续按键，在间隔时间较短只发一次请求，不用每输入一个文本就发一次清除  
                if(timeoutObj)  
                {  
                    clearTimeout(timeoutObj);  
                }
                if($("#"+result).html()==""){
                	event.data = 500;
                }
                timeoutObj = setTimeout(function(){  
                    //if(textObj.val().length>0)  
                    //{  
                        //获取数据，传入文本框的值作参数  
                    	var url=window.document.location.pathname;
                    	url = url.substring(0,url.substr(1).indexOf('/')+1)+searchUrl;  
                        $.post(url, {searchText: textObj.val()}, function(data, status){  
                        		showResult(data);  
                        });  
                    //}  
                }, event.data);//在event.data时间后执行请求，就是事件绑定函数时传入的参数，点击文本框立即加载，输入文本则在500毫秒后加载  
            }
            
            function showResult(jsonData)  
            {  
            	if(jsonData==""){
            		return;
            	}
                index = -1;//设置提示框选中值，即选中了文本框  
                var resultObj = $("#"+result);
                resultObj.html(jsonData);//清空提示框里面之前的内容  
                /*var rows = eval(jsonData);//获取json数据
                if(rows.length<=0)return;
                for(var i=0; i<rows.length; i++)  
                {  
                    var divObj = $("<div>");//创建提示框里一行数据  
                    divObj.addClass("span");//设置class，方便后面获取提示框里的行  
                    divObj.html(rows[i].name+rows[i].id).appendTo(resultObj);//将这一行添加到提示框里面  
                    divObj.hover(function(){//设置这一行的hover事件，即进入行改变背景颜色为#ccc，离开行改变背景颜色#fff  
                        this.style.backgroundColor="#ccc";  
                    }, function(){  
                        this.style.backgroundColor="#fff";  
                    });  
                    divObj.click(function(event){//设置这一行的click事件，将文本框的值设置当前行的值  
                        $(searchText).val(this.innerHTML);  
                    });  
                }
                */
                resultObj.find("div").mousemove(function(){
               	 	this.style.backgroundColor="#b8ceda";
                }).mouseout(function(){
                	this.style.backgroundColor="#fff";
                }).click(function(){
                	 $(searchText).val(this.innerHTML);
                	 $(searchId).val(this.id);
                	 if(cascade){
                		 cascade(this.id); 
                	 }
                });
                resultObj.css("border","1px solid #a7b5bc");
                resultObj.css("background-color","#fff");
                if(resultObj.css("display")=="none"){
                	resultObj.slideDown(300);//将提示框div显示出来    
                }
            }
            //隐藏提示框  
            function hideResult()  
            {  
                index=-1;  
                var resultObj = $("#"+result);  
                resultObj.slideUp(300);  
            }  