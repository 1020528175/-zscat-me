package com.zscat.shop.service;

import com.zscat.shop.domain.TFloorDO;

import java.util.List;
import java.util.Map;

/**
 * 商品类型表
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
public interface TFloorService {
	
	TFloorDO get(Long id);
	
	List<TFloorDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TFloorDO tFloor);
	
	int update(TFloorDO tFloor);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
