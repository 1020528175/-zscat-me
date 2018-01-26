package com.zscat.shop.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-18 13:12:04
 */
public class TopicDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//名称
	private String title;
	//创建时间
	private Date createDate;
	//删除标记(0活null 正常 1,删除)
	private String stat;
	private String img;
	private Integer clickhit;
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getClickhit() {
		return clickhit;
	}

	public void setClickhit(Integer clickhit) {
		this.clickhit = clickhit;
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
	 * 设置：名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：删除标记(0活null 正常 1,删除)
	 */
	public void setStat(String stat) {
		this.stat = stat;
	}
	/**
	 * 获取：删除标记(0活null 正常 1,删除)
	 */
	public String getStat() {
		return stat;
	}
}
