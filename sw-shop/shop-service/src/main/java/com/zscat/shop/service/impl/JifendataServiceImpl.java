package com.zscat.shop.service.impl;


import com.zscat.shop.dao.JifendataDao;
import com.zscat.shop.Constan;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.domain.JifendataDO;
import com.zscat.shop.service.JifendataService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class JifendataServiceImpl implements JifendataService {
	@Autowired
	private JifendataDao jifendataDao;
	//@Autowired
	//private UserService userService;
	@Override
	public JifendataDO get(Long id){
		return jifendataDao.get(id);
	}
	
	@Override
	public List<JifendataDO> list(Map<String, Object> map){
		return jifendataDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return jifendataDao.count(map);
	}
	
	@Override
	public int save(JifendataDO jifendata){
		return jifendataDao.save(jifendata);
	}
	@Override
	public int save(Constan addjifen){
//		UserDO m = MemberUtils.getSessionLoginUser();
//		if (m!=null){
//			JifendataDO jifendata = new JifendataDO();
//			jifendata.setAddcount(addjifen.getCode());
//			jifendata.setSource(addjifen.getMsg());
//			jifendata.setCreatedate(new Date());
//			jifendata.setUserid(m.getUserId());
//			m.setJifen(m.getJifen()+addjifen.getCode());
//			userService.updateOnly(m);
//			return jifendataDao.save(jifendata);
//		}
		return 1;
	}
	
	@Override
	public int update(JifendataDO jifendata){
		return jifendataDao.update(jifendata);
	}
	
	@Override
	public int remove(Long id){
		return jifendataDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return jifendataDao.batchRemove(ids);
	}
	
}
