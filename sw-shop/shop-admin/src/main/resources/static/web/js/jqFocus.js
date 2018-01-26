/*
插件描述：本插件适用于网站上常用的首页焦点图。
使用方法：1、页面引入jqFocus.js脚本。
		  
		  2、焦点图作用对象调用jqFocus()这个方法。
		  <script type="text/javascript">
			  $(function(){
				  $("#focuswrap").jqFocus({
					  focusContainer : ".focus",
					  focusContainer : ".focus",
					  focusUl : ".focus ul",
					  focusUlLi : ".focus ul li",
					  preBtn : ".focus .btnPre",
					  nextBtn : ".focus .btnNext",
					  focusSmallBtnBg : ".focus .btnBg"
				  });
			  })
		  </script>
author：nothing
website：jqlover.com
*/
(function($){
	$.fn.jqFocus = function(options){
		var defaults = {};
		var opts = $.extend({},defaults,options),
			index = 0,
			focusContainer = $(opts.focusContainer),
			focusUl = $(opts.focusUl),
			focusUlLi = $(opts.focusUlLi),
			focusSmallBtnBg = $(opts.focusSmallBtnBg)
			len = focusUlLi.length,
			preBtn = $(opts.preBtn),
			nextBtn = $(opts.nextBtn),
			_this = $(this),
			focusActive = opts.focusActive,
			focusWidth = $(opts.focusContainer).width(),
			focusUlWidth = len * parseInt(focusWidth);
			
		var focusSmallBtnSpan = ""
		for (var i = 0 ; i<len ; i++){
			focusSmallBtnSpan += "<span></span>"
		};
		focusSmallBtnBg.append(focusSmallBtnSpan);
		var focusSmallBtn = focusSmallBtnBg.find("span");
		focusSmallBtn.eq(0).addClass(focusActive);
		focusSmallBtn.mouseover(function(){
			index = $(this).index();
			picShow(index);
		});
		//自动播放
		focusContainer.hover(function(){
			clearInterval(picTimer);
		},function(){
			picTimer = setInterval(function(){
				index ++;
				if(index == len){index = 0}
				picShow(index);
			},3000)
		}).trigger("mouseleave")
		//单击下一个按钮
		nextBtn.click(function(){
			index += 1;
			if(index == len){index = 0};
			picShow(index);
		});
		//单击上一个按钮
		preBtn.click(function(){
			index -= 1;
			if(index == -1){index = len -1};
			picShow(index);
		});
		focusUl.width(focusUlWidth);
		//滚动函数
		function picShow(index){
			//计算当前left值
			var nowLeft = -index * focusWidth;
			focusUl.stop(true,false).animate({"left":nowLeft},654);
			focusSmallBtnBg.find("span").removeClass(focusActive);
			focusSmallBtnBg.find("span").eq(index).addClass(focusActive);
		};
	};
})(jQuery)