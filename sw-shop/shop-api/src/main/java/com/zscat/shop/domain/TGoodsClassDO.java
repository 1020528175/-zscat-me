package com.zscat.shop.domain;

import java.io.Serializable;
import java.util.List;


/**
 * 商品分类表
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
public class TGoodsClassDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//索引ID
	private Long id;
	//分类名称
	private String name;
	//分类图片
	private String pic;
	//前台显示，0为否，1为是，默认为1
	private String delFlag;
	//名称
	private String title;
	//
	private Long pid;
	//
	private String parentIds;
	private List<TGoodsClassDO> childs;

	public List<TGoodsClassDO> getChilds() {
		return childs;
	}

	public void setChilds(List<TGoodsClassDO> childs) {
		this.childs = childs;
	}

	/**
	 * 设置：索引ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：索引ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：分类名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：分类名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：分类图片
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * 获取：分类图片
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * 设置：前台显示，0为否，1为是，默认为1
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：前台显示，0为否，1为是，默认为1
	 */
	public String getDelFlag() {
		return delFlag;
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
	 * 设置：
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public Long getPid() {
		return pid;
	}
	/**
	 * 设置：
	 */
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	/**
	 * 获取：
	 */
	public String getParentIds() {
		return parentIds;
	}

	@Override
	public String toString() {
		return "TGoodsClassDO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pic='" + pic + '\'' +
				", delFlag='" + delFlag + '\'' +
				", title='" + title + '\'' +
				", pid=" + pid +
				", parentIds='" + parentIds + '\'' +
				", childs=" + childs +
				'}';
	}
}
