package com.kq.user.loadblance;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * NacosRandomWithWeightRule
 *
 * @author kq
 * @date 2021/3/31 23:08
 * @since 1.0.0
 */
public class NacosRandomWithWeightRule extends AbstractLoadBalancerRule {

    protected static Logger logger = LoggerFactory.getLogger(NacosRandomWithWeightRule.class);

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public Server choose(Object key) {
        DynamicServerListLoadBalancer loadBalancer = (DynamicServerListLoadBalancer) getLoadBalancer();

        String serviceName = loadBalancer.getName();
        NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
        try {
            //nacos基于权重的算法
            Instance instance = namingService.selectOneHealthyInstance(serviceName);
            return new NacosServer(instance);
        } catch (NacosException e) {
            logger.error("获取服务实例异常：{}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }
}
