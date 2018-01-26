package com.zscat.shop.dao;

import com.zscat.shop.domain.TBrandDO;

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
public interface TBrandDao {

	TBrandDO get(Long id);
	
	List<TBrandDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TBrandDO tBrand);
	
	int update(TBrandDO tBrand);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    List<TBrandDO> getBrandByFloorid(Long id);
}
