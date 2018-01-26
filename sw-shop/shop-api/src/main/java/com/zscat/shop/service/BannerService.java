package com.zscat.shop.service;

import com.zscat.shop.domain.BannerDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-18 10:31:32
 */
public interface BannerService {
	
	BannerDO get(Long id);
	
	List<BannerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BannerDO banner);
	
	int update(BannerDO banner);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
