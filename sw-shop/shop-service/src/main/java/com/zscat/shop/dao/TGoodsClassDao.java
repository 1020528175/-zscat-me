package com.zscat.shop.dao;

import com.zscat.shop.domain.TGoodsClassDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类表
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
@Mapper
public interface TGoodsClassDao {

	TGoodsClassDO get(Long id);
	
	List<TGoodsClassDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TGoodsClassDO tGoodsClass);
	
	int update(TGoodsClassDO tGoodsClass);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
