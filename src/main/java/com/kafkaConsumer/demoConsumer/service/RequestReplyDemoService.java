package com.kafkaConsumer.demoConsumer.service;

import com.google.gson.Gson;
import com.kafkaConsumer.demoConsumer.gateway.http.json.TopicRequest;
import com.kafkaConsumer.demoConsumer.gateway.http.json.TopicResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
/*

 - Exemplo de uso de um sendTo:
    - Ideal para quando você precisa retornar algum dado para determinado método.
    - Normalmente usado em conjunto com uma requisição Síncrona de outro microservice
    - Se comporta como um "by pass"

 */
@Service
public class RequestReplyDemoService {

    @SendTo("${spring.kafka.topic.reply-demo-2}")
    @KafkaListener(topics = "${spring.kafka.topic.request-demo-2}")
    public String listenAndReply(String topicRequestJson) {

        TopicRequest topicRequest = new Gson().fromJson(topicRequestJson, TopicRequest.class);

        TopicResponse topicResponse =
                TopicResponse
                        .builder()
                        .name(topicRequest.getName() + " Secretti Sarmento | TestReplyTopic")
                        .yearsOld(29)
                        .build();

        return new Gson().toJson(topicResponse);

    }
}