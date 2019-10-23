package com.kafkaConsumer.demoConsumer.gateway.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*

 - Rota de exemplo

 */
@RestController
public class StatusResource {

    @GetMapping
    public String status() {
        return "OK";
    }
}

