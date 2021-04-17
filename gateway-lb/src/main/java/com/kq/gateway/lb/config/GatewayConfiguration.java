package com.kq.gateway.lb.config;

import org.springframework.context.annotation.Configuration;

/**
 * GatewayConfiguration
 *
 * @author kq
 * @date 2021/2/23 21:55
 * @since 1.0.0
 */
@Configuration
public class GatewayConfiguration {


//    routes:
//    - id: jd_route
//    uri: http://www.jd.com
//    predicates:
//            - Path=/jd
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes().route(r->r.path("/jd")
//                .uri("http://jd.com").id("jd_route")).build();
//
//    }

//    @Bean
//    public RouteLocator customRouteLocatorAfterTime(RouteLocatorBuilder builder) {
//
//        ZonedDateTime minusTime = LocalDateTime.now().minusHours(1).atZone(ZoneId.systemDefault());
//
//        return builder.routes().route("after_baidu_route",r-> r.after(minusTime)
//                .uri("http://baidu.com")).build();
//
//    }


}
