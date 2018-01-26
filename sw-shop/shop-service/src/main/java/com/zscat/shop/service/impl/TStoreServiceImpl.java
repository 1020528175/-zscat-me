package com.zscat.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.dao.TStoreDao;
import com.zscat.shop.domain.TStoreDO;
import com.zscat.shop.service.TStoreService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class TStoreServiceImpl implements TStoreService {
	@Autowired
	private TStoreDao tStoreDao;
	
	@Override
	public TStoreDO get(Long id){
		return tStoreDao.get(id);
	}
	
	@Override
	public List<TStoreDO> list(Map<String, Object> map){
		return tStoreDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tStoreDao.count(map);
	}
	
	@Override
	public int save(TStoreDO tStore){
		return tStoreDao.save(tStore);
	}
	
	@Override
	public int update(TStoreDO tStore){
		return tStoreDao.update(tStore);
	}
	
	@Override
	public int remove(Long id){
		return tStoreDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tStoreDao.batchRemove(ids);
	}
	
}
