package com.hubena.entity;

import java.io.Serializable;

public class JsonResult implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean success;
	
	private String message;
	
	private Object data;

	public JsonResult() {}

	public JsonResult(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public JsonResult(boolean success, String message, Object data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [success=" + success + ", message=" + message + ", data=" + data + "]";
	}


	

}
