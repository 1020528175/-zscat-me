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

import com.zscat.shop.domain.TReplyDO;
import com.zscat.shop.service.TReplyService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:37
 */
 
@Controller
@RequestMapping("/shop/tReply")
public class TReplyController {
	@Reference(version = "1.0.0")
	private TReplyService tReplyService;
	
	@GetMapping()
	@RequiresPermissions("shop:tReply:tReply")
	String TReply(){
	    return "shop/tReply/tReply";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:tReply:tReply")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TReplyDO> tReplyList = tReplyService.list(query);
		int total = tReplyService.count(query);
		PageUtils pageUtils = new PageUtils(tReplyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:tReply:add")
	String add(){
	    return "shop/tReply/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:tReply:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TReplyDO tReply = tReplyService.get(id);
		model.addAttribute("tReply", tReply);
	    return "shop/tReply/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:tReply:add")
	public R save( TReplyDO tReply){
		if(tReplyService.save(tReply)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:tReply:edit")
	public R update( TReplyDO tReply){
		tReplyService.update(tReply);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:tReply:remove")
	public R remove( Long id){
		if(tReplyService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:tReply:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tReplyService.batchRemove(ids);
		return R.ok();
	}
	
}
