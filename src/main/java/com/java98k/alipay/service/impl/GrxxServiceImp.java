package com.java98k.alipay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java98k.alipay.dao.GrxxDao;
import com.java98k.alipay.service.GrxxService;
import com.java98k.alipay.vo.GrxxPojo;


@Service
public class GrxxServiceImp implements GrxxService{

	@Autowired
	private GrxxDao grxx;
	@Override
	public List<GrxxPojo> findByYHID(String id) {
		List<GrxxPojo> f = grxx.findByYHID(id);
		return f;
	}

}
