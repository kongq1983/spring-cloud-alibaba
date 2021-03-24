package com.kq.sentinel.demo;

import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;

import java.net.InetAddress;

/**
 * @author kq
 * @date 2021-03-24 17:56
 * @since 2020-0630
 */
public class InetUtilsDemo {


    public static void main(String[] args) {
        InetAddress inetAddress = new InetUtils(new InetUtilsProperties()).findFirstNonLoopbackAddress();
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());
    }

}
