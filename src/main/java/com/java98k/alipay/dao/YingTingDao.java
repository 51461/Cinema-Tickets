package com.java98k.alipay.dao;

import org.apache.ibatis.annotations.Param;

import com.java98k.alipay.vo.YingTingPojo;

public interface YingTingDao {
	YingTingPojo findByYingTingID(Integer ID);
	YingTingPojo findByYingTingName(@Param("yingTingname")String yingTingname);
}
