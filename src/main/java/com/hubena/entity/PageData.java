/**
 * 
 */
package com.hubena.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 核心后台返回前台页面展示参数类
 * @author 曾谢波
 */
public class PageData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private boolean success;
	private String message;
	private Long count; 
	private List<?> rows;
	private Object data;
	
	public PageData(){
		
	}
	
	/**
	 * @param success
	 * @param message
	 */
	public PageData(boolean success, String message){
		this.success = success;
		this.message = message;
	}
	
	/**
	 * @param success
	 * @param message
	 * @param count
	 * @param rows
	 */
	public PageData(boolean success, String message, Long count, List<?> rows) {
		this(success, message);
		this.count = count;
		this.rows = rows;
	}
	
	/**
	 * @param success
	 * @param message
	 * @param count
	 * @param rows
	 * @param data
	 */
	public PageData(boolean success, String message, Long count, List<?> rows, Object data) {
		this(success, message, count, rows);
		this.data = data;
	}


	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}


	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}


	/**
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}


	/**
	 * @return the rows
	 */
	public List<?> getRows() {
		return rows;
	}


	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}


	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageData [success=" + success + ", message=" + message + ", count=" + count + ", rows=" + rows
				+ ", data=" + data + "]";
	}
	
}
