package com.java98k.alipay.service.impl;

import org.springframework.stereotype.Service;

import com.java98k.alipay.config.IPUtils;
import com.java98k.alipay.service.SysIpService;
import com.java98k.alipay.vo.SysIpVo;
@Service
public class SysIpServiceImpl implements SysIpService{

	@Override
	public SysIpVo findIp() {
		String message = IPUtils.getIP();
    	String splitIp = message.substring(28, message.length()-3);
    	String[] s1 = splitIp.split(",");
    	/**最终的ip*/
    	String ip = s1[0].substring(0, s1[0].length()-1);
    	String[] s2 = s1[2].split(": \"");
    	/**最终的address*/
    	String address = s2[1];
        System.out.println(ip);
        System.out.println(address);
		SysIpVo sysIpVo = new SysIpVo();
		sysIpVo.setAddress(address);
		sysIpVo.setIp(ip);
		return sysIpVo;
	}

}
