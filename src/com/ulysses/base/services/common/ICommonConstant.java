package com.ulysses.base.services.common;

/**
 * 公用常量
 *
 */
public interface ICommonConstant {
	
	/**
	 * 创建球队的数量限制
	 */
	public static final Integer TEAM_SIZE = 20;
	
	public static final String SUCCESS = "success";
	public static final String INFO = "info";
	public static final String CODE_TYPE = "codeType";
	public static final String DATA = "data";

	public static final String RELAY_DATA = "relayData";

	public static final String LIKE_DATA = "likeData";

	public static final String MEDAL_ALL = "medalAll";

	public static final String MEDAL_ALL_BODY = "md_001:md_001.png, md_002:md_002.png, md_003:md_003.png, md_004:md_004.png, md_005:md_005.png, md_006:md_006.png";

	/**
	 * 个人发表动态的图片所在文件夹
	 */
	public static final String PERSONAL_NEWS_PATH = "personalNewsPath";

	/**
	 * 个人头像所在文件夹
	 */
	public static final String USER_LOGIN_PHOTO_PATH = "userLoginPhotoPath";
	
	public static final String USER_PHOTO_PATH = "userPhotoPath";
	
	/**
	 * 球队头像所在文件夹
	 */
	public static final String TEAM_PHOTO_FOLDER = "teamPhotoFolder";
	
	/**
	 * 勋章所在文件夹
	 */
	public static final String MEDAL_PHOTO_FOLDER = "medalFolder";

	/**
	 * 战术略缩图的所在文件夹
	 */
	public static final String TACTIC_PHOTO_FOLDER = "tacticPhotoFolder";

	/**
	 * 场地略缩图的所在文件夹
	 */
	public static final String AREAN_PHOTO_FOLDER = "areanPhotoFolder";

	/**
	 * 忽略
	 */
	public static final String STATE_G = "G";
	
	/**
	 * 否
	 */
	public static final String STATE_N = "N";
	
	/**
	 * 是
	 */
	public static final String STATE_Y = "Y";
	
	/**
	 * 表示正在进行某个过程的状态.  如     审核状态:N=未审核; NY=已申请审核; Y=已审核. 
	 */
	public static final String STATE_NY = "NY";
	

	/**
	 * 比赛状态: W=系统待办;E=接受报名;C=审核;S=已开赛;D=比赛已结束
	 */
	public static final String STATE_W = "W";
	public static final String STATE_E = "E";
	public static final String STATE_C = "C";
	public static final String STATE_S = "S";
	public static final String STATE_D = "D";
	
	
	
}
