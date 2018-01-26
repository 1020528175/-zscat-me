package com.zscat.shop.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zscat.common.utils.ShiroUtils;
import com.zscat.shop.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zscat.shop.domain.TGoodsDO;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
 
@Controller
@RequestMapping("/shop/tGoods")
public class TGoodsController {
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
	@GetMapping()
	@RequiresPermissions("shop:tGoods:tGoods")
	String TGoods(){
	    return "shop/tGoods/tGoods";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:tGoods:tGoods")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TGoodsDO> tGoodsList = tGoodsService.list(query);
		int total = tGoodsService.count(query);
		PageUtils pageUtils = new PageUtils(tGoodsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:tGoods:add")
	String add(Model model){
		model.addAttribute("brandList",tBrandService.list(null));
		model.addAttribute("storeList",tStoreService.list(null));
		model.addAttribute("typeList",tGoodsTypeService.list(null));
	    return "shop/tGoods/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:tGoods:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TGoodsDO tGoods = tGoodsService.get(id);
		model.addAttribute("tGoods", tGoods);
	    return "shop/tGoods/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:tGoods:add")
	public R save( TGoodsDO tGoods){
		tGoods.setClickhit(0);tGoods.setReplyhit(0);tGoods.setSellhit(0);
		tGoods.setCreateDate(new Date());
		tGoods.setCreateBy(ShiroUtils.getUserId());
		String imgMore = tGoods.getImg();
		if(StringUtils.isNoneBlank(tGoods.getImg1())){
			imgMore=imgMore+","+tGoods.getImg1();
		}
		if(StringUtils.isNoneBlank(tGoods.getImg2())){
			imgMore=imgMore+","+tGoods.getImg2();
		}
		tGoods.setImgmore(imgMore);
		if(tGoodsService.save(tGoods)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:tGoods:edit")
	public R update( TGoodsDO tGoods){
		tGoodsService.update(tGoods);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:tGoods:remove")
	public R remove( Long id){
		if(tGoodsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:tGoods:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tGoodsService.batchRemove(ids);
		return R.ok();
	}
	
}
