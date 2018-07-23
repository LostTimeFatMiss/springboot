package com.sym.springboot.erp.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/7/20
 */
@Component
public class ConsumerController {
    @KafkaListener(topics = "topicTest")
    public void listen (ConsumerRecord<?, ?> record) throws Exception {
        /*if(records!=null && !records.isEmpty()){
            for (ConsumerRecord<?, ?> record : records) {
                System.out.println("-------------------------------------------");
                System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
                System.out.println("-------------------------------------------");
                System.out.println("-------------------------------------------");
                System.out.println("-------------------------------------------");
            }
        }*/

        System.out.println("-------------------------------------------");
        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
        System.out.println("-------------------------------------------");
        System.out.println("-------------------------------------------");
        System.out.println("-------------------------------------------");
    }
}
