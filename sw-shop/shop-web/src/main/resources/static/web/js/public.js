/* JS Document */

//top隐藏层
$(function(){
	$(".top_hb").mouseover(function(){
		$(this).addClass("hbhover"); 	
		$(this).find("ul").css("display","block");	
	});
	$(".top_hb").mouseout(function(){
		$(this).removeClass("hbhover"); 	
		$(this).find("ul").css("display","none");	
	});
	$(".top_xx").mouseover(function(){
		$(this).addClass("xxhover"); 	
		$(this).find("ul").css("display","block");	
	});
	$(".top_xx").mouseout(function(){
		$(this).removeClass("xxhover"); 	
		$(this).find("ul").css("display","none");	
	});
	$(".dp_nav_1").hover(function(){
		$(".dp_nav_all").css("display","block");		
	},function(){
		$(".dp_nav_all").css("display","none");
	});
	$(".top_xx_pay").mouseover(function(){
		$(this).addClass("hover"); 	
		$(this).find("ul").css("display","block");	
	});
	$(".top_xx_pay").mouseout(function(){
		$(this).removeClass("hover"); 	
		$(this).find("ul").css("display","none");	
	});
})

$(function(){
	$(".sy_imggb").click(function(){
		$("#sy_img1").css("display","none");	
	});
})
$(function(){
	$("#tsjxly").click(function(){
		$(".hb_tsck_ly").css("display","block");	
	});
})

