package com.ulysses.bean;

import org.springframework.beans.factory.annotation.Value;

public class ConfigBean {
	
	@Value("#{propertiesReader[baseFilePath]}")
	private String baseFilePath;

	public String getBaseFilePath() {
		return baseFilePath;
	}

	public void setBaseFilePath(String baseFilePath) {
		this.baseFilePath = baseFilePath;
	}
	
	

}
