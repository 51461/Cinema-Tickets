package com.java98k.alipay.vo;

import java.io.Serializable;

public class ChangCiBiao implements Serializable{
	private static final long serialVersionUID = 3567907684868099083L;
	private Integer id;
	private Integer dianYingID;
	private Integer yingTingID;
	private Double jiaGe;
	private String shiJIan;
	private String yingTingMingCheng;
	private String yingYuanMingCheng;
	private String city;
	private String fangYingShiJian;
	public String getFangYingShiJian() {
		return fangYingShiJian;
	}
	public void setFangYingShiJian(String fangYingShiJian) {
		this.fangYingShiJian = fangYingShiJian;
	}
	public String getYingYuanMingCheng() {
		return yingYuanMingCheng;
	}
	public void setYingYuanMingCheng(String yingYuanMingCheng) {
		this.yingYuanMingCheng = yingYuanMingCheng;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDianYingID() {
		return dianYingID;
	}
	public void setDianYingID(Integer dianYingID) {
		this.dianYingID = dianYingID;
	}
	public Integer getYingTingID() {
		return yingTingID;
	}
	public void setYingTingID(Integer yingTingID) {
		this.yingTingID = yingTingID;
	}
	public Double getJiaGe() {
		return jiaGe;
	}
	public void setJiaGe(Double jiaGe) {
		this.jiaGe = jiaGe;
	}
	public String getShiJIan() {
		return shiJIan;
	}
	public void setShiJIan(String shiJIan) {
		this.shiJIan = shiJIan;
	}
	public String getYingTingMingCheng() {
		return yingTingMingCheng;
	}
	public void setYingTingMingCheng(String yingTingMingCheng) {
		this.yingTingMingCheng = yingTingMingCheng;
	}
	public String getYinYuanMingCheng() {
		return yingYuanMingCheng;
	}
	public void setYinYuanMingCheng(String yinYuanMingCheng) {
		this.yingYuanMingCheng = yinYuanMingCheng;
	}
	@Override
	public String toString() {
		return "ChangCiBiao [id=" + id + ", dianYingID=" + dianYingID + ", yingTingID=" + yingTingID + ", jiaGe="
				+ jiaGe + ", shiJIan=" + shiJIan + ", yingTingMingCheng=" + yingTingMingCheng + ", yingYuanMingCheng="
				+ yingYuanMingCheng + ", city=" + city + ", fangYingShiJian=" + fangYingShiJian + "]";
	}
}
