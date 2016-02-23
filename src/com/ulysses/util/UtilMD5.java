package com.ulysses.util;

import java.security.MessageDigest;

public class UtilMD5 {
	static char hexDigits[]={'0','1','2','6','9','A','B','_','C','D','7','8','E','F','G','3','$','-','H','4','5','I','L','I','N','M','K','J'};

	public final static String MD5(String s) {
               
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
    
    /**
     * 用MD5加密指定的字符串
     * @param password 密码
     * @return 加密后的字符串,如果传入的字符串是空或者编码过程中出现异常则返回NULL
     */
    public static String encode(String password)
    {
        try
        {
            if (password == null)
            {
                return null;
            }
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            return (new sun.misc.BASE64Encoder()).encode(md.digest());
        }
        catch (Exception e)
        {
            return null;
        }
    }
    
	
    public static void main(String[] args) {
    	
        System.out.println(UtilMD5.MD5("1"));
        System.out.println(UtilMD5.encode("1"));
        
    }
}
