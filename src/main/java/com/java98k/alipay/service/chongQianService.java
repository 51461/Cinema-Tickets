package com.java98k.alipay.service;

import com.java98k.alipay.vo.chongQianPojo;

public interface chongQianService {
	String chongQian(chongQianPojo cq);
	Integer updateQian(Double allQian,String yhm);
	Integer update(String yhm);
	Integer saveDingDan(Integer palce,String[] ids,Integer changciid,String yhm);
	Integer saveDing(Integer changciid,String[] ids,String yhm);
}
