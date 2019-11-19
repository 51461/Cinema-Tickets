package com.java98k.alipay.service;

import java.util.List;

import com.java98k.alipay.vo.PingLunPojo;

public interface PingLunService {
	int addPL(PingLunPojo pp);
	List<PingLunPojo> findyAllPingLun(Integer id);
	String findByYongHuMing(Integer id);
	List<Double> findAllFenShuByDianYingid(Integer id);
}
