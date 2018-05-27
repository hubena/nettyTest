/**
 * 
 */
package com.hubena.entity;

import java.io.Serializable;

/**
 * request请求实体类父类
 * @author 曾谢波
 * @since 2018年5月27日
 */
public class RequestDataBase implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String value1;
	private String value2;
	
	/**
	 * @return the value1
	 */
	public String getValue1() {
		return value1;
	}
	/**
	 * @param value1 the value1 to set
	 */
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	/**
	 * @return the value2
	 */
	public String getValue2() {
		return value2;
	}
	/**
	 * @param value2 the value2 to set
	 */
	public void setValue2(String value2) {
		this.value2 = value2;
	}
 
	@Override
	public String toString() {
		return "RequestData [value1=" + value1 + ", value2=" + value2 + "]";
	}
}
