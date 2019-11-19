package com.java98k;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.java98k.alipay.dao")
/**
 * @author chents
 * @date 2019-05-20 15:26
 * 启动类
 */
public class AlipayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlipayDemoApplication.class,args);
	}
}
