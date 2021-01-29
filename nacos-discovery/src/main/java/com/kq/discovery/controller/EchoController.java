package com.kq.discovery.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kq
 * @date 2021-01-28 9:08
 * @since 2020-0630
 */

@RestController
public class EchoController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        String str = "EchoController.echo port=%d string=%s";
        return String.format(str,port,string);
    }
}