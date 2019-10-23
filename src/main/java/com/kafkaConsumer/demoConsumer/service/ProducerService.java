package com.kafkaConsumer.demoConsumer.service;

import com.google.gson.Gson;
import com.kafkaConsumer.demoConsumer.gateway.http.json.TopicRequest;
import com.kafkaConsumer.demoConsumer.gateway.http.json.TopicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
/*

 - Envio de um tópico com kafka template

 */
@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.reply-demo}")
    private String replyDemo;

    public void execute(String message, TopicRequest topicRequest) {

        TopicResponse topicResponse = TopicResponse
                .builder()
                .name(topicRequest.getName() + " Sarmento")
                .yearsOld(29)
                .build();

        this.kafkaTemplate.send(replyDemo, new Gson().toJson(topicResponse));
    }
}
