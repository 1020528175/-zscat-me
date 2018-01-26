package com.zscat.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.dao.TBrandDao;
import com.zscat.shop.domain.TBrandDO;
import com.zscat.shop.service.TBrandService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class TBrandServiceImpl implements TBrandService {
	@Autowired
	private TBrandDao tBrandDao;
	
	@Override
	public TBrandDO get(Long id){
		return tBrandDao.get(id);
	}
	
	@Override
	public List<TBrandDO> list(Map<String, Object> map){
		return tBrandDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tBrandDao.count(map);
	}
	
	@Override
	public int save(TBrandDO tBrand){
		return tBrandDao.save(tBrand);
	}
	
	@Override
	public int update(TBrandDO tBrand){
		return tBrandDao.update(tBrand);
	}
	
	@Override
	public int remove(Long id){
		return tBrandDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tBrandDao.batchRemove(ids);
	}
	@Override
	public
	List<TBrandDO> getBrandByFloorid(Long id){
		return tBrandDao.getBrandByFloorid(id);
	}
}
