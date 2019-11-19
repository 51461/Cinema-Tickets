package com.java98k.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.java98k.alipay.bean.AlipayBean;
import com.java98k.alipay.service.PayService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/* 订单接口 */
@RestController()
@RequestMapping("order")
public class OrderController {
    @Resource
    private PayService payService;//调用支付服务
    /*阿里支付*/
    @PostMapping(value = "alipay")
    public String alipay(String out_trade_no,String subject,String total_amount,String body) throws AlipayApiException {
    	AlipayBean bean=new AlipayBean();
    	bean.setOut_trade_no(out_trade_no);
    	bean.setSubject(subject);
    	bean.setTotal_amount(total_amount);
    	bean.setBody(body);
        return  payService.aliPay(bean);
    }
}
