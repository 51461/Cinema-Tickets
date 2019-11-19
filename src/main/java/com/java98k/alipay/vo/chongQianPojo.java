package com.java98k.alipay.vo;

import java.io.Serializable;

public class chongQianPojo implements Serializable{
	private static final long serialVersionUID = -5070124520641042777L;
	private Integer yuE;
	private Integer huiYuanDengJi;
	public Integer getYuE() {
		return yuE;
	}
	public void setYuE(Integer yuE) {
		this.yuE = yuE;
	}
	public Integer getHuiYuanDengJi() {
		return huiYuanDengJi;
	}
	public void setHuiYuanDengJi(Integer huiYuanDengJi) {
		this.huiYuanDengJi = huiYuanDengJi;
	}
	@Override
	public String toString() {
		return "chongQianPojo [yuE=" + yuE + ", huiYuanDengJi=" + huiYuanDengJi + "]";
	}
}