//弹出层
function showtelts(cover,id){
	
	var Sys = {};
	var ua = navigator.userAgent.toLowerCase();
	var s;      
	(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : 
	(s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;	
	
	//如果是ie6，隐藏页面select
	if(Sys.ie=="6.0"){
		var n=document.getElementsByTagName("select").length;
		var m=document.getElementById(id).getElementsByTagName("select").length;
		for(var i=0;i<n;i++){
			document.getElementsByTagName("select")[i].style.display= 'none';
		}
		for(var j=0;j<m;j++){			
			document.getElementById(id).getElementsByTagName("select")[j].style.display= '';
		}
	}	
	
	
	var objCover=document.getElementById(cover);
	var objId=document.getElementById(id);
	var scrollW=document.documentElement.scrollWidth;
	var scrollH=document.documentElement.scrollHeight;
	if (Sys.safari) {
		var T=(document.documentElement.clientHeight-objId.clientHeight)/2+document.body.scrollTop;
	}else{
		var T=(document.documentElement.clientHeight-objId.clientHeight)/2+document.documentElement.scrollTop;	
	}
	var L=(document.documentElement.clientWidth-objId.clientWidth)/2+document.documentElement.scrollLeft;
	
	
	objCover.style.width=scrollW+"px";
	objCover.style.height=scrollH+"px";
	objCover.style.visibility="visible";
	
	objId.style.top=T+"px";
	objId.style.left=L+"px";
	objId.style.visibility="visible";
	
}
function hidetelts(cover,id){
	//将页面全部select换件设为可用状态
	var Sys = {};
	var ua = navigator.userAgent.toLowerCase();
	var s;    
	(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : 
	(s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;	
	if(Sys.ie=="6.0"){
		var n=document.getElementsByTagName("select").length;
		for(var i=0;i<n;i++){
			document.getElementsByTagName("select")[i].style.display= '';
		}
	}
	var objCover=document.getElementById(cover);
	var objId=document.getElementById(id);
	objCover.style.visibility="hidden";
	objId.style.visibility="hidden";
}
//nav隐藏层
$(function(){
	$(".nav_all_li").mouseover(function(){
		$(this).addClass("hover"); 	
	});
	$(".nav_all_li").mouseout(function(){
		$(this).removeClass("hover"); 	
	});
})
$(function(){
	$(".dp_nav_all_li").mouseover(function(){
		$(this).addClass("hover"); 	
	});
	$(".dp_nav_all_li").mouseout(function(){
		$(this).removeClass("hover"); 	
	});
})

//搜索联想隐藏层
$(function(){
    var timer = null;
	$(".head_ss").click(function(){
		$(".head_sslx").css("display","block");
        clearTimeout(timer);
	});
	$(".head_sslx").click(function(){
		$(".head_sslx").css("display","none");
	});
    $('.head_ss').hover(function(){
        if($(this).is(':focus')){
            clearTimeout(timer);
            $(".head_sslx").show();
        }
    }, function(){
        timer = setTimeout(function(){
            $(".head_sslx").hide();
        }, 300);
    });
    $('.head_sslx').hover(function(){
        clearTimeout(timer);
        $(".head_sslx").show();
    }, function(){
        timer = setTimeout(function(){
            $(".head_sslx").hide();
        }, 300);
    });
})
$(function(){
	$(".head_sslx li").mouseover(function(){
		$(this).addClass("bffdfc6"); 	
	});
	$(".head_sslx li").mouseout(function(){
		$(this).removeClass("bffdfc6"); 	
	});
})

//选项卡用js
function nTabs(thisObj,Num,active,normal){
	if(thisObj.className == active)return;
	var tabObj = thisObj.parentNode.id;
	var tabList = document.getElementById(tabObj).getElementsByTagName("li");
	for(i=0; i <tabList.length; i++)
	{
		if (i == Num)
		{
		   thisObj.className = active;
		   document.getElementById(tabObj+"_Content"+i).style.display = "block";
		}else{
		   tabList[i].className = normal;
		   document.getElementById(tabObj+"_Content"+i).style.display = "none";
		}
	}
}
//选项卡用js3
function snTabs(thisObj,Num,active,normal){
	if(thisObj.className == active)return;
	var tabObj = thisObj.parentNode.id;
	var tabList = document.getElementById(tabObj).getElementsByTagName("li");
	for(i=0; i <tabList.length; i++)
	{
		if (i == Num)
		{
		   thisObj.className = active;
		   document.getElementById(tabObj+"_Content"+i).style.display = "block";
		}else{
		   tabList[i].className = normal;
		   document.getElementById(tabObj+"_Content"+i).style.display = "none";
		}
	}
}
//选项卡用js2
function setTab(name,cursel,n){
 for(i=1;i<=n;i++){
  var menu=document.getElementById(name+i);
  var con=document.getElementById("con_"+name+"_"+i);
  menu.className=i==cursel?"hover":"";
  con.style.display=i==cursel?"block":"none";
 }
}

//nav隐藏层
//$(function(){
//	$(".sy_jbtjbox li").mouseover(function(){
//		$(this).addClass("jbhover"); 	
//	});
//	$(".sy_jbtjbox li").mouseout(function(){
//		$(this).removeClass("jbhover"); 	
//	});
//})

//首页排行榜选中
$(function(){
	$(".sy_top_r li").mouseover(function(){
		$(this).addClass("sthover"); 	
	});
	$(".sy_top_r li").mouseout(function(){
		$(this).removeClass("sthover"); 	
	});
})

//头部我的和包和去购物车结算
$(function(){
	$(".head_wdhb").mouseover(function(){
		$(this).addClass("myhbhover"); 	
	});
	$(".head_wdhb").mouseout(function(){
		$(this).removeClass("myhbhover"); 	
	});
	$(".head_qgwcjs").mouseover(function(){
		$(this).addClass("gwcjshover"); 	
	});
	$(".head_qgwcjs").mouseout(function(){
		$(this).removeClass("gwcjshover"); 	
	});
})

//首页后台JS
$(function(){
	$("#sy_ht .sy_htsz").mouseover(function(){
		$(this).addClass("sy_sfbj");
	});
	$("#sy_ht .sy_htsz").mouseout(function(){
		$(this).removeClass("sy_sfbj");
	});
})
//店铺首页后台JS
$(function(){
	$("#dpsy_ht .sy_htsz").mouseover(function(){
		$(this).addClass("dpsy_sfbj");
	});
	$("#dpsy_ht .sy_htsz").mouseout(function(){
		$(this).removeClass("dpsy_sfbj");
	});
})

//主导航JS显示隐藏
$(function(){
	$("#nav_1").mouseover(function(){
		$("#nav_all").css("display","block");
	});
	$("#nav_1").mouseout(function(){
		$("#nav_all").css("display","none");
	});
})
$(function(){
	$("#nav_1").mouseover(function(){
		$(this).addClass("navhover1");
	});
	$("#nav_1").mouseout(function(){
		$(this).removeClass("navhover1");
	});
})

//滑动门
function setTabdp(name,cursel,n){
 for(var i=1;i<=n;i++){
  var menu=document.getElementById(name+i);
  var con=document.getElementById("con_"+name+"_"+i);
  if(menu!=null){
	  menu.className=i==cursel?"hover":"";
  }
  if(con!=null){
	  con.style.display=i==cursel?"block":"none";
  }
 }
}

/*
* 详情页面——为你推荐切换
*/
$(function(){
    var index = 0;
    var len = $('.xq_wntj_nr li').length;
    $('.xq_wntj_nr').height(len * $('.xq_wntj_nr li').outerHeight(true));
    $('.slide_down').click(function(){
        index ++;
        if(index > 0){
            index = 0;
        }
        slide(index);
    });
    $('.slide_up').click(function(){
        index --;
        if(index < -len + 2){
            index = -len + 2;
        }
        slide(index);
    });
    function slide(index){
        $('.xq_wntj_nr').stop(true, false).animate({'top': index * $('.xq_wntj_nr li').outerHeight(true)});
    }
	});
	$(function(){
    var index = 0;
    var len = $('.tg_wntj_nr li').length;
    $('.tg_wntj_nr').height(len * $('.tg_wntj_nr li').outerHeight(true));
    $('.slide_down').click(function(){
        index ++;
        if(index > 0){
            index = 0;
        }
        slide(index);
    });
    $('.slide_up').click(function(){
        index --;
        if(index < -len + 2){
            index = -len + 2;
        }
        slide(index);
    });
    function slide(index){
        $('.tg_wntj_nr').stop(true, false).animate({'top': index * $('.tg_wntj_nr li').outerHeight(true)});
    }
});


$(function(){
	$(".db_cont").mouseover(function(){
		$(this).addClass("hover"); 	
	});
	$(".db_cont").mouseout(function(){
		$(this).removeClass("hover"); 	
	});
})


//对比页面隐藏显示
$(function(){
	$("#db_zt").toggle(
	  function () {
		$(this).addClass("dbhover");
		$("#db_ztnr").hide();
	  },
	  function () {
		$(this).removeClass("dbhover");
		$("#db_ztnr").show();
	  }
	);
	$("#db_wl").toggle(
	  function () {
		$(this).addClass("dbhover");
		$("#db_wlnr").hide();
	  },
	  function () {
		$(this).removeClass("dbhover");
		$("#db_wlnr").show();
	  }
	);
	$("#db_xs").toggle(
	  function () {
		$(this).addClass("dbhover");
		$("#db_xsnr").hide();
	  },
	  function () {
		$(this).removeClass("dbhover");
		$("#db_xsnr").show();
	  }
	);
	$("#db_cc").toggle(
	  function () {
		$(this).addClass("dbhover");
		$("#db_ccnr").hide();
	  },
	  function () {
		$(this).removeClass("dbhover");
		$("#db_ccnr").show();
	  }
	);
	$("#db_ylgn").toggle(
	  function () {
		$(this).addClass("dbhover");
		$("#db_ylgnnr").hide();
	  },
	  function () {
		$(this).removeClass("dbhover");
		$("#db_ylgnnr").show();
	  }
	);
})

//列表页下拉框
$(function(){
	var liTimer = null;
    $(".lb_qtxx").hover(function(){
        if($(this).hasClass('qthover')){
            //alert('fdsa')
            clearTimeout(liTimer);
        }
    }, function(){
        //clearTimeout(litimer);
        liTimer = setTimeout(function(){
            $(".lb_qtxx").removeClass("qthover");
            $(".lb_qtxx").find("s").hide();
            $(".lb_qtxx").find(".lb_qtyc").hide();
        }, 400);
    });
    $('.lb_qtyc1 li a').click(function(){
        $(".lb_qtxx").removeClass("qthover");
        $(".lb_qtxx").find("s").hide();
        $(".lb_qtxx").find(".lb_qtyc").hide();
    });
	$(".lb_qtxx p").click(
	  function () {
          if($(this).parent().hasClass('qthover')){
              $(this).parent().removeClass("qthover");
              $(this).parent().find("s").hide();
              $(this).parent().find(".lb_qtyc").hide();
          }else{
              $(".lb_qtxx").removeClass("qthover");
              $(".lb_qtxx s").hide();
              $(".lb_qtxx .lb_qtyc").hide();
              $(this).parent().addClass("qthover");
              $(this).parent().find("s").show();
              $(this).parent().find(".lb_qtyc").show();
          }
	  }
	);
    $('.lb_qtyc2_b img').click(function(){
        $('.lb_qtyc2').hide();
        $('.lb_qtxx').removeClass('qthover').find('s').hide();
        $('.lb_qtxx .lb_qtyc1').show();
        $('.lb_qtyc').hide();
        return false;
    });
	$(".lb_ss_duox").click(
	  function () {
		$(".lb_qtyc1").css("display","none");
		$(".lb_qtyc2").css("display","block");
	  }
	);
	$(".lb_ss_danx").click(
	  function () {
		$(".lb_qtyc1").css("display","block");
		$(".lb_qtyc2").css("display","none");
	  }
	);
})

$(function(){
	$(".lb_ss_duox2").click(
	  function () {
		$("#lb_ss_danx2").css("display","none");
		$("#lb_ss_duox2").css("display","block");
	  }
	);
	$(".lb_ss_danx2").click(
	  function () {
		$("#lb_ss_danx2").css("display","block");
		$("#lb_ss_duox2").css("display","none");
	  }
	);
})
//列表也对比栏
$(function(){
	$(".lb_icon_db").click(
	  function () {
		$(".lb_fddb").show();
	  }
	);
	$(".lb_fddb_tit a").click(
	  function () {
		$(".lb_fddb").hide();
	  }
	);
})

//列表也对比栏
$(function(){
	$(".lb_icon_db").click(
	  function () {
          if($.browser.msie && $.browser.version == '6.0'){
              $(".lb_fddb").show().css({'position': 'absolute', 'left': $('.box').offset().left, 'bottom': 0});
          }else{
              $(".lb_fddb").show().css({'position': 'fixed', 'left': $('.box').offset().left, 'bottom': 0});
          }
	  }
	);
    $(window).scroll(function(){
        if($.browser.msie && $.browser.version == '6.0'){
            //alert($(window).scrollTop() + $(window).height() - $(".lb_fddb").height());
            $(".lb_fddb").css('top', $(window).scrollTop() + $(window).height() - $(".lb_fddb").height());
        }
    });
	$(".lb_fddb_tit a").click(
	  function () {
		$(".lb_fddb").hide();
	  }
	);
})

$(function(){
	$("#lb_ppxz_duox").click(function(){
		$("#lb_ppxz_1").hide();
		$("#lb_ppxz_2").hide();
		$("#lb_ppxz_3").show();
	});
	$("#lb_ppxz_duox1").click(function(){
		$("#lb_ppxz_1").hide();
		$("#lb_ppxz_2").hide();
		$("#lb_ppxz_3").show();
	});
	$("#lb_ppxz_gd").click(function(){
		$("#lb_ppxz_1").hide();
		$("#lb_ppxz_2").show();
		$("#lb_ppxz_3").hide();
	});
	$("#lb_ppxz_sq").click(function(){
		$("#lb_ppxz_1").show();
		$("#lb_ppxz_2").hide();
		$("#lb_ppxz_3").hide();
	});
	$("#lb_ppxz_danx").click(function(){
		$("#lb_ppxz_1").hide();
		$("#lb_ppxz_2").show();
		$("#lb_ppxz_3").hide();
	});
	
	  $('.pay_ddxx').click(function(){
		$('.pay_ddxx').removeClass('pay_moren');
		$(".pay_ddxx .pay_mrdz").hide();
        $(this).addClass('pay_moren');
		$(".pay_moren .pay_mrdz").show();
	});
})

//top购物车隐藏显示
$(function(){
	$(".top_gwc").mouseover(function(){
		$(".zxkf_hover").css("display","block");
		$(".top_gwc").css("background","#fff");
	});
	$(".top_gwc").mouseout(function(){
		$(".zxkf_hover").css("display","none");
		$(".top_gwc").css("background","none");
	});
})

$(function(){
	$(".hb_navbox_r_1").mouseover(function(){
		$(".hb_navbox_r_1 li").css("display","block");
	});
	$(".hb_navbox_r_1").mouseout(function(){
		$(".hb_navbox_r_1 li").css("display","none");
	});
})
//我的和包左导航
$(function(){
	$(".hb_l_nav dt").toggle(
	  function () {
		$(this).addClass("hbnavon");
		$(this).parent().find("dd").hide();
	  },
	  function () {
		$(this).removeClass("hbnavon");
		$(this).parent().find("dd").show();
	}
);
//add xk ddjs
$("#xgdd").click(function(){
		$(".pay_ddjs_step1").addClass("step-current"); 	
		$("#xgdd").css("display","none"); 	
		$(".sbox").css("display","block");
		$("#bcshrxx").css("display","inline-block");
		$(".sbox-wrap").css("display","none");
		
			});
$("#bcshrxx").click(function(){
		$(".pay_ddjs_step1").removeClass("step-current"); 	
		$("#xgdd").show(); 	
		$(".sbox").hide();
		$("#bcshrxx").hide();
		$(".sbox-wrap").show();
		
			});
$("#newddd").click(function(){
		$(".pay_newadd").css("display","block"); 
		});
	$('.ddjs_address').mouseover(function(){
		$('.ddjs_address').removeClass('item-selected');
        $(this).addClass('item-selected');
		$(".item-selected .item-action").show();
	});
	$(".ddjs_address").mouseout(function(){
		$(".item-selected .item-action").hide();
		$(this).find("ul").css("display","none");	
	});
})

//我的和包页面模拟下拉单
$(function(){
	$(".nb_r_xld_r").click(function(){
		$('.nb_r_xld').addClass('xlclick');
	});
	$(".nb_r_xldycgb").click(function(){
		$('.nb_r_xld').removeClass('xlclick');
	});
	$(".nb_r_xldyc li a").click(function(){
		$('.nb_r_xld').removeClass('xlclick');
	});

	$(".hb_nav_zhsz_wz").mouseover(function(){
		$(this).addClass("tophover"); 	
		$(this).find("ul").css("display","block");	
	});
	$(".hb_nav_zhsz_wz").mouseout(function(){
		$(this).removeClass("tophover"); 	
		$(this).find("ul").css("display","none");	
	});
	$(".hb_nav_xx_wz").mouseover(function(){
		$(this).addClass("tophover"); 	
		$(this).find("ul").css("display","block");	
	});
	$(".hb_nav_xx_wz").mouseout(function(){
		$(this).removeClass("tophover"); 	
		$(this).find("ul").css("display","none");	
	});
	})
	
//首页热销排行榜
$(function(){
	$(".rxph_nr li").mouseover(function(){
		$(this).addClass("rxhover").siblings().removeClass("rxhover"); 	
	});
})

//详情后台JS
$(function(){
	$(".xq_ht").mouseover(function(){
		$(this).addClass("xq_wqxg");
	});
	$(".xq_ht").mouseout(function(){
		$(this).removeClass("xq_wqxg");
	});
})
//详情后台JS
$(function(){
	$(".nav_sjxd").mouseover(function(){
		$(this).find(".nav_sjxd_ycc").show();
	});
	$(".nav_sjxd").mouseout(function(){
		$(this).find(".nav_sjxd_ycc").hide();
	});
})

//列表页搜索条件更多隐藏
$(function(){
	$(".lx_ssmore1").click(function(){
		$(".lx_ssmore1").hide();
		$(".lx_ssmore2").show();
		$(".lx_ss_gd").show();
	});
	$(".lx_ssmore2").click(function(){
		$(".lx_ssmore1").show();
		$(".lx_ssmore2").hide();
		$(".lx_ss_gd").hide();
	});
})