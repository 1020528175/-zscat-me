package com.zscat.common.service.impl;

import java.util.List;
import com.alibaba.dubbo.config.annotation.Reference;
import com.zsCat.common.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zscat.common.dao.LogDao;
import com.zscat.common.domain.LogDO;
import com.zscat.common.domain.PageDO;
import com.zscat.common.service.LogService;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	LogDao logMapper;

	@Override
	public PageDO<LogDO> queryList(Query query) {
		int total = logMapper.count(query);
//		int limit = query.getLimit();
//		
//		if(total<=query.getOffset()) {
//			System.out.println(total +"-----"+query.getOffset());
//			query.setOffset((total/limit-2)*limit);
//			System.out.println(query.getOffset());
//		}
		List<LogDO> logs = logMapper.list(query);
		PageDO<LogDO> page = new PageDO<>();
		page.setTotal(total);
		page.setRows(logs);
		return page;
	}

	@Override
	public int remove(Long id) {
		int count = logMapper.remove(id);
		return count;
	}

	@Override
	public int batchRemove(Long[] ids){
		return logMapper.batchRemove(ids);
	}
}
