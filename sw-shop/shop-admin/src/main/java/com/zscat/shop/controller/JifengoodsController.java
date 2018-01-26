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

import com.zscat.shop.domain.JifengoodsDO;
import com.zscat.shop.service.JifengoodsService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-11-29 20:40:38
 */
 
@Controller
@RequestMapping("/shop/jifengoods")
public class JifengoodsController {
	@Reference(version = "1.0.0")
	private JifengoodsService jifengoodsService;
	
	@GetMapping()
	@RequiresPermissions("shop:jifengoods:jifengoods")
	String Jifengoods(){
	    return "shop/jifengoods/jifengoods";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:jifengoods:jifengoods")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<JifengoodsDO> jifengoodsList = jifengoodsService.list(query);
		int total = jifengoodsService.count(query);
		PageUtils pageUtils = new PageUtils(jifengoodsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:jifengoods:add")
	String add(){
	    return "shop/jifengoods/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:jifengoods:edit")
	String edit(@PathVariable("id") Long id,Model model){
		JifengoodsDO jifengoods = jifengoodsService.get(id);
		model.addAttribute("jifengoods", jifengoods);
	    return "shop/jifengoods/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:jifengoods:add")
	public R save( JifengoodsDO jifengoods){
		if(jifengoodsService.save(jifengoods)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:jifengoods:edit")
	public R update( JifengoodsDO jifengoods){
		jifengoodsService.update(jifengoods);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:jifengoods:remove")
	public R remove( Long id){
		if(jifengoodsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:jifengoods:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		jifengoodsService.batchRemove(ids);
		return R.ok();
	}
	
}
