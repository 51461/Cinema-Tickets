package com.java98k.alipay.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java98k.alipay.dao.PingLunDao;
import com.java98k.alipay.service.PingLunService;
import com.java98k.alipay.vo.PingLunPojo;

@Service
public class PingLunServiceImp implements PingLunService{
@Autowired
private PingLunDao pingLunDao;
	@Override
	public int addPL(PingLunPojo pp) {
		int a = pingLunDao.addPL(pp);
		if(a==0){
			System.out.println("评论失败");
		}
		return a;
	}
	@Override
	public List<PingLunPojo> findyAllPingLun(Integer id) {
		return pingLunDao.findAllPingLun(id);
	}
	@Override
	public String findByYongHuMing(Integer id) {
		return pingLunDao.findByYongHuMing(id);
	}
	@Override
	public List<Double> findAllFenShuByDianYingid(Integer id) {
		return pingLunDao.findAllFenShuByDianYingid(id);
	}
}
