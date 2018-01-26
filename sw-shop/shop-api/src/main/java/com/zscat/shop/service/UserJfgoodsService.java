package com.zscat.shop.service;

import com.zscat.shop.domain.UserJfgoodsDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-11-30 18:40:31
 */
public interface UserJfgoodsService {
	
	UserJfgoodsDO get(Long id);
	
	List<UserJfgoodsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserJfgoodsDO userJfgoods);
	
	int update(UserJfgoodsDO userJfgoods);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
