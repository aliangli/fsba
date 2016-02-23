package com.ulysses.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 读取properties文件
 */
public class UtilProperties {

	public static String getPram(String key) {
		URL xx = UtilProperties.class.getClassLoader().getResource(".");
		
		InputStream inputStream = ClassLoader.getSystemResourceAsStream("./config/config.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("baseFilePath: " + p.getProperty(key));

		return p.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(UtilProperties.getPram("baseFilePath"));
	}

}
