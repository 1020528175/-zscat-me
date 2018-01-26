package com.zscat.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:37
 */
public class TStoreDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Date addtime;
	//
	private Boolean deletestatus;
	//
	private String storeaddress;
	//
	private Integer storecredit;
	//
	private String storeinfo;
	//
	private String storemsn;
	//名称
	private String storename;
	//
	private String storeower;
	//
	private String storeqq;
	//
	private Boolean storerecommend;
	//
	private String storeseodescription;
	//
	private String storeseokeywords;
	//
	private Integer storestatus;
	//
	private String storetelephone;
	//
	private String storezip;
	//
	private String template;
	//
	private Long areaid;
	//
	private Long storebannerid;
	//
	private Long storelicenseid;
	//
	private String img;
	//
	private Integer favoritecount;
	//
	private BigDecimal storelat;
	//
	private BigDecimal storelng;
	//
	private String storeww;
	//
	private String maptype;
	//
	private Long storedistribution;

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
	public void setDeletestatus(Boolean deletestatus) {
		this.deletestatus = deletestatus;
	}
	/**
	 * 获取：
	 */
	public Boolean getDeletestatus() {
		return deletestatus;
	}
	/**
	 * 设置：
	 */
	public void setStoreaddress(String storeaddress) {
		this.storeaddress = storeaddress;
	}
	/**
	 * 获取：
	 */
	public String getStoreaddress() {
		return storeaddress;
	}
	/**
	 * 设置：
	 */
	public void setStorecredit(Integer storecredit) {
		this.storecredit = storecredit;
	}
	/**
	 * 获取：
	 */
	public Integer getStorecredit() {
		return storecredit;
	}
	/**
	 * 设置：
	 */
	public void setStoreinfo(String storeinfo) {
		this.storeinfo = storeinfo;
	}
	/**
	 * 获取：
	 */
	public String getStoreinfo() {
		return storeinfo;
	}
	/**
	 * 设置：
	 */
	public void setStoremsn(String storemsn) {
		this.storemsn = storemsn;
	}
	/**
	 * 获取：
	 */
	public String getStoremsn() {
		return storemsn;
	}
	/**
	 * 设置：名称
	 */
	public void setStorename(String storename) {
		this.storename = storename;
	}
	/**
	 * 获取：名称
	 */
	public String getStorename() {
		return storename;
	}
	/**
	 * 设置：
	 */
	public void setStoreower(String storeower) {
		this.storeower = storeower;
	}
	/**
	 * 获取：
	 */
	public String getStoreower() {
		return storeower;
	}
	/**
	 * 设置：
	 */
	public void setStoreqq(String storeqq) {
		this.storeqq = storeqq;
	}
	/**
	 * 获取：
	 */
	public String getStoreqq() {
		return storeqq;
	}
	/**
	 * 设置：
	 */
	public void setStorerecommend(Boolean storerecommend) {
		this.storerecommend = storerecommend;
	}
	/**
	 * 获取：
	 */
	public Boolean getStorerecommend() {
		return storerecommend;
	}
	/**
	 * 设置：
	 */
	public void setStoreseodescription(String storeseodescription) {
		this.storeseodescription = storeseodescription;
	}
	/**
	 * 获取：
	 */
	public String getStoreseodescription() {
		return storeseodescription;
	}
	/**
	 * 设置：
	 */
	public void setStoreseokeywords(String storeseokeywords) {
		this.storeseokeywords = storeseokeywords;
	}
	/**
	 * 获取：
	 */
	public String getStoreseokeywords() {
		return storeseokeywords;
	}
	/**
	 * 设置：
	 */
	public void setStorestatus(Integer storestatus) {
		this.storestatus = storestatus;
	}
	/**
	 * 获取：
	 */
	public Integer getStorestatus() {
		return storestatus;
	}
	/**
	 * 设置：
	 */
	public void setStoretelephone(String storetelephone) {
		this.storetelephone = storetelephone;
	}
	/**
	 * 获取：
	 */
	public String getStoretelephone() {
		return storetelephone;
	}
	/**
	 * 设置：
	 */
	public void setStorezip(String storezip) {
		this.storezip = storezip;
	}
	/**
	 * 获取：
	 */
	public String getStorezip() {
		return storezip;
	}
	/**
	 * 设置：
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
	/**
	 * 获取：
	 */
	public String getTemplate() {
		return template;
	}
	/**
	 * 设置：
	 */
	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}
	/**
	 * 获取：
	 */
	public Long getAreaid() {
		return areaid;
	}
	/**
	 * 设置：
	 */
	public void setStorebannerid(Long storebannerid) {
		this.storebannerid = storebannerid;
	}
	/**
	 * 获取：
	 */
	public Long getStorebannerid() {
		return storebannerid;
	}
	/**
	 * 设置：
	 */
	public void setStorelicenseid(Long storelicenseid) {
		this.storelicenseid = storelicenseid;
	}
	/**
	 * 获取：
	 */
	public Long getStorelicenseid() {
		return storelicenseid;
	}
	/**
	 * 设置：
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：
	 */
	public void setFavoritecount(Integer favoritecount) {
		this.favoritecount = favoritecount;
	}
	/**
	 * 获取：
	 */
	public Integer getFavoritecount() {
		return favoritecount;
	}
	/**
	 * 设置：
	 */
	public void setStorelat(BigDecimal storelat) {
		this.storelat = storelat;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getStorelat() {
		return storelat;
	}
	/**
	 * 设置：
	 */
	public void setStorelng(BigDecimal storelng) {
		this.storelng = storelng;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getStorelng() {
		return storelng;
	}
	/**
	 * 设置：
	 */
	public void setStoreww(String storeww) {
		this.storeww = storeww;
	}
	/**
	 * 获取：
	 */
	public String getStoreww() {
		return storeww;
	}
	/**
	 * 设置：
	 */
	public void setMaptype(String maptype) {
		this.maptype = maptype;
	}
	/**
	 * 获取：
	 */
	public String getMaptype() {
		return maptype;
	}
	/**
	 * 设置：
	 */
	public void setStoredistribution(Long storedistribution) {
		this.storedistribution = storedistribution;
	}
	/**
	 * 获取：
	 */
	public Long getStoredistribution() {
		return storedistribution;
	}
}
