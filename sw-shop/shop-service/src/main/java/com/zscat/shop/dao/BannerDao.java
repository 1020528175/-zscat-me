package com.zscat.shop.dao;

import com.zscat.shop.domain.BannerDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-18 10:31:32
 */
@Mapper
public interface BannerDao {

	BannerDO get(Long id);
	
	List<BannerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BannerDO banner);
	
	int update(BannerDO banner);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
