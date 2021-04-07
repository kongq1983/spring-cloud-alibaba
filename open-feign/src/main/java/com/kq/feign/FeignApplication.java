package com.kq.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author kq
 * @date 2021-01-28 9:07
 * @since 2020-0630
 */
@SpringBootApplication
@EnableFeignClients
public class FeignApplication {


    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }


}
