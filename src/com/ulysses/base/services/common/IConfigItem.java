package com.ulysses.base.services.common;

/**
 * 读取配置信息接口
 *
 */
public interface IConfigItem {

	public String getBaseFilePath();
	public String getPersonalNewsPath();
	public String getUserLoginPhotoPath();
	public String getTeamPhotoPath();
	public String getUserDefaultPhoto();
	public String getTeamDefaultPhoto();
	public String getMedalPhotoFolder();
	public String getTacticPhotoFolder();
	public String getAreanPhotoFolder();
}
