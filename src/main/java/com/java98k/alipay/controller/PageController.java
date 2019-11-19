package com.java98k.alipay.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.java98k.alipay.entity.SysUser;
import com.java98k.alipay.service.ChangCiService;
import com.java98k.alipay.service.DianYingService;
import com.java98k.alipay.service.PingLunService;
import com.java98k.alipay.service.YongHuService;
import com.java98k.alipay.service.chongQianService;
import com.java98k.alipay.vo.DianYingPojo;
import com.java98k.alipay.vo.ZhangDanPojo;
import com.java98k.alipay.vo.JsonResult;
import com.java98k.alipay.vo.SmsUtils;
import com.java98k.common.exception.ServiceException;


@Controller
@RequestMapping("/")
public class PageController {
	@Autowired
	private DianYingService dianYingService;
	@Autowired
	private YongHuService yongHuService;
	@Autowired
	private PingLunService pingLunService;
	@Autowired
	private chongQianService cq;
	@Autowired
	private ChangCiService changCiService;
	@RequestMapping("doSeatUI")
	public String doSeatUI() {
		return "donttaiseat";
	}
	@RequestMapping("sccess")
	public String sccess() {
		return "sccess";
	}
	@RequestMapping("pay/doPayUI")
	public String doPayUI() {
		return "pay";
	}
	@RequestMapping("pay/doPay")
	@ResponseBody
	public JsonResult doPay(@RequestParam("ids[]")String[] ids,Integer changciid) {
		Integer palce = changCiService.findByChangCiID(changciid);
		int c=ids.length;
		return new JsonResult(palce*c);
	}
	@RequestMapping("pay/doYuE")
	@ResponseBody
	public JsonResult doYuE(Integer palce,String[] ids,Integer changciid,String yhm) {
		Integer rows = cq.saveDingDan(palce, ids, changciid, yhm);
		System.out.println(rows);
		return new JsonResult("pay ok");
	}
	@RequestMapping("pay/doZhiFuB")
	@ResponseBody
	public JsonResult doZhiFuB(Integer changciid,String[] ids,String yhm) {
		Integer rows = cq.saveDing(changciid, ids, yhm);
		System.err.println("rows="+rows);
		return new JsonResult("pay ok");
	}
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}

	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(boolean isRememberMe,String username, String password) {
		// 提交用户信息到业务层
		// 1.获取主体对象（Subject）
		Subject subject = SecurityUtils.getSubject();
		// 2.提交信息（提交给shiro的securityManager）
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		if(isRememberMe) {
			token.setRememberMe(true); 
		}
		System.out.println(username);
		System.out.println(password);
		JsonResult r=new JsonResult(); 
//		try { subject.login(token); } 
//		catch (UnknownAccountException e) {
//			e.printStackTrace();
//			r.setState(0); 
//			r.setMessage("用户名不存在！！！"); 
//			return r; }
//		catch (IncorrectCredentialsException e) {
//			e.printStackTrace();
//			r.setState(0);
//			r.setMessage("密码不正确！！！"); 
//			return r; 
//		}
		subject.login(token);
		return new JsonResult("login ok");
	}

	@RequestMapping("doForgetPwdUI")
	public String doForgetPwdUI() {
		return "forgetPwd";
	}

	@RequestMapping("doRegisterUI")
	public String doRegisterUI() {
		return "register";
	}
	@RequestMapping("doDianYing")
	@ResponseBody
	public JsonResult doDianYing(Integer id){
		List<ZhangDanPojo> list = dianYingService.findByID(id);
		JsonResult jsonResult = new JsonResult(list);
		System.out.println(list);
		return jsonResult;
	}
	@RequestMapping("doQiTaUI")
	public String doQiTaUI() {
		return "qtlogin";
	}
	@RequestMapping("doWangJiMiMa")
	@ResponseBody
	public JsonResult doWangJiMiMa(String phone){
		if (phone==null||StringUtils.isEmpty(phone)) {
			throw new IllegalArgumentException("手机号不能为空");
		}
		int rows = yongHuService.findByPhone(phone);
		if (rows==0) {
			throw new ServiceException("该手机号还未注册,请前往注册");
		}
		System.out.println("rows="+rows);
		System.out.println("phone="+phone);
		int newcode = (int)(Math.random()*9999)+100;  //每次调用生成一位四位数的随机数
		String code=Integer.toString(newcode);
		System.err.println(code);
		SendSmsResponse sendSms=null;
		try {
			sendSms= SmsUtils.sendSms(phone, code, "SMS_165414522");
		} catch (ClientException e) {
			e.printStackTrace();
		}
		System.err.println(sendSms.getMessage());
		return new JsonResult(code);
	}
	@RequestMapping("doZhuCe")
	@ResponseBody
	public JsonResult doZhuCe(SysUser entity) {
		//String username,String password,String phone
		System.out.println(entity.getYongHuMing());
		System.out.println(entity);
		int rows=0;
		try {
			rows = yongHuService.insertUser(entity);
		} catch (Exception e) {
			throw new ServiceException("用户名重复");
		}
		if (rows==0) {
			throw new ServiceException("注册失败");
		}
		return new JsonResult("注册 OK！");
	}
	@RequestMapping("doYanZheng")
	@ResponseBody
	public JsonResult doYanZheng(String phone) {
		System.err.println("*****************************");
		System.out.println(phone);
		int rows=0;
		try {
			rows = yongHuService.findByPhone(phone);
		} catch (Exception e) {
			System.err.println("chaxuncuowu ");
		}
		if (rows!=0) {
			throw new ServiceException("该手机号已注册,请前往登录");
		}
		int newcode = (int)(Math.random()*9999)+100;  //每次调用生成一位四位数的随机数
		String code=Integer.toString(newcode);
		System.err.println(code);
		SendSmsResponse sendSms=null;
		try {
			sendSms= SmsUtils.sendSms(phone, code, "SMS_165414518");
		} catch (ClientException e) {
			e.printStackTrace();
		}
		System.err.println(sendSms.getMessage());
		return new JsonResult(code);
	}
	@RequestMapping("doDLYanZheng")
	@ResponseBody
	public JsonResult doDLYanZheng(String phone) {
		if (phone==null||StringUtils.isEmpty(phone)) {
			throw new IllegalArgumentException("手机号不能为空");
		}
		int rows = yongHuService.findByPhone(phone);
		if (rows==0) {
			throw new ServiceException("该手机号还未注册,请前往注册");
		}
		System.out.println("rows="+rows);
		System.err.println("*****************************");
		System.out.println(phone);
		int newcode = (int)(Math.random()*9999)+100;  //每次调用生成一位四位数的随机数
		String code=Integer.toString(newcode);
		System.err.println("验证码为："+code);
		SendSmsResponse sendSms=null;
		try {
			sendSms= SmsUtils.sendSms(phone, code, "SMS_165414524");
		} catch (ClientException e) {
			e.printStackTrace();
		}
		System.err.println(sendSms.getMessage());
		return new JsonResult(code);
	}

	@RequestMapping("doIndexUI")
	public String doIndexUI(){
		return "index";
	}
	@RequestMapping("doDianYingUI")
	public String doDianYingUI(){
		return "dianying";
	}
	@RequestMapping("doDianYing2")
	public String doDianYing2(){
		return "dianying";
	}
	@RequestMapping("doZzryUI")
	public String doZzryUI(){
		return "zzry";
	}
	@RequestMapping("doZzry")
	@ResponseBody
	public JsonResult doZzry(Integer id){	
		List<DianYingPojo> w=dianYingService.findByZzry(id);
		return new JsonResult(w);
	}
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "page";
	}

	@RequestMapping("doGouPiaoUI")
	public String doGouPiaoUI() {
		return "goupiao";
	}
	@RequestMapping("doMaiPiaoUI")
	public String doMaiPiaoUI() {
		return "yingting";
	}
	@RequestMapping("doGrxxUI")
	public String doGrxxUI(){
		return "user";
	}

}
