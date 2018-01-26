package com.zscat.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zsCat.common.common.utils.R;
import com.zscat.config.MemberUtils;
import com.zscat.shop.domain.*;
import com.zscat.shop.domain.TGoodsDO;
import com.zscat.shop.domain.TMemberDO;
import com.zscat.shop.domain.TOrderDO;
import com.zscat.shop.service.ArticleService;
import com.zscat.shop.service.*;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by Administrator on 2017/5/19 0019.
 */
@Controller
@RequestMapping("/web/person")
public class PersonController {
    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class.getName());
    private String PREFIX = "/web/";
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
    /**
     * 开店
     */

    @RequestMapping(value = "addStore", method = RequestMethod.GET)
    public String addStore(Model model) {
        TMemberDO tMember = MemberUtils.getSessionLoginUser();
        if (tMember!=null && tMember.getStoreid()!=null){
            TStoreDO store = tStoreService.get(tMember.getStoreid());
            model.addAttribute("store",store);
            return PREFIX + "store";
        }else{
            return PREFIX + "addStore";
        }

    }
    @RequestMapping(value = "addStore", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addStores(TStoreDO tStore,
                                   HttpServletRequest req) {
        Map<String, Object> map = new HashMap<>();
        TMemberDO tMember = MemberUtils.getSessionLoginUser();
        if (tMember!=null) {
            tStore.setAddtime(new Date());
            tStoreService.save(tStore);
            tMember.setStoreid(tStore.getId());
          //  tMemberService.update(tMember);
            HttpSession session = req.getSession();
            session.setAttribute(MemberUtils.SESSION_LOGIN_MEMBER, tMember);
            map.put("code","1");
            map.put("id",tStore.getId());
        }else {
            map.put("code","2");
        }
        LOG.info("addStores:{}",map);
        return map;
    }


    @RequestMapping(value = "addGoods", method = RequestMethod.GET)
    public String addGoods() {
        TMemberDO tMember = MemberUtils.getSessionLoginUser();
        if (tMember!=null && tMember.getStoreid()!=null) {
            return PREFIX + "addGoods";
        }else{
            return PREFIX + "login";
        }
    }
    @RequestMapping(value = "addGoods", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addGoods(TGoodsDO tGoods,
                                  HttpServletRequest req) {
        Map<String, Object> map = new HashMap<>();

        TMemberDO tMember = MemberUtils.getSessionLoginUser();
        if (tMember!=null) {
            String imges="";
            String blogInfo=tGoods.getRemark();
            Document doc=Jsoup.parse(blogInfo);
            Elements jpgs=doc.select("img[src]"); //　查找扩展名是jpg的图片
            for(int i=0;i<jpgs.size();i++){
                Element jpg=jpgs.get(i);
                if(jpg!=null && jpg!=null){
                    String linkHref = jpg.attr("src");
                    imges+=linkHref+",";
                }
                if(i==2){
                    break;
                }
            }
            tGoods.setStoreid(tMember.getStoreid());
            tGoods.setImgmore(imges);
            tGoods.setCreateDate(new Date());
            tGoods.setCreateBy(tMember.getId());
            tGoodsService.save(tGoods);
            map.put("id",tMember.getStoreid());
            map.put("code","1");
        }else {
            map.put("code","2");
        }
        LOG.info("addGoods:{}",map);
        return map;
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
    R addCart(@RequestParam Map<String, Object> params) throws Exception {
        params.put("offset", 0);
        R r=new R();
        TMemberDO user=MemberUtils.getSessionLoginUser();
        try {
            String goodsid = params.get("goodsid").toString();
            String count = params.get("count").toString();
            if (StringUtils.isEmpty(goodsid) || user == null ||
                    StringUtils.isEmpty(count)) {
                return R.Empty();
            }
            TGoodsDO goods = tGoodsService.get(Long.parseLong(goodsid));
            params.remove("count");
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
        List<TCartDO> cartList=tCartService.list(param);
        mav.addObject("cartList", cartList);

//        List<TAddress> addressList= AddressService.selectByMemberId();
//        mav.addObject("addressList", addressList);
//
//        TPayment Payment=new Payment();
//        Payment.setIsDel(1);
//        List<Payment> payList=PaymentService.select(Payment);
//        mav.addObject("payList", payList);

        mav.setViewName("web/likBuy");
        return mav;
    }
    /**
     * 提交订单
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("submitOrder")
    public ModelAndView submitOrder(@RequestParam(value = "cartIds") String[] cartIds,
                                    @RequestParam(value = "addressid") Long addressid,
                                    @RequestParam(value = "paymentid") Long paymentid,
                                    @RequestParam(value = "paymentid",defaultValue="无留言") String usercontent
    )throws Exception{
        ModelAndView mav=new ModelAndView();
        TMemberDO m =MemberUtils.getSessionLoginUser();
       TOrderDO order=tCartService.insertWebOrder(cartIds,addressid,paymentid,usercontent,m.getId(),m.getUsername());
//        Payment Payment=new Payment();
//        Payment.setIsDel(1);
//        List<Payment> payList=PaymentService.select(Payment);
//        mav.addObject("payList", payList);
        if(order==null){
            mav.setViewName("web/forwad");
        }else{
            mav.setViewName("web/success");
        }

        mav.addObject("order", order);
        return mav;
    }
}
