package com.sym.springboot.erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/7/20
 */
@RestController
@RequestMapping("kafka")
public class ProducerController {
    @Resource(name = "newKafkaTemplate")
    private KafkaTemplate<String,Object> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "send",method = RequestMethod.GET)
    public void send(){
        for (int i = 0; i < 20; i++) {
            try {
                kafkaTemplate.send("topicTest","key","第"+i+"条消息");
            } catch (Exception e) {
                e.printStackTrace();
                throw  new  RuntimeException("发送失败");
            }
            System.out.println("发送第"+i+"条消息发送成功");
            logger.info("message:{}","第"+i+"条消息成功!");
        }
    }

}
