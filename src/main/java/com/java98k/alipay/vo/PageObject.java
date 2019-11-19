package com.java98k.alipay.vo;
import java.io.Serializable;
import java.util.List;
/**
 * POJO:
 * 值对象(VO):(Value Object)
 * @param <T>
 */
public class PageObject<T> implements Serializable{//类泛型
	private static final long serialVersionUID = -7368493786259905794L;
	/**当前页要呈现的记录*/
	private List<T> records;
	/**总记录数*/
	private Integer rowCount=0;
	/**总页数*/
	private Integer pageCount=0;
	/**当前页码*/
	private Integer pageCurrent=1;
	/**页面大小(每页最多显示多少条记录)*/
	private Integer pageSize=3;
	//........
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
