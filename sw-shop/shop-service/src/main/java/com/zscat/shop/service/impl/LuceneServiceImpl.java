package com.zscat.shop.service.impl;


import com.zsCat.common.common.utils.PageUtils;

import com.zsCat.common.lucene.IndexObject;
import com.zsCat.common.lucene.LuceneDao;
import com.zscat.shop.service.LuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;


/**
 * Description:luncene
 *
 * @author Jin
 * @create 2017-06-06
 **/
@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class LuceneServiceImpl implements LuceneService {

    @Autowired
    private LuceneDao luceneDao;


    @Override
    public void save(IndexObject indexObject) {
        luceneDao.create(indexObject);
    }


    @Override
    public void update(IndexObject indexObject) {
        luceneDao.update(indexObject);
    }

    @Override
    public void delete(IndexObject indexObject) {
        luceneDao.deleteAll();
    }

    @Override
    public PageUtils page(Integer pageNumber, Integer pageSize, String keyword) {
        return luceneDao.page(pageNumber,pageSize,keyword);
    }
}
