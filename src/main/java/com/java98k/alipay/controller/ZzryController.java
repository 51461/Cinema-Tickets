package com.java98k.alipay.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java98k.alipay.service.ZzryService;
import com.java98k.alipay.vo.DianYingPojo;
import com.java98k.alipay.vo.JsonResult;
import com.java98k.alipay.vo.PageObject;

@Controller
@RequestMapping("/")//日志模块根路径
public class ZzryController {
	  @Autowired
	  private ZzryService zzryService;
	  @RequestMapping(value= {"doLogListUI","logListUI"})
	  public String doLogListUI() {
		  return "sys/log_list";
	  }
	  @PostMapping("doDeleteObjects")
	  @ResponseBody
	  public JsonResult doDeleteObjects(Integer...ids) {
		  int rows=zzryService.deleteObjects(ids);
		  return new JsonResult("delete ok,rows="+rows);
	  }
	  /**
	   * 1.分页查询用户行为日志信息
	   * @param username
	   * @param pageCurrent
	   * @return
	 ` * 返回值要转换为json格式的串
	   * 1)添加依赖(例如jackson)
	   * 2)配置文件中添加<mvc:annotation-driven/>
	   * 3)使用@ResponseBody注解修饰方法
	   */
	  @GetMapping("doFindPageObjects")
	  @ResponseBody
	  public JsonResult doFindPageObjects(
			  String jiJiangShangYing,
			  Integer pageCurrent) {
		  PageObject<DianYingPojo> pageObject=
		  zzryService.findPageObjects(jiJiangShangYing,
				  pageCurrent);
		  System.out.println(pageObject.getRecords());
		  return new JsonResult(pageObject);
	  }
}