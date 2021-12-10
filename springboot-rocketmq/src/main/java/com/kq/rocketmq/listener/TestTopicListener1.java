package com.kq.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author kq
 * @date 2021-12-10 8:48
 * @since 2020-0630
 */
@Service
@RocketMQMessageListener(topic = "QuickOrder", consumerGroup = "QuickOrderGroup",selectorExpression="TagC")
public class TestTopicListener1  implements RocketMQListener<String> {

    protected Logger logger = LoggerFactory.getLogger(TestTopicListener1.class);


    @Override
    public void onMessage(String message) {
        System.out.println("TestTopicListener1 receive message =" +message);
        logger.info("TestTopicListener1 receive message ={}", message);
    }

}
