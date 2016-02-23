package com.ulysses.util;

public class UtilParse {

	/**
	 * 字符串数组转Long数组
	 * @param arr
	 * @return
	 */
	public static Long[] parseStrArr(String[] arr){
		if(arr==null||arr.length==0){return null;}
		
		Long[] intIdArr = new Long[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intIdArr[i] = Long.parseLong(arr[i]);
		}
		return intIdArr;
	}
}
