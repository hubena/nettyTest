package com.hubena.entity;

import java.io.Serializable;

import org.springframework.util.StringUtils;

/**
 * 分页查询数据准备
 * @author 曾谢波
 * @since 2018年5月27日
 */
public class QueryPageData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/** 排序方式：asc */
	public static final String SORTTYPE_ASC = "asc";
	/** 排序方式：desc */
	public static final String SORTTYPE_DESC = "desc";

	private String whereField = " 1=1 "; // 查询条件

	private Long pageNo; // 当前页

	private Long pageSize; // 查询页数据量

	private String sortField; // 排序字段

	private String sortType; // 排序类型

	private String tableField; // 查询的表

	private String valueField; // 要查询的字段
	
	private Long endRow;// 结束数
	
	private Long offset;// 偏移数

	public QueryPageData() {
		
	}

	public QueryPageData(Long pageNo, Long pageSize, String sortField, String sortType) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.sortField = sortField;
		this.sortType = sortType;
	}

	public QueryPageData(Long pageNo, Long pageSize, String sortField, String sortType, String tableField, String valueField) {
		this(pageNo, pageSize, sortField, sortType);
		this.tableField = tableField;
		this.valueField = valueField;
	}

	public QueryPageData(String whereField) {
		this.whereField = whereField;
	}

	public QueryPageData(String tableField, String whereField) {
		this.tableField = tableField;
		this.whereField = whereField;
	}

	public QueryPageData(String tableField, String valueField, String whereField) {
		this(tableField, whereField);
		this.valueField = valueField;
	}

	public String getWhereField() {
		return whereField;
	}

	public void setWhereField(String whereField) {
		this.whereField = whereField;
	}

	public Long getPageNo() {
		return pageNo;
	}

	public void setPageNo(Long pageNo) {
		this.pageNo = pageNo;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public String getTableField() {
		return tableField;
	}

	public void setTableField(String tableField) {
		this.tableField = tableField;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}
	
	public Long getEndRow() {
		if (!StringUtils.isEmpty(this.pageNo) && !StringUtils.isEmpty(this.pageSize)) {
			this.endRow = this.pageNo * this.pageSize;
		} else {
			this.endRow = 10l;
		}
		return endRow;
	}

	public void setEndRow(Long endRow) {
		this.endRow = endRow;
	}

	public Long getOffset() {
		if (!StringUtils.isEmpty(this.pageNo) && !StringUtils.isEmpty(this.pageSize)) {
			this.offset = (this.pageNo - 1) * this.pageSize;
		} else {
			this.offset = 0l;
		}
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryPageData [whereField=" + whereField + ", pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", sortField=" + sortField + ", sortType=" + sortType + ", tableField=" + tableField + ", valueField="
				+ valueField + "]";
	}


}
