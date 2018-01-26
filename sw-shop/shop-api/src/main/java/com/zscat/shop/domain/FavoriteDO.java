package com.zscat.shop.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-21 11:21:45
 */
public class FavoriteDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Date addtime;
	//
	private Integer deletestatus;
	//
	private Integer type;
	//
	private Long goodsid;
	//
	private Long storeid;
	//
	private Long userid;

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
	public void setDeletestatus(Integer deletestatus) {
		this.deletestatus = deletestatus;
	}
	/**
	 * 获取：
	 */
	public Integer getDeletestatus() {
		return deletestatus;
	}
	/**
	 * 设置：
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}
	/**
	 * 获取：
	 */
	public Long getGoodsid() {
		return goodsid;
	}
	/**
	 * 设置：
	 */
	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}
	/**
	 * 获取：
	 */
	public Long getStoreid() {
		return storeid;
	}
	/**
	 * 设置：
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：
	 */
	public Long getUserid() {
		return userid;
	}
}
