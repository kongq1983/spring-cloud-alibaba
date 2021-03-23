package com.kq.config.controller;

import com.kq.config.myconfig.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MyConfigController
 *
 * @author kq
 * @date 2021/3/15 22:09
 * @since 1.0.0
 */
@RestController
public class MyConfigController {

    @Autowired
    private MyConfig myConfig;


    @RequestMapping("/myconfig/info")
    public String info() {
        return "获取 Nacos Config配置如下：name="  + myConfig.getName() + " hobby=" + myConfig.getHobby() + "!";
    }

}
