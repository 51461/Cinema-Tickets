package com.java98k.alipay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java98k.alipay.vo.DianYingPojo;
import com.java98k.alipay.vo.ZhangDanPojo;


public interface DianYingDao {
	/**
	 * 根据id查询数据
	 */
	List<DianYingPojo> findAll();
	List<ZhangDanPojo> findByID(@Param("id")Integer id);
	List<DianYingPojo> findByZzry(@Param("id")Integer id);
	List<DianYingPojo> findByName(@Param("name") String name);
	int findByname(@Param("name")String name);
	Integer findByID2(@Param("name")String name);
	Integer updateZHPingFen(
			@Param("id") Integer id,
			@Param("zhpf") Double ZHPingFen);
	Integer findYongHuID(@Param("userName")String userName);
}
