package com.zscat.shop.domain;

import java.io.Serializable;


/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-20 11:41:11
 */
public class AddressDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long userid;
	//姓名
	private String name;
	//地址
	private String detail;
	//电话
	private String mobile;
	//
	private Integer isdefault;// 0默认

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
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：
	 */
	public Long getUserid() {
		return userid;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：地址
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * 获取：地址
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * 设置：电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：电话
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：
	 */
	public void setIsdefault(Integer isdefault) {
		this.isdefault = isdefault;
	}
	/**
	 * 获取：
	 */
	public Integer getIsdefault() {
		return isdefault;
	}
}
