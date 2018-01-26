package com.zscat.shop.service;

import com.zscat.shop.domain.TopicDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-18 13:12:04
 */
public interface TopicService {
	
	TopicDO get(Long id);
	
	List<TopicDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TopicDO topic);
	
	int update(TopicDO topic);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
