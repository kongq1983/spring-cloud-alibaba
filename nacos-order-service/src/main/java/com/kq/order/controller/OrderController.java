package com.kq.order.controller;

import com.kq.order.entity.Order;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kq
 * @date 2021-04-17 14:27
 * @since 2020-0630
 */

@RestController
@RequestMapping("/101/order")
public class OrderController {

    @GetMapping
    public String getInfo(@RequestParam("id") String id, HttpServletRequest request){

        return "Get Order:"+id;

    }


    @PostMapping
    public String postInfo(@RequestParam("id") String id, HttpServletRequest request){

        String name = request.getParameter("name");
        String mytoken = request.getHeader("mytoken");

        return String.format("Post Order id=%s,name=%s,mytoken=%s",id,name,mytoken);

    }

    @PutMapping
    public String putInfo(@RequestBody Order order, HttpServletRequest request){

        String mytoken = request.getHeader("mytoken");

        return String.format("Put Order id=%s,name=%s,mytoken=%s",order.getId(),order.getName(),mytoken);

    }


}
