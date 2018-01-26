package com.zscat.shop.service.impl;

import com.zscat.shop.dao.TArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.domain.TArticleDO;
import com.zscat.shop.service.TArticleService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class TArticleServiceImpl implements TArticleService {
	@Autowired
	private TArticleDao tArticleDao;
	
	@Override
	public TArticleDO get(Long id){
		return tArticleDao.get(id);
	}
	
	@Override
	public List<TArticleDO> list(Map<String, Object> map){
		return tArticleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tArticleDao.count(map);
	}
	
	@Override
	public int save(TArticleDO tArticle){
		return tArticleDao.save(tArticle);
	}
	
	@Override
	public int update(TArticleDO tArticle){
		return tArticleDao.update(tArticle);
	}
	
	@Override
	public int remove(Long id){
		return tArticleDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tArticleDao.batchRemove(ids);
	}
	
}
