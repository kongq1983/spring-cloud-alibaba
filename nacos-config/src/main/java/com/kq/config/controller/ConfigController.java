package com.kq.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigController
 *
 * @author kq
 * @date 2021/2/22 21:44
 * @since 1.0.0
 */

@RestController
@RefreshScope
public class ConfigController {

    @Value("${my.name}")
    String name;

    @Value("${my.hobby}")
    String hobby;


    @RequestMapping("/config/info")
    public String info() {
        return "获取 Nacos Config配置如下：name="  + name + " hobby=" + hobby + "!";
    }

}
