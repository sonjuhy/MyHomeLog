package com.myhome.log.api.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumer {
    // light(iot), reserve(iot), cloud, fileCheck(cloud)
    void consumeLight(ConsumerRecord<String, String> consumerRecord) throws Exception;
    void consumeReserve(ConsumerRecord<String, String> consumerRecord) throws Exception;
    void consumeCloud(ConsumerRecord<String, String> consumerRecord) throws Exception;
    void consumeFileCheck(ConsumerRecord<String, String> consumerRecord) throws Exception;
}
