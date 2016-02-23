package com.ulysses.base.services.common.imp;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.ulysses.base.services.common.ICommonUploadFile;
import com.ulysses.base.services.common.IConfigItem;
import com.ulysses.util.UtilMD5;
import com.ulysses.util.UtilString;

/**
 * 上传文件
 *
 */
@Service
public class CommonUploadFileImp implements ICommonUploadFile {

	@Autowired
	IConfigItem config;
	
	private static String STR_NULL = "";
	private static String STR_SMCL = ";";

	private static String[] imgType = {".jpg", ".jpeg", ".png"};
	

	public String updateFile(HttpServletRequest request, String imgFolderPath) throws IllegalStateException, IOException {
		return this.transferFile(request, imgFolderPath, false, imgType);
	}


	public String updateFileMultiple(HttpServletRequest request, String imgFolderPath) throws IllegalStateException, IOException {
		return this.transferFile(request, imgFolderPath, true, imgType);
	}
	
	
	
	/**
	 * 上传文件
	 * @param request
	 * @param basePath 项目名称下的文件路径
	 * @param isMultiple 传多个文件 true
	 * @param fileTypes 允许传的文件类型
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String transferFile(HttpServletRequest request, String imgFolderPath, boolean isMultiple, String[] fileTypes) throws IllegalStateException, IOException {
		//创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		//判断 request 是否有文件上传,即多部分请求
		if(multipartResolver.isMultipart(request)){
			//转换成多部分request  
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			//取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			
			int i=0;
			StringBuffer paths = new StringBuffer();//保存路径
			while(iter.hasNext()){
				//取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				
				if(file != null){
					//取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					
					//如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if(validFile(myFileName, fileTypes)){
						long ms = System.currentTimeMillis();
						
						//重命名上传后的文件名
						String fileName = UtilMD5.MD5(((ms/7)*3)+"") + "_" + (i++)+ "." + StringUtils.getFilenameExtension(myFileName).toLowerCase();
						//定义上传路径
						File localFile = new File(config.getBaseFilePath() + imgFolderPath + "/" + fileName);
						file.transferTo(localFile);
						
						paths.append(fileName+ (isMultiple? STR_SMCL:STR_NULL));
					}
				}
			}
			return paths.length()==0?null:paths.toString();
		}
		return null;
	}
	

	private boolean validFile(String fileName, String[] fileTypes) {
		
		if(UtilString.isEmptyR(fileName.trim())){
			return false;
		}
		
		for(String type : fileTypes){
			if(StringUtils.endsWithIgnoreCase(fileName.toLowerCase(), type)){
				return true;
			}
		}
		
		return false;
	}


	
	
	
	

}
