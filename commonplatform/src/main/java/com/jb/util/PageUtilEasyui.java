package com.jb.util;

/**
 * @author Administrator
 *
 * @param <T>
 */

public class PageUtilEasyui<T> {
	
	//搜索扩展
	private T t;
	
	//当前页
	private static Integer page;
	
	//每页条数
	private static Integer rows;
	
	public static int getStartIndex() {
		return ( page -1) * rows;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
}
