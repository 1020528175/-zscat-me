package com.zscat.shop.dao;

import com.zscat.shop.domain.TGoodSorderDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
@Mapper
public interface TGoodSorderDao {

	TGoodSorderDO get(Long id);
	
	List<TGoodSorderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TGoodSorderDO tGoodSorder);
	
	int update(TGoodSorderDO tGoodSorder);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
