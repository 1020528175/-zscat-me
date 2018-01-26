package com.zscat.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.dao.ArticleDao;
import com.zscat.shop.domain.ArticleDO;
import com.zscat.shop.service.ArticleService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public ArticleDO get(Long id){
		return articleDao.get(id);
	}
	
	@Override
	public List<ArticleDO> list(Map<String, Object> map){
		return articleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return articleDao.count(map);
	}
	
	@Override
	public int save(ArticleDO article){
		return articleDao.save(article);
	}
	
	@Override
	public int update(ArticleDO article){
		return articleDao.update(article);
	}
	
	@Override
	public int remove(Long id){
		return articleDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return articleDao.batchRemove(ids);
	}
	
}
