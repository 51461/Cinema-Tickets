package com.java98k.alipay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java98k.alipay.service.SysIpService;
import com.java98k.alipay.vo.JsonResult;

@Controller
@RequestMapping("/")
public class SysIpController {
	@Autowired
	SysIpService sysIpService;
	@RequestMapping("doFindIp")
	@ResponseBody
	public JsonResult doFindIp() {
		return new JsonResult(sysIpService.findIp());
	}
	//测试
	@RequestMapping("test")
	public String test() {
		return "home-categories-articles";
	}
}
