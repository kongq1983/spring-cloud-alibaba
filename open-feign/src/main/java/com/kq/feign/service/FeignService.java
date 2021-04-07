package com.kq.feign.service;

import com.kq.dto.DtoResult;
import feign.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "nacos-discovery")
public interface FeignService {

    static Logger logger = LoggerFactory.getLogger(FeignService.class);

    @RequestMapping("/feign/string/{userId}")
    public DtoResult findOrderByUserId(@PathVariable("userId") String userId);

}
