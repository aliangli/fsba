package com.ulysses.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

public class UtilString {

	/**
	 * 判断字符是否为空，如果为NULL或者"" 则返回true 否则返回false
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(Object str)
	{
		if (str != null && !"".equals(str))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public static boolean isEmptyR(Object str)
	{
		if (str == null || "".equals(str.toString().trim()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * is Null or 零 返回true
	 * @param obj
	 * @return
	 */
	public static boolean isEmptyL(Long obj)
	{
		if (obj == null || obj==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 *   null 或  "" 或 包含空格  " " 返回true 
	 *  
	 * @param str
	 * @return
	 */
	public static boolean isEmptyRC(Object str)
	{
		if (str == null || "".equals(str) || StringUtils.containsWhitespace(str.toString()) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean notEmpty(Object str)
	{
		if (str == null || "".equals(str.toString().trim()))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * 如果参数为null则返回"" 否则返回原值
	 * @param str
	 * @return
	 */
	public static String returnStr(String str)
	{
		if (str==null || "null".equals(str))
		{
			return "";
		}
		else
		{
			return str;
		}
	}
	

	  /**
	   * 判断字符串是否全为数字
	   * 创建日期: (2004-12-8)
	   * @return java.lang.boolean
	   * @param validString java.lang.String
	 */
	  public static boolean isNumber(String validString) {
	    byte[] tempbyte = validString.getBytes();
	    for (int i = 0; i < validString.length(); i++) {
	      //by=tempbyte[i];
	      if ( (tempbyte[i] < 48) || (tempbyte[i] > 57)) {
	        return false;
	      }
	    }
	    return true;
	  }

	  /**
	   * 判断字符串是否全为字符（含字母及数字）。
	   * 创建日期: (2004-12-8)
	   * @return java.lang.boolean
	   * @param validString java.lang.String
	 */
	  public static boolean isChar(String validString) {
	    byte[] tempbyte = validString.getBytes();
	    for (int i = 0; i < validString.length(); i++) {
	      //  by=tempbyte[i];
	      if ( (tempbyte[i] < 48) || ( (tempbyte[i] > 57) & (tempbyte[i] < 65)) ||
	          (tempbyte[i] > 122) || ( (tempbyte[i] > 90) & (tempbyte[i] < 95)) ||
	          ( (tempbyte[i] > 95) & (tempbyte[i] < 97))) {
	        return false;
	      }
	    }
	    return true;
	  }


	  /**
	    * 判断字符串是否全为字母（大写或小写字母）。
	    * 创建日期: (2004-12-8)
	    * @return java.lang.boolean
	    * @param validString java.lang.String
	 */
	  public static boolean isLetter(String validString) {
	     byte[] tempbyte = validString.getBytes();
	     for (int i = 0; i < validString.length(); i++) {
	       //by=tempbyte[i];
	       if ( (tempbyte[i] < 65) || (tempbyte[i] > 122) ||
	           ( (tempbyte[i] > 90) & (tempbyte[i] < 97))) {
	         return false;
	       }
	     }
	     return true;
	  }



	  /**
	    * 把字符串转化为能够正确显示的Task2编码.
	    * 从数据库中取出字符串显示可用此方法
	    * 创建日期: (2004-12-8)
	    * @return java.lang.String
	    * @param str java.lang.String
	 */
	public static String ISO2GBK(String str) throws Exception {
	        if (str == null)
	                return null;
	        return new String(str.getBytes("ISO8859_1"), "GBK");
	}

	/**
	   * 把字符串转化为能够正确显示的UTF-8编码.
	   * 从数据库中取出字符串显示可用此方法
	   * 创建日期: (2004-12-8)
	   * @return java.lang.String
	   * @param str java.lang.String
	*/
	public static String GBK2UTF(String str) throws Exception {
	       if (str == null)
	               return null;
	       return new String(str.getBytes("ISO8859_1"), "UTF-8");
	}



	  /**
	   * 把字符串转化为ISO8859_1编码.
	   * 用此方法后,JDBC可识别带有中文的SQL语句.
	   * 创建日期: (2004-12-8)
	   * @return java.lang.String
	   * @param str java.lang.String
	   */
	  public static String GBK2ISO(String str) throws Exception {
	          if (str == null)
	                  return null;
	          return new String(str.getBytes("GBK"), "ISO8859_1");
	}


	  /**
	   * 把日期时间转换成“yyyy年MM月dd日HH时mm分ss秒”形式
	   * 创建日期: (2004-12-8)
	   * @return java.lang.String
	   * @param myDate java.util.Date
	   */
	   public static String FormatDate1(Date myDate) {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
	    String strDate = formatter.format(myDate);
	    return strDate;
	  }


	  /**
	     * 把日期时间转换成“yyyy年MM月dd日”形式
	     * 创建日期: (2004-12-8)
	     * @return java.lang.String
	     * @param myDate java.util.Date
	   */
	  public static String FormatDate2(Date myDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
	   String strDate = formatter.format(myDate);
	   return strDate;
	 }

	 /**
	     * 把日期时间转换成“yyyy-MM-dd HH:mm:ss”形式
	     * 创建日期: (2004-12-8)
	     * @return java.lang.String
	     *@param myDate java.util.Date
	   */
	 public static String FormatDate3(Date myDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String strDate = formatter.format(myDate);
	   return strDate;
	 }

	 /**
	     * 把日期时间转换成“yyyy-MM-dd”形式
	     * 创建日期: (2004-12-8)
	     * @return java.lang.String
	     * @param myDate java.util.Date
	   */
	 public static String FormatDate4(Date myDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	   String strDate = formatter.format(myDate);
	   return strDate;
	 }

	 /**
	     * 把日期时间转换成“yyyy/MM/dd”形式
	     * 创建日期: (2004-12-8)
	     * @return java.lang.String
	     * @param myDate java.util.Date
	   */
	 public static String FormatDate5(Date myDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	   String strDate = formatter.format(myDate);
	   return strDate;
	 }

	 /**
	     * 把日期时间转换成“MM-dd HH:mm”形式
	     * 创建日期: (2004-12-8)
	     * @return java.lang.String
	     * @param myDate java.util.Date
	   */
	 public static String FormatDate6(Date myDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm");
	   String strDate = formatter.format(myDate);
	   return strDate;
	 }

	 /**
	     * 把日期时间转换成“yyyyMMdd”形式
	     * 创建日期: (2004-12-8)
	     * @return java.lang.String
	     * @param myDate java.util.Date
	   */
	 public static String FormatDate7(Date myDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	   String strDate = formatter.format(myDate);
	    return strDate;
	 }

	 /**
	    * 把日期时间转换成“yyyyMM”形式
	    * 创建日期: (2004-12-8)
	    * @return java.lang.String
	    * @param myDate java.util.Date
	  */
	public static String FormatDate8(Date myDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
	  String strDate = formatter.format(myDate);
	  return strDate;
	 }



	/**
	 * 将字符串src中的子字符串fnd全部替换为新子字符串rep.<br>
	 * 功能相当于java sdk 1.4的String.replaceAll方法.<br>
	 * 不同之处在于查找时不是使用正则表达式而是普通字符串.
	 */

	public static String replaceAll(String src, String fnd, String rep) 
	{
	    if (src == null || src.equals(""))
	    {
	        return "";
	    }
	    
	    String dst = src;
	    
	    int idx = dst.indexOf(fnd);
	    
	    while (idx >= 0)
	    {
	        dst = dst.substring(0, idx) + rep + dst.substring(idx + fnd.length(), dst.length());
	        idx = dst.indexOf(fnd, idx + rep.length());
	    }
	    
	    return dst;
	}
	/**
	 * 转换为HTML编码.<br>
	 */
	public static String htmlEncoder(String src) 
	{
	    if (src == null || src.equals(""))
	    {
	        return "";
	    }
	    
	    String dst = src;
	    dst = replaceAll(dst, "<",  "&lt;");
	    dst = replaceAll(dst, ">",  "&rt;");
	    dst = replaceAll(dst, "\"", "&quot;");
	    dst = replaceAll(dst, "'",  "&#039;");
	    
	    return dst;
	}
	/**
	 * 转换为HTML文字编码.<br>
	 */
	public static String htmlTextEncoder(String src) 
	{
	    if (src == null || src.equals(""))
	    {
	        return "";
	    }
	    
	    String dst = src;
	    //dst = replaceAll(dst, "<",    "&lt;");
	    //dst = replaceAll(dst, ">",    "&rt;");
	    dst = replaceAll(dst, "\"",   "&quot;");
	    dst = replaceAll(dst, "'",    "&#039;");
	    dst = replaceAll(dst, " ",    "&nbsp;");
	    dst = replaceAll(dst, "\r\n", "<br>");
	    dst = replaceAll(dst, "\r",   "<br>");
	    dst = replaceAll(dst, "\n",   "<br>");
	    
	    return dst;
	}
	/**
	 * 转换为HTML文字编码.<br>
	 */
	public static String htmlTextUnEncoder(String src) 
	{
	    if (src == null || src.equals(""))
	    {
	        return "";
	    }
	    
	    String dst = src;
	   
	    dst = replaceAll(dst, "&quot;","\"" );
	    dst = replaceAll(dst, "&#039;","'");
	    dst = replaceAll(dst, "&nbsp;"," ");
	    dst = replaceAll(dst, "<br>","\r\n");
	    dst = replaceAll(dst, "<br>","\r");
	    dst = replaceAll(dst, "<br>","\n");
	    
	    return dst;
	}
	/**
	 * 转换为URL编码.<br>
	 */
	public static String urlEncoder(String src, String enc) throws Exception
	{
	    return java.net.URLEncoder.encode(src, enc) ;
	}
	/**
	 * 转换为XML编码.<br>
	 * xmlEncoder方法将文本格式转换为xml格式。
	 */
	public static String xmlEncoder(String src) throws Exception
	{
	    if (src == null || src.equals(""))
	    {
	        return "";
	    }
	    
	    String dst = src;
	    dst = replaceAll(dst, "&",  "&amp;");
	    dst = replaceAll(dst, "<",  "&lt;");
	    dst = replaceAll(dst, ">",  "&gt;");
	    dst = replaceAll(dst, "\"", "&quot;");
	    dst = replaceAll(dst, "\'", "&acute;");
	    
	    return dst;
	}
	/**
	 * 转换为SQL编码.<br>
	 */
	public static String sqlEncoder(String src) throws Exception
	{
	    if (src == null || src.equals(""))
	    {
	        return "";
	    }
	    
	    return replaceAll(src, "'", "''");
	}
	/**
	 * 转换为javascript编码.<br>
	 */
	public static String jsEncoder(String src) throws Exception
	{
	    if (src == null || src.equals(""))
	    {
	        return "";
	    }
	    
	    String dst = src;
	    dst   = replaceAll(dst, "'",    "\\'");
	    dst   = replaceAll(dst, "\"",   "\\\"");
	    //dst = replaceAll(dst, "\r\n", "\\\n"); // 和\n转换有冲突
	     dst   = replaceAll(dst, "\n",   "\\\n");
	    dst   = replaceAll(dst, "\r",   "\\\n");
	    
	    return dst;
	}

	public static String jsEncoder2(String src) throws Exception
	{
	    if (src == null || src.equals(""))
	    {
	        return "";
	    }
	    
	    String dst = src;
	    dst   = replaceAll(dst, "&quot;",    "");
	    dst   = replaceAll(dst, "&#039;",   "");
	    dst   = replaceAll(dst, "\"",   "");
	    dst   = replaceAll(dst, "\'",   "");
	   
	    
	    return dst;
	}
	//html代码屏蔽
	public static  String filterStr(String str){
	          if(str==null)return null;
	       StringBuffer sb = new StringBuffer();
	      int n = str.length();
	      for (int i = 0; i < n; i++) {
	             char c = str.charAt(i);
	             switch (c) {
	                     case ' ': sb.append("&nbsp;");break;
	                  // case '':  sb.append("<br/>");break;
	                     case '\'':sb.append("'");break;
	                     case '<': sb.append("<"); break;
	                     case '>': sb.append(">"); break;
	                     case '&': sb.append("&"); break;
	                   //case '"': sb.append("""); break;
	                     default:  sb.append(c);
	         }
	   }
	   return sb.toString();
	}

	// html代码屏蔽
	public static String filterStr2(String str) {
		if (str == null)
			return null;

		str = htmlTextEncoder(str);
		// System.out.println(str);
		StringBuffer sb = new StringBuffer();
		int n = str.length();
		for (int i = 0; i < n; i++) {
			char c = str.charAt(i);
			switch (c) {
			case ' ':
				sb.append("&nbsp;");
				break;
			// case '': sb.append("<br/>");break;
			case '\'':
				sb.append("'");
				break;
			case '<':
				sb.append("<");
				break;
			case '>':
				sb.append(">");
				break;
			case '&':
				sb.append("&");
				break;
			// case '"': sb.append("""); break;
			default:
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 返回数值型的整数部分
	 * 
	 * @param str
	 * @return
	 */
	public static String getDoubleInt(double numeric) {

		String str = String.valueOf(numeric);
		int numarg = str.indexOf(".");
		String intStr = str.substring(0, numarg);
		return intStr;
	}

	public static String getDoubledig(double numeric) {
		String str = String.valueOf(numeric);
		int numLen = str.length();
		int numarg = str.indexOf(".");
		String digStr = str.substring(numarg + 1, numLen);
		return digStr;
	}

	public static String Formatnumber(String s, double d) {
		DecimalFormat decimalformat = new DecimalFormat(s);
		return decimalformat.format(d);

	}

	public static String FormatP(double d) {
		return NumberFormat.getPercentInstance().format(d);
	}

	public static String Formatnumber1(double s) {
		DecimalFormat nf1 = new DecimalFormat("####.0");
		String nf2 = nf1.format(s);
		return nf2;
	}

	public static String Formatnumber2(double s) {
		DecimalFormat nf1 = new DecimalFormat("####.00");
		String nf2 = nf1.format(s);
		return nf2;
	}

	public static String Formatnumber3(double s) {
		DecimalFormat nf1 = new DecimalFormat("####.000");
		String nf2 = nf1.format(s);
		return nf2;
	}
	
	public static String Formatnumber4(double s) {
		return new DecimalFormat("##.##").format(s);
	}
	
	public static String Formatnumber5(double s) {
		return new DecimalFormat("###,###.00").format(s);
	}

}
