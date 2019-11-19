package com.java98k.alipay.vo;

import java.io.Serializable;

public class YingTingPojo implements Serializable{
	private static final long serialVersionUID = 9155469811213704989L;
	private Integer yingTingID;
	private String yingTingMingCheng;
	private String yinYuanMingCheng;
	private String chengShi;
	private Integer paiShu;
	private Integer hangShu;
	private String diZhi;
	public Integer getYingTingID() {
		return yingTingID;
	}
	public void setYingTingID(Integer yingTingID) {
		this.yingTingID = yingTingID;
	}
	public String getYingTingMingCheng() {
		return yingTingMingCheng;
	}
	public void setYingTingMingCheng(String yingTingMingCheng) {
		this.yingTingMingCheng = yingTingMingCheng;
	}
	
	public String getYinYuanMingCheng() {
		return yinYuanMingCheng;
	}
	public void setYinYuanMingCheng(String yinYuanMingCheng) {
		this.yinYuanMingCheng = yinYuanMingCheng;
	}
	public String getChengShi() {
		return chengShi;
	}
	public void setChengShi(String chengShi) {
		this.chengShi = chengShi;
	}
	public Integer getPaiShu() {
		return paiShu;
	}
	public void setPaiShu(Integer paiShu) {
		this.paiShu = paiShu;
	}
	public Integer getHangShu() {
		return hangShu;
	}
	public void setHangShu(Integer hangShu) {
		this.hangShu = hangShu;
	}
	public String getDiZhi() {
		return diZhi;
	}
	public void setDiZhi(String diZhi) {
		this.diZhi = diZhi;
	}
	@Override
	public String toString() {
		return "YingTingPojo [yingTingID=" + yingTingID + ", yingTingMingCheng=" + yingTingMingCheng
				+ ", yinYuanMingCheng=" + yinYuanMingCheng + ", chengShi=" + chengShi + ", paiShu=" + paiShu
				+ ", hangShu=" + hangShu + ", diZhi=" + diZhi + "]";
	}
}
