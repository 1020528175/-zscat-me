package com.zscat.shop.service.impl;

import com.zsCat.common.common.utils.RandomString;
import com.zscat.shop.dao.TGoodsDao;
import com.zscat.shop.dao.TOrderLogDao;
import com.zscat.shop.domain.TGoodsDO;
import com.zscat.shop.domain.TOrderLogDO;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zscat.shop.dao.TOrderDao;
import com.zscat.shop.domain.TOrderDO;
import com.zscat.shop.service.TOrderService;



@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class TOrderServiceImpl implements TOrderService {
	@Autowired
	private TOrderDao tOrderDao;
	@Autowired
	private TOrderLogDao tOrderLogDao;
	@Autowired
	private TGoodsDao tGoodsDao;
	
	@Override
	public TOrderDO get(Long id){
		return tOrderDao.get(id);
	}
	
	@Override
	public List<TOrderDO> list(Map<String, Object> map){
		return tOrderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tOrderDao.count(map);
	}
	
	@Override
	public int save(TOrderDO tOrder){
		return tOrderDao.save(tOrder);
	}
	
	@Override
	public int update(TOrderDO tOrder){
		return tOrderDao.update(tOrder);
	}
	
	@Override
	public int remove(Long id){
		return tOrderDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tOrderDao.batchRemove(ids);
	}

	@Override
	public TOrderDO insertWapOrder(Long productId, Long addressid, Long paymentid, String usercontent, Long id, String username) {
		TOrderDO order=new TOrderDO();
		TGoodsDO p =tGoodsDao.get(productId);
		order.setOrdersn(RandomString.generateRandomString(8));
		order.setCreatedate(new Date());
		order.setStatus(1);
		order.setUserid(id);
		order.setUsername(username);
		order.setPaymentid(paymentid);
		order.setUsercontent(usercontent);
		order.setAddressid(addressid);
		order.setTotalcount(1);
		order.setTotalprice(BigDecimal.valueOf(Double.valueOf(p.getPrices())));
		tOrderDao.save(order);

		TOrderLogDO log=new TOrderLogDO();
		log.setOrderId(order.getId());
		log.setOrderState("1");
		log.setStateInfo("提交订单");
		log.setCreateTime(new Date().getTime());
		log.setOperator(username);
		tOrderLogDao.save(log);

		return order;
	}

}
