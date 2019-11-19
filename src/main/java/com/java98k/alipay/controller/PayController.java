package com.java98k.alipay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java98k.alipay.entity.SysUser;
import com.java98k.alipay.service.LoginService;
import com.java98k.alipay.service.YingTingService;
import com.java98k.alipay.service.ZuoWeiService;
import com.java98k.alipay.vo.JsonResult;
import com.java98k.alipay.vo.YingTingPojo;
import com.java98k.alipay.vo.ZuoWeiBiao;

@Controller
@RequestMapping("/")
public class PayController {
	@Autowired
	private YingTingService yingTingService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private ZuoWeiService zuoWeiService;
	@RequestMapping("doseat")
	@ResponseBody
	public JsonResult doseat(@RequestParam("yymc")String yymc) {
//		System.err.println("*******************************");
//		System.err.println(yymc);
//		System.err.println("*******************************");
		YingTingPojo pojo = yingTingService.findByYingTingName(yymc);
		return new JsonResult(pojo);
	}
	@RequestMapping("doFindDD")
	@ResponseBody
	public JsonResult doFindDD(String yynm,String ytnm,String sj,String fysj) {
		System.err.println("*******************************");
		System.err.println(yynm);
		System.err.println(ytnm);
		System.err.println(sj);
		System.err.println(fysj);
		System.err.println("*******************************");
		List<ZuoWeiBiao> list = zuoWeiService.findByChangCiIDs(yynm, ytnm, sj, fysj);
		System.out.println("************************************");
		System.err.println(list);
		System.out.println("************************************");
		return new JsonResult(list);
	}
	@RequestMapping("doLogin2")
	public String doLogin2() {
		return "login2";
	}
	@RequestMapping("doLogin5")
	@ResponseBody
	public JsonResult doLogin3(String username,String password) {
		String password1=loginService.check(username);
		System.err.println(password1);
		JsonResult jsonResult;
		if(password1.equals(password)){
			jsonResult=new JsonResult();
			return jsonResult;
			
		}
		jsonResult=new JsonResult();
		jsonResult.setState(0);
		return jsonResult;
	}
	@RequestMapping("doIndexUI4")
	public String doIndexUI4() {
		return "index4";
	}
	@RequestMapping("doFindAll")
	@ResponseBody
	public JsonResult doFindAll() {
		System.out.println("***************************************");
		List<SysUser> list=loginService.findAll();
		System.out.println(list);
		JsonResult jsonResult = new JsonResult(list);
		return jsonResult;
	}
	
	
}
