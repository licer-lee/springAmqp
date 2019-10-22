package com.licerlee.redis.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RabbitListener(queues = "exam")
public class ExamTask {


    @RabbitHandler
    public void receiveAndGeneratePaper(Object message){
//    public void receiveAndGeneratePaper(Message message){
        // TODO 使用Object以外的类型会报错，具体原因待调查
        if(message instanceof Message){
            message = (Message) message;
            log.warn("msg type {}", message.getClass());
            log.info("接收到{}, 开始生成试卷...", new String(((Message) message).getBody()));
        }
//

    }

}
