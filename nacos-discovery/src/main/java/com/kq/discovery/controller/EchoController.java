package com.kq.discovery.controller;

import com.kq.dto.DtoResult;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kq
 * @date 2021-01-28 9:08
 * @since 2020-0630
 */

@RestController
public class EchoController {

    @Value("${server.port}")
    private Integer port;

    private AtomicInteger atomicInteger = new AtomicInteger();
    ThreadLocalRandom random = ThreadLocalRandom.current();

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string, HttpServletRequest request) {
        String str = atomicInteger.incrementAndGet()+",EchoController.echo port=%d string=%s server=%s";
        System.out.println("EchoController echo is called. "+atomicInteger.get() +", string="+string);

        int num = NumberUtils.toInt(string,0);
        if((atomicInteger.get()%1000)==0) { // 休息
            System.out.println("echo is sleep. -------------------------");
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(10));
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        String server = request.getLocalAddr();

        return String.format(str,port,string,server);
    }

    @GetMapping(value = "/feign/string/{string}")
    public DtoResult print(@PathVariable String string, HttpServletRequest request) {
        String str = atomicInteger.incrementAndGet()+",EchoController.echo port=%d string=%s server=%s";
        System.out.println("EchoController echo is called. "+atomicInteger.get());

        String server = request.getLocalAddr();

        DtoResult result = new DtoResult();
        result.setSuccess(true);
        result.setData(String.format(str,port,string,server));


        return result;
    }
}