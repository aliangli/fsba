package com.ulysses.util;

/**
 * 产生编号 
 *
 */
public final class GenerateCode {

	 /**
     * 精确到毫秒的完整中文时间
     */
    public static String FORMAT_FULL_CN = "yyyyMMddHHmmssSSS";
    
    /**
     * 根据毫秒数产生编号
     */
    public static String getCode(String str, int index) {
    	String date = UtilDate.getNow(FORMAT_FULL_CN);
    	
    	if(UtilString.isEmpty(str)){
    		
    	}
    	
        return date;
    }
    
    
}
