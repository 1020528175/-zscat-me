package com.zscat.shop.dao;

import com.zscat.shop.domain.TGoodsDO;

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
public interface TGoodsDao {

	TGoodsDO get(Long id);
	
	List<TGoodsDO> list(Map<String, Object> map);
	List<TGoodsDO> list1(Map<String, Object> map);
	int count(Map<String, Object> map);
	
	int save(TGoodsDO tGoods);
	
	int update(TGoodsDO tGoods);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	List<TGoodsDO> selectGoodsByFloorLimit(Map<String, Object> map);

	List<TGoodsDO> getProductByFloorid(Long tid);

	List<TGoodsDO> selectgoodsListByType(Map<String, Object> map);
}
