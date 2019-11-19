package com.java98k.alipay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java98k.alipay.dao.ChangCiDao;
import com.java98k.alipay.dao.DianYingDao;
import com.java98k.alipay.service.ChangCiService;
import com.java98k.alipay.vo.ChangCiBiao;

@Service("changCiService")
public class ChangCiServiceImpl implements ChangCiService{
	@Autowired
	private ChangCiDao changCiDao; 
	@Autowired
	private DianYingDao dianYingDao;
	@Override
	public List<ChangCiBiao> findYingTing(String name) {
		int id = dianYingDao.findByname(name);
		List<ChangCiBiao> rows = changCiDao.findYingTing(id);
		return rows;
	}
	@Override
	public String findCity(Integer id) {
		return changCiDao.findCity(id);
	}
	@Override
	public Integer findByChangCiID(Integer id) {
		return changCiDao.findByChangCiID(id);
	}

}
