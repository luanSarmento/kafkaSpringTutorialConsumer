package com.kafkaConsumer.demoConsumer.gateway.http.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*

 - Estrutura de response de um tópico da aplicação

 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicResponse {

    public Integer yearsOld;
    public String name;

}
