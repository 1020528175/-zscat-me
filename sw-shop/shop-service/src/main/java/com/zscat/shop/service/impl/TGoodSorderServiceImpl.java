package com.zscat.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.dao.TGoodSorderDao;
import com.zscat.shop.domain.TGoodSorderDO;
import com.zscat.shop.service.TGoodSorderService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class TGoodSorderServiceImpl implements TGoodSorderService {
	@Autowired
	private TGoodSorderDao tGoodSorderDao;
	
	@Override
	public TGoodSorderDO get(Long id){
		return tGoodSorderDao.get(id);
	}
	
	@Override
	public List<TGoodSorderDO> list(Map<String, Object> map){
		return tGoodSorderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tGoodSorderDao.count(map);
	}
	
	@Override
	public int save(TGoodSorderDO tGoodSorder){
		return tGoodSorderDao.save(tGoodSorder);
	}
	
	@Override
	public int update(TGoodSorderDO tGoodSorder){
		return tGoodSorderDao.update(tGoodSorder);
	}
	
	@Override
	public int remove(Long id){
		return tGoodSorderDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tGoodSorderDao.batchRemove(ids);
	}
	
}
