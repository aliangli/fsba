package com.ulysses.base.bean;

import java.util.Map;

/**
 *  返回对象
 * @author Administrator
 *
 */
public class ResponseObj {
	private boolean success;
	private String info;
	private Map<String, Object> data;
	
	public static ResponseObj getObj(boolean success, String info, Map<String, Object> data){
		return new ResponseObj(success, info,data);
	}
	
	public static ResponseObj getObj(boolean success, String info){
		return new ResponseObj(success, info,null);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public ResponseObj(boolean success, String info,  Map<String, Object> data) {
		super();
		this.success = success;
		this.info = info;
		this.data = data;
	}
	
	
	
}
