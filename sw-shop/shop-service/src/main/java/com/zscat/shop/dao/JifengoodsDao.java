package com.zscat.shop.dao;

import com.zscat.shop.domain.JifengoodsDO;

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
public interface JifengoodsDao {

	JifengoodsDO get(Long id);
	
	List<JifengoodsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(JifengoodsDO jifengoods);
	
	int update(JifengoodsDO jifengoods);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
