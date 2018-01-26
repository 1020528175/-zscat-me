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

import com.zscat.shop.domain.ArticleDO;
import com.zscat.shop.service.ArticleService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-18 13:12:04
 */
 
@Controller
@RequestMapping("/shop/article")
public class ArticleController {
	@Reference(version = "1.0.0")
	private ArticleService articleService;
	
	@GetMapping()
	@RequiresPermissions("shop:article:article")
	String Article(){
	    return "shop/article/article";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:article:article")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ArticleDO> articleList = articleService.list(query);
		int total = articleService.count(query);
		PageUtils pageUtils = new PageUtils(articleList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:article:add")
	String add(){
	    return "shop/article/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:article:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ArticleDO article = articleService.get(id);
		model.addAttribute("article", article);
	    return "shop/article/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:article:add")
	public R save( ArticleDO article){
		if(articleService.save(article)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:article:edit")
	public R update( ArticleDO article){
		articleService.update(article);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:article:remove")
	public R remove( Long id){
		if(articleService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:article:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		articleService.batchRemove(ids);
		return R.ok();
	}
	
}
