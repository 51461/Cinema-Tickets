package com.java98k.alipay.service;

import java.util.List;

import com.java98k.alipay.vo.DianYingPojo;
import com.java98k.alipay.vo.ZhangDanPojo;


public interface DianYingService {
	List<DianYingPojo> findAll();
	List<ZhangDanPojo> findByID(Integer id);
	List<DianYingPojo> findByZzry(Integer id);
	List<DianYingPojo> findByName(String name);
	Integer findByID2(String name);
	Integer findByDianYingID(Integer id,Double zhpf);
	Integer findYongHuID(String userName);
}
