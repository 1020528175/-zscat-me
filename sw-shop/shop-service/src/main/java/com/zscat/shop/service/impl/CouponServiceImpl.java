package com.zscat.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import com.zscat.shop.dao.CouponDao;
import com.zscat.shop.domain.CouponDO;
import com.zscat.shop.service.CouponService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponDao couponDao;
	
	@Override
	public CouponDO get(Long id){
		return couponDao.get(id);
	}
	
	@Override
	public List<CouponDO> list(Map<String, Object> map){
		return couponDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return couponDao.count(map);
	}
	
	@Override
	public int save(CouponDO coupon){
		return couponDao.save(coupon);
	}
	
	@Override
	public int update(CouponDO coupon){
		return couponDao.update(coupon);
	}
	
	@Override
	public int remove(Long id){
		return couponDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return couponDao.batchRemove(ids);
	}

	@Override
	public List<CouponDO> userCoupon(Map<String, Object> map) {
		return couponDao.getUserCoupon(map);
	}


	@Override
	public int removeUserCoupon(Map<String, Object> map){
		return couponDao.removeUserCoupon(map);
	}
}
