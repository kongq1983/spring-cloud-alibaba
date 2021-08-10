package com.kq.sentinel.exceptionhandler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kq
 * @date 2021-08-10 19:04
 * @since 2020-0630
 */
@Slf4j
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        log.info("BlockExceptionHandler BlockException================"+e.getRule());

//        R r = null;

        Map<String,Object> map = new HashMap<>();
        if (e instanceof FlowException) {
//            r = R.error(100,"接口限流了");
            map.put("code",100);
            map.put("msg","接口限流了");

        } else if (e instanceof DegradeException) {
//            r = R.error(101,"服务降级了");
            map.put("code",101);
            map.put("msg","服务降级了");

        } else if (e instanceof ParamFlowException) {
//            r = R.error(102,"热点参数限流了");
            map.put("code",102);
            map.put("msg","热点参数限流了");

        } else if (e instanceof SystemBlockException) {
//            r = R.error(103,"触发系统保护规则了");
            map.put("code",103);
            map.put("msg","触发系统保护规则了");

        } else if (e instanceof AuthorityException) {
//            r = R.error(104,"授权规则不通过");
//            map.put("104","授权规则不通过");
            map.put("code",104);
            map.put("msg","授权规则不通过");
        }

        //返回json数据
        response.setStatus(500);
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getWriter(), map);

    }
}
