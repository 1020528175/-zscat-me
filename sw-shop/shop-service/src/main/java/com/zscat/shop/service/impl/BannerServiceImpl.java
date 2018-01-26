package com.zscat.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.dao.BannerDao;
import com.zscat.shop.domain.BannerDO;
import com.zscat.shop.service.BannerService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class BannerServiceImpl implements BannerService {
	@Autowired
	private BannerDao bannerDao;
	
	@Override
	public BannerDO get(Long id){
		return bannerDao.get(id);
	}
	
	@Override
	public List<BannerDO> list(Map<String, Object> map){
		return bannerDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bannerDao.count(map);
	}
	
	@Override
	public int save(BannerDO banner){
		return bannerDao.save(banner);
	}
	
	@Override
	public int update(BannerDO banner){
		return bannerDao.update(banner);
	}
	
	@Override
	public int remove(Long id){
		return bannerDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return bannerDao.batchRemove(ids);
	}
	
}
