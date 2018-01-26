package com.zscat.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.dao.TFloorGoodsDao;
import com.zscat.shop.domain.TFloorGoodsDO;
import com.zscat.shop.service.TFloorGoodsService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class TFloorGoodsServiceImpl implements TFloorGoodsService {
	@Autowired
	private TFloorGoodsDao tFloorGoodsDao;
	
	@Override
	public TFloorGoodsDO get(Long id){
		return tFloorGoodsDao.get(id);
	}
	
	@Override
	public List<TFloorGoodsDO> list(Map<String, Object> map){
		return tFloorGoodsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tFloorGoodsDao.count(map);
	}
	
	@Override
	public int save(TFloorGoodsDO tFloorGoods){
		return tFloorGoodsDao.save(tFloorGoods);
	}
	
	@Override
	public int update(TFloorGoodsDO tFloorGoods){
		return tFloorGoodsDao.update(tFloorGoods);
	}
	
	@Override
	public int remove(Long id){
		return tFloorGoodsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tFloorGoodsDao.batchRemove(ids);
	}
	
}
