package com.kq.feign.fallback;

import com.kq.feign.service.EchoService;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author kq
 * @date 2021-04-08 18:55
 * @since 2020-0630
 */
public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(@PathVariable("str") String str) {
        return "echo fallback";
    }

}
