package com.ulysses.util;

import java.text.DecimalFormat;

/**
 * 数字格式化
 * @author Administrator
 *
 */
public class UtilDecimalFormat {

	public static String fm1(double s) {
		DecimalFormat nf1 = new DecimalFormat("####.0");
		String nf2 = nf1.format(s);
		return nf2;
	}

	public static String fm2(double s) {
		DecimalFormat nf1 = new DecimalFormat("####.00");
		String nf2 = nf1.format(s);
		return nf2;
	}

	public static String fm3(double s) {
		DecimalFormat nf1 = new DecimalFormat("####.000");
		String nf2 = nf1.format(s);
		return nf2;
	}
	
	public static String fm4(double s) {
		return new DecimalFormat("##.##").format(s);
	}
	
	public static String fm5(double s) {
		return new DecimalFormat("###,###.00").format(s);
	}
}
