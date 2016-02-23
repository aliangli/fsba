package com.ulysses.base.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.bean.ResponseObj;
import com.ulysses.util.GenerateCode;


@Controller
@RequestMapping(value="initController")
public class InitController {
	

	/**
	 * 产生编号
	 * @return
	 */
	@RequestMapping(value="getCode", method=RequestMethod.POST)
	@ResponseBody
	public ResponseObj getCode(){
		
		String code = GenerateCode.getCode(null, 0);
		Map<String , Object > data = new HashMap<String , Object >();
		data.put("code", code);
		return ResponseObj.getObj(true, "ok", data);
	}
	
}
