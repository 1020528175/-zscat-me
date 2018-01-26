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

import com.zscat.shop.domain.JifendataDO;
import com.zscat.shop.service.JifendataService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-11-29 20:40:38
 */
 
@Controller
@RequestMapping("/shop/jifendata")
public class JifendataController {
	@Reference(version = "1.0.0")
	private JifendataService jifendataService;
	
	@GetMapping()
	@RequiresPermissions("shop:jifendata:jifendata")
	String Jifendata(){
	    return "shop/jifendata/jifendata";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:jifendata:jifendata")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<JifendataDO> jifendataList = jifendataService.list(query);
		int total = jifendataService.count(query);
		PageUtils pageUtils = new PageUtils(jifendataList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:jifendata:add")
	String add(){
	    return "shop/jifendata/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:jifendata:edit")
	String edit(@PathVariable("id") Long id,Model model){
		JifendataDO jifendata = jifendataService.get(id);
		model.addAttribute("jifendata", jifendata);
	    return "shop/jifendata/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:jifendata:add")
	public R save( JifendataDO jifendata){
		if(jifendataService.save(jifendata)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:jifendata:edit")
	public R update( JifendataDO jifendata){
		jifendataService.update(jifendata);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:jifendata:remove")
	public R remove( Long id){
		if(jifendataService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:jifendata:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		jifendataService.batchRemove(ids);
		return R.ok();
	}
	
}
