package com.java98k.alipay.service;

import java.util.List;

import com.java98k.alipay.vo.GrxxPojo;


public interface GrxxService {
	List<GrxxPojo> findByYHID(String id);
}
