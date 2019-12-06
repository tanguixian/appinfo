package cn.sq.appinfo.entity;

import java.util.List;

public class Page {

	// 当前是多少页
	private Integer pageNo = 1;
	// 每一页显示多少条数据
	private Integer pagesize = 3;
	// 数据库总记录数
	private Integer rows;
	// 一共多少页
	private Integer pages;
	// 存放片段数据集合
	private List list;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
		setPages();
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
		setPages();
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages() {
		if(rows!=null&&pagesize!=null) {
			if (rows % pagesize == 0) {
				pages= rows / pagesize;
			} else {
				pages= rows / pagesize + 1;
			}
		}
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Page(Integer pageNo, Integer pagesize, Integer rows, Integer pages, List list) {
		super();
		this.pageNo = pageNo;
		this.pagesize = pagesize;
		this.rows = rows;
		this.pages = pages;
		this.list = list;
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 获取每一页第一条下标
	public Integer getFirst() {
		return (pageNo - 1) * pagesize;
	}

	// 下一页
	public Integer getNext() {
		if (pageNo == getPages()) {
			return pageNo;
		} else {
			return pageNo + 1;
		}
	}

	// 上一页
	public Integer getPrev() {
		if (pageNo == 1) {
			return pageNo;

		} else {
			return pageNo - 1;
		}
	}
}
