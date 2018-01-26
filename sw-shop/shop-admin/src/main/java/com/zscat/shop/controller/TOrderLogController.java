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

import com.zscat.shop.domain.TOrderLogDO;
import com.zscat.shop.service.TOrderLogService;
import com.zsCat.common.common.utils.*;
/**
 * 订单处理历史表
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:37
 */
 
@Controller
@RequestMapping("/shop/tOrderLog")
public class TOrderLogController {
	@Reference(version = "1.0.0")
	private TOrderLogService tOrderLogService;
	
	@GetMapping()
	@RequiresPermissions("shop:tOrderLog:tOrderLog")
	String TOrderLog(){
	    return "shop/tOrderLog/tOrderLog";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:tOrderLog:tOrderLog")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TOrderLogDO> tOrderLogList = tOrderLogService.list(query);
		int total = tOrderLogService.count(query);
		PageUtils pageUtils = new PageUtils(tOrderLogList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:tOrderLog:add")
	String add(){
	    return "shop/tOrderLog/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:tOrderLog:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TOrderLogDO tOrderLog = tOrderLogService.get(id);
		model.addAttribute("tOrderLog", tOrderLog);
	    return "shop/tOrderLog/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:tOrderLog:add")
	public R save( TOrderLogDO tOrderLog){
		if(tOrderLogService.save(tOrderLog)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:tOrderLog:edit")
	public R update( TOrderLogDO tOrderLog){
		tOrderLogService.update(tOrderLog);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:tOrderLog:remove")
	public R remove( Long id){
		if(tOrderLogService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:tOrderLog:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tOrderLogService.batchRemove(ids);
		return R.ok();
	}
	
}
