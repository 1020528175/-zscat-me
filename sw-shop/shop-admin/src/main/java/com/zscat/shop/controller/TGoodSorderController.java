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

import com.zscat.shop.domain.TGoodSorderDO;
import com.zscat.shop.service.TGoodSorderService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
 
@Controller
@RequestMapping("/shop/tGoodSorder")
public class TGoodSorderController {
	@Reference(version = "1.0.0")
	private TGoodSorderService tGoodSorderService;
	
	@GetMapping()
	@RequiresPermissions("shop:tGoodSorder:tGoodSorder")
	String TGoodSorder(){
	    return "shop/tGoodSorder/tGoodSorder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:tGoodSorder:tGoodSorder")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TGoodSorderDO> tGoodSorderList = tGoodSorderService.list(query);
		int total = tGoodSorderService.count(query);
		PageUtils pageUtils = new PageUtils(tGoodSorderList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:tGoodSorder:add")
	String add(){
	    return "shop/tGoodSorder/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:tGoodSorder:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TGoodSorderDO tGoodSorder = tGoodSorderService.get(id);
		model.addAttribute("tGoodSorder", tGoodSorder);
	    return "shop/tGoodSorder/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:tGoodSorder:add")
	public R save( TGoodSorderDO tGoodSorder){
		if(tGoodSorderService.save(tGoodSorder)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:tGoodSorder:edit")
	public R update( TGoodSorderDO tGoodSorder){
		tGoodSorderService.update(tGoodSorder);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:tGoodSorder:remove")
	public R remove( Long id){
		if(tGoodSorderService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:tGoodSorder:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tGoodSorderService.batchRemove(ids);
		return R.ok();
	}
	
}
