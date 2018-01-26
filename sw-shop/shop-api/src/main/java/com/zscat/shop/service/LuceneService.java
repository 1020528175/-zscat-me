package com.zscat.shop.service;


import com.zsCat.common.common.utils.PageUtils;
import com.zsCat.common.lucene.IndexObject;


public interface LuceneService {

    void save(IndexObject indexObject);

    void update(IndexObject indexObject);

    void delete(IndexObject indexObject);

    PageUtils page(Integer pageNumber, Integer pageSize, String keyword);
}
