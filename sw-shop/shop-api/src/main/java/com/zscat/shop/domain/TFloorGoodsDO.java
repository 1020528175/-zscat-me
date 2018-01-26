package com.zscat.shop.domain;

import java.io.Serializable;


/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
public class TFloorGoodsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long productid;
	//
	private Long floorid;

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
	public void setProductid(Long productid) {
		this.productid = productid;
	}
	/**
	 * 获取：
	 */
	public Long getProductid() {
		return productid;
	}
	/**
	 * 设置：
	 */
	public void setFloorid(Long floorid) {
		this.floorid = floorid;
	}
	/**
	 * 获取：
	 */
	public Long getFloorid() {
		return floorid;
	}
}
