package com.zscat.shop.service;

import com.zscat.shop.domain.TReplyDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:37
 */
public interface TReplyService {
	
	TReplyDO get(Long id);
	
	List<TReplyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TReplyDO tReply);
	
	int update(TReplyDO tReply);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
