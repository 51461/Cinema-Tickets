package com.java98k.alipay.dao;

import org.apache.ibatis.annotations.Param;

public interface ZhangDanDao {
	Integer saveDD(@Param("changCiID")Integer changCiID,
			@Param("yongHuID")Integer yongHuID,
			@Param("zuoWeiID")Integer zuoWeiID);
}
