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
@RequestMapping("/wap")
public class Wap1IndexController {
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
	  public ModelAndView index(@RequestParam Map<String, Object> params) {
	        try {
				ModelAndView model = new ModelAndView("/wap/index");
				List<TArticleDO> nav_icon_list = new ArrayList<>();
				TStoreDO store = tStoreService.get(1L);

				params.put("limit", 3);
				List<BannerDO> bannerList = bannerService.list(params);

				params.put("limit", 3);
				List<CouponDO> couponList = couponService.list(params);

				List<TopicDO> tArticleList = topicService.list(params);

				TArticleDO c1 = new TArticleDO("全部商品","/pages/list/list?cat_id=","navigate", "http://www.91weiyi.xyz/addons/zjhj_mall/core/web/uploads/image/86/863a7db352a936743faf8edd5162bb5c.png");
				TArticleDO c2 = new TArticleDO("商品分类","/pages/cat/cat","switchTab", "http://www.91weiyi.xyz/addons/zjhj_mall/core/web/uploads/image/35/3570994c06e61b1f0cf719bdb52a0053.png");
				TArticleDO c3 = new TArticleDO("购物车","/pages/cart/cart","switchTab", "http://www.91weiyi.xyz/addons/zjhj_mall/core/web/uploads/image/c2/c2b01cf78f79cbfba192d5896eeaecbe.png");
				TArticleDO c4 = new TArticleDO("我的订单","/pages/order/order?status=9","navigate", "http://www.91weiyi.xyz/addons/zjhj_mall/core/web/uploads/image/7c/7c80acbbd479b099566cc6c3d34fbcb8.png");
				TArticleDO c5 = new TArticleDO("用户中心","/pages/user/user","switchTab", "http://www.91weiyi.xyz/addons/zjhj_mall/core/web/uploads/image/46/46eabbff1e7dc5e416567fc45d4d5df3.png");
				TArticleDO c6 = new TArticleDO("优惠劵","/pages/coupon/coupon?status=3","navigate", "http://www.91weiyi.xyz/addons/zjhj_mall/core/web/uploads/image/13/13312a6d56c202330f8c282d8cf84ada.png");
				TArticleDO c7 = new TArticleDO("我的收藏","/pages/favorite/favorite","navigate", "http://www.91weiyi.xyz/addons/zjhj_mall/core/web/uploads/image/ca/cab6d8d4785e43bd46dcbb52ddf66f61.png");
				TArticleDO c8 = new TArticleDO("售后订单","/pages/order/order?status=4","navigate", "http://www.91weiyi.xyz/addons/zjhj_mall/core/web/uploads/image/cf/cfb32a65d845b4e9a9778020ed2ccac6.png");
				nav_icon_list.add(c1);nav_icon_list.add(c2);nav_icon_list.add(c3);
				nav_icon_list.add(c4);nav_icon_list.add(c5);nav_icon_list.add(c6);
				nav_icon_list.add(c7);nav_icon_list.add(c8);


				params.clear();
				params.put("sort","clickHit");
				params.put("order","desc");
				model.addObject("hitList", tGoodsService.list(params));
				params.clear();
				params.put("sort","create_date");
				params.put("order","desc");
				model.addObject("xinpinList", tGoodsService.list(params));
				params.clear();
				params.put("iscom","1");
				model.addObject("commList", tGoodsService.list(params));

				model.addObject("tArticleList",tArticleList);model.addObject("nav_icon_list",nav_icon_list);
				model.addObject("bannerList",bannerList);model.addObject("couponList",couponList);
				model.addObject("store",store);
				model.addObject("nav_icon_list",nav_icon_list);

	            return model;
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("导航失败!");
	        }
	    }
	@RequestMapping("index1")
	public ModelAndView index1(HttpServletRequest req) {
		try {
			ModelAndView model = new ModelAndView("/wap/index1");
			Map<String, Object> params = new HashMap<>();
			params.put("sort","clickHit");
			params.put("order","desc");
			model.addObject("hitList", tGoodsService.list(params));
			params.clear();
			params.put("sort","create_date");
			params.put("order","desc");
			model.addObject("xinpinList", tGoodsService.list(params));
			params.clear();
			params.put("iscom","1");
			model.addObject("commList", tGoodsService.list(params));

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("导航失败!");
		}
	}
	 @RequestMapping("/goodsDetail/{id}")
		public ModelAndView goodsDetail(@PathVariable("id") Long id, HttpServletRequest req)throws Exception{
			ModelAndView mav=new ModelAndView();
			TGoodsDO goods=tGoodsService.get(id);
			mav.addObject("goods", goods);
			if(goods.getImgmore()!=null && goods.getImgmore().indexOf(",")>-1){
				mav.addObject("imgs", goods.getImgmore().split(","));
			}
			mav.setViewName("wap/goodsDetail");
			goods.setClickhit(goods.getClickhit()+1);
			tGoodsService.update(goods);
			//查询详情商品的 其他商品

		 Map<String, Object> params = new HashMap<>();
		 params.put("createBy",goods.getCreateBy());

			mav.addObject("ownGoods", tGoodsService.list(params));

			return mav;
		}

