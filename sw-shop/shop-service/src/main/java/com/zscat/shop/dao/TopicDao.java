package com.zscat.shop.dao;

import com.zscat.shop.domain.TopicDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-18 13:12:04
 */
@Mapper
public interface TopicDao {

	TopicDO get(Long id);
	
	List<TopicDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TopicDO topic);
	
	int update(TopicDO topic);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
