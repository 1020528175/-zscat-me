package com.zsCat.common.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 */
public class PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	// 总记录数
	private int total;
	// 列表数据
	private List<?> rows;

	/**
	 * 分页
	 * 
	 * @param list
	 *            列表数据

	 * @param total
	 *            每页记录数
	 * @param list
	 *            当前页数
	 */
	public PageUtils(List<?> list, int total) {
		this.rows = list;
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageUtils{" +
				"total=" + total +
				", rows=" + rows +
				'}';
	}
}