	 @RequestMapping("/information/{createBy}")
	  public ModelAndView information(@PathVariable("createBy") Long createBy) {
		 ModelAndView model = new ModelAndView("/wap/person/information");
        TMemberDO member=tMemberService.get(createBy);
        model.addObject("member", member);
		 return model;
	 }
	 /**
	  * 商城公告
	  * @param
	  * @return
	  */
	 @RequestMapping("/newD/{id}")
	  public ModelAndView newD(@PathVariable("id") Long id) {
		 ModelAndView model = new ModelAndView("/wap/person/blog");
//        Article article=articleService.selectByPrimaryKey(id);
//        model.addObject("article", article);
//        List<Article> articleList=articleService.select(new Article());
//        model.addObject("articleList", articleList);
		 return model;
	 }
	   /**
		 * 跳转到登录页面
		 * 
		 * @return
		 */

	@RequestMapping(value = "login")
	public ModelAndView toLogin1() {
		ModelAndView model = new ModelAndView("/wap/login");
		if( MemberUtils.getSessionLoginUser() != null){
			return new ModelAndView("redirect:/wap");
		}
		return model;
	}

		/**
		 * 登录验证
		 * 
		 * @param username
		 * @param password
		 * @param
		 * @return
		 */
		@RequestMapping(value = "login", method = RequestMethod.POST)
		public @ResponseBody
        Map<String, Object> checkLogin(String username,
                                       String password, HttpServletRequest request) {

			Map<String, Object> msg = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			//code = StringUtils.trim(code);
			username = StringUtils.trim(username);
			password = StringUtils.trim(password);

			TMemberDO user = tMemberService.checkUser(username, password);
			if (null != user) {
				Map<String, Object> params = new HashMap<>();
				session.setAttribute(MemberUtils.SESSION_LOGIN_MEMBER, tMemberService.selectOne(params));
			} else {
				msg.put("error", "用户名或密码错误");
			}
			return msg;
		}
	 
		 /**
		 * 跳转到登录页面
		 * 
		 * @return
		 */
		@RequestMapping(value = "reg", method = RequestMethod.GET)
		public String reg() {
			if( MemberUtils.getSessionLoginUser() != null){
				return "redirect:/wap";
			}
			return "/wap/register";
		}
	
		@RequestMapping(value = "reg", method = RequestMethod.POST)
		public @ResponseBody
        Map<String, Object> reg(
                @RequestParam(value = "password",required=true)String  password,
                @RequestParam(value = "email",required=false)String email,
                @RequestParam(value = "phone",required=false)String phone,
                @RequestParam(value = "username")String username,
                @RequestParam(value = "passwordRepeat",required=true)String passwordRepeat, HttpServletRequest request) {
			Map<String, Object> msg = new HashMap<String, Object>();
			if (!StringUtils.equalsIgnoreCase(password, passwordRepeat)) {
				msg.put("error", "密码不一致!");
				return msg;
			}
			String secPwd = null ;
			TMemberDO m=new TMemberDO();
			secPwd = MD5Utils.encrypt(password, username);
			m.setUsername(username);
			m.setPassword(secPwd);
			m.setTruename(m.getUsername());
			m.setPhone(phone);
			try {
				HttpSession session = request.getSession();
				int result = tMemberService.save(m);
				System.out.println(m.getId());
				if (result == 1) {
					Map<String, Object> params = new HashMap<>();

					session.setAttribute(MemberUtils.SESSION_LOGIN_MEMBER, tMemberService.get(m.getId()));
				} else {
					msg.put("error", "注册失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return msg;
		}
	 	/**
		 * 用户退出
		 * 
		 * @return 跳转到登录页面
		 */
		@RequestMapping("logout")
		public String logout(HttpServletRequest request) {
			request.getSession().invalidate();
			return "redirect:/wap/login";
		}
	

}
