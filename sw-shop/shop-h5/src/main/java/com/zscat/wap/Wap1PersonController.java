package com.zscat.wap;



import com.alibaba.dubbo.config.annotation.Reference;
import com.zsCat.common.common.utils.CookieUtil;
import com.zsCat.common.common.utils.PageUtils;
import com.zsCat.common.common.utils.Query;
import com.zsCat.common.common.utils.R;
import com.zsCat.common.lucene.IndexObject;
import com.zsCat.common.utils.DateUtils;
import com.zscat.config.MemberUtils;
import com.zscat.config.ShiroUtils;
import com.zscat.shop.Constan;
import com.zscat.shop.domain.*;
import com.zscat.shop.domain.TGoodsDO;
import com.zscat.shop.domain.TMemberDO;
import com.zscat.shop.service.ArticleService;
import com.zscat.shop.service.*;
import com.zscat.util.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
	 * 
	 * @author zsCat 2016-10-31 14:01:30
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	商品管理
	 */
@Controller
@RequestMapping("/wap/person")
public class Wap1PersonController {
	@Reference(version = "1.0.0")
	private ArticleService articleService;
	@Reference(version = "1.0.0")
	private TBrandService tBrandService;
	@Reference(version = "1.0.0")
	private TGoodsTypeService tGoodsTypeService;
	@Reference(version = "1.0.0")
	private TGoodsService tGoodsService;
	@Reference(version = "1.0.0")
	private TGoodsClassService tGoodsClassService;
	@Reference(version = "1.0.0")
	private TStoreService tStoreService;
	@Reference(version = "1.0.0")
	private BannerService bannerService;
	@Reference(version = "1.0.0")
	private CouponService couponService;
	@Reference(version = "1.0.0")
	private TopicService topicService;
	@Reference(version = "1.0.0")
	private TCartService tCartService;
	@Reference(version = "1.0.0")
	private TReplyService tReplyService;
	@Reference(version = "1.0.0")
	private TMemberService tMemberService;

	@Reference(version = "1.0.0")
	private AddressService addressService;
	@Reference(version = "1.0.0")
	private FavoriteService favoriteService;
	@Reference(version = "1.0.0")
	private TOrderService orderService;
	@Reference(version = "1.0.0")
	private TGoodSorderService tGoodSorderService;
	@Reference(version = "1.0.0")
	private JifendataService jifendataService;
	@Reference(version = "1.0.0")
	private TMemberService userService;
	@Reference(version = "1.0.0")
	private JifengoodsService jifengoodsService;
	@Reference(version = "1.0.0")
	private UserJfgoodsService userJfgoodsService;
	@RequestMapping("")
	  public ModelAndView index() {
	        try {
	            ModelAndView model = new ModelAndView("/wap/user.html");

	            return model;
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("导航失败!");
	        }
	    }
	 //个人资料
	 @RequestMapping("/profile")
	  public ModelAndView profile() {
		  ModelAndView model = new ModelAndView("/wap/profile.html");
          TMemberDO member= MemberUtils.getSessionLoginUser();
          model.addObject("member", member);
		  return model;
	 }
	 
	 
	 @RequestMapping("/change_name")
	  public ModelAndView change_name() {
		  ModelAndView model = new ModelAndView("/wap/change_name.html");
		 TMemberDO member= MemberUtils.getSessionLoginUser();
         model.addObject("member", member);
		  return model;
	 }
	 @RequestMapping("/change_tel")
	  public ModelAndView change_tel() {
		  ModelAndView model = new ModelAndView("/wap/change_tel.html");
		 TMemberDO member=MemberUtils.getSessionLoginUser();
         model.addObject("member", member);
		  return model;
	 }
	 @RequestMapping("/change_pwd")
	  public ModelAndView change_pwd() {
		  ModelAndView model = new ModelAndView("/wap/change_tel.html");
       
		  return model;
	 }
	@RequestMapping("/favorite")
	public ModelAndView favorite() {
		ModelAndView model = new ModelAndView("/wap/favorite.html");

		return model;
	}
	 /**
		 * 修改密码
		* @return
		 */
		@RequestMapping(value = "updateUser1", method = RequestMethod.POST)
		public ModelAndView updateUser1(@ModelAttribute TMemberDO Member, HttpServletRequest request){
			 ModelAndView model = new ModelAndView("/wap/profile.html");
			 userService.update(Member);
			 return model;
		}
		/**
		 * 保存用户
		* @return
		 */
		@RequestMapping(value = "updateUser", method = RequestMethod.POST)
		public ModelAndView updateUser(@ModelAttribute TMemberDO Member, HttpServletRequest request){
			 ModelAndView model = new ModelAndView("/wap/profile.html");
			 userService.update(Member);
			 return model;
		}
	 // 自定义比较器：按销售情况排序  
	    static class SellHitComparator implements Comparator {  
	        public int compare(Object object1, Object object2) {// 实现接口中的方法  
	        	TGoodsDO p1 = (TGoodsDO) object1; // 强制转换
				TGoodsDO p2 = (TGoodsDO) object2;
	            return p2.getSellhit().compareTo(p1.getSellhit());  
	        }  
	    }  
	  
