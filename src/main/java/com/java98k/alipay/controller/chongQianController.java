package com.java98k.alipay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java98k.alipay.service.chongQianService;
import com.java98k.alipay.vo.JsonResult;


@Controller
@RequestMapping("/")
public class chongQianController {
	@Autowired
	private chongQianService c;
	
	@RequestMapping("doChongQian")
	@ResponseBody
	public JsonResult chongQian(String yhm,String yuE,String chongQian){
		Double cq =Double.valueOf(chongQian);
		Double ye=Double.valueOf(yuE);
		if(cq>=500){
			int rows= c.update(yhm);
			System.out.println(rows);
		}
		double allQian=cq+ye;
		int rows =c.updateQian(allQian,yhm);
		
		return new JsonResult("1");
	}
}
