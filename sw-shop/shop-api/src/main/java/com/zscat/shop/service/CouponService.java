package com.zscat.shop.service;

import com.zscat.shop.domain.CouponDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-18 13:12:04
 */
public interface CouponService {
	
	CouponDO get(Long id);
	
	List<CouponDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CouponDO coupon);
	
	int update(CouponDO coupon);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	int removeUserCoupon(Map<String, Object> map);
	List<CouponDO> userCoupon(Map<String, Object> map);
}
