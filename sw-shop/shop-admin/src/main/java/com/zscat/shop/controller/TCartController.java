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

import com.zscat.shop.domain.TCartDO;
import com.zscat.shop.service.TCartService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
 
@Controller
@RequestMapping("/shop/tCart")
public class TCartController {
	@Reference(version = "1.0.0")
	private TCartService tCartService;
	
	@GetMapping()
	@RequiresPermissions("shop:tCart:tCart")
	String TCart(){
	    return "shop/tCart/tCart";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:tCart:tCart")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TCartDO> tCartList = tCartService.list(query);
		int total = tCartService.count(query);
		PageUtils pageUtils = new PageUtils(tCartList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:tCart:add")
	String add(){
	    return "shop/tCart/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:tCart:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TCartDO tCart = tCartService.get(id);
		model.addAttribute("tCart", tCart);
	    return "shop/tCart/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:tCart:add")
	public R save( TCartDO tCart){
		if(tCartService.save(tCart)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:tCart:edit")
	public R update( TCartDO tCart){
		tCartService.update(tCart);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:tCart:remove")
	public R remove( Long id){
		if(tCartService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:tCart:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tCartService.batchRemove(ids);
		return R.ok();
	}
	
}
