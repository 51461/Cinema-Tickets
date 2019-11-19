package com.java98k.alipay.service.impl;

import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.java98k.alipay.dao.YongHuDao;
import com.java98k.alipay.entity.SysUser;
import com.java98k.alipay.service.YongHuService;
import com.java98k.common.exception.ServiceException;

@Service
public class YongHuSeviceImpl implements YongHuService {
	@Autowired
	private YongHuDao yongHuDao;
	
	@Override
	public String findObjectByName(String userName) {
		SysUser user = yongHuDao.findUserByUserName(userName);
		user.getYongHuMing();
		user.getMiMa();
		return userName;
	}

	@Override
	public int updatePassword(String username, String newPwd, String cfgPwd) {
		System.out.println("*************************************************");
		System.out.println(username);
		System.out.println(newPwd);
		System.out.println(cfgPwd);
		System.out.println("*************************************************");
		if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("用户名不能为空！！！");
        }
		if (StringUtils.isEmpty(newPwd)) {
            throw new IllegalArgumentException("新密码不能为空！！！");
        }
		if (StringUtils.isEmpty(cfgPwd)) {
            throw new IllegalArgumentException("确认密码不能为空！！！");
        }
		if (!newPwd.equals(cfgPwd)) {
            throw new IllegalArgumentException("两次输入的密码不一致！！！");
        }
		SysUser user = yongHuDao.findUserByUserName(username);
		System.out.println(user.getSalt());
		SimpleHash sh=new SimpleHash("MD5",newPwd, user.getSalt(), 1);
		if (!(username).equals(user.getYongHuMing())) {
			throw new IllegalArgumentException("用户名不正确");
		}
		//3.对新密码进行加密
		String salt=UUID.randomUUID().toString();
		System.err.println("*****************************");
		System.err.println(salt);
		System.err.println(user.getYongHuID());
		System.err.println("*****************************");
		sh=new SimpleHash("MD5",newPwd,salt, 1);
		//4.将新密码加密以后的结果更新到数据库
		int rows = yongHuDao.updatePassword( user.getYongHuID(), salt,sh.toHex());
		if (rows==0) {
			throw new ServiceException("修改失败");
		}
		return rows;
	}

	@Override
	public int insertUser(SysUser entity) {
		String salt=UUID.randomUUID().toString();
		entity.setSalt(salt);
		SimpleHash sHash=new SimpleHash("MD5",entity.getMiMa(), salt);
		entity.setMiMa(sHash.toHex());
		int rows = yongHuDao.insertUser(entity);
		//3.返回结果
		return rows;
	}

	@Override
	public int findByPhone(String phone) {
		int rows = yongHuDao.findByPhone(phone);
		return rows;
	}
}
