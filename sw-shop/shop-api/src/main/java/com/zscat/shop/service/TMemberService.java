package com.zscat.shop.service;

import com.zscat.shop.domain.TMemberDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
public interface TMemberService {
	
	TMemberDO get(Long id);
	
	List<TMemberDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TMemberDO tMember);
	
	int update(TMemberDO tMember);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    TMemberDO checkUser(String username, String password);

	TMemberDO selectOne(Map<String, Object> params);
}
