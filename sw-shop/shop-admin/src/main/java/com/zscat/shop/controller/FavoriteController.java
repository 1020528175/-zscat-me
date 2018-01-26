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

import com.zscat.shop.domain.FavoriteDO;
import com.zscat.shop.service.FavoriteService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-21 11:21:45
 */
 
@Controller
@RequestMapping("/shop/favorite")
public class FavoriteController {
	@Reference(version = "1.0.0")
	private FavoriteService favoriteService;
	
	@GetMapping()
	@RequiresPermissions("shop:favorite:favorite")
	String Favorite(){
	    return "shop/favorite/favorite";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:favorite:favorite")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FavoriteDO> favoriteList = favoriteService.list(query);
		int total = favoriteService.count(query);
		PageUtils pageUtils = new PageUtils(favoriteList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:favorite:add")
	String add(){
	    return "shop/favorite/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:favorite:edit")
	String edit(@PathVariable("id") Long id,Model model){
		FavoriteDO favorite = favoriteService.get(id);
		model.addAttribute("favorite", favorite);
	    return "shop/favorite/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:favorite:add")
	public R save( FavoriteDO favorite){
		if(favoriteService.save(favorite)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:favorite:edit")
	public R update( FavoriteDO favorite){
		favoriteService.update(favorite);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:favorite:remove")
	public R remove( Long id){
		if(favoriteService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:favorite:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		favoriteService.batchRemove(ids);
		return R.ok();
	}
	
}
