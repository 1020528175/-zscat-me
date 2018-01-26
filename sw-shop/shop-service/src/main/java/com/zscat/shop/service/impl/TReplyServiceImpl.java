package com.zscat.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.dao.TReplyDao;
import com.zscat.shop.domain.TReplyDO;
import com.zscat.shop.service.TReplyService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class TReplyServiceImpl implements TReplyService {
	@Autowired
	private TReplyDao tReplyDao;
	
	@Override
	public TReplyDO get(Long id){
		return tReplyDao.get(id);
	}
	
	@Override
	public List<TReplyDO> list(Map<String, Object> map){
		return tReplyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tReplyDao.count(map);
	}
	
	@Override
	public int save(TReplyDO tReply){
		return tReplyDao.save(tReply);
	}
	
	@Override
	public int update(TReplyDO tReply){
		return tReplyDao.update(tReply);
	}
	
	@Override
	public int remove(Long id){
		return tReplyDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tReplyDao.batchRemove(ids);
	}
	
}
