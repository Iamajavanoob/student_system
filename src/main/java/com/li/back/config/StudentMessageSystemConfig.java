package com.li.back.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StudentMessageSystemConfig {
    public static final String STUDENT_QUEUE = "studentQueue";
    public static final String STUDENT_EXCHANGE = "studentExchange";
    public static final String STUDENT_ROUTING_KEY = "studentTopic";
    @Bean
    ObjectMapper objectMapper (){
        return new ObjectMapper();
    }

//    @Bean
//    Queue studentQueue(){ return new Queue(STUDENT_QUEUE,true);}
//
//    @Bean
//    Exchange studentExchange() {
//        return ExchangeBuilder.topicExchange(STUDENT_EXCHANGE)
//                .durable(true)
//                .build();
//    }
//
//    @Bean
//    Binding binding(){
//        return BindingBuilder
//                .bind(studentQueue())
//                .to(studentExchange())
//                .with(STUDENT_ROUTING_KEY)
//                .noargs();
//    }
//
//    @Bean
//    CachingConnectionFactory connectionFactory(){
//        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
//        cachingConnectionFactory.setUsername("guest");
//        cachingConnectionFactory.setPassword("guest");
//        return cachingConnectionFactory;
//    }
}

