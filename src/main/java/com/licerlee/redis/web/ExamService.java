package com.licerlee.redis.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ExamService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Qualifier("exam")
    @Autowired
    Queue queue;


    public String fetchAndPush2MQ(String userid, String examId){
        // 如果已抽过题就不要再抽了
        Map map = new HashMap();
        map.put("userid", userid);
        map.put("examId", examId);

        Message message = MessageBuilder
                .withBody(userid.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .build();

        rabbitTemplate.convertAndSend(queue.getName(), message);
        log.info("考生 {} 已参加 {} 的考试...", userid, examId);
        return "正在生成试卷,请稍后刷新页面查看...";
    }

}
