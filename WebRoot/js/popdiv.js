   
function doPopupDiv(div_id,pop_body){
	//alert(pop_body);
	$("#"+div_id).append($("#"+pop_body)); 
	$("#"+pop_body).show();
	popupDiv(div_id);
	
}

function popupDiv(div_id) {  
    var div_obj = $("#"+div_id); 
    var windowWidth = document.body.clientWidth;      
    var windowHeight = document.body.clientHeight; 
    var popupHeight = div_obj.height();      
    var popupWidth = div_obj.width();   
    //添加并显示遮罩层  
    $("<div id='mask'></div>").addClass("mask")  
                              .width(windowWidth + document.body.scrollWidth)  
                              .height(windowHeight + document.body.scrollHeight)  
                              .click(function() {hideDiv(div_id); })  
                              .appendTo("body")  
                              .fadeIn(200);  
    div_obj.css({"position": "absolute"})  
           .animate({left: windowWidth/2-popupWidth/2,   
                     top:100, opacity: "show" }, "slow");  
                   
}  
 
function hideDiv(div_id) {  
    $("#mask").remove();  
    $("#" + div_id).animate({left: 0, top: 0, opacity: "hide" }, "slow");  
} 