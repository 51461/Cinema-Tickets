package com.java98k.alipay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java98k.alipay.service.DianYingService;
import com.java98k.alipay.service.PingLunService;
import com.java98k.alipay.vo.JsonResult;
import com.java98k.alipay.vo.PingLunPojo;


@Controller
@RequestMapping("/pinglun/")
public class PingLunController {
	@Autowired
	private PingLunService pingLunService;
	@Autowired
	private DianYingService dianYingService;
	
	@RequestMapping("ineasePingLun")
	public String inceasePingLun(String pingFen,String pingLun, String dianYingMing,String userName) {
		
		//System.out.println(userName);
		System.err.println(pingFen+pingLun+dianYingMing+userName);
		
		
		PingLunPojo pingLunPojo=new PingLunPojo();
		pingLunPojo.setPingFen(Integer.valueOf(pingFen));
		pingLunPojo.setPingLun(pingLun);
		int dianYingID=findDianYingID(dianYingMing);
		pingLunPojo.setDianYingID(dianYingID);
		
		int yongHuID = dianYingService.findYongHuID(userName);
		pingLunPojo.setYongHuID(yongHuID);
		int addPL = addPL(pingLunPojo);
		List<Double> findAllFenShu=pingLunService.findAllFenShuByDianYingid(dianYingID);
		//System.err.println(findAllFenShu);
		double all=0;
		double zonghepingfen=10;
		if(findAllFenShu.size()>=1) {
			for (int i = 0; i < findAllFenShu.size(); i++) {
				all +=findAllFenShu.get(i);
			}
			zonghepingfen=all/findAllFenShu.size();
		}
		String result = String.format("%.1f", zonghepingfen);
		Integer rows = dianYingService.findByDianYingID(dianYingID, Double.valueOf(result));
		return "dianying";
	}
	@RequestMapping("showPingLun")
	@ResponseBody
	public JsonResult showPingLun(Integer id) {
		List<PingLunPojo> findyAllPingLun = pingLunService.findyAllPingLun(id);
		for(PingLunPojo p:findyAllPingLun) {
			int id2=p.getYongHuID();
			String name=findByYongHuMing(id2);
			p.setName(name);
		}
		JsonResult jsonResult =new JsonResult(findyAllPingLun);
		System.err.println(findyAllPingLun);
		return jsonResult;
	}
	
	public String findByYongHuMing(Integer id2) {
		return pingLunService.findByYongHuMing(id2);
	}
	public int addPL(PingLunPojo pingLunPojo) {
		return pingLunService.addPL(pingLunPojo);
	}
	
	public int findDianYingID(String dianYingMing) {
		int dianYingID=dianYingService.findByID2(dianYingMing);
		return dianYingID;
	}
}
 