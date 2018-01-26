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

import com.zscat.shop.domain.TFloorDO;
import com.zscat.shop.service.TFloorService;
import com.zsCat.common.common.utils.*;
/**
 * 商品类型表
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
 
@Controller
@RequestMapping("/shop/tFloor")
public class TFloorController {
	@Reference(version = "1.0.0")
	private TFloorService tFloorService;
	
	@GetMapping()
	@RequiresPermissions("shop:tFloor:tFloor")
	String TFloor(){
	    return "shop/tFloor/tFloor";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:tFloor:tFloor")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TFloorDO> tFloorList = tFloorService.list(query);
		int total = tFloorService.count(query);
		PageUtils pageUtils = new PageUtils(tFloorList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:tFloor:add")
	String add(){
	    return "shop/tFloor/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:tFloor:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TFloorDO tFloor = tFloorService.get(id);
		model.addAttribute("tFloor", tFloor);
	    return "shop/tFloor/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:tFloor:add")
	public R save( TFloorDO tFloor){
		if(tFloorService.save(tFloor)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:tFloor:edit")
	public R update( TFloorDO tFloor){
		tFloorService.update(tFloor);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:tFloor:remove")
	public R remove( Long id){
		if(tFloorService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:tFloor:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tFloorService.batchRemove(ids);
		return R.ok();
	}
	
}
