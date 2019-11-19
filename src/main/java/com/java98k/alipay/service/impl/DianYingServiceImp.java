package com.java98k.alipay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java98k.alipay.dao.DianYingDao;
import com.java98k.alipay.service.DianYingService;
import com.java98k.alipay.vo.DianYingPojo;
import com.java98k.alipay.vo.ZhangDanPojo;


@Service
public class DianYingServiceImp implements DianYingService{
	@Autowired
	private DianYingDao dianYingDao;
	@Override
	public List<DianYingPojo> findAll() {
		  List<DianYingPojo> list = dianYingDao.findAll();
		  return list;
	}
	@Override
	public List<ZhangDanPojo> findByID(Integer id) {
		List<ZhangDanPojo> list = dianYingDao.findByID(id);
		return list;
	}
	@Override
	public List<DianYingPojo> findByZzry(Integer id) {
		  List<DianYingPojo> list = dianYingDao.findByZzry(id);
		  return list;
	}
	@Override
	public List<DianYingPojo> findByName(String name) {
		List<DianYingPojo> list=dianYingDao.findByName(name);
		return list;
	}
	@Override
	public Integer findByID2(String name) {
		return dianYingDao.findByID2(name);
	}
	@Override
	public Integer findByDianYingID(Integer id,Double zhpf) {
		return dianYingDao.updateZHPingFen(id, zhpf);
	}
	@Override
	public Integer findYongHuID(String userName) {
		return dianYingDao.findYongHuID(userName);
	}
}
