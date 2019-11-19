package com.java98k.alipay.vo;
import java.io.Serializable;
import java.sql.Date;

public class DianYingPojo implements Serializable{
	private static final long serialVersionUID = -3680543093024711690L;
	
	private Integer dianYingID;
	private String dianYingMingCheng;
	private String dianYingJieShao;
	private Date shiJian;
	private Integer shiChang;
	private String dianYingTuPian;
	private Integer dianYingZongHePingFen;
	private String dianYingLeiXing;
	private String dianYingQuYu;
	
	public Integer getDianYingID() {
		return dianYingID;
	}
	public void setDianYingID(Integer dianYingID) {
		this.dianYingID = dianYingID;
	}
	public String getDianYingMingCheng() {
		return dianYingMingCheng;
	}
	public void setDianYingMingCheng(String dianYingMingCheng) {
		this.dianYingMingCheng = dianYingMingCheng;
	}
	public String getDianYingJieShao() {
		return dianYingJieShao;
	}
	public void setDianYingJieShao(String dianYingJieShao) {
		this.dianYingJieShao = dianYingJieShao;
	}
	public Date getshiJian() {
		return shiJian;
	}
	public void setshiJian(Date shiJian) {
		this.shiJian = shiJian;
	}
	public Integer getShiChang() {
		return shiChang;
	}
	public void setShiChang(Integer shiChang) {
		this.shiChang = shiChang;
	}
	public String getDianYingTuPian() {
		return dianYingTuPian;
	}
	public void setDianYingTuPian(String dianYingTuPian) {
		this.dianYingTuPian = dianYingTuPian;
	}
	public Integer getDianYingZongHePingFen() {
		return dianYingZongHePingFen;
	}
	public void setDianYingZongHePingFen(Integer dianYingZongHePingFen) {
		this.dianYingZongHePingFen = dianYingZongHePingFen;
	}
	public String getDianYingLeiXing() {
		return dianYingLeiXing;
	}
	public void setDianYingLeiXing(String dianYingLeiXing) {
		this.dianYingLeiXing = dianYingLeiXing;
	}
	public String getDianYingQuYu() {
		return dianYingQuYu;
	}
	public void setDianYingQuYu(String dianYingQuYu) {
		this.dianYingQuYu = dianYingQuYu;
	}
	@Override
	public String toString() {
		return "DianYingPojo [dianYingID=" + dianYingID + ", dianYingMingCheng=" + dianYingMingCheng
				+ ", dianYingJieShao=" + dianYingJieShao + ", shiJian=" + shiJian + ", shiChang="
				+ shiChang + ", dianYingTuPian=" + dianYingTuPian + ", dianYingZongHePingFen=" + dianYingZongHePingFen
				+ ", dianYingLeiXing=" + dianYingLeiXing + ", dianYingQuYu=" + dianYingQuYu + "]";
	}
}
