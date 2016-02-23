package com.ulysses.base.bean;

public class ResultObj {

	private boolean success;
	private String info;
	private String codeType;
	
	public static ResultObj getObj(boolean success, String info, String codeType){
		return new ResultObj(success, info, codeType);
	}
	
	public ResultObj(){}
	
	public ResultObj(boolean success, String info, String codeType) {
		this.success = success;
		this.info = info;
		this.codeType = codeType;
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
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
	
	
}
