package com.kq.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author kq
 * @date 2021-01-28 9:07
 * @since 2020-0630
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryApplication2 {


    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryApplication2.class, args);
    }


}
