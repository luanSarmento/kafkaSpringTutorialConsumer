package com.kafkaConsumer.demoConsumer.gateway.listener;

import com.google.gson.Gson;
import com.kafkaConsumer.demoConsumer.gateway.http.json.TopicRequest;
import com.kafkaConsumer.demoConsumer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
/*

 - Listener de um tópico

 */
@Service
public class ConsumerDemoListener {

    @Autowired
    private ProducerService producerService;



    @KafkaListener(topics = "${spring.kafka.topic.request-demo}")
    public void consume(String message){

        TopicRequest topicRequest = new Gson().fromJson(message, TopicRequest.class);
        this.producerService.execute(message, topicRequest);
    }
}
