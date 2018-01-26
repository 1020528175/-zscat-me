package com.zscat.shop.service.impl;

import com.zscat.shop.dao.UserJfgoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.domain.UserJfgoodsDO;
import com.zscat.shop.service.UserJfgoodsService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class UserJfgoodsServiceImpl implements UserJfgoodsService {
	@Autowired
	private UserJfgoodsDao userJfgoodsDao;
	
	@Override
	public UserJfgoodsDO get(Long id){
		return userJfgoodsDao.get(id);
	}
	
	@Override
	public List<UserJfgoodsDO> list(Map<String, Object> map){
		return userJfgoodsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userJfgoodsDao.count(map);
	}
	
	@Override
	public int save(UserJfgoodsDO userJfgoods){
		return userJfgoodsDao.save(userJfgoods);
	}
	
	@Override
	public int update(UserJfgoodsDO userJfgoods){
		return userJfgoodsDao.update(userJfgoods);
	}
	
	@Override
	public int remove(Long id){
		return userJfgoodsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userJfgoodsDao.batchRemove(ids);
	}
	
}
