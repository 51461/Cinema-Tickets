package com.java98k.alipay.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java98k.alipay.service.SysBadWordService;
import com.java98k.alipay.vo.JsonResult;

@Controller
@RequestMapping("/")
public class SysBadWordController {
	@Autowired
	SysBadWordService sysBadWordService;
	
	@RequestMapping(value="doFindBadWord", method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doFindBadWord(String content,HttpSession session) {
		System.out.println("content:-----"+content);
		String message = sysBadWordService.findBadWord(content);
		return new JsonResult(message);
	}
	@RequestMapping("doTest")
	public String doTest() {
		return "test2";
	}
}
