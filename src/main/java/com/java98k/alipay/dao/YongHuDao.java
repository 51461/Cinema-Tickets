package com.java98k.alipay.dao;

import org.apache.ibatis.annotations.Param;

import com.java98k.alipay.entity.SysUser;


public interface YongHuDao {
	SysUser findUserByUserName(String username);
	int updatePassword(
			@Param("id")Integer id,
			 @Param("salt")String salt,
			@Param("password")String password
			);
	int insertUser(SysUser entity);
	int findByPhone(String phone);
	Integer findByname(String name);
	Integer selcetID(String name);
}
