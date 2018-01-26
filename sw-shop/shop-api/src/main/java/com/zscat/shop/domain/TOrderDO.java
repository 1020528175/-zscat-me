package com.zscat.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:37
 */
public class TOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//总价格
	private BigDecimal totalprice;
	//总个数
	private Integer totalcount;
	//订单号
	private String ordersn;
	//状态 9 待付款  1待发货 2待收货 3 已完成  4 已取消
	private Integer status;
	//用户
	private Long userid;
	//
	private Long couponid;
	private Date createdate;
	//
	private Long paymentid;
	//
	private Long addressid;
	//
	private String username;
	//
	private String usercontent;
	private List<TGoodSorderDO> goodsList;

	public List<TGoodSorderDO> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<TGoodSorderDO> goodsList) {
		this.goodsList = goodsList;
	}

	public Long getCouponid() {
		return couponid;
	}

	public void setCouponid(Long couponid) {
		this.couponid = couponid;
	}

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：总价格
	 */
	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}
	/**
	 * 获取：总价格
	 */
	public BigDecimal getTotalprice() {
		return totalprice;
	}
	/**
	 * 设置：总个数
	 */
	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}
	/**
	 * 获取：总个数
	 */
	public Integer getTotalcount() {
		return totalcount;
	}
	/**
	 * 设置：订单号
	 */
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	/**
	 * 获取：订单号
	 */
	public String getOrdersn() {
		return ordersn;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：用户
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户
	 */
	public Long getUserid() {
		return userid;
	}
	/**
	 * 设置：
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：
	 */
	public void setPaymentid(Long paymentid) {
		this.paymentid = paymentid;
	}
	/**
	 * 获取：
	 */
	public Long getPaymentid() {
		return paymentid;
	}
	/**
	 * 设置：
	 */
	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}
	/**
	 * 获取：
	 */
	public Long getAddressid() {
		return addressid;
	}
	/**
	 * 设置：
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setUsercontent(String usercontent) {
		this.usercontent = usercontent;
	}
	/**
	 * 获取：
	 */
	public String getUsercontent() {
		return usercontent;
	}
}
