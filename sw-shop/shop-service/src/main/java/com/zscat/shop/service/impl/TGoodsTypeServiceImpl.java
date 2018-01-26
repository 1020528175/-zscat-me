package com.zscat.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.dao.TGoodsTypeDao;
import com.zscat.shop.domain.TGoodsTypeDO;
import com.zscat.shop.service.TGoodsTypeService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class TGoodsTypeServiceImpl implements TGoodsTypeService {
	@Autowired
	private TGoodsTypeDao tGoodsTypeDao;
	
	@Override
	public TGoodsTypeDO get(Long id){
		return tGoodsTypeDao.get(id);
	}
	
	@Override
	public List<TGoodsTypeDO> list(Map<String, Object> map){
		return tGoodsTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tGoodsTypeDao.count(map);
	}
	
	@Override
	public int save(TGoodsTypeDO tGoodsType){
		return tGoodsTypeDao.save(tGoodsType);
	}
	
	@Override
	public int update(TGoodsTypeDO tGoodsType){
		return tGoodsTypeDao.update(tGoodsType);
	}
	
	@Override
	public int remove(Long id){
		return tGoodsTypeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tGoodsTypeDao.batchRemove(ids);
	}
	
}
