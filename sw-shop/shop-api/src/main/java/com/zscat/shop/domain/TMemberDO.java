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
public class TMemberDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//姓名
	private String username;
	//密码
	private String password;
	//
	private Date addtime;
	//电话
	private String phone;
	//QQ
	private String qq;
	//EMAIL
	private String email;
	//昵称
	private String truename;
	//金币
	private Integer gold;
	//状态
	private Integer status;
	//
	private String address;
	//商铺
	private Long storeid;
private String sex;
private String img;
	//
	private Integer balance;

	//
	private Integer jifen;

	//
	private String wxOpenId;
	//
	private String wxUnionid;
	//
	private String wxAvatar;


	private String token;
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getJifen() {
		return jifen;
	}

	public void setJifen(Integer jifen) {
		this.jifen = jifen;
	}

	public String getWxOpenId() {
		return wxOpenId;
	}

	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}

	public String getWxUnionid() {
		return wxUnionid;
	}

	public void setWxUnionid(String wxUnionid) {
		this.wxUnionid = wxUnionid;
	}

	public String getWxAvatar() {
		return wxAvatar;
	}

	public void setWxAvatar(String wxAvatar) {
		this.wxAvatar = wxAvatar;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
	 * 设置：姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：姓名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
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
	 * 设置：电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：QQ
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * 获取：QQ
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * 设置：EMAIL
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：EMAIL
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：昵称
	 */
	public void setTruename(String truename) {
		this.truename = truename;
	}
	/**
	 * 获取：昵称
	 */
	public String getTruename() {
		return truename;
	}
	/**
	 * 设置：金币
	 */
	public void setGold(Integer gold) {
		this.gold = gold;
	}
	/**
	 * 获取：金币
	 */
	public Integer getGold() {
		return gold;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：商铺
	 */
	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}
	/**
	 * 获取：商铺
	 */
	public Long getStoreid() {
		return storeid;
	}
}
