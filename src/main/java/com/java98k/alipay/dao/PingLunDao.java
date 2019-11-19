package com.java98k.alipay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java98k.alipay.vo.PingLunPojo;

public interface PingLunDao {
	int addPL(PingLunPojo pp);
	List<PingLunPojo> findAllPingLun(@Param("id")Integer id);
	String findByYongHuMing(@Param("id")Integer id);
	List<Double> findAllFenShuByDianYingid(@Param("id")Integer id);
}
