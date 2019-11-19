package com.java98k.alipay.vo;

import java.io.Serializable;
import java.util.Date;

public class PingLunPojo implements Serializable{
	private static final long serialVersionUID = 3950192758196550975L;
	private Integer pingJiaID; 
	private Integer pingFen;
	private String pingLun;
	private Integer dianYingID;
	private Date shiJian;
	private Integer yongHuID;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPingJiaID() {
		return pingJiaID;
	}
	public void setPingJiaID(Integer pingJiaID) {
		this.pingJiaID = pingJiaID;
	}
	public Integer getPingFen() {
		return pingFen;
	}
	public void setPingFen(Integer pingFen) {
		this.pingFen = pingFen;
	}
	public String getPingLun() {
		return pingLun;
	}
	public void setPingLun(String pingLun) {
		this.pingLun = pingLun;
	}
	public Integer getDianYingID() {
		return dianYingID;
	}
	public void setDianYingID(Integer dianYingID) {
		this.dianYingID = dianYingID;
	}
	public Date getShiJian() {
		return shiJian;
	}
	public void setShiJian(Date shiJian) {
		this.shiJian = shiJian;
	}
	public Integer getYongHuID() {
		return yongHuID;
	}
	public void setYongHuID(Integer yongHuID) {
		this.yongHuID = yongHuID;
	}
	@Override
	public String toString() {
		return "PingLunPojo [pingJiaID=" + pingJiaID + ", pingFen=" + pingFen + ", pingLun=" + pingLun + ", dianYingID="
				+ dianYingID + ", shiJian=" + shiJian + ", yongHuID=" + yongHuID + ", name=" + name + "]";
	}
	
	
}
