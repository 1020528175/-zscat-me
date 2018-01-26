package com.zscat.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.dao.TCommentDao;
import com.zscat.shop.domain.TCommentDO;
import com.zscat.shop.service.TCommentService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class TCommentServiceImpl implements TCommentService {
	@Autowired
	private TCommentDao tCommentDao;
	
	@Override
	public TCommentDO get(Long id){
		return tCommentDao.get(id);
	}
	
	@Override
	public List<TCommentDO> list(Map<String, Object> map){
		return tCommentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tCommentDao.count(map);
	}
	
	@Override
	public int save(TCommentDO tComment){
		return tCommentDao.save(tComment);
	}
	
	@Override
	public int update(TCommentDO tComment){
		return tCommentDao.update(tComment);
	}
	
	@Override
	public int remove(Long id){
		return tCommentDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tCommentDao.batchRemove(ids);
	}
	
}
