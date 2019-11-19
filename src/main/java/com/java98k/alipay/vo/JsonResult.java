package com.java98k.alipay.vo;

import java.io.Serializable;
/**
 * 借助此对象封装控制层数据
 * 1）业务层返回数据
 * 2）状态码
 * 3）状态信息
 * @author Administrator
 */
public class JsonResult implements Serializable{
	private static final long serialVersionUID = -4138033536625725437L;
	/**状态码*/
	private int state=1;//1表示SUCCESS,0表示ERROR
	/**状态信息*/
	private String message="ok";
	/**正确数据(输出到客户端)*/
	private Object data;
	public JsonResult() {
	}
	public JsonResult(String message){
		this.message=message;
	}
	/**一般查询时调用，封装查询结果*/
	public JsonResult(Object data) {
		this.data=data;
	}
	/**出现异常时时调用*/
	public JsonResult(Throwable t){
		this.state=0;
		this.message=t.getMessage();
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
