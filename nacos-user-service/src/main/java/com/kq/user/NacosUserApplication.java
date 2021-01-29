package com.kq.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author kq
 * @date 2021-01-29 16:56
 * @since 2020-0630
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosUserApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {

        SpringApplication.run(NacosUserApplication.class,args);
    }

}
