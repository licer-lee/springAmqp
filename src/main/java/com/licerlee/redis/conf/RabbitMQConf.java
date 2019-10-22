package com.licerlee.redis.conf;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConf {

    @Bean("hello")
    public Queue hello(){
        return new Queue("hello", true);
    }

    @Bean("exam")
    public Queue exam(){
        return new Queue("exam", true);
    }
}
