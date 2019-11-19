package com.java98k.alipay.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.regions.ProductDomain;

public class SmsUtils {
	public static final String product="Dysmsapi";
	public static final String domain = "dysmsapi.aliyuncs.com";
	public static final String accessKeyId = "LTAIUzgw22et5sm6";
	public static final String accessKeySecret = "HIuKfLUMu91LmEXb54JATiXdlVtk5A";
	public static SendSmsResponse sendSms(String tel,String code,String templateCode) throws ClientException {
		System.setProperty("sun.net.client.defaultConnectTimeout", "60000");
        System.setProperty("sun.net.client.defaultReadTimeout", "60000s");
		IClientProfile profile = DefaultProfile.getProfile("cn-beijing", accessKeyId, accessKeySecret);
		IAcsClient acsClient = new DefaultAcsClient(profile);
		SendSmsRequest request = new SendSmsRequest();
		ProductDomain pro = new ProductDomain(product, domain);
		//必填:待发送手机号
		request.setPhoneNumbers(tel);
		//必填:短信签名-可在短信控制台中找到
		request.setSignName("兄弟盟电影院");
		//必填:短信模板-可在短信控制台中找到
		request.setTemplateCode(templateCode);
		//模板中的变量替换JSON串
		request.setTemplateParam("{\"code\":"+code+"}");
		request.setProductDomain(pro);
		//可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		request.setOutId("yourOutId");
		SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
		if(sendSmsResponse.getCode()!= null && "OK".equals(sendSmsResponse.getCode())){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
		return sendSmsResponse;
	}
//	public static QuerySendDetailsResponse querySendDetails(String bizId) {
//		//可自助调整超时时间
//		System.setProperty("sun.net.client.defaultConnectTimeout", "60000");
//		System.setProperty("sun.net.client.defaultReadTimeout", "60000");
//		//初始acsClient对象
//		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
//		try {
//			DefaultProfile.addEndpoint("cn-shanghai", "cn-hangzhou", product, domain);
//		} catch (ClientException e) {
//			e.printStackTrace();
//		}
//		IAcsClient acsClient = new DefaultAcsClient(profile);
//		//组装请求对象
//		QuerySendDetailsRequest request = new QuerySendDetailsRequest();
//		//必填-待发送的手机号码
//		request.setPhoneNumber("18332258810");
//		//可选-流水号
//		request.setBizId(bizId);
//		//必填-发送日期 支持30天内记录查询，格式yyyyMMdd
//		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
//		request.setSendDate(ft.format(new Date()));
//		//必填-页大小
//		request.setPageSize(10L);
//		//必填-当前页码从1开始计数
//		request.setCurrentPage(1L);
//		QuerySendDetailsResponse querySendDetailsResponse =null;
//        try {
//        	querySendDetailsResponse= acsClient.getAcsResponse(request);
//		} catch (ClientException e) {
//			e.printStackTrace();
//		}
//		return querySendDetailsResponse;
//	}
	private static int newcode;
    public static int getNewcode() {
        return newcode;
    }
    public static void setNewcode(){
        newcode = (int)(Math.random()*9999)+100;  //每次调用生成一位四位数的随机数
    }
//    public static void main(String[] args) throws ClientException, InterruptedException {
//        setNewcode();
//        String code = Integer.toString(getNewcode());
//        System.out.println("发送的验证码为："+code);
//        //发短信
//        SendSmsResponse response =sendSms("18435204724",code, "SMS_165414518"); // TODO 填写你需要测试的手机号码
//        System.out.println("短信接口返回的数据----------------");
//        System.out.println("Code=" + response.getCode());
//        System.out.println("Message=" + response.getMessage());
//        System.out.println("RequestId=" + response.getRequestId());
//        System.out.println("BizId=" + response.getBizId());
//        System.out.println("--------------------------------------");
//        if(response.getCode() != null && response.getCode().equals("OK")) {
//            QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(response.getBizId());
//            System.out.println("短信明细查询接口返回数据----------------");
//            System.out.println("Code=" + querySendDetailsResponse.getCode());
//            System.out.println("Message=" + querySendDetailsResponse.getMessage());
//            int i = 0;
//            for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
//            {
//                System.out.println("SmsSendDetailDTO["+i+"]:");
//                System.out.println("Content=" + smsSendDetailDTO.getContent());
//                System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
//                System.out.println("OutId=" + smsSendDetailDTO.getOutId());
//                System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
//                System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
//                System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
//                System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
//                System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
//            }
//            System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
//            System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
//        }
//    }
}
