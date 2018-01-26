// JavaScript Document

/*说明：
以下是插件默认值，都为空	
$.fn.adfocus.defaults = {
  drection:"",   //控制方向，分为向上滚，向左滚 ,和渐变效果，填left为左滚动，填up向上滚动，filter为渐变效果，当pull为true的时候，pull_right为右，pull_left为左，pull_top为上，pull_bottom为下。
  numbox:"",   //轮换数字的层的class名或者ID名 要加" . "或者" # "
  imgbox:"",  //轮换图的层，放入图片的层，填class名或者id名 要加" . "或者" # "
  text:"",//文字层
  speed:"" , //速度控制
  addClass: "" //轮换数字层里的li标签class样式替换,切忌此处不要加上 " . ",直接填class名
  imgboxWidth:"" //轮换的宽度设置 输入时请去掉引号
  imgboxHeight:""//轮换的高度的设置 输入时请去掉引号
  imgLen:""//图片数量设置 输入时请去掉引号
  pull:""//拉动效果启动开关，若不是拉动效果，请不要填任何参数。
  usevent:""//事件选择...click   mouseover  mouseenter 点击和鼠标滑动事件
  插件版本: 1.0.4
  修改了查询方式..避免结构不同而插件不能使用的问题。
  增加了文字层。
  修改了拉动效果，对拉动效果改成另一种模式...
  插件版本: 1.0.4
  增加了事件选择usevent, 可以选择点击事件触发和鼠标滑动触发
  修改了鼠标滑动事件的时候由于鼠标过快滑动滤镜效果会有延迟，停顿的问题..
  对拉动pull效果做了修改，但是好存在一点问题，太快的点击和滑动，会使得图片显示慢或者停顿...
  
  以往更新：
  插件版本: 1.0.3
  由于近期项目的进行，需要更多的焦点图效果，于是我在网上看到一些效果蛮不错的，变自己写了下，然后又对拉动效果进行延伸，一共增加了4个效果！
  经过技术总监的提醒，把前几个版本的轮换宽度和高度的改为自定义变量，技术人员可以根据自己设定轮换高度和宽度。
  增加了图片数量的设置，提高维护性。
  优化了下代码
  
  注意事项：当鼠标来回滑过速度太快的时候，会存在图片不切换！原因是因为动画效果没有停止造成！
  插件可能存在未知的缺陷，请各位见谅！欢迎大家一起讨论！
  版权所有*******
  作者：颓废小魔
  QQ: 305009858    谢绝不良访问！
  
};*/
$.fn.adfocus = function (options) {
     var opts={
	drection: "",
     //控制方向，分为向上滚，向左滚 ,和渐变效果，填left为左滚动，填up向上滚动，filter为渐变效果，当pull为true的时候，pull_right为右，pull_left为左，pull_top为上，pull_bottom为下。
    numbox: "",
    //轮换数字的层的class名或者ID名 要加" . "或者" # "
    imgbox: "",
    //轮换图的层，放入图片的层，填class名或者id名 要加" . "或者" # "
	text:"",
	//文字层
    speed: "",
    //速度控制
    addClass: "", 
	//轮换数字层里的li标签class样式替换,切忌此处不要加上 " . ",直接填class名
	imgboxWidth:"",
	//宽度
	imgboxHeight:"",
	//高度
	imgLen:"",
	//图片数量
	pull:"",
	//拉动效果开启变量
	usevent:""
		 }
    $.extend(opts, options);
    return this.each(function () {

        var adTimer = null;
		var _this = $(this);
		var index = 0; 
		var oNumList =_this.find(opts.numbox).children();
		var txList =_this.find(opts.text).children();
		var len = opts.imgLen;
		var imgListBox = _this.find(opts.imgbox);
		var imglistWidth =  opts.imgboxWidth;
		var imglistHeight = opts.imgboxHeight;
		var imglistBoxChid=imgListBox.children();
		timer();
		if(opts.pull=="true"){
			imglistBoxChid.not("script").css({
										   "position":"absolute",
											"z-index":1}).first().css({"z-index":2})

			}
          oNumList.bind(opts.usevent,function(){
									index = oNumList.index(this);
                                      action(index);
											   }).eq(0).trigger("mouseleave");

       _this.hover(function () {
            clearInterval(adTimer);
        }, function () {timer();
           
        })
        //以下是控制滑动的方法
	  function timer(){
		 adTimer = setInterval(function () {
                action(index)
                index++;
                if (index == len) {
                    index = 0;
                }
            }, opts.speed)
	  }
        function action(index) {
			//alert(1);
            if (opts.drection == "left") {         //像左移动
			   imgListBox.width(imglistWidth*len);
                imglistBoxChid.css({
                    float: "left"
                });
                imgListBox.stop().animate({
                    left: -imglistWidth * index
                }, 1000);
            } else if(opts.drection == "up") {             //像上移动  
			 // alert(1);
                imgListBox.stop().animate({
                    top: -imglistHeight * index
                }, 1000);
            }else if(opts.drection == "filter"){   //渐变效果 
			     _this.css({"position":"relative"})
				imglistBoxChid.eq(index).css({"position":"absolute",
										   "left":"0px",
										   "top":"0px" }).stop()
				                   .animate({opacity:1},500)
								   .css({"z-index": "1"})
								   .siblings().stop().animate({opacity:0},500)
								   .css({"z-index": "0"});
			}else if(opts.pull=="true"){
				var pull_drection = {}
				var pull_drection2 = {}
			    if(opts.drection == "pull_right"){
					key="left";
					pull_drection[key]="0";
					pull_drection2[key]=-opts.imgboxWidth;
					pull(pull_drection,pull_drection2);
					}
				else if(opts.drection == "pull_left"){
					key="left";
					pull_drection[key]="0";
					pull_drection2[key]= opts.imgboxWidth;
					pull(pull_drection,pull_drection2);
					}
			   else if(opts.drection == "pull_top"){
					key="top";
					pull_drection[key]="0";
					pull_drection2[key]=-opts.imgboxHeight;
					pull(pull_drection,pull_drection2);
					}
			   else if(opts.drection == "pull_bottom"){
					key="top";
					pull_drection[key]="0";
					pull_drection2[key]=opts.imgboxHeight;
					pull(pull_drection,pull_drection2);
					}
				
				
				}

			txList.eq(index).stop().animate({"top":0},500).siblings().stop().animate({"top":-30},0);//文字
            oNumList.removeClass(opts.addClass).eq(index).addClass(opts.addClass);
			function pull(pull_drection,pull_drection2){
						imglistBoxChid.not("script").eq(index)
					                            .css({ "z-index": 3 })
												.siblings().css({ "z-index": 1 });	
						imgListBox.children().not("script").eq(index).stop()
					                                   .animate( pull_drection,500)
													   .siblings().stop().animate(pull_drection2,500).css({"z-index": 1})
						
					}//pull()
        }
		
		
		
    });
};

