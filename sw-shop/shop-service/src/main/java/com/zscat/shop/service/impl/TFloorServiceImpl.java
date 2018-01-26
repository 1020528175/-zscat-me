package com.zscat.shop.service.impl;

import com.zscat.shop.dao.TFloorDao;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.domain.TFloorDO;
import com.zscat.shop.service.TFloorService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class TFloorServiceImpl implements TFloorService {
	@Autowired
	private TFloorDao tFloorDao;
	
	@Override
	public TFloorDO get(Long id){
		return tFloorDao.get(id);
	}
	
	@Override
	public List<TFloorDO> list(Map<String, Object> map){
		return tFloorDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tFloorDao.count(map);
	}
	
	@Override
	public int save(TFloorDO tFloor){
		return tFloorDao.save(tFloor);
	}
	
	@Override
	public int update(TFloorDO tFloor){
		return tFloorDao.update(tFloor);
	}
	
	@Override
	public int remove(Long id){
		return tFloorDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tFloorDao.batchRemove(ids);
	}
	
}
