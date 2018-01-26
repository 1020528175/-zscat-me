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
public class JifengoodsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//名称
	private String title;
	//标签
	private String tag;
	//
	private String remark;
	//
	private String summary;
	//点击量
	private Integer clickhit;
	//
	private Long typeid;
	//图片
	private String img;
	//分类
	private Long classid;
	//价格
	private String prices;
	//
	private String imgmore;
	//创建时间
	private Date createDate;
	//评价量
	private Integer replyhit;
	//1推荐，2不推荐
	private Integer iscom;
	//
	private Long storeid;
	//有效期  天
	private Integer days;

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
	 * 设置：标签
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * 获取：标签
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * 获取：
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * 设置：点击量
	 */
	public void setClickhit(Integer clickhit) {
		this.clickhit = clickhit;
	}
	/**
	 * 获取：点击量
	 */
	public Integer getClickhit() {
		return clickhit;
	}
	/**
	 * 设置：
	 */
	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}
	/**
	 * 获取：
	 */
	public Long getTypeid() {
		return typeid;
	}
	/**
	 * 设置：图片
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：图片
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：分类
	 */
	public void setClassid(Long classid) {
		this.classid = classid;
	}
	/**
	 * 获取：分类
	 */
	public Long getClassid() {
		return classid;
	}
	/**
	 * 设置：价格
	 */
	public void setPrices(String prices) {
		this.prices = prices;
	}
	/**
	 * 获取：价格
	 */
	public String getPrices() {
		return prices;
	}
	/**
	 * 设置：
	 */
	public void setImgmore(String imgmore) {
		this.imgmore = imgmore;
	}
	/**
	 * 获取：
	 */
	public String getImgmore() {
		return imgmore;
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
	 * 设置：评价量
	 */
	public void setReplyhit(Integer replyhit) {
		this.replyhit = replyhit;
	}
	/**
	 * 获取：评价量
	 */
	public Integer getReplyhit() {
		return replyhit;
	}
	/**
	 * 设置：1推荐，2不推荐
	 */
	public void setIscom(Integer iscom) {
		this.iscom = iscom;
	}
	/**
	 * 获取：1推荐，2不推荐
	 */
	public Integer getIscom() {
		return iscom;
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
	 * 设置：有效期  天
	 */
	public void setDays(Integer days) {
		this.days = days;
	}
	/**
	 * 获取：有效期  天
	 */
	public Integer getDays() {
		return days;
	}
}
