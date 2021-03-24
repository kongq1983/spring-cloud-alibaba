package com.kq.discovery.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kq
 * @date 2021-01-28 9:08
 * @since 2020-0630
 */

@RestController
public class EchoController {

    @Value("${server.port}")
    private Integer port;

    private AtomicInteger atomicInteger = new AtomicInteger();

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        String str = atomicInteger.incrementAndGet()+",EchoController.echo port=%d string=%s";
        System.out.println("EchoController echo is called. "+atomicInteger.get());
        return String.format(str,port,string);
    }
}