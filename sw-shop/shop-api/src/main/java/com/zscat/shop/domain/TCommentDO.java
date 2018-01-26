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
public class TCommentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//IP
	private String userip;
	//
	private Integer blogid;
	//内容
	private String content;
	//时间
	private Date commentdate;
	//状态
	private Integer state;
	//博客
	private Long bloggerId;
	//标题
	private String title;
	//回答者
	private String blogger;

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
	 * 设置：IP
	 */
	public void setUserip(String userip) {
		this.userip = userip;
	}
	/**
	 * 获取：IP
	 */
	public String getUserip() {
		return userip;
	}
	/**
	 * 设置：
	 */
	public void setBlogid(Integer blogid) {
		this.blogid = blogid;
	}
	/**
	 * 获取：
	 */
	public Integer getBlogid() {
		return blogid;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：时间
	 */
	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}
	/**
	 * 获取：时间
	 */
	public Date getCommentdate() {
		return commentdate;
	}
	/**
	 * 设置：状态
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：状态
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：博客
	 */
	public void setBloggerId(Long bloggerId) {
		this.bloggerId = bloggerId;
	}
	/**
	 * 获取：博客
	 */
	public Long getBloggerId() {
		return bloggerId;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：回答者
	 */
	public void setBlogger(String blogger) {
		this.blogger = blogger;
	}
	/**
	 * 获取：回答者
	 */
	public String getBlogger() {
		return blogger;
	}
}
