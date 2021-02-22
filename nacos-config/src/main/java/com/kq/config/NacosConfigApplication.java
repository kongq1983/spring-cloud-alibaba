package com.kq.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * NacosConfigApplication
 *
 * @author kq
 * @date 2021/2/22 21:03
 * @since 1.0.0
 */
@SpringBootApplication
public class NacosConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigApplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("my.name");
        String hobby = applicationContext.getEnvironment().getProperty("my.hobby");
        System.err.println("user name :" +userName+"; hobby: "+hobby);
    }




}
