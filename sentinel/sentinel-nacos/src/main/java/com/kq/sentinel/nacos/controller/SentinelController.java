package com.kq.sentinel.nacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kq
 * @date 2021-03-24 16:54
 * @since 2020-0630
 */
@Slf4j
@RestController
public class SentinelController {

    private AtomicLong atomicLong = new AtomicLong();

    // helloBlockHandler要跟Sentinel Dashboard中的名称对应上
    @GetMapping(value = "/simpele/demo")
    @SentinelResource(value = "simpleDemoFlowRule",blockHandler = "helloBlockHandlerLogic")
    public String hello() throws Exception{

        long index = atomicLong.incrementAndGet();
        System.out.println("index="+index);
        if(index%5==0){
            TimeUnit.SECONDS.sleep(3);
        }

        return "Hello Sentinel";
    }

    public String helloBlockHandlerLogic(BlockException exception) {

        log.error("helloBlockHandler 触发限流！");

        return "helloBlockHandler 触发限流！"+exception.toString();

    }


}
