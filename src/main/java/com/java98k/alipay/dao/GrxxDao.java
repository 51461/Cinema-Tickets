package com.java98k.alipay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java98k.alipay.vo.GrxxPojo;


public interface GrxxDao {
	 List<GrxxPojo> findByYHID(@Param("id")String id);
}
