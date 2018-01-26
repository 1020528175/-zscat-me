package com.zscat.shop.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-11-29 20:40:38
 */
public class JifendataDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	private Long userid;
	//积分
	private Integer addcount;
	//时间
	private Date createdate;

	private String source;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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
	 * 设置：积分
	 */
	public void setAddcount(Integer addcount) {
		this.addcount = addcount;
	}
	/**
	 * 获取：积分
	 */
	public Integer getAddcount() {
		return addcount;
	}
	/**
	 * 设置：时间
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：时间
	 */
	public Date getCreatedate() {
		return createdate;
	}
}
