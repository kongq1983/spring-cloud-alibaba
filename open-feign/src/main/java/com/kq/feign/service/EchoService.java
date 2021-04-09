package com.kq.feign.service;

import com.kq.feign.config.FeignConfiguration;
import com.kq.feign.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author kq
 * @date 2021-04-08 18:54
 * @since 2020-0630
 */
@FeignClient(name = "nacos-discovery", fallback = EchoServiceFallback.class, configuration = FeignConfiguration.class , contextId = "nacos-discovery-0")
public interface EchoService {

    @GetMapping(value = "/echo/{str}")
    String echo(@PathVariable("str") String str);

}