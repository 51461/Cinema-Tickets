package com.java98k.alipay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java98k.alipay.service.DianYingService;
import com.java98k.alipay.service.YongHuService;
import com.java98k.alipay.vo.JsonResult;
@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private DianYingService dianYingService;
	@Autowired
	private YongHuService yongHuService;
	@RequestMapping("doUpdatePwd")
	@ResponseBody
	public JsonResult doUpdatePwd(String username,String newPwd,String cfgPwd) {
		yongHuService.updatePassword(username, newPwd, cfgPwd);
		return new JsonResult("update ok!");
	}
}
