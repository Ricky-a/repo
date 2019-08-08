package com.crm.entity;

/**
 * 
 * @author admin
 *
 */
public class Page {

	/**
	 * 当前第几页
	 */
	private int page;

	/**
	 * 每页显示记录数
	 */
	private int rows;

	/**
	 * 第几条记录起始
	 */
	private int firstPage;

	public Page(int page, int rows) {
		this.page = page;
		this.rows = rows;
	}

	public Page(int page, int rows, int firstPage) {
		super();
		this.page = page;
		this.rows = rows;
		this.firstPage = firstPage;
	}

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

	public int getFirstPage() {
		firstPage = (page - 1) * rows;
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", rows=" + rows + ", firstPage=" + firstPage + "]";
	}

}
