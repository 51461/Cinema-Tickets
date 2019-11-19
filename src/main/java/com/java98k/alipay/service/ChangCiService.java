package com.java98k.alipay.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java98k.alipay.vo.ChangCiBiao;


public interface ChangCiService {
	List<ChangCiBiao> findYingTing(String name);
	String findCity(Integer id);
	Integer findByChangCiID(Integer id);
}