	    // 自定义比较器：按书出版时间来排序  
	    static class CalendarComparator implements Comparator {  
	        public int compare(Object object1, Object object2) {// 实现接口中的方法  
				TGoodsDO p1 = (TGoodsDO) object1; // 强制转换
				TGoodsDO p2 = (TGoodsDO) object2;
	            return p2.getCreateDate().compareTo(p1.getCreateDate());  
	        }  
	    }  
	 /**
	  * 个人信息
	  * @return
	  */
	 @RequestMapping("/information")
	  public ModelAndView information() {
		 ModelAndView model = new ModelAndView("/wap/information.html");
		 TMemberDO member=MemberUtils.getSessionLoginUser();
         model.addObject("member", member);
		 
         
		 
		 return model;
	 }
	  /**
	  * 安全管理
	  * @return
	  */
	 @RequestMapping("/safety")
	  public ModelAndView safety() {
		 ModelAndView model = new ModelAndView("/wap/safety.html");
		 
		 
		 return model;
	 }
	 /**
	     * 根据父类ID 获取到 下级城市
	     *
	     * @param @param  parentid
	     * @param @return
	     * @param @throws JsonGenerationException
	     * @param @throws JsonMappingException
	     * @param @throws Exception    设定文件
	     * @return Map<String,String>    返回类型
	     * @throws
	     * @Title: getChildArea
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     */
	   
	
	 
	 /**
	  * 订单管理
	  * @return
	  */
	 @RequestMapping("/order")
	  public ModelAndView order() {
		 ModelAndView model = new ModelAndView("/wap/likBuy.html");
		
		 return model;
	 }
		@RequestMapping("/ajax/order")
		public String orderList(HttpServletRequest request) {
				try {
					String id = request.getParameter("order");
					if (id != null && !id.equals("")) {
						Map<String, Object> params = new HashMap<>();
						params.put("userid",MemberUtils.getSessionLoginUser().getId());
						params.put("status",Integer.parseInt(id));
						List<TOrderDO> orderList=orderService.list(params);
					//	request.setAttribute("imgServer", "http://image.zscat.com");
						request.setAttribute("orderList", orderList);
					}
				} catch (Exception e) {

				}
				return "wap/ajax-likBuy.html";
	}
		
	 /**
	  * 退款管理
	  * @return
	  */
	 @RequestMapping("/change")
	  public ModelAndView change() {
		 ModelAndView model = new ModelAndView("/wap/change");
		 
		 
		 return model;
	 }
	
	 /**
	  * 我的积分
	  * @return
	  */
	 @RequestMapping("/points")
	  public ModelAndView points() {
		 ModelAndView model = new ModelAndView("/wap/points");
		 
		 
		 return model;
	 }
	 
	 /**
	  * 优惠劵
	  * @return
	  */
	 @RequestMapping("/coupon")
	  public ModelAndView coupon() {
		 ModelAndView model = new ModelAndView("/wap/coupon");
		 
		 
		 return model;
	 }
	 /**
	  * 红包
	  * @return
	  */
	 @RequestMapping("/bonus")
	  public ModelAndView bonus() {
		 ModelAndView model = new ModelAndView("/wap/bonus");
		 
		 
		 return model;
	 }
	 /**
	  * 账户余额
	  * @return
	  */
	 @RequestMapping("/walletlist")
	  public ModelAndView walletlist() {
		 ModelAndView model = new ModelAndView("/wap/walletlist");
		 
		 
		 return model;
	 }
	 /**
	  * 账单明细
	  * @return
	  */
	 @RequestMapping("/bill")
	  public ModelAndView bill() {
		 ModelAndView model = new ModelAndView("/wap/bill");
		 
		 
		 return model;
	 }
	 
