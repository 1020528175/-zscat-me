package com.zscat.shop.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zscat.shop.dao.AddressDao;
import com.zscat.shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Map;


import com.zscat.shop.domain.AddressDO;




@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public AddressDO get(Long id){
		return addressDao.get(id);
	}
	
	@Override
	public List<AddressDO> list(Map<String, Object> map){
		return addressDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return addressDao.count(map);
	}
	
	@Override
	public int save(AddressDO address){
		return addressDao.save(address);
	}
	
	@Override
	public int update(AddressDO address){
		return addressDao.update(address);
	}
	
	@Override
	public int remove(Long id){
		return addressDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return addressDao.batchRemove(ids);
	}

	@Override
	public AddressDO selectOne(Map<String, Object> params) {
		List<AddressDO> list = addressDao.list(params);
		if (list!=null && list.size()>0){
			return  list.get(0);
		}
		return null;
	}

}
