package com.java98k.alipay.dao;


import com.java98k.alipay.vo.chongQianPojo;

public interface ChongQianDao {
	String chongQian(chongQianPojo cq);
	Integer updateQian(Double allQian, String yhm);
	Integer update(String yhm);
}