	 /**
	  * 足迹
	  * @return
	  */
	 @RequestMapping("/foot")
	  public ModelAndView foot(HttpServletRequest req) {
		 ModelAndView model = new ModelAndView("/wap/foot.html");
		
//		    RedisUtils  RedisUtils=new RedisUtils();
//			Map<String,String> map=RedisUtils.hgetall(MemberUtils.SHOPPING_HISTORY+ip);
//			List<Object> TGoodsList=JsonUtils.readJsonList(JsonUtils.toJsonStr(map), TGoods.class);
//			model.addObject("TGoodsList",TGoodsList);
		 return model;
	 }
	 /**
	  * 商品咨询
	  * @return
	  */
	 @RequestMapping("/consultation")
	  public ModelAndView consultation() {
		 ModelAndView model = new ModelAndView("/wap/consultation");
		 
		 
		 return model;
	 }
	 /**
	  * 意见反馈
	  * @return
	  */
	 @RequestMapping("/suggest")
	  public ModelAndView suggest() {
		 ModelAndView model = new ModelAndView("/wap/suggest");
		 
		 
		 return model;
	 }
	 /**
	  * 我的消息
	  * @return
	  */
	 @RequestMapping("/news")
	  public ModelAndView news() {
		 ModelAndView model = new ModelAndView("/wap/news");
		 
		 
		 return model;
	 }
	/**
	 * 购物车
	 * @return
	 */
	 @RequestMapping("/cartList")
	  public ModelAndView cartList() {
		 ModelAndView model = new ModelAndView("/wap/cartList.html");
		 if(MemberUtils.getSessionLoginUser()!=null){
			 model.addObject("cartList", tCartService.selectOwnCart(MemberUtils.getSessionLoginUser().getId()));
		 }
		 model.addObject("cartList", new ArrayList<>());
		 return model;
	 }
	 /**
	  * 立即购买
	  * @param
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/LikBuy/{TGoodsId}")
		public ModelAndView TGoodsDetail(@PathVariable("TGoodsId") Long TGoodsId,
                                         HttpSession session)throws Exception{
			ModelAndView mav=new ModelAndView();
		 Map<String, Object> params = new HashMap<>();
		  params.put("userid",MemberUtils.getSessionLoginUser().getId());
			List<TCartDO> cartList=tCartService.list(params);
			mav.addObject("cartList", cartList);
			
			
		 mav.addObject("goods", tGoodsService.get(TGoodsId) );
			mav.setViewName("wap/LikBuy.html");
			return mav;
		}
	 /**
	  * 提交订单
	  * @param
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("submitOrder")
		public ModelAndView submitOrder(@RequestParam(value = "productId") Long productId,
                                        @RequestParam(value = "addressid") Long addressid,
                                        @RequestParam(value = "paymentid") Long paymentid,
                                        @RequestParam(value = "paymentid",defaultValue="无留言") String usercontent
				)throws Exception{
			ModelAndView mav=new ModelAndView();
			TMemberDO m =MemberUtils.getSessionLoginUser();
			TOrderDO order=orderService.insertWapOrder(productId,addressid,paymentid,usercontent,m.getId(),m.getUsername());
			
			 if(order==null){
				 mav.setViewName("wap/forwad.html");
			 }else{
				 mav.setViewName("wap/success.html");
			 }
			
			mav.addObject("order", order);
			return mav;
		}
	 
	 
	 /**
	  * 查看已买到的宝贝
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/selledTGoods/{id}")
		public ModelAndView selledTGoods(@PathVariable("id") Long id)throws Exception{
			ModelAndView mav=new ModelAndView();
			TGoodsDO b=tGoodsService.get(id);
			mav.addObject("TGoods", b);
			mav.setViewName("wap/likBuy.html");
			return mav;
		}
	 /**
	  *交易详情
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/orderDetail/{id}")
		public ModelAndView orderDetail(@PathVariable("id") Long id)throws Exception{
			ModelAndView mav=new ModelAndView();
		 TGoodsDO b=tGoodsService.get(id);
			mav.addObject("TGoods", b);
			mav.setViewName("wap/orderinfo.html");
			return mav;
		}
	 /**
	  * 物流
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/logistics/{id}")
		public ModelAndView logistics(@PathVariable("id") Long id)throws Exception{
			ModelAndView mav=new ModelAndView();
		 TGoodsDO b=tGoodsService.get(id);
			mav.addObject("TGoods", b);
			mav.setViewName("wap/orderinfo.html");
			return mav;
		}

	 /**
	  * 加入购物车
	  * @param goodsid
	  * @param
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value = "/addCart", method = RequestMethod.POST)
		public @ResponseBody
		Map<String, String> addCart(@RequestParam(value = "goodsid") Long goodsid) throws Exception {
		 Map<String, String> map =new HashMap<>();

		 TGoodsDO goods=tGoodsService.get(goodsid);
		 	TCartDO cart=new TCartDO();
		 	cart.setGoodsid(goodsid);
		 	cart.setUserid(MemberUtils.getSessionLoginUser().getId());
		 Map<String, Object> params = new HashMap<>();
		 TCartDO check=tCartService.selectOne(params);

		 	int result=0;
		 	if(check==null){
		 		cart.setCount(1);
		 		cart.setGoodsname(goods.getTitle());
		 		cart.setImg(goods.getImg());
			 	cart.setPrice(goods.getPrices());
				 result = tCartService.save(cart);
		 	}else{
		 		check.setCount(check.getCount()+1);
		 		result=tCartService.update(check);
		 	}
		 	
			if(result == 1){
				map.put("success", "true");
			}else{
				map.put("success", "false");
			}
			return map;
		}



	/**
	  * 删除购物车
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
		public @ResponseBody
		Map<String, String> deleteCart(@RequestParam(value = "id") Long id) throws Exception {
		 tCartService.remove(id);
		 	Map<String, String> map = new HashMap<>();
				map.put("success", "true");
			 return map;
		}
	 /**
	  * 删除订单，修改状态为9
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
		public @ResponseBody
		Map<String, String> deleteOrder(@RequestParam(value = "id") Long id) throws Exception {
		 	TOrderDO o=new TOrderDO();
		 	o.setStatus(9);
		 	o.setId(id);
		 	orderService.update(o);
		 	Map<String, String> map = new HashMap<>();
				map.put("success", "true");
			 return map;
		}
}
