package com.zscat.shop.service;

import com.zscat.shop.domain.TGoodsDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
public interface TGoodsService {
	
	TGoodsDO get(Long id);
	
	List<TGoodsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TGoodsDO tGoods);
	
	int update(TGoodsDO tGoods);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    List<TGoodsDO> list1(Map<String, Object> params);
	List<TGoodsDO> selectProductByFloor(Long id);

	List<TGoodsDO> getProductByFloorid(Long tid);

	List<TGoodsDO> selectgoodsListByType(Map<String, Object> map);

	List<TGoodsDO> selectGoodsByFloorLimit(Map<String, Object> map);
	//这里考虑代码的清晰，还是避免频繁的堆栈调用可选用不同的方式实现
	List<TGoodsDO> getProductListByPids(String[] pids) ;
}
