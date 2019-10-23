package com.kafkaConsumer.demoConsumer.gateway.http.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*

 - Estrutura de request de um tópico da aplicação

 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicRequest {

    public String name;
}
