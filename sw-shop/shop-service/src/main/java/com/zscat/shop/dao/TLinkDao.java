package com.zscat.shop.dao;

import com.zscat.shop.domain.TLinkDO;

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
public interface TLinkDao {

	TLinkDO get(Integer id);
	
	List<TLinkDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TLinkDO tLink);
	
	int update(TLinkDO tLink);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
