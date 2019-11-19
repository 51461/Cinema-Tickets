package com.java98k.alipay.service;

import com.alipay.api.AlipayApiException;
import com.java98k.alipay.bean.AlipayBean;

/*支付服务*/
public interface PayService {
    /*支付宝*/
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;
}
