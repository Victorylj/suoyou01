$(function(){
	var toptitle = $(".divtable").eq(0);
	var content = $(".divtable").eq(1);
	var ths = toptitle.find("thead").find("th");
	var thead = content.find("tbody").find("tr").eq(0).find("td");
	var num = 0;
	content.find("table").css("margin-top","-36px");
	toptitle.find("table").width(content.find("table").width()); 
	content.height($(window).height()-$(".place").outerHeight()- $(".tools").outerHeight()-$(".toolbar").outerHeight()-$(".pagin").outerHeight()-99);
	if(content.height()<content[0].scrollHeight){
		toptitle.css("overflow-y","scroll");
		content.css("overflow-y","auto");
		//$(".divtable").eq(0).width($(".divtable").eq(0).width()-20);
	}
	for(var i=0;i<ths.length;i++){
		ths.eq(i).width(thead.eq(i).width()-7);
		num +=thead.eq(i).width();
	}
	toptitle[0].scrollLeft=content[0].scrollLeft;
	content.scroll( function(){
		toptitle[0].scrollLeft=content[0].scrollLeft;
	})
	$(window).resize(function(){
		var toptitle = $(".divtable").eq(0);
		var content = $(".divtable").eq(1);
		var ths = toptitle.find("thead").find("th");
		var thead = content.find("tbody").find("tr").eq(0).find("td");
		var num = 0;
		content.find("table").css("margin-top","-36px");
		toptitle.find("table").width(content.find("table").width());
		content.height($(window).height()-$(".place").outerHeight()- $(".tools").outerHeight()-$(".toolbar").outerHeight()-$(".pagin").outerHeight()-99);
		if(content.height()<content[0].scrollHeight){
			toptitle.css("overflow-y","scroll");
			content.css("overflow-y","auto");
			//$(".divtable").eq(0).width($(".divtable").eq(0).width()-20);
		}
		for(var i=0;i<ths.length;i++){
			ths.eq(i).width(thead.eq(i).width()-7);
			num +=thead.eq(i).width();
		}
		toptitle[0].scrollLeft=content[0].scrollLeft;
		content.scroll( function(){
			toptitle[0].scrollLeft=content[0].scrollLeft;
		})
	});
})