package com.ulysses.base.services.common.imp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ulysses.base.services.common.IConfigItem;

/**
 * 读取配置信息接口
 *
 */
@Service
public class ConfigItemImp implements IConfigItem {

	

	/**
	 * 项目路径
	 */
	@Value("#{propertiesReader['baseFilePath']}")
	private String baseFilePath;

	/**
	 * 个人动态图片的所在文件夹
	 */
	@Value("#{propertiesReader['personalNewsPath']}")
	private String personalNewsPath;

	/**
	 * 默认个人头像文件名
	 */
	@Value("#{propertiesReader['userDefaultPhoto']}")
	private String userDefaultPhoto;
	
	/**
	 * 默认球队头像文件名
	 */
	@Value("#{propertiesReader['teamDefaultPhoto']}")
	private String teamDefaultPhoto;
	
	/**
	 * 个人头像图片的所在文件夹
	 */
	@Value("#{propertiesReader['userLoginPhotoPath']}")
	private String userLoginPhotoPath;
	
	/**
	 * 球队头像图片的所在文件夹
	 */
	@Value("#{propertiesReader['teamPhotoPath']}")
	private String teamPhotoPath;
	
	/**
	 * 勋章图片的所在文件夹
	 */
	@Value("#{propertiesReader['medalPhotoFolder']}")
	private String medalPhotoFolder;
	
	/**
	 * 战术略缩图的所在文件夹
	 */
	@Value("#{propertiesReader['tacticPhotoFolder']}")
	private String tacticPhotoFolder;
	
	/**
	 * 场地略缩图的所在文件夹
	 */
	@Value("#{propertiesReader['areanPhotoFolder']}")
	private String areanPhotoFolder;
	

	public String getBaseFilePath() {
		return baseFilePath;
	}

	public void setBaseFilePath(String baseFilePath) {
		this.baseFilePath = baseFilePath;
	}

	public String getPersonalNewsPath() {
		return personalNewsPath;
	}

	public void setPersonalNewsPath(String personalNewsPath) {
		this.personalNewsPath = personalNewsPath;
	}
	
	public String getUserLoginPhotoPath() {
		return userLoginPhotoPath;
	}

	public void setUserLoginPhotoPath(String userLoginPhotoPath) {
		this.userLoginPhotoPath = userLoginPhotoPath;
	}

	public String getTeamPhotoPath() {
		return teamPhotoPath;
	}

	public void setTeamPhotoPath(String teamPhotoPath) {
		this.teamPhotoPath = teamPhotoPath;
	}

	public String getUserDefaultPhoto() {
		return userDefaultPhoto;
	}

	public void setUserDefaultPhoto(String userDefaultPhoto) {
		this.userDefaultPhoto = userDefaultPhoto;
	}

	public String getTeamDefaultPhoto() {
		return teamDefaultPhoto;
	}

	public void setTeamDefaultPhoto(String teamDefaultPhoto) {
		this.teamDefaultPhoto = teamDefaultPhoto;
	}

	public String getMedalPhotoFolder() {
		return medalPhotoFolder;
	}

	public void setMedalPhotoFolder(String medalPhotoFolder) {
		this.medalPhotoFolder = medalPhotoFolder;
	}

	public String getTacticPhotoFolder() {
		return tacticPhotoFolder;
	}

	public void setTacticPhotoFolder(String tacticPhotoFolder) {
		this.tacticPhotoFolder = tacticPhotoFolder;
	}

	public String getAreanPhotoFolder() {
		return areanPhotoFolder;
	}

	public void setAreanPhotoFolder(String areanPhotoFolder) {
		this.areanPhotoFolder = areanPhotoFolder;
	}
	
}
