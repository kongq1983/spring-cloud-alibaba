package com.kq.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-04-02 11:00
 * @since 2020-0630
 */

@Component
@ConfigurationProperties("my.bean")
public class MyProperties {

    private String id;
    private String ip;
    private String load;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", load='" + load + '\'' +
                '}';
    }
}
