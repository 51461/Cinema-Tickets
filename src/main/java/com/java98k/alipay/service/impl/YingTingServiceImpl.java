package com.java98k.alipay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java98k.alipay.dao.YingTingDao;
import com.java98k.alipay.service.YingTingService;
import com.java98k.alipay.vo.YingTingPojo;
import com.java98k.common.exception.ServiceException;
@Service
public class YingTingServiceImpl implements YingTingService{
	@Autowired
	private YingTingDao yingTingDao;
	@Override
	public YingTingPojo findByYingTingName(String yingTingname) {
		YingTingPojo pojo = yingTingDao.findByYingTingName(yingTingname);
		if (pojo==null) {
			throw new ServiceException("系统繁忙");
		}
		return pojo;
	}

}
