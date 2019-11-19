package com.java98k.alipay.service;

import com.java98k.alipay.vo.PageObject;

public interface PageService<T> {
	 PageObject<T> findPageObjects(
			 String jiJiangShangYing,Integer pageCurrent);
}
