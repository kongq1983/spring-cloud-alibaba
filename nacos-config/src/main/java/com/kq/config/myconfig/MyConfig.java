package com.kq.config.myconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.time.LocalDateTime;

/**
 * MyConfig
 *
 * @author kq
 * @date 2021/3/15 21:44
 * @since 1.0.0
 */
@RefreshScope
@Component
public class MyConfig {

    @Value("${my.name}")
    String name;

    @Value("${my.hobby}")
    String hobby;

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    @PreDestroy
    public void destroy1() throws Exception {
        System.out.println(LocalDateTime.now()+",MyConfig is destory");
    }

    @Override
    public String toString() {
        return "MyConfig{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
