package com.zscat.shop.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
public class TGoodsDO implements Serializable {
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
	private String img1;
	private String img2;
	//类型
	private String typename;
	//分类
	private Long classid;
	//
	private String orderby;
	//价格
	private String prices;
	//
	private String imgmore;
	//创建者
	private Long createBy;
	//创建时间
	private Date createDate;
	//删除标记(0活null 正常 1,删除)
	private String delFlag;
	//评价量
	private Integer replyhit;
	//销售量
	private Integer sellhit;
	//销售量
	private Integer collecthit;
	//1推荐，2不推荐
	private Integer iscom;
	//
	private Long storeid;
	//
	private String storename;
	//
	private Long brandid;
	private String imgs[];// 多图  详情中截取
	private  Integer 	is_favorite;//1已收藏

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public Integer getIs_favorite() {
		return is_favorite;
	}

	public void setIs_favorite(Integer is_favorite) {
		this.is_favorite = is_favorite;
	}

	public String[] getImgs() {
		return imgs;
	}

	public void setImgs(String[] imgs) {
		this.imgs = imgs;
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
	 * 设置：类型
	 */
	public void setTypename(String typename) {
		this.typename = typename;
	}
	/**
	 * 获取：类型
	 */
	public String getTypename() {
		return typename;
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
	 * 设置：
	 */
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	/**
	 * 获取：
	 */
	public String getOrderby() {
		return orderby;
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
	 * 设置：创建者
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建者
	 */
	public Long getCreateBy() {
		return createBy;
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
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：删除标记(0活null 正常 1,删除)
	 */
	public String getDelFlag() {
		return delFlag;
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
	 * 设置：销售量
	 */
	public void setSellhit(Integer sellhit) {
		this.sellhit = sellhit;
	}
	/**
	 * 获取：销售量
	 */
	public Integer getSellhit() {
		return sellhit;
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
	 * 设置：
	 */
	public void setStorename(String storename) {
		this.storename = storename;
	}
	/**
	 * 获取：
	 */
	public String getStorename() {
		return storename;
	}
	/**
	 * 设置：
	 */
	public void setBrandid(Long brandid) {
		this.brandid = brandid;
	}
	/**
	 * 获取：
	 */
	public Long getBrandid() {
		return brandid;
	}
}
