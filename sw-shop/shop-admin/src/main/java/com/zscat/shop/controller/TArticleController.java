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

import com.zscat.shop.domain.TArticleDO;
import com.zscat.shop.service.TArticleService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
 
@Controller
@RequestMapping("/shop/tArticle")
public class TArticleController {
	@Reference(version = "1.0.0")
	private TArticleService tArticleService;
	
	@GetMapping()
	@RequiresPermissions("shop:tArticle:tArticle")
	String TArticle(){
	    return "shop/tArticle/tArticle";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:tArticle:tArticle")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TArticleDO> tArticleList = tArticleService.list(query);
		int total = tArticleService.count(query);
		PageUtils pageUtils = new PageUtils(tArticleList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:tArticle:add")
	String add(){
	    return "shop/tArticle/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:tArticle:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TArticleDO tArticle = tArticleService.get(id);
		model.addAttribute("tArticle", tArticle);
	    return "shop/tArticle/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:tArticle:add")
	public R save( TArticleDO tArticle){
		if(tArticleService.save(tArticle)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:tArticle:edit")
	public R update( TArticleDO tArticle){
		tArticleService.update(tArticle);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:tArticle:remove")
	public R remove( Long id){
		if(tArticleService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:tArticle:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tArticleService.batchRemove(ids);
		return R.ok();
	}
	
}
