package com.zscat.shop.domain;

import java.io.Serializable;


/**
 * 订单处理历史表
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:37
 */
public class TOrderLogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//订单处理历史索引id
	private Long id;
	//订单id
	private Long orderId;
	//订单状态信息
	private String orderState;
	//下一步订单状态信息
	private String changeState;
	//订单状态描述
	private String stateInfo;
	//处理时间
	private Long createTime;
	//操作人
	private String operator;

	/**
	 * 设置：订单处理历史索引id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：订单处理历史索引id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：订单id
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单id
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：订单状态信息
	 */
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	/**
	 * 获取：订单状态信息
	 */
	public String getOrderState() {
		return orderState;
	}
	/**
	 * 设置：下一步订单状态信息
	 */
	public void setChangeState(String changeState) {
		this.changeState = changeState;
	}
	/**
	 * 获取：下一步订单状态信息
	 */
	public String getChangeState() {
		return changeState;
	}
	/**
	 * 设置：订单状态描述
	 */
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	/**
	 * 获取：订单状态描述
	 */
	public String getStateInfo() {
		return stateInfo;
	}
	/**
	 * 设置：处理时间
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：处理时间
	 */
	public Long getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：操作人
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * 获取：操作人
	 */
	public String getOperator() {
		return operator;
	}
}
