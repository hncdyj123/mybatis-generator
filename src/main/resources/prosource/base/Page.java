package com.sym.ams.domain.base;
/**
 * 翻页请求实体
 * 
 * @author hncdyj123@163.com
 * @date 2015年12月5日 下午1:05:00
 *
 */
public class Page {
	/** 当前页 **/
	private int page;
	/** 每页条数 **/
	private int rows;
	/** 起始行号 **/
	private Integer pageNo;
	/** 每页条数 **/
	private Integer pageSize;

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}

	public Integer getPageNo() {
		pageNo = (page - 1) * rows;
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		pageSize = rows;
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
