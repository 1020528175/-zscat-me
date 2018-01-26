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

import com.zscat.shop.domain.TMemberDO;
import com.zscat.shop.service.TMemberService;
import com.zsCat.common.common.utils.*;
/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
 
@Controller
@RequestMapping("/shop/tMember")
public class TMemberController {
	@Reference(version = "1.0.0")
	private TMemberService tMemberService;
	
	@GetMapping()
	@RequiresPermissions("shop:tMember:tMember")
	String TMember(){
	    return "shop/tMember/tMember";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:tMember:tMember")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TMemberDO> tMemberList = tMemberService.list(query);
		int total = tMemberService.count(query);
		PageUtils pageUtils = new PageUtils(tMemberList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:tMember:add")
	String add(){
	    return "shop/tMember/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:tMember:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TMemberDO tMember = tMemberService.get(id);
		model.addAttribute("tMember", tMember);
	    return "shop/tMember/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:tMember:add")
	public R save( TMemberDO tMember){
		if(tMemberService.save(tMember)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:tMember:edit")
	public R update( TMemberDO tMember){
		tMemberService.update(tMember);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:tMember:remove")
	public R remove( Long id){
		if(tMemberService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:tMember:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tMemberService.batchRemove(ids);
		return R.ok();
	}
	
}
