package com.zscat.wap;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.alibaba.dubbo.config.annotation.Reference;
import com.zsCat.common.common.utils.CookieUtil;
import com.zsCat.common.common.utils.JSONUtils;
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
import org.springframework.web.bind.annotation.GetMapping;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
 
@Controller
@RequestMapping("/h5")
public class H5IndexController {
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
	/**
	 * banner图列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/banner/list")
	public R banner(@RequestParam Map<String, Object> params) {
		params.put("offset", 0);
		//查询列表数据
		R r = new R();
		try {
			Query query = new Query(params);
			List<TBrandDO> tArticleList = tBrandService.list(query);
			int total = tBrandService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);

			r.put("data", pageUtils);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 品牌列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/brand/list")
	public R brand(@RequestParam Map<String, Object> params) {
		params.put("offset", 0);
		//查询列表数据
		R r = new R();
		try {
			Query query = new Query(params);
			List<TBrandDO> tArticleList = tBrandService.list(query);
			int total = tBrandService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);
			r.put("data", pageUtils);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
		return r;
	}

	/**
	 * 品牌下的商品
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/brand/index")
	public R brandGoods(@RequestParam Map<String, Object> params,HttpServletRequest req) {
		params.put("offset", 0);
		params.put("limit", 12);
		//查询列表数据
		R r = new R();
		try {
			Query query = new Query(params);
			List<TGoodsDO> tArticleList = tGoodsService.list(query);
			int total = tGoodsService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);
			r.put("data", pageUtils);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 所有的分类
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/category/all")
	public R category(@RequestParam Map<String, Object> params) {
		params.put("offset", 0);
		params.put("limit", 10);
		//查询列表数据
		R r = new R();
		try {
			Query query = new Query(params);
			List<TGoodsTypeDO> tArticleList = tGoodsTypeService.list(query);
			int total = tGoodsTypeService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);

			r.put("data", pageUtils);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 商品列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/goods/list")
	public R goods(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		params.put("limit", 10);
		params.put("sort","clickHit");
		params.put("order","desc");
		R r=new R();
		try {
			Query query = new Query(params);
			List<TGoodsDO> tArticleList = tGoodsService.list(query);
			int total = tGoodsService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);
			r.put("data",pageUtils);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}

	/**
	 * 商品详情
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/details")
	public R goodsDetail(HttpServletRequest req)throws Exception{
		Long id = Long.parseLong(req.getParameter("id"));

		R r=new R();
		try {
			TGoodsDO goods=tGoodsService.get(id);
			r.put("data",goods);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 文章列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/article/list")
	public R article(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		R r=new R();
		try {
			Query query = new Query(params);
			List<ArticleDO> tArticleList = articleService.list(query);
			int total = articleService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);
			r.put("page",pageUtils);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	@PostMapping( "/user/check-token")
	@ResponseBody
	public R remove( String  token){
//		if(tArticleService.remove(id)>0){
//			return R.ok();
//		}
		return R.error();
	}


	/**
	 * 文章列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/default/index")
	public R index(@RequestParam Map<String, Object> params){
		Map<String, Object> data = new HashMap<>();
		List<TArticleDO> nav_icon_list = new ArrayList<>();
		R r=new R();
		try {

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

			List<TGoodsTypeDO> goodsTypeDOList = tGoodsTypeService.list(params);
			for (TGoodsTypeDO g :goodsTypeDOList){
				params.clear();
				params.put("typeid",g.getId());
				List<TGoodsDO> goodsDOList = tGoodsService.list(params);
				g.setGoods_list(goodsDOList);
			}
            params.clear();
			params.put("sort","clickHit");
			params.put("order","desc");
			data.put("hitList", tGoodsService.list(params));
			params.clear();
			params.put("sort","create_date");
			params.put("order","desc");
			data.put("xinpinList", tGoodsService.list(params));
			params.clear();
			params.put("iscom","1");
			data.put("commList", tGoodsService.list(params));

			data.put("goodsTypeList",goodsTypeDOList);
			data.put("tArticleList",tArticleList);data.put("nav_icon_list",nav_icon_list);
			data.put("bannerList",bannerList);data.put("couponList",couponList);
			data.put("store",store);
			r.put("data",data);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 商品列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/default/goods-list")
	public R goodsList(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		//params.put("limit", 10);
		//params.put("sort","clickHit");
	//	params.put("order","desc");
		if("1".equals(params.get("sort1"))){
			params.put("sort","create_date");
		}else if("2".equals(params.get("sort1"))){
			params.put("sort","prices");
		}else if("3".equals(params.get("sort1"))){
			params.put("sort","sellhit");
		}else if("4".equals(params.get("sort1"))){
			params.put("sort","clickHit");
		}

		if("1".equals(params.get("order1"))){
			params.put("order","asc");
		}else if("2".equals(params.get("order1"))){
			params.put("order","desc");
		}else if("-1".equals(params.get("order1"))){
			params.put("order","asc");
		}
		R r=new R();
		try {
			params.remove("sort1");
			params.remove("order1");
			Query query = new Query(params);
			List<TGoodsDO> tArticleList = tGoodsService.list(query);
			int total = tGoodsService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);
			r.put("data",pageUtils);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 商品详情
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/default/goods")
	public R defaultgoodsDetail(HttpServletRequest req)throws Exception{
		Long id = Long.parseLong(req.getParameter("id"));
		Long userid = Long.parseLong(req.getParameter("userid"));
		R r=new R();
		try {
			TGoodsDO goods=tGoodsService.get(id);
			String imgs[] =new String[4];
			if(goods.getImgmore()!=null && goods.getImgmore().indexOf(",")>-1){
				imgs = goods.getImgmore().split(",");
				imgs[0] = "https://zscat.tunnel.qydev.com/upload/project/"+goods.getImg();
			}else {
				imgs[0] = "https://zscat.tunnel.qydev.com/upload/project/"+goods.getImg();
			}
			goods.setImgs(imgs);
			goods.setClickhit(goods.getClickhit()+1);
			tGoodsService.update(goods);
			Map<String, Object> params = new HashMap<>();
			params.put("userid",userid);
			params.put("goodsid",id);
			params.put("deletestatus",2);
			params.put("type",1);
            FavoriteDO favoriteDO = favoriteService.selectOne(params);
            if(favoriteDO!=null){
            	goods.setIs_favorite(1);
			}
			r.put("data",goods);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}

	/**
	 * 店铺详情
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/default/store")
	public R storeDetail(HttpServletRequest req)throws Exception{
		Long id = Long.parseLong(req.getParameter("id"));
		R r=new R();
		try {
			TStoreDO goods=tStoreService.get(id);
			r.put("data",goods);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 购物车列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/cart/cart-list")
	public R cartList(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		R r=new R();
		try {
			Query query = new Query(params);
			List<TCartDO> tArticleList = tCartService.list(query);
			int total = tCartService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);
			r.put("data",pageUtils);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}

	/**
	 * 添加购物车
	 * @param params
	 * @return
	 */
	@ResponseBody
	@PostMapping("/cart/add-cart")
	public R addCart(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		R r=new R();
		try {
			String goodsid=params.get("goodsid").toString();
			String userid=params.get("userid").toString();
			String count=params.get("count").toString();
			TGoodsDO goods = tGoodsService.get(Long.parseLong(goodsid));
			params.remove("count");
			TCartDO cart = tCartService.selectOne(params);
			if(cart!=null){
				cart.setCount(cart.getCount()+Integer.parseInt(count));
				tCartService.update(cart);
			}else{
				cart = new TCartDO();
				cart.setCount(Integer.parseInt(count));
				cart.setGoodsid(Long.parseLong(goodsid));
				cart.setUserid(Long.parseLong(userid));
				cart.setPrice(goods.getPrices());
				cart.setStoreid(goods.getStoreid());
				cart.setImg(goods.getImg());
				cart.setGoodsname(goods.getTitle());
				tCartService.save(cart);
			}
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
//	submit_preview: _api_root + 'order/submit-preview',
	/**
	 * 预览订单
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/order/submit-preview")
	public R ordersubmitpreview(@RequestParam Map<String, Object> params){
		R r=new R();
		try {
			Map<String, Object> result = tCartService.ordersubmitpreview(params);
			r.put("data",result);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}

//	submit: _api_root + 'order/submit',
	/**
	 * 提交订单
	 * @param
	 * @return
	 */
	@ResponseBody
	@PostMapping("/order/submit")
	public R orderSubmit(HttpServletRequest req){
		R r=new R();
		try {
			TOrderDO result = tCartService.orderSubmit(req);
			r.put("data",result);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
//	pay_data: _api_root + 'order/pay-data',
	/**
	 * 提交订单
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/order/pay-data")
	public R payData(@RequestParam Map<String, Object> params){
		Long id = Long.parseLong(params.get("orderid").toString());
		R r=new R();
		try {
			TOrderDO result = orderService.get(id);
			r.put("data",result);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
//	list: _api_root + 'order/list',
	/**
	 * 分类列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/order/list")
	public R orderList(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		R r=new R();
		try {
			Query query = new Query(params);
			List<TOrderDO> tGoodsTypeDOS = orderService.list(query);
			int total = orderService.count(query);
			for (TOrderDO orderDO : tGoodsTypeDOS){
				params.clear();
				params.put("orderid",orderDO.getId());
				List<TGoodSorderDO> gs = tGoodSorderService.list(params);
				orderDO.setGoodsList(gs);
			}

			PageUtils pageUtils = new PageUtils(tGoodsTypeDOS, total);
			r.put("data",pageUtils);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
//	revoke: _api_root + 'order/revoke',
//	confirm: _api_root + 'order/confirm',
//	count_data: _api_root + 'order/count-data',
//	detail: _api_root + 'order/detail',
//	refund_preview: _api_root + 'order/refund-preview',
//	refund: _api_root + 'order/refund',
//	refund_detail: _api_root + 'order/refund-detail',
//	comment_preview: _api_root + 'order/comment-preview',
//	comment: _api_root + 'order/comment',
//	express_detail: _api_root + 'order/express-detail',
//	clerk: _api_root + "order/clerk",
//	clerk_detail: _api_root + 'order/clerk-detail',
//	get_qrcode: _api_root + 'order/get-qrcode',
	/**
	 * 分类列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/default/cat-list")
	public R catList(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		R r=new R();
		try {
			Query query = new Query(params);
			List<TGoodsTypeDO> tGoodsTypeDOS = tGoodsTypeService.list(query);
			int total = tGoodsTypeService.count(query);
			for (TGoodsTypeDO gt : tGoodsTypeDOS){
				params.clear();
				params.put("typeid",gt.getId());
				List<TGoodsDO> goodsDOList = tGoodsService.list(params);
				gt.setGoods_list(goodsDOList);
			}
			PageUtils pageUtils = new PageUtils(tGoodsTypeDOS, total);
			r.put("data",pageUtils);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 商品评论列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/default/comment-list")
	public R commentList(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		R r=new R();
		try {
			Query query = new Query(params);
			List<TReplyDO> tArticleList = tReplyService.list(query);
			int total = tReplyService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);
			r.put("data",pageUtils);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 用户地址列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/user/address-list")
	public R addressList(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		R r=new R();
		try {
			Query query = new Query(params);
			List<AddressDO> tArticleList = addressService.list(query);
			int total = addressService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);
			r.put("data",pageUtils);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 地址详情
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/user/address-detail")
	public R addressDetail(HttpServletRequest req)throws Exception{
		Long id = Long.parseLong(req.getParameter("id"));
		R r=new R();
		try {
			AddressDO goods=addressService.get(id);
			r.put("data",goods);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 用户详情
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/user/index")
	public R memberDetail(HttpServletRequest req)throws Exception{
		Long id = Long.parseLong(req.getParameter("id"));
		R r=new R();
		try {
			TMemberDO goods=tMemberService.get(id);
			r.put("data",goods);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
//	address_save: _api_root + 'user/address-save',
	/**
	 * 添加地址
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/user/address-save")
	public R addressSave(HttpServletRequest req)throws Exception{

		R r=new R();
		try {
			AddressDO addressDO =new AddressDO();

			addressService.save(addressDO);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
//	address_set_default: _api_root + 'user/address-set-default',
	/**
	 * 修改地址
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/user/address-update")
	public R addressUpdate(HttpServletRequest req)throws Exception{

		R r=new R();
		try {
			AddressDO addressDO =new AddressDO();

			addressService.update(addressDO);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
//	address_delete: _api_root + 'user/address-delete',
	/**
	 * 删除
	 */
	@PostMapping( "/user/address-delete")
	@ResponseBody
	public R remove( Long id){
		if(addressService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
//	save_form_id: _api_root + "user/save-form-id",
	/**
	 * 添加地址
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/user/save-form-id")
	public R saveformid(HttpServletRequest req)throws Exception{

		R r=new R();
		try {
			AddressDO addressDO =new AddressDO();

			addressService.save(addressDO);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
//	favorite_add: _api_root + "user/favorite-add",
	/**
	 * 添加地址
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/user/favorite-add")
	public R favoriteadd(@RequestParam Map<String, Object> params,HttpServletRequest req)throws Exception{
		Long userid=Long.parseLong(req.getParameter("userid"));
		Long goodsid=Long.parseLong(req.getParameter("goodsid"));
		params.put("offset", 0);
		R r=new R();
		try {
			FavoriteDO favoriteDO = favoriteService.selectOne(params);
			if (favoriteDO!=null){
				FavoriteDO favoriteDO1 =new FavoriteDO();
				favoriteDO1.setId(favoriteDO.getId());
				//更新状态
				if(favoriteDO.getDeletestatus()==2){
					favoriteDO1.setDeletestatus(1);
				}else{
					favoriteDO1.setDeletestatus(2);
				}

				favoriteDO1.setAddtime(new Date());
				favoriteService.update(favoriteDO1);
			}else{
				TGoodsDO goodsDO = tGoodsService.get(goodsid);
				favoriteDO = new FavoriteDO();
				favoriteDO.setType(1); //增加
				favoriteDO.setDeletestatus(2);
				favoriteDO.setGoodsid(goodsid);
				favoriteDO.setUserid(userid);
				favoriteDO.setStoreid(goodsDO.getStoreid());
				favoriteDO.setAddtime(new Date());
				favoriteService.save(favoriteDO);
			}
			r.put("data",favoriteDO);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
//	favorite_remove: _api_root + "user/favorite-remove",
	/**
	 * 删除
	 */
	@PostMapping( "/user/favorite-remove")
	@ResponseBody
	public R favoriteremove( Long id){
		if(favoriteService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
//	favorite_list: _api_root + "user/favorite-list",
	/**
	 * 话题列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/user/favorite-list")
	public R goodsfavoriteList(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		R r=new R();
		try {
			Query query = new Query(params);
			List<FavoriteDO> tArticleList = favoriteService.userFavorite(query);
			r.put("data",tArticleList);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 话题列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/user/topic-favorite-list")
	public R topicfavoriteList(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		R r=new R();
		try {
			Query query = new Query(params);
			List<FavoriteDO> tArticleList = favoriteService.userTopicFavorite(query);
			r.put("data",tArticleList);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
//	index: _api_root + "user/index",
//	wechat_district: _api_root + "user/wechat-district",
//	add_wechat_address: _api_root + "user/add-wechat-address",
	/**
	 * 添加地址
	 * @param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/user/add-wechat-address")
	public R addwechataddress(AddressDO addressDO)throws Exception{

		R r=new R();
		try {
			addressDO.setIsdefault(0);
			addressService.save(addressDO);
			r.put("data",addressDO);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
//	topic_favorite: _api_root + "user/topic-favorite",
//	topic_favorite_list: _api_root + "user/topic-favorite-list",
	/**
	 * 话题列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/default/topic-list")
	public R topicList(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		R r=new R();
		try {
			Query query = new Query(params);
			List<TopicDO> tArticleList = topicService.list(query);
			int total = topicService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);
			r.put("data",pageUtils);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 店铺详情
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/default/topic")
	public R topicDetail(HttpServletRequest req)throws Exception{
		Long id = Long.parseLong(req.getParameter("id"));
		R r=new R();
		try {
			TopicDO goods=topicService.get(id);
			r.put("data",goods);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 优惠劵列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/default/coupon-list")
	public R couponList(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		R r=new R();
		try {
			Query query = new Query(params);
			List<CouponDO> tArticleList = couponService.list(query);
			int total = couponService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);
			r.put("data",pageUtils);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}
	/**
	 * 我领取优惠劵列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/coupon/index")
	public R userCoupon(@RequestParam Map<String, Object> params){
		params.put("offset", 0);
		R r=new R();
		try {
			Query query = new Query(params);
			List<CouponDO> tArticleList = couponService.userCoupon(query);
			int total = couponService.count(query);
			PageUtils pageUtils = new PageUtils(tArticleList, total);
			r.put("data",pageUtils);
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}
		return r;
	}


}
