package com.zscat.shop.controller;

import java.util.List;
import java.util.Map;

import com.zscat.shop.service.TCartService;
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
import com.zscat.shop.domain.AddressDO;
import com.zscat.shop.service.AddressService;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-20 11:41:11
 */
 
@Controller
@RequestMapping("/shop/address")
public class AddressController {
	@Reference(version = "1.0.0")
	private AddressService addressService;
	@Reference(version = "1.0.0")
	private TCartService tCartService;
	@GetMapping()
	@RequiresPermissions("shop:address:address")
	String Address(){
	    return "shop/address/address";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:address:address")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AddressDO> addressList = addressService.list(query);
		int total = addressService.count(query);
		PageUtils pageUtils = new PageUtils(addressList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:address:add")
	String add(){
	    return "shop/address/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:address:edit")
	String edit(@PathVariable("id") Long id,Model model){
		AddressDO address = addressService.get(id);
		model.addAttribute("address", address);
	    return "shop/address/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:address:add")
	public R save( AddressDO address){
		if(addressService.save(address)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:address:edit")
	public R update( AddressDO address){
		addressService.update(address);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:address:remove")
	public R remove( Long id){
		if(addressService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:address:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		addressService.batchRemove(ids);
		return R.ok();
	}
	
}
