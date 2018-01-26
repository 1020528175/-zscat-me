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

import com.zscat.shop.domain.TLinkDO;
import com.zscat.shop.service.TLinkService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
 
@Controller
@RequestMapping("/shop/tLink")
public class TLinkController {
	@Reference(version = "1.0.0")
	private TLinkService tLinkService;
	
	@GetMapping()
	@RequiresPermissions("shop:tLink:tLink")
	String TLink(){
	    return "shop/tLink/tLink";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:tLink:tLink")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TLinkDO> tLinkList = tLinkService.list(query);
		int total = tLinkService.count(query);
		PageUtils pageUtils = new PageUtils(tLinkList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:tLink:add")
	String add(){
	    return "shop/tLink/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:tLink:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		TLinkDO tLink = tLinkService.get(id);
		model.addAttribute("tLink", tLink);
	    return "shop/tLink/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:tLink:add")
	public R save( TLinkDO tLink){
		if(tLinkService.save(tLink)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:tLink:edit")
	public R update( TLinkDO tLink){
		tLinkService.update(tLink);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:tLink:remove")
	public R remove( Integer id){
		if(tLinkService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:tLink:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		tLinkService.batchRemove(ids);
		return R.ok();
	}
	
}
