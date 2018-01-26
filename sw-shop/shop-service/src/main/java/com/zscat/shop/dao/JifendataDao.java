package com.zscat.shop.dao;

import com.zscat.shop.domain.JifendataDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-11-29 20:40:38
 */
@Mapper
public interface JifendataDao {

	JifendataDO get(Long id);
	
	List<JifendataDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(JifendataDO jifendata);
	
	int update(JifendataDO jifendata);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
