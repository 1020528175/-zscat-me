package com.zscat.shop.dao;

import com.zscat.shop.domain.TFloorGoodsDO;

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
public interface TFloorGoodsDao {

	TFloorGoodsDO get(Long id);
	
	List<TFloorGoodsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TFloorGoodsDO tFloorGoods);
	
	int update(TFloorGoodsDO tFloorGoods);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
