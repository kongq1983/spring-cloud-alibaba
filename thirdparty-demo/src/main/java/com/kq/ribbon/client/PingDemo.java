package com.kq.ribbon.client;

import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;

/**
 * @author kq
 * @date 2021-04-01 8:38
 * @since 2020-0630
 */
public class PingDemo {

    public static void main(String[] args) {
        PingUrl p = new PingUrl(false,"/yt02login");
//        p.setExpectedContent("true"); // 期望返回值  如果设置了这个值，则返回值一样，isAlive才等于true
        Server s = new Server("wwww.baidu.com", 80);

        boolean isAlive = p.isAlive(s);
        System.out.println("isAlive:" + isAlive);
    }

}
