package com.java98k.alipay.service;

import com.java98k.alipay.vo.DianYingPojo;

public interface ZzryService extends PageService<DianYingPojo>{
	   /**
	    * 基于id删除日志信息
	    * @param ids
	    * @return
	    */
	   int deleteObjects(Integer... ids);

}







