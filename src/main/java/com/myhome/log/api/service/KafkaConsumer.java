package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogReceiveDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumer {
    // light(iot), reserve(iot), cloud, fileCheck(cloud)
    void consumeLight(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception;
    void consumeReserve(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception;
    void consumeCloud(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception;
    void consumeFileCheck(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception;
}
