package com.ulysses.base.services.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

/**
 * 上传文件处理
 *
 */
public interface ICommonUploadFile {

	/**
	 * 上传文件 
	 * 返回文件名
	 * @param request
	 * @return
	 */
	public String updateFile(HttpServletRequest request, String path)throws IllegalStateException, IOException;
	
	/**
	 * 上传多个文件 
	 * 返回文件名 , 路径用;分割
	 * @param request
	 * @return
	 */
	public String updateFileMultiple(HttpServletRequest request, String path)throws IllegalStateException, IOException;
	
}
