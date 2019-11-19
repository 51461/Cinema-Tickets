package com.java98k.alipay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java98k.alipay.dao.LoginServiceDao;
import com.java98k.alipay.entity.SysUser;
import com.java98k.alipay.service.LoginService;


@Service
public class LoginServiceImp implements LoginService{
	@Autowired
	private LoginServiceDao loginServiceDao;
	@Override
	public String check(String username) {
		// TODO Auto-generated method stub
		return loginServiceDao.check(username);
	}
	@Override
	public List<SysUser> findAll() {
		
		return loginServiceDao.findAll();
	}

}
