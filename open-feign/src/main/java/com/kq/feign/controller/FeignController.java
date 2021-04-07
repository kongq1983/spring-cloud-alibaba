package com.kq.feign.controller;

import com.kq.dto.DtoResult;
import com.kq.feign.service.FeignService;
import feign.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FeignController
 *
 * @author kq
 * @date 2021/4/7 23:25
 * @since 1.0.0
 */
@RestController
public class FeignController {

    protected static Logger logger = LoggerFactory.getLogger(FeignController.class);

    @Autowired
    private FeignService feignService;

    @RequestMapping("/feign/{userId}")
    public DtoResult findOrderByUserId(@PathVariable("userId") String userId) {;

        logger.info("controller receive userId={}",userId);
        return feignService.findOrderByUserId(userId);

    }




}
