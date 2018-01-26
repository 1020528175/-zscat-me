package com.zscat.shop.service;


import com.zscat.shop.Constan;
import com.zscat.shop.domain.JifendataDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-11-29 20:40:38
 */
public interface JifendataService {
	
	JifendataDO get(Long id);
	
	List<JifendataDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(JifendataDO jifendata);
	int save(Constan addjifen);
	
	int update(JifendataDO jifendata);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
