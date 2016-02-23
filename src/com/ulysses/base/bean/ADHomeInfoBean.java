package com.ulysses.base.bean;

public class ADHomeInfoBean {
	
	private String imgPath;
	private String activeURL;
	
	public ADHomeInfoBean(){}
	
	public ADHomeInfoBean(String imgPath, String activeURL) {
		super();
		this.imgPath = imgPath;
		this.activeURL = activeURL;
	}
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getActiveURL() {
		return activeURL;
	}
	public void setActiveURL(String activeURL) {
		this.activeURL = activeURL;
	}
	
}
