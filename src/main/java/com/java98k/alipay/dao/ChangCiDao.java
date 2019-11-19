package com.java98k.alipay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java98k.alipay.vo.ChangCiBiao;


public interface ChangCiDao {
	List<ChangCiBiao> findYingTing(@Param("id")Integer id);
	String findCity(@Param("id")Integer id);
	int selectChangCiID(@Param("ytnm")String ytnm,
			@Param("yynm")String yynm,
			@Param("sj")String sj,
			@Param("fysj")String fysj);
	Integer findByChangCiID(@Param("id")Integer id);
}
