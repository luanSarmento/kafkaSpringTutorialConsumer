package com.kafkaConsumer.demoConsumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
/*

 - Configuração customizada do kafka

 - Aqui você pode:

    - definir os tópicos que sua aplicação vai criar automaticamente
    - definir o numero de partitions padrão que cada tópico seu vai ter (aconselhamos usar o padrão 10)
    - Adicionar no seu método replyContainer os tópicos que recebem alguma resposta (listeners)

 */
@Configuration
public class TopicsKafkaConfig {

    @Value("${spring.kafka.topic.reply-demo}")
    private String replyDemoTopic;

    @Value("${spring.kafka.topic.request-demo}")
    private String requestDemoTopic;

    @Value("${spring.kafka.topic.request-demo-2}")
    private String requestDemo2Topic;

    @Value("${spring.kafka.topic.reply-demo-2}")
    private String replyDemo2Topic;

    @Value("${spring.kafka.binder.replication-factor}")
    private String replicationFactor;

    private int defaultPartitions = 10;

    // Listener Container to be set up in ReplyingKafkaTemplate
    @Bean
    public KafkaMessageListenerContainer<String, String> replyContainer(ConsumerFactory<String, String> cf) {
        ContainerProperties containerProperties = new ContainerProperties(replyDemoTopic);
        return new KafkaMessageListenerContainer<>(cf, containerProperties);
    }

    // Automatic Topic creation
    @Bean
    public NewTopic topic1() {
        return new NewTopic(replyDemoTopic, defaultPartitions, Short.parseShort(replicationFactor));
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic(requestDemo2Topic, defaultPartitions, Short.parseShort(replicationFactor));
    }

    @Bean
    public NewTopic topic3() {
        return new NewTopic(replyDemo2Topic, defaultPartitions, Short.parseShort(replicationFactor));
    }

    @Bean
    public NewTopic topic4() {
        return new NewTopic(requestDemoTopic, defaultPartitions, Short.parseShort(replicationFactor));
    }

}
