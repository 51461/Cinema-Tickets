package com.java98k.alipay.entity;

import java.io.Serializable;

public class SysUser implements Serializable{
	private static final long serialVersionUID = 8271686677568452479L;
	private Integer yongHuID;
	private String yongHuMing;
	private String miMa;
	private String salt;//盐值
	private Integer yongHuDengJi;
	private String phone;
	private Integer zhangDanID;
	private Double yuE;
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getYongHuID() {
		return yongHuID;
	}
	public void setYongHuID(Integer yongHuID) {
		this.yongHuID = yongHuID;
	}
	public String getYongHuMing() {
		return yongHuMing;
	}
	public void setYongHuMing(String yongHuMing) {
		this.yongHuMing = yongHuMing;
	}
	public String getMiMa() {
		return miMa;
	}
	public void setMiMa(String miMa) {
		this.miMa = miMa;
	}
	public Integer getYongHuDengJi() {
		return yongHuDengJi;
	}
	public void setYongHuDengJi(Integer yongHuDengJi) {
		this.yongHuDengJi = yongHuDengJi;
	}
	public Integer getZhangDanID() {
		return zhangDanID;
	}
	public void setZhangDanID(Integer zhangDanID) {
		this.zhangDanID = zhangDanID;
	}
	public Double getYuE() {
		return yuE;
	}
	public void setYuE(Double yuE) {
		this.yuE = yuE;
	}
	@Override
	public String toString() {
		return "SysUser [yongHuID=" + yongHuID + ", yongHuMing=" + yongHuMing + ", miMa=" + miMa + ", salt=" + salt
				+ ", yongHuDengJi=" + yongHuDengJi + ", phone=" + phone + ", zhangDanID=" + zhangDanID + ", yuE=" + yuE
				+ "]";
	}
}

