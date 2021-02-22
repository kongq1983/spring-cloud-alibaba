package com.kq.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kq
 * @date 2021-01-29 17:00
 * @since 2020-0630
 */
@RestController
public class RestEchoController {

    @Autowired // RibbonLoadBalancerClient
    private LoadBalancerClient loadBalancerClient;

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    AtomicInteger atomicInteger = new AtomicInteger();

    /**  这个是负载均衡的 */
    @Resource(name = "loadBlancerRestTemplate")
    private RestTemplate loadBlancerRestTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/echo/show")
    public String echoAppName(){
        //Access through the combination of LoadBalanceClient and RestTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-discovery");
        String path = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName);
        System.out.println("request path:" +path);
        return restTemplate.getForObject(path,String.class);
    }

    @GetMapping("/echo/blance")
    public String echoBlance(){

        //这边的nacos-discovery就是注册中心的注册别名
        //配置在yml文件的spring-application-name下
        String path = "http://nacos-discovery/echo/"+atomicInteger.incrementAndGet();

        return loadBlancerRestTemplate.getForObject(path,String.class);
    }

}
