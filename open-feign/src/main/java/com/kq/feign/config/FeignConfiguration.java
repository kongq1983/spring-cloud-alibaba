package com.kq.feign.config;

import com.kq.feign.fallback.EchoServiceFallback;
import org.springframework.context.annotation.Bean;

/**
 * @author kq
 * @date 2021-04-08 18:56
 * @since 2020-0630
 */
public class FeignConfiguration {

    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }

}
