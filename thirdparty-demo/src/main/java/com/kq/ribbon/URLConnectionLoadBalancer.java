package com.kq.ribbon;

import com.google.common.collect.Lists;
import com.netflix.loadbalancer.*;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import rx.Observable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @author kq
 * @date 2021-03-31 18:37
 * @since 2020-0630
 */
public class URLConnectionLoadBalancer {

    private final ILoadBalancer loadBalancer;

    public URLConnectionLoadBalancer(List<Server> serverList) {
        loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(serverList);
    }

    //通过 LoadBalancerCommand 发送请求
    public String call(final String path) {
        return LoadBalancerCommand.<String>builder()
                .withLoadBalancer(loadBalancer)
                .build()
                .submit(server -> {
                    URL url;
                    try {
                        url = new URL("http://" + server.getHost() + ":" + server.getPort() + path);
                        System.out.println("url="+url);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                        conn.setRequestMethod("GET");
                        conn.connect();
                        InputStream in = conn.getInputStream();
                        byte[] data = new byte[in.available()];
                        in.read(data);
                        return Observable.just(new String(data));
                    } catch (Exception e) {
                        return Observable.error(e);
                    }
                }).toBlocking().first();
    }

    //获取 ILoadBalancer 状态
    public LoadBalancerStats getLoadBalancerStats() {
        return ((BaseLoadBalancer) loadBalancer).getLoadBalancerStats();
    }

    public static void main(String[] args) {
        //添加服务列表
        URLConnectionLoadBalancer urlLoadBalancer = new URLConnectionLoadBalancer(Lists.newArrayList(
                new Server("172.16.5.1", 8091),
                new Server("172.16.5.3", 8091),
                new Server("172.16.6.209", 8091),
                new Server("172.16.69.41", 8081)));

        int size = 5;
        //循环请求
        for (int i = 0; i < size; i++) {
            System.out.println(urlLoadBalancer.call("/echo/hello"));
        }
        System.out.println("=== Load balancer stats ===");
        System.out.println(urlLoadBalancer.getLoadBalancerStats());
    }
}
