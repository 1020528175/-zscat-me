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

import com.zscat.shop.domain.TopicDO;
import com.zscat.shop.service.TopicService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-18 13:12:04
 */
 
@Controller
@RequestMapping("/shop/topic")
public class TopicController {
	@Reference(version = "1.0.0")
	private TopicService topicService;
	
	@GetMapping()
	@RequiresPermissions("shop:topic:topic")
	String Topic(){
	    return "shop/topic/topic";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:topic:topic")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TopicDO> topicList = topicService.list(query);
		int total = topicService.count(query);
		PageUtils pageUtils = new PageUtils(topicList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:topic:add")
	String add(){
	    return "shop/topic/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:topic:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TopicDO topic = topicService.get(id);
		model.addAttribute("topic", topic);
	    return "shop/topic/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:topic:add")
	public R save( TopicDO topic){
		if(topicService.save(topic)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:topic:edit")
	public R update( TopicDO topic){
		topicService.update(topic);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:topic:remove")
	public R remove( Long id){
		if(topicService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:topic:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		topicService.batchRemove(ids);
		return R.ok();
	}
	
}
