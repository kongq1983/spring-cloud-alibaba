package com.kq.user.controller;

import com.kq.user.config.MyProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kq
 * @date 2021-04-17 11:25
 * @since 2020-0630
 */

@RestController
@RequestMapping("/100/account")
public class AccountController {

    private Logger log = LoggerFactory.getLogger(AccountController.class);

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping
    public String getInfo(@RequestParam("id") String id, HttpServletRequest request){

        return "account:"+id+" port="+serverPort;

    }


    @PostMapping
    public String postInfo(@RequestParam("id") String id, @RequestBody MyProperties bean, HttpServletRequest request){

        String name = request.getParameter("name");
        String mytoken = request.getHeader("mytoken");

        log.info("postInfo name={} mytoken={} bean={}",name,mytoken,bean);

        return String.format("account id=%s,name=%s,mytoken=%s port=%s",id,name,mytoken,serverPort.toString());

    }

    @PostMapping("/view")
    public String postView(@RequestParam("id") String id, @RequestBody MyProperties bean, HttpServletRequest request){

        String name = request.getParameter("name");
        String mytoken = request.getHeader("mytoken");

        log.info("postView name={} mytoken={} bean={}",name,mytoken,bean);

        return String.format("account id=%s,name=%s,mytoken=%s port=%s",id,name,mytoken,serverPort.toString());

    }


}
