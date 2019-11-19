package com.java98k.alipay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java98k.alipay.dao.ChangCiDao;
import com.java98k.alipay.dao.ZuoWeiDao;
import com.java98k.alipay.service.ZuoWeiService;
import com.java98k.alipay.vo.ZuoWeiBiao;
import com.java98k.common.exception.ServiceException;
@Service
public class ZuoWeiServiceImpl implements ZuoWeiService{
	@Autowired
	private ChangCiDao changCiDao;
	@Autowired
	private ZuoWeiDao zuoWeiDao;
	@Override
	public List<ZuoWeiBiao> findByChangCiIDs(String yynm, String ytnm, String sj, String fysj) {
		int id=0;
		try {
			id = changCiDao.selectChangCiID(ytnm, yynm, sj, fysj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("*******************************************");
		System.err.println(id);
		System.out.println("*******************************************");
		if (id==0) {
			throw new ServiceException("后台抢修中...");
		}
		List<ZuoWeiBiao> list = zuoWeiDao.findByChangCiID(id);
		return list;
	}
	
}
