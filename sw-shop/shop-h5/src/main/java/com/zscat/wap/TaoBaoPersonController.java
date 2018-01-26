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
import org.springframework.web.bind.annotation.RequestAttribute;
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
@RequestMapping("/person/taobao")
public class TaoBaoPersonController {
	private String PREFIX = "/taobao/";
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
	@RequestMapping("index")
	  public ModelAndView index() {
	        try {
	            ModelAndView model = new ModelAndView("/taobao/self");
				TMemberDO member= MemberUtils.getSessionLoginUser();
				model.addObject("member", member);
	            return model;
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("导航失败!");
	        }
	    }
	 //个人资料
	 @RequestMapping("/profile")
	  public ModelAndView profile() {
		  ModelAndView model = new ModelAndView("/taobao/profile");
          TMemberDO member= MemberUtils.getSessionLoginUser();
          model.addObject("member", member);
		  return model;
	 }
	 
	 
	 @RequestMapping("/change_name")
	  public ModelAndView change_name() {
		  ModelAndView model = new ModelAndView("/taobao/change_name");
		 TMemberDO member= MemberUtils.getSessionLoginUser();
         model.addObject("member", member);
		  return model;
	 }
	 @RequestMapping("/change_tel")
	  public ModelAndView change_tel() {
		  ModelAndView model = new ModelAndView("/taobao/change_tel");
		 TMemberDO member=MemberUtils.getSessionLoginUser();
         model.addObject("member", member);
		  return model;
	 }
	 @RequestMapping("/change_pwd")
	  public ModelAndView change_pwd() {
		  ModelAndView model = new ModelAndView("/taobao/change_tel");
       
		  return model;
	 }
	@RequestMapping("/favorite")
	public ModelAndView favorite() {
		ModelAndView model = new ModelAndView("/taobao/mycollect");
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("userid",MemberUtils.getSessionLoginUser().getId());
			Query query = new Query(params);
			List<FavoriteDO> favoriteList = favoriteService.userFavorite(query);
			model.addObject("favoriteList", favoriteList);
		}catch (Exception e){
			e.printStackTrace();

		}
		return model;
	}
	 /**
		 * 修改密码
		* @return
		 */
		@RequestMapping(value = "updateUser1", method = RequestMethod.POST)
		public ModelAndView updateUser1(@ModelAttribute TMemberDO Member, HttpServletRequest request){
			 ModelAndView model = new ModelAndView("/taobao/profile");
			 userService.update(Member);
			 return model;
		}
		/**
		 * 保存用户
		* @return
		 */
		@RequestMapping(value = "updateUser", method = RequestMethod.POST)
		public ModelAndView updateUser(@ModelAttribute TMemberDO Member, HttpServletRequest request){
			 ModelAndView model = new ModelAndView("/taobao/profile");
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
		 ModelAndView model = new ModelAndView("/taobao/information");
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
		 ModelAndView model = new ModelAndView("/taobao/safety");
		 
		 
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
	  public ModelAndView order(HttpServletRequest request) {
		 ModelAndView model = new ModelAndView("/taobao/order");
		 String status = request.getParameter("status");
		 Map<String, Object> params = new HashMap<>();
		 if(!StringUtils.isNoneEmpty(status)){
			 params.put("status",status);
		 }
		 params.put("userid",MemberUtils.getSessionLoginUser().getId());
		 Query query = new Query(params);
		 List<TOrderDO> tOrderList = orderService.list(query);
		 for (TOrderDO orderDO : tOrderList){
			 params.clear();
			 params.put("orderid",orderDO.getId());
			 List<TGoodSorderDO> gs = tGoodSorderService.list(params);
			 orderDO.setGoodsList(gs);
		 }
		 model.addObject("tOrderList",tOrderList);
		 return model;
	 }

	/**
	 * 物流
	 * @return
	 */
	@RequestMapping("/wuliu/id")
	public ModelAndView wuliu(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("/taobao/wuliu");

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
				return "taobao/ajax-order";
	}
		
	 /**
	  * 退款管理
	  * @return
	  */
	 @RequestMapping("/change")
	  public ModelAndView change() {
		 ModelAndView model = new ModelAndView("/taobao/change");
		 
		 
		 return model;
	 }
	
	 /**
	  * 我的积分
	  * @return
	  */
	 @RequestMapping("/points")
	  public ModelAndView points() {
		 ModelAndView model = new ModelAndView("/taobao/points");
		 
		 
		 return model;
	 }
	 
	 /**
	  * 优惠劵
	  * @return
	  */
	 @RequestMapping("/coupon")
	  public ModelAndView coupon() {
		 ModelAndView model = new ModelAndView("/taobao/myCoupon");
		 Map<String, Object> params =new HashMap<>();
		 params.put("userid",MemberUtils.getSessionLoginUser().getId());
		 Query query = new Query(params);
		 List<CouponDO> couponList = couponService.userCoupon(query);
		 model.addObject("couponList",couponList);
		 return model;
	 }
	 /**
	  * 红包
	  * @return
	  */
	 @RequestMapping("/bonus")
	  public ModelAndView bonus() {
		 ModelAndView model = new ModelAndView("/taobao/bonus");
		 
		 
		 return model;
	 }
	 /**
	  * 账户余额
	  * @return
	  */
	 @RequestMapping("/walletlist")
	  public ModelAndView walletlist() {
		 ModelAndView model = new ModelAndView("/taobao/walletlist");
		 
		 
		 return model;
	 }
	 /**
	  * 账单明细
	  * @return
	  */
	 @RequestMapping("/bill")
	  public ModelAndView bill() {
		 ModelAndView model = new ModelAndView("/taobao/bill");
		 
		 
		 return model;
	 }
	 
	 /**
	  * 足迹
	  * @return
	  */
	 @RequestMapping("/foot")
	  public ModelAndView foot(HttpServletRequest req) {
		 ModelAndView model = new ModelAndView("/taobao/foot");
		
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
		 ModelAndView model = new ModelAndView("/taobao/consultation");
		 
		 
		 return model;
	 }
	 /**
	  * 意见反馈
	  * @return
	  */
	 @RequestMapping("/suggest")
	  public ModelAndView suggest() {
		 ModelAndView model = new ModelAndView("/taobao/suggest");
		 
		 
		 return model;
	 }
	 /**
	  * 我的消息
	  * @return
	  */
	 @RequestMapping("/msg")
	  public ModelAndView news() {
		 ModelAndView model = new ModelAndView("/taobao/news");
		 
		 
		 return model;
	 }
	/**
	 * 购物车
	 * @return
	 */
	 @RequestMapping("/cartList")
	  public ModelAndView cartList() {
		 ModelAndView model = new ModelAndView("/taobao/shopcar");
		 if(MemberUtils.getSessionLoginUser()!=null){
			 model.addObject("cartList", tCartService.selectOwnCart(MemberUtils.getSessionLoginUser().getId()));
		 }else{
			 model.addObject("cartList", new ArrayList<>());
		 }
		 return model;
	 }
	/**
	 * 加入购物车
	 * @param
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public @ResponseBody
	R addCart(HttpServletRequest req) throws Exception {
		Map<String, Object> params =new HashMap<>();
		params.put("offset", 0);
		R r=new R();
		TMemberDO user=MemberUtils.getSessionLoginUser();
		try {
			String goodsid = req.getParameter("goodsid");
			String count = req.getParameter("count");
			if (StringUtils.isEmpty(goodsid) || user == null) {
				return R.Empty();
			}
			if (StringUtils.isEmpty(count)) {
				count ="1";
			}
			TGoodsDO goods = tGoodsService.get(Long.parseLong(goodsid));
			params.remove("count");
			params.put("userid", user.getId());
			params.put("goodsid", goodsid);
			TCartDO cart = tCartService.selectOne(params);
			if (cart != null) {
				cart.setCount(cart.getCount() + Integer.parseInt(count));
				tCartService.update(cart);
			} else {
				cart = new TCartDO();
				cart.setCount(Integer.parseInt(count));
				cart.setGoodsid(Long.parseLong(goodsid));
				cart.setUserid(user.getId());
				cart.setPrice(goods.getPrices());
				cart.setStoreid(goods.getStoreid());
				cart.setImg(goods.getImg());
				cart.setGoodsname(goods.getTitle());
				tCartService.save(cart);
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 立即购买
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/likBuy/{ProductId}")
	public ModelAndView ProductDetail(@PathVariable("ProductId") Long ProductId,
									  HttpSession session)throws Exception{
		ModelAndView mav=new ModelAndView();
		Map<String, Object> param =new HashMap<>();
		param.put("userid",MemberUtils.getSessionLoginUser().getId());
		mav.addObject("totalprice",tCartService.countprice(param));
		param.put("limit", 20);
		List<AddressDO> addressList= addressService.list(param);
		mav.addObject("addressList", addressList);
		List<CouponDO> couponList = couponService.list(param);
		mav.addObject("couponList", couponList);
		param.put("goodsid", ProductId);
		List<TCartDO> cartList=tCartService.list(param);
		mav.addObject("cartList", cartList);

		mav.setViewName("taobao/likBuy");
		return mav;
	}

	/**
	 * 重购物车过来
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/likBuy1")
	public ModelAndView ProductDetail1()throws Exception{
		ModelAndView mav=new ModelAndView();
		Map<String, Object> param =new HashMap<>();
	   TMemberDO user =MemberUtils.getSessionLoginUser();
		param.put("userid",user.getId());
		mav.addObject("totalprice",tCartService.countprice(param));
		param.put("limit", 20);
		List<TCartDO> cartList=tCartService.list(param);
		mav.addObject("cartList", cartList);

		List<CouponDO> couponList = couponService.list(param);
		mav.addObject("couponList", couponList);
		param.put("isdefault", 0);
		List<AddressDO> addressList= addressService.list(param);
		mav.addObject("addressList", addressList);
		mav.setViewName("taobao/likBuy");
		return mav;
	}
	/**
	 * 提交订单
	 * @param
	 * @return
	 */
	@ResponseBody
	@PostMapping("/submitOrder")
	public R orderSubmit(HttpServletRequest req){
		R r=new R();
		try {
			TOrderDO result = tCartService.orderStreetSubmit(req);
			if (result!=null){
				jifendataService.save(Constan.SUBMITORDER);
				r.put("data",result);
			}else{
				return R.error();
			}
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 余额支付
	 * @param
	 * @return
	 */
	@ResponseBody
	@PostMapping("/balancePay")
	public R balancePay(HttpServletRequest req){
		try {
			return tCartService.balancePay(req);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
	}
	/**
	 * 立即付款
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/pay/{orderId}")
	public ModelAndView pay(@RequestAttribute("wxOpenId") String wxOpenId,
							@PathVariable("orderId") Long orderId
	)throws Exception{
		ModelAndView mav=new ModelAndView();
		TOrderDO orderDO =orderService.get(orderId);
		mav.addObject("order", orderDO);
		AddressDO addressDO = addressService.get(orderDO.getAddressid());
		String str = "收货信息："+addressDO.getDetail()+","+addressDO.getName()+",手机号:"+addressDO.getMobile();
		mav.addObject("str", str);
		mav.addObject("user", userService.get(MemberUtils.getSessionLoginUser().getId()));
		mav.setViewName("taobao/pay");
		mav.addObject("wxOpenId", wxOpenId);

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
			mav.setViewName("taobao/order");
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
			mav.setViewName("taobao/orderinfo");
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
			mav.setViewName("taobao/orderinfo");
			return mav;
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
