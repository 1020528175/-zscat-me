package com.zscat.shop.controller;
import com.zsCat.common.common.utils.*;
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

import com.zscat.shop.domain.UserJfgoodsDO;
import com.zscat.shop.service.UserJfgoodsService;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-11-30 18:40:31
 */
 
@Controller
@RequestMapping("/shop/userJfgoods")
public class UserJfgoodsController {
	@Reference(version = "1.0.0")
	private UserJfgoodsService userJfgoodsService;
	
	@GetMapping()
	@RequiresPermissions("shop:userJfgoods:userJfgoods")
	String UserJfgoods(){
	    return "shop/userJfgoods/userJfgoods";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:userJfgoods:userJfgoods")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserJfgoodsDO> userJfgoodsList = userJfgoodsService.list(query);
		int total = userJfgoodsService.count(query);
		PageUtils pageUtils = new PageUtils(userJfgoodsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:userJfgoods:add")
	String add(){
	    return "shop/userJfgoods/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:userJfgoods:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UserJfgoodsDO userJfgoods = userJfgoodsService.get(id);
		model.addAttribute("userJfgoods", userJfgoods);
	    return "shop/userJfgoods/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:userJfgoods:add")
	public R save( UserJfgoodsDO userJfgoods){
		if(userJfgoodsService.save(userJfgoods)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:userJfgoods:edit")
	public R update( UserJfgoodsDO userJfgoods){
		userJfgoodsService.update(userJfgoods);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:userJfgoods:remove")
	public R remove( Long id){
		if(userJfgoodsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:userJfgoods:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		userJfgoodsService.batchRemove(ids);
		return R.ok();
	}
	
}
