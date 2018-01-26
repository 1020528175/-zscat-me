package com.zscat.shop.service.impl;

import com.zscat.shop.dao.JifengoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.domain.JifengoodsDO;
import com.zscat.shop.service.JifengoodsService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class JifengoodsServiceImpl implements JifengoodsService {
	@Autowired
	private JifengoodsDao jifengoodsDao;
	
	@Override
	public JifengoodsDO get(Long id){
		return jifengoodsDao.get(id);
	}
	
	@Override
	public List<JifengoodsDO> list(Map<String, Object> map){
		return jifengoodsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return jifengoodsDao.count(map);
	}
	
	@Override
	public int save(JifengoodsDO jifengoods){
		return jifengoodsDao.save(jifengoods);
	}
	
	@Override
	public int update(JifengoodsDO jifengoods){
		return jifengoodsDao.update(jifengoods);
	}
	
	@Override
	public int remove(Long id){
		return jifengoodsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return jifengoodsDao.batchRemove(ids);
	}
	
}
