package com.java98k.alipay.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java98k.alipay.service.ChangCiService;
import com.java98k.alipay.vo.ChangCiBiao;
import com.java98k.alipay.vo.JsonResult;


@Controller
@RequestMapping("/")
public class changciController {
	@Resource
	private ChangCiService changCiService;
	@RequestMapping("doGouPiao")
	@ResponseBody
	public JsonResult doGouPiao(String name,String city) {
		List<ChangCiBiao> list = changCiService.findYingTing(name);
		Iterator<ChangCiBiao> it = list.iterator();
		while(it.hasNext()){
			ChangCiBiao c = it.next();
			int yingTingid=c.getYingTingID();
			String findCity=changCiService.findCity(yingTingid);
		    if(findCity.equals(city)){
		    	c.setCity(findCity);
		        continue;
		    }
		    it.remove();
		}		
		System.err.println(list);
		return new JsonResult(list);
	}
	@RequestMapping("doMaiPiao")
	@ResponseBody
	public JsonResult doMaiPiao(String name) {
		List<ChangCiBiao> list = changCiService.findYingTing(name);
		return new JsonResult(list);
	}
}
