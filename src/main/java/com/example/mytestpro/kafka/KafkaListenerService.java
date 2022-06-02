//package com.example.mytestpro.kafka;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//import java.util.function.Consumer;
//
//@Slf4j
//@Component
//public class KafkaListenerService {
//    @org.springframework.kafka.annotation.KafkaListener(topics = {"test"},groupId = "0")
//    public void listener(ConsumerRecord<String,String> record){
//        Optional message = Optional.ofNullable(record.value());
//        if (message.isPresent()) {
//            Object msg = message.get();
//            log.info("topic  test 消费了： Message:{}" , msg);
//        }
//        log.info(record.key());
//    }
//}
