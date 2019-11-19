package com.java98k.alipay.vo;

import java.io.Serializable;
import java.util.Date;

public class GrxxPojo implements Serializable{
	private static final long serialVersionUID = -8995648021105963182L;
	private String yongHuMing;
	private Integer yongHuDengJi;
	private Integer yuE;
	private Date shiJian;
	private String dianYingMingCheng;
	private Integer shiChang;
	private Integer zuoWeiPaiShu;
	private Integer zuoWeiLieShu;
	private String yinYuanMingCheng;
	
	public String getYinYuanMingCheng() {
		return yinYuanMingCheng;
	}
	public void setYinYuanMingCheng(String yingYuanMingCheng) {
		this.yinYuanMingCheng = yingYuanMingCheng;
	}
	public String getYongHuMing() {
		return yongHuMing;
	}
	public void setYongHuMing(String yongHuMing) {
		this.yongHuMing = yongHuMing;
	}
	public Integer getYongHuDengJi() {
		return yongHuDengJi;
	}
	public void setYongHuDengJi(Integer yongHuDengJi) {
		this.yongHuDengJi = yongHuDengJi;
	}
	public Integer getYuE() {
		return yuE;
	}
	public void setYuE(Integer yuE) {
		this.yuE = yuE;
	}
	public Date getShiJian() {
		return shiJian;
	}
	public void setShiJian(Date shiJian) {
		this.shiJian = shiJian;
	}
	public String getDianYingMingCheng() {
		return dianYingMingCheng;
	}
	public void setDianYingMingCheng(String dianYingMingCheng) {
		this.dianYingMingCheng = dianYingMingCheng;
	}
	public Integer getShiChang() {
		return shiChang;
	}
	public void setShiChang(Integer shiChang) {
		this.shiChang = shiChang;
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
		return "GrxxPojo [yongHuMing=" + yongHuMing + ", yongHuDengJi=" + yongHuDengJi + ", yuE=" + yuE + ", shiJian="
				+ shiJian + ", dianYingMingCheng=" + dianYingMingCheng + ", shiChang=" + shiChang + ", zuoWeiPaiShu="
				+ zuoWeiPaiShu + ", zuoWeiLieShu=" + zuoWeiLieShu + ", yinYuanMingCheng=" + yinYuanMingCheng + "]";
	}
	
	
}
