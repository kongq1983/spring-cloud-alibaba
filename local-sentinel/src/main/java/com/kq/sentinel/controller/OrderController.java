package com.kq.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kq
 * @date 2021-08-10 16:25
 * @since 2020-0630
 */
@Slf4j
@RestController
public class OrderController {

    private AtomicLong atomicLong = new AtomicLong();

    @GetMapping(value = "/order/add")
    @SentinelResource(value = "orderAdd",blockHandler = "helloBlockHandlerLogic",fallback="fallbackHandlerLogic")
    public String hello() throws Exception{

        long index = atomicLong.incrementAndGet();
        if(index%5==0){
            throw new Exception("exception=index="+index);
        }

        return index+"";
    }

    /**
     * 限流
     * @param exception
     * @return
     */
    public String helloBlockHandlerLogic(BlockException exception) {

        return "helloBlockHandler Order Save 触发限流！" +exception.toString();

    }

    /**
     * 降级
     * @param exception
     * @return
     */
    public String fallbackHandlerLogic(BlockException exception) {

        log.error("fallbackHandlerLogic Order Save 触发限流！");

        if(exception!=null) {
            return "fallbackHandlerLogic Order Save 触发限流！" + exception.toString();
        }else {
            return "fallbackHandlerLogic Order Save 触发限流！";
        }

    }


}
