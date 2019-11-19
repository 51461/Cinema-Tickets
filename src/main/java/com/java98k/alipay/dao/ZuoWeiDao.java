package com.java98k.alipay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java98k.alipay.vo.ZuoWeiBiao;

public interface ZuoWeiDao {
	List<ZuoWeiBiao> findByChangCiID(Integer id);
	int saveByChangCiID(@Param("changCiID")Integer changCiID,
			@Param("zuoWeiPaiShu")Integer zuoWeiPaiShu,
			@Param("zuoWeiLieShu")Integer zuoWeiLieShu);
	int findByID(@Param("changCiID")Integer changCiID,
			@Param("zuoWeiPaiShu")Integer zuoWeiPaiShu,
			@Param("zuoWeiLieShu")Integer zuoWeiLieShu);
	
}
