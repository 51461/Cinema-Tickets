package com.java98k.alipay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java98k.alipay.service.DianYingService;
import com.java98k.alipay.vo.DianYingPojo;
import com.java98k.alipay.vo.JsonResult;


@Controller
@RequestMapping("/sou/")
public class SouSuoController {
	@Autowired
	private DianYingService dianYingService;
	@RequestMapping("doSouSuo")
	@ResponseBody
	public JsonResult doSouSuo(String name) {
		JsonResult jsonResult = new JsonResult(name);
		return jsonResult;
	}
	@RequestMapping("doSouSuoUI")
	public String doSouSuoUI() {
		return "sousuo";
	}
	@RequestMapping("doSou")
	@ResponseBody
	public JsonResult doSou(String name) {
		List<DianYingPojo> list = dianYingService.findByName(name);
		JsonResult jsonResult = new JsonResult(list);
		return jsonResult;
	}
}
