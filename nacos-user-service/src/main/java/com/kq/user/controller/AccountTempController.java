package com.kq.user.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kq
 * @date 2021-04-17 11:25
 * @since 2020-0630
 */
@RestController
@RequestMapping("/account/info")
public class AccountTempController {

    @GetMapping
    public String getInfo(@RequestParam("id") String id, HttpServletRequest request){

        return id;

    }


    @PostMapping
    public String postInfo(@RequestParam("id") String id, HttpServletRequest request){

        String name = request.getParameter("name");
        String mytoken = request.getHeader("mytoken");

        return String.format("id=%s,name=%s,mytoken=%s",id,name,mytoken);

    }


}
