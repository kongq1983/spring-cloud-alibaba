package com.kq.config.controller;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;
import java.time.LocalDateTime;

/**
 * ConfigController
 *
 * @author kq
 * @date 2021/2/22 21:44
 * @since 1.0.0
 */

@RestController
@RefreshScope
public class ConfigController1 implements DisposableBean {

    @Value("${my.name}")
    String name;

    @Value("${my.hobby}")
    String hobby;


    @RequestMapping("/config1/info")
    public String info() {
        return "获取 Nacos ConfigController1 配置如下：name="  + name + " hobby=" + hobby + "!" + this.toString();
    }


    @Override
    public void destroy() throws Exception {
        System.out.println(LocalDateTime.now()+",ConfigController1 is destory");
    }

    @PreDestroy
    public void destroy1() throws Exception {
        System.out.println(LocalDateTime.now()+",ConfigController1 is destory1");
    }
}
