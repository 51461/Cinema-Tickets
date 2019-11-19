package com.java98k.alipay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java98k.alipay.vo.DianYingPojo;

/**
 * spring-respository.xml 此
 * 文件中定义了一个MapperScannerConfigurer
 * 对象,此对象会对BasePackage属性指定的包
 * 下接口进行扫描,然后会为接口创建实现类的对象,
 * 并将这个对象存储到bean池,其key为接口名(首字母小写).
 */
public interface ZzryDao {//SysLogDao.class
	  /**
	   * 依据查询条件从起始位置startIndex获取
	   * 当前页日志信息
	   * @param username 查询条件
	   * @param startIndex 当前页起始位置
	   * @param pageSize 当前页的页面大小(
	   * 当前页最多查询多少条件记录)
	   * @return 当前页的日志记录信息
	   */
	  List<DianYingPojo> findPageObjects(
			  @Param("jiJiangShangYing")String jiJiangShangYing,
			  @Param("startIndex")Integer startIndex,
			  @Param("pageSize")Integer pageSize);
	  /**
	   * 依据条件统计用户行为日志总数
	   * @param username 查询条件(操作用户)
	   * @return 总记录数
	   * 说明:假如方法参数应用在动态SQL,两种方式:
	   * 1)参数使用@Param进行定义(推荐)
	   * 2)使用参数_paramter (不好记)-->了解
	   */
	  int getRowCount(@Param("jiJiangShangYing")String jiJiangShangYing);
	  /**
	   * 执行日志删除操作
	   * @param id
	   * @return
	   */
	  int deleteObjects(@Param("ids")Integer... id);
}
