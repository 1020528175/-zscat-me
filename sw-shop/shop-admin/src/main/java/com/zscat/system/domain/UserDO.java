package com.zscat.system.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 *
 *
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-11-29 20:40:38
 */
public class UserDO implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Long userId;
	//用户名
	private String username;
	//
	private String name;
	//密码
	private String password;
	//
	private Long deptId;
	//邮箱
	private String email;
	//手机号
	private String mobile;
	//状态 0:禁用，1:正常
	private Integer status;
	//创建用户id
	private Long userIdCreate;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModified;
	//
	private Integer balance;
	//
	private Long storeid;
	//
	private Integer jifen;
	//
	private String img;
	//
	private String wxOpenId;
	//
	private String wxUnionid;
	//
	private String wxAvatar;
	private String deptName;
	//角色
	private List<Long> roleIds;
	private String token;



	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<Long> getroleIds() {
		return roleIds;
	}

	public void setroleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
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
	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：状态 0:禁用，1:正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0:禁用，1:正常
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建用户id
	 */
	public void setUserIdCreate(Long userIdCreate) {
		this.userIdCreate = userIdCreate;
	}
	/**
	 * 获取：创建用户id
	 */
	public Long getUserIdCreate() {
		return userIdCreate;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
	/**
	 * 设置：
	 */
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	/**
	 * 获取：
	 */
	public Integer getBalance() {
		return balance;
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
	public void setJifen(Integer jifen) {
		this.jifen = jifen;
	}
	/**
	 * 获取：
	 */
	public Integer getJifen() {
		return jifen;
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
	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}
	/**
	 * 获取：
	 */
	public String getWxOpenId() {
		return wxOpenId;
	}
	/**
	 * 设置：
	 */
	public void setWxUnionid(String wxUnionid) {
		this.wxUnionid = wxUnionid;
	}
	/**
	 * 获取：
	 */
	public String getWxUnionid() {
		return wxUnionid;
	}
	/**
	 * 设置：
	 */
	public void setWxAvatar(String wxAvatar) {
		this.wxAvatar = wxAvatar;
	}
	/**
	 * 获取：
	 */
	public String getWxAvatar() {
		return wxAvatar;
	}
}
