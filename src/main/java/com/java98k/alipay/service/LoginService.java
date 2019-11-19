package com.java98k.alipay.service;

import java.util.List;

import com.java98k.alipay.entity.SysUser;


public interface LoginService {

	String check(String username);

	List<SysUser> findAll();

}
