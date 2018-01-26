package com.zscat.shop.controller;

import java.util.List;
import java.util.Map;

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
import com.zsCat.common.common.utils.*;
import com.zscat.shop.domain.BannerDO;
import com.zscat.shop.service.BannerService;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-18 10:31:32
 */
 
@Controller
@RequestMapping("/shop/banner")
public class BannerController {
	@Reference(version = "1.0.0")
	private BannerService bannerService;
	
	@GetMapping()
	@RequiresPermissions("shop:banner:banner")
	String Banner(){
	    return "shop/banner/banner";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:banner:banner")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BannerDO> bannerList = bannerService.list(query);
		int total = bannerService.count(query);
		PageUtils pageUtils = new PageUtils(bannerList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:banner:add")
	String add(){
	    return "shop/banner/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:banner:edit")
	String edit(@PathVariable("id") Long id,Model model){
		BannerDO banner = bannerService.get(id);
		model.addAttribute("banner", banner);
	    return "shop/banner/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:banner:add")
	public R save( BannerDO banner){
		if(bannerService.save(banner)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:banner:edit")
	public R update( BannerDO banner){
		bannerService.update(banner);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:banner:remove")
	public R remove( Long id){
		if(bannerService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:banner:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		bannerService.batchRemove(ids);
		return R.ok();
	}
	
}
