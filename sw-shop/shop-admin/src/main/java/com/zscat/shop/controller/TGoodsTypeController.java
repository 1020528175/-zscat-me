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

import com.zscat.shop.domain.TGoodsTypeDO;
import com.zscat.shop.service.TGoodsTypeService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
 
@Controller
@RequestMapping("/shop/tGoodsType")
public class TGoodsTypeController {
	@Reference(version = "1.0.0")
	private TGoodsTypeService tGoodsTypeService;
	
	@GetMapping()
	@RequiresPermissions("shop:tGoodsType:tGoodsType")
	String TGoodsType(){
	    return "shop/tGoodsType/tGoodsType";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:tGoodsType:tGoodsType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TGoodsTypeDO> tGoodsTypeList = tGoodsTypeService.list(query);
		int total = tGoodsTypeService.count(query);
		PageUtils pageUtils = new PageUtils(tGoodsTypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:tGoodsType:add")
	String add(){
	    return "shop/tGoodsType/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:tGoodsType:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TGoodsTypeDO tGoodsType = tGoodsTypeService.get(id);
		model.addAttribute("tGoodsType", tGoodsType);
	    return "shop/tGoodsType/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:tGoodsType:add")
	public R save( TGoodsTypeDO tGoodsType){
		if(tGoodsTypeService.save(tGoodsType)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:tGoodsType:edit")
	public R update( TGoodsTypeDO tGoodsType){
		tGoodsTypeService.update(tGoodsType);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:tGoodsType:remove")
	public R remove( Long id){
		if(tGoodsTypeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:tGoodsType:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tGoodsTypeService.batchRemove(ids);
		return R.ok();
	}
	
}
