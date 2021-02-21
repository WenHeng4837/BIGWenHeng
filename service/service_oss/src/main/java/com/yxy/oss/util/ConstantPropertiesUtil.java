package com.yxy.oss.util;
/**
 2
 * 常量类，读取配置文件application.properties中的配置
 3
 */

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:application.properties")
//@PropertySource("classpath:appclication.properties")???名字不一样靠
public class ConstantPropertiesUtil implements InitializingBean {
  /*  @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private String keyId;
    @Value("${aliyun.oss.file.keysecret}")
    private String keySecret;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;
    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;*/
    @Override
    public void afterPropertiesSet() throws Exception {
        //END_POINT = this.endpoint;
      //  ACCESS_KEY_ID = this.keyId;
      //  ACCESS_KEY_SECRET =this. keySecret;
       // BUCKET_NAME = this.bucketName;
    }
}