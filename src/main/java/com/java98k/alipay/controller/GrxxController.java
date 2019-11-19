package com.java98k.alipay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java98k.alipay.service.GrxxService;
import com.java98k.alipay.vo.GrxxPojo;
import com.java98k.alipay.vo.JsonResult;


@Controller
@RequestMapping("/")
public class GrxxController {
	@Autowired
	private GrxxService g;
	
	@RequestMapping("doGrxx")
	@ResponseBody
	public JsonResult findByYHID(String yhm) {
		System.err.println(yhm);
		List<GrxxPojo> f = g.findByYHID(yhm);
		System.err.println("**********************************");
		System.err.println(f);
		System.err.println("**********************************");
		JsonResult j = new JsonResult(f);
		return j;
	}
}
