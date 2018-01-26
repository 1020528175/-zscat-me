// JavaScript Document
(function($){
	$.fn.scrollDiv = function(options){
		var defaults = {};
		var opts = $.extend({}, defaults, options),
			_this = $(this);
			
			
		var oBtnLeft = _this.find(".j-hdrbtn-up"),
			oBtnRight = _this.find(".j-hdrbtn-down"),
			oScrollWrap = _this.find(".nav_3_l"),
			oScrollCon = oScrollWrap.find(".nav_3_lbox"),
			oScrollList = oScrollCon.find("li"),
			len = oScrollList.length,
			index = 0,
			timer = null,
			delay = 3000;
		
		oScrollCon.width(oScrollList.outerHeight() * len);
		
		function setTimer(){
			timer = setInterval(function(){
				index += 1;
				
				if(index == len){
					index = 0;
				}
				fnScroll(index);
			},delay)
		}
		
		oBtnLeft.click(function(){
			
			
			index --;
			if(index < 0){
				index = len - 1;
			}
			fnScroll(index);
		});
		oBtnRight.click(function(){
			index ++;
			if(index == len){
				index = 0;
			}
			fnScroll(index);
		});
		
		_this.hover(function(){
			clearInterval(timer);
		},function(){
			setTimer();
		}).trigger("mouseleave");
		
		function fnScroll(index){
			var iNowLeft = -index * oScrollList.outerHeight();
			oScrollCon.stop(true, false).animate({"top" : iNowLeft}, 300);
		}
	}
})($);