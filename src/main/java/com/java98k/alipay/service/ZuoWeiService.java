package com.java98k.alipay.service;

import java.util.List;

import com.java98k.alipay.vo.ZuoWeiBiao;

public interface ZuoWeiService {
	List<ZuoWeiBiao> findByChangCiIDs(String yynm,String ytnm,String sj,String fysj);
}
