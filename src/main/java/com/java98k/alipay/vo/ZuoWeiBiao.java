package com.java98k.alipay.vo;

import java.io.Serializable;

public class ZuoWeiBiao implements Serializable{
	private static final long serialVersionUID = 4246203032094017029L;
	private Integer zuoWeiBiaoID;
	private Integer changCiID;
	private Integer zuoWeiPaiShu;
	private Integer zuoWeiLieShu;
	public Integer getZuoWeiBiaoID() {
		return zuoWeiBiaoID;
	}
	public void setZuoWeiBiaoID(Integer zuoWeiBiaoID) {
		this.zuoWeiBiaoID = zuoWeiBiaoID;
	}
	public Integer getChangCiID() {
		return changCiID;
	}
	public void setChangCiID(Integer changCiID) {
		this.changCiID = changCiID;
	}
	public Integer getZuoWeiPaiShu() {
		return zuoWeiPaiShu;
	}
	public void setZuoWeiPaiShu(Integer zuoWeiPaiShu) {
		this.zuoWeiPaiShu = zuoWeiPaiShu;
	}
	public Integer getZuoWeiLieShu() {
		return zuoWeiLieShu;
	}
	public void setZuoWeiLieShu(Integer zuoWeiLieShu) {
		this.zuoWeiLieShu = zuoWeiLieShu;
	}
	@Override
	public String toString() {
		return "ZuoWeiBiao [zuoWeiBiaoID=" + zuoWeiBiaoID + ", changCiID=" + changCiID + ", zuoWeiPaiShu="
				+ zuoWeiPaiShu + ", zuoWeiLieShu=" + zuoWeiLieShu + "]";
	}
	
}
