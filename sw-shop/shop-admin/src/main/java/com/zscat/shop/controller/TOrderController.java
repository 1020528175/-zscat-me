package com.zscat.shop.controller;

import java.util.List;
import java.util.Map;

import com.zsCat.common.common.utils.PageUtils;
import com.zsCat.common.common.utils.R;
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

import com.zscat.shop.domain.TOrderDO;
import com.zscat.shop.service.TOrderService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:37
 */
 
@Controller
@RequestMapping("/shop/tOrder")
public class TOrderController {
	@Reference(version = "1.0.0")
	private TOrderService tOrderService;
	
	@GetMapping()
	@RequiresPermissions("shop:tOrder:tOrder")
	String TOrder(){
	    return "shop/tOrder/tOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:tOrder:tOrder")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TOrderDO> tOrderList = tOrderService.list(query);
		int total = tOrderService.count(query);
		PageUtils pageUtils = new PageUtils(tOrderList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:tOrder:add")
	String add(){
	    return "shop/tOrder/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:tOrder:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TOrderDO tOrder = tOrderService.get(id);
		model.addAttribute("tOrder", tOrder);
	    return "shop/tOrder/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:tOrder:add")
	public R save( TOrderDO tOrder){
		if(tOrderService.save(tOrder)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:tOrder:edit")
	public R update( TOrderDO tOrder){
		tOrderService.update(tOrder);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:tOrder:remove")
	public R remove( Long id){
		if(tOrderService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:tOrder:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tOrderService.batchRemove(ids);
		return R.ok();
	}
	
}
