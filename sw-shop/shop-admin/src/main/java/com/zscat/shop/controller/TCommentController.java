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

import com.zscat.shop.domain.TCommentDO;
import com.zscat.shop.service.TCommentService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
 
@Controller
@RequestMapping("/shop/tComment")
public class TCommentController {
	@Reference(version = "1.0.0")
	private TCommentService tCommentService;
	
	@GetMapping()
	@RequiresPermissions("shop:tComment:tComment")
	String TComment(){
	    return "shop/tComment/tComment";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:tComment:tComment")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TCommentDO> tCommentList = tCommentService.list(query);
		int total = tCommentService.count(query);
		PageUtils pageUtils = new PageUtils(tCommentList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:tComment:add")
	String add(){
	    return "shop/tComment/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:tComment:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TCommentDO tComment = tCommentService.get(id);
		model.addAttribute("tComment", tComment);
	    return "shop/tComment/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:tComment:add")
	public R save( TCommentDO tComment){
		if(tCommentService.save(tComment)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:tComment:edit")
	public R update( TCommentDO tComment){
		tCommentService.update(tComment);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:tComment:remove")
	public R remove( Long id){
		if(tCommentService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:tComment:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tCommentService.batchRemove(ids);
		return R.ok();
	}
	
}
