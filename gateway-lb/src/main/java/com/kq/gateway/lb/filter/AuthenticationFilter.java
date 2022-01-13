package com.kq.gateway.lb.filter;

import com.kq.gateway.lb.common.ResultCode;
import com.kq.gateway.lb.exception.GateWayException;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Set;

/**
 * @author kq
 * @date 2022-01-13 17:12
 * @since 2020-0630
 */

@Component
@Order(0)
//@EnableConfigurationProperties(value = NotAuthUrlProperties.class)
@Slf4j
public class AuthenticationFilter implements GlobalFilter, InitializingBean {

    private Set<String> skipUrls;


    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String currentUrl = exchange.getRequest().getURI().getPath();

        //过滤不需要认证的url
        if(shouldSkip(currentUrl)) {
            //log.info("跳过认证的URL:{}",currentUrl);
            return chain.filter(exchange);
        }
        //log.info("需要认证的URL:{}",currentUrl);

        //2. 获取token
        // 从请求头中解析 Authorization  value:  bearer xxxxxxx
        // 或者从请求参数中解析 access_token
        //第一步:解析出我们Authorization的请求头  value为: “bearer XXXXXXXXXXXXXX”
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");

        //第二步:判断Authorization的请求头是否为空
        if(StringUtils.isEmpty(authHeader)) {
            log.warn("需要认证的url,请求头为空");
            throw new GateWayException(ResultCode.AUTHORIZATION_HEADER_IS_EMPTY);
        }

        //3. 校验token
        // 拿到token后，通过公钥（需要从授权服务获取公钥）校验
        // 校验失败或超时抛出异常
        //第三步 校验我们的jwt 若jwt不对或者超时都会抛出异常
//        Claims claims = JwtUtils.validateJwtToken(authHeader,publicKey);

        //4. 校验通过后，从token中获取的用户登录信息存储到请求头中
        //第四步 把从jwt中解析出来的 用户登陆信息存储到请求头中
        ServerWebExchange webExchange = wrapHeader(exchange);

        return chain.filter(webExchange);

    }

    private ServerWebExchange wrapHeader(ServerWebExchange serverWebExchange) {

//        String loginUserInfo = JSON.toJSONString(claims);
//
//        //log.info("jwt的用户信息:{}",loginUserInfo);
//
//        String memberId = claims.get("additionalInfo", Map.class).get("memberId").toString();
//
//        String nickName = claims.get("additionalInfo",Map.class).get("nickName").toString();

        //向headers中放文件，记得build
        ServerHttpRequest request = serverWebExchange.getRequest().mutate()
//                .header("username",claims.get("user_name",String.class))
//                .header("memberId",memberId)
//                .header("nickName",nickName)
                .header("from","gateway")
                .build();

        //将现在的request 变成 change对象
        return serverWebExchange.mutate().request(request).build();
    }


    private boolean shouldSkip(String currentUrl) {
        //路径匹配器(简介SpringMvc拦截器的匹配器)
        //比如/oauth/** 可以匹配/oauth/token    /oauth/check_token等
        PathMatcher pathMatcher = new AntPathMatcher();

        if(skipUrls!=null) {
            for (String skipPath : skipUrls) {
                if (pathMatcher.match(skipPath, currentUrl)) {
                    return true;
                }
            }
        }
        return false;
    }

}
