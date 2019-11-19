package com.java98k.alipay.service.impl;

import com.alipay.api.AlipayApiException;
import com.java98k.alipay.bean.AlipayBean;
import com.java98k.alipay.config.AlipayUtil;
import com.java98k.alipay.service.PayService;

import org.springframework.stereotype.Service;

/* 支付服务 */
@Service("payService")
public class PayServiceImpl implements PayService {
    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return AlipayUtil.connect(alipayBean);
    }
}
