package com.java98k.alipay.service.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.java98k.alipay.config.BadWordUtil;
import com.java98k.alipay.service.SysBadWordService;
import com.java98k.common.exception.ServiceException;
@Service
public class SysBadWordServiceImpl implements SysBadWordService{

	@Override
	public String findBadWord(String content) {
		Set<String> s = BadWordUtil.words;
		Map<String,String> map = BadWordUtil.wordMap;
		//判断是否存在敏感词
		Boolean i = BadWordUtil.isContaintBadWord(content, 1);
		System.out.println(i);
		//获得敏感词
		Set<String> set = BadWordUtil.getBadWord(content, 1);//匹配规则 1：最小匹配规则，2：最大匹配规则
		String message="语句中包含敏感词的个数为：" + set.size() + "。包含：" + set;
		if(i==true) {
			throw new ServiceException(message);
		}
		return message;
	}

}
