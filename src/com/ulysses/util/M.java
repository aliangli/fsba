package com.ulysses.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.view.BaseView;
import com.ulysses.util.ec.Des3;

public class M {
	
	public static void main(String[] args) {
//		new M().p1();
//		new M().p3();
		new M().p9();
		
		
	}
	

	private void p9() {
		TbUser user = new TbUser();
		Object view = new Object();
		if(view instanceof TbUser){
			System.out.println(1);
		}
		if(user instanceof TbUser){
			System.out.println(2);
		}
	}


	private void p8() {
		int p = 6;
		for(int i=0;i<p;i++){
			String s = "md_00" + (i+1);
			System.out.println(s +":" + s +".png,");
		}
	}


	private void p7() {
		long ms = System.currentTimeMillis()/5;
		System.out.println(UtilMD5.MD5(ms+""));
	}


	private void p6() {
		String[] arr = {"abc", "123", "45", "6678", "54642"};
		String str2 = String.format("%s+%s,%s", arr);
		
		System.out.println(str2);
		
		
	}


	private void p5() {
		System.out.println(UtilDate.parseMS(1451471188000L));
	}

	private void p4() {
		System.out.println(UtilString.Formatnumber1(Double.parseDouble("1000.0200")));
		System.out.println(UtilString.Formatnumber2(Double.parseDouble("1000.0200")));
		System.out.println(UtilString.Formatnumber5(Double.parseDouble("100033.0256")));
	}

	private void p3() {
		try {
			System.out.println(Des3.encode("DWa4OPACVl8="));
//			System.out.println(Des3.encode("1111111d"));
//			System.out.println(Des3.encode("sss3333ac"));
//			System.out.println(Des3.encode("sss3333ace"));
//			System.out.println(Des3.encode("sss3333acesdfs"));
//			System.out.println(Des3.encode("sss3333acesdfsdd"));

//			System.out.println(Des3.decode("DrmWh37ndl4="));
//			System.out.println(Des3.decode("uR39nfV4zrG="));
//			System.out.println(Des3.decode("lEnNWNuNg4D="));
			
//			System.out.println(Des3.decode("EFG7ZR3CjyI"));
//			System.out.println(Des3.decode("zlRACtqI4FU"));
//			System.out.println(Des3.decode("ygCc7czcwIE"));

			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void p2() {
		String s = "FB6D69722E6A5200EF2B6B1C6F070928"; //EC17BBEAAE696198D67811E2CF_0E0F8
		
		System.out.println(UtilMD5.MD5(s));
		String x = "EC17BBEAAE696198D67811E2CF_0E0F8";
		
		
		
	}
	
	

	private void p1() {
		if(StringUtils.containsWhitespace(" a b ")){
			System.out.println("true");
		}else {
			System.out.println("f");
		}
	}
	
	
	
}
