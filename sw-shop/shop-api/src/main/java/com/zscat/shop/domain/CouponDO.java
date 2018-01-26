package com.zscat.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-18 13:12:04
 */
public class CouponDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Date addtime;
	//
	private Integer status;
	//
	private BigDecimal amount;
	//
	private Date beginTime;
	//
	private Integer couponCount;
	//
	private Date couponEndTime;
	//
	private String couponName;
	//
	private BigDecimal couponOrderAmount;
	//
	private String pic;
	//
	private int isReceive;

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
	 * 设置：
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取：
	 */
	public Date getAddtime() {
		return addtime;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	/**
	 * 获取：
	 */
	public Date getBeginTime() {
		return beginTime;
	}
	/**
	 * 设置：
	 */
	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}
	/**
	 * 获取：
	 */
	public Integer getCouponCount() {
		return couponCount;
	}
	/**
	 * 设置：
	 */
	public void setCouponEndTime(Date couponEndTime) {
		this.couponEndTime = couponEndTime;
	}
	/**
	 * 获取：
	 */
	public Date getCouponEndTime() {
		return couponEndTime;
	}
	/**
	 * 设置：
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	/**
	 * 获取：
	 */
	public String getCouponName() {
		return couponName;
	}
	/**
	 * 设置：
	 */
	public void setCouponOrderAmount(BigDecimal couponOrderAmount) {
		this.couponOrderAmount = couponOrderAmount;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getCouponOrderAmount() {
		return couponOrderAmount;
	}
	/**
	 * 设置：
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * 获取：
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * 设置：
	 */
	public void setIsReceive(int isReceive) {
		this.isReceive = isReceive;
	}
	/**
	 * 获取：
	 */
	public int getIsReceive() {
		return isReceive;
	}
}
