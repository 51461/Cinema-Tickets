package com.java98k.alipay.vo;

import java.io.Serializable;

public class SysIpVo implements Serializable{
	private static final long serialVersionUID = 6309316860381232279L;
	/**封装ip地址*/
	private String ip;
	/**封装具体地址*/
	private String address;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
