package com.zscat.shop.domain;

import java.io.Serializable;


/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
public class TLinkDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//名称
	private String linkname;
	//url
	private String linkurl;
	//
	private Integer orderno;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：名称
	 */
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
	/**
	 * 获取：名称
	 */
	public String getLinkname() {
		return linkname;
	}
	/**
	 * 设置：url
	 */
	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}
	/**
	 * 获取：url
	 */
	public String getLinkurl() {
		return linkurl;
	}
	/**
	 * 设置：
	 */
	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}
	/**
	 * 获取：
	 */
	public Integer getOrderno() {
		return orderno;
	}
}
