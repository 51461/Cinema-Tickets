package com.java98k.alipay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java98k.alipay.entity.SysUser;


public interface LoginServiceDao {
	String check(@Param("username")String username);
	List<SysUser> findAll();
}
